package com.pi.medsync.service;

import com.pi.medsync.model.Usuario;
import com.pi.medsync.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Value("${jwt.secret}")
    private String SECRET_KEY;  // Chave secreta para assinar o JWT (configurada no application.properties)

    // Método para criptografar a senha usando SHA-256
    private String criptografarSenha(String senha) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = messageDigest.digest(senha.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString(); // Retorna a senha criptografada
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar a senha", e);
        }
    }

    public String autenticar(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null && compararSenha(senha, usuario.getSenha())) {
            return gerarToken(usuario);
        }
        return null; // Retorna null se a autenticação falhar
    }

    private boolean compararSenha(String senhaInformada, String senhaCriptografada) {
        // Compara a senha informada com a criptografada
        String senhaCriptografadaInformada = criptografarSenha(senhaInformada);
        return senhaCriptografada.equals(senhaCriptografadaInformada);
    }

    private String gerarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))  // Expira em 1 dia
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}

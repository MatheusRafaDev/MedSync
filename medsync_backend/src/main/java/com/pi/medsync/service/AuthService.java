package com.pi.medsync.service;

import com.pi.medsync.model.Usuario;
import com.pi.medsync.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;


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

        return "Login inválido";
    }

    private boolean compararSenha(String senhaInformada, String senhaCriptografada) {
        String senhaCriptografadaInformada = criptografarSenha(senhaInformada);
        return senhaCriptografada.equals(senhaCriptografadaInformada);
    }
}

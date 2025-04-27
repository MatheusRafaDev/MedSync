package com.pi.medsync.service;

import com.pi.medsync.model.Paciente;
import com.pi.medsync.model.PacienteDTO;
import com.pi.medsync.model.Usuario;
import com.pi.medsync.repository.PacienteRepository;
import com.pi.medsync.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class PacienteService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;


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

    public Paciente criarPacienteComUsuario(PacienteDTO pacienteDTO) {
        // Cria o novo usuário
        Usuario usuario = new Usuario();
        usuario.setNome(pacienteDTO.getUsuarioNome());
        usuario.setEmail(pacienteDTO.getUsuarioEmail());

        // Criptografa a senha antes de salvar com SHA-256
        String senhaCriptografada = criptografarSenha(pacienteDTO.getUsuarioSenha());

        System.out.println(senhaCriptografada);

        usuario.setSenha(senhaCriptografada);

        usuario.setTipo("Paciente");
        usuarioRepository.save(usuario);

        Paciente paciente = new Paciente();
        paciente.setNascimento(pacienteDTO.getNascimento());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setRg(pacienteDTO.getRg());
        paciente.setUsuario(usuario);

        return pacienteRepository.save(paciente);
    }
}

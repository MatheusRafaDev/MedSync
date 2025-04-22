package com.pi.medsync.service;

import com.pi.medsync.model.Paciente;
import com.pi.medsync.model.PacienteDTO;
import com.pi.medsync.model.Usuario;
import com.pi.medsync.repository.PacienteRepository;
import com.pi.medsync.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente criarPacienteComUsuario(PacienteDTO pacienteDTO) {
        // Cria o novo usuário
        Usuario usuario = new Usuario();
        usuario.setNome(pacienteDTO.getUsuarioNome());
        usuario.setEmail(pacienteDTO.getUsuarioEmail());
        usuario.setSenha(pacienteDTO.getUsuarioSenha());
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

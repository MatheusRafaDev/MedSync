package com.pi.medsync.service;

import com.pi.medsync.model.Paciente;
import com.pi.medsync.model.Usuario;
import com.pi.medsync.repository.PacienteRepository;
import com.pi.medsync.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private static PacienteRepository pacienteRepository;

    @Autowired
    private static UsuarioRepository usuarioRepository;

    public static Paciente salvarPaciente(Paciente paciente) {
        if (paciente.getUsuario() == null || paciente.getUsuario().getId() == null) {
            throw new RuntimeException("O id do usuário não pode ser nulo");
        }

        Usuario usuario = paciente.getUsuario();
        if (!usuarioRepository.existsById(usuario.getId())) {
            throw new RuntimeException("Usuário não encontrado");
        }

        // Salve o paciente se tudo estiver correto
        return pacienteRepository.save(paciente);
    }

}

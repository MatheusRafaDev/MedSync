package com.pi.medsync.service;

import com.pi.medsync.model.Prontuario;
import com.pi.medsync.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository repository;

    public List<Prontuario> listarPorPaciente(Long idPaciente) {
        return repository.findByPacienteId(idPaciente);
    }

    public Prontuario salvar(Prontuario prontuario) {
        prontuario.setDtRegistro(LocalDateTime.now());
        return repository.save(prontuario);
    }
}

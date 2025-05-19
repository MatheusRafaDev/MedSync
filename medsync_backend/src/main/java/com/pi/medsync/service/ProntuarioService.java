package com.pi.medsync.service;

import com.pi.medsync.model.Prontuario;
import com.pi.medsync.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository repository;

    public List<Prontuario> listarPorPaciente(Long idPaciente) {
        return repository.findByPacienteIdPaciente(idPaciente);
    }

    public Prontuario salvar(Prontuario prontuario) {
        prontuario.setDtRegistro(LocalDateTime.now());
        return repository.save(prontuario);
    }

    public List<Prontuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Prontuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

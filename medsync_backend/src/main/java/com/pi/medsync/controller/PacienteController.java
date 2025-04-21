package com.pi.medsync.controller;

import com.pi.medsync.model.Paciente;
import com.pi.medsync.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Endpoint para criar um novo paciente
    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        try {
            Paciente novoPaciente = pacienteRepository.save(paciente);
            return ResponseEntity.ok(novoPaciente);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Endpoint para listar todos os pacientes
    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    // Endpoint para obter um paciente específico
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para atualizar os dados de um paciente
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente pacienteDetails) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);

        if (paciente.isPresent()) {
            Paciente pacienteExistente = paciente.get();
            pacienteExistente.setNascimento(pacienteDetails.getNascimento());
            pacienteExistente.setTelefone(pacienteDetails.getTelefone());
            pacienteExistente.setRg(pacienteDetails.getRg());
            pacienteExistente.setUsuario(pacienteDetails.getUsuario());  // Atualiza o usuário, caso necessário

            Paciente updatedPaciente = pacienteRepository.save(pacienteExistente);
            return ResponseEntity.ok(updatedPaciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para excluir um paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);

        if (paciente.isPresent()) {
            pacienteRepository.delete(paciente.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

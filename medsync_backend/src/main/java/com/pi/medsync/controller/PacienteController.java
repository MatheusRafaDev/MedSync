package com.pi.medsync.controller;

import com.pi.medsync.model.Paciente;
import com.pi.medsync.service.PacienteService;
import com.pi.medsync.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody Paciente paciente) {
        Paciente criado = pacienteService.criarPaciente(paciente);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    // Obter um paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar um paciente
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente pacienteDetails) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);

        if (paciente.isPresent()) {
            Paciente pacienteExistente = paciente.get();
            pacienteExistente.setNome(pacienteDetails.getNome());
            pacienteExistente.setCpf(pacienteDetails.getCpf());
            pacienteExistente.setNascimento(pacienteDetails.getNascimento());
            pacienteExistente.setTelefone(pacienteDetails.getTelefone());
            pacienteExistente.setEndereco(pacienteDetails.getEndereco());
            pacienteExistente.setPlanoSaude(pacienteDetails.getPlanoSaude());

            Paciente updatedPaciente = pacienteRepository.save(pacienteExistente);
            return ResponseEntity.ok(updatedPaciente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Excluir um paciente
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

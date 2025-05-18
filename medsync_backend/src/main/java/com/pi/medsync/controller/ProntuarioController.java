package com.pi.medsync.controller;

import com.pi.medsync.model.Prontuario;
import com.pi.medsync.service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService service;

    // por paciente
    @GetMapping("/paciente/{id}")
    public List<Prontuario> listarPorPaciente(@PathVariable Long id) {
        return service.listarPorPaciente(id);
    }

    // para criar
    @PostMapping
    public Prontuario salvar(@RequestBody Prontuario prontuario) {
        return service.salvar(prontuario);
    }

    // tudo
    @GetMapping
    public List<Prontuario> listarTodos() {
        return service.listarTodos();
    }

    // por id
    @GetMapping("/{id}")
    public ResponseEntity<Prontuario> buscarPorId(@PathVariable Long id) {
        Optional<Prontuario> prontuario = service.buscarPorId(id);
        return prontuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // apaga registro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

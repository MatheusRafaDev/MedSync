package com.pi.medsync.controller;

import com.pi.medsync.model.Prontuario;
import com.pi.medsync.service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService service;

    @GetMapping("/paciente/{id}")
    public List<Prontuario> listarPorPaciente(@PathVariable Long id) {
        return service.listarPorPaciente(id);
    }

    @PostMapping
    public Prontuario salvar(@RequestBody Prontuario prontuario) {
        return service.salvar(prontuario);
    }
}

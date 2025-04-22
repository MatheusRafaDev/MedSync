package com.pi.medsync.controller;

import com.pi.medsync.model.Paciente;
import com.pi.medsync.model.PacienteDTO;
import com.pi.medsync.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pi.medsync.service.PacienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente(@RequestBody PacienteDTO pacienteDTO) {

        Paciente pacienteCriado = pacienteService.criarPacienteComUsuario(pacienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteCriado);
    }
}

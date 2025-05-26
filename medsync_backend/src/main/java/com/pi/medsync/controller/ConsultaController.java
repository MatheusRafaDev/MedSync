package com.pi.medsync.controller;


import com.pi.medsync.model.Consulta;
import com.pi.medsync.model.Medico;
import com.pi.medsync.model.Paciente;
import com.pi.medsync.repository.ConsultaRepository;
import com.pi.medsync.service.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


@RestController
@RequestMapping("/api/consulta")
@CrossOrigin(origins = "*")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/{paciente}")
    public Optional<Consulta> buscarPorPaciente(@PathVariable Paciente paciente) {
        return Optional.ofNullable(consultaRepository.findByPaciente(paciente));
    }

    @GetMapping("/{medico}")
    public Optional<Consulta> buscarPorMedico(@PathVariable Medico medico) {
        return Optional.ofNullable(consultaRepository.findByMedico(medico));
    }

    @GetMapping("/{dtConsulta}")
    public Optional<Consulta> buscarPorPaciente(@PathVariable String dtConsulta) {
        return Optional.ofNullable(consultaRepository.findByDtCosulta(dtConsulta));
    }

    @PostMapping
    public ResponseEntity<Consulta> criarUsuario(@RequestBody Consulta consulta) {
        Consulta consultaCriada = consultaService.criarConsulta(consulta);
        return new ResponseEntity<>(consultaCriada, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{status}")
    public Consulta atualizar(@PathVariable String status, @RequestBody Consulta consulta) {
        consulta.setDsStatus(status);
        return consultaRepository.save(consulta);
    }
}

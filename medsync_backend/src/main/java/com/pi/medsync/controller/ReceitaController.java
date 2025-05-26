package com.pi.medsync.controller;

import com.pi.medsync.model.Medico;
import com.pi.medsync.model.Paciente;
import com.pi.medsync.model.Receita;
import com.pi.medsync.repository.ReceitaRepository;
import com.pi.medsync.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/receita")
@CrossOrigin(origins = "*")// Prefixo comum para as rotas da controller
public class ReceitaController {

    @Autowired
    private ReceitaRepository receitaRepository;
    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/{paciente}")
    public Optional<Receita> buscarPorPaciente(@PathVariable Paciente paciente) {
        return Optional.ofNullable(receitaRepository.findByPaciente(paciente));
    }

    @GetMapping("/{medico}")
    public Optional<Receita> buscarPorMedico(@PathVariable Medico medico) {
        return Optional.ofNullable(receitaRepository.findByMedico(medico));
    }

    @PostMapping
    public ResponseEntity<Receita> criarReceita(@RequestBody Receita receita) {
        Receita receitaCriada = receitaService.criarReceita(receita);
        return new ResponseEntity<>(receitaCriada, HttpStatus.CREATED);
    }
}

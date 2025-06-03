package com.pi.medsync.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receitas") // Prefixo comum para as rotas da controller
public class ReceitasController {

    @GetMapping("/pacientes")
    public String telaListarPacientes() {
        return "listar-pacientes";
    }

    @GetMapping("/medicos")
    public String telaListarMedicos() {
        return "listar-medicos";
    }
}

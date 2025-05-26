package com.pi.medsync.service;

import com.pi.medsync.model.Receita;
import com.pi.medsync.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita criarReceita(Receita receita) {
        return receitaRepository.save(receita);
    }
}

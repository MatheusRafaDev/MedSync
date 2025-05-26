package com.pi.medsync.service;

import com.pi.medsync.model.Consulta;
import com.pi.medsync.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta criarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }
}

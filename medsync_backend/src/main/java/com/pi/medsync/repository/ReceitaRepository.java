package com.pi.medsync.repository;

import com.pi.medsync.model.Medico;
import com.pi.medsync.model.Paciente;
import com.pi.medsync.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    Receita findByPaciente(Paciente paciente);
    Receita findByMedico(Medico medico);
}

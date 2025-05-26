package com.pi.medsync.repository;

import com.pi.medsync.model.Consulta;
import com.pi.medsync.model.Medico;
import com.pi.medsync.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Consulta findByPaciente(Paciente paciente);
    Consulta findByMedico(Medico medico);
    Consulta findByDtCosulta(String dtConsulta);
}

package com.pi.medsync.repository;

import com.pi.medsync.model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
    List<Prontuario> findByPacienteId (Long idPaciente);
}

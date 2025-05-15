
package com.pi.medsync.repository;

import com.pi.medsync.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Métodos adicionais de consulta podem ser definidos aqui, se necessário
}

package com.pi.medsync.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;

    @ManyToOne
    @JoinColumn(name = "fk_medico", referencedColumnName = "pk_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "fk_paciente", referencedColumnName = "pk_id")
    private Paciente paciente;

    private LocalDateTime hora;
    private String status;  // 'confirmada', 'realizada', 'faltou', 'cancelada'

    // Getters and Setters
}

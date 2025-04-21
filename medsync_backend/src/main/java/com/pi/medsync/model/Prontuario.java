package com.pi.medsync.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;

    @ManyToOne
    @JoinColumn(name = "fk_consulta", referencedColumnName = "pk_id")
    private Consulta consulta;

    private String diagnostico;
    private String receita;
    private String exames;
    private Timestamp criacao;

    // Getters and Setters
}

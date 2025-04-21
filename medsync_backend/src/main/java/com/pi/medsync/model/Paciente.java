package com.pi.medsync.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "pk_id")
    private Usuario usuario;

    private Date nascimento;
    private String telefone;
    private String rg;

    // Getters and Setters
}

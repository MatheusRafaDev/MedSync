package com.pi.medsync.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "pk_id")
    private Usuario usuario;

    private String crm;
    private String especialidade;

    // Getters and Setters
}

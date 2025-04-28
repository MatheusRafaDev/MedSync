package com.pi.medsync.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_RECEITAS")
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceita;

    @ManyToOne
    @JoinColumn(name = "ID_CONSULTA", nullable = false)
    private Consulta consulta;

    @Column(name = "DS_MEDICAMENTOS", nullable = false, columnDefinition = "TEXT")
    private String dsMedicamentos;

    @Column(name = "DS_ORIENTACOES", columnDefinition = "TEXT")
    private String dsOrientacoes;

    @Column(name = "DT_EMISSAO", nullable = false)
    private LocalDateTime dtEmissao;

    public Receita() {}

    public Receita(Long idReceita, Consulta consulta, String dsMedicamentos, String dsOrientacoes, LocalDateTime dtEmissao) {
        this.idReceita = idReceita;
        this.consulta = consulta;
        this.dsMedicamentos = dsMedicamentos;
        this.dsOrientacoes = dsOrientacoes;
        this.dtEmissao = dtEmissao;
    }

}

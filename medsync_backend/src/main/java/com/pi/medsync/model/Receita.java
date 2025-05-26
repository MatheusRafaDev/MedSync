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

    public Long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(Long idReceita) {
        this.idReceita = idReceita;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getDsMedicamentos() {
        return dsMedicamentos;
    }

    public void setDsMedicamentos(String dsMedicamentos) {
        this.dsMedicamentos = dsMedicamentos;
    }

    public String getDsOrientacoes() {
        return dsOrientacoes;
    }

    public void setDsOrientacoes(String dsOrientacoes) {
        this.dsOrientacoes = dsOrientacoes;
    }

    public LocalDateTime getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(LocalDateTime dtEmissao) {
        this.dtEmissao = dtEmissao;
    }
}

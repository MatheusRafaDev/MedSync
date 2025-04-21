package com.pi.medsync.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Long pkId;

    @OneToOne
    @JoinColumn(name = "fk_consulta", nullable = false)
    private Consulta consulta;

    @Column(name = "ds_diagnostico")
    private String diagnostico;

    @Column(name = "ds_receita")
    private String receita;

    @Column(name = "ds_exames")
    private String exames;

    @Column(name = "dt_criacao", nullable = false)
    private LocalDateTime criacao;

    // Getters and Setters
    public Long getPkId() {
        return pkId;
    }
    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }
    public Consulta getConsulta() {
        return consulta;
    }
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getReceita() {
        return receita;
    }
    public void setReceita(String receita) {
        this.receita = receita;
    }
    public String getExames() {
        return exames;
    }
    public void setExames(String exames) {
        this.exames = exames;
    }
    public LocalDateTime getCriacao() {
        return criacao;
    }
    public void setCriacao(LocalDateTime criacao) {
        this.criacao = criacao;
    }
}

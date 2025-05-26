package com.pi.medsync.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CONSULTAS")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsulta;

    @ManyToOne
    @JoinColumn(name = "ID_PACIENTE", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "ID_MEDICO", nullable = false)
    private Medico medico;

    @Column(name = "DT_CONSULTA", nullable = false)
    private LocalDateTime dtConsulta;

    @Column(name = "DS_STATUS", nullable = false, length = 20)
    private String dsStatus;

    @Column(name = "DS_OBSERVACOES", columnDefinition = "TEXT")
    private String dsObservacoes;

    public Consulta() {}

    public Consulta(Long idConsulta, Paciente paciente, Medico medico, LocalDateTime dtConsulta, String dsStatus, String dsObservacoes) {
        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.dtConsulta = dtConsulta;
        this.dsStatus = dsStatus;
        this.dsObservacoes = dsObservacoes;
    }

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(LocalDateTime dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public String getDsStatus() {
        return dsStatus;
    }

    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus;
    }

    public String getDsObservacoes() {
        return dsObservacoes;
    }

    public void setDsObservacoes(String dsObservacoes) {
        this.dsObservacoes = dsObservacoes;
    }
}

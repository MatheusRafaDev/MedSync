package com.pi.medsync.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Long pkId;

    @ManyToOne
    @JoinColumn(name = "fk_medico", nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "fk_paciente", nullable = false)
    private Paciente paciente;

    @Column(name = "dt_hora", nullable = false)
    private LocalDateTime hora;

    @Column(name = "ds_status", nullable = false)
    private String status;

    // Getters and Setters
    public Long getPkId() {
        return pkId;
    }
    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public LocalDateTime getHora() {
        return hora;
    }
    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}


package com.pi.medsync.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PRONTUARIOS")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProntuario;

    @ManyToOne
    @JoinColumn(name = "ID_PACIENTE", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "ID_MEDICO", nullable = false)
    private Medico medico;

    @Column(name = "DT_REGISTRO", nullable = false)
    private LocalDateTime dtRegistro;

    @Column(name = "DS_DESCRICAO", columnDefinition = "TEXT")
    private String dsDescricao;

    public Prontuario() {}

    public Prontuario(Long idProntuario, Paciente paciente, Medico medico, LocalDateTime dtRegistro, String dsDescricao) {
        this.idProntuario = idProntuario;
        this.paciente = paciente;
        this.medico = medico;
        this.dtRegistro = dtRegistro;
        this.dsDescricao = dsDescricao;
    }
}

package com.pi.medsync.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_MEDICOS")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;

    @Column(name = "DS_NOME", nullable = false, length = 100)
    private String dsNome;

    @Column(name = "DS_ESPECIALIDADE", nullable = false, length = 100)
    private String dsEspecialidade;

    @Column(name = "DS_CRM", nullable = false, unique = true, length = 20)
    private String dsCrm;

    public Medico() {}

    public Medico(Long idMedico, String dsNome, String dsEspecialidade, String dsCrm) {
        this.idMedico = idMedico;
        this.dsNome = dsNome;
        this.dsEspecialidade = dsEspecialidade;
        this.dsCrm = dsCrm;
    }


}

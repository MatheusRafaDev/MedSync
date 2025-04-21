package com.pi.medsync.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Long pkId;

    @OneToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @Column(name = "ds_crm", nullable = false)
    private String crm;

    @Column(name = "ds_especialidade", nullable = false)
    private String especialidade;

    // Getters and Setters
    public Long getPkId() {
        return pkId;
    }
    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
package com.pi.medsync.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private Long pkId;

    @OneToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @Column(name = "dt_nascimento")
    private LocalDateTime nascimento;

    @Column(name = "ds_telefone")
    private String telefone;

    @Column(name = "ds_rg")
    private String rg;

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
    public LocalDateTime getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDateTime nascimento) {
        this.nascimento = nascimento;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
}

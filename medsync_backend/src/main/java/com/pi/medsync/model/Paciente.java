package com.pi.medsync.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_PACIENTES")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;

    @Column(name = "ds_nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "ds_cpf", nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(name = "dt_nascimento", nullable = false)
    private LocalDate nascimento;

    @Column(name = "ds_telefone", length = 20)
    private String telefone;

    @Column(name = "ds_endereco", columnDefinition = "TEXT")
    private String endereco;

    @Column(name = "ds_plano_saude", length = 50)
    private String planoSaude;

    // Construtor padrão
    public Paciente() {}

    // Construtor com campos
    public Paciente(Long id, String nome, String cpf, LocalDate nascimento, String telefone, String endereco, String planoSaude) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.planoSaude = planoSaude;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }
}

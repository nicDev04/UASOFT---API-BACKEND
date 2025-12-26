package com.nicolas.uasoft.dtos.requisicao;

import java.time.LocalDate;

public class requisicaoPetDTO {
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
    private Long especieId;
    private Long racaId;
    private Long clienteId;

    public requisicaoPetDTO() {
    }

    public requisicaoPetDTO(String nome, String sexo, LocalDate dataNascimento, Long especieId, Long racaId, Long clienteId) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.especieId = especieId;
        this.racaId = racaId;
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getEspecieId() {
        return especieId;
    }

    public void setEspecieId(Long especieId) {
        this.especieId = especieId;
    }

    public Long getRacaId() {
        return racaId;
    }

    public void setRacaId(Long racaId) {
        this.racaId = racaId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    
    
}

package com.nicolas.uasoft.dtos.resposta;

import java.time.LocalDate;

public class respostaConsultaDTO {
    private long idConsulta;
    private String nomeCliente;
    private String nomePet;
    private String nomeFuncionario;
    private LocalDate dataConsulta;
    private double valorConsulta;
    private double valorMedicamentos;
    private String observacoes;

    public respostaConsultaDTO() {
    }

    public respostaConsultaDTO(long idConsulta, String nomeCliente, String nomePet, String nomeFuncionario, LocalDate dataConsulta, double valorConsulta, double valorMedicamentos, String observacoes) {
        this.idConsulta = idConsulta;
        this.nomeCliente = nomeCliente;
        this.nomePet = nomePet;
        this.nomeFuncionario = nomeFuncionario;
        this.dataConsulta = dataConsulta;
        this.valorConsulta = valorConsulta;
        this.valorMedicamentos = valorMedicamentos;
        this.observacoes = observacoes;
    }

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public double getValorMedicamentos() {
        return valorMedicamentos;
    }

    public void setValorMedicamentos(double valorMedicamentos) {
        this.valorMedicamentos = valorMedicamentos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}

package com.nicolas.uasoft.dtos.requisicao;

public class requisicaoConsultaDTO {
    private Long idCliente;
    private Long idPet;
    private Long idFuncionario;
    private double valorConsulta;
    private double valorMedicamentos;
    private String observacoes;

    public requisicaoConsultaDTO() {
    }

    public requisicaoConsultaDTO(Long idCliente, Long idPet, Long idFuncionario, double valorConsulta, double valorMedicamentos, String observacoes) {
        this.idCliente = idCliente;
        this.idPet = idPet;
        this.idFuncionario = idFuncionario;
        this.valorConsulta = valorConsulta;
        this.valorMedicamentos = valorMedicamentos;
        this.observacoes = observacoes;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdPet() {
        return idPet;
    }

    public void setIdPet(Long idPet) {
        this.idPet = idPet;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
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

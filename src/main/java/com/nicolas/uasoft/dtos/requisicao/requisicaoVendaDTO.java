package com.nicolas.uasoft.dtos.requisicao;

public class requisicaoVendaDTO {
    private Long idTutor;
    private Long idProduto;
    private int qtdProduto;
    private Double totalVenda;

    public requisicaoVendaDTO(Long idTutor, Long idProduto, int qtdProduto, Double totalVenda) {
        this.idTutor = idTutor;
        this.idProduto = idProduto;
        this.qtdProduto = qtdProduto;
        this.totalVenda = totalVenda;
    }

    public requisicaoVendaDTO() {
    }

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }
}

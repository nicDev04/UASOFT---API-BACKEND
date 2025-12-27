package com.nicolas.uasoft.dtos.resposta;

import java.time.LocalDate;

public class respostaVendaDTO {
    private Long id;
    private String tutor;
    private String  produto;
    private int qtdProduto;
    private Double totalVenda;
    private LocalDate dataVenda;

    public respostaVendaDTO() {
    }

    public respostaVendaDTO(long idVenda, String nomeC, String nomeProd, int qtdProduto,double totalVenda, LocalDate dataVenda) {
        this.id = idVenda;
        this.tutor = nomeC;
        this.produto = nomeProd;
        this.qtdProduto = qtdProduto;
        this.totalVenda = totalVenda;
        this.dataVenda = dataVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
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

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
}

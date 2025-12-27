package com.nicolas.uasoft.dtos.resposta;

public class respostaProdutoDTO {
    private Long id;
    private String nome;
    private String marca;
    private String grupo;
    private String descricao;
    private String unVenda;
    private Double valorProd;

    public respostaProdutoDTO(Long id, String nome, String marca, String grupo, String descricao, String unVenda, Double valorProd) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.grupo = grupo;
        this.descricao = descricao;
        this.unVenda = unVenda;
        this.valorProd = valorProd;
    }

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnVenda() {
        return unVenda;
    }

    public void setUnVenda(String unVenda) {
        this.unVenda = unVenda;
    }

    public Double getValorProd() {
        return valorProd;
    }

    public void setValorProd(Double valorProd) {
        this.valorProd = valorProd;
    }
}

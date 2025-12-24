package com.nicolas.uasoft_refatoracao.dtos.requisicao;

public class requisicaoProdutoDTO {

    private String nome;
    private String descricao;
    private String unVenda;
    private Double valor;
    private Long grupoId;
    private Long marcaId;

    public requisicaoProdutoDTO(String nome, String descricao, String unVenda, Double valor, Long grupoId, Long marcaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.unVenda = unVenda;
        this.valor = valor;
        this.grupoId = grupoId;
        this.marcaId = marcaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }

    

}

package com.nicolas.uasoft_refatoracao.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbProduto")

public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduto;
    
    @Column(name = "nomeProd")
    private String nomeProd;
    
    @Column(name = "unVenda")
    private String unVenda;

    @Column(name = "valorProd")
    private double valorProd;
    
    @Column(name = "descricaoProd")
    private String descricaoProd;
    
    @ManyToOne
    @JoinColumn(name = "marca_id", unique = true)
    private Marca marca;
    
    @ManyToOne
    @JoinColumn(name = "grupo_id", unique = true)
    private Grupo grupo;

    public Produto() {
    }

    public Produto(String nomeProd, String unVenda, double valorProd, String descricaoProd) {
        this.nomeProd = nomeProd;
        this.unVenda = unVenda;
        this.valorProd = valorProd;
        this.descricaoProd = descricaoProd;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getUnVenda() {
        return unVenda;
    }

    public void setUnVenda(String unVenda) {
        this.unVenda = unVenda;
    }

    public double getValorProd() {
        return valorProd;
    }

    public void setValorProd(double valorProd) {
        this.valorProd = valorProd;
    }

    public String getDescricaoProd() {
        return descricaoProd;
    }

    public void setDescricaoProd(String descricaoProd) {
        this.descricaoProd = descricaoProd;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}

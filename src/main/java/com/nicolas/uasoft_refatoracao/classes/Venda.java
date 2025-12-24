package com.nicolas.uasoft_refatoracao.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tbVenda")

public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVenda;
    
    @Column(name = "dataVenda")
    private LocalDate dataVenda;
    
    @Column(name = "qtdProduto")
    private int qtdProduto;
    
    @Column(name = "totalVenda")
    private double totalVenda;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id", unique = true)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "produto_id", unique = true)
    private Produto produto;

    public Venda() {
    }

    public Venda(LocalDate dataVenda, int qtdProduto, double totalVenda, Cliente cliente, Produto produto) {
        this.dataVenda = dataVenda;
        this.qtdProduto = qtdProduto;
        this.totalVenda = totalVenda;
        this.cliente = cliente;
        this.produto = produto;
    }

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}

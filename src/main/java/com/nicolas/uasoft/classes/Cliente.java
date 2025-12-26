package com.nicolas.uasoft.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbCliente")

public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(name = "nomeC") 
    private String nomeC;

    @Column(name = "cpfC")
    private String cpfC;

    @Column(name = "sexoC")
    private String sexoC;

    @Column(name = "telefoneC")
    private String telefoneC;
    
    @Column(name = "enderecoC")
    private String enderecoC;

    public Cliente() {
    }

    public Cliente(String nomeC, String cpfC, String sexoC, String telefoneC, String enderecoC) {
        this.nomeC = nomeC;
        this.cpfC = cpfC;
        this.sexoC = sexoC;
        this.telefoneC = telefoneC;
        this.enderecoC = enderecoC;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeC() {
        return nomeC;
    }

    public void setNomeC(String nomeC) {
        this.nomeC = nomeC;
    }

    public String getCpfC() {
        return cpfC;
    }

    public void setCpfC(String cpfC) {
        this.cpfC = cpfC;
    }

    public String getSexoC() {
        return sexoC;
    }

    public void setSexoC(String sexoC) {
        this.sexoC = sexoC;
    }

    public String getTelefoneC() {
        return telefoneC;
    }

    public void setTelefoneC(String telefoneC) {
        this.telefoneC = telefoneC;
    }

    public String getEnderecoC() {
        return enderecoC;
    }

    public void setEnderecoC(String enderecoC) {
        this.enderecoC = enderecoC;
    }
}

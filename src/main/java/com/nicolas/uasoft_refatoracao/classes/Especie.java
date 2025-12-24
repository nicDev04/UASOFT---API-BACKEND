
package com.nicolas.uasoft_refatoracao.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbEspecie")
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEspecie;
    
    @Column(name = "nomeEspecie")
    private String nomeEspecie;

    public Especie() {
    }
    
    

    public Especie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }

    public long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(long idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public void setNomeEspecie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }
}

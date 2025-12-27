
package com.nicolas.uasoft.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbRaca")
public class Raca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRaca;

    @Column(name = "nomeRaca")
    private String nomeRaca;
    
    @ManyToOne
    @JoinColumn(name = "especie_id", unique = true)
    private Especie especie;

    public Raca() {
    }
    
    

    public Raca(String nomeRaca, Especie especie) {
        this.nomeRaca = nomeRaca;
        this.especie = especie;
    }

    public long getIdRaca() {
        return idRaca;
    }

    public void setIdRaca(long idRaca) {
        this.idRaca = idRaca;
    }

    public String getNomeRaca() {
        return nomeRaca;
    }

    public void setNomeRaca(String nomeRaca) {
        this.nomeRaca = nomeRaca;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
    
    
}

package com.nicolas.uasoft.classes;

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
@Table(name = "tbPet")

public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPet;

    public Pet() {
    }

    @Column(name = "nomePet")
    private String nomePet;

    @Column(name = "sexoPet")
    private String sexoPet;

    @Column(name = "dataNascPet")
    private LocalDate dataNascPet;

    @ManyToOne
    @JoinColumn(name = "especie_id", unique = true)
    private Especie especie;

    @ManyToOne
    @JoinColumn(name = "raca_id", unique = true)
    private Raca raca;

    @ManyToOne
    @JoinColumn(name = "cliente_id", unique = true)
    private Cliente cliente;

    public Pet(String nomePet, String sexoPet, LocalDate dataNascPet, Especie especie, Raca raca, Cliente cliente) {
        this.nomePet = nomePet;
        this.sexoPet = sexoPet;
        this.dataNascPet = dataNascPet;
        this.especie = especie;
        this.raca = raca;
        this.cliente = cliente;
    }

    public long getIdPet() {
        return idPet;
    }

    public void setIdPet(long idPet) {
        this.idPet = idPet;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getSexoPet() {
        return sexoPet;
    }

    public void setSexoPet(String sexoPet) {
        this.sexoPet = sexoPet;
    }

    public LocalDate getDataNascPet() {
        return dataNascPet;
    }

    public void setDataNascPet(LocalDate dataNascPet) {
        this.dataNascPet = dataNascPet;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}

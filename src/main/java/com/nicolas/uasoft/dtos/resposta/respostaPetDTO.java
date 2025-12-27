package com.nicolas.uasoft.dtos.resposta;
import java.time.LocalDate;

public class respostaPetDTO {
    private Long idPet;
    private String nomePet;
    private String sexoPet;
    private LocalDate dataNascPet;
    private String especie;
    private String raca;
    private String tutor;

    public respostaPetDTO() {
    }

    public respostaPetDTO(Long idPet, String nomePet, String sexoPet, LocalDate dataNascPet, String especie, String raca, String tutor) {
        this.idPet = idPet;
        this.nomePet = nomePet;
        this.sexoPet = sexoPet;
        this.dataNascPet = dataNascPet;
        this.especie = especie;
        this.raca = raca;
        this.tutor = tutor;
    }

    public Long getIdPet() {
        return idPet;
    }

    public void setIdPet(Long idPet) {
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}

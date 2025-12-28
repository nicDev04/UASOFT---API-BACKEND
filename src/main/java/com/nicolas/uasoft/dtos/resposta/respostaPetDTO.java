package com.nicolas.uasoft.dtos.resposta;
import java.time.LocalDate;

public class respostaPetDTO {
    private Long idPet;
    private String nomePet;
    private String sexoPet;
    private LocalDate dataNascPet;

    private Long idEspecie;
    private String especie;

    private Long idRaca;
    private String raca;

    private Long idTutor;
    private String tutor;

    public respostaPetDTO() {
    }

    public respostaPetDTO(Long idPet, String nomePet, String sexoPet, LocalDate dataNascPet, Long idEspecie, String especie, Long idRaca, String raca, Long idTutor, String tutor) {
        this.idPet = idPet;
        this.nomePet = nomePet;
        this.sexoPet = sexoPet;
        this.dataNascPet = dataNascPet;
        this.idEspecie = idEspecie;
        this.especie = especie;
        this.idRaca = idRaca;
        this.raca = raca;
        this.idTutor = idTutor;
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

    public Long getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Long idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Long getIdRaca() {
        return idRaca;
    }

    public void setIdRaca(Long idRaca) {
        this.idRaca = idRaca;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Long getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(Long idTutor) {
        this.idTutor = idTutor;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}

package com.nicolas.uasoft.dtos.resposta;

public class respostaEspecieDTO {
    private Long id;
    private String nomeEspecie;

    public respostaEspecieDTO(Long id, String nomeEspecie) {
        this.id = id;
        this.nomeEspecie = nomeEspecie;
    }

    public respostaEspecieDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEspecie() {
        return nomeEspecie;
    }

    public void setNomeEspecie(String nomeEspecie) {
        this.nomeEspecie = nomeEspecie;
    }
}

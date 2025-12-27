package com.nicolas.uasoft.dtos.resposta;

import jakarta.persistence.Column;

public class respostaMarcaDTO {
    private Long idMarca;
    private String nomeMarca;

    public respostaMarcaDTO(Long idMarca, String nomeMarca) {
        this.idMarca = idMarca;
        this.nomeMarca = nomeMarca;
    }

    public respostaMarcaDTO() {
    }

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }
}

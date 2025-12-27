package com.nicolas.uasoft.dtos.resposta;

import jakarta.persistence.Column;
import org.apache.juli.logging.Log;

public class respostaGrupoDTO {
    private Long idGrupo;
    private String nomeGrupo;

    public respostaGrupoDTO(Long idGrupo, String nomeGrupo) {
        this.idGrupo = idGrupo;
        this.nomeGrupo = nomeGrupo;
    }

    public respostaGrupoDTO() {
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }
}

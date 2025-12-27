package com.nicolas.uasoft.dtos.resposta;

public class respostaRacaDTO {
    private long idRaca;
    private String nomeRaca;

    public respostaRacaDTO() {
    }

    public respostaRacaDTO(long idRaca, String nomeRaca) {
        this.idRaca = idRaca;
        this.nomeRaca = nomeRaca;
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
}

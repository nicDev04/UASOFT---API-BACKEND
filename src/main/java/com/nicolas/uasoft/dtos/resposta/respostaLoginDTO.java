package com.nicolas.uasoft.dtos.resposta;

public class respostaLoginDTO {
    private Long idF;
    private String nomeF;
    private String loginF;
    private String cargoF;

    public respostaLoginDTO(Long idF, String nomeF, String loginF, String cargoF) {
        this.idF = idF;
        this.nomeF = nomeF;
        this.loginF = loginF;
        this.cargoF = cargoF;
    }

    public Long getIdF() {
        return idF;
    }

    public void setIdF(Long idF) {
        this.idF = idF;
    }

    public String getNomeF() {
        return nomeF;
    }

    public void setNomeF(String nomeF) {
        this.nomeF = nomeF;
    }

    public String getLoginF() {
        return loginF;
    }

    public void setLoginF(String loginF) {
        this.loginF = loginF;
    }

    public String getCargoF() {
        return cargoF;
    }

    public void setCargoF(String cargoF) {
        this.cargoF = cargoF;
    }
}

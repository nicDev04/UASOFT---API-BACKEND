package com.nicolas.uasoft.dtos.requisicao;

public class requisicaoLoginDTO {
    private String usuario;
    private String senha;

    public requisicaoLoginDTO(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public requisicaoLoginDTO() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

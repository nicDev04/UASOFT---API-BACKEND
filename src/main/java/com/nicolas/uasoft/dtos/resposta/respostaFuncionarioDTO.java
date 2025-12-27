package com.nicolas.uasoft.dtos.resposta;

public class respostaFuncionarioDTO {
    private long idFuncionario;
    private String nomeF;
    private String cpfF;
    private String sexoF;
    private String enderecoF;
    private String telefoneF;
    private String cargoF;
    private String login;

    public respostaFuncionarioDTO(long idFuncionario, String nomeF, String cpfF, String sexoF, String enderecoF, String telefoneF, String cargoF, String login) {
        this.idFuncionario = idFuncionario;
        this.nomeF = nomeF;
        this.cpfF = cpfF;
        this.sexoF = sexoF;
        this.enderecoF = enderecoF;
        this.telefoneF = telefoneF;
        this.cargoF = cargoF;
        this.login = login;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeF() {
        return nomeF;
    }

    public void setNomeF(String nomeF) {
        this.nomeF = nomeF;
    }

    public String getCpfF() {
        return cpfF;
    }

    public void setCpfF(String cpfF) {
        this.cpfF = cpfF;
    }

    public String getSexoF() {
        return sexoF;
    }

    public void setSexoF(String sexoF) {
        this.sexoF = sexoF;
    }

    public String getEnderecoF() {
        return enderecoF;
    }

    public void setEnderecoF(String enderecoF) {
        this.enderecoF = enderecoF;
    }

    public String getTelefoneF() {
        return telefoneF;
    }

    public void setTelefoneF(String telefoneF) {
        this.telefoneF = telefoneF;
    }

    public String getCargoF() {
        return cargoF;
    }

    public void setCargoF(String cargoF) {
        this.cargoF = cargoF;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

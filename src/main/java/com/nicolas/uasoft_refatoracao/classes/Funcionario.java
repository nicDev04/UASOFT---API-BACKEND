package com.nicolas.uasoft_refatoracao.classes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbFuncionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFuncionario;

    @Column(name = "nomeF")
    private String nomeF;

    @Column(name = "cpfF")
    private String cpfF;

    @Column(name = "sexoF")
    private String sexoF;

    @Column(name = "enderecoF")
    private String enderecoF;

    @Column(name = "telefoneF")
    private String telefoneF;

    @Column(name = "cargoF")
    private String cargoF;

    @OneToOne(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private Login login;

    public Funcionario() {
    }

    public Funcionario(String nomeF, String cpfF, String sexoF, String enderecoF, String telefoneF, String cargoF) {
        this.nomeF = nomeF;
        this.cpfF = cpfF;
        this.sexoF = sexoF;
        this.enderecoF = enderecoF;
        this.telefoneF = telefoneF;
        this.cargoF = cargoF;
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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}

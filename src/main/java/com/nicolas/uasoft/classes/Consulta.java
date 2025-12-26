package com.nicolas.uasoft.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tbConsulta")

public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idConsulta;

    @Column(name = "dataConsulta")
    private LocalDate dataConsulta;

    @Column(name = "valorConsulta")
    private double valorConsulta;

    @Column(name = "valorMedicamentos")
    private double valorMedicamentos;

    @Column(name = "observacoes")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "cliente_id", unique = true)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "pet_id", unique = true)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", unique = true)
    private Funcionario funcionario;

    public Consulta() {
    }

    public Consulta(Cliente cliente, Pet pet, Funcionario funcionario, LocalDate dataConsulta, double valorConsulta, double valorMedicamentos, String observacoes) {
        this.cliente = cliente;
        this.pet = pet;
        this.funcionario = funcionario;
        this.dataConsulta = dataConsulta;
        this.valorConsulta = valorConsulta;
        this.valorMedicamentos = valorMedicamentos;
        this.observacoes = observacoes;
    }

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public double getValorMedicamentos() {
        return valorMedicamentos;
    }

    public void setValorMedicamentos(double valorMedicamentos) {
        this.valorMedicamentos = valorMedicamentos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}

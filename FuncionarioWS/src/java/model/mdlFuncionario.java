/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Almir
 */
public class mdlFuncionario {
    
    private String datacad;
    private String cargo;
    private String cpf;
    private String nome;
    private String ufnasc;
    private Double salario;
    private String status;

    public String getDataCad() {
        return datacad;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getUfNasc() {
        return ufnasc;
    }
    
    public Double getSalario() {
        return salario;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setDataCad(String datacad) {
        this.datacad = datacad;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setUfNasc(String ufnasc) {
        this.ufnasc = ufnasc;
    }
    
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

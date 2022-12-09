/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.modelos;

/**
 *
 * @author aluno
 */
public class Endereco {
    
    private String logradouro = "";
    private String complemento = "";
    private String CEP = "";
    private Estado estado = null;
    private String cidade = "";
    private String bairro = "";

    public Endereco() {
        
    }
    
    public Endereco(String logradouro, String complemento, String CEP, Estado estado, String cidade, String bairro){
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.CEP = CEP;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return logradouro + ";" + complemento + ";" + CEP + ";" + estado + ";" + cidade + ";" + bairro + "\n";
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.modelos;

/**
 *
 * @author aluno
 */
public class Cliente {

    private int id = 0;
    private String cpf_cnpj = "";
    private String nome = "";
    private String razaoSocial = "";
    private String identidade = "";
    private Telefone telefone = null;
    private String email = "";
    private Endereco endereco = null;
    private TipoDoCliente tipo = null;

    public Cliente() {
        
    }

    public Cliente(int id, String cpf_cnpj, String nome, String razaoSocial, String identidade, Telefone telefone, String email, Endereco endereco, TipoDoCliente tipo) {
        this.id = id;
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.identidade = identidade;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return id + ";" + cpf_cnpj + ";" + nome + ";" + razaoSocial + ";" + identidade + ";" + telefone + ";" + email + ";" + endereco + ";" + tipo + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TipoDoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoDoCliente tipo) {
        this.tipo = tipo;
    }
    
}

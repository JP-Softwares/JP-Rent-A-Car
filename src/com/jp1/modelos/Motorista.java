/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.modelos;
import com.jp1.tools.Data;

/**
 *
 * @author aluno
 */
public class Motorista {
    
    private int id = 0;
    private Data dataVencimento = null;
    private String nome = "";
    private String numeroCNH = "";
    private String urlImagemCNH = "";
    private Telefone telefone = null;
    private Endereco endereco = null;

    public Motorista() {
        
    }

    public Motorista(int id, Data dataVencimento, String nome, String numeroCNH, String urlImagemCNH, Telefone telefone, Endereco endereco) {
        this.id = id;
        this.dataVencimento = dataVencimento;
        this.nome = nome;
        this.numeroCNH = numeroCNH;
        this.urlImagemCNH = urlImagemCNH;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return  id + ";" + dataVencimento + ";" + nome + ";" + numeroCNH + ";" + urlImagemCNH + ";" + telefone + ";" + endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Data getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Data dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getUrlImagemCNH() {
        return urlImagemCNH;
    }

    public void setUrlImagemCNH(String urlImagemCNH) {
        this.urlImagemCNH = urlImagemCNH;
    }
    
}

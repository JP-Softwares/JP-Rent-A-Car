/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.modelos;

/**
 *
 * @author aluno
 */
public class Acessorios {
    
    private int id = 0;
    private String descricao = "";
    private float valorDaLocacao = 0;
    private int quantidadeTotal = 0;
    private int quantidadeDisponivel = 0;
    
    
    // Métodos
    
    public Acessorios(){
        
    }
    
    public Acessorios(int id, String descricao, float valorDaLocacao, int quantidadeTotal, int quantidadeDisponivel){
        this.id = id;
        this.descricao = descricao;
        this.valorDaLocacao = valorDaLocacao;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public String toString(){
        return id + ";" + descricao + ";" + valorDaLocacao + ";" + quantidadeTotal + ";" + quantidadeDisponivel + "\n";
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorDaLocacao() {
        return valorDaLocacao;
    }

    public void setValorDaLocacao(float valorDaLocacao) {
        this.valorDaLocacao = valorDaLocacao;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
    
}

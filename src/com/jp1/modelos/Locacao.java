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
public class Locacao {
    private int id = 0;
    private Data dataInicio = null;
    private Data dataFim = null;
    private float valorDaLocacao = 0;
    private SituacaoDoVeiculo situacao = null;
    
    public Locacao(){
        
    }
    
    public Locacao(int id, Data dataInicio, Data dataFim, float valorDaLocacao, SituacaoDoVeiculo situacao){
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.valorDaLocacao = valorDaLocacao;
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return  id + ";" + dataInicio + ";"  + dataFim + ";" + dataFim + ";" + valorDaLocacao + ";"  + situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Data getDataFim() {
        return dataFim;
    }

    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    public float getValorDaLocacao() {
        return valorDaLocacao;
    }

    public void setValorDaLocacao(float valorDaLocacao) {
        this.valorDaLocacao = valorDaLocacao;
    }

    public SituacaoDoVeiculo getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoDoVeiculo situacao) {
        this.situacao = situacao;
    }
    
    
}

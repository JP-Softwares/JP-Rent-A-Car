/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.modelos;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class Veiculo {

    private int id = 0;
    private String placa = "";
    private int renavam = 0;
    private String categoria = "";
    private float precoDeCompra = 0;
    private float precoDeVenda = 0;
    private Date anoFabricacao = null;
    private Date anoModelo = null;
    private int quilometragem = 0;
    private TipoDoCombustivel combustivel = null;
    private TipoDoVeiculo carro = null;
    private SituacaoDoVeiculo situacao = null;

    public Veiculo(){

    }

    public Veiculo(int id, String placa, int renavam, String categoria, float precoDeCompra, float precoDeVenda, Date anoFabricacao, Date anoModelo, int quilometragem, TipoDoCombustivel combustivel, TipoDoVeiculo carro, SituacaoDoVeiculo situacao) {
        this.id = id;
        this.placa = placa;
        this.renavam = renavam;
        this.categoria = categoria;
        this.precoDeCompra = precoDeCompra;
        this.precoDeVenda = precoDeVenda;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.quilometragem = quilometragem;
        this.combustivel = combustivel;
        this.carro = carro;
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return id + ";" + placa + ";" + renavam + ";" + categoria + ";" + precoDeCompra + ";" + precoDeVenda + ";" + anoFabricacao + ";" + anoModelo + ";" + quilometragem + ";" + combustivel + ";" + carro + ";" + situacao + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getRenavam() {
        return renavam;
    }

    public void setRenavam(int renavam) {
        this.renavam = renavam;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecoDeCompra() {
        return precoDeCompra;
    }

    public void setPrecoDeCompra(float precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public float getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(float precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public Date getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Date anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Date getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Date anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public TipoDoCombustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(TipoDoCombustivel combustivel) {
        this.combustivel = combustivel;
    }

    public TipoDoVeiculo getCarro() {
        return carro;
    }

    public void setCarro(TipoDoVeiculo carro) {
        this.carro = carro;
    }

    public SituacaoDoVeiculo getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoDoVeiculo situacao) {
        this.situacao = situacao;
    }

}

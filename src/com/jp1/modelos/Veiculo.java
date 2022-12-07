/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.modelos;

/**
 *
 * @author aluno
 */
public class Veiculo {

    private int id = 0;
    private String placa = "";
    private int renavam = 0;
    private float precoDeCompra = 0;
    private float precoDeVenda = 0;
    private int anoFabricacao = 0;
    private int anoModelo = 0;
    private int kilometragem = 0;
    private TipoDoCombustivel combustivel = null;
    private TipoDoVeiculo carro = null;
    private SituacaoDoVeiculo situacao = null;
    private Categoria categoria = null;
    private Modelo modelo = null;

    public Veiculo(){

    }

    public Veiculo(int id, String placa, int renavam, Categoria categoria, float precoDeCompra, float precoDeVenda, int anoFabricacao, int anoModelo, int kilometragem, TipoDoCombustivel combustivel, TipoDoVeiculo carro, SituacaoDoVeiculo situacao, Modelo modelo) {
        this.id = id;
        this.placa = placa;
        this.renavam = renavam;
        this.categoria = categoria;
        this.precoDeCompra = precoDeCompra;
        this.precoDeVenda = precoDeVenda;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.kilometragem = kilometragem;
        this.combustivel = combustivel;
        this.carro = carro;
        this.situacao = situacao;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return id + ";" + placa + ";" + renavam + ";" + categoria.getId() + ";" + precoDeCompra + ";" + precoDeVenda + ";" + anoFabricacao + ";" + anoModelo + ";" + kilometragem + ";" + combustivel + ";" + carro + ";" + situacao + ";" + modelo.getId() + "\n";
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
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

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
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

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.modelos;
import com.jp1.controle.*;
import com.jp1.modelos.*;
/**
 *
 * @author aluno
 */
public class Modelo {
    
    private int id = 0;
    private String descricao = "";
    private String url = "";
    private Marca marca = null;
    
    // Métodos
    
    public Modelo(){
        
    }
    
    public Modelo(int id, String descricao, String url, Marca marca){
        this.id = id;
        this.descricao = descricao;
        this.url = url;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return id + ";" + descricao + ";" + url + ";" + marca.getId() +"\n";
    }
    
    public Marca buscar(String descricao) throws Exception{
        try {
            IModeloControle modeloControle = new ModeloControle();
            Marca marca = modeloControle.buscar(descricao);
            return marca;
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public Marca buscar(int id) throws Exception{
        try {
            IModeloControle modeloControle = new ModeloControle();
            Marca marca = modeloControle.buscar(id);
            return marca;
        } catch (Exception e) {
            throw e;
        }
        
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
}

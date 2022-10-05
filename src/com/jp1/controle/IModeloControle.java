/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.controle;
import com.jp1.modelos.Modelo;
import java.util.ArrayList;
import java.util.Iterator;
import com.jp1.modelos.Marca;

/**
 *
 * @author aluno
 */
public interface IModeloControle {
    void incluir(Modelo objeto) throws Exception;
    
    void alterar(Modelo objeto) throws Exception;

    Marca buscar(String descricao) throws Exception;

    Marca buscar(int id) throws Exception;
    
    ArrayList<Modelo> listar() throws Exception;
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.controle;
import com.jp1.modelos.Categoria;
import java.util.ArrayList;
/**
 *
 * @author aluno
 */
public interface ICategoriaControle {
    void incluir(Categoria objeto) throws Exception;

    
    void alterar(Categoria objeto) throws Exception;

    
    ArrayList<Categoria> listar() throws Exception;
             
    Categoria buscar(String descricao) throws Exception;

    Categoria buscar(int id) throws Exception;
}

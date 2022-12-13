/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.controle;
import com.jp1.modelos.Acessorios;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public interface IAcessoriosControle {
  
    void incluir(Acessorios objeto) throws Exception;

    
    void alterar(Acessorios objeto) throws Exception;

    
    ArrayList<Acessorios> listar() throws Exception;
             
    Acessorios buscar(String descricao) throws Exception;

    Acessorios buscar(int id) throws Exception;
}

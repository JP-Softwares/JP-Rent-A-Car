/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.persistencia;

import java.util.ArrayList;
import com.jp1.modelos.Veiculo;

/**
 *
 * @author aluno
 */
public interface IVeiculoDao {

    void incluir(Veiculo objeto) throws Exception;
    void alterar(Veiculo objeto) throws Exception;
    ArrayList<Veiculo> listar() throws Exception;
    Veiculo buscar(String descricao) throws Exception;
    Veiculo buscar(int id) throws Exception; 

    
}

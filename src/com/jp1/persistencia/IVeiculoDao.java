/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.persistencia;

import com.jp1.modelos.Categoria;
import java.util.ArrayList;
import com.jp1.modelos.Veiculo;
import com.jp1.tools.Data;

/**
 *
 * @author aluno
 */
public interface IVeiculoDao {

    void incluir(Veiculo objeto) throws Exception;
    void alterar(Veiculo objeto) throws Exception;
    ArrayList<Veiculo> listar() throws Exception;
    Veiculo buscar(int id) throws Exception; 
    Veiculo buscar(String placa) throws Exception;
    ArrayList<Veiculo> listarNaoLocados(Data inicio, Categoria categoria) throws Exception;
   

    
}

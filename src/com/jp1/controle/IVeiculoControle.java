/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.controle;
import com.jp1.modelos.Categoria;
import com.jp1.modelos.Veiculo;
import java.util.ArrayList;
import java.util.Iterator;
import com.jp1.modelos.Modelo;
import com.jp1.tools.Data;

/**
 *
 * @author aluno
 */
public interface IVeiculoControle {
    void incluir(Veiculo objeto) throws Exception;
    
    void alterar(Veiculo objeto) throws Exception;

    ArrayList<Veiculo> listar() throws Exception;

    Veiculo buscar(int id) throws Exception;

    Veiculo buscar(String placa) throws Exception;
    
    ArrayList<Veiculo> listarNaoLocados(Data inicio, Categoria categoria) throws Exception;
}

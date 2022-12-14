/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.controle;
import com.jp1.modelos.Motorista;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public interface IMotoristaControle {
    void incluir(Motorista objeto) throws Exception;
    void alterar(Motorista objeto) throws Exception;
    ArrayList<Motorista> listar() throws Exception;
    Motorista buscar(String CNH) throws Exception;
    Motorista buscar(int id) throws Exception; 
}

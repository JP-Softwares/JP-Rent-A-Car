/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.persistencia;

import java.util.ArrayList;
import com.jp1.modelos.*;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author aluno
 */
public interface IModeloDao {

    void incluir(Modelo objeto) throws Exception;
    void alterar(Modelo objeto) throws Exception;
    ArrayList<Modelo> listar() throws Exception;
    void apagar()throws Exception;
    Modelo buscar(String descricao) throws Exception;
    Modelo buscar(int id) throws Exception; 
}    


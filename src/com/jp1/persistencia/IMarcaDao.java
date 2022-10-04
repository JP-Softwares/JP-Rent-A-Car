/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.persistencia;
import com.jp1.modelos.Marca;

import java.util.ArrayList;
/**
 *
 * @author HP
 */
public interface IMarcaDao {
    
    void incluir(Marca objeto) throws Exception;
    void alterar(Marca objeto) throws Exception;
    ArrayList<Marca> listar() throws Exception;
    Marca buscar(String descricao) throws Exception;
}

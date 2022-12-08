/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.persistencia;
import java.util.ArrayList;
import com.jp1.modelos.Cliente;

/**
 *
 * @author aluno
 */
public interface IClienteDao {

    void incluir(Cliente objeto) throws Exception;
    void alterar(Cliente objeto) throws Exception;
    ArrayList<Cliente> listar() throws Exception;
    Cliente buscar(int id) throws Exception; 
    
       
}

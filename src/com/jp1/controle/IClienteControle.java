/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.controle;
import com.jp1.modelos.Cliente;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public interface IClienteControle {

    void incluir(Cliente objeto) throws Exception;
    
    void alterar(Cliente objeto) throws Exception;

    ArrayList<Cliente> listar() throws Exception;

    Cliente buscar(int id) throws Exception;
    Cliente buscar(String cpf_cnpj) throws Exception;
    boolean validarCPF (String CPF);
    
}

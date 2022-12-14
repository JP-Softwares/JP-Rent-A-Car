/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.persistencia;
import java.util.ArrayList;
import com.jp1.modelos.Locacao;

/**
 *
 * @author aluno
 */
public interface ILocacaoDao {
    void incluir(Locacao objeto) throws Exception;
    void alterar(Locacao objeto) throws Exception;
    ArrayList<Locacao> listar() throws Exception;
    //Locacao buscar(String descricao) throws Exception;
    Locacao buscar(int id) throws Exception; 
}

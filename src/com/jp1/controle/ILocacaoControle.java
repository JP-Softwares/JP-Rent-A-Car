/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jp1.controle;
import com.jp1.modelos.Locacao;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public interface ILocacaoControle {
    void incluir(Locacao objeto) throws Exception;
    void alterar(Locacao objeto) throws Exception;
    ArrayList<Locacao> listar() throws Exception;
    Locacao buscar(int id) throws Exception;
    boolean verificarCampos(Locacao objeto)throws Exception;
    ArrayList<Locacao> listarRelacionados(String cpf_cnpj) throws Exception;
}

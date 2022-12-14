/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.persistencia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.jp1.tools.Data;
import com.jp1.modelos.Motorista;

/**
 *
 * @author aluno
 */
public class MotoristaDao implements IMotoristaDao {

    String nomeDoArquivoNoDisco = "./src/com/jp1/arquivosdedados/motorista.txt";
    
    public MotoristaDao(){
        
    } 

    @Override
    public void incluir(Motorista objeto) throws Exception {

        
    }

    @Override
    public void alterar(Motorista objeto) throws Exception {
  
    }

    @Override
    public ArrayList<Motorista> listar() throws Exception {

    }

    @Override
    public Motorista buscar(String CNH) throws Exception {

    }

    @Override
    public Motorista buscar(int id) throws Exception {

    }

    public static boolean verificarMotorista(Motorista objeto) throws Exception {

    }
}

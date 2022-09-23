/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.tools;

// Java I/O: Entrada e Saída
// I/O usado para arquivotexto
// Buffered: Controlar o delay.
import java.io.BufferedReader; // Leitura
import java.io.BufferedWriter; // Escrita
import java.io.FileNotFoundException; // Exceção de Entrada e Saída em arquivos
import java.io.FileReader; // Leitura
import java.io.FileWriter; // Escrita
import java.io.IOException; // Outros problemas de I/O

/**
 *
 * @author aluno
 */
public class ID {
    
    public static void criarArquivoDeID()throws FileNotFoundException, IOException{
        String nomeDoArquivo ="./src/com/jp1/arquivodedados/id.txt";
        FileWriter fw = new FileWriter(nomeDoArquivo);
        //Criar o buffer do arquivo
        BufferedWriter bw =new BufferedWriter(fw);
        //Escreve no arquivo
        String saida = 100000+"";
        bw.write(saida);
        //fecha o arquivo
        bw.close();
    }
    
    public static int getID()throws FileNotFoundException, IOException{
        String nomeDoArquivo ="./src/com/jp1/arquivodedados/id.txt";
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br  = new BufferedReader(fr);
        int id = Integer.parseInt(br.readLine());
        br.close();
        id++;
        //cria o arquivo
        FileWriter fw = new FileWriter(nomeDoArquivo);
        //Criar o buffer do arquivo
        BufferedWriter bw =new BufferedWriter(fw);
        //Escreve no arquivo
        bw.write(id+"");
        //fecha o arquivo
        bw.close();	
        return id;
    }
    
}

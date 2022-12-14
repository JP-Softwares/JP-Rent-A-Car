/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.persistencia;


import com.jp1.modelos.Acessorios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.io.File;

/**
 *
 * @author aluno
 */
public class AcessoriosDao implements IAcessoriosDao {

     String nomeDoArquivoNoDisco = "./src/com/jp1/arquivosdedados/acessorios.txt";

     public AcessoriosDao(){
        
    } 

    public void incluir(Acessorios objeto) throws IOException, FileNotFoundException, Exception {
        try {
            
            FileWriter fw = new FileWriter(new File(nomeDoArquivoNoDisco), true);
            BufferedWriter bw  = new BufferedWriter(fw);
            bw.write(objeto.toString());
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

      public void alterar(Acessorios objeto) throws IOException,FileNotFoundException,Exception{
     
     FileReader fr = new FileReader(new File(nomeDoArquivoNoDisco));
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        String banco = "";
        while((linha = br.readLine()) != null){
            if(linha.split(";")[0].equals(objeto.getId()+"")){
                banco+= objeto.toString();
            }else{
                banco+= linha + "\n";
            }
        }
        br.close();
        FileWriter fw = new FileWriter(new File(nomeDoArquivoNoDisco));
        BufferedWriter bw  = new BufferedWriter(fw);
        bw.write(banco);
        bw.close();

  }

  public ArrayList<Acessorios> listar() throws IOException,FileNotFoundException,Exception {
        try {
            ArrayList<Acessorios> listaDeAcessorios = new ArrayList<Acessorios>();
            FileReader fr = new FileReader(new File(nomeDoArquivoNoDisco));
            BufferedReader br = new BufferedReader(fr);

             String linha = "";

              while((linha = br.readLine()) != null){
                Acessorios objetoAcessorio = new Acessorios();
                String vetorString[] = linha.split(";");
                objetoAcessorio.setId(Integer.parseInt(vetorString[0]));
                objetoAcessorio.setDescricao(vetorString[1]);
                objetoAcessorio.setValorDaLocacao(Float.parseFloat(vetorString[2]));
                objetoAcessorio.setQuantidadeTotal(Integer.parseInt(vetorString[3]));
                objetoAcessorio.setQuantidadeLocada(Integer.parseInt(vetorString[4]));
                listaDeAcessorios.add(objetoAcessorio);

             
            }
            br.close();
            return listaDeAcessorios;
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    public Acessorios buscar(String descricao) throws Exception {


        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr); 

            
            String vetorString[] = null;
            

            Acessorios objetoAcessorio = new Acessorios();
            while(!(vetorString = br.readLine().split(";"))[1].equals(descricao));
            objetoAcessorio.setId(Integer.parseInt(vetorString[0]));
            objetoAcessorio.setDescricao(vetorString[1]);
            objetoAcessorio.setValorDaLocacao(Float.parseFloat(vetorString[2]));
            objetoAcessorio.setQuantidadeTotal(Integer.parseInt(vetorString[3]));
            objetoAcessorio.setQuantidadeLocada(Integer.parseInt(vetorString[4]));
            br.close();
            return objetoAcessorio;
            
        } catch (Exception erro) {
            throw erro;
        }
    }

     public Acessorios buscar(int id) throws Exception {


        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr); 

            
            String vetorString[] = null;
            

            Acessorios objetoAcessorio = new Acessorios();
         while(!(vetorString = br.readLine().split(";"))[0].equals(id+""));
            objetoAcessorio.setId(Integer.parseInt(vetorString[0]));
            objetoAcessorio.setDescricao(vetorString[1]);
            objetoAcessorio.setValorDaLocacao(Float.parseFloat(vetorString[2]));
            objetoAcessorio.setQuantidadeTotal(Integer.parseInt(vetorString[3]));
            objetoAcessorio.setQuantidadeLocada(Integer.parseInt(vetorString[4]));
            br.close();
            return objetoAcessorio;
            
        } catch (Exception erro) {
            throw erro;
        }
    }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.persistencia;

import com.jp1.modelos.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author aluno
 */
public class ModeloDao implements IModeloDao {

    String nomeDoArquivoNoDisco = "./src/com/jp1/arquivosdedados/modelo.txt";
    
    public Marca buscar(String descricao) throws IOException, FileNotFoundException {

        try {
            FileReader fr = new FileReader("./src/com/jp1/arquivosdedados/marca.txt");
            BufferedReader br = new BufferedReader(fr); 

            String linha =  "";

            Marca objetoMarca = new Marca();

            while(!(linha = br.readLine()).contains(descricao));
             String vetorString[] = linha.split(";");
             objetoMarca.setId(Integer.parseInt(vetorString[0]));
             objetoMarca.setDescricao(vetorString[1]);
             objetoMarca.setUrl(vetorString[2]);
            br.close();
            return objetoMarca;
            
        } catch (Exception erro) {
            throw erro;
        }
  }

  public Marca buscar(int id) throws IOException, FileNotFoundException {

        try {
            FileReader fr = new FileReader("./src/com/jp1/arquivosdedados/marca.txt");
            BufferedReader br = new BufferedReader(fr); 

            String linha =  "";

            Marca objetoMarca = new Marca();

            while(!(linha = br.readLine()).contains(id+""));
            
             String vetorString[] = linha.split(";");
             objetoMarca.setId(Integer.parseInt(vetorString[0]));
             objetoMarca.setDescricao(vetorString[1]);
             objetoMarca.setUrl(vetorString[2]);
            br.close();
            return objetoMarca;
            
        } catch (Exception erro) {
            throw erro;
        }
  }


   @Override
 public void incluir(Modelo objeto) throws IOException, FileNotFoundException{
  try {
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            BufferedWriter bw  = new BufferedWriter(fw);
            bw.write(objeto.toString());
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
 }

 @Override
    public void alterar(Modelo objeto) throws IOException, FileNotFoundException {
        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        String banco = "";
        while((linha = br.readLine()) != null){
            if(linha.contains(objeto.getId()+"")){
                banco+= objeto.getId() + ";" + objeto.getDescricao() + ";" + objeto.getUrl() + "\n";
            }else{
                banco+= linha + "\n";
            }
        }
        br.close();
        FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
        BufferedWriter bw  = new BufferedWriter(fw);
        bw.write(banco);
        bw.close(); 

    }

       @Override
    public ArrayList<Modelo> listar() throws IOException, FileNotFoundException {
        try {
            ArrayList<Modelo> listaDeModelos = new ArrayList<Modelo>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);

            String linha = "";

            while((linha = br.readLine()) != null){
                Modelo objetoModelo = new Modelo();
                String vetorString[] = linha.split(";");
                objetoModelo.setId(Integer.parseInt(vetorString[0]));
                objetoModelo.setDescricao(vetorString[1]);
                objetoModelo.setUrl(vetorString[2]);
                listaDeModelos.add(objetoModelo);
                //TelaMarcas.jTableMarcas.add
            }
            br.close();
            return listaDeModelos;
        } catch (Exception erro) {
            throw erro;
        }
    }

}

  

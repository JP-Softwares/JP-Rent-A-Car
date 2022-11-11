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

import javax.swing.ImageIcon;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;

import javax.imageio.ImageIO;
import javax.imageio.ImageTypeSpecifier;
import javax.swing.JOptionPane;


/**
 *
 * @author aluno
 */
public class  ModeloDao implements IModeloDao {

    String nomeDoArquivoNoDisco = "./src/com/jp1/arquivosdedados/modelo.txt";
    
    
    
    private String incluirAutoRetrato(Modelo objeto) throws Exception{
        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File(objeto.getUrl()));
            File outputfile = new File("./src/com/jp1/autoretrato/"+ objeto.getId()+".png");
            ImageIO.write(imagem, "png", outputfile);
            return outputfile.toString();
        } catch (Exception e) {
            throw e;
        }
    }

   @Override
    public void incluir(Modelo objeto) throws Exception{
        try {
            objeto.setUrl(incluirAutoRetrato(objeto));
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            BufferedWriter bw  = new BufferedWriter(fw);
            bw.write(objeto.toString());
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

 @Override
    public void alterar(Modelo objeto) throws Exception {
        try {
            objeto.setUrl(incluirAutoRetrato(objeto));
        } catch (Exception e) {
            throw e;
        }
        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        String banco = "";
        while((linha = br.readLine()) != null){
            if(linha.contains(objeto.getId()+"")){
                banco+= objeto.toString();
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
    public ArrayList<Modelo> listar() throws IOException, FileNotFoundException, Exception {
        try {
            ArrayList<Modelo> listaDeModelos = new ArrayList<Modelo>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);

            String linha = "";

            while((linha = br.readLine()) != null){
                Modelo objetoModelo = new Modelo();
                IMarcaDao marcaDao = new MarcaDao();
                String vetorString[] = linha.split(";");
                objetoModelo.setId(Integer.parseInt(vetorString[0]));
                objetoModelo.setDescricao(vetorString[1]);
                objetoModelo.setUrl(vetorString[2]);
                try {
                    objetoModelo.setMarca(marcaDao.buscar(vetorString[3]));
                } catch (Exception e) {
                    throw e;
                }
                
                listaDeModelos.add(objetoModelo);
                //TelaMarcas.jTableMarcas.add
            }
            br.close();
            return listaDeModelos;
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void apagar() throws Exception {
        File arquivo = new File(nomeDoArquivoNoDisco);
        FileWriter fw = new FileWriter(arquivo);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("");
    }
     
}

  

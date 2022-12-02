/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.persistencia;

import com.jp1.modelos.Marca;
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
 * @author HP
 */
public class MarcaDao implements IMarcaDao {    
    
    String nomeDoArquivoNoDisco = "./src/com/jp1/arquivosdedados/marca.txt";
    
    public MarcaDao(){
        
    } 

    public Marca buscar(String descricao) throws IOException, FileNotFoundException {

        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr); 

            
            String vetorString[] = null;
            

            Marca objetoMarca = new Marca();
            while(!(vetorString = br.readLine().split(";"))[1].equals(descricao));
            //vetorString = linha.split(";");
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
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr); 

            String vetorString[] = null;

            Marca objetoMarca = new Marca();
            while(!(vetorString = br.readLine().split(";"))[0].equals(id+""));
             objetoMarca.setId(Integer.parseInt(vetorString[0]));
             objetoMarca.setDescricao(vetorString[1]);
             objetoMarca.setUrl(vetorString[2]);
            br.close();
            return objetoMarca;
            
        } catch (Exception erro) {  
            throw erro;
        }
  }


    private String incluirLogo(Marca objeto) throws Exception{
        if(objeto.getUrl().contains("logosdainternet")) return "";
        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File(objeto.getUrl()));
            File outputfile = new File("./src/com/jp1/logos/" + objeto.getId() + ".png");
            ImageIO.write(imagem, "png", outputfile);
            
            return outputfile.getPath().replace("\\" , "/");
        } catch (Exception e) {
            throw e;
        }
        
    }

    
    @Override
    public void incluir(Marca objeto) throws IOException, FileNotFoundException, Exception {
        try {
            String url = incluirLogo(objeto);
            if(!url.equals("")) objeto.setUrl(url);
            
            FileWriter fw = new FileWriter(new File(nomeDoArquivoNoDisco), true);
            BufferedWriter bw  = new BufferedWriter(fw);
            bw.write(objeto.toString());
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Marca objeto) throws IOException, FileNotFoundException, Exception {
        String url = "";
        try {
            url = incluirLogo(objeto);
           
            if(url.equals("")) {
                File outputfile = new File("./src/com/jp1/logos/" + objeto.getId() + ".png");
                if(outputfile.exists()){
                     if(outputfile.delete()){

                }else{
                    throw new Exception("A imagem do package logos não foi deletada com sucesso");
                }
                }//else throw new Exception ("Imagem não existe no package logos");
               

            }else{ objeto.setUrl(url);

            }

        } catch (Exception e) {
            throw e;
        }
        
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
    
             @Override
    public ArrayList<Marca> listar() throws IOException, FileNotFoundException, Exception {
        try {
            ArrayList<Marca> listaDeMarcas = new ArrayList<Marca>();
            FileReader fr = new FileReader(new File(nomeDoArquivoNoDisco));
            BufferedReader br = new BufferedReader(fr);

            String linha = "";

            while((linha = br.readLine()) != null){
                Marca objetoMarca = new Marca();
                String vetorString[] = linha.split(";");
                objetoMarca.setId(Integer.parseInt(vetorString[0]));
                objetoMarca.setDescricao(vetorString[1]);
                objetoMarca.setUrl(vetorString[2]);
                listaDeMarcas.add(objetoMarca);
                //TelaMarcas.jTableMarcas.add
            }
            br.close();
            return listaDeMarcas;
        } catch (Exception erro) {
            throw erro;
        }
        
    }


    
}

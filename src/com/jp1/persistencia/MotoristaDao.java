/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.persistencia;
import com.jp1.modelos.Modelo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.jp1.tools.Data;
import com.jp1.modelos.Motorista;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

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
        try {
            String url = incluirFotoCNH(objeto);
            if(!url.equals("")) objeto.setUrlImagemCNH(url);
            FileWriter fw = new FileWriter(new File(nomeDoArquivoNoDisco), true);
            BufferedWriter bw  = new BufferedWriter(fw);
            bw.write(objeto.toString());
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Motorista objeto) throws Exception {
        String url = "";
        try {
            url = incluirFotoCNH(objeto);
           
            if(url.equals("")) {
                File outputfile = new File("./src/com/jp1/fotoCNH/" + objeto.getId() + ".png");
                if(outputfile.exists()){
                     if(outputfile.delete()){

                }else{
                    throw new Exception("A imagem do package fotoCNH não foi deletada com sucesso");
                }
                }//else throw new Exception ("Imagem não existe no package logos");
               

            }else{ objeto.setUrlImagemCNH(url);

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
    public ArrayList<Motorista> listar() throws Exception {
        try {
            ArrayList<Motorista> listaDeMarcas = new ArrayList<Motorista>();
            FileReader fr = new FileReader(new File(nomeDoArquivoNoDisco));
            BufferedReader br = new BufferedReader(fr);

            String linha = "";

            while((linha = br.readLine()) != null){
                Motorista objetoMotorista = new Motorista();
                String vetorString[] = linha.split(";");
                objetoMotorista.setId(Integer.parseInt(vetorString[0]));
                objetoMotorista.setDataVencimento(new Data(vetorString[1].split("/")));
                objetoMotorista.setUrl(vetorString[2]);
                listaDeMarcas.add(objetoMarca);
                //TelaMarcas.jTableMarcas.add
            }
            br.close();
            return listaDeMarcas;
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Motorista buscar(String CNH) throws Exception {

    }

    @Override
    public Motorista buscar(int id) throws Exception {

    }

    public static boolean verificarMotorista(Motorista objeto) throws Exception {

    }
    
    private String incluirFotoCNH(Motorista objeto) throws Exception{
        BufferedImage imagem = null;
        try {
            imagem = ImageIO.read(new File(objeto.getUrlImagemCNH()));
            File outputfile = new File("./src/com/jp1/fotoCNH/"+ objeto.getId()+".png");
            ImageIO.write(imagem, "png", outputfile);
            return outputfile.toString();
        } catch (Exception e) {
            throw e;
        }
    }
}

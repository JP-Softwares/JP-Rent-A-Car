/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.persistencia;

import com.jp1.modelos.Categoria;
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
public class CategoriaDao implements ICategoriaDao {

    String nomeDoArquivoNoDisco = "./src/com/jp1/arquivosdedados/categoria.txt";

     public CategoriaDao(){
        
    } 

    @Override
    public void incluir(Categoria objeto) throws IOException, FileNotFoundException, Exception {
        try {
            
            FileWriter fw = new FileWriter(new File(nomeDoArquivoNoDisco), true);
            BufferedWriter bw  = new BufferedWriter(fw);
            bw.write(objeto.toString());
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

  @Override
  public void alterar(Categoria objeto) throws IOException,FileNotFoundException,Exception{
    String url = ""; 

  }

    @Override
    public ArrayList<Categoria> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categoria buscar(String descricao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categoria buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }











    
}

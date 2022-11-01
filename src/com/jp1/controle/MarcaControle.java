/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.controle;

import com.jp1.modelos.Marca;
import com.jp1.persistencia.IMarcaDao;
import com.jp1.persistencia.MarcaDao;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import com.jp1.tools.ID;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author aluno
 */
public class MarcaControle implements IMarcaControle {
    
    IMarcaDao marcaPersistencia = null;
    
    
    public MarcaControle(){
        this.marcaPersistencia = new MarcaDao();
    }
    //private String verificarDescricao(String descricao){
        //String str = descricao.replaceAll("\\s+", "");
        //return str;
    //}
    private String verificarDescricao(String descricao){
        String str;
        while(descricao.endsWith(" ")){
            descricao = descricao.replaceFirst(".$", "");
        }
        while(descricao.startsWith(" ")){
            descricao = descricao.substring(1);
        }
        return descricao;
    }  

    public Marca buscar(String descricao) throws Exception{
        return marcaPersistencia.buscar(descricao);
    }

    public Marca buscar(int id) throws Exception{
        return marcaPersistencia.buscar(id);
    }  
    private boolean buscarMarca(String descricao) throws Exception{
        try {
            ArrayList<Marca> listagem = marcaPersistencia.listar();
            Iterator<Marca> lista = listagem.iterator();
            while(lista.hasNext()){
                Marca aux = lista.next();
                if(aux.getDescricao().equalsIgnoreCase(descricao)){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            throw erro;
        }
    }
    
      private boolean buscarMarca(Marca objeto) throws Exception{
        try {
            ArrayList<Marca> listagem = marcaPersistencia.listar();
            Iterator<Marca> lista = listagem.iterator();
            while(lista.hasNext()){
                Marca aux = lista.next();
                if(aux.getDescricao().equalsIgnoreCase(objeto.getDescricao()) && aux.getId() != objeto.getId()){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
           
            throw erro;
        }
    }

    private boolean verificarVazio(Marca objeto){
        if(objeto.getDescricao().equals("") || objeto.getUrl().equals("")) return true;
        return false;
    }

     public void incluir(Marca objeto) throws Exception{
        objeto.setDescricao(verificarDescricao(objeto.getDescricao()));
        if(verificarVazio(objeto)) throw new Exception("Preencha os campos corretamente");
        try{
            if(buscarMarca(objeto.getDescricao())){
                throw new Exception("Marca já cadastrada");
            }
        }catch(Exception erro) {
            if(erro.getMessage().contains("arquivo especificado")){  
            }else{
                throw erro;
            }
        }
        objeto.setId(ID.getID());
        marcaPersistencia.incluir(objeto);
     }

     public void alterar(Marca objeto) throws Exception{
        objeto.setDescricao(verificarDescricao(objeto.getDescricao()));
        if(verificarVazio(objeto)) throw new Exception("Preencha os campos corretamente");
        if(buscarMarca(objeto)){
            throw new Exception("Marca já cadastrada");
        }
        marcaPersistencia.alterar(objeto);
     }
     

     public ArrayList<Marca> listar() throws Exception{
        try{
            return marcaPersistencia.listar();
        }catch(Exception erro){
            return new ArrayList<Marca>();
        }
     }

    
}

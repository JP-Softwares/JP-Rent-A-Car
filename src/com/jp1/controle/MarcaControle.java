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

/**
 *
 * @author aluno
 */
public class MarcaControle implements IMarcaControle {
    
    IMarcaDao marcaPersistencia = null;
    
    public MarcaControle(){
        this.marcaPersistencia = new MarcaDao();
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

     public void incluir(Marca objeto) throws Exception{
         if(objeto.getDescricao().equals("")) throw new Exception("O nome da Marca não pode ser vazio.");
        if(buscarMarca(objeto.getDescricao())){
            throw new Exception("Marca já cadastrada");
        }
        marcaPersistencia.incluir(objeto);
     }

     public void alterar(Marca objeto) throws Exception{
       marcaPersistencia.alterar(objeto);
     }
     

     public ArrayList<Marca> listar() throws Exception{
        return marcaPersistencia.listar();
      
     }

    
}

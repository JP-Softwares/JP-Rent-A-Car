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

    private boolean verificarVazio(Marca objeto){
        if(objeto.getDescricao().equals("") || objeto.getUrl().equals("")) return true;
        return false;
    }

     public void incluir(Marca objeto) throws Exception{
        if(verificarVazio(objeto)) throw new Exception("Preencha os campos corretamente");
        if(buscarMarca(objeto.getDescricao())){
            throw new Exception("Marca já cadastrada");
        }
        objeto.setId(ID.getID());
        marcaPersistencia.incluir(objeto);
     }

     public void alterar(Marca objeto) throws Exception{
        if(verificarVazio(objeto)) throw new Exception("Preencha os campos corretamente");
        
        marcaPersistencia.alterar(objeto);
     }
     

     public ArrayList<Marca> listar() throws Exception{
        return marcaPersistencia.listar();
      
     }

    
}

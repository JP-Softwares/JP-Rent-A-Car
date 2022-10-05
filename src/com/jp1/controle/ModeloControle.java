/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.controle;
import java.util.ArrayList;
import java.util.Iterator;
import com.jp1.persistencia.IModeloDao;
import com.jp1.persistencia.ModeloDao;
import com.jp1.persistencia.IMarcaDao;
import com.jp1.modelos.Modelo;
import com.jp1.modelos.Marca;
import com.jp1.tools.ID;

/**
 *
 * @author aluno
 */
public class ModeloControle implements IModeloControle{

    IModeloDao modeloPersistencia = null;

    public ModeloControle(){
        this.modeloPersistencia = new ModeloDao();
    }
    
    private boolean buscarModelo(String descricao) throws Exception{
        try {
            ArrayList<Modelo> listagem = modeloPersistencia.listar();
            Iterator<Modelo> lista = listagem.iterator();
            while(lista.hasNext()){
                Modelo aux = lista.next();
                if(aux.getDescricao().equalsIgnoreCase(descricao)){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            throw erro;
        }
    }

    public Marca buscar(String descricao) throws Exception{
        return modeloPersistencia.buscar(descricao);
    }

    public Marca buscar(int id) throws Exception{
        return modeloPersistencia.buscar(id);
    }

    private boolean verificarVazio(Modelo objeto){
        if(objeto.getDescricao().equals("") || objeto.getUrl().equals("")) return true;
        return false;
    }

    public void incluir(Modelo objeto) throws Exception{
        if(verificarVazio(objeto)) throw new Exception("Preencha os campos corretamente");
        if(buscarModelo(objeto.getDescricao())){
            throw new Exception("Modelo já cadastrado");
        }
        objeto.setId(ID.getID());
        modeloPersistencia.incluir(objeto);
    }

     public void alterar(Modelo objeto) throws Exception{
        if(verificarVazio(objeto)) throw new Exception("Preencha os campos corretamente");
        if(buscarModelo(objeto.getDescricao())){
            throw new Exception("Modelo já cadastrado");
        }
        modeloPersistencia.alterar(objeto);
    }

    public ArrayList<Modelo> listar() throws Exception{
        return modeloPersistencia.listar();
      
     }



}

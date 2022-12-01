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
    

    public ModeloControle(){
        this.modeloPersistencia = new ModeloDao();
    }
    IModeloDao modeloPersistencia = null;
    
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
    private boolean buscarModelo(Modelo objeto) throws Exception{
        try {
            ArrayList<Modelo> listagem = modeloPersistencia.listar();
            Iterator<Modelo> lista = listagem.iterator();
            while(lista.hasNext()){
                Modelo aux = lista.next();
                if(aux.getDescricao().equalsIgnoreCase(objeto.getDescricao()) && aux.getId() != objeto.getId()){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            throw erro;
        }
    }

    

    private String verificarVazio(Modelo objeto){
        String erro = "";
        boolean descricaovazia = false;
        if(objeto.getDescricao().equals("")){
            erro = "Preencha o campo de descrição";
            descricaovazia = true;
        }
        
        if(objeto.getUrl().equals("")){
            if(descricaovazia){
                erro += " e insira uma imagem";
            }else{
                erro = "Insira uma imagem";
            }
        }
        
//        if(objeto.getDescricao().equals("") || objeto.getUrl().equals("")){
//            if(objeto.getDescricao().equals(""))erro = "Preencha a descrição corretamente";
//            else if(objeto.getUrl().equals(""))erro = "Insira uma imagem";
//        }
        return erro;
    }
    
    @Override
    public void incluir(Modelo objeto) throws Exception{
        objeto.setDescricao(verificarDescricao(objeto.getDescricao()));
        if(!verificarVazio(objeto).equals("")) throw new Exception(verificarVazio(objeto));
        try{
            if(buscarModelo(objeto.getDescricao())){
                throw new Exception("Modelo já cadastrado");
            }
        }catch(Exception erro){
            if(erro.getMessage().contains("arquivo especificado")){  
            }else{
                  throw erro;
            }
        }
        objeto.setId(ID.getID());
        modeloPersistencia.incluir(objeto);
    }
    @Override
     public void alterar(Modelo objeto) throws Exception{
        objeto.setDescricao(verificarDescricao(objeto.getDescricao()));
        if(!verificarVazio(objeto).equals("")) throw new Exception(verificarVazio(objeto));
        if(buscarModelo(objeto)){
            throw new Exception("Modelo já cadastrado");
        }
        modeloPersistencia.alterar(objeto);
    }
    @Override
    public ArrayList<Modelo> listar() throws Exception{
        try{
            ArrayList<Modelo> modelos = modeloPersistencia.listar();
            Iterator<Modelo> array = modelos.iterator();
            Marca marca = new Marca();
            
            while(array.hasNext()){
                Modelo modelo = array.next();
                marca.buscar(modelo.getMarca().getId());
            }
            return modeloPersistencia.listar();
        }catch(Exception erro){
            modeloPersistencia.apagar();
            return new ArrayList<Modelo>();
        }
      
     }



}

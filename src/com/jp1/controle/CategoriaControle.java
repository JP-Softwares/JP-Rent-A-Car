/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.controle;
import com.jp1.modelos.Categoria;
import com.jp1.persistencia.ICategoriaDao;
import com.jp1.persistencia.CategoriaDao;
import java.util.ArrayList;
import java.util.Iterator;
import com.jp1.tools.ID;

/**
 *
 * @author aluno
 */
public class CategoriaControle implements ICategoriaControle{
    ICategoriaDao categoriaPersistencia = null;
    
    
    public CategoriaControle(){
        this.categoriaPersistencia = new CategoriaDao();
    }

    @Override
    public void incluir(Categoria objeto) throws Exception {
        objeto.setDescricao(verificarDescricao(objeto.getDescricao()));
        if(!verificarVazio(objeto).equals("")) throw new Exception(verificarVazio(objeto));
        try{
            if(buscarCategoria(objeto.getDescricao())){
                throw new Exception("Categoria já cadastrada");
            }
        }catch(Exception erro) {
            if(erro.getMessage().contains("arquivo especificado")){  
                
            }else{
                throw erro;
            }
        }
        objeto.setId(ID.getID());
        categoriaPersistencia.incluir(objeto);
    }

    @Override
    public void alterar(Categoria objeto) throws Exception {
        objeto.setDescricao(verificarDescricao(objeto.getDescricao()));
        if(!verificarVazio(objeto).equals("")) throw new Exception(verificarVazio(objeto));
        if(buscarCategoria(objeto)){
            throw new Exception("Categoria já cadastrada");
        }
        categoriaPersistencia.alterar(objeto);
        
    }

    @Override
    public ArrayList<Categoria> listar() throws Exception {
        try{
            return categoriaPersistencia.listar();
        }catch(Exception erro){
            return new ArrayList<Categoria>();
        }
    }

    @Override
    public Categoria buscar(String descricao) throws Exception {
        return categoriaPersistencia.buscar(descricao);
    }

    @Override
    public Categoria buscar(int id) throws Exception {
        return categoriaPersistencia.buscar(id);
    }

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

    private boolean buscarCategoria(Categoria objeto) throws Exception{
        try {
            ArrayList<Categoria> listagem = categoriaPersistencia.listar();
            Iterator<Categoria> lista = listagem.iterator();
            while(lista.hasNext()){
                Categoria aux = lista.next();
                System.out.println(aux.getDescricao());
                if(aux.getDescricao().equalsIgnoreCase(objeto.getDescricao()) && aux.getId() != objeto.getId()){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
           
            throw erro;
        }
    }
    private boolean buscarCategoria(String descricao) throws Exception{
        try {
            ArrayList<Categoria> listagem = categoriaPersistencia.listar();
            Iterator<Categoria> lista = listagem.iterator();
            while(lista.hasNext()){
                Categoria aux = lista.next();
                if(aux.getDescricao().equalsIgnoreCase(descricao)){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            throw erro;
        }
    }
    private String verificarVazio(Categoria objeto){
        String erro = "";
        if(objeto.getDescricao().equals("")){
            erro = "Preencha o campo de descrição";
        }
        return erro;
    }  
}

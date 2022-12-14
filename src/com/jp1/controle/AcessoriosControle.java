/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.controle;
import com.jp1.modelos.Acessorios;
import com.jp1.persistencia.AcessoriosDao;
import com.jp1.persistencia.IAcessoriosDao;
import java.util.ArrayList;
import java.util.Iterator;
import com.jp1.tools.ID;

/**
 *
 * @author aluno
 */
public class AcessoriosControle implements IAcessoriosControle {
    IAcessoriosDao acessoriosPersistencia = null;
    
    
    public AcessoriosControle(){
        this.acessoriosPersistencia = new AcessoriosDao();
    }

    @Override
    public void incluir(Acessorios objeto) throws Exception {
        objeto.setDescricao(verificarDescricao(objeto.getDescricao()));
        if(!verificarVazio(objeto).equals("")) throw new Exception(verificarVazio(objeto));
        try{
            if(buscarAcessorios(objeto.getDescricao())){
                throw new Exception("Acessorio já cadastrado");
            }
        }catch(Exception erro) {
            if(erro.getMessage().contains("arquivo especificado")){  
                
            }else{
                throw erro;
            }
        }
        objeto.setId(ID.getID());
        acessoriosPersistencia.incluir(objeto);
    }

    @Override
    public void alterar(Acessorios objeto) throws Exception {
        objeto.setDescricao(verificarDescricao(objeto.getDescricao()));
        if(!verificarVazio(objeto).equals("")) throw new Exception(verificarVazio(objeto));
        if(buscarAcessorios(objeto)){
            throw new Exception("Acessorio já cadastrado");
        }
        if(objeto.getQuantidadeTotal() < buscar(objeto.getId()).getQuantidadeLocada()) throw new Exception("O numero de unidades totais não pode ser menor do que o numero de unidades locadas");
        acessoriosPersistencia.alterar(objeto);
        
    }

    @Override
    public ArrayList<Acessorios> listar() throws Exception {
        try{
            return acessoriosPersistencia.listar();
        }catch(Exception erro){
            return new ArrayList<Acessorios>();
        }
    }

    @Override
    public Acessorios buscar(String descricao) throws Exception {
        return acessoriosPersistencia.buscar(descricao);
    }

    @Override
    public Acessorios buscar(int id) throws Exception {
        return acessoriosPersistencia.buscar(id);
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

    private boolean buscarAcessorios(Acessorios objeto) throws Exception{
        try {
            ArrayList<Acessorios> listagem = listar();
            Iterator<Acessorios> lista = listagem.iterator();
            while(lista.hasNext()){
                Acessorios aux = lista.next();
                if(aux.getDescricao().equalsIgnoreCase(objeto.getDescricao()) && aux.getId() != objeto.getId()){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
           
            throw erro;
        }
    }
    private boolean buscarAcessorios(String descricao) throws Exception{
        try {
            ArrayList<Acessorios> listagem = listar();
            Iterator<Acessorios> lista = listagem.iterator();
            while(lista.hasNext()){
                Acessorios aux = lista.next();
                if(aux.getDescricao().equalsIgnoreCase(descricao)){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            throw erro;
        }
    }
    private String verificarVazio(Acessorios objeto){
        String erro = "";
        if(objeto.getDescricao().equals("")){
            erro = "Preencha o campo de descrição";
        }
        return erro;
    }
}

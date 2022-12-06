/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.controle;

import com.jp1.modelos.Veiculo;
import com.jp1.persistencia.IVeiculoDao;
import com.jp1.persistencia.VeiculoDao;
import java.util.ArrayList;
import java.util.Iterator;

import com.jp1.tools.ID;

/**
 *
 * @author aluno
 */
public class VeiculoControle implements IVeiculoControle{
    IVeiculoDao veiculoPersistencia = null;
    
    
    public VeiculoControle(){
        this.veiculoPersistencia = new VeiculoDao();
    }

    @Override
    public void incluir(Veiculo objeto) throws Exception {
        try {
            verificarCampos(objeto);
            buscarPlacaVeiculo(objeto);
            buscarRenavamVeiculo(objeto);
        } catch (Exception e) {
            throw e;
        }
        objeto.setId(ID.getID());
        veiculoPersistencia.incluir(objeto);
        
    }

    @Override
    public void alterar(Veiculo objeto) throws Exception {
        try {
            verificarCampos(objeto);
            buscarPlacaVeiculo(objeto);
            buscarRenavamVeiculo(objeto);
        } catch (Exception e) {
            throw e;
        }
        veiculoPersistencia.alterar(objeto);
        
    }

    @Override
    public ArrayList<Veiculo> listar() throws Exception {
        try{
            return veiculoPersistencia.listar();
        }catch(Exception erro){
            return new ArrayList<Veiculo>();
        }
        
    }

    @Override
    public Veiculo buscar(int id) throws Exception {
        return veiculoPersistencia.buscar(id);
    }

    private boolean buscarPlacaVeiculo(Veiculo objeto) throws Exception{
        try {
            ArrayList<Veiculo> listagem = veiculoPersistencia.listar();
            Iterator<Veiculo> lista = listagem.iterator();
            while(lista.hasNext()){
                Veiculo aux = lista.next();
                if(aux.getPlaca().equalsIgnoreCase(objeto.getPlaca()) && aux.getId() != objeto.getId()){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
           
            throw erro;
        }
    }

    private boolean buscarRenavamVeiculo(Veiculo objeto) throws Exception{
        try {
            ArrayList<Veiculo> listagem = veiculoPersistencia.listar();
            Iterator<Veiculo> lista = listagem.iterator();
            while(lista.hasNext()){
                Veiculo aux = lista.next();
                if(aux.getRenavam() == objeto.getRenavam() && aux.getId() != objeto.getId()){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
           
            throw erro;
        }
    }

    private boolean verificarCampos(Veiculo objeto) throws Exception{
        if((objeto.getPlaca()).length() < 7) throw new Exception("A placa informada é invalida, por favor digite uma placa com 7 digitos");
        if(objeto.getRenavam() < 100000000) throw new Exception("O Renavam informado é invalido, por favor digite um Renavam com 9 digitos");
        if(objeto.getAnoFabricacao() < 1950) throw new Exception("O ano de fabricação informado é inválido, por favor digite um ano de fabricação válido");
        if(objeto.getAnoModelo() < 1950) throw new Exception("O ano do modelo informado é inválido, por favor digite um ano de modelo válido");
        if(objeto.getQuilometragem() < 0) throw new Exception("Por favor digite uma quilometragem válida");
        return true;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.controle;

import static com.jp1.controle.MotoristaControle.verificarCampos;
import com.jp1.modelos.Locacao;
import com.jp1.modelos.Motorista;
import com.jp1.modelos.TipoDoCliente;
import com.jp1.persistencia.AcessoriosDao;
import com.jp1.persistencia.IAcessoriosDao;
import com.jp1.persistencia.ILocacaoDao;
import com.jp1.persistencia.IMotoristaDao;
import com.jp1.persistencia.LocacaoDao;
import com.jp1.persistencia.MotoristaDao;
import com.jp1.tools.Data;

import static com.jp1.tools.Data.dataCNH;
import com.jp1.tools.ID;
import java.util.ArrayList;


/**
 *
 * @author aluno
 */
public class LocacaoControle implements ILocacaoControle {
    ILocacaoDao locacaoPersistencia = null;
    MotoristaControle motoristaControle = null;
    IAcessoriosDao acessoriosPersistencia = null;
    
    public LocacaoControle(){
        this.locacaoPersistencia = new LocacaoDao();
        this.motoristaControle = new MotoristaControle();
        this.acessoriosPersistencia = new AcessoriosDao();
    }


    

    @Override
    public void incluir(Locacao locacao) throws Exception {
        locacao.setId(ID.getID());
        locacaoPersistencia.incluir(locacao);
    }

    @Override
    public void alterar(Locacao locacao) throws Exception {
        verificarCampos(locacao);
        motoristaControle.verificarCampos(locacao.getMotorista());
        verificarMotorista(locacao.getMotorista(), locacao);
        locacao.setId(ID.getID());
        locacaoPersistencia.alterar(locacao);
    }

    @Override
    public ArrayList<Locacao> listar() throws Exception {
        try{
            return locacaoPersistencia.listar();
        }catch(Exception erro){
            return new ArrayList<Locacao>();
        }
    }
    
    @Override
    public ArrayList<Locacao> listarRelacionados(String cpf_cnpj) throws Exception{
        try{
            return locacaoPersistencia.listarRelacionados(cpf_cnpj);
        }catch(Exception erro){
            return new ArrayList<Locacao>();
        }
    }

    @Override
    public Locacao buscar(int id) throws Exception {
        return locacaoPersistencia.buscar(id);
    }
    
    public static boolean verificarMotorista(Motorista motorista, Locacao Locacao) throws Exception{
        try{
            if(dataCNH(motorista.getDataVencimento(), Locacao.getDataFim())) return true;
            else return false;
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    public boolean verificarCampos(Locacao objeto)throws Exception {
        if(objeto.getCliente() == null) throw new Exception("O cliente informado não está cadastrado");
        if(!objeto.getDataInicio().eData() || !objeto.getDataFim().eData()) throw new Exception("Insira uma data válida.");
        if(Integer.parseInt(objeto.getDataInicio().getAno()) < 2000 || Integer.parseInt(objeto.getDataInicio().getMes()) < 1 || Integer.parseInt(objeto.getDataInicio().getMes()) > 12 || Integer.parseInt(objeto.getDataInicio().getDia()) < 1 || Integer.parseInt(objeto.getDataInicio().getDia()) > 31 || (new Data("14/12/2022")).toInt() > objeto.getDataInicio().toInt()) throw new Exception("A data de inicio informada é inválida");
        if(Integer.parseInt(objeto.getDataFim().getAno()) < 2000 || Integer.parseInt(objeto.getDataFim().getMes()) < 1 || Integer.parseInt(objeto.getDataFim().getMes()) > 12 || Integer.parseInt(objeto.getDataFim().getDia()) < 1 || Integer.parseInt(objeto.getDataFim().getDia()) > 31 ) throw new Exception("A data de fim informada é inválida");
        if(objeto.getDataInicio().toInt() > (objeto.getDataFim()).toInt())throw new Exception("A data fim é menor do que data inicio");
        return true;
    }
}

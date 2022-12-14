/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.controle;
import com.jp1.tools.*;

/**
 *
 * @author aluno
 */
public class MotoristaControle implements IMotoristaControle {
    IMotoristaDao motoristaPersistencia = null;
    
    
    public MotoristaControle(){
        this.motoristaPersistencia = new MotoristaDao();
    }
    @Override
    public void incluir(Motorista objeto) throws Exception{
        verificarCampos(objeto);
        objeto.setId(ID.getID());
        motoristaPersistencia.incluir(objeto);
    }

    @Override
    public void alterar(Motorista objeto) throws Exception {
        verificarCampos(objeto);
        motoristaPersistencia.alterar(objeto);
    }

    @Override
    public ArrayList<Motorista> listar() throws Exception {
        try{
            return motoristaPersistencia.listar();
        }catch(Exception erro){
            return new ArrayList<Motorista>();
        }
        
    }

    @Override
    public Motorista buscar(int id) throws Exception{
        return motoristaPersistencia.buscar(id);
    }

    @Override
    public Motorista buscar(String numeroCNH) throws Exception{
        return motoristaPersistencia.buscar(numeroCNH);
    }
    public static boolean verificarCampos(Motorista objeto) throws Exception{  
        if((objeto.getNumeroCNH).length < 9) throw new Exception("Numero de CNH inválido!!");
        if((objeto.getUrlImagemCNH).length < 1) throw new Exception("Insira uma imagem da CNH");
        if((objeto.getNome).length < 1) throw new Exception("Insira um nome para o motorista!");
        if((objeto.getDataVencimento).length != 10); throw new Exception("Preencha o campo de data de vencimento da CNH corretamente");
        if(objeto.getEndereco().getBairro().length() < 1) throw new Exception("O bairro informado para o motorista é inválido, por favor digite um bairro válido!!");
        if(objeto.getEndereco().getCEP().length() != 9) throw new Exception("O CEP informado para o motorista é inválido, por favor digite um CEP válido!!");
        if(objeto.getEndereco().getCidade().length() <1 ) throw new Exception("A cidade informada para o motorista é inválida, por favor digite uma cidade válida!!");
        if(objeto.getEndereco().getComplemento().length() <1 ) throw new Exception("O complemento informado para o motorista é inválido, por favor digite um complemento válido!!");
        if(objeto.getEndereco().getLogradouro().length() <1 ) throw new Exception("O logradouro informado para o motorista é inválido, por favor digite um logradouro válido!!");
        if(objeto.getTelefone().getDDD() < 11) throw new Exception("O DDD informado para o motorista é inválido, por favor digite um DDD válido!!");
        if(objeto.getTelefone().getDDI() < 1) throw new Exception("O DDI informado para o motorista é inválido, por favor digite um DDI válido!!");
        if(objeto.getTelefone().getNumero() < 10000000) throw new Exception("O telefone informado para o motorista é inválido, por favor digite um telefone válido!!");

    }

    

}

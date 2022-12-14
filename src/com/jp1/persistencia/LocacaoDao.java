/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.persistencia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.jp1.tools.Data;
import com.jp1.modelos.SituacaoDoVeiculo;
import com.jp1.modelos.Locacao;
import com.jp1.controle.*;

import java.io.File;

/**
 *
 * @author aluno
 */
public class LocacaoDao implements ILocacaoDao {

    String nomeDoArquivoNoDisco = "./src/com/jp1/arquivosdedados/locacao.txt";
    
    public LocacaoDao(){

    }

    @Override
    public void incluir(Locacao objeto) throws Exception {
        try {
            FileWriter fw = new FileWriter(new File(nomeDoArquivoNoDisco), true);
            BufferedWriter bw  = new BufferedWriter(fw);
            bw.write(objeto.toString());
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Locacao objeto) throws Exception {
        FileReader fr = new FileReader(new File(nomeDoArquivoNoDisco));
        BufferedReader br = new BufferedReader(fr);
        String linha = "";
        String banco = "";
        while((linha = br.readLine()) != null){
            if(linha.split(";")[0].equals(objeto.getId()+"")){
                banco+= objeto.toString();
            }else{
                banco+= linha + "\n";
            }
        }
        br.close();
        FileWriter fw = new FileWriter(new File(nomeDoArquivoNoDisco));
        BufferedWriter bw  = new BufferedWriter(fw);
        bw.write(banco);
        bw.close();
    }

    @Override
    public ArrayList<Locacao> listar() throws Exception {
        try {
            ArrayList<Locacao> listaDeMarcas = new ArrayList<Locacao>();
            FileReader fr = new FileReader(new File(nomeDoArquivoNoDisco));
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while((linha = br.readLine()) != null){
                Locacao objetoLocacao = new Locacao();
                String vetorString[] = linha.split(";");
                IMotoristaControle motoristaControle = new MotoristaControle();
                IClienteControle clienteControle = new ClienteControle();
                IVeiculoControle veiculoControle = new VeiculoControle();
                IAcessoriosControle acessoriosControle = new AcessoriosControle();
                objetoLocacao.setId(Integer.parseInt(vetorString[0]));
                objetoLocacao.setDataInicio(new Data((vetorString[1]).split("/")));
                objetoLocacao.setDataFim(new Data((vetorString[2]).split("/")));
                objetoLocacao.setValorDaLocacao(Float.parseFloat(vetorString[3]));
                objetoLocacao.setSituacao(SituacaoDoVeiculo.valueOf(vetorString[4]));
                try {
                    objetoLocacao.setMotorista(motoristaControle.buscar(Integer.parseInt(vetorString[5])));
                    objetoLocacao.setCliente(clienteControle.buscar(Integer.parseInt(vetorString[6])));
                    objetoLocacao.setVeiculo(veiculoControle.buscar(Integer.parseInt(vetorString[7])));
                    objetoLocacao.setAcessorios(acessoriosControle.buscar(Integer.parseInt(vetorString[8])));
                } catch (Exception e) {
                    throw e;
                }
                listaDeMarcas.add(objetoLocacao);
            }
            br.close();
            return listaDeMarcas;
        } catch (Exception erro) {
            throw erro;
        }
    }   
    @Override
    public Locacao buscar(int id) throws Exception {
         try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr); 

            String vetorString[] = null;
            String texto = "";
            Locacao objetoLocacao = new Locacao();
            IMotoristaControle motoristaControle = new MotoristaControle();
            IClienteControle clienteControle = new ClienteControle();
            IVeiculoControle veiculoControle = new VeiculoControle();
            IAcessoriosControle acessoriosControle = new AcessoriosControle();
            while(!(vetorString = br.readLine().split(";"))[0].equals(id+""));
                objetoLocacao.setId(Integer.parseInt(vetorString[0]));
                objetoLocacao.setDataInicio(new Data((vetorString[1]).split("/")));
                objetoLocacao.setDataFim(new Data((vetorString[2]).split("/")));
                objetoLocacao.setValorDaLocacao(Float.parseFloat(vetorString[3]));
                objetoLocacao.setSituacao(SituacaoDoVeiculo.valueOf(vetorString[4]));
                try {
                    objetoLocacao.setMotorista(motoristaControle.buscar(Integer.parseInt(vetorString[5])));
                    objetoLocacao.setCliente(clienteControle.buscar(Integer.parseInt(vetorString[6])));
                    objetoLocacao.setVeiculo(veiculoControle.buscar(Integer.parseInt(vetorString[7])));
                    objetoLocacao.setAcessorios(acessoriosControle.buscar(Integer.parseInt(vetorString[8])));
                } catch (Exception e) {
                    throw e;
                }
                br.close();
            return objetoLocacao;
            
        } catch (Exception erro) {  
            throw erro;
        }
    }
    @Override
    public Locacao buscar(String placa) throws Exception {
         try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr); 

            String vetorString[] = null;
            String texto = "";
            Locacao objetoLocacao = new Locacao();
            IMotoristaControle motoristaControle = new MotoristaControle();
            IClienteControle clienteControle = new ClienteControle();
            IVeiculoControle veiculoControle = new VeiculoControle();
            IAcessoriosControle acessoriosControle = new AcessoriosControle();
            while(!(vetorString = br.readLine().split(";"))[7].equals(veiculoControle.buscar(placa).getID));
                objetoLocacao.setId(Integer.parseInt(vetorString[0]));
                objetoLocacao.setDataInicio(new Data((vetorString[1]).split("/")));
                objetoLocacao.setDataFim(new Data((vetorString[2]).split("/")));
                objetoLocacao.setValorDaLocacao(Float.parseFloat(vetorString[3]));
                objetoLocacao.setSituacao(SituacaoDoVeiculo.valueOf(vetorString[4]));
                try {
                    objetoLocacao.setMotorista(motoristaControle.buscar(Integer.parseInt(vetorString[5])));
                    objetoLocacao.setCliente(clienteControle.buscar(Integer.parseInt(vetorString[6])));
                    objetoLocacao.setVeiculo(veiculoControle.buscar(Integer.parseInt(vetorString[7])));
                    objetoLocacao.setAcessorios(acessoriosControle.buscar(Integer.parseInt(vetorString[8])));
                } catch (Exception e) {
                    throw e;
                }
                br.close();
            return objetoLocacao;
            
        } catch (Exception erro) {  
            throw erro;
        }
    }

    public static boolean estaLocado(String placa, Data inicio, Data fim) throws Exception{
        try{
            buscar(placa).getData
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.persistencia;

import com.jp1.modelos.Cliente;
import com.jp1.modelos.Endereco;
import com.jp1.modelos.TipoDoCliente;
import com.jp1.modelos.Telefone;
import com.jp1.modelos.Estado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import java.io.File;

/**
 *
 * @author aluno
 */
public class ClienteDao implements IClienteDao {

    String nomeDoArquivoNoDisco = "./src/com/jp1/arquivosdedados/cliente.txt";

    public ClienteDao(){

    }

    @Override
    public void incluir(Cliente objeto) throws Exception,FileNotFoundException,Exception {

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
    public void alterar(Cliente objeto) throws Exception,FileNotFoundException,Exception {
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
    public ArrayList<Cliente> listar() throws Exception,FileNotFoundException,Exception {
        
        try {
            ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
            FileReader fr = new FileReader(new File(nomeDoArquivoNoDisco));
            BufferedReader br = new BufferedReader(fr);

             String linha = "";

              while((linha = br.readLine()) != null){
                    Cliente objetoCliente = new Cliente();
                    String vetorString[] = linha.split(";");
                    objetoCliente.setId(Integer.parseInt(vetorString[0]));
                    objetoCliente.setCpf_cnpj(vetorString[1]);
                    objetoCliente.setNome(vetorString[2]);
                    objetoCliente.setRazaoSocial(vetorString[3]);
                    objetoCliente.setIdentidade(vetorString[4]);
                    Telefone telefone = new Telefone();
                        telefone.setDDD(Integer.parseInt(vetorString[5]));
                        telefone.setDDI(Integer.parseInt(vetorString[6]));
                        telefone.setNumero(Integer.parseInt(vetorString[7]));
                    objetoCliente.setTelefone(telefone);
                    objetoCliente.setEmail(vetorString[8]);
                    Endereco endereco = new Endereco();
                        endereco.setLogradouro(vetorString[9]);
                        endereco.setComplemento(vetorString[10]);
                        endereco.setCEP(vetorString[11]);
                        endereco.setEstado(Estado.valueOf(vetorString[12]));
                        endereco.setCidade(vetorString[13]);
                        endereco.setBairro(vetorString[14]);
                    objetoCliente.setEndereco(endereco);
                    objetoCliente.setTipo(TipoDoCliente.valueOf(vetorString[15]));
                    listaDeClientes.add(objetoCliente);



            }
            br.close();
            return listaDeClientes;
        } catch (Exception erro) {
            throw erro; 
        }
       
    }
    

    @Override
    public Cliente buscar(int id) throws Exception,FileNotFoundException,Exception {
       
        
        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr); 

            String vetorString[] = null;

            Cliente objetoCliente = new Cliente();
            while(!(vetorString = br.readLine().split(";"))[0].equals(id+""));
                objetoCliente.setId(Integer.parseInt(vetorString[0]));
                objetoCliente.setCpf_cnpj(vetorString[1]);
                objetoCliente.setNome(vetorString[2]);
                objetoCliente.setRazaoSocial(vetorString[3]);
                objetoCliente.setIdentidade(vetorString[4]);
                Telefone telefone = new Telefone();
                    telefone.setDDD(Integer.parseInt(vetorString[5]));
                    telefone.setDDI(Integer.parseInt(vetorString[6]));
                    telefone.setNumero(Integer.parseInt(vetorString[7]));
                objetoCliente.setTelefone(telefone);
                objetoCliente.setEmail(vetorString[8]);
                Endereco endereco = new Endereco();
                    endereco.setLogradouro(vetorString[9]);
                    endereco.setComplemento(vetorString[10]);
                    endereco.setCEP(vetorString[11]);
                    endereco.setEstado(Estado.valueOf(vetorString[12]));
                    endereco.setCidade(vetorString[13]);
                    endereco.setBairro(vetorString[14]);
                objetoCliente.setEndereco(endereco);
                objetoCliente.setTipo(TipoDoCliente.valueOf(vetorString[15]));


            br.close();  
            return objetoCliente;
            
        } catch (Exception erro) {  
            throw erro;
        }
       
    }
    
    @Override
    public Cliente buscar(String cpf_cnpj) throws Exception,FileNotFoundException,Exception {
       
        
        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr); 

            String vetorString[] = null;

            Cliente objetoCliente = new Cliente();
            while(!(vetorString = br.readLine().split(";"))[1].equals(cpf_cnpj));
                objetoCliente.setId(Integer.parseInt(vetorString[0]));
                objetoCliente.setCpf_cnpj(vetorString[1]);
                objetoCliente.setNome(vetorString[2]);
                objetoCliente.setRazaoSocial(vetorString[3]);
                objetoCliente.setIdentidade(vetorString[4]);
                Telefone telefone = new Telefone();
                    telefone.setDDD(Integer.parseInt(vetorString[5]));
                    telefone.setDDI(Integer.parseInt(vetorString[6]));
                    telefone.setNumero(Integer.parseInt(vetorString[7]));
                objetoCliente.setTelefone(telefone);
                objetoCliente.setEmail(vetorString[8]);
                Endereco endereco = new Endereco();
                    endereco.setLogradouro(vetorString[9]);
                    endereco.setComplemento(vetorString[10]);
                    endereco.setCEP(vetorString[11]);
                    endereco.setEstado(Estado.valueOf(vetorString[12]));
                    endereco.setCidade(vetorString[13]);
                    endereco.setBairro(vetorString[14]);
                objetoCliente.setEndereco(endereco);
                objetoCliente.setTipo(TipoDoCliente.valueOf(vetorString[15]));


            br.close();  
            return objetoCliente;
            
        } catch (Exception erro) {  
            throw erro;
        }
       
    }


    }
    
    


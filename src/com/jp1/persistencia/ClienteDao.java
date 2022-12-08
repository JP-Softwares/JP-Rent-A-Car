/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.persistencia;

import com.jp1.modelos.Cliente;
import com.jp1.modelos.Endereco;
import com.jp1.modelos.TipoDoCliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public void incluir(Cliente objeto) throws Exception {

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
    public void alterar(Cliente objeto) throws Exception {
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
    public ArrayList<Cliente> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
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
                //objetoCliente.setTelefone(null);
                objetoCliente.setEmail(vetorString[6]);
                objetoCliente.setEndereco(Endereco.valueOf(vetorString[7]));
                objetoCliente.setTipo(TipoDoCliente.valueOf(vetorString[8]));



                
                
                listaDeClientes.add(objetoCliente);



            }
            br.close();
            return listaDeClientes;
        } catch (Exception erro) {
            throw erro; 
        }
       
    }
    }

    @Override
    public Cliente buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

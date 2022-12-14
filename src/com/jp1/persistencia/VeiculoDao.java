/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.persistencia;


import com.jp1.modelos.Veiculo;



import com.jp1.modelos.TipoDoCombustivel;
import com.jp1.modelos.TipoDoVeiculo;
import com.jp1.controle.IModeloControle;
import com.jp1.controle.ICategoriaControle;
import com.jp1.controle.ModeloControle;
import com.jp1.controle.CategoriaControle;
import com.jp1.modelos.SituacaoDoVeiculo;
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
public class VeiculoDao implements IVeiculoDao {

     String nomeDoArquivoNoDisco = "./src/com/jp1/arquivosdedados/veiculo.txt";
     

     public VeiculoDao(){

     }



    @Override
  public void incluir(Veiculo objeto) throws IOException,FileNotFoundException,Exception {

      try {
            System.out.println(new File(nomeDoArquivoNoDisco).exists());
            FileWriter fw = new FileWriter(new File(nomeDoArquivoNoDisco), true);
            BufferedWriter bw  = new BufferedWriter(fw);
            bw.write(objeto.toString());
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }


    @Override
    public void alterar(Veiculo objeto) throws Exception,FileNotFoundException,Exception {

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
    public ArrayList<Veiculo> listar() throws IOException,FileNotFoundException,Exception {

         try {
            ArrayList<Veiculo> listaDeVeiculos = new ArrayList<Veiculo>();
            FileReader fr = new FileReader(new File(nomeDoArquivoNoDisco));
            BufferedReader br = new BufferedReader(fr);

             String linha = "";

              while((linha = br.readLine()) != null){
                Veiculo objetoVeiculo = new Veiculo();
                String vetorString[] = linha.split(";");
                objetoVeiculo.setId(Integer.parseInt(vetorString[0]));
                objetoVeiculo.setPlaca(vetorString[1]);
                objetoVeiculo.setRenavam(vetorString[2]);
                ICategoriaControle categoriaControle = new CategoriaControle();
                objetoVeiculo.setCategoria(categoriaControle.buscar(Integer.parseInt(vetorString[3])));
                objetoVeiculo.setPrecoDeCompra(Float.parseFloat(vetorString[4]));
                objetoVeiculo.setPrecoDeVenda(Float.parseFloat(vetorString[5]));
                objetoVeiculo.setAnoFabricacao(Integer.parseInt(vetorString[6]));
                objetoVeiculo.setAnoModelo(Integer.parseInt(vetorString[7]));
                objetoVeiculo.setKilometragem(Integer.parseInt(vetorString[8]));
                objetoVeiculo.setCombustivel(TipoDoCombustivel.valueOf(vetorString[9]));
                objetoVeiculo.setCarro(TipoDoVeiculo.valueOf(vetorString[10]));
                objetoVeiculo.setSituacao(SituacaoDoVeiculo.valueOf(vetorString[11]));
                IModeloControle modeloControle = new ModeloControle();
                objetoVeiculo.setModelo(modeloControle.buscar(Integer.parseInt(vetorString[12])));
                listaDeVeiculos.add(objetoVeiculo);



            }
            br.close();
            return listaDeVeiculos;
        } catch (Exception erro) {
            throw erro; 
        }
       
    }

    public ArrayList<Veiculo> listarNaoLocados(Data inicio, Data fim) throws IOException,FileNotFoundException,Exception {

         try {
            ArrayList<Veiculo> listaDeVeiculos = new ArrayList<Veiculo>();
            FileReader fr = new FileReader(new File(nomeDoArquivoNoDisco));
            BufferedReader br = new BufferedReader(fr);

             String linha = "";

              while((linha = br.readLine()) != null){
                Veiculo objetoVeiculo = new Veiculo();
                String vetorString[] = linha.split(";");
                objetoVeiculo.setId(Integer.parseInt(vetorString[0]));
                objetoVeiculo.setPlaca(vetorString[1]);
                objetoVeiculo.setRenavam(vetorString[2]);
                ICategoriaControle categoriaControle = new CategoriaControle();
                objetoVeiculo.setCategoria(categoriaControle.buscar(Integer.parseInt(vetorString[3])));
                objetoVeiculo.setPrecoDeCompra(Float.parseFloat(vetorString[4]));
                objetoVeiculo.setPrecoDeVenda(Float.parseFloat(vetorString[5]));
                objetoVeiculo.setAnoFabricacao(Integer.parseInt(vetorString[6]));
                objetoVeiculo.setAnoModelo(Integer.parseInt(vetorString[7]));
                objetoVeiculo.setKilometragem(Integer.parseInt(vetorString[8]));
                objetoVeiculo.setCombustivel(TipoDoCombustivel.valueOf(vetorString[9]));
                objetoVeiculo.setCarro(TipoDoVeiculo.valueOf(vetorString[10]));
                objetoVeiculo.setSituacao(SituacaoDoVeiculo.valueOf(vetorString[11]));
                IModeloControle modeloControle = new ModeloControle();
                objetoVeiculo.setModelo(modeloControle.buscar(Integer.parseInt(vetorString[12])));
                if(estaLocado(objetoVeiculo.getPlaca, inicio, fim))
                else listaDeVeiculos.add(objetoVeiculo);



            }
            br.close();
            return listaDeVeiculos;
        } catch (Exception erro) {
            throw erro; 
        }
       
    }

    @Override
    public Veiculo buscar(String placa) throws IOException,FileNotFoundException,Exception {
       try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr); 

            String vetorString[] = null;

            Veiculo objetoVeiculo = new Veiculo();
            while(!(vetorString = br.readLine().split(";"))[1].equals(placa));
                objetoVeiculo.setId(Integer.parseInt(vetorString[0]));
                objetoVeiculo.setPlaca(vetorString[1]);
                objetoVeiculo.setRenavam(vetorString[2]);
                ICategoriaControle categoriaControle = new CategoriaControle();
                objetoVeiculo.setCategoria(categoriaControle.buscar(Integer.parseInt(vetorString[3])));
                objetoVeiculo.setPrecoDeCompra(Float.parseFloat(vetorString[4]));
                objetoVeiculo.setPrecoDeVenda(Float.parseFloat(vetorString[5]));
                objetoVeiculo.setAnoFabricacao(Integer.parseInt(vetorString[6]));
                objetoVeiculo.setAnoModelo(Integer.parseInt(vetorString[7]));
                objetoVeiculo.setKilometragem(Integer.parseInt(vetorString[8]));
                objetoVeiculo.setCombustivel(TipoDoCombustivel.valueOf(vetorString[9]));
                objetoVeiculo.setCarro(TipoDoVeiculo.valueOf(vetorString[10]));
                objetoVeiculo.setSituacao(SituacaoDoVeiculo.valueOf(vetorString[11]));
                IModeloControle modeloControle = new ModeloControle();
                objetoVeiculo.setModelo(modeloControle.buscar(Integer.parseInt(vetorString[12])));
             
            br.close();
            return objetoVeiculo;
            
        } catch (Exception erro) {  
            throw erro;
        }
       
    }
    

    @Override
    public Veiculo buscar(int id) throws IOException,FileNotFoundException,Exception {

        try {
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr); 

            String vetorString[] = null;

            Veiculo objetoVeiculo = new Veiculo();
            while(!(vetorString = br.readLine().split(";"))[0].equals(id+""));
             objetoVeiculo.setId(Integer.parseInt(vetorString[0]));
             objetoVeiculo.setPlaca(vetorString[1]);
             objetoVeiculo.setRenavam(vetorString[2]);
             ICategoriaControle categoriaControle = new CategoriaControle();
             objetoVeiculo.setCategoria(categoriaControle.buscar(Integer.parseInt(vetorString[3])));
             objetoVeiculo.setPrecoDeCompra(Float.parseFloat(vetorString[4]));
             objetoVeiculo.setPrecoDeVenda(Float.parseFloat(vetorString[5]));
             objetoVeiculo.setAnoFabricacao(Integer.parseInt(vetorString[6]));
             objetoVeiculo.setAnoModelo(Integer.parseInt(vetorString[7]));
             objetoVeiculo.setKilometragem(Integer.parseInt(vetorString[8]));
             objetoVeiculo.setCombustivel(TipoDoCombustivel.valueOf(vetorString[9]));
             objetoVeiculo.setCarro(TipoDoVeiculo.valueOf(vetorString[10]));
             objetoVeiculo.setSituacao(SituacaoDoVeiculo.valueOf(vetorString[11]));
             IModeloControle modeloControle = new ModeloControle();
             objetoVeiculo.setModelo(modeloControle.buscar(Integer.parseInt(vetorString[12])));

            br.close();
            return objetoVeiculo;
            
        } catch (Exception erro) {  
            throw erro;
        }
       
    }
    
}

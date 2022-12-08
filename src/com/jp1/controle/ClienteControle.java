/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.controle;
import com.jp1.modelos.Cliente;
import java.util.ArrayList;
import java.util.Iterator;
import com.jp1.tools.ID;
import com.jp1.persistencia.IClienteDao;
import com.jp1.persistencia.ClienteDao;


/**
 *
 * @author aluno
 */
public class ClienteControle implements IClienteControle {
    
    IClienteDao clientePersistencia = null;
    
    
    public ClienteControle(){
        this.clientePersistencia = new ClienteDao();
    }

    @Override
    public void incluir(Cliente objeto) throws Exception {
        objeto.setId(ID.getID());
        clientePersistencia.incluir(objeto);
    }

    @Override
    public void alterar(Cliente objeto) throws Exception {

        clientePersistencia.alterar(objeto);
        
    }

    @Override
    public ArrayList<Cliente> listar() throws Exception {
        try{
            return clientePersistencia.listar();
        }catch(Exception erro){
            return new ArrayList<Cliente>();
        }
        
    }

    @Override
    public Cliente buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

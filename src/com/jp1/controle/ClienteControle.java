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
import com.jp1.modelos.TipoDoCliente;
import java.util.InputMismatchException;
import com.jp1.tools.Numero;
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
        verificarCampos(objeto);
        objeto.setId(ID.getID());
        clientePersistencia.incluir(objeto);
    }

    @Override
    public void alterar(Cliente objeto) throws Exception {
        verificarCampos(objeto);
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
        return clientePersistencia.buscar(id);
    }
    
    private boolean verificarCampos(Cliente objeto) throws Exception{
        if(objeto.getTipo() == TipoDoCliente.PESSOAFISICA){
            if(!validarCPF(Numero.numerosSemPonto(objeto.getCpf_cnpj())))throw new Exception("O CPF informado é inválido!!");
            if(objeto.getIdentidade().length() < 6) throw new Exception("O RG informado é inválido!!");
            if(objeto.getNome().length() < 6) throw new Exception("O nome informado é inválido, por favor digite um nome com pelo menos 6 digitos!!");
        }
        if(objeto.getTipo() == TipoDoCliente.PESSOAJURIDICA){
            if(!validarCNPJ(Numero.numerosSemPonto(objeto.getCpf_cnpj())))throw new Exception("O CNPJ informado é inválido!!");
            if(objeto.getRazaoSocial().length() < 6) throw new Exception("A razão social informada é inválida, por favor digite uma razão social com pelo menos 6 digitos!!");
        }
        if(!objeto.getEmail().contains("@") || !objeto.getEmail().contains(".com") || objeto.getEmail().length() < 6 ) throw new Exception("O email informado é inválido, por favor digite um email válido!!");
        if(objeto.getEndereco().getBairro().length() < 1) throw new Exception("O bairro informado é inválido, por favor digite um bairro válido!!");
        if(objeto.getEndereco().getCEP().length() != 9) throw new Exception("O CEP informado é inválido, por favor digite um CEP válido!!");
        if(objeto.getEndereco().getCidade().length() <1 ) throw new Exception("A cidade informada é inválida, por favor digite uma cidade válida!!");
        if(objeto.getEndereco().getComplemento().length() <1 ) throw new Exception("O complemento informado é inválido, por favor digite um complemento válido!!");
        if(objeto.getEndereco().getLogradouro().length() <1 ) throw new Exception("O logradouro informado é inválido, por favor digite um logradouro válido!!");
        if(objeto.getTelefone().getDDD() < 11) throw new Exception("O DDD informado é inválido, por favor digite um DDD válido!!");
        if(objeto.getTelefone().getDDI() < 1) throw new Exception("O DDI informado é inválido, por favor digite um DDI válido!!");
        if(objeto.getTelefone().getNumero() > 9  || objeto.getTelefone().getNumero() < 8) throw new Exception("O telefone informado é inválido, por favor digite um telefone válido!!");
        return true;
    }

    private boolean validarCPF (String CPF) {
        if (CPF.length() != 11) return(false);
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); 
                sm = 0;
                peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }
        private String imprimeCPF(String CPF) {
            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        }

    public static boolean validarCNPJ (String CNPJ) {
        if (CNPJ.length() != 14)return(false);
            char dig13, dig14;
            int sm, i, r, num, peso;
        try {
          sm = 0;
          peso = 2;
          for (i=11; i>=0; i--) {
            num = (int)(CNPJ.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
               peso = 2;
        }
        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig13 = '0';
        else dig13 = (char)((11-r) + 48);
        sm = 0;
        peso = 2;
        for (i=12; i>=0; i--) {
        num = (int)(CNPJ.charAt(i)- 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }
        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig14 = '0';
        else dig14 = (char)((11-r) + 48);
        if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
            return(true);
        else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }
    public static String imprimeCNPJ(String CNPJ) {
        return(CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) + "." +
            CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
            CNPJ.substring(12, 14));
    }
}

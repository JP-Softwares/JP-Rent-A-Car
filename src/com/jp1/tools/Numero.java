/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.tools;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author aluno
 */
public class Numero {
    
    private static final Locale local = new Locale("pt", "br");
    
    
    public static float numeros(String texto){
        char letras[] = texto.toCharArray();
        texto = "";
        
        for(int i = 0; i < letras.length; i++){
            if(Character.isDigit(letras[i])){
                texto += letras[i];
            }
            if(letras[i] == ',') texto += '.';
        }
        return Float.parseFloat(texto);
    }
    
    public static int numerosSemPonto(String texto){
        char letras[] = texto.toCharArray();
        texto = "";
        
        for(int i = 0; i < letras.length; i++){
            if(Character.isDigit(letras[i])){
                texto += letras[i];
            }
            //if(letras[i] == ',') texto += '.';
        }
        if(texto.equals("")) return 0;
        return Integer.parseInt(texto);
    }
    
    public static String numeral(int numero){
        return NumberFormat.getInstance(local).format(numero);
    }
    
    public static String numeral(String numero){
        return NumberFormat.getInstance(local).format(Integer.parseInt(numero));
    }
    
    public static String real(double numero){
        return NumberFormat.getCurrencyInstance(local).format(numero);
    }
    
    public static String real(float numero){
        return NumberFormat.getCurrencyInstance(local).format(numero);
    }
    
    public static String real(int numero){
        return NumberFormat.getCurrencyInstance(local).format(numero);
    }
    
    public static String real(String texto){
        double numero = 0;
        try {
            numero = Double.parseDouble(texto);
        } catch (Exception e) {
            System.out.println("Erro: Não é possível converter esse texto em número.");
            e.printStackTrace();
        }
        return NumberFormat.getCurrencyInstance(local).format(numero);
    }
    
    public static String validarCampo(String texto, int qtd, boolean apagar, java.awt.event.KeyEvent evt){
        texto = Numero.numerosSemPonto(texto) + "";
        
        char novasletras[] = texto.toCharArray();
        texto = "";
        
        int menos = 0;
        if(apagar) menos = 1;
        
        for(int i = 0; i < novasletras.length - menos; i++){
            texto += novasletras[i];
        }
        char c = evt.getKeyChar();
        if(!apagar && Character.isDigit(c) && texto.toCharArray().length < qtd) {
            texto += evt.getKeyChar();
        }
        evt.consume();
        if(!texto.equals("")){
            double numero = Long.parseLong(texto)/100.0;

            return Numero.real(numero);
        }
        return Numero.real(0) + "";
    }
}

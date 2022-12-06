/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.tools;

/**
 *
 * @author Woly
 */
public class Texto {
    
    public static enum tipoDoTexto{
        STRING, INT, INT_STRING, STRING_SPACE
    }
    
    public static String toString(char vetor[]) throws Exception{
        if(vetor.length > 0){
            String texto = "";
            for(int i = 0; i < vetor.length; i++){
                texto += vetor[i];
            }

            return texto;
        }else throw new Exception("Vetor vazio");
    }
    
    public static String validadorX(String texto, int qtd, tipoDoTexto tipo){
        char letras[] = texto.toCharArray();
        int cont = 0;
        boolean qtdIlimitada = qtd == 0;
        texto = "";

        for(int i = 0; i < letras.length; i++){
            boolean positivo = false;
            switch (tipo) {
                case INT:
                    positivo = Character.isDigit(letras[i]);
                    break;
                case STRING:
                    positivo = Character.isLetter(letras[i]);
                    break;
                case INT_STRING:
                    positivo = Character.isLetterOrDigit(letras[i]);
                    break;
                case STRING_SPACE:
                    positivo = Character.isLetter(letras[i]) || letras[i] == ' ';
                    Character.toUpperCase(letras[i]);
                    break;
            }
            if(positivo){
                texto += letras[i];
                cont++;
                if(cont == qtd && !qtdIlimitada) break;
            }
        }
        return texto;
    }
}

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
    
    public static String toString(char vetor[]) throws Exception{
        if(vetor.length > 0){
            String texto = "";
            for(int i = 0; i < vetor.length; i++){
                texto += vetor[i];
            }

            return texto;
        }else throw new Exception("Vetor vazio");
    }
    
    public static String validadorLetraEspaco(String texto){
        char vetor[] = texto.toCharArray();
        texto = "";
        boolean espaco = false;

        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] == ' ') espaco = true;
            if(Character.isLetter(vetor[i]) || espaco){
                texto += Character.toUpperCase(vetor[i]);
            }
            espaco = false;
        }
        
        return texto;
    }
    
    public static String validador4Numeros(String texto){
        if(texto.length() > 4){
            char letras[] = texto.toCharArray();
            int cont = 0;
            texto = "";

            for(int i = 0; i < letras.length; i++){
                if(Character.isDigit(letras[i])){
                    texto += letras[i];
                    cont++;
                    if(cont == 4) break;
                }
            }
        }
        return texto;
    }
}

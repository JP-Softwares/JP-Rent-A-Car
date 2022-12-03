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
}

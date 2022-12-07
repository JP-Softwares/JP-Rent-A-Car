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
        STRING, INT, INT_STRING, STRING_SPACE, INT_STRING_SPACE
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
    
    public static void validarString(javax.swing.JTextField jTextField, int qtd, java.awt.event.KeyEvent evt, boolean toUpperCase){
        char c = evt.getKeyChar();
        if(c != ''){
            evt.consume();
            jTextField.setText(Texto.validadorX(jTextField.getText() + c, qtd, Texto.tipoDoTexto.STRING, toUpperCase));
        }
    }
    
    public static void validarNumero(javax.swing.JTextField jTextField, int qtd, java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        if(c != ''){
            evt.consume();
            jTextField.setText(Texto.validadorX(jTextField.getText() + c, qtd, Texto.tipoDoTexto.INT, false));
        }
    }
    
    public static void validarLetrasENumeros(javax.swing.JTextField jTextField, int qtd, java.awt.event.KeyEvent evt, boolean toUpperCase){
        char c = evt.getKeyChar();
        if(c != ''){
            evt.consume();
            jTextField.setText(Texto.validadorX(jTextField.getText() + c, qtd, Texto.tipoDoTexto.INT_STRING, toUpperCase));
        }
    }
    
    public static void validarLetrasEEspaco(javax.swing.JTextField jTextField, int qtd, java.awt.event.KeyEvent evt, boolean toUpperCase){
        char c = evt.getKeyChar();
        if(c != ''){
            evt.consume();
            jTextField.setText(Texto.validadorX(jTextField.getText() + c, qtd, Texto.tipoDoTexto.STRING_SPACE, toUpperCase));
        }
    }
    
    public static void validarLetrasEspacoENumero(javax.swing.JTextField jTextField, int qtd, java.awt.event.KeyEvent evt, boolean toUpperCase){
        char c = evt.getKeyChar();
        if(c != ''){
            evt.consume();
            jTextField.setText(Texto.validadorX(jTextField.getText() + c, qtd, Texto.tipoDoTexto.INT_STRING_SPACE, toUpperCase));
        }
    }
    
    private static String validadorX(String texto, int qtd, tipoDoTexto tipo, boolean toUpperCase){
        char letras[] = texto.toCharArray();
        
        int cont = 0;
        boolean qtdIlimitada = qtd == 0;
        texto = "";

        for(int i = 0; i < letras.length; i++){
            boolean positivo = false;
            if(toUpperCase) letras[i] = Character.toUpperCase(letras[i]);
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
                    break;
                case INT_STRING_SPACE:
                    positivo = Character.isLetterOrDigit(letras[i]) || letras[i] == ' ';
                    break;
            }
            if(positivo){
                texto += letras[i];
                cont++;
                if(cont == qtd && !qtdIlimitada) break;
            }
        }
//        if(apagar){
//            texto = "";
//            for(int i = 0; i < letras.length - 1; i++){
//                texto += letras[i];
//            }
//        }else{
//            
//        }
        return texto;
    }
}

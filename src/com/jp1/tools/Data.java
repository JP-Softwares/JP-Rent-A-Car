/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.tools;

/**
 *
 * @author aluno
 */
public class Data {
    
    public static void validarCampo(javax.swing.JTextField campo, boolean apagar, java.awt.event.KeyEvent evt) throws Exception{
        String texto = campo.getText();
        
        char data[] = {
            ' ', ' ', '/', ' ', ' ', '/', ' ', ' ', ' ', ' '
        };
        if(texto.length() == 10){
            if(texto.charAt(2) == '/' && texto.charAt(5) == '/'){
                char letras[] = texto.toCharArray();
                texto = "";

                int posLetras = 0;
                boolean primeiraVez = true;
                for(int i = 0; i < data.length; i++){
                    if(i != 2 && i != 5){
                        if(Character.isDigit(letras[i])) {
                            data[i] = letras[posLetras];
                        }else {
                            if(primeiraVez) {
                                if(!apagar){
                                    primeiraVez = false;
                                    char c = evt.getKeyChar();
                                    if(Character.isDigit(c)){
                                        data[i] = c;
                                        campo.setText(Texto.toString(data));
                                        setarCareta(campo, apagar, i);
                                    }
                                    
                                }
                            }
                            break;
                        }
                    }
                    posLetras++;
                }
                
                if(apagar){
                    for(int i = data.length-1; i >= 0; i--){
                        if(data[i] != ' '){
                            if(i != 2 && i != 5){
                                data[i] = ' ';
                                campo.setText(Texto.toString(data));
                                setarCareta(campo, apagar, i);
                                break;
                            }
                        }
                    }
                }
                
                evt.consume();
            }
        }else{
            char numeros[] = Numero.numerosSemPonto(texto).toCharArray();
            texto = "";
            if(numeros.length != 0){
                int posLetras = 0;
                for(int i = 0; i < data.length; i++){
                    if(i != 2 && i != 5){
                        if(numeros.length > posLetras){
                            data[i] = numeros[posLetras];
                            posLetras++;
                        }else {
                            if(!apagar){
                                char c = evt.getKeyChar();
                                if(Character.isDigit(c)){
                                    data[i] = c;
                                    campo.setText(Texto.toString(data));
                                    setarCareta(campo, apagar, i);
                                }
                                
                            }
                            break;
                        }

                    }
                }

                if(apagar){
                    for(int i = data.length-1; i >= 0; i--){
                        if(data[i] != ' '){
                            if(i != 2 && i != 5){
                                data[i] = ' ';
                                campo.setText(Texto.toString(data));
                                setarCareta(campo, apagar, i);
                                break;
                            }
                        }
                    }
                }
                //if(posLetras < numeros.length) throw new Exception("Muitos números. Não é possível converter para uma data");
            }else {
                if(!apagar) {
                    char c = evt.getKeyChar();
                    if(Character.isDigit(c)){
                        data[0] = c;
                        campo.setText(Texto.toString(data));
                        setarCareta(campo, apagar, 0);
                    }
                }
            }
            evt.consume();
        }
    }
    
    private static void setarCareta(javax.swing.JTextField campo, boolean apagar, int i){
        if(apagar){
            if(i-1 != 2 && i-1 != 5){
                campo.setCaretPosition(i);
            }else{
                campo.setCaretPosition(i-1);
            }
        }else{
            if(i+1 != 2 && i+1 != 5){
                campo.setCaretPosition(i+1);
            }else{
                campo.setCaretPosition(i+2);
            }
        }
    }
}

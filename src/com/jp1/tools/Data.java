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
    
    String dia = "", mes = "", ano = "";
    
    public Data(int dia, int mes, int ano) throws Exception{
        if(dia < 10) this.dia = "0" + dia;
        else this.dia = dia + "";
        
        if(mes < 10) this.dia = "0" + mes;
        else this.mes = mes + "";
        
        if((ano + "").length() == 4) this.ano = ano + "";
        else throw new Exception("O ano precisa ter 4 dígitos.");
    }
    
    public Data(String[] data){
        this.dia = data[0];
        this.mes = data[1];
        this.ano = data[2];
    }
    
    public int toInt(){
        return Integer.parseInt(ano + "" + mes + "" + dia);
    }
    
    public Data(String data){
        String texto[] = data.split("/");
        this.dia = texto[0];
        this.mes = texto[1];
        this.ano = texto[2];
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public static boolean dataCNH(Data cnh, Data fimLocacao) throws Exception {
        cnh.setMes((Integer.parseInt(cnh.getMes()) + 1) + "");
        if(cnh.toInt() < fimLocacao.toInt()) throw new Exception("O motorista estará com a CNH vencida por mais de 30 dias durante a locação");
        return true;
    }
    
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
            char numeros[] = (Numero.numerosSemPonto(texto) + "").toCharArray();
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.visao;

import javax.swing.Timer;

/**
 *
 * @author aluno
 */
public class Run {
    
    public static TelaPrincipal telaPrincipal = null;
    private static TelaLogo logo = null;
    private static Timer timer = null;
    
    public static void main(String[] args){
        logo = new TelaLogo();
        timer = new Timer(1500, (e) -> {
            timerPlay();
        });
        timer.start();
        
    }
    
    private static void timerPlay(){
        logo.fechar();
        timer.stop();
        telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);
    }
}

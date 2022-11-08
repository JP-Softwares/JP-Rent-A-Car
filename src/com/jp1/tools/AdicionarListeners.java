/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.tools;

import java.awt.Color;
import javax.swing.JComponent;
/**
 *
 * @author aluno
 */
public class AdicionarListeners {

    public final static Color botaoFundo = new Color(250, 250, 250);
    public final static Color botaoEntered = new Color(240,240,240);
    public final static Color botaoPressed = new Color(220,220,220);
    static enum listeners {
        MOUSEENTERED, MOUSEEXITED, MOUSEPRESSED, MOUSERELEASED
    }

    public AdicionarListeners() {
        
    }
    
    public static void adicionar(JComponent botoes[]) {
        for(int i = 0; i < botoes.length; i++){
            adicionarEvento(botoes[i]);
        }
    }
    
    private static void adicionarEvento(JComponent botao){
        botao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                colorir(listeners.MOUSEENTERED, botao);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                colorir(listeners.MOUSEEXITED, botao);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                colorir(listeners.MOUSEPRESSED, botao);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                colorir(listeners.MOUSERELEASED, botao);
            }
        });
    }
    
    private static void colorir(listeners evento, JComponent botao){
        
        switch(evento){
            case MOUSEENTERED:
                botao.setBackground(botaoEntered);
                break;
            case MOUSEEXITED:
                botao.setBackground(botaoFundo);
                break;
            case MOUSEPRESSED:
                botao.setBackground(botaoPressed);
                break;
            case MOUSERELEASED:
                botao.setBackground(botaoFundo);
                break;
        }
    }
}

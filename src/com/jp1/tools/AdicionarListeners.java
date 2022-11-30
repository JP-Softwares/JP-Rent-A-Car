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
    
    public static void adicionar(JComponent... componentes) {
        for(int i = 0; i < componentes.length; i++){
            JComponent componente = componentes[i];
            componente.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    colorir(listeners.MOUSEENTERED, componente);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    colorir(listeners.MOUSEEXITED, componente);
                }
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    colorir(listeners.MOUSEPRESSED, componente);
                }
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    colorir(listeners.MOUSERELEASED, componente);
                }
            });
        }
    }
    
    private static void colorir(listeners evento, JComponent componente){
        
        switch(evento){
            case MOUSEENTERED:
                componente.setBackground(botaoEntered);
                break;
            case MOUSEEXITED:
                componente.setBackground(botaoFundo);
                break;
            case MOUSEPRESSED:
                componente.setBackground(botaoPressed);
                break;
            case MOUSERELEASED:
                componente.setBackground(botaoFundo);
                break;
        }
    }
}

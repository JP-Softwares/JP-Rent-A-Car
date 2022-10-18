/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.visao;

/**
 *
 * @author aluno
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;

public class TelaLogo {
    
    JWindow jWindow = new JWindow();
    public TelaLogo() {
        
        jWindow.setBackground(new Color(0, 0, 0, 0));
        jWindow.setContentPane(new Pane());
        jWindow.pack();
        jWindow.setLocationRelativeTo(null);
        jWindow.setVisible(true);
    }
    
    public void fechar(){
        jWindow.dispose();
    }

    class Pane extends JPanel {

        private BufferedImage leaf;

        public Pane() {
            setBorder(new EmptyBorder(0, 0, 250, 0));

            try {
                leaf = ImageIO.read(getClass().getResource("/com/jp1/icones/JP_Softwares.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setOpaque(false);
            setLayout(new GridBagLayout());

        }

        @Override
        public Dimension getPreferredSize() {
            return leaf == null ? new Dimension(200, 200) : new Dimension(leaf.getWidth(), leaf.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (leaf != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(leaf, 0, 0, this);
                g2d.dispose();
            }
        }
    }
}

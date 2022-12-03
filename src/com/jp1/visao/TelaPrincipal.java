/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jp1.visao;

import com.formdev.flatlaf.FlatDarkLaf;
import com.myapp.themes.Tema;
import com.jp1.tools.AdicionarListeners;

import java.awt.Color;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.LookAndFeel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.plaf.metal.MetalLookAndFeel;
//import java.awt.AlphaComposite;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.Timer;

/**
 *
 * @author aluno
 */
public final class TelaPrincipal extends javax.swing.JFrame /*implements ActionListener*/ {

    /**
     * Creates new form TelaPrincipal
     */
    
    int localx = 0;
    int localy = 0;
    int mousex = 0;
    int mousey = 0;
    Color botaofundo = new Color(250, 250, 250);
//    boolean texto = false;
//    boolean panel = false;
//    int time = 0;
//    float opacity = 10;
//    int animar = 0;
    
    
//    javax.swing.JPanel jPanelInicial = new javax.swing.JPanel();
//    Timer timer = new Timer(1000/30, this);
    
    /*public void pintar(Graphics g) {
        if (g != null) {
            Graphics2D g2d = (Graphics2D) g;
            System.out.println(opacity/10);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity/10));
            opacity-= 1;
            super.paint(g);
            if(opacity == 0) {
                g = null;
                jPanelInicial.setVisible(false);
            }
        }
    }*/
    
    public TelaPrincipal() {
        lookAndFeel();
        initComponents();
        this.setLocationRelativeTo(null);

        jPanelVeiculosExp.setVisible(false);
        jPanelVeiculosExp.setLocale(jPanelVeiculos.getLocale());
        jButtonMarcas.setBackground(AdicionarListeners.botaoFundo);
        jButtonModelos.setBackground(AdicionarListeners.botaoFundo);
        jButtonVeiculo.setBackground(AdicionarListeners.botaoFundo);
        jButtonCategoria.setBackground(AdicionarListeners.botaoFundo);
        //AdicionarListeners.adicionar(jButtonMarcas, jButtonModelos, jButtonVeiculo);
        
        adicionarTela(new TelaWelcome());
        

        localx = getX();
        localy = getY();
        /*
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(980, 540));
        setResizable(false);
        pack();
        this.setLocationRelativeTo(null);
        jPanelInicial.setBackground(Color.WHITE);
        jPanelInicial.setSize(980, 540);
        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon(getClass().getResource("/com/jp1/icones/JP_Softwares.png")));
        jPanelInicial.getGraphics();
        javax.swing.GroupLayout jPanelInicialLayout = new javax.swing.GroupLayout(jPanelInicial);
        jPanelInicial.setLayout(jPanelInicialLayout);
        jPanelInicialLayout.setHorizontalGroup(
            jPanelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicialLayout.createSequentialGroup()
                .addGap(250)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                
        );
        jPanelInicialLayout.setVerticalGroup(
            jPanelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicialLayout.createSequentialGroup()
                .addGap(50)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE)
                )
                
        );
        getContentPane().add(jPanelInicial);
        
        timer.start();*/
        
    }
    
    public void lookAndFeel(){
        try {
            javax.swing.UIManager.setLookAndFeel(new Tema());
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void mouse(java.awt.event.MouseEvent evt){
        if(mousex != evt.getX())localx += (evt.getX() - mousex);

        //System.out.println("O Localx é: " + localx + "\no mousex é: " + mousex + "  o evt getx é: " + evt.getX());

        if(mousey != evt.getY()) localy += (evt.getY() - mousey);
        
    }
    
    public void adicionarTela(JInternalFrame tela){
        ((BasicInternalFrameUI)tela.getUI()).setNorthPane(null);
        jDesktopPane1.removeAll();
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        jPanelVeiculosExp.setVisible(false);
    }
    
//    public boolean verificarveiculo(){
//        if(texto || panel) return true;
//        return false;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelVeiculosExp = new javax.swing.JPanel();
        jButtonMarcas = new javax.swing.JButton();
        jButtonModelos = new javax.swing.JButton();
        jButtonVeiculo = new javax.swing.JButton();
        jButtonCategoria = new javax.swing.JButton();
        jPanelBarra = new javax.swing.JPanel();
        jPanelX = new javax.swing.JPanel();
        jLabelX = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelMinimizar = new javax.swing.JPanel();
        jLabelMinimizar = new javax.swing.JLabel();
        jLabeliconeCliente = new javax.swing.JLabel();
        jLabelClientes = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelVeiculos = new javax.swing.JPanel();
        jLabeliconeCliente1 = new javax.swing.JLabel();
        jLabelClientes1 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(980, 540));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanelVeiculosExp.setBackground(new java.awt.Color(255, 255, 255));
        jPanelVeiculosExp.setPreferredSize(new java.awt.Dimension(133, 124));
        jPanelVeiculosExp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelVeiculosExpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelVeiculosExpMouseExited(evt);
            }
        });

        jButtonMarcas.setText("Marcas");
        jButtonMarcas.setBorder(null);
        jButtonMarcas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMarcas.setFocusable(false);
        jButtonMarcas.setPreferredSize(new java.awt.Dimension(38, 31));
        jButtonMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMarcasActionPerformed(evt);
            }
        });

        jButtonModelos.setText("Modelos");
        jButtonModelos.setBorder(null);
        jButtonModelos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonModelos.setFocusable(false);
        jButtonModelos.setPreferredSize(new java.awt.Dimension(133, 31));
        jButtonModelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModelosActionPerformed(evt);
            }
        });

        jButtonVeiculo.setText("Cadastrar Veículo");
        jButtonVeiculo.setBorder(null);
        jButtonVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonVeiculo.setFocusable(false);
        jButtonVeiculo.setPreferredSize(new java.awt.Dimension(92, 31));
        jButtonVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVeiculoActionPerformed(evt);
            }
        });

        jButtonCategoria.setText("Categoria");
        jButtonCategoria.setBorder(null);
        jButtonCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCategoria.setFocusable(false);
        jButtonCategoria.setPreferredSize(new java.awt.Dimension(92, 31));
        jButtonCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVeiculosExpLayout = new javax.swing.GroupLayout(jPanelVeiculosExp);
        jPanelVeiculosExp.setLayout(jPanelVeiculosExpLayout);
        jPanelVeiculosExpLayout.setHorizontalGroup(
            jPanelVeiculosExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonMarcas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonModelos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelVeiculosExpLayout.setVerticalGroup(
            jPanelVeiculosExpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVeiculosExpLayout.createSequentialGroup()
                .addComponent(jButtonMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonModelos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelVeiculosExp);
        jPanelVeiculosExp.setBounds(540, 30, 133, 124);

        jPanelBarra.setBackground(new java.awt.Color(250, 250, 250));
        jPanelBarra.setPreferredSize(new java.awt.Dimension(980, 30));
        jPanelBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelBarraMouseDragged(evt);
            }
        });
        jPanelBarra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelBarraMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelBarraMousePressed(evt);
            }
        });

        jPanelX.setBackground(jPanelBarra.getBackground());
        jPanelX.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelX.setPreferredSize(new java.awt.Dimension(44, 30));
        jPanelX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelXMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelXMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelXMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelXMousePressed(evt);
            }
        });

        jLabelX.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelX.setForeground(new java.awt.Color(102, 102, 102));
        jLabelX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelX.setText("X");
        jLabelX.setPreferredSize(new java.awt.Dimension(44, 30));

        javax.swing.GroupLayout jPanelXLayout = new javax.swing.GroupLayout(jPanelX);
        jPanelX.setLayout(jPanelXLayout);
        jPanelXLayout.setHorizontalGroup(
            jPanelXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelXLayout.setVerticalGroup(
            jPanelXLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jp1/icones/Home_26x26.png"))); // NOI18N
        jLabelTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelTitulo.setPreferredSize(new java.awt.Dimension(48, 30));
        jLabelTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTituloMouseClicked(evt);
            }
        });

        jPanelMinimizar.setBackground(jPanelBarra.getBackground());
        jPanelMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelMinimizar.setPreferredSize(new java.awt.Dimension(44, 30));
        jPanelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelMinimizarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelMinimizarMousePressed(evt);
            }
        });

        jLabelMinimizar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelMinimizar.setForeground(new java.awt.Color(102, 102, 102));
        jLabelMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinimizar.setText("—");
        jLabelMinimizar.setPreferredSize(new java.awt.Dimension(44, 30));

        javax.swing.GroupLayout jPanelMinimizarLayout = new javax.swing.GroupLayout(jPanelMinimizar);
        jPanelMinimizar.setLayout(jPanelMinimizarLayout);
        jPanelMinimizarLayout.setHorizontalGroup(
            jPanelMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMinimizarLayout.setVerticalGroup(
            jPanelMinimizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMinimizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabeliconeCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabeliconeCliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabeliconeCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeliconeCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jp1/icones/Cliente_26x26.png"))); // NOI18N
        jLabeliconeCliente.setPreferredSize(new java.awt.Dimension(38, 30));

        jLabelClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelClientes.setForeground(new java.awt.Color(61, 47, 47));
        jLabelClientes.setText("Clientes");
        jLabelClientes.setPreferredSize(new java.awt.Dimension(48, 30));

        jPanel2.setBackground(new java.awt.Color(52, 135, 231));
        jPanel2.setMinimumSize(new java.awt.Dimension(1, 1));
        jPanel2.setPreferredSize(new java.awt.Dimension(2, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanelVeiculos.setBackground(jPanelBarra.getBackground());
        jPanelVeiculos.setPreferredSize(new java.awt.Dimension(133, 30));
        jPanelVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelVeiculosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelVeiculosMouseExited(evt);
            }
        });

        jLabeliconeCliente1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabeliconeCliente1.setForeground(new java.awt.Color(255, 255, 255));
        jLabeliconeCliente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeliconeCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jp1/icones/Carro_26x26.png"))); // NOI18N
        jLabeliconeCliente1.setPreferredSize(new java.awt.Dimension(63, 30));

        jLabelClientes1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelClientes1.setForeground(new java.awt.Color(61, 47, 47));
        jLabelClientes1.setText("Veículos");
        jLabelClientes1.setPreferredSize(new java.awt.Dimension(50, 30));

        javax.swing.GroupLayout jPanelVeiculosLayout = new javax.swing.GroupLayout(jPanelVeiculos);
        jPanelVeiculos.setLayout(jPanelVeiculosLayout);
        jPanelVeiculosLayout.setHorizontalGroup(
            jPanelVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVeiculosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabeliconeCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabelClientes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanelVeiculosLayout.setVerticalGroup(
            jPanelVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVeiculosLayout.createSequentialGroup()
                .addGroup(jPanelVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabeliconeCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClientes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanelBarraLayout = new javax.swing.GroupLayout(jPanelBarra);
        jPanelBarra.setLayout(jPanelBarraLayout);
        jPanelBarraLayout.setHorizontalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraLayout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(291, 291, 291)
                .addComponent(jLabeliconeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jPanelVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addComponent(jPanelMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelBarraLayout.setVerticalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
            .addGroup(jPanelBarraLayout.createSequentialGroup()
                .addGroup(jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeliconeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelBarra);
        jPanelBarra.setBounds(0, 0, 980, 30);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(980, 510));
        jDesktopPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDesktopPane1MouseEntered(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(246, 246, 246));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 30, 980, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelXMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jPanelXMouseClicked

    private void jPanelXMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelXMouseEntered
        // TODO add your handling code here:
        jPanelX.setBackground(new Color(255,100,100));
        jLabelX.setForeground(new Color(242,242,242));
    }//GEN-LAST:event_jPanelXMouseEntered

    private void jPanelXMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelXMouseExited
        // TODO add your handling code here:
        jPanelX.setBackground(jPanelBarra.getBackground());
        jLabelX.setForeground(new Color(102,102,102));
        
    }//GEN-LAST:event_jPanelXMouseExited

    private void jPanelXMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelXMousePressed
        // TODO add your handling code here:
        jPanelX.setBackground(new Color(200,100,100));
    }//GEN-LAST:event_jPanelXMousePressed

    private void jPanelBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBarraMouseDragged
        // TODO add your handling code here:
        mouse(evt);
        this.setLocation(localx, localy);
    }//GEN-LAST:event_jPanelBarraMouseDragged

    private void jPanelBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBarraMousePressed
        // TODO add your handling code here:
        mousex = evt.getX();
        mousey = evt.getY();
    }//GEN-LAST:event_jPanelBarraMousePressed

    private void jPanelMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(javax.swing.JFrame.ICONIFIED);
    }//GEN-LAST:event_jPanelMinimizarMouseClicked

    private void jPanelMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMinimizarMouseEntered
        // TODO add your handling code here:
        jPanelMinimizar.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_jPanelMinimizarMouseEntered

    private void jPanelMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMinimizarMouseExited
        // TODO add your handling code here:
        jPanelMinimizar.setBackground(jPanelBarra.getBackground());
    }//GEN-LAST:event_jPanelMinimizarMouseExited

    private void jPanelMinimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMinimizarMousePressed
        // TODO add your handling code here:
        jPanelMinimizar.setBackground(new Color(220,220,220));
    }//GEN-LAST:event_jPanelMinimizarMousePressed

    private void jPanelVeiculosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVeiculosMouseEntered
        // TODO add your handling code here:
        jPanelVeiculosExp.setVisible(true);
        //texto = true;
    }//GEN-LAST:event_jPanelVeiculosMouseEntered

    private void jPanelVeiculosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVeiculosMouseExited
        // TODO add your handling code here:
        //texto = false;
        
    }//GEN-LAST:event_jPanelVeiculosMouseExited

    private void jPanelVeiculosExpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVeiculosExpMouseEntered
        // TODO add your handling code here:
        //panel = true;
    }//GEN-LAST:event_jPanelVeiculosExpMouseEntered

    private void jPanelVeiculosExpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelVeiculosExpMouseExited
        // TODO add your handling code here:
        jPanelVeiculosExp.setVisible(false);
    }//GEN-LAST:event_jPanelVeiculosExpMouseExited

    private void jPanelBarraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelBarraMouseEntered
        // TODO add your handling code here:
        jPanelVeiculosExp.setVisible(false);
    }//GEN-LAST:event_jPanelBarraMouseEntered

    private void jDesktopPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDesktopPane1MouseEntered
        // TODO add your handling code here:
        jPanelVeiculosExp.setVisible(false);
    }//GEN-LAST:event_jDesktopPane1MouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
        jPanelVeiculosExp.setVisible(false);
    }//GEN-LAST:event_formMouseExited

    private void jButtonMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMarcasActionPerformed
        // TODO add your handling code here:
        adicionarTela(new TelaMarcas());
    }//GEN-LAST:event_jButtonMarcasActionPerformed

    private void jButtonModelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModelosActionPerformed
        // TODO add your handling code here:
        adicionarTela(new TelaModelos());
    }//GEN-LAST:event_jButtonModelosActionPerformed

    private void jLabelTituloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTituloMouseClicked
        // TODO add your handling code here:
        adicionarTela(new TelaWelcome());
    }//GEN-LAST:event_jLabelTituloMouseClicked

    private void jButtonVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVeiculoActionPerformed
        // TODO add your handling code here:
        TelaVeiculo tela = new TelaVeiculo();
        adicionarTela(tela);
    }//GEN-LAST:event_jButtonVeiculoActionPerformed

    private void jButtonCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriaActionPerformed
        // TODO add your handling code here:
        TelaCategoria tela = new TelaCategoria();
        adicionarTela(tela);
    }//GEN-LAST:event_jButtonCategoriaActionPerformed

    
    /**
     * @param args the command line arguments
     */
    /* aqui
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /* aqui
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /* aqui
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }e aqui */ 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCategoria;
    private javax.swing.JButton jButtonMarcas;
    private javax.swing.JButton jButtonModelos;
    private javax.swing.JButton jButtonVeiculo;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelClientes;
    private javax.swing.JLabel jLabelClientes1;
    private javax.swing.JLabel jLabelMinimizar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelX;
    private javax.swing.JLabel jLabeliconeCliente;
    private javax.swing.JLabel jLabeliconeCliente1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelBarra;
    private javax.swing.JPanel jPanelMinimizar;
    private javax.swing.JPanel jPanelVeiculos;
    protected javax.swing.JPanel jPanelVeiculosExp;
    private javax.swing.JPanel jPanelX;
    // End of variables declaration//GEN-END:variables

    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        time++;
        if(time >= 20 && time <= 30){
            animar++;
            System.out.println(animar);
            pintar(jPanelInicial.getGraphics());
            
        }
        
        if(time == 30){
            //jPanelInicial.setVisible(false);
            System.out.println("parou");
            timer.stop();
            

            initComponents();

            jPanelVeiculosExp.setVisible(false);
            jPanelVeiculosExp.setLocale(jPanelVeiculos.getLocale());
            jButtonMarcas.setBackground(Color.WHITE);
            jButtonModelos.setBackground(Color.WHITE);


            localx = getX();
            localy = getY();
        }
        
    }*/

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.jp1.visao;

import com.jp1.Renderer.*;
import com.jp1.modelos.Marca;

import com.jp1.controle.*;

import java.awt.event.KeyEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class TelaMarcas extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaMarcas
     */
    IMarcaControle marcaControle = new MarcaControle();
    Marca marca = null;
    boolean espaco = false;
    int linha = 0;
    
    public TelaMarcas() {
        initComponents();
        
        ((DefaultTableCellRenderer) jTableMarcas.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        /*
        try {
            ImageIcon logo = Logo.pegarLogo();
            logo.setImage(logo.getImage().getScaledInstance(148, 148, 1));
            jLabelLogo.setIcon(logo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }*/
        
        
        
        //MyModel m = new MyModel();
        //jTableMarcas.getColumnModel().getColumn(3).setCellRenderer(new GradeRenderer());
        
        try {
            listar(marcaControle.listar());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }
    
    
    
    public void limparTabela(){
        jTextFieldIdentificador.setText("");
        jTextFieldDescricao.setText("");
        jTextFieldURL.setText("");
        jTableMarcas.clearSelection();
        jLabelLogo.setIcon(null);
    }
    
    public void listar(ArrayList<Marca> listaDeMarcas){
        try {
            DefaultTableModel model =  (DefaultTableModel) jTableMarcas.getModel();
            //Limpa a tabela 
            model.setNumRows(0);
            Iterator<Marca> lista = listaDeMarcas.iterator();
            while(lista.hasNext()){
                Object[] saida= new Object[4];
                Marca aux = lista.next();
                saida[0]= aux.getId()+"";
                saida[1]= aux.getDescricao();
                saida[2] = aux.getUrl();
                saida[3] = "";
                //Incluir nova linha na Tabela
                model.addRow(saida);
            }
            jTableMarcas.setModel(model);
        } catch(Exception erro){
            JOptionPane.showMessageDialog(this, erro.getMessage());
      }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldIdentificador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldURL = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jButtonIncluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMarcas = new javax.swing.JTable();
        jButtonLogoPredefinida = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(980, 510));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 510));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Identificador");

        jTextFieldIdentificador.setBackground(new java.awt.Color(242, 247, 246));
        jTextFieldIdentificador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIdentificador.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Descrição");

        jTextFieldDescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescricaoActionPerformed(evt);
            }
        });
        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("URL");

        jTextFieldURL.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("LOGO");

        jLabelLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabelLogo.setPreferredSize(new java.awt.Dimension(152, 152));

        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBuscar.setText("BUSCAR IMAGEM");
        jButtonBuscar.setFocusable(false);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonIncluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonIncluir.setText("INCLUIR MARCA");
        jButtonIncluir.setFocusable(false);
        jButtonIncluir.setMaximumSize(new java.awt.Dimension(150, 28));
        jButtonIncluir.setMinimumSize(new java.awt.Dimension(150, 28));
        jButtonIncluir.setPreferredSize(new java.awt.Dimension(150, 28));
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAlterar.setText("ALTERAR MARCA");
        jButtonAlterar.setFocusable(false);
        jButtonAlterar.setMaximumSize(new java.awt.Dimension(150, 28));
        jButtonAlterar.setMinimumSize(new java.awt.Dimension(150, 28));
        jButtonAlterar.setPreferredSize(new java.awt.Dimension(150, 28));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(952, 244));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTableMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR", "DESCRIÇÃO", "URL", "LOGO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMarcas.setFocusable(false);
        jTableMarcas.setRowHeight(50);
        jTableMarcas.setSelectionBackground(new java.awt.Color(52, 135, 231));
        jTableMarcas.getTableHeader().setResizingAllowed(false);
        jTableMarcas.getTableHeader().setReorderingAllowed(false);
        jTableMarcas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMarcasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMarcas);
        if (jTableMarcas.getColumnModel().getColumnCount() > 0) {
            jTableMarcas.getColumnModel().getColumn(0).setCellRenderer(new GradeRenderer());
            jTableMarcas.getColumnModel().getColumn(1).setCellRenderer(new GradeRenderer());
            jTableMarcas.getColumnModel().getColumn(2).setCellRenderer(new GradeRenderer());
            jTableMarcas.getColumnModel().getColumn(3).setCellRenderer(new GradeRenderer());
        }

        jButtonLogoPredefinida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonLogoPredefinida.setText("LOGO PREDEFINIDA");
        jButtonLogoPredefinida.setFocusable(false);
        jButtonLogoPredefinida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLogoPredefinidaMouseEntered(evt);
            }
        });
        jButtonLogoPredefinida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoPredefinidaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MARCAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldURL, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonLogoPredefinida))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jButtonBuscar)))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLogoPredefinida))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescricaoActionPerformed

    private void jTextFieldDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        
        if(Character.isDigit(c) || (!Character.isLetterOrDigit(c) && !espaco)){
            evt.consume();
        }

        if(Character.isLowerCase(c)){
            evt.setKeyChar(Character.toUpperCase(c));
        }

    }//GEN-LAST:event_jTextFieldDescricaoKeyTyped

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser fc = new JFileChooser();
            fc.setAcceptAllFileFilterUsed(false);
            fc.addChoosableFileFilter(new FileNameExtensionFilter("Imagens (*.jpg, *.jpeg, *.png)", "jpg", "jpeg", "png"));
            
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.showOpenDialog(this);
            File arquivo = fc.getSelectedFile();
            if(arquivo != null){
                String nomeDoArquivo = arquivo.getPath();
                jTextFieldURL.setText(nomeDoArquivo);
                ImageIcon iconLogo = new ImageIcon(nomeDoArquivo);
                iconLogo.setImage(iconLogo.getImage().getScaledInstance(
                    jLabelLogo.getWidth(),jLabelLogo.getHeight(),1));
                jLabelLogo.setIcon(iconLogo);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {
            marca = new Marca(0, jTextFieldDescricao.getText(), jTextFieldURL.getText());
            marcaControle.incluir(marca);
            listar(marcaControle.listar());
            jTextFieldIdentificador.setText("");
            jTextFieldDescricao.setText("");
            jTextFieldURL.setText("");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }

    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        if(jTableMarcas.getSelectedRow() != -1){
            try {
                marcaControle.alterar(new Marca(Integer.parseInt(jTextFieldIdentificador.getText()), jTextFieldDescricao.getText(), jTextFieldURL.getText()));
                listar(marcaControle.listar());
                jTableMarcas.changeSelection(linha, 0, false, false);
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }else JOptionPane.showMessageDialog(null, "Selecione uma Marca primeiro para alterá-la.");

    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jTableMarcasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMarcasMouseClicked
        // TODO add your handling code here:
        if(jTableMarcas.getSelectedRow() != -1){
            linha = jTableMarcas.getSelectedRow();
            int larguraLogo = jLabelLogo.getWidth();
            int alturaLogo = jLabelLogo.getHeight();
            int borda = jLabelLogo.getBorder().getBorderInsets(this).left*2;
            marca = new Marca(Integer.parseInt(jTableMarcas.getValueAt(jTableMarcas.getSelectedRow(), 0).toString()), jTableMarcas.getValueAt(jTableMarcas.getSelectedRow(), 1).toString(), jTableMarcas.getValueAt(jTableMarcas.getSelectedRow(), 2).toString());
            jTextFieldIdentificador.setText(marca.getId() + "");
            jTextFieldDescricao.setText(marca.getDescricao());
            jTextFieldURL.setText(marca.getUrl());

            ImageIcon iconLogo = new ImageIcon(marca.getUrl());
            iconLogo.setImage(iconLogo.getImage().getScaledInstance(
                larguraLogo - borda,alturaLogo - borda,1));
            jLabelLogo.setIcon(iconLogo);
        }
        
    }//GEN-LAST:event_jTableMarcasMouseClicked

    private void jButtonLogoPredefinidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoPredefinidaActionPerformed
        // TODO add your handling code here:
        String texto = jTextFieldDescricao.getText();
        if(!texto.equals("")){
            
            /*
            if(texto.contains(" ")){
                String textos[] = texto.split(" ");
                if(!textos[0].equals("")){
                    texto = textos[0];
                }else texto = textos[1];
            }*/
            
            String url = "./src/com/jp1/logosdainternet/"+ jTextFieldDescricao.getText() + ".jpg";
            int larguraLogo = jLabelLogo.getWidth();
            int alturaLogo = jLabelLogo.getHeight();
            int borda = jLabelLogo.getBorder().getBorderInsets(this).left*2;
            ImageIcon imagem = null;
            try {
                imagem = new ImageIcon(url);
                if(imagem.getIconWidth() == -1){
                    url = "./src/com/jp1/logosdainternet/"+ jTextFieldDescricao.getText() + ".png";
                    imagem = new ImageIcon(url);
                    if(imagem.getIconWidth() == -1) {
                        url = "";
                        throw new Exception("Esta marca não existe no nosso banco de dados :(");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            imagem.setImage(imagem.getImage().getScaledInstance(
                larguraLogo - borda,alturaLogo - borda,1));
            jLabelLogo.setIcon(imagem);
            jTextFieldURL.setText(url);
        }else JOptionPane.showMessageDialog(null, "Digite algo no campo Observação!");
        
        
    }//GEN-LAST:event_jButtonLogoPredefinidaActionPerformed

    private void jTextFieldDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_SPACE) espaco = true;
        else espaco = false;
    }//GEN-LAST:event_jTextFieldDescricaoKeyPressed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
        Run.telaPrincipal.jPanelVeiculosExp.setVisible(false);
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        limparTabela();
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        limparTabela();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButtonLogoPredefinidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLogoPredefinidaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLogoPredefinidaMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonLogoPredefinida;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMarcas;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldIdentificador;
    private javax.swing.JTextField jTextFieldURL;
    // End of variables declaration//GEN-END:variables
}

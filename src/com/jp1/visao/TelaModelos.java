/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.jp1.visao;

import com.jp1.Renderer.GradeRenderer;
import com.jp1.controle.*;
import com.jp1.modelos.*;
import com.jp1.tools.AdicionarListeners;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class TelaModelos extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaModelos
     */
    IModeloControle modeloControle = new ModeloControle();
    Modelo modelo = new Modelo();
    IMarcaControle marcaControle = new MarcaControle();
    boolean espaco = false;
    int linha = 0;
    
    public TelaModelos() {
        initComponents();
        AdicionarListeners.adicionar(new JComponent[] {jButtonAlterar, jButtonBuscar, jButtonIncluir});
        
        ((DefaultTableCellRenderer) jTableModelos.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        
        listarComboBox();
        try {
            if(!marcaControle.listar().isEmpty()) listar(modeloControle.listar());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
        
    }
    
    public void listarComboBox(){
        try {
            Object vetorMarcas[] = marcaControle.listar().toArray();
            
            String marcas[] = new String[vetorMarcas.length];
            
            for(int i = 0; i < marcas.length; i++){
                marcas[i] = vetorMarcas[i].toString().split(";")[1];
            }
            
            if(marcas.length != 0){
                jComboBoxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(marcas));
                setarImagemMarca();
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public void setarImagemMarca(){
        try {
            ImageIcon imagemMarca = new ImageIcon(marcaControle.buscar(jComboBoxMarca.getSelectedItem().toString()).getUrl());
            imagemMarca.setImage(imagemMarca.getImage().getScaledInstance(50, 50, 0));
            jLabelMarca.setIcon(imagemMarca);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void limpar(){
        jTextFieldIdentificador.setText("");
        jTextFieldDescricao.setText("");
        jTextFieldURL.setText("");
        jTableModelos.clearSelection();
        //jComboBoxMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jLabelLogo.setIcon(null);
    }
    
    public void listar(ArrayList<Modelo> listaDeModelos){
        try {
            DefaultTableModel model = (DefaultTableModel) jTableModelos.getModel();
            //Limpa a tabela 
            model.setNumRows(0);
            Iterator<Modelo> lista = listaDeModelos.iterator();
            while(lista.hasNext()){
                Object[] saida= new Object[5];
                Modelo aux = lista.next();
                saida[0]= aux.getId()+"";
                saida[1]= aux.getDescricao();
                saida[2] = aux.getUrl();
                saida[3] = "";
                saida[4] = "";
                //Incluir nova linha na Tabela
                model.addRow(saida);
            }
            jTableModelos.setModel(model);
        } catch(Exception erro){
            JOptionPane.showMessageDialog(this, erro.getMessage());
      }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
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
        jTableModelos = new javax.swing.JTable();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(980, 510));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 510));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);
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
        jLabel6.setText("AUTO-RETRATO");

        jLabelLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabelLogo.setPreferredSize(new java.awt.Dimension(152, 152));

        jButtonBuscar.setBackground(new java.awt.Color(250, 250, 250));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBuscar.setText("BUSCAR IMAGEM");
        jButtonBuscar.setBorder(null);
        jButtonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscar.setFocusable(false);
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(138, 30));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonIncluir.setBackground(new java.awt.Color(250, 250, 250));
        jButtonIncluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonIncluir.setText("INCLUIR MODELO");
        jButtonIncluir.setBorder(null);
        jButtonIncluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonIncluir.setFocusable(false);
        jButtonIncluir.setMaximumSize(new java.awt.Dimension(148, 28));
        jButtonIncluir.setMinimumSize(new java.awt.Dimension(148, 28));
        jButtonIncluir.setPreferredSize(new java.awt.Dimension(150, 28));
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonAlterar.setBackground(new java.awt.Color(250, 250, 250));
        jButtonAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAlterar.setText("ALTERAR MODELO");
        jButtonAlterar.setBorder(null);
        jButtonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAlterar.setFocusable(false);
        jButtonAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAlterar.setInheritsPopupMenu(true);
        jButtonAlterar.setMaximumSize(new java.awt.Dimension(148, 28));
        jButtonAlterar.setMinimumSize(new java.awt.Dimension(148, 28));
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

        jTableModelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR", "DESCRIÇÃO", "URL", "AUTO-RETRATO", "MARCA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableModelos.setFocusable(false);
        jTableModelos.setName("TabelaModelos"); // NOI18N
        jTableModelos.setRowHeight(50);
        jTableModelos.setSelectionBackground(new java.awt.Color(52, 135, 231));
        jTableModelos.getTableHeader().setResizingAllowed(false);
        jTableModelos.getTableHeader().setReorderingAllowed(false);
        jTableModelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableModelosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableModelos);
        if (jTableModelos.getColumnModel().getColumnCount() > 0) {
            jTableModelos.getColumnModel().getColumn(0).setCellRenderer(new GradeRenderer());
            jTableModelos.getColumnModel().getColumn(1).setCellRenderer(new GradeRenderer());
            jTableModelos.getColumnModel().getColumn(2).setCellRenderer(new GradeRenderer());
            jTableModelos.getColumnModel().getColumn(3).setCellRenderer(new GradeRenderer());
            jTableModelos.getColumnModel().getColumn(4).setCellRenderer(new GradeRenderer());
        }

        jComboBoxMarca.setBackground(new java.awt.Color(250, 250, 250));
        jComboBoxMarca.setBorder(null);
        jComboBoxMarca.setFocusable(false);
        jComboBoxMarca.setPreferredSize(new java.awt.Dimension(208, 22));
        jComboBoxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("MARCA");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MODELOS");

        jLabelMarca.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldURL, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(17, 17, 17)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jLabelMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextFieldIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jTextFieldURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGap(10, 10, 10))))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescricaoActionPerformed

    private void jTextFieldDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyPressed
        // TODO add your handling code here:
        espaco = evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE;
    }//GEN-LAST:event_jTextFieldDescricaoKeyPressed

    private void jTextFieldDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();

        if(!Character.isLetterOrDigit(c) && !espaco){
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
            modelo = new Modelo(0, jTextFieldDescricao.getText(), jTextFieldURL.getText(), marcaControle.buscar(jComboBoxMarca.getSelectedItem().toString()));
            modeloControle.incluir(modelo);
            jTextFieldDescricao.setText("");
            jTextFieldURL.setText("");
            jTextFieldIdentificador.setText("");
            jLabelLogo.setIcon(null);
            listar(modeloControle.listar());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        if(jTableModelos.getSelectedRow() != -1){
            try {
                modeloControle.alterar(new Modelo(Integer.parseInt(jTextFieldIdentificador.getText()), jTextFieldDescricao.getText(), jTextFieldURL.getText(), marcaControle.buscar(jComboBoxMarca.getSelectedItem().toString())));
                listar(modeloControle.listar());
                jTableModelos.changeSelection(linha, 0, false, false);
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }else JOptionPane.showMessageDialog(null, "Selecione um Modelo primeiro para alterá-lo.");
        
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jTableModelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableModelosMouseClicked
        // TODO add your handling code here:
        if(jTableModelos.getSelectedRow() != -1){
            listarComboBox();
            int larguraLogo = jLabelLogo.getWidth();
            int alturaLogo = jLabelLogo.getHeight();
            int borda = jLabelLogo.getBorder().getBorderInsets(this).left*2;
            linha = jTableModelos.getSelectedRow();
            
            
            try {
                Object[] lista = modeloControle.listar().toArray();
                int idMarca = 0;
                for(int i = 0; i < lista.length; i++){
                    if(lista[i].toString().contains(jTableModelos.getValueAt(jTableModelos.getSelectedRow(), 0).toString())){

                        String linha[] = lista[i].toString().split(";");
                        idMarca = Integer.parseInt(linha[3].replace("\n", ""));
                    }
                }
                modelo = new Modelo(Integer.parseInt(jTableModelos.getValueAt(jTableModelos.getSelectedRow(), 0).toString()), jTableModelos.getValueAt(jTableModelos.getSelectedRow(), 1).toString(), jTableModelos.getValueAt(jTableModelos.getSelectedRow(), 2).toString(), marcaControle.buscar(idMarca));
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }

            jTextFieldIdentificador.setText(modelo.getId() + "");
            jTextFieldDescricao.setText(modelo.getDescricao());
            jTextFieldURL.setText(modelo.getUrl());
            jComboBoxMarca.setSelectedItem((Object) (modelo.getMarca().getDescricao()));

            ImageIcon iconLogo = new ImageIcon(modelo.getUrl());
            iconLogo.setImage(iconLogo.getImage().getScaledInstance(
                larguraLogo - borda,alturaLogo - borda,1));
            jLabelLogo.setIcon(iconLogo);
        }
        
    }//GEN-LAST:event_jTableModelosMouseClicked

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
        Run.telaPrincipal.jPanelVeiculosExp.setVisible(false);
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jComboBoxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcaActionPerformed
        // TODO add your handling code here:
        setarImagemMarca();
    }//GEN-LAST:event_jComboBoxMarcaActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JComboBox<Object> jComboBoxMarca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableModelos;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldIdentificador;
    private javax.swing.JTextField jTextFieldURL;
    // End of variables declaration//GEN-END:variables
}

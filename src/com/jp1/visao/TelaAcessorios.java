/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.jp1.visao;

import com.jp1.modelos.Acessorios;
import com.jp1.tools.Numero;
import com.jp1.tools.Texto;
import com.jp1.controle.IAcessoriosControle;
import com.jp1.controle.AcessoriosControle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.jp1.Renderer.TableRenderer;

/**
 *
 * @author aluno
 */
public class TelaAcessorios extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaAcessorios
     */
    
    int linha = 0;
    int quantidadeLocada = 0;
    private final String CAMPODINHEIRO_DEFAULT = "R$ 0,00";
    
    IAcessoriosControle acessoriosControle = new AcessoriosControle();
    
    public TelaAcessorios() {
        initComponents();
        
        try {
            listar(acessoriosControle.listar());
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void listar(ArrayList<Acessorios> listaDeCategorias){
        try {
            DefaultTableModel modelo =  (DefaultTableModel) jTableCategoria.getModel();
            //Limpa a tabela 
            modelo.setNumRows(0);
            Iterator<Acessorios> lista = listaDeCategorias.iterator();
            while(lista.hasNext()){
                Acessorios acessorios = lista.next();
                Object[] saida = acessorios.toString().split(";");
                saida[2] = Numero.real(saida[2].toString());
                saida[3] = Numero.numerosSemPonto(saida[3].toString());
                int qtdTotal = Integer.parseInt(saida[3].toString());
                int qtdLocada = Integer.parseInt(Numero.numerosSemPonto(saida[4].toString()));
                saida[4] = qtdTotal - qtdLocada + "";
                //Incluir nova linha na Tabela
                modelo.addRow(saida);
            }
            jTableCategoria.setModel(modelo);
        } catch(Exception erro){
            erro.printStackTrace();
            JOptionPane.showMessageDialog(this, erro.getMessage());
      }
    }
    
    public void limparTabela(){
        jTextFieldIdentificador.setText("");
        jTextFieldDescricao.setText("");
        jTextFieldValor.setText(CAMPODINHEIRO_DEFAULT);
        jTextFieldQuantidadeTotal.setText("0 un");
        jTextFieldQuantidadeDisponivel.setText("0 un");
        jTableCategoria.clearSelection();
        linha = -1;
        quantidadeLocada = 0;
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
        jButtonIncluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCategoria = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldQuantidadeTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldQuantidadeDisponivel = new javax.swing.JTextField();

        setBorder(null);

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
        jTextFieldDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDescricaoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Valor da Locação");

        jButtonIncluir.setBackground(new java.awt.Color(250, 250, 250));
        jButtonIncluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonIncluir.setText("INCLUIR ACESSÓRIOS");
        jButtonIncluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonIncluir.setFocusable(false);
        jButtonIncluir.setMaximumSize(new java.awt.Dimension(150, 28));
        jButtonIncluir.setMinimumSize(new java.awt.Dimension(150, 28));
        jButtonIncluir.setPreferredSize(new java.awt.Dimension(150, 28));
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonAlterar.setBackground(new java.awt.Color(250, 250, 250));
        jButtonAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAlterar.setText("ALTERAR ACESSÓRIOS");
        jButtonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jTableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR", "DESCRIÇÃO", "VALOR DA LOCAÇÃO", "QUANTIDADE TOTAL", "QUANTIDADE DISPONÍVEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCategoria.setFocusable(false);
        jTableCategoria.setName("TabelaCategoria"); // NOI18N
        jTableCategoria.setRowHeight(50);
        jTableCategoria.setSelectionBackground(new java.awt.Color(52, 135, 231));
        jTableCategoria.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableCategoria.setShowHorizontalLines(true);
        jTableCategoria.getTableHeader().setResizingAllowed(false);
        jTableCategoria.getTableHeader().setReorderingAllowed(false);
        jTableCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCategoria);
        if (jTableCategoria.getColumnModel().getColumnCount() > 0) {
            jTableCategoria.getColumnModel().getColumn(0).setCellRenderer(new TableRenderer());
            jTableCategoria.getColumnModel().getColumn(1).setCellRenderer(new TableRenderer());
            jTableCategoria.getColumnModel().getColumn(2).setCellRenderer(new TableRenderer());
            jTableCategoria.getColumnModel().getColumn(3).setCellRenderer(new TableRenderer());
            jTableCategoria.getColumnModel().getColumn(4).setCellRenderer(new TableRenderer());
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ACESSÓRIOS");

        jTextFieldValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValor.setText("R$ 0,00");
        jTextFieldValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldValorKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Quantidade Total");

        jTextFieldQuantidadeTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldQuantidadeTotal.setText("0 un");
        jTextFieldQuantidadeTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldQuantidadeTotalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldQuantidadeTotalKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Quantidade Disponível");

        jTextFieldQuantidadeDisponivel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldQuantidadeDisponivel.setText("0 un");
        jTextFieldQuantidadeDisponivel.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextFieldValor)
                                    .addGap(121, 121, 121)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldQuantidadeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonIncluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldQuantidadeDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldQuantidadeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldQuantidadeDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDescricaoKeyTyped
        // TODO add your handling code here:
        Texto.validarLetrasEEspaco(jTextFieldDescricao, 0, evt, true);
    }//GEN-LAST:event_jTextFieldDescricaoKeyTyped

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {
            Acessorios acessorio = new Acessorios(0, jTextFieldDescricao.getText(), 
                    Numero.numeros(jTextFieldValor.getText()), 
                    Integer.parseInt(Numero.numerosSemPonto(jTextFieldQuantidadeTotal.getText())), 
                    0);
            acessoriosControle.incluir(acessorio);
            listar(acessoriosControle.listar());
            jTextFieldIdentificador.setText("");
            jTextFieldDescricao.setText("");
            jTextFieldValor.setText(CAMPODINHEIRO_DEFAULT);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        if(jTableCategoria.getSelectedRow() != -1){
            try {
                int quantidadeTotal = Integer.parseInt(Numero.numerosSemPonto(jTextFieldQuantidadeTotal.getText()));
                Acessorios acessorio = new Acessorios(Integer.parseInt(jTextFieldIdentificador.getText()), jTextFieldDescricao.getText(), 
                    Numero.numeros(jTextFieldValor.getText()), 
                    quantidadeTotal, 
                    acessoriosControle.buscar(Integer.parseInt(jTextFieldIdentificador.getText())).getQuantidadeLocada());
                acessoriosControle.alterar(acessorio);
                listar(acessoriosControle.listar());
                jTableCategoria.changeSelection(linha, 0, false, false);
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }else JOptionPane.showMessageDialog(null, "Selecione um Acessório primeiro para alterá-lo.");
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jTableCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCategoriaMouseClicked
        // TODO add your handling code here:
        if(jTableCategoria.getSelectedRow() != -1){
            try {
                linha = jTableCategoria.getSelectedRow();
                Acessorios acessorio = acessoriosControle.buscar(Integer.parseInt(jTableCategoria.getValueAt(jTableCategoria.getSelectedRow(), 0).toString()));
                jTextFieldIdentificador.setText(acessorio.getId() + "");
                jTextFieldDescricao.setText(acessorio.getDescricao());
                jTextFieldValor.setText(Numero.real(acessorio.getValorDaLocacao()) + "");
                jTextFieldQuantidadeTotal.setText(acessorio.getQuantidadeTotal() + " un");
                quantidadeLocada = acessorio.getQuantidadeLocada();
                jTextFieldQuantidadeDisponivel.setText((acessorio.getQuantidadeTotal() - quantidadeLocada) + " un");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jTableCategoriaMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        limparTabela();
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTextFieldValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorKeyTyped
        // TODO add your handling code here:
        Texto.validarNumeroReal(jTextFieldValor, 10, evt);
    }//GEN-LAST:event_jTextFieldValorKeyTyped

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        limparTabela();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
        Run.telaPrincipal.jPanelVeiculosExp.setVisible(false);
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jTextFieldQuantidadeTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeTotalKeyTyped
        // TODO add your handling code here:
        Texto.validarNumero(jTextFieldQuantidadeTotal, 0, evt);
        if(jTextFieldQuantidadeTotal.getText().equals("")) jTextFieldQuantidadeTotal.setText("0");
        if(jTextFieldQuantidadeTotal.getText().equals("0" + evt.getKeyChar())) jTextFieldQuantidadeTotal.setText(jTextFieldQuantidadeTotal.getText().substring(1, jTextFieldQuantidadeTotal.getText().length()));
        
        jTextFieldQuantidadeTotal.setText(jTextFieldQuantidadeTotal.getText() + " un");
        
        
        int quantidadeTotal = Integer.parseInt(Numero.numerosSemPonto(jTextFieldQuantidadeTotal.getText()));
        
        jTextFieldQuantidadeDisponivel.setText(quantidadeTotal - quantidadeLocada + " un");
    }//GEN-LAST:event_jTextFieldQuantidadeTotalKeyTyped

    private void jTextFieldQuantidadeTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeTotalKeyPressed
        // TODO add your handling code here:
        jTextFieldQuantidadeTotal.setText(jTextFieldQuantidadeTotal.getText().replace(" un", ""));
    }//GEN-LAST:event_jTextFieldQuantidadeTotalKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCategoria;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldIdentificador;
    private javax.swing.JTextField jTextFieldQuantidadeDisponivel;
    private javax.swing.JTextField jTextFieldQuantidadeTotal;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.jp1.visao;

import com.jp1.controle.CategoriaControle;
import com.jp1.controle.ICategoriaControle;
import com.jp1.modelos.TipoDoVeiculo;
import com.jp1.modelos.TipoDoCombustivel;
import com.jp1.modelos.SituacaoDoVeiculo;
import com.jp1.modelos.Modelo;
import com.jp1.controle.IModeloControle;
import com.jp1.controle.IVeiculoControle;
import com.jp1.controle.ModeloControle;
import com.jp1.controle.VeiculoControle;
import com.jp1.modelos.Categoria;
import com.jp1.modelos.Veiculo;
import com.jp1.tools.Numero;
import com.jp1.tools.Texto;
import com.jp1.Renderer.TableRenderer;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class TelaVeiculo extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaVeiculo
     */
    boolean apagar = false;
    int linha = 0;
    
    IModeloControle modeloControle = new ModeloControle();
    ICategoriaControle categoriaControle = new CategoriaControle();
    IVeiculoControle veiculoControle = new VeiculoControle();
    
    private final String CAMPODINHEIRO_DEFAULT = "R$ 0,00";
    //private final String CAMPODATA_DEFAULT = "  /  /    ";
    
    public TelaVeiculo() {
        initComponents();
        setarComboBox();
        
        try {
            listar(veiculoControle.listar());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void listar(ArrayList<Veiculo> array){
        Iterator<Veiculo> veiculos = array.iterator();
        DefaultTableModel model = (DefaultTableModel) jTableVeiculo.getModel();
        model.setNumRows(0);
        
        while(veiculos.hasNext()){
            Veiculo veiculo = veiculos.next();
            String dados[] = veiculo.toString().split(";");
            try {
                dados[3] = categoriaControle.buscar(Integer.parseInt(dados[3])).getDescricao();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            dados[4] = Numero.real(dados[4]);
            dados[5] = Numero.real(dados[5]);
            dados[8] = Numero.numeral(dados[8]) + " Km";
            dados[12] = "";
            model.addRow(dados);
        }
        jTableVeiculo.setModel(model);
    }
    
    public void setarComboBox(){
        try {
            ArrayList<Modelo> array = modeloControle.listar();
            Iterator<Modelo> modelos = array.iterator();
            String vetorModelos[] = new String[array.size()];
            for(int i = 0; i < array.size(); i++){
                vetorModelos[i] = modelos.next().getDescricao();
            }
            if(vetorModelos.length != 0){
                jComboBoxModelo.setModel(new DefaultComboBoxModel<>(vetorModelos));
                setarImagemModelo();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        try {
            ArrayList<Categoria> array = categoriaControle.listar();
            Iterator<Categoria> categorias = array.iterator();
            String vetorCategorias[] = new String[array.size()];
            for(int i = 0; i < array.size(); i++){
                vetorCategorias[i] = categorias.next().getDescricao();
            }
            if(vetorCategorias.length != 0) jComboBoxCategoria.setModel(new DefaultComboBoxModel<>(vetorCategorias));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        jComboBoxTipoDoVeiculo.setModel(new DefaultComboBoxModel<>(TipoDoVeiculo.values()));
        jComboBoxTipoDoCombustivel.setModel(new DefaultComboBoxModel<>(TipoDoCombustivel.values()));
        jComboBoxSituacaoDoVeiculo.setModel(new DefaultComboBoxModel<>(SituacaoDoVeiculo.values()));
    }
    
    public void limparCampos(){
        jTableVeiculo.clearSelection();
        jTextFieldIdentificador.setText("");
        jTextFieldPlaca.setText("");
        jTextFieldRenavam.setText("");
        jComboBoxTipoDoVeiculo.setSelectedIndex(0);
        jComboBoxTipoDoCombustivel.setSelectedIndex(0);
        jComboBoxSituacaoDoVeiculo.setSelectedIndex(0);
        jTextFieldKilometragem.setText(" Km");
        jTextFieldAnoDeFabricacao.setText("");
        jTextFieldAnoDoModelo.setText("");
        jComboBoxModelo.setSelectedIndex(0);
        setarImagemModelo();
        jComboBoxCategoria.setSelectedIndex(0);
        jTextFieldPrecoDeCompra.setText(CAMPODINHEIRO_DEFAULT);
        jTextFieldPrecoDeVenda.setText(CAMPODINHEIRO_DEFAULT);
    }
    
    public void setarImagemModelo(){
        try {
            ImageIcon imagemModelo = new ImageIcon(modeloControle.buscar(jComboBoxModelo.getSelectedItem().toString()).getUrl());
            imagemModelo.setImage(imagemModelo.getImage().getScaledInstance(50, 50, 0));
            jLabelModelo.setIcon(imagemModelo);
        } catch (Exception e) {
            e.printStackTrace();
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
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldIdentificador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPlaca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldRenavam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTipoDoVeiculo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPrecoDeCompra = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldAnoDeFabricacao = new javax.swing.JTextField();
        jTextFieldAnoDoModelo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxTipoDoCombustivel = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxModelo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVeiculo = new javax.swing.JTable();
        jButtonIncluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jLabelModelo = new javax.swing.JLabel();
        jComboBoxSituacaoDoVeiculo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldKilometragem = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldPrecoDeVenda = new javax.swing.JTextField();

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

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("VEÍCULOS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Identificador");

        jTextFieldIdentificador.setBackground(new java.awt.Color(242, 247, 246));
        jTextFieldIdentificador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldIdentificador.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Placa");

        jTextFieldPlaca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPlacaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Renavam");

        jTextFieldRenavam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldRenavam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldRenavamKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Tipo do Veículo");

        jComboBoxTipoDoVeiculo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTipoDoVeiculo.setFocusable(false);
        jComboBoxTipoDoVeiculo.setPreferredSize(new java.awt.Dimension(208, 22));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Preço de Compra");

        jTextFieldPrecoDeCompra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldPrecoDeCompra.setText("R$ 0,00");
        jTextFieldPrecoDeCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoDeCompraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoDeCompraKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Ano de Fabricação");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Ano do Modelo");

        jTextFieldAnoDeFabricacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldAnoDeFabricacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAnoDeFabricacaoKeyTyped(evt);
            }
        });

        jTextFieldAnoDoModelo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldAnoDoModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAnoDoModeloKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Tipo do Combustível");

        jComboBoxTipoDoCombustivel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTipoDoCombustivel.setFocusable(false);
        jComboBoxTipoDoCombustivel.setPreferredSize(new java.awt.Dimension(208, 22));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Modelo");

        jComboBoxModelo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxModelo.setFocusable(false);
        jComboBoxModelo.setPreferredSize(new java.awt.Dimension(208, 22));
        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Categoria");

        jComboBoxCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxCategoria.setFocusable(false);
        jComboBoxCategoria.setPreferredSize(new java.awt.Dimension(208, 22));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(952, 244));
        jScrollPane1.setViewportView(jTableVeiculo);
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTableVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR", "PLACA", "RENAVAM", "CATEGORIA", "PREÇO DE COMPRA", "PREÇO DE VENDA", "ANO DE FABRICAÇÃO", "ANO DO MODELO", "QUILOMETRAGEM", "TIPO DO COMBUSTÍVEL", "TIPO DO VEÍCULO", "SITUAÇÃO DO VEÍCULO", "MODELO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVeiculo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableVeiculo.setFocusable(false);
        jTableVeiculo.setName("TabelaVeículo"); // NOI18N
        jTableVeiculo.setRowHeight(50);
        jTableVeiculo.setSelectionBackground(new java.awt.Color(52, 135, 231));
        jTableVeiculo.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableVeiculo.setShowHorizontalLines(true);
        jTableVeiculo.getTableHeader().setResizingAllowed(false);
        jTableVeiculo.getTableHeader().setReorderingAllowed(false);
        jTableVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVeiculoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVeiculo);
        if (jTableVeiculo.getColumnModel().getColumnCount() > 0) {
            jTableVeiculo.getColumnModel().getColumn(0).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(0).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(1).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(1).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(2).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(2).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(3).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(3).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(4).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(4).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(5).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(5).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(6).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(6).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(7).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(7).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(8).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(8).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(9).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(9).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(10).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(10).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(11).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(11).setCellRenderer(new TableRenderer());
            jTableVeiculo.getColumnModel().getColumn(12).setMinWidth(150);
            jTableVeiculo.getColumnModel().getColumn(12).setCellRenderer(new TableRenderer());
        }

        jButtonIncluir.setBackground(new java.awt.Color(250, 250, 250));
        jButtonIncluir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonIncluir.setText("INCLUIR VEÍCULO");
        jButtonIncluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonAlterar.setBackground(new java.awt.Color(250, 250, 250));
        jButtonAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAlterar.setText("ALTERAR VEÍCULO");
        jButtonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jLabelModelo.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabelModelo.setPreferredSize(new java.awt.Dimension(50, 50));

        jComboBoxSituacaoDoVeiculo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxSituacaoDoVeiculo.setFocusable(false);
        jComboBoxSituacaoDoVeiculo.setPreferredSize(new java.awt.Dimension(208, 22));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Situação do Veículo");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Kilometragem");

        jTextFieldKilometragem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldKilometragem.setText(" Km");
        jTextFieldKilometragem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKilometragemKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Preço de Venda");

        jTextFieldPrecoDeVenda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldPrecoDeVenda.setText("R$ 0,00");
        jTextFieldPrecoDeVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoDeVendaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoDeVendaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxTipoDoCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxTipoDoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldAnoDoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldAnoDeFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldKilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxSituacaoDoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabelModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldPrecoDeCompra)
                                            .addComponent(jTextFieldPrecoDeVenda))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextFieldIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldRenavam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxTipoDoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldPrecoDeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonIncluir)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxTipoDoCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jButtonAlterar)
                            .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxSituacaoDoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldKilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldPrecoDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldAnoDeFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextFieldAnoDoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
        Run.telaPrincipal.jPanelVeiculosExp.setVisible(false);
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jTextFieldPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPlacaKeyTyped
        // TODO add your handling code here:
        Texto.validarLetrasENumeros(jTextFieldPlaca, 7, evt, true);
    }//GEN-LAST:event_jTextFieldPlacaKeyTyped

    private void jTextFieldRenavamKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRenavamKeyTyped
        // TODO add your handling code here:
        Texto.validarNumero(jTextFieldRenavam, 9, evt);
    }//GEN-LAST:event_jTextFieldRenavamKeyTyped

    private void jTextFieldPrecoDeCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoDeCompraKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) apagar = true;
        else apagar = false;
    }//GEN-LAST:event_jTextFieldPrecoDeCompraKeyPressed

    private void jTextFieldPrecoDeCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoDeCompraKeyTyped
        // TODO add your handling code here:
        jTextFieldPrecoDeCompra.setText(Numero.validarCampo(jTextFieldPrecoDeCompra.getText(), 10, apagar, evt));
    }//GEN-LAST:event_jTextFieldPrecoDeCompraKeyTyped

    private void jTextFieldPrecoDeVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoDeVendaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE) apagar = true;
        else apagar = false;
    }//GEN-LAST:event_jTextFieldPrecoDeVendaKeyPressed

    private void jTextFieldPrecoDeVendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoDeVendaKeyTyped
        // TODO add your handling code here:
        jTextFieldPrecoDeVenda.setText(Numero.validarCampo(jTextFieldPrecoDeVenda.getText(), 10, apagar, evt));
    }//GEN-LAST:event_jTextFieldPrecoDeVendaKeyTyped

    private void jTextFieldAnoDeFabricacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAnoDeFabricacaoKeyTyped
        // TODO add your handling code here:
        Texto.validarNumero(jTextFieldAnoDeFabricacao, 4, evt);
    }//GEN-LAST:event_jTextFieldAnoDeFabricacaoKeyTyped

    private void jTextFieldAnoDoModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAnoDoModeloKeyTyped
        // TODO add your handling code here:
        Texto.validarNumero(jTextFieldAnoDoModelo, 4, evt);
    }//GEN-LAST:event_jTextFieldAnoDoModeloKeyTyped

    private void jTextFieldKilometragemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldKilometragemKeyTyped
        // TODO add your handling code here:
        Texto.validarNumero(jTextFieldKilometragem, 6, evt);
        if(!jTextFieldKilometragem.getText().equals("")){
            jTextFieldKilometragem.setText(Numero.numeral(jTextFieldKilometragem.getText()));
        }
        int caret = jTextFieldKilometragem.getCaretPosition();
        jTextFieldKilometragem.setText(jTextFieldKilometragem.getText() + " Km");
        jTextFieldKilometragem.setCaretPosition(caret);
    }//GEN-LAST:event_jTextFieldKilometragemKeyTyped

    private void jTableVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVeiculoMouseClicked
        // TODO add your handling code here:
        if(jTableVeiculo.getSelectedRow() != -1){
            try {
                linha = jTableVeiculo.getSelectedRow();
                Categoria categoria = categoriaControle.buscar(jTableVeiculo.getValueAt(linha, 3).toString());
                Veiculo veiculo = new Veiculo(Integer.parseInt(jTableVeiculo.getValueAt(linha, 0).toString()), 
                        jTableVeiculo.getValueAt(linha, 1).toString(), 
                        jTableVeiculo.getValueAt(linha, 2).toString(), 
                        categoria, Numero.numeros(jTableVeiculo.getValueAt(linha, 4).toString()), 
                        Numero.numeros(jTableVeiculo.getValueAt(linha, 5).toString()), 
                        Integer.parseInt(jTableVeiculo.getValueAt(linha, 6).toString()), 
                        Integer.parseInt(jTableVeiculo.getValueAt(linha, 7).toString()), 
                        Numero.numerosSemPonto(jTableVeiculo.getValueAt(linha, 8).toString()), 
                        TipoDoCombustivel.valueOf(jTableVeiculo.getValueAt(linha, 9).toString()), 
                        TipoDoVeiculo.valueOf(jTableVeiculo.getValueAt(linha, 10).toString()), 
                        SituacaoDoVeiculo.valueOf(jTableVeiculo.getValueAt(linha, 11).toString()), 
                        veiculoControle.buscar(Integer.parseInt(jTableVeiculo.getValueAt(linha, 0).toString())).getModelo());
                jTextFieldIdentificador.setText(veiculo.getId() + "");
                jTextFieldPlaca.setText(veiculo.getPlaca());
                jTextFieldRenavam.setText(veiculo.getRenavam() + "");
                jComboBoxCategoria.setSelectedItem(veiculo.getCategoria().getDescricao());
                jTextFieldPrecoDeCompra.setText(Numero.real(veiculo.getPrecoDeCompra()));
                jTextFieldPrecoDeVenda.setText(Numero.real(veiculo.getPrecoDeVenda()));
                jTextFieldAnoDeFabricacao.setText(veiculo.getAnoFabricacao() + "");
                jTextFieldAnoDoModelo.setText(veiculo.getAnoModelo() + "");
                jTextFieldKilometragem.setText(Numero.numeral(veiculo.getKilometragem()) + " Km");
                jComboBoxTipoDoCombustivel.setSelectedItem(veiculo.getCombustivel());
                jComboBoxTipoDoVeiculo.setSelectedItem(veiculo.getCarro());
                jComboBoxSituacaoDoVeiculo.setSelectedItem(veiculo.getSituacao());
                jComboBoxModelo.setSelectedItem(veiculo.getModelo().getDescricao());
                
                setarImagemModelo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTableVeiculoMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        // TODO add your handling code here:
        try {
            Veiculo veiculo = new Veiculo(0, jTextFieldPlaca.getText(), jTextFieldRenavam.getText(), 
                    categoriaControle.buscar(jComboBoxCategoria.getSelectedItem().toString()), 
                    Numero.numeros(jTextFieldPrecoDeCompra.getText()), 
                    Numero.numeros(jTextFieldPrecoDeVenda.getText()), 
                    Numero.numerosSemPonto(jTextFieldAnoDeFabricacao.getText()), 
                    Numero.numerosSemPonto(jTextFieldAnoDoModelo.getText()), 
                    Numero.numerosSemPonto(jTextFieldKilometragem.getText()), 
                    TipoDoCombustivel.valueOf(jComboBoxTipoDoCombustivel.getSelectedItem().toString()), 
                    TipoDoVeiculo.valueOf(jComboBoxTipoDoVeiculo.getSelectedItem().toString()), 
                    SituacaoDoVeiculo.valueOf(jComboBoxSituacaoDoVeiculo.getSelectedItem().toString()), 
                    modeloControle.buscar(jComboBoxModelo.getSelectedItem().toString()));
            
            veiculoControle.incluir(veiculo);
            listar(veiculoControle.listar());
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        try {
            Veiculo veiculo = new Veiculo(Integer.parseInt(jTextFieldIdentificador.getText()), 
                    jTextFieldPlaca.getText(), jTextFieldRenavam.getText(), 
                    categoriaControle.buscar(jComboBoxCategoria.getSelectedItem().toString()), 
                    Numero.numeros(jTextFieldPrecoDeCompra.getText()), 
                    Numero.numeros(jTextFieldPrecoDeVenda.getText()), 
                    Numero.numerosSemPonto(jTextFieldAnoDeFabricacao.getText()), 
                    Numero.numerosSemPonto(jTextFieldAnoDoModelo.getText()), 
                    Numero.numerosSemPonto(jTextFieldKilometragem.getText()), 
                    TipoDoCombustivel.valueOf(jComboBoxTipoDoCombustivel.getSelectedItem().toString()), 
                    TipoDoVeiculo.valueOf(jComboBoxTipoDoVeiculo.getSelectedItem().toString()), 
                    SituacaoDoVeiculo.valueOf(jComboBoxSituacaoDoVeiculo.getSelectedItem().toString()), 
                    modeloControle.buscar(jComboBoxModelo.getSelectedItem().toString()));
            veiculoControle.alterar(veiculo);
            listar(veiculoControle.listar());
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
        // TODO add your handling code here:
        setarImagemModelo();
    }//GEN-LAST:event_jComboBoxModeloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxModelo;
    private javax.swing.JComboBox<SituacaoDoVeiculo> jComboBoxSituacaoDoVeiculo;
    private javax.swing.JComboBox<TipoDoCombustivel> jComboBoxTipoDoCombustivel;
    private javax.swing.JComboBox<TipoDoVeiculo> jComboBoxTipoDoVeiculo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVeiculo;
    private javax.swing.JTextField jTextFieldAnoDeFabricacao;
    private javax.swing.JTextField jTextFieldAnoDoModelo;
    private javax.swing.JTextField jTextFieldIdentificador;
    private javax.swing.JTextField jTextFieldKilometragem;
    private javax.swing.JTextField jTextFieldPlaca;
    private javax.swing.JTextField jTextFieldPrecoDeCompra;
    private javax.swing.JTextField jTextFieldPrecoDeVenda;
    private javax.swing.JTextField jTextFieldRenavam;
    // End of variables declaration//GEN-END:variables
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.jp1.visao;

import com.jp1.controle.AcessoriosControle;
import com.jp1.controle.CategoriaControle;
import com.jp1.controle.ClienteControle;
import com.jp1.controle.IAcessoriosControle;
import com.jp1.controle.ICategoriaControle;
import com.jp1.controle.IClienteControle;
import com.jp1.controle.ILocacaoControle;
import com.jp1.controle.IMotoristaControle;
import com.jp1.controle.IVeiculoControle;
import com.jp1.controle.LocacaoControle;
import com.jp1.controle.MotoristaControle;
import com.jp1.controle.VeiculoControle;
import com.jp1.modelos.Acessorios;
import com.jp1.modelos.Categoria;
import com.jp1.modelos.Endereco;
import com.jp1.modelos.Estado;
import com.jp1.modelos.Locacao;
import com.jp1.modelos.Motorista;
import com.jp1.modelos.Telefone;
import com.jp1.modelos.TipoDoCliente;
import com.jp1.modelos.Veiculo;
import com.jp1.tools.Data;
import com.jp1.tools.Numero;
import com.jp1.tools.Texto;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author aluno
 */
public class TelaLocacao extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaLocacao
     */
    TelaTelefone telaTelefone = new TelaTelefone();
    TelaEndereco telaEndereco = new TelaEndereco();
    
    int linha = 0;
    String urlImagemMotorista = "";
    boolean apagar = false;
    
    IMotoristaControle motoristaControle = new MotoristaControle();
    ICategoriaControle categoriaControle = new CategoriaControle();
    IVeiculoControle veiculoControle = new VeiculoControle();
    ILocacaoControle locacaoControle = new LocacaoControle();
    IClienteControle clienteControle = new ClienteControle();
    IAcessoriosControle acessoriosControle = new AcessoriosControle();
    
    Locacao locacao = null;
    //private final String CAMPODATA_DEFAULT = "  /  /    ";
    
    public TelaLocacao() {
        initComponents();
        AdicionarTela(jInternalFrameLocacao);
        listarComboBox();
        try {
            listar(veiculoControle.listarNaoLocados(new Data(14, 12, 2022), categoriaControle.buscar(jComboBoxCategoria.getSelectedItem().toString())));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void AdicionarTela(javax.swing.JInternalFrame tela){
        tela.setSize(941, 417);
        ((BasicInternalFrameUI)tela.getUI()).setNorthPane(null);
        jDesktopPane1.removeAll();
        jDesktopPane1.add(tela);
        tela.setVisible(true);
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
    
    public void listarComboBox(){
        try {
            ArrayList<Categoria> array = categoriaControle.listar();
            Iterator<Categoria> categorias = array.iterator();
            
            String categoria[] = new String[array.size()];
            
            for(int i = 0; i < categoria.length; i++){
                categoria[i] = categorias.next().toString().split(";")[1];
            }
            
            if(categoria.length != 0){
                jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(categoria));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        try {
            ArrayList<Acessorios> array = acessoriosControle.listar();
            Iterator<Acessorios> acessorios = array.iterator();
            
            String acessorio[] = new String[array.size()];
            
            for(int i = 0; i < acessorio.length; i++){
                Acessorios aux = acessorios.next();
                if(i == 0) jTextFieldQuantidadeDisponivel.setText((aux.getQuantidadeTotal() - aux.getQuantidadeLocada()) + "");
                acessorio[i] = aux.toString().split(";")[1];
            }
            
            if(acessorio.length != 0){
                jComboBoxAcessorios.setModel(new javax.swing.DefaultComboBoxModel<>(acessorio));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        jComboBoxTipoDoCliente.setModel(new DefaultComboBoxModel<>(TipoDoCliente.values()));
    }
    
    public void setarMascara(javax.swing.JFormattedTextField campo, String mask, char placeHolderCharcter){
        try{
            MaskFormatter mascara = new MaskFormatter();
            mascara.setMask(mask);
            mascara.setPlaceholderCharacter(placeHolderCharcter);
            campo.setFormatterFactory(new DefaultFormatterFactory(mascara));
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void setarCamposFinal(){
        try {
            Acessorios acessorio = acessoriosControle.buscar(jComboBoxAcessorios.getSelectedItem().toString());
        
            jTextFieldQuantidadeDisponivel.setText((acessorio.getQuantidadeTotal() - acessorio.getQuantidadeLocada()) + "");
            int diasLocados = Data.dias(locacao.getDataInicio(), locacao.getDataFim()) + 1;
            float valorTotal = acessorio.getValorDaLocacao() * diasLocados + locacao.getVeiculo().getCategoria().getValorDaLocacao() * diasLocados;
            jTextFieldValorTotal.setText(Numero.real(valorTotal) + "");
            locacao.setValorDaLocacao(valorTotal);
            float valorCaucao = valorTotal + valorTotal * 0.5f;
            jTextFieldValorCaucao.setText(Numero.real(valorCaucao) + "");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jInternalFrameMotorista = new javax.swing.JInternalFrame();
        jPanelMotorista = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMotoristaIdentificador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMotoristaNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldMotoristaCNH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonTelefone = new javax.swing.JButton();
        jButtonEndereco = new javax.swing.JButton();
        jButtonMotoristaProximo = new javax.swing.JButton();
        jFormattedTextFieldMotoristaDataDeVencimento = new javax.swing.JFormattedTextField();
        setarMascara(jFormattedTextFieldMotoristaDataDeVencimento, "##/##/####", ' ');
        jInternalFrameLocacao = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldMotoristaIdentificador1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipoDoCliente = new javax.swing.JComboBox<>();
        jLabelCPF_CNPJ = new javax.swing.JLabel();
        jFormattedTextFieldCPF_CNPJ = new javax.swing.JFormattedTextField();
        setarMascara(jFormattedTextFieldCPF_CNPJ, "###.###.###-##", ' ');
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVeiculo = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jFormattedTextFieldDataInicio = new javax.swing.JFormattedTextField();
        setarMascara(jFormattedTextFieldDataInicio, "##/##/####", ' ');
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextFieldDataFim = new javax.swing.JFormattedTextField();
        setarMascara(jFormattedTextFieldDataFim, "##/##/####", ' ');
        jButtonLocacaoProximo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jInternalFrameFinal = new javax.swing.JInternalFrame();
        jPanelMotorista1 = new javax.swing.JPanel();
        jButtonConfirmarLocacao = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxAcessorios = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldQuantidadeDisponivel = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldValorTotal = new javax.swing.JTextField();
        jTextFieldValorCaucao = new javax.swing.JTextField();
        jCheckBoxPago = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        jInternalFrameMotorista.setBorder(null);
        jInternalFrameMotorista.setPreferredSize(new java.awt.Dimension(941, 417));
        jInternalFrameMotorista.setVisible(true);

        jPanelMotorista.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMotorista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMotoristaMouseEntered(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Identificador");

        jTextFieldMotoristaIdentificador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMotoristaIdentificador.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nome");

        jTextFieldMotoristaNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMotoristaNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMotoristaNomeKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Número da CNH");

        jTextFieldMotoristaCNH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMotoristaCNH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMotoristaCNHKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Motorista");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Data de Vencimento");

        jButtonBuscar.setBackground(new java.awt.Color(250, 250, 250));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBuscar.setText("BUSCAR IMAGEM");
        jButtonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscar.setFocusable(false);
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(138, 30));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabelLogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabelLogo.setPreferredSize(new java.awt.Dimension(152, 152));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Foto da CNH");

        jButtonTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonTelefone.setText("Telefone");
        jButtonTelefone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonTelefone.setFocusable(false);
        jButtonTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTelefoneActionPerformed(evt);
            }
        });

        jButtonEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEndereco.setText("Endereço");
        jButtonEndereco.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEndereco.setFocusable(false);
        jButtonEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnderecoActionPerformed(evt);
            }
        });

        jButtonMotoristaProximo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonMotoristaProximo.setText("Próximo");
        jButtonMotoristaProximo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMotoristaProximo.setFocusable(false);
        jButtonMotoristaProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMotoristaProximoActionPerformed(evt);
            }
        });

        jFormattedTextFieldMotoristaDataDeVencimento.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextFieldMotoristaDataDeVencimento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelMotoristaLayout = new javax.swing.GroupLayout(jPanelMotorista);
        jPanelMotorista.setLayout(jPanelMotoristaLayout);
        jPanelMotoristaLayout.setHorizontalGroup(
            jPanelMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMotoristaLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanelMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldMotoristaIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldMotoristaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                        .addGroup(jPanelMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(jButtonTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jButtonEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jButtonMotoristaProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldMotoristaCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextFieldMotoristaDataDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanelMotoristaLayout.setVerticalGroup(
            jPanelMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addGroup(jPanelMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldMotoristaIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldMotoristaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanelMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldMotoristaCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextFieldMotoristaDataDeVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGroup(jPanelMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelMotoristaLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanelMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonTelefone)
                            .addComponent(jButtonEndereco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonMotoristaProximo)))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrameMotoristaLayout = new javax.swing.GroupLayout(jInternalFrameMotorista.getContentPane());
        jInternalFrameMotorista.getContentPane().setLayout(jInternalFrameMotoristaLayout);
        jInternalFrameMotoristaLayout.setHorizontalGroup(
            jInternalFrameMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMotorista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrameMotoristaLayout.setVerticalGroup(
            jInternalFrameMotoristaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMotorista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jInternalFrameLocacao.setBorder(null);
        jInternalFrameLocacao.setPreferredSize(new java.awt.Dimension(941, 417));
        jInternalFrameLocacao.setVisible(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(941, 417));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Identificador");

        jTextFieldMotoristaIdentificador1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMotoristaIdentificador1.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Tipo do Cliente");

        jComboBoxTipoDoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoDoClienteActionPerformed(evt);
            }
        });

        jLabelCPF_CNPJ.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCPF_CNPJ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCPF_CNPJ.setText("CPF");

        jFormattedTextFieldCPF_CNPJ.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextFieldCPF_CNPJ.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jScrollPane1.setPreferredSize(new java.awt.Dimension(952, 244));
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
        jTableVeiculo.setName("TabelaVeículos"); // NOI18N
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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Categoria");

        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Data Início");

        jFormattedTextFieldDataInicio.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextFieldDataInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jFormattedTextFieldDataInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDataInicioKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Data Fim");

        jFormattedTextFieldDataFim.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jFormattedTextFieldDataFim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonLocacaoProximo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonLocacaoProximo.setText("Próximo");
        jButtonLocacaoProximo.setFocusable(false);
        jButtonLocacaoProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLocacaoProximoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Modelo");

        jTextFieldModelo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldModelo.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldMotoristaIdentificador1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxTipoDoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabelCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextFieldCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(363, 363, 363)
                        .addComponent(jButtonLocacaoProximo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldMotoristaIdentificador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxTipoDoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCPF_CNPJ)
                    .addComponent(jFormattedTextFieldCPF_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jFormattedTextFieldDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jFormattedTextFieldDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLocacaoProximo)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jInternalFrameLocacaoLayout = new javax.swing.GroupLayout(jInternalFrameLocacao.getContentPane());
        jInternalFrameLocacao.getContentPane().setLayout(jInternalFrameLocacaoLayout);
        jInternalFrameLocacaoLayout.setHorizontalGroup(
            jInternalFrameLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jInternalFrameLocacaoLayout.setVerticalGroup(
            jInternalFrameLocacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jInternalFrameFinal.setBorder(null);
        jInternalFrameFinal.setPreferredSize(new java.awt.Dimension(941, 417));
        jInternalFrameFinal.setVisible(true);

        jPanelMotorista1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMotorista1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelMotorista1MouseEntered(evt);
            }
        });

        jButtonConfirmarLocacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonConfirmarLocacao.setText("Confirmar Locação");
        jButtonConfirmarLocacao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConfirmarLocacao.setFocusable(false);
        jButtonConfirmarLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarLocacaoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Acessórios");

        jComboBoxAcessorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAcessoriosActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Quantidade Disponível");

        jTextFieldQuantidadeDisponivel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldQuantidadeDisponivel.setText("0 un");
        jTextFieldQuantidadeDisponivel.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Valor Total");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Valor Caução");

        jTextFieldValorTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValorTotal.setEnabled(false);

        jTextFieldValorCaucao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldValorCaucao.setEnabled(false);

        jCheckBoxPago.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jCheckBoxPago.setText("Pago");

        javax.swing.GroupLayout jPanelMotorista1Layout = new javax.swing.GroupLayout(jPanelMotorista1);
        jPanelMotorista1.setLayout(jPanelMotorista1Layout);
        jPanelMotorista1Layout.setHorizontalGroup(
            jPanelMotorista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMotorista1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConfirmarLocacao)
                .addGap(398, 398, 398))
            .addGroup(jPanelMotorista1Layout.createSequentialGroup()
                .addGroup(jPanelMotorista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMotorista1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanelMotorista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelMotorista1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxAcessorios, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(134, 134, 134)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldQuantidadeDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMotorista1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldValorCaucao, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelMotorista1Layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jCheckBoxPago, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanelMotorista1Layout.setVerticalGroup(
            jPanelMotorista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMotorista1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanelMotorista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxAcessorios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldQuantidadeDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelMotorista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldValorCaucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jCheckBoxPago)
                .addGap(27, 27, 27)
                .addComponent(jButtonConfirmarLocacao)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrameFinalLayout = new javax.swing.GroupLayout(jInternalFrameFinal.getContentPane());
        jInternalFrameFinal.getContentPane().setLayout(jInternalFrameFinalLayout);
        jInternalFrameFinalLayout.setHorizontalGroup(
            jInternalFrameFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMotorista1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrameFinalLayout.setVerticalGroup(
            jInternalFrameFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMotorista1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOCAÇÃO");

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(941, 417));
        jDesktopPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jDesktopPane1MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 941, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldMotoristaNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMotoristaNomeKeyTyped
        // TODO add your handling code here:
        Texto.validarLetrasEEspaco(jTextFieldMotoristaNome, 0, evt, false);
    }//GEN-LAST:event_jTextFieldMotoristaNomeKeyTyped

    private void jTextFieldMotoristaCNHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMotoristaCNHKeyTyped
        // TODO add your handling code here:
        Texto.validarNumero(jTextFieldMotoristaCNH, 9, evt);
    }//GEN-LAST:event_jTextFieldMotoristaCNHKeyTyped

    private void jPanelMotoristaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMotoristaMouseEntered
        // TODO add your handling code here:
        Run.telaPrincipal.jPanelVeiculosExp.setVisible(false);
    }//GEN-LAST:event_jPanelMotoristaMouseEntered

    private void jDesktopPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDesktopPane1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jDesktopPane1MouseEntered

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        try {
            ExploradorDeArquivos fc = new ExploradorDeArquivos();
            fc.setDialogTitle("Selecionar Imagem");

            fc.setAcceptAllFileFilterUsed(false);
            fc.addChoosableFileFilter(new FileNameExtensionFilter("Imagens (*.jpg, *.jpeg, *.png)", "jpg", "jpeg", "png"));

            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.abrir(this);
            File arquivo = fc.getSelectedFile();
            if(arquivo != null){
                urlImagemMotorista = arquivo.getPath();
                ImageIcon iconLogo = new ImageIcon(urlImagemMotorista);
                iconLogo.setImage(iconLogo.getImage().getScaledInstance(
                    jLabelLogo.getWidth(),jLabelLogo.getHeight(),1));
            jLabelLogo.setIcon(iconLogo);
        }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTelefoneActionPerformed
        // TODO add your handling code here:
        Point local = jButtonTelefone.getLocationOnScreen();
        local.setLocation(local.getX() - 150, local.getY() - 50);
        telaTelefone.setLocation(local);
        telaTelefone.setVisible(true);
    }//GEN-LAST:event_jButtonTelefoneActionPerformed

    private void jButtonEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnderecoActionPerformed
        // TODO add your handling code here:
        Point local = jButtonEndereco.getLocationOnScreen();
        local.setLocation(local.getX() - 150, local.getY() - 50);
        telaEndereco.setLocation(local);
        telaEndereco.setVisible(true);
    }//GEN-LAST:event_jButtonEnderecoActionPerformed

    private void jButtonMotoristaProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMotoristaProximoActionPerformed
        // TODO add your handling code here:
        
            Telefone telefone = new Telefone(Integer.parseInt(Numero.numerosSemPonto(telaTelefone.jFormattedTextFieldDDD.getText())), 
                    Integer.parseInt(Numero.numerosSemPonto(telaTelefone.jFormattedTextFieldDDI.getText())), 
                    Integer.parseInt(Numero.numerosSemPonto(telaTelefone.jTextFieldNumero.getText())));
            
            Endereco endereco = new Endereco(telaEndereco.jTextFieldLogradouro.getText(), 
                    telaEndereco.jTextFieldComplemento.getText(), 
                    telaEndereco.jFormattedTextFieldCEP.getText(), 
                    Estado.valueOf(telaEndereco.jComboBoxEstado.getSelectedItem().toString()), 
                    telaEndereco.jTextFieldCidade.getText(), telaEndereco.jTextFieldBairro.getText());
            
        Motorista motorista = new Motorista(0, new Data(jFormattedTextFieldMotoristaDataDeVencimento.getText()), jTextFieldMotoristaNome.getText(), jTextFieldMotoristaCNH.getText(), urlImagemMotorista, telefone, endereco);
        
        
        try {
            MotoristaControle.verificarCampos(motorista);
            LocacaoControle.verificarMotorista(motorista, locacao);
            locacao.setMotorista(motorista);
            
            AdicionarTela(jInternalFrameFinal);
            setarCamposFinal();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButtonMotoristaProximoActionPerformed

    private void jComboBoxTipoDoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoDoClienteActionPerformed
        // TODO add your handling code here:
        switch (TipoDoCliente.valueOf(jComboBoxTipoDoCliente.getSelectedItem().toString())) {
            case PESSOAFISICA:
                jLabelCPF_CNPJ.setText("CPF");
                setarMascara(jFormattedTextFieldCPF_CNPJ, "###.###.###-##", ' ');
            break;
            case PESSOAJURIDICA:
                jLabelCPF_CNPJ.setText("CNPJ");
                setarMascara(jFormattedTextFieldCPF_CNPJ, "##.###.###/####-##", ' ');
            break;
        }
    }//GEN-LAST:event_jComboBoxTipoDoClienteActionPerformed

    private void jTableVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVeiculoMouseClicked
        // TODO add your handling code here:
        if(jTableVeiculo.getSelectedRow() != -1){
            linha = jTableVeiculo.getSelectedRow();
            try {
                jTextFieldModelo.setText(veiculoControle.buscar(Integer.parseInt(jTableVeiculo.getValueAt(linha, 0).toString())).getModelo().getDescricao());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }else jTextFieldModelo.setText("");
    }//GEN-LAST:event_jTableVeiculoMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
        //limparCampos();
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        // TODO add your handling code here:
        try {
            listar(veiculoControle.listarNaoLocados(new Data(jFormattedTextFieldDataInicio.getText()), categoriaControle.buscar(jComboBoxCategoria.getSelectedItem().toString())));
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jButtonLocacaoProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLocacaoProximoActionPerformed
        // TODO add your handling code here:
        try {
            locacao = new Locacao(0, new Data(jFormattedTextFieldDataInicio.getText()), 
                    new Data(jFormattedTextFieldDataFim.getText()), 
                    categoriaControle.buscar(jComboBoxCategoria.getSelectedItem().toString()).getValorDaLocacao(), 
                    null, clienteControle.buscar(jFormattedTextFieldCPF_CNPJ.getText()), 
                    veiculoControle.buscar(Integer.parseInt(jTableVeiculo.getValueAt(jTableVeiculo.getSelectedRow(), 0).toString())), null);
            locacaoControle.verificarCampos(locacao);
            AdicionarTela(jInternalFrameMotorista);
        } catch (Exception e) {
            if(jTableVeiculo.getSelectedRow() == -1) JOptionPane.showMessageDialog(null, "Selecione um veículo primeiro.");
            else{
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
                
            }
        }
    }//GEN-LAST:event_jButtonLocacaoProximoActionPerformed

    private void jFormattedTextFieldDataInicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataInicioKeyTyped
        // TODO add your handling code here:
        if(jFormattedTextFieldDataInicio.getText().length() == 10){
            try {
                listar(veiculoControle.listarNaoLocados(new Data(jFormattedTextFieldDataInicio.getText()), categoriaControle.buscar(jComboBoxCategoria.getSelectedItem().toString())));
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jFormattedTextFieldDataInicioKeyTyped

    private void jButtonConfirmarLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarLocacaoActionPerformed
        // TODO add your handling code here:
        if(jCheckBoxPago.isSelected()){
            try {
                locacao.setAcessorios(acessoriosControle.buscar(jComboBoxAcessorios.getSelectedItem().toString()));
                Acessorios novoAcessorio = locacao.getAcessorios();
                novoAcessorio.setQuantidadeLocada(novoAcessorio.getQuantidadeLocada() + 1);
                acessoriosControle.alterar(novoAcessorio);
                
                motoristaControle.incluir(locacao.getMotorista());
                locacao.setMotorista(motoristaControle.buscar(locacao.getMotorista().getNumeroCNH()));
                locacaoControle.incluir(locacao);
                JOptionPane.showMessageDialog(null, "Locação realizada com sucesso!");
                Run.telaPrincipal.adicionarTela(new TelaWelcome());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }else JOptionPane.showMessageDialog(null, "A locação precisa ser paga.");
    }//GEN-LAST:event_jButtonConfirmarLocacaoActionPerformed

    private void jPanelMotorista1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelMotorista1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelMotorista1MouseEntered

    private void jComboBoxAcessoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAcessoriosActionPerformed
        // TODO add your handling code here:
        setarCamposFinal();
    }//GEN-LAST:event_jComboBoxAcessoriosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonConfirmarLocacao;
    public javax.swing.JButton jButtonEndereco;
    private javax.swing.JButton jButtonLocacaoProximo;
    private javax.swing.JButton jButtonMotoristaProximo;
    public javax.swing.JButton jButtonTelefone;
    private javax.swing.JCheckBox jCheckBoxPago;
    private javax.swing.JComboBox<String> jComboBoxAcessorios;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JComboBox<TipoDoCliente> jComboBoxTipoDoCliente;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF_CNPJ;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataFim;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataInicio;
    private javax.swing.JFormattedTextField jFormattedTextFieldMotoristaDataDeVencimento;
    private javax.swing.JInternalFrame jInternalFrameFinal;
    private javax.swing.JInternalFrame jInternalFrameLocacao;
    private javax.swing.JInternalFrame jInternalFrameMotorista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCPF_CNPJ;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelMotorista;
    private javax.swing.JPanel jPanelMotorista1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVeiculo;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldMotoristaCNH;
    private javax.swing.JTextField jTextFieldMotoristaIdentificador;
    private javax.swing.JTextField jTextFieldMotoristaIdentificador1;
    private javax.swing.JTextField jTextFieldMotoristaNome;
    private javax.swing.JTextField jTextFieldQuantidadeDisponivel;
    private javax.swing.JTextField jTextFieldValorCaucao;
    private javax.swing.JTextField jTextFieldValorTotal;
    // End of variables declaration//GEN-END:variables
}

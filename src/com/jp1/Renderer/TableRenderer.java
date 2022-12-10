/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.Renderer;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import com.jp1.modelos.Modelo;
import com.jp1.controle.*;
import com.jp1.modelos.Veiculo;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author aluno
 */
public class TableRenderer extends DefaultTableCellRenderer {
    
    JLabel icone = new JLabel();
    IModeloControle modeloControle = new ModeloControle();
    IMarcaControle marcaControle = new MarcaControle();
    IVeiculoControle veiculoControle = new VeiculoControle();
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column){
        if(isSelected){
            this.setBackground(table.getSelectionBackground());
            this.setForeground(table.getSelectionForeground());
        }else{
            this.setBackground(table.getBackground());
            this.setForeground(table.getForeground());
        }
        
        if(value != null){
            if(value.toString().equals("")){
                ImageIcon iconLogo = null;
                try {
                    if((table.getName().equals("TabelaMarcas") || table.getName().equals("TabelaModelos")) && column == 3) iconLogo = new ImageIcon(table.getValueAt(row, 2).toString());
                    if(table.getName().equals("TabelaModelos") && column == 4){
                        ArrayList<Modelo> lista = modeloControle.listar();
                        Iterator<Modelo> modelos = lista.iterator();
                        Modelo modelo = null;
                        String urlMarca = "";
                        while(modelos.hasNext()){
                            if((modelo = modelos.next()).getId() == Integer.parseInt(table.getValueAt(row, 0).toString())){
                                urlMarca = modelo.getMarca().getUrl();
                                break;
                            }
                        }
                        iconLogo = new ImageIcon(urlMarca);
                        

                    }
                    
                    if(table.getName().equals("TabelaVeículo") && column == 12){
                        ArrayList<Veiculo> lista = veiculoControle.listar();
                        Iterator<Veiculo> veiculos = lista.iterator();
                        Veiculo veiculo = null;
                        
                        String urlModelo = "";
                        while(veiculos.hasNext()){
                            if((veiculo = veiculos.next()).getId() == Integer.parseInt(table.getValueAt(row, 0).toString())){
                                urlModelo = veiculo.getModelo().getUrl();
                                break;
                            }
                        }
                        iconLogo = new ImageIcon(urlModelo);
                        
                    }
                    
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, erro);
                }

                if(iconLogo != null){
                    int tamanho = table.getRowHeight();
                    int recuo = 20 * tamanho/ 100;
                    iconLogo.setImage(iconLogo.getImage().getScaledInstance(
                    tamanho - recuo,tamanho - recuo,1));
                    this.setIcon(iconLogo);
                }
                
                
            }else this.setText(value.toString());
            
        }
        
        this.setHorizontalAlignment(JLabel.CENTER);
        return this;
    }
}

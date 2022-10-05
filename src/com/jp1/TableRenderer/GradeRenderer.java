/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.TableRenderer;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import com.jp1.modelos.Modelo;
import com.jp1.controle.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class GradeRenderer extends DefaultTableCellRenderer {
    
    JLabel icone = new JLabel();
    Modelo modelo = new Modelo();
    IModeloControle modeloControle = new ModeloControle();
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column){
        
        if(isSelected){
            this.setBackground(table.getBackground());
            this.setForeground(table.getForeground());
        }else{
            this.setBackground(table.getBackground());
            this.setForeground(table.getForeground());
        }
        
        if(value != null){
            ImageIcon iconLogo = null;
            try {
                if(column == 3) iconLogo = new ImageIcon(table.getValueAt(row, 2).toString());
                else if(column == 4){
                    Object[] lista = modeloControle.listar().toArray();
                    String idMarca = "";
                    for(int i = 0; i < lista.length; i++){
                        if(lista[i].toString().contains(table.getValueAt(row, 1).toString())){
                            String linha[] = lista[i].toString().split(";");
                            idMarca = linha[3];
                        }
                    }
                    iconLogo = new ImageIcon(modelo.buscar(idMarca).getUrl());
                    
                }
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
            
            int tamanho = table.getRowHeight();
            int recuo = 20 * tamanho/ 100;
            icone.setText((String) value);
            iconLogo.setImage(iconLogo.getImage().getScaledInstance(
                tamanho - recuo,tamanho - recuo,1));
            icone.setIcon(iconLogo);
        }
        
        icone.setHorizontalAlignment(JLabel.CENTER);
        return icone;
    }
}

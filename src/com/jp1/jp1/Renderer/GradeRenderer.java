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
import java.awt.Color;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author aluno
 */
public class GradeRenderer extends DefaultTableCellRenderer {
    
    JLabel icone = new JLabel();
    IModeloControle modeloControle = new ModeloControle();
    IMarcaControle marcaControle = new MarcaControle();
    
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
                    if(column == 3) iconLogo = new ImageIcon(table.getValueAt(row, 2).toString());
                    else if(column == 4){
                        Object[] lista = modeloControle.listar().toArray();
                        int idMarca = 0;
                        for(int i = 0; i < lista.length; i++){
                            if(lista[i].toString().contains(table.getValueAt(row, 0).toString())){
                                
                                String linha[] = lista[i].toString().split(";");
                                idMarca = Integer.parseInt(linha[3].replace("\n", ""));
                            }
                        }
                        iconLogo = new ImageIcon(getClass().getResource(marcaControle.buscar(idMarca).getUrl().replace("./src", "")));

                    }
                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e.getMessage());
                }


                int tamanho = table.getRowHeight();
                int recuo = 20 * tamanho/ 100;
                this.setText((String) value);
                iconLogo.setImage(iconLogo.getImage().getScaledInstance(
                    tamanho - recuo,tamanho - recuo,1));
                this.setIcon(iconLogo);
            }else this.setText(value.toString());
            
        }
        
        this.setHorizontalAlignment(JLabel.CENTER);
        return this;
    }
}

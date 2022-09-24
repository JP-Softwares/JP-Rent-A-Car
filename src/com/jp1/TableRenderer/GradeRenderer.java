/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.TableRenderer;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author aluno
 */
public class GradeRenderer extends DefaultTableCellRenderer {
    
    JLabel icone = new JLabel();
    
    class MyModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return 4;
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return "Player" + (rowIndex*columnIndex);
        }
        
    }
    
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
            ImageIcon iconLogo = new ImageIcon(table.getValueAt(row, column).toString());
            icone.setText((String) value);
            icone.setIcon(iconLogo);
        }
        
        icone.setHorizontalAlignment(JLabel.CENTER);
        return icone;
    }
}

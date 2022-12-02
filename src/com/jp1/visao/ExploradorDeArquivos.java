/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.visao;

import java.awt.Component;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author aluno
 */
public class ExploradorDeArquivos extends JFileChooser {
    
    public ExploradorDeArquivos(){
        UIManager.put("FileChooser.openDialogTitleText", "Seleção de aquivos");
        UIManager.put("FileChooser.lookInLabelText", "Local");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do Arquivo");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo de Arquivo");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir arquivo selecionado");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Fechar");
        UIManager.put("FileChooser.fileNameHeaderText", "Nome do Arquivo");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir Nivel Acima");
        UIManager.put("FileChooser.homeFolderToolTipText", "Desktop");
        UIManager.put("FileChooser.newFolderToolTipText", "Nova Pasta");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.newFolderButtonText", "Criar Nova Pasta");
        UIManager.put("FileChooser.renameFileButtonText", "Renomear");
        UIManager.put("FileChooser.deleteFileButtonText", "Apagar");
        UIManager.put("FileChooser.filterLabelText", "Tipo de Arquivos");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.fileSizeHeaderText", "Tamanho");
        UIManager.put("FileChooser.fileDateHeaderText", "Data de Modificação");
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public void abrir(Component parent){
        this.showOpenDialog(parent);
    }
    
    public void salvar(Component parent){
        UIManager.put("FileChooser.openButtonText", "Salvar");
        UIManager.put("FileChooser.openButtonToolTipText", "Salvar arquivo selecionado");
        SwingUtilities.updateComponentTreeUI(this);
        
        this.showSaveDialog(parent);
    }
}

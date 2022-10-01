/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jp1.Networking;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author aluno
 */
public class Logo {
    
    
    public static ImageIcon pegarLogo() throws Exception{
        URL url = null;
        try {
            url = new URL("https://i.pinimg.com/236x/b1/c4/95/b1c4954148c0a31354f2fea8b64788b9.jpg");
        } catch (MalformedURLException e) {
            throw e;
        }
        
        ImageIcon imgIcon = new ImageIcon("C:\\Users\\aluno\\Downloads\\VW_Volkswagen.eps");
        
        return imgIcon;
    }
}

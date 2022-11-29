/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.themes;

import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author aluno
 */
public class Tema extends FlatLightLaf {
    
     public static boolean setup() {
        return setup( new Tema() );
    }

    @Override
    public String getName() {
        return "Tema";
    }
}

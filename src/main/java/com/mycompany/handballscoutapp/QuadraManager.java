/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.handballscoutapp;

import com.mycompany.handballscoutapp.GUI.DlgGol;

public class QuadraManager {
    private String timeFinal;

    public QuadraManager(String time) {
        timeFinal = time;
    }

    public void criarGol(String quadranteChute) {
        DlgGol gol = new DlgGol(true, timeFinal, quadranteChute);
        gol.setVisible(true);
    }
}

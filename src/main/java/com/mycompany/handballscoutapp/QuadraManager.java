/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.handballscoutapp;

import com.mycompany.handballscoutapp.GUI.DlgGol;

public class QuadraManager {

    private String timeFinal;
    private String nomeArquivoFinal;

    public QuadraManager(String time, String nomeArquivo) {
        timeFinal = time;
        nomeArquivoFinal = nomeArquivo;
    }

    public void criarGol(String quadranteChute, String nome) {
        DlgGol gol = new DlgGol(true, timeFinal, quadranteChute, nomeArquivoFinal);
        gol.setVisible(true);
    }
}

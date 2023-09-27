/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.handballscoutapp.GUI;

import com.mycompany.handballscoutapp.GolManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class FrHome extends javax.swing.JFrame {

    private String timeA = "";
    private String timeB = "";
    private int placarTimeA = 0;
    private int placarTimeB = 0;
    private boolean nomesTimesPreenchidos = false;
    private String nomeArquivo;
    private GolManager golManager;

    /**
     * Creates new form FrHome
     */
    public FrHome() {
        setTitle("TIME:");
        initComponents();
        bloquearBotao(false);
        jLabelPlacar.setText(placarTimeA + " - " + placarTimeB);

    }

    private void criarQuadra(String time, String nomeArquivo) {
        if (!time.isEmpty() && !timeA.isEmpty() && !timeB.isEmpty()) {
            // Incrementa o placar do time correspondente
            if (time.equals(timeA)) {
                placarTimeA++;
            } else if (time.equals(timeB)) {
                placarTimeB++;
            }

            // Atualiza o texto do JLabel com o novo placar
            jLabelPlacar.setText(placarTimeA + " - " + placarTimeB);

            DlgQuadra telaQuadra = new DlgQuadra(true, time, nomeArquivo);
            telaQuadra.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Preencha os nomes dos times antes de continuar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private boolean validarNomesTimes(String nomeTimeA, String nomeTimeB) {
        if (nomeTimeA.equals(nomeTimeB)) {
            JOptionPane.showMessageDialog(this, "Os nomes dos times não podem ser iguais.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false; // Nomes iguais, retorna false
        }

        return true; // Nomes diferentes, retorna true
    }

    private void bloquearBotao(boolean flag) {
        this.jBtTimeA.setEnabled(flag);
        this.jBtTimeB.setEnabled(flag);
        this.jBtFinalizarPartida.setEnabled(flag);
    }

    private String gerarNomeArquivo() {
        return String.format("RELATORIO_%s_%s.txt", timeA, timeB);
    }

    private void criarArquivoComNomesDosTimes(String nomeArquivoBase) {
        nomeArquivo = nomeArquivoBase;
        int contador = 1;

        while (arquivoExiste(nomeArquivo)) {
            nomeArquivo = nomeArquivoBase + "_" + contador;
            contador++;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("TIME A: " + timeA);
            writer.newLine();
            writer.write("TIME B: " + timeB);
            writer.newLine();
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Arquivo criado com sucesso: " + nomeArquivo, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao criar o arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean arquivoExiste(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        return arquivo.exists();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jBtTimeA = new javax.swing.JButton();
        jBtTimeB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabelPlacar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBtFinalizarPartida = new javax.swing.JButton();
        jBtInicializarPartida = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jBtTimeA.setText("GOL TIME A");
        jBtTimeA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTimeAActionPerformed(evt);
            }
        });

        jBtTimeB.setText("GOL TIME B");
        jBtTimeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtTimeBActionPerformed(evt);
            }
        });

        jLabel1.setText("NOME TIME \"A\":");

        jLabel2.setText("NOME TIME \"B\":");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabelPlacar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPlacar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPlacar.setText("PLACAR");

        jLabel4.setText("PLACAR:");

        jBtFinalizarPartida.setText("FINALIZAR PARTIDA");
        jBtFinalizarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtFinalizarPartidaActionPerformed(evt);
            }
        });

        jBtInicializarPartida.setText("INICIALIZAR PARTIDA");
        jBtInicializarPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtInicializarPartidaMouseClicked(evt);
            }
        });
        jBtInicializarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtInicializarPartidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtTimeA)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtTimeB))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2)
                    .addComponent(jLabelPlacar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtInicializarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtFinalizarPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtTimeA)
                    .addComponent(jBtTimeB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPlacar)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtInicializarPartida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtFinalizarPartida)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtTimeAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTimeAActionPerformed
        criarQuadra(timeA, nomeArquivo);
    }//GEN-LAST:event_jBtTimeAActionPerformed

    private void jBtTimeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtTimeBActionPerformed
        criarQuadra(timeB, nomeArquivo);
    }//GEN-LAST:event_jBtTimeBActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        String textoDigitado2 = jTextField2.getText();
        if (validarNomesTimes(timeA, textoDigitado2)) {
            timeB = textoDigitado2;
            jTextField2.setEnabled(false);
        }
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        String textoDigitado1 = jTextField1.getText();
        if (validarNomesTimes(textoDigitado1, timeB)) {
            timeA = textoDigitado1;
            jTextField1.setEnabled(false);
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jBtFinalizarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtFinalizarPartidaActionPerformed
        try {
            golManager.lerEscreverEstatisticasDoArquivo(nomeArquivo);
        } catch (IOException ex) {
            Logger.getLogger(FrHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtFinalizarPartidaActionPerformed

    private void jBtInicializarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtInicializarPartidaActionPerformed
        if (!timeA.isEmpty() && !timeB.isEmpty()) {
            // Os nomes dos times foram preenchidos, permita o uso de outros botões
            nomesTimesPreenchidos = true;
            bloquearBotao(true);
            jBtInicializarPartida.setEnabled(false);

            // Gere o nome do arquivo
            String nomeArquivo = gerarNomeArquivo();

            // Crie o arquivo com os nomes dos times
            criarArquivoComNomesDosTimes(nomeArquivo);
            golManager = new GolManager("", "", nomeArquivo);

        } else {
            JOptionPane.showMessageDialog(this, "Preencha os nomes dos times antes de continuar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBtInicializarPartidaActionPerformed

    private void jBtInicializarPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtInicializarPartidaMouseClicked
        if (timeA.isEmpty() && timeB.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Preencha os nomes dos times antes de continuar.", "Aviso", JOptionPane.WARNING_MESSAGE);

        } else {
            bloquearBotao(true);
        }
    }//GEN-LAST:event_jBtInicializarPartidaMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtFinalizarPartida;
    private javax.swing.JButton jBtInicializarPartida;
    private javax.swing.JButton jBtTimeA;
    private javax.swing.JButton jBtTimeB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelPlacar;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

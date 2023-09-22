/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.handballscoutapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ifmaker
 */
public class DlgGol extends javax.swing.JDialog {

    private List<String> informacoesGols = new ArrayList<>();
    private boolean acaoExecutada = false;
    private String quadranteChuteFinal;
    private String timeFinal;


    public DlgGol(boolean modal,String time,String quadranteChute) {
        setTitle("CHUTE: " + quadranteChute); // Exibe o identificador no título
        timeFinal = time;
        quadranteChuteFinal = quadranteChute;
        initComponents();
    }
    
    private String obterHoraAtual() {
        LocalTime agora = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        return agora.format(formato);
    }
    
    private String formatarInformacaoGol(String quadranteGol) {
        String horaAtual = obterHoraAtual();
        return "HORA: " + horaAtual + " - " + timeFinal + ": " + quadranteChuteFinal + " -> " + quadranteGol;
}

    private void criarInformacaoGol(String quadranteGol) {
        if (!acaoExecutada) {
            String informacaoGol = formatarInformacaoGol(quadranteGol);
            informacoesGols.add(informacaoGol);
            escreverInformacoesEmArquivo("informacoes_de_gols.txt");
            acaoExecutada = true;
            this.setVisible(false);
        }
    }
    
 
    public void escreverInformacoesEmArquivo(String nomeArquivo) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo,true))) {
        for (String informacao : informacoesGols) {
            writer.write(informacao);
            writer.newLine(); // Adicionar uma nova linha após cada informação
        }
        System.out.println("Informações gravadas em " + nomeArquivo);
    } catch (IOException e) {
        System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtQuadranteGol1 = new javax.swing.JButton();
        jBtQuadranteGol2 = new javax.swing.JButton();
        jBtQuadranteGol3 = new javax.swing.JButton();
        jBtQuadranteGol4 = new javax.swing.JButton();
        jBtQuadranteGol5 = new javax.swing.JButton();
        jBtQuadranteGol6 = new javax.swing.JButton();
        jBtQuadranteGol7 = new javax.swing.JButton();
        jBtQuadranteGol8 = new javax.swing.JButton();
        jBtQuadranteGol9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jBtQuadranteGol1.setText("Q1 GOL");
        jBtQuadranteGol1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteGol1ActionPerformed(evt);
            }
        });

        jBtQuadranteGol2.setText("Q2 GOL");
        jBtQuadranteGol2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteGol2ActionPerformed(evt);
            }
        });

        jBtQuadranteGol3.setText("Q3 GOL");
        jBtQuadranteGol3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteGol3ActionPerformed(evt);
            }
        });

        jBtQuadranteGol4.setText("Q4 GOL");
        jBtQuadranteGol4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteGol4ActionPerformed(evt);
            }
        });

        jBtQuadranteGol5.setText("Q5 GOL");
        jBtQuadranteGol5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteGol5ActionPerformed(evt);
            }
        });

        jBtQuadranteGol6.setText("Q6 GOL");
        jBtQuadranteGol6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteGol6ActionPerformed(evt);
            }
        });

        jBtQuadranteGol7.setText("Q7 GOL");
        jBtQuadranteGol7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteGol7ActionPerformed(evt);
            }
        });

        jBtQuadranteGol8.setText("Q8 GOL");
        jBtQuadranteGol8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteGol8ActionPerformed(evt);
            }
        });

        jBtQuadranteGol9.setText("Q9 GOL");
        jBtQuadranteGol9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteGol9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBtQuadranteGol1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtQuadranteGol2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtQuadranteGol3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBtQuadranteGol4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtQuadranteGol5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtQuadranteGol6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBtQuadranteGol7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtQuadranteGol8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtQuadranteGol9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtQuadranteGol2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtQuadranteGol3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtQuadranteGol1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtQuadranteGol4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtQuadranteGol6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtQuadranteGol5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtQuadranteGol7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtQuadranteGol8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtQuadranteGol9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtQuadranteGol1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteGol1ActionPerformed
        criarInformacaoGol("Q1 GOL");
    }//GEN-LAST:event_jBtQuadranteGol1ActionPerformed

    private void jBtQuadranteGol2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteGol2ActionPerformed
        criarInformacaoGol("Q2 GOL");
    }//GEN-LAST:event_jBtQuadranteGol2ActionPerformed

    private void jBtQuadranteGol3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteGol3ActionPerformed
        criarInformacaoGol("Q3 GOL");
    }//GEN-LAST:event_jBtQuadranteGol3ActionPerformed

    private void jBtQuadranteGol4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteGol4ActionPerformed
        criarInformacaoGol("Q4 GOL");
    }//GEN-LAST:event_jBtQuadranteGol4ActionPerformed

    private void jBtQuadranteGol5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteGol5ActionPerformed
        criarInformacaoGol("Q5 GOL");
    }//GEN-LAST:event_jBtQuadranteGol5ActionPerformed

    private void jBtQuadranteGol6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteGol6ActionPerformed
        criarInformacaoGol("Q6 GOL");
    }//GEN-LAST:event_jBtQuadranteGol6ActionPerformed

    private void jBtQuadranteGol7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteGol7ActionPerformed
        criarInformacaoGol("Q7 GOL");
    }//GEN-LAST:event_jBtQuadranteGol7ActionPerformed

    private void jBtQuadranteGol8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteGol8ActionPerformed
        criarInformacaoGol("Q8 GOL");
    }//GEN-LAST:event_jBtQuadranteGol8ActionPerformed

    private void jBtQuadranteGol9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteGol9ActionPerformed
        criarInformacaoGol("Q9 GOL");
    }//GEN-LAST:event_jBtQuadranteGol9ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtQuadranteGol1;
    private javax.swing.JButton jBtQuadranteGol2;
    private javax.swing.JButton jBtQuadranteGol3;
    private javax.swing.JButton jBtQuadranteGol4;
    private javax.swing.JButton jBtQuadranteGol5;
    private javax.swing.JButton jBtQuadranteGol6;
    private javax.swing.JButton jBtQuadranteGol7;
    private javax.swing.JButton jBtQuadranteGol8;
    private javax.swing.JButton jBtQuadranteGol9;
    // End of variables declaration//GEN-END:variables

}

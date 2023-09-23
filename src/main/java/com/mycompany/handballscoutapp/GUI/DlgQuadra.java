/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.handballscoutapp.GUI;

import com.mycompany.handballscoutapp.QuadraManager;


/**
 *
 * @author rafae
 */
public class DlgQuadra extends javax.swing.JDialog {
    private String timeFinal;
    private QuadraManager quadraManager;

    public DlgQuadra(boolean modal, String time) {
        setTitle("SELECIONE O QUADRANTE DO CHUTE:");
        timeFinal = time;
        quadraManager = new QuadraManager(time); // Instância do QuadraManager
        initComponents();
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtQuadranteQuadra1 = new javax.swing.JButton();
        jBtQuadranteQuadra2 = new javax.swing.JButton();
        jBtQuadranteQuadra3 = new javax.swing.JButton();
        jBtQuadranteQuadra4 = new javax.swing.JButton();
        jBtQuadranteQuadra5 = new javax.swing.JButton();
        jBtQuadranteQuadra6 = new javax.swing.JButton();
        jBtQuadranteQuadra7 = new javax.swing.JButton();
        jBtQuadranteQuadra8 = new javax.swing.JButton();
        jBtQuadranteQuadra9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jBtQuadranteQuadra1.setText("Q1 QUADRA");
        jBtQuadranteQuadra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteQuadra1ActionPerformed(evt);
            }
        });

        jBtQuadranteQuadra2.setText("Q2 QUADRA");
        jBtQuadranteQuadra2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteQuadra2ActionPerformed(evt);
            }
        });

        jBtQuadranteQuadra3.setText("Q3 QUADRA");
        jBtQuadranteQuadra3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteQuadra3ActionPerformed(evt);
            }
        });

        jBtQuadranteQuadra4.setText("Q4 QUADRA");
        jBtQuadranteQuadra4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteQuadra4ActionPerformed(evt);
            }
        });

        jBtQuadranteQuadra5.setText("Q5 QUADRA");
        jBtQuadranteQuadra5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteQuadra5ActionPerformed(evt);
            }
        });

        jBtQuadranteQuadra6.setText("Q6 QUADRA");
        jBtQuadranteQuadra6.setPreferredSize(new java.awt.Dimension(160, 50));
        jBtQuadranteQuadra6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteQuadra6ActionPerformed(evt);
            }
        });

        jBtQuadranteQuadra7.setText("Q7 QUADRA");
        jBtQuadranteQuadra7.setPreferredSize(new java.awt.Dimension(160, 50));
        jBtQuadranteQuadra7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteQuadra7ActionPerformed(evt);
            }
        });

        jBtQuadranteQuadra8.setText("Q8 QUADRA");
        jBtQuadranteQuadra8.setPreferredSize(new java.awt.Dimension(162, 50));
        jBtQuadranteQuadra8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteQuadra8ActionPerformed(evt);
            }
        });

        jBtQuadranteQuadra9.setText("Q9 QUADRA");
        jBtQuadranteQuadra9.setPreferredSize(new java.awt.Dimension(490, 50));
        jBtQuadranteQuadra9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtQuadranteQuadra9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jBtQuadranteQuadra9, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtQuadranteQuadra1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtQuadranteQuadra3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtQuadranteQuadra6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtQuadranteQuadra7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtQuadranteQuadra4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtQuadranteQuadra8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtQuadranteQuadra5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtQuadranteQuadra2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtQuadranteQuadra1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtQuadranteQuadra2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtQuadranteQuadra3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtQuadranteQuadra4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtQuadranteQuadra5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtQuadranteQuadra6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtQuadranteQuadra8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtQuadranteQuadra7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtQuadranteQuadra9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtQuadranteQuadra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteQuadra1ActionPerformed
        quadraManager.criarGol("Q1 QUADRA");
    }//GEN-LAST:event_jBtQuadranteQuadra1ActionPerformed

    private void jBtQuadranteQuadra2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteQuadra2ActionPerformed
        quadraManager.criarGol("Q2 QUADRA");
    }//GEN-LAST:event_jBtQuadranteQuadra2ActionPerformed

    private void jBtQuadranteQuadra3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteQuadra3ActionPerformed
        quadraManager.criarGol("Q3 QUADRA");
    }//GEN-LAST:event_jBtQuadranteQuadra3ActionPerformed

    private void jBtQuadranteQuadra4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteQuadra4ActionPerformed
        quadraManager.criarGol("Q4 QUADRA");
    }//GEN-LAST:event_jBtQuadranteQuadra4ActionPerformed

    private void jBtQuadranteQuadra5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteQuadra5ActionPerformed
        quadraManager.criarGol("Q5 QUADRA");
    }//GEN-LAST:event_jBtQuadranteQuadra5ActionPerformed

    private void jBtQuadranteQuadra6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteQuadra6ActionPerformed
        quadraManager.criarGol("Q6 QUADRA");
    }//GEN-LAST:event_jBtQuadranteQuadra6ActionPerformed

    private void jBtQuadranteQuadra7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteQuadra7ActionPerformed
        quadraManager.criarGol("Q7 QUADRA");
    }//GEN-LAST:event_jBtQuadranteQuadra7ActionPerformed

    private void jBtQuadranteQuadra8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteQuadra8ActionPerformed
        quadraManager.criarGol("Q8 QUADRA");
    }//GEN-LAST:event_jBtQuadranteQuadra8ActionPerformed

    private void jBtQuadranteQuadra9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtQuadranteQuadra9ActionPerformed
        quadraManager.criarGol("Q9 QUADRA");
    }//GEN-LAST:event_jBtQuadranteQuadra9ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtQuadranteQuadra1;
    private javax.swing.JButton jBtQuadranteQuadra2;
    private javax.swing.JButton jBtQuadranteQuadra3;
    private javax.swing.JButton jBtQuadranteQuadra4;
    private javax.swing.JButton jBtQuadranteQuadra5;
    private javax.swing.JButton jBtQuadranteQuadra6;
    private javax.swing.JButton jBtQuadranteQuadra7;
    private javax.swing.JButton jBtQuadranteQuadra8;
    private javax.swing.JButton jBtQuadranteQuadra9;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipleiria.estg.es1.as2130557.minesfinder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
//import jdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;

/**
 *
 * @author tony
 */
public class MinesFinder extends javax.swing.JFrame {

    /**
     * Creates new form MinesFinder
     */
    private TabelaRecordes recordesFacil;
    private TabelaRecordes recordesMedio;
    private TabelaRecordes recordesDificil;
    
    
    public MinesFinder() {
        initComponents();
        recordesFacil = new TabelaRecordes();
        recordesMedio = new TabelaRecordes();
        recordesDificil = new TabelaRecordes();
        
        lerRecordesDoDisco(); // Actualização das Labels
        lblNomeFacil.setText(recordesFacil.getNomeJogador());
        lblTempoFacil.setText(Long.toString(recordesFacil.getTempoJogo()/1000));
        lblNomeMedio.setText(recordesMedio.getNomeJogador());
        lblTempoMedio.setText(Long.toString(recordesMedio.getTempoJogo()/1000));
        lblNomeDificil.setText(recordesDificil.getNomeJogador());
        lblTempoDificil.setText(Long.toString(recordesDificil.getTempoJogo()/1000));
        
        recordesFacil.addTabelaRecordesListener(new TabelaRecordesListener(){
            @Override
            public void recordesActualizados(TabelaRecordes recordes){
                recordesFacilActualizado(recordes);                
            }
        });
        
        recordesMedio.addTabelaRecordesListener(new TabelaRecordesListener(){
            @Override
            public void recordesActualizados(TabelaRecordes recordes){
                recordesMedioActualizado(recordes);
            }
        });
        
        recordesDificil.addTabelaRecordesListener(new TabelaRecordesListener(){
            @Override
            public void recordesActualizados(TabelaRecordes recordes){
                recordesDificilActualizado(recordes);
            }
        });
                
    }
    
    private void recordesFacilActualizado(TabelaRecordes recordes) {
        lblNomeFacil.setText(recordes.getNomeJogador());
        lblTempoFacil.setText(Long.toString(recordes.getTempoJogo()/1000));
        guardarRecordesDisco();
    }
    
    private void recordesMedioActualizado(TabelaRecordes recordes) {
        lblNomeMedio.setText(recordes.getNomeJogador());
        lblTempoMedio.setText(Long.toString(recordes.getTempoJogo()/1000));        
        guardarRecordesDisco();
    }
    
    private void recordesDificilActualizado(TabelaRecordes recordes) {
        lblNomeDificil.setText(recordes.getNomeJogador());
        lblTempoDificil.setText(Long.toString(recordes.getTempoJogo()/1000));
        guardarRecordesDisco();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNomeFacil = new javax.swing.JLabel();
        lblTempoFacil = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNomeMedio = new javax.swing.JLabel();
        lblTempoMedio = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblNomeDificil = new javax.swing.JLabel();
        lblTempoDificil = new javax.swing.JLabel();
        btnCreditos = new javax.swing.JButton();
        btnAjuda = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnJogoFacil = new javax.swing.JButton();
        btnJogoMedio = new javax.swing.JButton();
        btnJogoDificil = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MinesFinder");

        jLabel1.setBackground(new java.awt.Color(33, 183, 234));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MF v1.0");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Recordes");

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nível Fácil");

        lblNomeFacil.setText("Nome facil");

        lblTempoFacil.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTempoFacil.setText("9999");

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nível Médio");

        lblNomeMedio.setText("Nome medio");

        lblTempoMedio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTempoMedio.setText("9999");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Nível Difícil");

        lblNomeDificil.setText("Nome difícil");

        lblTempoDificil.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTempoDificil.setText("9999");

        btnCreditos.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnCreditos.setText("Créditos");
        btnCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditosActionPerformed(evt);
            }
        });

        btnAjuda.setText("Ajuda");
        btnAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblNomeFacil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTempoFacil))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblNomeMedio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTempoMedio))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblNomeDificil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTempoDificil))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(btnAjuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeFacil)
                    .addComponent(lblTempoFacil))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeMedio)
                    .addComponent(lblTempoMedio))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeDificil)
                    .addComponent(lblTempoDificil))
                .addGap(46, 46, 46)
                .addComponent(btnCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAjuda, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.GridLayout(2, 2));

        btnJogoFacil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/ipleiria/estg/es1/as2130557/minesfinder/minas_facil.png"))); // NOI18N
        btnJogoFacil.setText("Jogo Fácil");
        btnJogoFacil.setToolTipText("");
        btnJogoFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogoFacilActionPerformed(evt);
            }
        });
        jPanel2.add(btnJogoFacil);

        btnJogoMedio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/ipleiria/estg/es1/as2130557/minesfinder/minas_medio.png"))); // NOI18N
        btnJogoMedio.setText("Jogo Médio");
        btnJogoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogoMedioActionPerformed(evt);
            }
        });
        jPanel2.add(btnJogoMedio);

        btnJogoDificil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pt/ipleiria/estg/es1/as2130557/minesfinder/minas_dificil.png"))); // NOI18N
        btnJogoDificil.setText("Jogo Difícil");
        btnJogoDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogoDificilActionPerformed(evt);
            }
        });
        jPanel2.add(btnJogoDificil);

        btnSair.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        btnSair.setText("Sair");
        btnSair.setToolTipText("Termina aplicação");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel2.add(btnSair);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(MinesFinder.this, "Adeus!","Despedida...",JOptionPane.INFORMATION_MESSAGE);  // janela dialogo mais frequentemente usada
        System.exit(0);
        
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnJogoFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogoFacilActionPerformed
        // TODO add your handling code here:
        JanelaDeJogo janela=new JanelaDeJogo(new CampoMinado(9,9,10), recordesFacil); // minas 10
        janela.setVisible(true);
        
    }//GEN-LAST:event_btnJogoFacilActionPerformed

    private void btnJogoMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogoMedioActionPerformed
        // TODO add your handling code here:
        JanelaDeJogo janela=new JanelaDeJogo(new CampoMinado(16,16,40), recordesMedio); // 40
        janela.setVisible(true);
    }//GEN-LAST:event_btnJogoMedioActionPerformed

    private void btnJogoDificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogoDificilActionPerformed
        // TODO add your handling code here:
        JanelaDeJogo janela=new JanelaDeJogo(new CampoMinado(16,30,90), recordesDificil); //90
        janela.setVisible(true);
    }//GEN-LAST:event_btnJogoDificilActionPerformed

    private void btnCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditosActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, "Creditos: António Santos, ESoft 1, ESTG","CRÉDITOS",JOptionPane.INFORMATION_MESSAGE);
        JanelaCreditos creditos = new JanelaCreditos();
        creditos.setVisible(true);
        
    }//GEN-LAST:event_btnCreditosActionPerformed

    private void btnAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjudaActionPerformed
        // TODO add your handling code here:
        JanelaAjuda ajuda = new JanelaAjuda();
        ajuda.setVisible(true);
    }//GEN-LAST:event_btnAjudaActionPerformed

    /* ** PERSISTENCIA - GUARDAR DADOS NO DISCO ******* */
    private void guardarRecordesDisco(){
        ObjectOutputStream oos = null;
        try {
            File f = new File(System.getProperty("user.home")+File.separator+"minesFinder.recordes");
            oos = new ObjectOutputStream( new FileOutputStream(f));
            oos.writeObject(recordesFacil);
            oos.writeObject(recordesMedio);
            oos.writeObject(recordesDificil);
            oos.close();
            
        } catch (IOException ex){
            Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    private void lerRecordesDoDisco(){
        ObjectInputStream ois = null;
        File f = new File(System.getProperty("user.home")+File.separator+"minesFinder.recordes");
        if (f.canRead()){
            try {
                ois = new ObjectInputStream(new FileInputStream(f));
                recordesFacil=(TabelaRecordes) ois.readObject();
                recordesMedio=(TabelaRecordes) ois.readObject();
                recordesDificil=(TabelaRecordes) ois.readObject();
                ois.close();
                
            } catch (IOException ex){
                Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE,null,ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MinesFinder.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinesFinder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MinesFinder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjuda;
    private javax.swing.JButton btnCreditos;
    private javax.swing.JButton btnJogoDificil;
    private javax.swing.JButton btnJogoFacil;
    private javax.swing.JButton btnJogoMedio;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNomeDificil;
    private javax.swing.JLabel lblNomeFacil;
    private javax.swing.JLabel lblNomeMedio;
    private javax.swing.JLabel lblTempoDificil;
    private javax.swing.JLabel lblTempoFacil;
    private javax.swing.JLabel lblTempoMedio;
    // End of variables declaration//GEN-END:variables
}

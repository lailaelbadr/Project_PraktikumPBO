/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpbo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ella
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    public menu() {
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

        barang = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dataorder = new javax.swing.JLabel();
        order = new javax.swing.JLabel();
        pelanggan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        setMinimumSize(new java.awt.Dimension(1229, 70));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1229, 692));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barangMouseClicked(evt);
            }
        });
        getContentPane().add(barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 200, 170));

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 50, 50));

        dataorder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataorderMouseClicked(evt);
            }
        });
        getContentPane().add(dataorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 380, 200, 170));

        order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderMouseClicked(evt);
            }
        });
        getContentPane().add(order, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 200, 170));

        pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pelangganMouseClicked(evt);
            }
        });
        getContentPane().add(pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 220, 180));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/menu.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 700));

        jPanel1.setPreferredSize(new java.awt.Dimension(1229, 692));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1230, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pelangganMouseClicked
        // TODO add your handling code here:
        try {
            String sql = "select * from pelanggan ";
            java.sql.Connection conn=(Connection)projectpbo.Konfig.configDB();
            java.sql.Statement stm=conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
        
            if(rs.next()){
                new Pelanggan().setVisible(true);
                dispose();
                this.pack();
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
                
            }else{

            }
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }//GEN-LAST:event_pelangganMouseClicked

    private void orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderMouseClicked
        // TODO add your handling code here:
        try {
            String sql = "select * from `order` ";
            java.sql.Connection conn=(Connection)projectpbo.Konfig.configDB();
            java.sql.Statement stm=conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
        
            if(rs.next()){
                new pesanan().setVisible(true);
                dispose();
                this.pack();
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
                
            }else{

            }
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }//GEN-LAST:event_orderMouseClicked

    private void dataorderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataorderMouseClicked
        // TODO add your handling code here:
        try {
            String sql = "select * from `order` ";
            java.sql.Connection conn=(Connection)projectpbo.Konfig.configDB();
            java.sql.Statement stm=conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
        
            if(rs.next()){
                new dataorder().setVisible(true);
                dispose();
                this.pack();
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
                
            }else{

            }
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }//GEN-LAST:event_dataorderMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Yakin Keluar aplikasi???",
            "Yakin", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        this.dispose();
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangMouseClicked
        // TODO add your handling code here:
        try {
            String sql = "select * from `order` ";
            java.sql.Connection conn=(Connection)projectpbo.Konfig.configDB();
            java.sql.Statement stm=conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
        
            if(rs.next()){
                new databarang().setVisible(true);
                dispose();
                this.pack();
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
                
            }else{

            }
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }//GEN-LAST:event_barangMouseClicked

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barang;
    private javax.swing.JLabel dataorder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel order;
    private javax.swing.JLabel pelanggan;
    // End of variables declaration//GEN-END:variables
}

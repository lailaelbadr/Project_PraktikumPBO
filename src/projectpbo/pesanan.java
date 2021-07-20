/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpbo;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import java.sql.*;
import java.text.Format;
import javax.swing.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Ella
 */
public class pesanan extends javax.swing.JFrame {

    /**
     * Creates new form pesanan
     */
    public pesanan() {
        initComponents();
        KosongForm();
        tampil();
        tampilcombo();
    }
    
    public String tgl_order;
    
    public void KosongForm(){
        txtkode_pesan.setEditable(true);
        txtkode_pel.setText(null);
        cmbbarang.setSelectedItem(this);
        tgl.setDate(null);
        txtnama_pesan.setText(null);
        txtbahan.setText(null);
        txtjml.setText(null);
        txtharga.setText(null);
        txtsubtotal.setText(null);
    }
    
   
    public void tampil_data() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Pesanan");
        model.addColumn("Kode Pelanggan");
        model.addColumn("Kode Item");
        model.addColumn("Tanggal Order");
        model.addColumn("Status");
        model.addColumn("Nama Pesanan");
        model.addColumn("Bahan");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Subtotal");
        try {
            String sql = "SELECT * FROM `order` where kode_pelanggan ='"+txtkode_pel.getText()+"'";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                model.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10)});
            }
            tabelpesan.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error :"+ e.getMessage());
        }
    }
    
    public void tampil() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Kode Pesanan");
        model.addColumn("Kode Pelanggan");
        model.addColumn("Kode Item");
        model.addColumn("Tanggal Order");
        model.addColumn("Status");
        model.addColumn("Nama Pesanan");
        model.addColumn("Bahan");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Subtotal");
        try {
            String sql = "SELECT * FROM `order` where kode_pelanggan ='"+txtkode_pel.getText()
                    +"' and status = 'order'";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()) {
                model.addRow(new Object[]{
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9),
                    res.getString(10)});
            }
            tabelpesan.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error :"+ e.getMessage());
        }
    }
    
    public void tampilcombo(){
        try{
            
            String sql = "SELECT kode_barang from `order`";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
             cmbbarang.addItem(res.getString("kode_barang"));
            }
            res.last();
            int jumlah_data = res.getRow();
            res.first();
            
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        status = new javax.swing.JTextField();
        btnharga = new javax.swing.JButton();
        tgl = new com.toedter.calendar.JDateChooser();
        txtjml = new javax.swing.JTextField();
        txtsubtotal = new javax.swing.JTextField();
        kembali = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpesan = new javax.swing.JTable();
        exit = new javax.swing.JLabel();
        btnbatal = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btncari = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        cmbbarang = new javax.swing.JComboBox<>();
        txtnama_pesan = new javax.swing.JTextField();
        txtbahan = new javax.swing.JTextField();
        txtkode_pel = new javax.swing.JTextField();
        txtkode_pesan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        status.setBackground(new java.awt.Color(217, 217, 217));
        status.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        status.setBorder(null);
        status.setOpaque(false);
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 240, 20));

        btnharga.setBackground(new java.awt.Color(128, 165, 175));
        btnharga.setText("Harga");
        btnharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhargaActionPerformed(evt);
            }
        });
        jPanel1.add(btnharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 80, 40));

        tgl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglPropertyChange(evt);
            }
        });
        jPanel1.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 240, 30));

        txtjml.setBackground(new java.awt.Color(217, 217, 217));
        txtjml.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtjml.setBorder(null);
        txtjml.setOpaque(false);
        txtjml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlActionPerformed(evt);
            }
        });
        jPanel1.add(txtjml, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 230, 20));

        txtsubtotal.setBackground(new java.awt.Color(217, 217, 217));
        txtsubtotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtsubtotal.setBorder(null);
        txtsubtotal.setOpaque(false);
        txtsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtsubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 230, 30));

        kembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kembaliMouseClicked(evt);
            }
        });
        jPanel1.add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 60, 50));

        tabelpesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelpesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpesanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpesan);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 600, 390));

        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 50, 50));

        btnbatal.setBackground(new java.awt.Color(128, 165, 175));
        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });
        jPanel1.add(btnbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 70, 40));

        btnhapus.setBackground(new java.awt.Color(128, 165, 175));
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 70, 40));

        btnedit.setBackground(new java.awt.Color(128, 165, 175));
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, 70, 40));

        btnsimpan.setBackground(new java.awt.Color(128, 165, 175));
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 540, -1, 40));

        btntambah.setBackground(new java.awt.Color(128, 165, 175));
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        jPanel1.add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 540, -1, 40));

        btncari.setBackground(new java.awt.Color(128, 165, 175));
        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel1.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 540, 70, 40));

        cari.setBackground(new java.awt.Color(217, 217, 217));
        cari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cari.setBorder(null);
        cari.setOpaque(false);
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        jPanel1.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 550, 260, 30));

        txtharga.setBackground(new java.awt.Color(217, 217, 217));
        txtharga.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtharga.setBorder(null);
        txtharga.setOpaque(false);
        txtharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaActionPerformed(evt);
            }
        });
        jPanel1.add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 230, 20));

        cmbbarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "b001", "b002", "b003", "b004" }));
        cmbbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbbarangActionPerformed(evt);
            }
        });
        jPanel1.add(cmbbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 70, 30));

        txtnama_pesan.setBackground(new java.awt.Color(217, 217, 217));
        txtnama_pesan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtnama_pesan.setBorder(null);
        txtnama_pesan.setOpaque(false);
        txtnama_pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnama_pesanActionPerformed(evt);
            }
        });
        jPanel1.add(txtnama_pesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 230, 30));

        txtbahan.setBackground(new java.awt.Color(217, 217, 217));
        txtbahan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtbahan.setBorder(null);
        txtbahan.setOpaque(false);
        txtbahan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbahanActionPerformed(evt);
            }
        });
        jPanel1.add(txtbahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 230, 20));

        txtkode_pel.setBackground(new java.awt.Color(217, 217, 217));
        txtkode_pel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtkode_pel.setBorder(null);
        txtkode_pel.setOpaque(false);
        txtkode_pel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkode_pelActionPerformed(evt);
            }
        });
        jPanel1.add(txtkode_pel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 230, 30));

        txtkode_pesan.setBackground(new java.awt.Color(217, 217, 217));
        txtkode_pesan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtkode_pesan.setBorder(null);
        txtkode_pesan.setOpaque(false);
        txtkode_pesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkode_pesanActionPerformed(evt);
            }
        });
        jPanel1.add(txtkode_pesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 230, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/bgOrder.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkode_pesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkode_pesanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkode_pesanActionPerformed

    private void txtkode_pelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkode_pelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkode_pelActionPerformed

    private void txtbahanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbahanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbahanActionPerformed

    private void txtnama_pesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnama_pesanActionPerformed
        // TODO add your handling code here:
        try{
            
            int no = 1;
            String sql = "SELECT nama_barang from barang where kode_barang = '"+cmbbarang.getSelectedItem()+"'";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
            txtnama_pesan.setText(res.getString("Nama Pesan"));    
            }
            
            
            
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }//GEN-LAST:event_txtnama_pesanActionPerformed

    private void txthargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        KosongForm();
    }//GEN-LAST:event_btntambahActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Yakin Keluar aplikasi???",
            "Yakin", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        this.dispose();
        }
    }//GEN-LAST:event_exitMouseClicked

    private void tabelpesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpesanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelpesanMouseClicked

    private void kembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kembaliMouseClicked
        // TODO add your handling code here:
        try {
            String sql = "select * from pelanggan ";
            java.sql.Connection conn=(Connection)projectpbo.Konfig.configDB();
            java.sql.Statement stm=conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
        
            if(rs.next()){
                new menu().setVisible(true);
                dispose();
                this.pack();
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(login.EXIT_ON_CLOSE);
            }else{

            }
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
    }//GEN-LAST:event_kembaliMouseClicked

    private void txtsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtotalActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtsubtotalActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        
        try {
            String sql = "insert into `order` values('"
            + txtkode_pesan.getText() + "','"
            + txtkode_pel.getText() + "','"
            + cmbbarang.getSelectedItem() + "','"
            + tgl_order + "','"
            + status.getText() + "','"
            + txtnama_pesan.getText() + "','"
            + txtbahan.getText() + "','"
            + txtjml.getText()+ "','"
            + txtharga.getText() + "','"
            + txtsubtotal.getText() + "')";
            java.sql.Connection conn = (java.sql.Connection)
            projectpbo.Konfig.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil disimpan");
            tampil();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal disimpan"+ e.getMessage());
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        try {
            java.sql.Connection conn = (java.sql.Connection) projectpbo.Konfig.configDB();
            String sql = "update `order` set kode_pelanggan='" + txtkode_pel.getText()
            + "', kode_barang='" + cmbbarang.getSelectedItem()
            + "', tgl_order='" + tgl_order 
            + "', status = '" + status.getText()
            + "', nama_barang='" + txtnama_pesan.getText() 
            + "', bahan='" + txtbahan.getText() 
            + "', jumlah='" + txtjml.getText()
            + "', harga='" + txtharga.getText()
            + "', subtotal='" + txtsubtotal.getText()
            + "' where kode_order='" + txtkode_pesan.getText() + "'";
            
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di Koreksi");
            tampil_data();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Proses Edit data Gagal");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        try {
            java.sql.Connection conn = (java.sql.Connection) projectpbo.Konfig.configDB();
            String sql = "delete from `order` where kode_order='" + txtkode_pesan.getText() + "' ";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            tampil_data();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Proses Penghapusan Gagal");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
        txtkode_pesan.setText("");
        txtkode_pel.setText("");
        cmbbarang.setSelectedItem("");
        tgl.setDate(null);
        status.setText("");
        txtnama_pesan.setText("");
        txtbahan.setText("");
        txtjml.setText("");
        txtharga.setText("");
        txtsubtotal.setText("");
        cari.setText("");
        txtkode_pesan.requestFocus();
        
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
        try {
            java.sql.Connection conn = (java.sql.Connection) project.Konfig.configDB();

            String sql = "Select * from `order` where kode_order='" + cari.getText() 
                    + "' or kode_pelanggan='" + cari.getText() 
                    + "' or tgl_order='" + cari.getText() + "'";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                txtkode_pesan.setText(rs.getString(1));
                txtkode_pel.setText(rs.getString(2));
                cmbbarang.setSelectedItem(rs.getString(3));
                tgl.setDate(rs.getDate(4));
                status.setText(rs.getString(5));
                txtnama_pesan.setText(rs.getString(6));
                txtbahan.setText(rs.getString(7));
                txtjml.setText(rs.getString(8));
                txtharga.setText(rs.getString(9));
                txtsubtotal.setText(rs.getString(10));
                
                tampil_data();
                JOptionPane.showMessageDialog(null, "Data order : "
                    + cari.getText() + " ditemukan, Apakah Anda Ingin Mengedit atau Menghapus?");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btncariActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void txtjmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlActionPerformed

    private void btnhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhargaActionPerformed
        // TODO add your handling code here:
        int harga_barang = Integer.parseInt(txtharga.getText());
        int jumlah_produk = Integer.parseInt(txtjml.getText());
        
        int harga =  harga_barang * jumlah_produk;
        String hrg = Integer.toString(harga);
        txtsubtotal.setText(hrg);
    }//GEN-LAST:event_btnhargaActionPerformed

    private void cmbbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbbarangActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "SELECT harga from barang where kode_barang = '"+cmbbarang.getSelectedItem()+"'";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
            txtharga.setText(res.getString("Harga"));
            }  
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
        
        try{
            String sql = "SELECT nama_barang from barang where kode_barang = '"+cmbbarang.getSelectedItem()+"'";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
            txtnama_pesan.setText(res.getString("nama_barang"));
            }  
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
        
        try{
            String sql = "SELECT bahan from barang where kode_barang = '"+cmbbarang.getSelectedItem()+"'";
            java.sql.Connection conn = (Connection)Konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
            txtbahan.setText(res.getString("bahan"));
            }  
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }//GEN-LAST:event_cmbbarangActionPerformed

    private void tglPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglPropertyChange
        // TODO add your handling code here:
        if (tgl.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            tgl_order = format.format(tgl.getDate());
        }
    }//GEN-LAST:event_tglPropertyChange

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
            java.util.logging.Logger.getLogger(pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pesanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnharga;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox<String> cmbbarang;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kembali;
    private javax.swing.JTextField status;
    private javax.swing.JTable tabelpesan;
    private com.toedter.calendar.JDateChooser tgl;
    private javax.swing.JTextField txtbahan;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjml;
    private javax.swing.JTextField txtkode_pel;
    private javax.swing.JTextField txtkode_pesan;
    private javax.swing.JTextField txtnama_pesan;
    private javax.swing.JTextField txtsubtotal;
    // End of variables declaration//GEN-END:variables
}

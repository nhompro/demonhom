/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.SinhVien;
import Service.SinhVienService;

/**
 *
 * @author PC
 */
public class QLSV extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private SinhVienService svService;
    private static final String P_EMAIL = "^\\w+@\\w+\\.\\w+.\\w+";
    String hinhAnh = null;

    public QLSV() {
        this.svService = new SinhVienService();
        initComponents();
        gioiTinh();
        addCot();
        this.initIcon();
        loadData();
    }

    ButtonGroup buttonGroup = new ButtonGroup();

    public void gioiTinh() {
        buttonGroup.add(rd_nam);
        buttonGroup.add(rd_nu);
    }

    public void addCot() {
        ArrayList<String> listCot = new ArrayList<>();
        listCot.add("Mã SV");
        listCot.add("Họ tên");
        listCot.add("Email");
        listCot.add("Số ĐT");
        listCot.add("Giới tính");
        listCot.add("Địa chỉ");
        listCot.add("Hình");
        defaultTableModel = (DefaultTableModel) tb_SV.getModel();
        defaultTableModel.setColumnCount(0);
        for (String item : listCot) {
            defaultTableModel.addColumn(item);
        }
    }

    public boolean checkNew() {
        if (txt_maSV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy điền mã SV");
            return false;
        }
        if (txt_hoTen.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy điền họ tên SV");
            return false;
        }
        if (txt_email.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy điền email");
            return false;
        }
        if (txt_soDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy điền mã SĐT");
            return false;
        }
        if (ta_diaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy điền địa chỉ");
            return false;
        }
        Matcher matcher = Pattern.compile(P_EMAIL).matcher(txt_email.getText());
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
            return false;
        }
        return true;
    }

    public boolean checkMaSV(String maSV) {
        ArrayList<SinhVien> listSV = this.svService.getLists();
        for(int i = 0; i < listSV.size(); i++){
            if(listSV.get(i).getMaSV().equals(maSV)){
                return true;
            }
        }
        return false;
    }

    public SinhVien addSV() {
        SinhVien sinhVien = new SinhVien();
        sinhVien.setMaSV(txt_maSV.getText());
        sinhVien.setHoTen(txt_hoTen.getText());
        sinhVien.setEmail(txt_email.getText());
        sinhVien.setSDT(txt_soDT.getText());
        if (rd_nam.isSelected()) {
            sinhVien.setGioiTinh(1);
        } else {
            sinhVien.setGioiTinh(0);
        }
        sinhVien.setDiaChi(ta_diaChi.getText());
        if (hinhAnh == null) {
            sinhVien.setHinh("no avatar");
        } else {
            sinhVien.setHinh(hinhAnh);
        }
        return sinhVien;
    }

    public void loadData() {
        defaultTableModel = (DefaultTableModel) tb_SV.getModel();
        defaultTableModel.setRowCount(0);
        for (SinhVien sv : this.svService.getLists()) {
            defaultTableModel.addRow(new Object[]{
                sv.getMaSV(), sv.getHoTen(), sv.getEmail(), sv.getSDT(), sv.getGioiTinh(), sv.getDiaChi(), sv.getHinh()
            });
        }
    }

    private void initIcon() {
        Icon iNew = new ImageIcon("new.png");
        Icon iDelete = new ImageIcon("delete.png");
        Icon iSave = new ImageIcon("save.png");
        Icon iUpdate = new ImageIcon("update.png");

        this.bt_new.setIcon(iNew);
        this.bt_delete.setIcon(iDelete);
        this.bt_save.setIcon(iSave);
        this.bt_update.setIcon(iUpdate);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_maSV = new javax.swing.JTextField();
        txt_hoTen = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_soDT = new javax.swing.JTextField();
        rd_nam = new javax.swing.JRadioButton();
        rd_nu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_diaChi = new javax.swing.JTextArea();
        bt_delete = new javax.swing.JButton();
        bt_new = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_save = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_SV = new javax.swing.JTable();
        lb_anh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Quản lý sinh viên");

        jLabel2.setText("Mã SV:");

        jLabel3.setText("Họ tên:");

        jLabel4.setText("Email:");

        jLabel5.setText("Số ĐT:");

        jLabel6.setText("Giới tính:");

        jLabel7.setText("Địa chỉ:");

        rd_nam.setText("Nam");

        rd_nu.setText("Nữ");

        ta_diaChi.setColumns(20);
        ta_diaChi.setRows(5);
        jScrollPane1.setViewportView(ta_diaChi);

        bt_delete.setText("Delete");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        bt_new.setText("New");
        bt_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_newActionPerformed(evt);
            }
        });

        bt_update.setText("Update");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_save.setText("Save");
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });

        tb_SV.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_SV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_SVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_SV);

        lb_anh.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lb_anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_anhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(45, 45, 45)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_maSV, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soDT, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rd_nam)
                        .addGap(40, 40, 40)
                        .addComponent(rd_nu)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_new)
                            .addComponent(bt_delete))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_save)
                            .addComponent(bt_update)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lb_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_maSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_soDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(lb_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rd_nam)
                    .addComponent(rd_nu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_new)
                            .addComponent(bt_save))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_delete)
                            .addComponent(bt_update)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_newActionPerformed
        this.clearform();
    }//GEN-LAST:event_bt_newActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        int row = tb_SV.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        }
        int con = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
        if (con != JOptionPane.YES_OPTION) {
            return;
        }
        String idSV = this.tb_SV.getValueAt(row, 0).toString();
        this.svService.delete(idSV);
        this.loadData();
        this.clearform();
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        int row = tb_SV.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        SinhVien sv = this.addSV();
        if (sv == null) {
            return;
        }
        this.svService.update(sv.getMaSV(), sv);
        this.loadData();
        this.clearform();
    }//GEN-LAST:event_bt_updateActionPerformed

    private void lb_anhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_anhMouseClicked

        try {
            JFileChooser fChooser = new JFileChooser();
            int ketQua = fChooser.showOpenDialog(this);
            if (ketQua == JFileChooser.APPROVE_OPTION) {
                File f = fChooser.getSelectedFile();
                Image img = ImageIO.read(f);
                hinhAnh = f.getName();
                int w = lb_anh.getWidth();
                int h = lb_anh.getHeight();
                lb_anh.setIcon(new ImageIcon(img.getScaledInstance(w, h, 0)));
            }
        } catch (IOException e) {
        }
    }//GEN-LAST:event_lb_anhMouseClicked

    private void tb_SVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SVMouseClicked
        // TODO add your handling code here:
        int row = tb_SV.getSelectedRow();
        txt_maSV.setText(tb_SV.getValueAt(row, 0).toString());
        txt_hoTen.setText(tb_SV.getValueAt(row, 1).toString());
        txt_email.setText(tb_SV.getValueAt(row, 2).toString());
        txt_soDT.setText(tb_SV.getValueAt(row, 3).toString());
        if (tb_SV.getValueAt(row, 4).equals(1)) {
            rd_nam.setSelected(true);
        } else {
            rd_nu.setSelected(true);
        }
        ta_diaChi.setText(tb_SV.getValueAt(row, 5).toString());
        ImageIcon icon = new ImageIcon(tb_SV.getValueAt(row, 6).toString());
        Image img = icon.getImage();
        int w = lb_anh.getWidth();
        int h = lb_anh.getHeight();
        Image imgn = img.getScaledInstance(w, h, 0);
        ImageIcon ic = new ImageIcon(imgn);
        lb_anh.setIcon(ic);
    }//GEN-LAST:event_tb_SVMouseClicked

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
        if(checkMaSV(txt_maSV.getText()) == true){
            JOptionPane.showMessageDialog(this, "Trùng mã SV");
        }else{
            if(checkNew()){
                SinhVien sv = this.addSV();
                this.svService.insert(sv);
                this.loadData();
            }
        }
    }//GEN-LAST:event_bt_saveActionPerformed

    private void clearform() {
        txt_maSV.setText("");
        txt_hoTen.setText("");
        txt_email.setText("");
        txt_soDT.setText("");
        buttonGroup.clearSelection();
        ta_diaChi.setText("");
        lb_anh.setText("");
    }

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
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QLSV qlsv = new QLSV();
                qlsv.setSize(800, 600);
                qlsv.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_new;
    private javax.swing.JButton bt_save;
    private javax.swing.JButton bt_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_anh;
    private javax.swing.JRadioButton rd_nam;
    private javax.swing.JRadioButton rd_nu;
    private javax.swing.JTextArea ta_diaChi;
    private javax.swing.JTable tb_SV;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_maSV;
    private javax.swing.JTextField txt_soDT;
    // End of variables declaration//GEN-END:variables
}

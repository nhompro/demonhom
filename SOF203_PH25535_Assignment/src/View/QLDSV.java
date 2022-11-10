/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.Diem;
import Service.DiemService;

/**
 *
 * @author PC
 */
public class QLDSV extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DiemService dService;

    public QLDSV() {
        dService = new DiemService();
        initComponents();
        addCot();
        this.initIcon();
        loadData();
    }

    public void addCot() {
        ArrayList<String> listCot = new ArrayList<>();
        listCot.add("Mã SV");
        listCot.add("Họ tên");
        listCot.add("Tiếng anh");
        listCot.add("Tin học");
        listCot.add("GDTC");
        listCot.add("Điểm TB");
        defaultTableModel = (DefaultTableModel) tb_diem.getModel();
        defaultTableModel.setColumnCount(0);
        for (String item : listCot) {
            defaultTableModel.addColumn(item);
        }
    }

    public boolean checkNew() {
        if (txt_maSV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Điền mã SV !");
            return false;
        }
        if (txt_hoTen.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Điền họ tên SV !");
            return false;
        }
        if (txt_tAnh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Điền điểm TA !");
            return false;
        }
        if (txt_th.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Điền điểm TH !");
            return false;
        }
        if (txt_gdtc.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Điền điểm GDTC !");
            return false;
        }

        try {
            Double.parseDouble(txt_tAnh.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điểm TA phải là số !");
            return false;
        }
        if (Double.parseDouble(txt_tAnh.getText()) < 0 || Double.parseDouble(txt_tAnh.getText()) > 10) {
            JOptionPane.showMessageDialog(this, "Nhập điểm TA sai !");
            return false;
        }

        try {
            Double.parseDouble(txt_th.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điểm TH phải là số !");
            return false;
        }
        if (Double.parseDouble(txt_th.getText()) < 0 || Double.parseDouble(txt_th.getText()) > 10) {
            JOptionPane.showMessageDialog(this, "Nhập điểm TH sai !");
            return false;
        }

        try {
            Double.parseDouble(txt_gdtc.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Điểm GDTC phải là số !");
            return false;
        }
        if (Double.parseDouble(txt_gdtc.getText()) < 0 || Double.parseDouble(txt_gdtc.getText()) > 10) {
            JOptionPane.showMessageDialog(this, "Nhập điểm GDTC sai !");
            return false;
        }
        return true;
    }

    public boolean checkMaSV(String maSV) {
        ArrayList<Diem> listD = this.dService.getlist();
        for(int i = 0; i < listD.size(); i++){
            if(listD.get(i).getMaSV().equals(maSV)){
                return true;
            }
        }
        return false;
    }

    public Diem addSV() {
        String maSV = txt_maSV.getText();
        String ten = txt_hoTen.getText();
        int dTA = Integer.parseInt(txt_tAnh.getText());
        int dTH = Integer.parseInt(txt_th.getText());
        int dGDTC = Integer.parseInt(txt_gdtc.getText());
        Diem diem = new Diem(maSV, ten, dTA, dTH, dGDTC);
        return diem;
    }

    public void loadData() {
        defaultTableModel = (DefaultTableModel) tb_diem.getModel();
        defaultTableModel.setRowCount(0);
        for (Diem d : this.dService.getlist()) {
            defaultTableModel.addRow(new Object[]{
                d.getMaSV(), d.getHoTen(), d.getDiemTA(), d.getDiemTH(), d.getDiemGDTC(), d.getDiemTB()
            });
        }
    }

    private void initIcon() {
        Icon iSearch = new ImageIcon("search.png");
        Icon iNew = new ImageIcon("new.png");
        Icon iSave = new ImageIcon("save.png");
        Icon iDelete = new ImageIcon("delete.png");
        Icon iUpdate = new ImageIcon("update.png");
        Icon iPrev = new ImageIcon("previous.png");
        Icon iFirst = new ImageIcon("first.png");
        Icon iLast = new ImageIcon("last.png");
        Icon iNext = new ImageIcon("next.png");

        this.bt_search.setIcon(iSearch);
        this.bt_new.setIcon(iNew);
        this.bt_save.setIcon(iSave);
        this.bt_del.setIcon(iDelete);
        this.bt_upd.setIcon(iUpdate);

        this.bt_previous.setText("");
        this.bt_previous.setIcon(iPrev);
        this.bt_first.setText("");
        this.bt_first.setIcon(iFirst);
        this.bt_last.setText("");
        this.bt_last.setIcon(iLast);
        this.bt_next.setText("");
        this.bt_next.setIcon(iNext);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        bt_search = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_hoTen = new javax.swing.JTextField();
        txt_maSV = new javax.swing.JTextField();
        txt_tAnh = new javax.swing.JTextField();
        txt_th = new javax.swing.JTextField();
        txt_gdtc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lb_diem = new javax.swing.JLabel();
        bt_new = new javax.swing.JButton();
        bt_save = new javax.swing.JButton();
        bt_upd = new javax.swing.JButton();
        bt_del = new javax.swing.JButton();
        bt_previous = new javax.swing.JButton();
        bt_last = new javax.swing.JButton();
        bt_first = new javax.swing.JButton();
        bt_next = new javax.swing.JButton();
        lb_record = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_diem = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý điểm sinh viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Quản Lý Điểm Sinh Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Mã SV:");

        bt_search.setForeground(new java.awt.Color(0, 0, 255));
        bt_search.setText("Search");
        bt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(bt_search)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_search))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Họ tên SV:");

        jLabel5.setText("Mã SV:");

        jLabel6.setText("Tiếng anh:");

        jLabel7.setText("Tin học:");

        jLabel8.setText("Giáo dục TC:");

        jLabel9.setText("Điểm TB:");

        lb_diem.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lb_diem.setForeground(new java.awt.Color(51, 51, 255));
        lb_diem.setText("9.0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_gdtc, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_th, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_maSV, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_diem)
                            .addComponent(jLabel9))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5))
                    .addComponent(txt_maSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_tAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_diem)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_th, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_gdtc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_new.setText("New");
        bt_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_newActionPerformed(evt);
            }
        });

        bt_save.setText("Save");
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });

        bt_upd.setText("Update");
        bt_upd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updActionPerformed(evt);
            }
        });

        bt_del.setText("Delete");
        bt_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_delActionPerformed(evt);
            }
        });

        bt_previous.setText("Thêm");

        bt_last.setText("jButton2");

        bt_first.setText("jButton2");

        bt_next.setText("jButton2");

        lb_record.setForeground(new java.awt.Color(51, 51, 255));
        lb_record.setText("3 sinh viên có điểm cao nhất ");

        tb_diem.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_diem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_diemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_diem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(bt_previous)
                        .addGap(18, 18, 18)
                        .addComponent(bt_first)
                        .addGap(13, 13, 13)
                        .addComponent(bt_last)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_next))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bt_new)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(443, 443, 443)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_del)
                                    .addComponent(bt_save)
                                    .addComponent(bt_upd)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_record)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(bt_new)
                        .addGap(26, 26, 26)
                        .addComponent(bt_save)
                        .addGap(18, 18, 18)
                        .addComponent(bt_del)
                        .addGap(18, 18, 18)
                        .addComponent(bt_upd))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_next)
                    .addComponent(bt_previous)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bt_first)
                        .addComponent(bt_last)))
                .addGap(27, 27, 27)
                .addComponent(lb_record)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_newActionPerformed
        // TODO add your handling code here:
        this.clearform();
    }//GEN-LAST:event_bt_newActionPerformed

    private void tb_diemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_diemMouseClicked
        // TODO add your handling code here:
        int row = tb_diem.getSelectedRow();
        txt_maSV.setText(tb_diem.getValueAt(row, 0).toString());
        txt_hoTen.setText(tb_diem.getValueAt(row, 1).toString());
        txt_tAnh.setText(tb_diem.getValueAt(row, 2).toString());
        txt_th.setText(tb_diem.getValueAt(row, 3).toString());
        txt_gdtc.setText(tb_diem.getValueAt(row, 4).toString());
        lb_diem.setText(tb_diem.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tb_diemMouseClicked

    private void bt_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_delActionPerformed
        // TODO add your handling code here:
        int row = tb_diem.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            return;
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận xóa");
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "xóa thành công");
                String idSV = this.tb_diem.getValueAt(row, 0).toString();
                String idSV1 = this.tb_diem.getValueAt(row, 0).toString();
                this.dService.delete(idSV, idSV1);
                loadData();
                clearform();
            }
        }

    }//GEN-LAST:event_bt_delActionPerformed

    private void bt_updActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updActionPerformed
        int row = tb_diem.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần cập nhật");
            return;
        }
        Diem diem = this.addSV();
        if (diem == null) {
            return;
        }
        this.dService.update(diem.getMaSV(), diem);;
        this.loadData();
        this.clearform();
    }//GEN-LAST:event_bt_updActionPerformed

    private void bt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_searchActionPerformed
        // TODO add your handling code here:
        if (txt_search.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập mã sinh viên cần tìm");
        } else {
            Diem d = dService.searchDiem(txt_search.getText());
            if (d == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy mã sinh viên");
            } else {
                txt_maSV.setText(d.getMaSV());
                txt_hoTen.setText(d.getHoTen());
                txt_tAnh.setText(String.valueOf(d.getDiemTA()));
                txt_th.setText(String.valueOf(d.getDiemTH()));
                txt_gdtc.setText(String.valueOf(d.getDiemGDTC()));
                lb_diem.setText(String.valueOf(d.getDiemTB()));
            }
        }
    }//GEN-LAST:event_bt_searchActionPerformed

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
       if(checkMaSV(txt_maSV.getText()) == true){
           JOptionPane.showMessageDialog(this, "Trùng mã SV");
       }else{
           if(checkNew()){
               Diem d = this.addSV();
               this.dService.insert(d);
               JOptionPane.showMessageDialog(this, "Lưu thành công");
               this.loadData();
           }
       }
    }//GEN-LAST:event_bt_saveActionPerformed

    private void clearform() {
        txt_maSV.setText("");
        txt_hoTen.setText("");
        txt_tAnh.setText("");
        txt_th.setText("");
        txt_gdtc.setText("");
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
            java.util.logging.Logger.getLogger(QLDSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLDSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLDSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLDSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLDSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_del;
    private javax.swing.JButton bt_first;
    private javax.swing.JButton bt_last;
    private javax.swing.JButton bt_new;
    private javax.swing.JButton bt_next;
    private javax.swing.JButton bt_previous;
    private javax.swing.JButton bt_save;
    private javax.swing.JButton bt_search;
    private javax.swing.JButton bt_upd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_diem;
    private javax.swing.JLabel lb_record;
    private javax.swing.JTable tb_diem;
    private javax.swing.JTextField txt_gdtc;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_maSV;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_tAnh;
    private javax.swing.JTextField txt_th;
    // End of variables declaration//GEN-END:variables
}

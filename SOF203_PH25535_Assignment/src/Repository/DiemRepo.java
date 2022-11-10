/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Model.Diem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sof203_ph25535_assignment1.JDBCUtil;

/**
 *
 * @author PC
 */
public class DiemRepo {

    public void insert(Diem d) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO GRADE" + "(MASV, Tienganh, Tinhoc, GDTC) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getMaSV());
            ps.setInt(2, d.getDiemTA());
            ps.setInt(3, d.getDiemTH());
            ps.setInt(4, d.getDiemGDTC());
            ps.execute();

            System.out.println("Thêm thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String maSV, Diem d) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE GRADE set Tienganh=?, Tinhoc=?, GDTC=? WHERE MASV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(4, d.getMaSV());
            ps.setInt(1, d.getDiemTA());
            ps.setInt(2, d.getDiemTH());
            ps.setInt(3, d.getDiemGDTC());
            ps.executeUpdate();

            System.out.println("Cập nhật thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String maSV, String maSV1) {
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM GRADE WHERE MASV=? \n"
                    + "DELETE FROM STUDENTS WHERE MASV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.setString(2, maSV1);
            ps.executeUpdate();

            System.out.println("Xóa thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Diem search(String maSV){
        try{
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT HOTEN,Tienganh,Tinhoc,GDTC FROM GRADE JOIN STUDENTS on GRADE.MASV = STUDENTS.MASV WHERE GRADE.MASV = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSV);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                //String maSVV = rs.getString("MASV");
                String hoten = rs.getString("HOTEN");
                int tanh = rs.getInt("Tienganh");
                int th = rs.getInt("Tinhoc");
                int gdtc = rs.getInt("GDTC");
                Diem d = new Diem(maSV, hoten, gdtc, th, gdtc);
                return d;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Diem> all() {
        ArrayList<Diem> listDiem = new ArrayList<>();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT GRADE.MASV,HOTEN,Tienganh,Tinhoc,GDTC FROM GRADE join STUDENTS on GRADE.MASV = STUDENTS.MASV";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while(rs.next()) {
                String maSV = rs.getString("MASV");
                String hoten=rs.getString("HOTEN");
                int tAnh = rs.getInt("Tienganh");
                int tHoc = rs.getInt("Tinhoc");
                int GDTC = rs.getInt("GDTC");
                Diem d = new Diem(maSV, hoten, tAnh, tHoc, GDTC);
                listDiem.add(d);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDiem;
    }
}

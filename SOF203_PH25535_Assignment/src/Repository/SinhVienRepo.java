/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Model.SinhVien;
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
public class SinhVienRepo {
    public void insert(SinhVien sv){
        try{
            Connection conn = JDBCUtil.getConnection();
            String sql = "INSERT INTO STUDENTS" + "(MASV, HOTEN, Email, SoDT, Gioitinh, Diachi, Hinh) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoTen());
            ps.setString(3, sv.getEmail());
            ps.setString(4, sv.getSDT());
            ps.setInt(5, sv.getGioiTinh());
            ps.setString(6, sv.getDiaChi());
            ps.setString(7, sv.getHinh());
            ps.execute();
            
            System.out.println("Thêm thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(String idSV, SinhVien sv){
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "UPDATE STUDENTS set HOTEN = ?, Email = ?, SoDT = ?, Gioitinh = ?, Diachi = ?, Hinh = ? WHERE MASV = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getHoTen());
            ps.setString(2, sv.getEmail());
            ps.setString(3, sv.getSDT());
            ps.setInt(4, sv.getGioiTinh());
            ps.setString(5, sv.getDiaChi());
            ps.setString(6, sv.getHinh());
            ps.setString(7, idSV);
            ps.executeUpdate();
            
            System.out.println("Sửa thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public void delete(String idSV){
        try{
            Connection conn = JDBCUtil.getConnection();
            String sql = "DELETE FROM STUDENTS WHERE MASV = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idSV);
            ps.executeUpdate();
            System.out.println("Xóa thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public SinhVien search(String maSV){
        try{
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM STUDENTS WHERE MASV = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if(rs.next()){
                //String idSV = rs.getString("MASV");
                String ten = rs.getString("HOTEN");
                String email = rs.getString("Email");
                String sdt = rs.getString("SoDT");
                int gioiTinh = rs.getInt("Gioitinh");
                String diaChi = rs.getString("Diachi");
                String hinh = rs.getString("Hinh");
                
                SinhVien sv = new SinhVien(maSV, ten, email, sdt, gioiTinh, diaChi, hinh);
                return sv;
            }else{
                return null;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<SinhVien> all(){
        ArrayList<SinhVien> listSV = new ArrayList<>();
        try{
            Connection conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM STUDENTS";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {                
                String idSV = rs.getString("MASV");
                String ten = rs.getString("HOTEN");
                String email = rs.getString("Email");
                String sdt = rs.getString("SoDT");
                int gioiTinh = rs.getInt("Gioitinh");
                String diaChi = rs.getString("Diachi");
                String hinh = rs.getString("Hinh");
                
                SinhVien sv = new SinhVien(idSV, ten, email, sdt, gioiTinh, diaChi, hinh);
                listSV.add(sv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSV;
    }
}

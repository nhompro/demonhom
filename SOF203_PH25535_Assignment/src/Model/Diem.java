/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PC
 */
public class Diem {
    private String maSV;
    private String hoTen;
    private int diemTA;
    private int diemTH;
    private int diemGDTC;

    public Diem() {
    }

    public Diem(String maSV, String hoTen, int diemTA, int diemTH, int diemGDTC) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemTA = diemTA;
        this.diemTH = diemTH;
        this.diemGDTC = diemGDTC;
    }

//    Diem(String maSV, int tAnh, int tHoc, int GDTC) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getDiemTA() {
        return diemTA;
    }

    public void setDiemTA(int diemTA) {
        this.diemTA = diemTA;
    }

    public int getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(int diemTH) {
        this.diemTH = diemTH;
    }

    public int getDiemGDTC() {
        return diemGDTC;
    }

    public void setDiemGDTC(int diemGDTC) {
        this.diemGDTC = diemGDTC;
    }
    
    public float getDiemTB(){
        float diemTB = 0;
        diemTB = (diemTA + diemTH + diemGDTC)/3;
        return  diemTB;
    }
}

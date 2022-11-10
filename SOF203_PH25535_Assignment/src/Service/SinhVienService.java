/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Repository.SinhVienRepo;
import Model.SinhVien;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class SinhVienService {
    public SinhVienRepo sinhVienRepo = new SinhVienRepo();
    
    public SinhVienService(){
        this.sinhVienRepo = new SinhVienRepo();
    }
    
    public ArrayList<SinhVien> getLists(){
        return this.sinhVienRepo.all();
    }
    
    public void insert(SinhVien sv){
        this.sinhVienRepo.insert(sv);
    }
    
    public void update(String idSV, SinhVien sv){
        this.sinhVienRepo.update(idSV, sv);
    }
    
    public void delete(String idSv){
        this.sinhVienRepo.delete(idSv);
    }
    
    public SinhVien searchSinhVien(String maSV){
        return this.sinhVienRepo.search(maSV);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Repository.DiemRepo;
import Model.Diem;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class DiemService {

    public DiemRepo diemRepo = new DiemRepo();

    public ArrayList<Diem> getlist() {
        return this.diemRepo.all();
    }

    public DiemService() {
        this.diemRepo = new DiemRepo();
    }

    public void insert(Diem d) {
        this.diemRepo.insert(d);
    }

    public void update(String idSV, Diem d) {
        this.diemRepo.update(idSV, d);
    }

    public void delete(String maSV, String maSV1) {
        this.diemRepo.delete(maSV, maSV1);
    }

    public Diem searchDiem(String maSV) {
        return this.diemRepo.search(maSV);
    }

}

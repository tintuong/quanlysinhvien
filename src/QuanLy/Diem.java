/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

/**
 *
 * @author ADMIN
 */
public class Diem {
    private String mahv,mamh,ngthi,kqua;
    private int diem,lanthi;

    public void setMahv(String mahv) {
        this.mahv = mahv;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public void setNgthi(String ngthi) {
        this.ngthi = ngthi;
    }

    public void setKqua(String kqua) {
        this.kqua = kqua;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public void setLanthi(int lanthi) {
        this.lanthi = lanthi;
    }

    public String getMahv() {
        return mahv;
    }

    public String getMamh() {
        return mamh;
    }

    public String getNgthi() {
        return ngthi;
    }

    public String getKqua() {
        return kqua;
    }

    public int getDiem() {
        return diem;
    }

    public int getLanthi() {
        return lanthi;
    }

    public Diem(String mahv, String mamh, int lanthi, String ngthi, int diem, String kqua) {
        this.mahv = mahv;
        this.mamh = mamh;
        this.ngthi = ngthi;
        this.kqua = kqua;
        this.diem = diem;
        this.lanthi = lanthi;
    }
}

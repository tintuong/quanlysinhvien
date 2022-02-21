/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

/**
 *
 * @author ADMIN
 */
public class HocVien {
    private String mahv,ho,ten,ngsinh,gioitinh,noisinh,malop ;

    public HocVien(String mahv, String ho, String ten, String ngsinh, String gioitinh, String noisinh, String malop) {
        this.mahv = mahv;
        this.ho = ho;
        this.ten = ten;
        this.ngsinh = ngsinh;
        this.gioitinh = gioitinh;
        this.noisinh = noisinh;
        this.malop = malop;
    }

    public String getMahv() {
        return mahv;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getNgsinh() {
        return ngsinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getNoisinh() {
        return noisinh;
    }

    public String getMalop() {
        return malop;
    }

    public void setMahv(String mahv) {
        this.mahv = mahv;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgsinh(String ngsinh) {
        this.ngsinh = ngsinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setNoisinh(String noisinh) {
        this.noisinh = noisinh;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }
     
}

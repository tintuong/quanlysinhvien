/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package QuanLy;

/**
 *
 * @author ADMIN
 */
public class GiaoVien {
    private String magv,hoten,hocvi,hocham,gioitinh,ngsinh,ngvl,makhoa;
    private int mucluong,heso;

    public String getMagv() {
        return magv;
    }

    public String getHoten() {
        return hoten;
    }

    public String getHocvi() {
        return hocvi;
    }

    public String getHocham() {
        return hocham;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getNgsinh() {
        return ngsinh;
    }

    public String getNgvl() {
        return ngvl;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public int getMucluong() {
        return mucluong;
    }

    public int getHeso() {
        return heso;
    }
   public void setMagv(String magv) {
        this.magv = magv;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setHocvi(String hocvi) {
        this.hocvi = hocvi;
    }

    public void setHocham(String hocham) {
        this.hocham = hocham;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setNgsinh(String ngsinh) {
        this.ngsinh = ngsinh;
    }

    public void setNgvl(String ngvl) {
        this.ngvl = ngvl;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public void setMucluong(int mucluong) {
        this.mucluong = mucluong;
    }

    public void setHeso(int heso) {
        this.heso = heso;
    }
    public GiaoVien(String magv, String hoten, String hocvi, String hocham, String gioitinh, String ngsinh, String ngvl, int heso, int mucluong, String makhoa) {
        this.magv = magv;
        this.hoten = hoten;
        this.hocvi = hocvi;
        this.hocham = hocham;
        this.gioitinh = gioitinh;
        this.ngsinh = ngsinh;
        this.ngvl = ngvl;
        this.makhoa = makhoa;
        this.mucluong = mucluong;
        this.heso = heso;
    }
    /**
     * @param args the command line arguments
     */
    
}

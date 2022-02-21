/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

/**
 *
 * @author ADMIN
 */
public class Khoa {
    private String makhoa,tenkhoa,ngtlap,trgkhoa;

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    public void setNgtlap(String ngtlap) {
        this.ngtlap = ngtlap;
    }

    public void setTrgkhoa(String trgkhoa) {
        this.trgkhoa = trgkhoa;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public String getNgtlap() {
        return ngtlap;
    }

    public String getTrgkhoa() {
        return trgkhoa;
    }

    public Khoa(String makhoa, String tenkhoa, String ngtlap, String trgkhoa) {
        this.makhoa = makhoa;
        this.tenkhoa = tenkhoa;
        this.ngtlap = ngtlap;
        this.trgkhoa = trgkhoa;
    }
}

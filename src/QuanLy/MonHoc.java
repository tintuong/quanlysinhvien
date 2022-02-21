/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

/**
 *
 * @author ADMIN
 */
public class MonHoc {
    private String mamh,tenmh,makhoa;
    private int tclt,tcth;

    public MonHoc(String mamh, String tenmh,int tclt, int tcth, String makhoa ) {
        this.mamh = mamh;
        this.tenmh = tenmh;
        this.makhoa = makhoa;
        this.tclt = tclt;
        this.tcth = tcth;
    }

    public void setMamh(String mamh) {
        this.mamh = mamh;
    }

    public void setTenmh(String tenmh) {
        this.tenmh = tenmh;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public void setTclt(int tclt) {
        this.tclt = tclt;
    }

    public void setTcth(int tcth) {
        this.tcth = tcth;
    }

    public String getMamh() {
        return mamh;
    }

    public String getTenmh() {
        return tenmh;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public int getTclt() {
        return tclt;
    }

    public int getTcth() {
        return tcth;
    }
}

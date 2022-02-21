/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

/**
 *
 * @author ADMIN
 */
public class LopHoc {
    private String malop,tenlop,trglop,magvcn;
    private int siso;

    public LopHoc(String malop, String tenlop, String trglop, int siso, String magvcn) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.trglop = trglop;
        this.magvcn = magvcn;
        this.siso = siso;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public void setTrglop(String trglop) {
        this.trglop = trglop;
    }

    public void setMagvcn(String magvcn) {
        this.magvcn = magvcn;
    }

    public void setSiso(int siso) {
        this.siso = siso;
    }

    public String getMalop() {
        return malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public String getTrglop() {
        return trglop;
    }

    public String getMagvcn() {
        return magvcn;
    }

    public int getSiso() {
        return siso;
    }
    
    
}

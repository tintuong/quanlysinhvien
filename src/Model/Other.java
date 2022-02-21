/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import static Model.Connect.getDiem;
import static Model.Connect.getGiaoVien;
import static Model.Connect.getHocVien;
import static Model.Connect.getKhoa;
import static Model.Connect.getLopHoc;
import static Model.Connect.getMonHoc;
import QuanLy.Diem;
import QuanLy.GiaoVien;
import QuanLy.HocVien;
import QuanLy.Khoa;
import QuanLy.LopHoc;
import QuanLy.MonHoc;
import java.util.LinkedList;

/**
 *
 * @author ADMIN
 */
public class Other {
  
    public static LinkedList<HocVien> searchHocVien(String timkiem){
        LinkedList<HocVien> ds=new LinkedList<HocVien>();
        LinkedList<HocVien> allHocVien=getHocVien();
        for(HocVien item:allHocVien){
            int flag=0;
            if(item.getMahv().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getHo().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getTen().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getNgsinh().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getGioitinh().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getNoisinh().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getMalop().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(flag!=0)
                ds.add(item);
        }
        return ds;
    }
    public static LinkedList<GiaoVien> searchGiaoVien(String timkiem){
        LinkedList<GiaoVien> ds=new LinkedList<GiaoVien>();
        LinkedList<GiaoVien> allGiaoVien=getGiaoVien();
        for(GiaoVien item:allGiaoVien){
            int flag=0;
            if(item.getGioitinh().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(String.valueOf(item.getHeso()).toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getHocham().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getNgsinh().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getHocvi().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getHoten().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getMagv().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getMakhoa().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(String.valueOf(item.getMucluong()).toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
             if(item.getNgsinh().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
             if(item.getNgvl().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(flag!=0)
                ds.add(item);
        }
        return ds;
    }
     public static LinkedList<LopHoc> searchLopHoc(String timkiem){
        LinkedList<LopHoc> ds=new LinkedList<LopHoc>();
        LinkedList<LopHoc> allLopHoc=getLopHoc();
        for(LopHoc item:allLopHoc){
            int flag=0;
            if(item.getMagvcn().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getMalop().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getTenlop().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getTrglop().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(String.valueOf(item.getSiso()).toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(flag!=0)
                ds.add(item);
        }
        return ds;
    }
     public static LinkedList<MonHoc> searchMonHoc(String timkiem){
        LinkedList<MonHoc> ds=new LinkedList<MonHoc>();
        LinkedList<MonHoc> allMonHoc=getMonHoc();
        for(MonHoc item:allMonHoc){
            int flag=0;
            if(item.getMakhoa().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getMamh().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getTenmh().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(String.valueOf(item.getTclt()).toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(String.valueOf(item.getTcth()).toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(flag!=0)
                ds.add(item);
        }
        return ds;
    }
       public static LinkedList<Diem> searchDiem(String timkiem){
        LinkedList<Diem> ds=new LinkedList<Diem>();
        LinkedList<Diem> allDiem=getDiem();
        for(Diem item:allDiem){
            int flag=0;
            if(item.getNgthi().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getMamh().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getMahv().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(String.valueOf(item.getDiem()).toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(String.valueOf(item.getLanthi()).toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getKqua().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(flag!=0)
                ds.add(item);
        }
        return ds;
    }
        public static LinkedList<Khoa> searchKhoa(String timkiem){
        LinkedList<Khoa> ds=new LinkedList<Khoa>();
        LinkedList<Khoa> allKhoa=getKhoa();
        for(Khoa item:allKhoa){
            int flag=0;
            if(item.getMakhoa().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getNgtlap().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getTenkhoa().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(item.getTrgkhoa().toLowerCase().indexOf(timkiem.toLowerCase())!=-1)
                flag++;
            if(flag!=0)
                ds.add(item);
        }
        return ds;
    }
}

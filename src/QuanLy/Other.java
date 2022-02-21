/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

import static Model.Connect.addDiem;
import static Model.Connect.addGiaoVien;
import static Model.Connect.addHocVien;
import static Model.Connect.addKhoa;
import static Model.Connect.addLopHoc;
import static Model.Connect.addMonHoc;
import static Model.Connect.getDiem;
import static Model.Connect.getGiaoVien;
import static Model.Connect.getHocVien;
import static Model.Connect.getKhoa;
import static Model.Connect.getLopHoc;
import static Model.Connect.getMonHoc;
import static Views.Main.dataTable;
import static Views.Main.maso;
import static Views.Main.them;
import static Views.Main.load;

import Views.addHocVien;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Other {
    public static String[] getTitleTable(String title){
        if(title=="diem"){
            return new String[]{"#","Mã học viên","Mã môn học","Lần thi","Ngày thi","Điểm","Kết quả"};
        }else if(title=="giaovien"){
            return new String[]{"#","Mã giáo viên","Họ tên","Học vị","Học hàm","Giới Tính","Ngày sinh","Ngày làm","Hệ số","Mức lương","Mã Khoa"};
        }else if(title=="hocvien"){
            return new String[]{"#","Mã học viên","Họ","Tên","Ngày sinh","Giới Tính","Nơi sinh","Mã lớp"};
        }else if(title=="khoa"){
            return new String[]{"#","Mã khoa","Tên khoa","Ngày thành lập","Trưởng khoa"};
        }else if(title=="lophoc"){
            return new String[]{"#","Mã lớp","Tên lớp","Lớp trưởng","Sĩ số","Mã giáo viên"};
        }else if(title=="monhoc"){
            return new String[]{"#","Mã môn học","Tên môn học","TChỉ lý thuyết","TChỉ thực hành","Mã khoa"};
        }
        return null;
    }
  public static String getMS(String temp){
      if(temp=="hocvien")
          return "mahv";
      else if(temp=="giaovien")
          return "magv";
      else if(temp=="khoa")
          return "makhoa";
      else if(temp=="diem")
          return "madiem";
      else if(temp=="monhoc")
          return "mamh";
      else if(temp=="lophoc")
          return "malop";
      return null;
  } 

  
  public static void loadFileKhoa(File file){
       String sc;
        try {
            sc = new Scanner( file,"UTF-8").useDelimiter(UUID.randomUUID().toString()).next();
             String[] parts =sc.split("\n");
           
             for(String item:parts){ 
                
                  String[] value =item.split(","); 
                   if(value.length<=1)
                     break;
                  addKhoa(value[0],value[1],value[2],value[3]);     
             }
              dataTable("khoa");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Other.class.getName()).log(Level.SEVERE, null, ex);
        }       
  }
   public static void loadFileHocVien(File file){
       String sc;
        try {
            sc = new Scanner( file,"UTF-8").useDelimiter(UUID.randomUUID().toString()).next();
             String[] parts =sc.split("\n");            
             for(String item:parts){           
                  String[] value =item.split(",");     
                   if(value.length<=1)
                     break;
                  addHocVien(value[0],value[1],value[2],value[3],value[4],value[5],value[6]);
             }
              dataTable("hocvien");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Other.class.getName()).log(Level.SEVERE, null, ex);
        }       
  }
     public static void loadFileGiaoVien(File file){
       String sc;
        try {
            sc = new Scanner( file,"UTF-8").useDelimiter(UUID.randomUUID().toString()).next();
             String[] parts =sc.split("\n");
             for(String item:parts){
                  String[] value =item.split(",");
                   if(value.length<=1)
                     break;
                  addGiaoVien(value[0],value[1],value[2],value[3],value[4],value[5],value[6],Integer.parseInt(value[7]),Integer.parseInt(value[8]),value[9]);
             }
              dataTable("giaovien");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Other.class.getName()).log(Level.SEVERE, null, ex);
        }       
  }
     
       public static void loadFileLopHoc(File file){
       String sc;
        try {
            sc = new Scanner( file,"UTF-8").useDelimiter(UUID.randomUUID().toString()).next();
             String[] parts =sc.split("\n");
             
             for(String item:parts){
                  String[] value =item.split(",");
                   if(value.length<=1)
                     break;
                  addLopHoc(value[0],value[1],value[2],Integer.parseInt(value[3]),value[4]);
             }
              dataTable("lophoc");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Other.class.getName()).log(Level.SEVERE, null, ex);
        }       
  }
              public static void loadFileMonHoc(File file){
       String sc;
        try {
            sc = new Scanner( file,"UTF-8").useDelimiter(UUID.randomUUID().toString()).next();
             String[] parts =sc.split("\n");
             for(String item:parts){
                  String[] value =item.split(",");
                   if(value.length<=1)
                     break;
                  addMonHoc(value[0],value[1],Integer.parseInt(value[2]),Integer.parseInt(value[3]),value[4]);
             }
              dataTable("monhoc");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Other.class.getName()).log(Level.SEVERE, null, ex);
        }       
  }
       public static void loadFileDiem(File file){
       String sc;
        try {
            sc = new Scanner( file,"UTF-8").useDelimiter(UUID.randomUUID().toString()).next();
             String[] parts =sc.split("\n");
             for(String item:parts){
                  String[] value =item.split(",");
                   if(value.length<=1)
                     break;
                  addDiem(value[0],value[1],Integer.parseInt(value[2]),value[3],Integer.parseInt(value[4]),value[5]);
             }
              dataTable("diem");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Other.class.getName()).log(Level.SEVERE, null, ex);
        }       
  }
   
 
}

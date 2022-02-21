/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import QuanLy.Diem;
import QuanLy.GiaoVien;
import QuanLy.HocVien;
import QuanLy.Khoa;
import QuanLy.LopHoc;
import QuanLy.MonHoc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author ADMIN
 */
public class Connect {
    private static String DB_URL = "jdbc:mysql://localhost:3306/doanjava";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    //connect to mysql
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
   // lay toan bo hoc vien
    public static LinkedList<HocVien> getHocVien(){
        LinkedList<HocVien> ds=new LinkedList<HocVien>(); 
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from hocvien");
        while(rs.next()){
            ds.add(new HocVien(rs.getString("mahv"),rs.getString("ho"),
                    rs.getString("ten"),rs.getString("ngsinh"), rs.getString("gioitinh"),
                    rs.getString("noisinh"),rs.getString("malop")));
        }
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return ds;
    }
    //search hocvien
    public static LinkedList<HocVien> searchHocVien(){
        LinkedList<HocVien> ds=new LinkedList<HocVien>(); 
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from hocvien");
        while(rs.next()){
            ds.add(new HocVien(rs.getString("mahv"),rs.getString("ho"),
                    rs.getString("ten"),rs.getString("ngsinh"), rs.getString("gioitinh"),
                    rs.getString("noisinh"),rs.getString("malop")));
        }
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return ds;
    }
      //lay toan bo giang vien
        public static LinkedList<GiaoVien> getGiaoVien(){
        LinkedList<GiaoVien> ds=new LinkedList<GiaoVien>(); 
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from giaovien");
        while(rs.next()){
           
            ds.add(new GiaoVien(rs.getString("magv"),rs.getString("hoten"),rs.getString("hocvi"),
                    rs.getString("hocham"),rs.getString("gioitinh"),rs.getString("ngsinh"),rs.getString("NGVL"),
                    rs.getInt("heso"),rs.getInt("mucluong"),rs.getString("makhoa")));
        }
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ds;
    }
        //lay toan bo diem thi
        public static LinkedList<Diem> getDiem(){
        LinkedList<Diem> ds=new LinkedList<Diem>(); 
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from diem");
        while(rs.next()){
            
            ds.add(new Diem(rs.getString("mahv"),rs.getString("mamh"),
                    rs.getInt("lanthi"),rs.getString("ngthi"),rs.getInt("diem"),rs.getString("kqua")));
        }
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ds;
    }
         //lay toan bo lop hoc
        public static LinkedList<LopHoc> getLopHoc(){
        LinkedList<LopHoc> ds=new LinkedList<LopHoc>(); 
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from lophoc");
        while(rs.next()){
            
            ds.add(new LopHoc(rs.getString("malop"),rs.getString("tenlop"),
                    rs.getString("trglop"),rs.getInt("siso"),rs.getString("magvcn")));
        }
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ds;
    }
        //lay toan bo khoa
        public static LinkedList<Khoa> getKhoa(){
        LinkedList<Khoa> ds=new LinkedList<Khoa>(); 
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from khoa");
        while(rs.next()){
            
            ds.add(new Khoa(rs.getString("makhoa"),rs.getString("tenkhoa"),
                    rs.getString("ngtlap"),rs.getString("trgkhoa")));
        }
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ds;
    }
         //lay toan bo khoa
        public static LinkedList<MonHoc> getMonHoc(){
        LinkedList<MonHoc> ds=new LinkedList<MonHoc>(); 
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from monhoc");
        while(rs.next()){
            
            ds.add(new MonHoc(rs.getString("mamh"),rs.getString("tenmh"),
                    rs.getInt("tclt"),rs.getInt("tcth"),rs.getString("makhoa")));
        }
        conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ds;
    }
     // them hoc vien
        public static void addHocVien(String mahv, String ho, String ten, String ngsinh, String gioitinh, String noisinh, String malop){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="INSERT INTO `hocvien`"
	 + "(`mahv`, `ho`, `ten`, `ngsinh`, `gioitinh`, `noisinh`, `malop`)"
	 + "VALUES('" +mahv+"','"+ho+"','"+ten+"','"+ngsinh+"','"+gioitinh+"','"+noisinh+"','"+malop+"')";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    } 
     // them hoc vien
        public static void addGiaoVien(String magv, String hoten, String hocvi, String hocham, String gioitinh, String ngsinh, String ngvl,int heso,int mucluong,String makhoa){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="INSERT INTO `giaovien`"
	 + "(`MAGV`, `HOTEN`, `HOCVI`, `HOCHAM`, `GIOITINH`, `NGSINH`, `NGVL`, `HESO`, `MUCLUONG`, `MAKHOA`)"
	 + "VALUES('" +magv+"','"+hoten+"','"+hocvi+"','"+hocham+"','"+gioitinh+"','"+ngsinh+"','"+ngvl+"','"+heso+"','"+mucluong+"','"+makhoa+"')";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    } 
        // them Diem
        public static void addDiem(String mahv, String mamh, int lanthi, String ngthi, int diem, String kqua){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="INSERT INTO `diem`"
	 + "(`MAHV`, `MAMH`, `LANTHI`, `NGTHI`, `DIEM`, `KQUA`)"
	 + "VALUES('" +mahv+"','"+mamh+"','"+lanthi+"','"+ngthi+"','"+diem+"','"+kqua+"')";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    } 
            // them Diem
        public static void addKhoa(String makhoa, String tenkhoa, String ngtlap, String trgkhoa){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="INSERT INTO `khoa`"
	 + "(`MAKHOA`, `TENKHOA`, `NGTLAP`, `TRGKHOA`)"
	 + "VALUES('" +makhoa+"','"+tenkhoa+"','"+ngtlap+"','"+trgkhoa+"')";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
           // them Diem
        public static void addLopHoc(String malop, String tenlop, String trglop, int siso, String magvcn){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="INSERT INTO `lophoc`"
	 + "(`MALOP`, `TENLOP`, `TRGLOP`, `siso`, `MAGVCN`)"
	 + "VALUES('" +malop+"','"+tenlop+"','"+trglop+"','"+siso+"','"+magvcn+"')";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
           // them monhoc
        public static void addMonHoc(String mamh, String tenmh, int tclt, int tcth, String makhoa){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="INSERT INTO `monhoc`"
	 + "(`MAMH`, `TENMH`, `TCLT`, `TCTH`, `MAKHOA`)"
	 + "VALUES('" +mamh+"','"+tenmh+"','"+tclt+"','"+tcth+"','"+makhoa+"')";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
                // Xoa data
        public static void xoa(String table, String maso,String giatri){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="DELETE FROM "+table+" WHERE  "+maso+"= \""+giatri+"\";";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
  // Xoa data
     public static void xoaDiem(String mahv, String mamh,int lanthi){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="DELETE FROM diem WHERE MAHV=\""+mahv+"\" AND MAMH=\""+mamh+"\"  AND LANTHI="+lanthi+";";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }      
    }
       // sua data
     public static void suaHocVien(String mahv,String ho,String ten,String ngsinh,
             String gioitinh,String noisinh,String malop,String mahvcu){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="UPDATE `hocvien` SET `mahv`='"+mahv+"',`ho`='"+ho+"',`ten`='"+ten+"',"
                + "`ngsinh`='"+ngsinh+"',`gioitinh`='"+gioitinh+"',`noisinh`='"
                +noisinh+"',`malop`='"+malop+"' WHERE mahv='"+mahvcu+"'";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }      
    }
        // sua data
     public static void suaGiaoVien(String magv,String hoten,String hocvi,String hocham,
             String gioitinh,String ngsinh,String ngvl,int heso,int mucluong,String makhoa,String magvcu){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="UPDATE `giaovien` SET `MAGV`='"+magv+"',`HOTEN`='"+hoten+"',"
                + "`HOCVI`='"+hocvi+"',`HOCHAM`='"+hocham+"',`GIOITINH`='"+gioitinh+"',"
                + "`NGSINH`='"+ngsinh+"',`NGVL`='"+ngvl+"',`HESO`='"+heso+"',"
                + "`MUCLUONG`='"+mucluong+"',`MAKHOA`='"+makhoa+"' WHERE `MAGV`='"+magvcu+"'";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }      
    }
        // sua data
     public static void suaLopHoc(String malop,String tenlop,String trglop,int siso,String magvcn,String malopcu){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="UPDATE `lophoc` SET `MALOP`='"+malop+"',`TENLOP`='"+tenlop+"',"
                + "`TRGLOP`='"+trglop+"',`siso`='"+siso+"',`MAGVCN`='"+magvcn+"' WHERE `MALOP`='"+malopcu+"'";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }      
    }
       // sua data
     public static void suaMonHoc(String mamh,String tenmh,int tclt,int tcth,String makhoa,String mamhcu){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="UPDATE `monhoc` SET `MAMH`='"+mamh+"',`TENMH`='"+tenmh+"',"
                + "`TCLT`='"+tclt+"',`TCTH`='"+tcth+"',`MAKHOA`='"+makhoa+"' WHERE `MAMH`='"+mamhcu+"'";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }      
    }
       public static void suaKhoa(String makhoa,String tenkhoa,String ngtlap,String trgkhoa,String makhoacu){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="UPDATE `khoa` SET `MAKHOA`='"+makhoa+"',`TENKHOA`='"+tenkhoa+"',`NGTLAP`='"+ngtlap+"',`TRGKHOA`='"+trgkhoa+"' WHERE `MAKHOA`='"+makhoacu+"'";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }      
    }
           public static void suaDiem(String mahv,String mamh,int lanthi,String ngthi,int diem,
                   String kqua,String mahvcu,String mamhcu,int lanthicu){
        try{
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        Statement stmt = conn.createStatement();
        
        String sql="UPDATE `diem` SET `MAHV`='"+mahv+"',`MAMH`='"+mamh+"',`LANTHI`='"+lanthi+"',"
                + "`NGTHI`='"+ngthi+"',`DIEM`='"+diem+"',`KQUA`='"+kqua+"' WHERE `MAHV`='"+mahvcu+"'"
                + " AND `MAMH`='"+mamhcu+"' AND `LANTHI`='"+lanthicu+"'";
         stmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }      
    }
  
        
    public static void main(String[] args) {
      addMonHoc("d","d",4,5,"d");
//        LinkedList<MonHoc> ds= new LinkedList<MonHoc>();
//        ds=getMonHoc();
//        for(MonHoc item:ds){
//            System.out.println(item.getMakhoa());
//        }
    }
}

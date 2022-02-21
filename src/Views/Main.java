/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import static Model.Connect.getDiem;
import static Model.Connect.getGiaoVien;
import static Model.Connect.getHocVien;
import static Model.Connect.getKhoa;
import static Model.Connect.getLopHoc;
import static Model.Connect.getMonHoc;
import static Model.Connect.suaDiem;
import static Model.Connect.suaHocVien;
import static Model.Connect.suaGiaoVien;
import static Model.Connect.suaKhoa;
import static Model.Connect.suaLopHoc;
import static Model.Connect.suaMonHoc;
import static Model.Connect.xoa;
import static Model.Connect.xoaDiem;
import static Model.Other.searchDiem;
import static Model.Other.searchGiaoVien;
import static Model.Other.searchHocVien;
import static Model.Other.searchKhoa;
import static Model.Other.searchLopHoc;
import static Model.Other.searchMonHoc;

import QuanLy.Diem;
import QuanLy.GiaoVien;
import QuanLy.HocVien;
import QuanLy.Khoa;
import QuanLy.LopHoc;
import QuanLy.MonHoc;

import static QuanLy.Other.getMS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static QuanLy.Other.getTitleTable;
import static QuanLy.Other.loadFileDiem;
import static QuanLy.Other.loadFileGiaoVien;
import static QuanLy.Other.loadFileHocVien;
import static QuanLy.Other.loadFileKhoa;
import static QuanLy.Other.loadFileLopHoc;
import static QuanLy.Other.loadFileMonHoc;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ADMIN
 */
public  class Main extends javax.swing.JFrame {
       
    /**
     * Creates new form Main
     */
    public static String them;
    public static String maso;
    public static int sua=0;
    public static String masocu=null;
    public static String mahvcu=null;
    public static String mamhcu=null;
    public static int lanthicu=0;
    //

    //db to table
 public static void dataTable(String type){
        DefaultTableModel  table=new DefaultTableModel(){          
          };
        jTable1.setModel(table);
          String[] arr=getTitleTable(type);
             for(int i=0;i<arr.length;i++){
           table.addColumn(arr[i]); 
       }      
        if(type=="hocvien"){
            LinkedList<HocVien> list=getHocVien();
            int stt=1;
             for(HocVien item:list){
            table.addRow(new Object[]{stt,item.getMahv(),item.getHo(),
                item.getTen(),item.getNgsinh(),item.getGioitinh(),item.getNoisinh(),
                item.getMalop()});
            stt++;}
        }else if(type=="giaovien"){
           LinkedList<GiaoVien> list=getGiaoVien();
             int stt=1;
             for(GiaoVien item:list){
            table.addRow(new Object[]{stt,item.getMagv(),item.getHoten(),
                item.getHocvi(),item.getHocham(),item.getGioitinh(),item.getNgsinh(),
                item.getNgvl(),item.getHeso(),item.getMucluong(),item.getMakhoa()});
            stt++;
        }
      }else if(type=="lophoc"){
           LinkedList<LopHoc> list=getLopHoc();
            int stt=1;
              for(LopHoc item:list){
            table.addRow(new Object[]{stt,item.getMalop(),item.getTenlop(),
                item.getTrglop(),item.getSiso(),item.getMagvcn()});
            stt++;
        }
      }
        else if(type=="monhoc"){
           LinkedList<MonHoc> list=getMonHoc();
           int stt=1;
            for(MonHoc item:list){
            table.addRow(new Object[]{stt,item.getMamh(),item.getTenmh(),
                item.getTclt(),item.getTcth(),item.getMakhoa()});
            stt++;
      }}        else if(type=="khoa"){
           LinkedList<Khoa> list=getKhoa();
            int stt=1;
        for(Khoa item:list){
            table.addRow(new Object[]{stt,item.getMakhoa(),
                item.getTenkhoa(),item.getNgtlap(),item.getTrgkhoa()});
            stt++;
        }    
      }else if(type=="diem"){
           LinkedList<Diem> list=getDiem();
             int stt=1;
            for(Diem item:list){
            table.addRow(new Object[]{stt,item.getMahv(),item.getMamh(),item.getLanthi(),
                item.getNgthi(),item.getDiem(),item.getKqua()});
            stt++;
        }
        }
        them=type;
        maso=getMS(type);
        
    }
 // db to table search
  public  static void dataSearchTable(String type,String tukhoa){
        DefaultTableModel  table=new DefaultTableModel(){          
          };
        jTable1.setModel(table);
          String[] arr=getTitleTable(type);
             for(int i=0;i<arr.length;i++){
           table.addColumn(arr[i]); 
       }
        if(type=="hocvien"){
            LinkedList<HocVien> list=searchHocVien(tukhoa);
            int stt=1;
             for(HocVien item:list){
            table.addRow(new Object[]{stt,item.getMahv(),item.getHo(),
                item.getTen(),item.getNgsinh(),item.getGioitinh(),item.getNoisinh(),
                item.getMalop()});
            stt++;}
        }else if(type=="giaovien"){
           LinkedList<GiaoVien> list=searchGiaoVien(tukhoa);
             int stt=1;
             for(GiaoVien item:list){
            table.addRow(new Object[]{stt,item.getMagv(),item.getHoten(),
                item.getHocvi(),item.getHocham(),item.getGioitinh(),item.getNgsinh(),
                item.getNgvl(),item.getHeso(),item.getMucluong(),item.getMakhoa()});
            stt++;
        }
      }else if(type=="lophoc"){
           LinkedList<LopHoc> list=searchLopHoc(tukhoa);
            int stt=1;
              for(LopHoc item:list){
            table.addRow(new Object[]{stt,item.getMalop(),item.getTenlop(),
                item.getTrglop(),item.getSiso(),item.getMagvcn()});
            stt++;
        }
      }
        else if(type=="monhoc"){
           LinkedList<MonHoc> list=searchMonHoc(tukhoa);
           int stt=1;
            for(MonHoc item:list){
            table.addRow(new Object[]{stt,item.getMamh(),item.getTenmh(),
                item.getTclt(),item.getTcth(),item.getMakhoa()});
            stt++;
      }}        else if(type=="khoa"){
           LinkedList<Khoa> list=searchKhoa(tukhoa);
            int stt=1;
        for(Khoa item:list){
            table.addRow(new Object[]{stt,item.getMakhoa(),
                item.getTenkhoa(),item.getNgtlap(),item.getTrgkhoa()});
            stt++;
        }    
      }else if(type=="diem"){
           LinkedList<Diem> list=searchDiem(tukhoa);
             int stt=1;
            for(Diem item:list){
            table.addRow(new Object[]{stt,item.getMahv(),item.getMamh(),item.getLanthi(),
                item.getNgthi(),item.getDiem(),item.getKqua()});
            stt++;
        }
        }
        them=type;
        maso=getMS(type);
    }

    public Main() {
        initComponents();
        //chinh sua head table
   
        jTable1.getTableHeader().setFont(new Font("Arial",Font.BOLD,14));
         jTable1.getTableHeader().setPreferredSize(new Dimension(0,26) );
         DefaultTableCellRenderer hr = (DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer();
        hr.setHorizontalAlignment(DefaultTableCellRenderer.LEFT);
  
     
    }

  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        giaovien = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hocvien = new javax.swing.JLabel();
        lophoc = new javax.swing.JLabel();
        khoa = new javax.swing.JLabel();
        monhoc = new javax.swing.JLabel();
        diem = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        selectFile = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        load = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        nutsua = new javax.swing.JLabel();
        nuttim = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        nutxoa = new javax.swing.JLabel();
        nutthem = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(239, 239, 239));

        giaovien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png"))); // NOI18N
        giaovien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                giaovienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                giaovienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                giaovienMouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N

        hocvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png"))); // NOI18N
        hocvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hocvienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hocvienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hocvienMouseExited(evt);
            }
        });

        lophoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.png"))); // NOI18N
        lophoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lophocMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lophocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lophocMouseExited(evt);
            }
        });

        khoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/7.png"))); // NOI18N
        khoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                khoaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                khoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                khoaMouseExited(evt);
            }
        });

        monhoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.png"))); // NOI18N
        monhoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monhocMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                monhocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                monhocMouseExited(evt);
            }
        });

        diem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6.png"))); // NOI18N
        diem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                diemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                diemMouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOAD FILE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        selectFile.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        selectFile.setForeground(new java.awt.Color(102, 102, 102));
        selectFile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sinh viên", "Giáo viên", "Lớp học", "Môn học", "Khoa", "Điểm" }));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Thêm từ file");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(selectFile, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(hocvien)
                    .addComponent(giaovien)
                    .addComponent(lophoc)
                    .addComponent(monhoc)
                    .addComponent(diem)
                    .addComponent(jLabel12)
                    .addComponent(khoa)
                    .addComponent(jLabel1))
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hocvien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(giaovien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lophoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monhoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(diem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(khoa)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(selectFile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(load, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        nutsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/10.png"))); // NOI18N
        nutsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nutsuaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nutsuaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nutsuaMouseExited(evt);
            }
        });

        nuttim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/11.png"))); // NOI18N
        nuttim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuttimMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nuttimMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nuttimMouseExited(evt);
            }
        });

        search.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        nutxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/9.png"))); // NOI18N
        nutxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nutxoaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nutxoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nutxoaMouseExited(evt);
            }
        });

        nutthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/8.png"))); // NOI18N
        nutthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nutthemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nutthemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nutthemMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(nutthem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nutxoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nutsua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nuttim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nuttim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nutsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(search, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(nutxoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nutthem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(240, 240, 240));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new java.awt.Color(240, 240, 239));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 993, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hocvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hocvienMouseClicked
        // TODO add your handling code here:
        dataTable("hocvien");      
    }//GEN-LAST:event_hocvienMouseClicked

    private void giaovienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_giaovienMouseClicked
        // TODO add your handling code here:
        dataTable("giaovien");
    }//GEN-LAST:event_giaovienMouseClicked

    private void lophocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lophocMouseClicked
        // TODO add your handling code here:
        dataTable("lophoc");
    }//GEN-LAST:event_lophocMouseClicked

    private void monhocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monhocMouseClicked
        // TODO add your handling code here:
     dataTable("monhoc");

    }//GEN-LAST:event_monhocMouseClicked

    private void diemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diemMouseClicked
        // TODO add your handling code here:
        //hien data cho table
        dataTable("diem");
    }//GEN-LAST:event_diemMouseClicked

    private void khoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_khoaMouseClicked
        // TODO add your handling code here:
        dataTable("khoa");
    }//GEN-LAST:event_khoaMouseClicked

    private void hocvienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hocvienMouseEntered
        // TODO add your handling code here:
         ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/3_hover.png"));
         hocvien.setIcon(image);
    }//GEN-LAST:event_hocvienMouseEntered

    private void hocvienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hocvienMouseExited
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/2.png"));
         hocvien.setIcon(image);
    }//GEN-LAST:event_hocvienMouseExited

    private void giaovienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_giaovienMouseEntered
        // TODO add your handling code here:
         ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/5_hover.png"));
         giaovien.setIcon(image);
    }//GEN-LAST:event_giaovienMouseEntered

    private void giaovienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_giaovienMouseExited
        // TODO add your handling code here:
         ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/3.png"));
         giaovien.setIcon(image);
    }//GEN-LAST:event_giaovienMouseExited

    private void lophocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lophocMouseEntered
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/7_hover.png"));
         lophoc.setIcon(image);
    }//GEN-LAST:event_lophocMouseEntered

    private void lophocMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lophocMouseExited
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/4.png"));
         lophoc.setIcon(image);
    }//GEN-LAST:event_lophocMouseExited

    private void monhocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monhocMouseEntered
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/9_hover.png"));
         monhoc.setIcon(image);
    }//GEN-LAST:event_monhocMouseEntered

    private void monhocMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monhocMouseExited
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/5.png"));
         monhoc.setIcon(image);
    }//GEN-LAST:event_monhocMouseExited

    private void diemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diemMouseEntered
        // TODO add your handling code here:
         ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/11_hover.png"));
         diem.setIcon(image);
    }//GEN-LAST:event_diemMouseEntered

    private void diemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diemMouseExited
        // TODO add your handling code here:
            ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/6.png"));
         diem.setIcon(image);
    }//GEN-LAST:event_diemMouseExited

    private void khoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_khoaMouseEntered
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/13_hover.png"));
         khoa.setIcon(image);
    }//GEN-LAST:event_khoaMouseEntered

    private void khoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_khoaMouseExited
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
                        getClass().getResource("/images/7.png"));
         khoa.setIcon(image);
    }//GEN-LAST:event_khoaMouseExited

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void nuttimMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuttimMouseExited
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
            getClass().getResource("/images/11.png"));
        nuttim.setIcon(image);
    }//GEN-LAST:event_nuttimMouseExited

    private void nuttimMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuttimMouseEntered
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
            getClass().getResource("/images/21_hover.png"));
        nuttim.setIcon(image);
    }//GEN-LAST:event_nuttimMouseEntered

    private void nuttimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuttimMouseClicked
        // TODO add your handling code here:
        String tukhoa=search.getText();
        dataSearchTable(them,tukhoa);
    }//GEN-LAST:event_nuttimMouseClicked

    private void nutxoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nutxoaMouseExited
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
            getClass().getResource("/images/9.png"));
        nutxoa.setIcon(image);
    }//GEN-LAST:event_nutxoaMouseExited

    private void nutxoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nutxoaMouseEntered
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
            getClass().getResource("/images/17_hover.png"));
        nutxoa.setIcon(image);
    }//GEN-LAST:event_nutxoaMouseEntered

    private void nutxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nutxoaMouseClicked
        // TODO add your handling code here:
        int row=jTable1.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(Main.this, "Vui lòng chọn trước !","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            int luachon=JOptionPane.showConfirmDialog(Main.this, "Bạn đồng ý xóa không ?");
            if(luachon==JOptionPane.YES_OPTION){

                if(them=="diem"){
                    xoaDiem((String) jTable1.getValueAt(row,1),(String) jTable1.getValueAt(row,2),(Integer) jTable1.getValueAt(row,3));
                }else{
                    String giatri=(String) jTable1.getValueAt(row,1);
                    xoa(them,maso,giatri);
                }
                if(them=="hocvien"){
                    dataTable("hocvien");
                }else if(them=="giaovien"){
                    dataTable("giaovien");
                }else if(them=="lophoc"){
                    dataTable("lophoc");
                }else if(them=="monhoc"){
                    dataTable("monhoc");
                }else if(them=="diem"){
                    dataTable("diem");
                }else if(them=="khoa"){
                    dataTable("khoa");
                }
            }
        }
    }//GEN-LAST:event_nutxoaMouseClicked

    private void nutthemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nutthemMouseExited
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
            getClass().getResource("/images/8.png"));
        nutthem.setIcon(image);
    }//GEN-LAST:event_nutthemMouseExited

    private void nutthemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nutthemMouseEntered
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
            getClass().getResource("/images/15_hover.png"));
        nutthem.setIcon(image);
    }//GEN-LAST:event_nutthemMouseEntered

    private void nutthemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nutthemMouseClicked
        // TODO add your handling code here:
        if(them=="giaovien"){
            addGiaoVien window=new addGiaoVien();
            window.setVisible(true);
        }else if(them=="hocvien"){
            addHocVien window=new addHocVien();
            window.setVisible(true);
        }else if(them=="diem"){
            addDiem window=new addDiem();
            window.setVisible(true);
        }else if(them=="khoa"){
            addKhoa window=new addKhoa();
            window.setVisible(true);
        }else if(them=="lophoc"){
            addLopHoc window=new addLopHoc();
            window.setVisible(true);
        }else if(them=="monhoc"){
            addMonHoc window=new addMonHoc();
            window.setVisible(true);
        }

    }//GEN-LAST:event_nutthemMouseClicked

    private void nutsuaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nutsuaMouseExited
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
            getClass().getResource("/images/10.png"));
        nutsua.setIcon(image);
    }//GEN-LAST:event_nutsuaMouseExited

    private void nutsuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nutsuaMouseEntered
        // TODO add your handling code here:
        ImageIcon image = new ImageIcon(
            getClass().getResource("/images/19_hover.png"));
        nutsua.setIcon(image);
    }//GEN-LAST:event_nutsuaMouseEntered

    private void nutsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nutsuaMouseClicked
        // TODO add your handling code here:
        if(sua==0){
            int row=jTable1.getSelectedRow();
            if(them!="diem")
            masocu=(String) jTable1.getValueAt(row,1);
            else{
                mahvcu=(String) jTable1.getValueAt(row,1);
                mamhcu=(String) jTable1.getValueAt(row,2);
                lanthicu=(Integer) jTable1.getValueAt(row,3);
            }
            JOptionPane.showMessageDialog(jPanel1,"Bạn đã chọn dòng cần sửa !");
            sua=1;
        }else{
            int luachon=JOptionPane.showConfirmDialog(Main.this, "Bạn đồng ý sửa không ?");
            if(luachon==JOptionPane.YES_OPTION){
                int row=jTable1.getSelectedRow();
                if(them=="hocvien"){
                    String mahv=(String) jTable1.getValueAt(row,1);
                    String ho=(String) jTable1.getValueAt(row,2);
                    String ten=(String) jTable1.getValueAt(row,3);
                    String ngsinh=(String) jTable1.getValueAt(row,4);
                    String gioitinh=(String) jTable1.getValueAt(row,5);
                    String noisinh=(String) jTable1.getValueAt(row,6);
                    String malop=(String) jTable1.getValueAt(row,7);
                    suaHocVien(mahv,ho,ten,ngsinh,gioitinh,noisinh,malop,masocu);
                }else if(them=="giaovien"){
                    String magv=(String) jTable1.getValueAt(row,1);
                    String hoten=(String) jTable1.getValueAt(row,2);
                    String hocvi=(String) jTable1.getValueAt(row,3);
                    String hocham=(String) jTable1.getValueAt(row,4);
                    String gioitinh=(String) jTable1.getValueAt(row,5);
                    String ngsinh=(String) jTable1.getValueAt(row,6);
                    String ngvl=(String) jTable1.getValueAt(row,7);
                    int heso=0;
                    int mucluong=0;
                    if(jTable1.getValueAt(row,8) instanceof  String)
                    heso=Integer.parseInt((String) jTable1.getValueAt(row,8));
                    else
                    heso=(Integer)jTable1.getValueAt(row,8);
                    if(jTable1.getValueAt(row,9) instanceof  String)
                    mucluong=Integer.parseInt((String) jTable1.getValueAt(row,9));
                    else
                    mucluong=(Integer)jTable1.getValueAt(row,9);;
                    String makhoa=(String) jTable1.getValueAt(row,10);
                    suaGiaoVien(magv,hoten,hocvi,hocham,
                        gioitinh,ngsinh,ngvl,heso, mucluong, makhoa,masocu);
                }else if(them=="lophoc"){
                    String malop=(String) jTable1.getValueAt(row,1);
                    String tenlop=(String) jTable1.getValueAt(row,2);
                    String trglop=(String) jTable1.getValueAt(row,3);
                    int siso=0;
                    if(jTable1.getValueAt(row,4) instanceof  String)
                    siso=Integer.parseInt((String) jTable1.getValueAt(row,4));
                    else
                    siso=(Integer)jTable1.getValueAt(row,4);
                    String magv=(String) jTable1.getValueAt(row,5);
                    suaLopHoc(malop,tenlop,trglop,siso,magv,masocu);
                }else if(them=="monhoc"){
                    int tclt=0;
                    int tcth=0;
                    if(jTable1.getValueAt(row,3) instanceof  String)
                    tclt=Integer.parseInt((String) jTable1.getValueAt(row,3));
                    else
                    tclt=(Integer)jTable1.getValueAt(row,3);
                    if(jTable1.getValueAt(row,4) instanceof  String)
                    tcth=Integer.parseInt((String) jTable1.getValueAt(row,4));
                    else
                    tcth=(Integer)jTable1.getValueAt(row,4);
                    String mamh=(String) jTable1.getValueAt(row,1);
                    String tenmh=(String) jTable1.getValueAt(row,2);
                    String makhoa=(String) jTable1.getValueAt(row,5);
                    suaMonHoc(mamh,tenmh,tclt,tcth,makhoa,masocu);
                }else if(them=="khoa"){
                    String makhoa=(String) jTable1.getValueAt(row,1);
                    String tenkhoa=(String) jTable1.getValueAt(row,2);
                    String ngtlap=(String) jTable1.getValueAt(row,3);
                    String trgkhoa=(String) jTable1.getValueAt(row,4);
                    suaKhoa(makhoa,tenkhoa,ngtlap,trgkhoa,masocu);
                }else if(them=="diem"){
                    String mahv=(String) jTable1.getValueAt(row,1);
                    String makhoa=(String) jTable1.getValueAt(row,2);
                    int lanthi=0;
                    int diem=0;
                    if(jTable1.getValueAt(row,3) instanceof  String)
                    lanthi=Integer.parseInt((String) jTable1.getValueAt(row,3));
                    else
                    lanthi=(Integer)jTable1.getValueAt(row,3);
                    if(jTable1.getValueAt(row,5) instanceof  String)
                    diem=Integer.parseInt((String) jTable1.getValueAt(row,5));
                    else
                    diem=(Integer)jTable1.getValueAt(row,5);
                    String ngthi=(String) jTable1.getValueAt(row,4);
                    String kqua=(String) jTable1.getValueAt(row,6);
                    suaDiem(mahv,makhoa,lanthi,ngthi,diem,kqua,mahvcu,mamhcu,lanthicu);
                }
                sua=0;
            }
        }
    }//GEN-LAST:event_nutsuaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
            // TODO add your handling code here:
            
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter fileName = new FileNameExtensionFilter("txt","txt");
            fileChooser.setFileFilter(fileName);
            fileChooser.setMultiSelectionEnabled(false);
            int returnValue = fileChooser.showDialog(this,"Chon File");
            File f =fileChooser.getSelectedFile();
            if(selectFile.getSelectedItem()=="Sinh viên"){
                loadFileHocVien(f);
            }else if(selectFile.getSelectedItem()=="Giáo viên"){
                  loadFileGiaoVien(f);
            }else if(selectFile.getSelectedItem()=="Lớp học"){
                  loadFileLopHoc(f);
            }else if(selectFile.getSelectedItem()=="Môn học"){
                  loadFileMonHoc(f);
            }else if(selectFile.getSelectedItem()=="Điểm"){
                  loadFileDiem(f);
            }else if(selectFile.getSelectedItem()=="Khoa"){
                  loadFileKhoa(f);
            }   
            
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel diem;
    private javax.swing.JLabel giaovien;
    private javax.swing.JLabel hocvien;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JLabel khoa;
    public static javax.swing.JProgressBar load;
    private javax.swing.JLabel lophoc;
    private javax.swing.JLabel monhoc;
    private javax.swing.JLabel nutsua;
    private javax.swing.JLabel nutthem;
    private javax.swing.JLabel nuttim;
    private javax.swing.JLabel nutxoa;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> selectFile;
    // End of variables declaration//GEN-END:variables
}

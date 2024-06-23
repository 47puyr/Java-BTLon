
package BUS;

import DAO.ChiTietPhieuNhapDAO;
import POJO.ChiTietPhieuNhapPOJO;
import POJO.DateCustomPOJO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;


public class ChiTietPhieuNhapBUS {
    static ArrayList<ChiTietPhieuNhapPOJO> listChiTietPhieuNhap;

    public static void setListChiTietPhieuNhap(ArrayList<ChiTietPhieuNhapPOJO> listChiTietPhieuNhap) {
        ChiTietPhieuNhapBUS.listChiTietPhieuNhap = listChiTietPhieuNhap;
    }

    public static ArrayList<ChiTietPhieuNhapPOJO> getListChiTietPhieuNhap() {
        return listChiTietPhieuNhap;
    }
    public void setListChiTietPN(ArrayList<ChiTietPhieuNhapPOJO> listChiTietPhieuNhap) {
        ChiTietPhieuNhapBUS.listChiTietPhieuNhap = listChiTietPhieuNhap;
    }

    public  ArrayList<ChiTietPhieuNhapPOJO> getListChiTietPN() {
        return listChiTietPhieuNhap;
    }
    public ChiTietPhieuNhapBUS() {
    }
    public void  loadDSChiTietPhieuNhap() throws Exception{
        ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
        if(listChiTietPhieuNhap==null) listChiTietPhieuNhap = new ArrayList<ChiTietPhieuNhapPOJO>();
        listChiTietPhieuNhap=data.loadDatabase();
    }
    public void loadDSChiTietPhieuNhapCondition(String condition) throws IOException, Exception{
        ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
        if(listChiTietPhieuNhap==null) listChiTietPhieuNhap = new ArrayList<ChiTietPhieuNhapPOJO>();
        listChiTietPhieuNhap=data.loadDatabasewithCondition(condition);
    }
    public void addChiTietPhieuNhap(ChiTietPhieuNhapPOJO sach) throws Exception{
        // validate data
        ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
        data.addChiTietPhieuNhap(sach);
        listChiTietPhieuNhap.add(sach);
        
    }
    public void deleteChiTietPhieuNhap(String idChiTietPhieuNhap) throws Exception{
        
        for(ChiTietPhieuNhapPOJO sach : listChiTietPhieuNhap )
        {
            if(sach.getID().equalsIgnoreCase(idChiTietPhieuNhap))
            {   
                try {
                   listChiTietPhieuNhap.remove(sach);
                    ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
                    data.delete(idChiTietPhieuNhap);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa ChiTietPhieuNhap vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void deleteChiTietPhieuNhapByMaPN(String MaPN) throws Exception{
        
        for(ChiTietPhieuNhapPOJO sach : listChiTietPhieuNhap )
        {
            if(sach.getMaPN().equalsIgnoreCase(MaPN))
            {   
                try {
                   listChiTietPhieuNhap.remove(sach);
                    ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
                    data.deletebyMaPN(MaPN);
                } catch (Exception e) {
                    System.out.println("Khong the Xoa ChiTietPhieuNhap trong database  bằng Mã Phiếu Nhập !!!");
                } 
                return;
            }
        }
        
    }
    public void deleteChiTietPhieuNhapByMaSach(String MaSach) throws Exception{
        
        for(ChiTietPhieuNhapPOJO sach : listChiTietPhieuNhap )
        {
            if(sach.getMaSach().equalsIgnoreCase(MaSach))
            {   
                try {
                   listChiTietPhieuNhap.remove(sach);
                    ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
                    data.deletebyMaSach(MaSach);
                } catch (Exception e) {
                    System.out.println("Khong the Xoa ChiTietPhieuNhap trong database  bằng Mã Sách !!!");
                } 
                return;
            }
        }
        
    }
    public void updateChiTietPhieuNhap(ChiTietPhieuNhapPOJO sach) throws Exception{
         for(int i = 0 ; i < listChiTietPhieuNhap.size() ; i++)
        {
            if(listChiTietPhieuNhap.get(i).getMaPN().equals(sach.getMaPN()))
            {
                try {
                    listChiTietPhieuNhap.set(i, sach);
                ChiTietPhieuNhapDAO data =new ChiTietPhieuNhapDAO();
                data.updateChiTietPhieuNhap(sach);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat ChiTietPhieuNhap vao database !!!");
                   
                }
                
                return;
            }
        }
    }
    public boolean CheckSL(String MaSP,int SoLuong){
        for(ChiTietPhieuNhapPOJO ctpn : listChiTietPhieuNhap)
         {
             if(ctpn.getMaSach().equalsIgnoreCase(MaSP))
             {               
                if(SoLuong <= ctpn.getSoLuong())   return true;
             }
         }
         return false;
    }
    public int getSoLuong(String MaSP){
        for(ChiTietPhieuNhapPOJO ctpn : listChiTietPhieuNhap)
         {
             if(ctpn.getMaSach().equalsIgnoreCase(MaSP))
             {               
                return ctpn.getSoLuong();
             }
         }
         return 0;
    }
   public ArrayList<ChiTietPhieuNhapPOJO> searchMaPN(String idPN ){
       ArrayList<ChiTietPhieuNhapPOJO> list =new ArrayList<>();
       for(ChiTietPhieuNhapPOJO ct : listChiTietPhieuNhap){
           if( ct.getMaPN().equalsIgnoreCase(idPN)) list.add(ct);
       }
       return list;
   }
   
   public ChiTietPhieuNhapPOJO searchMaChiTietPN(String idCTPN ){
       for(ChiTietPhieuNhapPOJO ct : listChiTietPhieuNhap){
           if( ct.getID().equalsIgnoreCase(idCTPN)) return ct;
       }
       return null ;
   }
    public ArrayList<ChiTietPhieuNhapPOJO> searchChiTietPhieuNhap(String mactpn,String masach,int giamin,int giamax,float tienmin,float tienmax) throws ParseException
    {
        ArrayList<ChiTietPhieuNhapPOJO> search = new ArrayList<>();
        mactpn = mactpn.isEmpty()?mactpn = "": mactpn;
        masach = masach.equalsIgnoreCase("Không")?masach = "": masach;
       
        for(ChiTietPhieuNhapPOJO ct : listChiTietPhieuNhap)
        {
            if( ct.getID().contains(mactpn) &&
                ct.getMaSach().contains(masach) &&
                ct.getDonGia() >= giamin && ct.getDonGia() <= giamax &&
                    ct.getThanhTien()>= tienmin && ct.getThanhTien() <=tienmax
               ) 
            {
                
                search.add(ct);
            }
        }
        return search;
    }
  public ArrayList<ChiTietPhieuNhapPOJO> searchMaSach(String idPN ){
       ArrayList<ChiTietPhieuNhapPOJO> list =new ArrayList<>();
       for(ChiTietPhieuNhapPOJO ct : listChiTietPhieuNhap){
           if( ct.getMaPN().equalsIgnoreCase(idPN)) list.add(ct);
       }
       return list;
   }
   public ArrayList<String> getListMaSach( ) throws Exception{
       ArrayList<String> list =new ArrayList<String>();
       for(ChiTietPhieuNhapPOJO ct : listChiTietPhieuNhap) {
           list.add(ct.getMaSach());
       }
       return list ;
   }
    
}
//SELECT * FROM phieunhap WHERE NgayNhap BETWEEN '2020-01-12' AND '2021-12-01'
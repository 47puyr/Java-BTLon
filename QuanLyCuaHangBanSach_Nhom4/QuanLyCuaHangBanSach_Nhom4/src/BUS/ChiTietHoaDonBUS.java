package BUS;

import DAO.ChiTietHoaDonDAO;
import POJO.ChiTietHoaDonPOJO;
import POJO.HoaDonPOJO;
import java.util.ArrayList;

public class ChiTietHoaDonBUS {
     static ArrayList<ChiTietHoaDonPOJO> CTHD;
    public ChiTietHoaDonBUS(){
        
    }
    public ChiTietHoaDonBUS(int i){
        List();
    }
    public void List(){
        ChiTietHoaDonDAO HDDAO=new ChiTietHoaDonDAO();
        CTHD=new ArrayList<>();
        CTHD=HDDAO.List();
    }
    public ArrayList<ChiTietHoaDonPOJO> getListHD(String MaHD){
        ArrayList<ChiTietHoaDonPOJO> ds=new ArrayList<>();
        for(ChiTietHoaDonPOJO ct: CTHD){
            if(ct.getMaHD().equals(MaHD))
                ds.add(ct);
        }
            
        return ds;
    }
    public void Them(ChiTietHoaDonPOJO ct){
        CTHD.add(ct);
        ChiTietHoaDonDAO ctdao=new ChiTietHoaDonDAO();
        ctdao.Them(ct);
    }
    public void Sua(ChiTietHoaDonPOJO ct){
        for(int i=0;i<CTHD.size();i++){
            if(CTHD.get(i).getMaHD().equals(ct.getMaHD()) && CTHD.get(i).getMaSach().equals(ct.getMaSach())){

                ChiTietHoaDonDAO ctDAO=new ChiTietHoaDonDAO();
                ctDAO.Sua(ct);
                CTHD.set(i,ct);
            }
        }
    }
    public void Xoa(String MaHD){
        for(ChiTietHoaDonPOJO ct: CTHD){
            if(ct.getMaHD().equals(MaHD)){
                CTHD.remove(ct);
                ChiTietHoaDonDAO CTDAO=new ChiTietHoaDonDAO();
                CTDAO.Xoa(MaHD);
                return;
            }
        }
    }
    public void XoaMS(String MaSach,String MaHD){
        for(ChiTietHoaDonPOJO ct: CTHD){
            if(ct.getMaSach().equals(MaSach) && ct.getMaHD().equals(MaHD)){
                CTHD.remove(ct);
                ChiTietHoaDonDAO CTDAO=new ChiTietHoaDonDAO();
                CTDAO.XoaMS(MaSach,MaHD);
                return;
            }
        }
    }
    public void deleteChiTietHoaDonByMaSach(String MaSach) throws Exception{
        
        for(ChiTietHoaDonPOJO sach : CTHD )
        {
            if(sach.getMaSach().equalsIgnoreCase(MaSach))
            {   
                try {
                   CTHD.remove(sach);
                    ChiTietHoaDonDAO data =new ChiTietHoaDonDAO();
                    data.deletebyMaSach(MaSach);
                } catch (Exception e) {
                    System.out.println("Khong the Xoa ChiTietPhieuNhap trong database  bằng Mã Sách !!!");
                } 
                return;
            }
        }
        
    }
    public ArrayList<ChiTietHoaDonPOJO> getList(){
        return CTHD;
    }
    
}

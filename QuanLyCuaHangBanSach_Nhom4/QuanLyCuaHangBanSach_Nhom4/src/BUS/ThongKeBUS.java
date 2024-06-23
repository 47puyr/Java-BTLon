

package BUS;

import DAO.ThongKeDAO;
import POJO.ThongKePOJO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class ThongKeBUS {
    /*Phiếu Nhập*/
    HashMap<String,Object> tbthongkePNNCC ;
    public ArrayList<ThongKePOJO> tbthongkePNNCCtheoQuy;
    /*Hoa Don*/
     HashMap<String,Object> tbthongkeHDKH ;
    public ArrayList<ThongKePOJO> tbthongkeHDSPtheoQuy;
    public ArrayList<ThongKePOJO> tbthongkeHDNVtheoQuy;

    public void setTbthongkeHDKH(HashMap<String, Object> tbthongkeHDKH) {
        this.tbthongkeHDKH = tbthongkeHDKH;
    }

    public HashMap<String, Object> getTbthongkeHDKH() {
        return tbthongkeHDKH;
    }

    public HashMap<String, Object> getTbthongkePNNCC() {
        return tbthongkePNNCC;
    }

    public void setTbthongkePNNCC(HashMap<String, Object> tbthongkePNNCC) {
        this.tbthongkePNNCC = tbthongkePNNCC;
    }
    
     
    public ArrayList<ThongKePOJO> getTbthongkePNNCCtheoQuy() {
        return tbthongkePNNCCtheoQuy;
    }

    public void setTbthongkePNNCCtheoQuy(ArrayList<ThongKePOJO> tbthongkePNNCCtheoQuy) {
        this.tbthongkePNNCCtheoQuy = tbthongkePNNCCtheoQuy;
    }

    public ArrayList<ThongKePOJO> getTbthongkeHDSPtheoQuy() {
        return tbthongkeHDSPtheoQuy;
    }

    public void setTbthongkeHDSPtheoQuy(ArrayList<ThongKePOJO> tbthongkeHDSPtheoQuy) {
        this.tbthongkeHDSPtheoQuy = tbthongkeHDSPtheoQuy;
    }

    public ArrayList<ThongKePOJO> getTbthongkeHDNVtheoQuy() {
        return tbthongkeHDNVtheoQuy;
    }
    public void setTbthongkeHDNVtheoQuy(ArrayList<ThongKePOJO> tbthongkeHDNVtheoQuy) {
        this.tbthongkeHDNVtheoQuy = tbthongkeHDNVtheoQuy;
    }

   
    
     /*Các hàm tra ve gia tri thong ke cho phieu nhap*/
    public float TongTienPNTheoTG(String ngaymin,String ngaymax) throws IOException{
         ThongKeDAO dao =new ThongKeDAO();
         return dao.TongTienPhieuNhapTheoNgayNhap(ngaymin, ngaymax);
    }
    public long TongTienPN() throws IOException{
         ThongKeDAO dao =new ThongKeDAO();
         return dao.TongTienPhieuNhap();
    }
    public void ThongKeTienPNTheoMaNCC() throws IOException{
        ThongKeDAO dao =new ThongKeDAO();
        if(tbthongkePNNCC==null ) tbthongkePNNCC = new HashMap<String,Object>();
        tbthongkePNNCC=dao.TongTienPhieuNhapTheoMaNCC();
        
    }
    public void ThongKePNTheoQuyVaMaNCC(String year) throws IOException, Exception{
        ThongKeDAO dao =new ThongKeDAO();
       tbthongkePNNCCtheoQuy=dao.xuatThongKePNNCCtheoQuy(year);
        
    }
    /*Các hàm tra ve gia tri thong ke cho hoa don*/
    public float TongTienHDTheoTG(String ngaymin,String ngaymax) throws IOException{
         ThongKeDAO dao =new ThongKeDAO();
         return dao.TongTienHoaDonTheoNgayNhap(ngaymin, ngaymax);
    }
    public long TongTienHD() throws IOException{
         ThongKeDAO dao =new ThongKeDAO();
         return dao.TongTienHoaDon();
    }
    public void ThongKeHDSPTheoQuy(String year) throws Exception{ 
        ThongKeDAO dao = new ThongKeDAO();
        tbthongkeHDSPtheoQuy = dao.xuatThongKeHDSPtheoQuy(year);
    }
    public void ThongKeHDNVTheoQuy(String year) throws Exception{ 
        ThongKeDAO dao = new ThongKeDAO();
        tbthongkeHDNVtheoQuy = dao.xuatThongKeHDNVtheoQuy(year);
    }
    public void ThongKeTienHDTheoMaKH() throws IOException{
        ThongKeDAO dao =new ThongKeDAO();
        if(tbthongkeHDKH==null ) tbthongkeHDKH = new HashMap<String,Object>();
        tbthongkeHDKH=dao.TongTienHoaDonTheoKH();
        
    }
}

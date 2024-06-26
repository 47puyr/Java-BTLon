package BUS;

import DAO.HoaDonDAO;
import POJO.ChiTietHoaDonPOJO;
import POJO.HoaDonPOJO;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonBUS {
    private static ArrayList<HoaDonPOJO> DSHoaDon;
    public HoaDonBUS(){
        
    }
    public void List(){
        HoaDonDAO HDDAO=new HoaDonDAO();
        DSHoaDon=new ArrayList<>();
        DSHoaDon=HDDAO.List();
    }
    public void Them(HoaDonPOJO hd){
        DSHoaDon.add(hd);
        HoaDonDAO HDDAO=new HoaDonDAO();
        HDDAO.Them(hd);
    }
    public void Xoa(String MaHD){
        for(HoaDonPOJO hd:DSHoaDon){
            if(hd.getMaHD().equals(MaHD)){
                DSHoaDon.remove(hd);
                HoaDonDAO HDDAO=new HoaDonDAO();
                HDDAO.Xoa(MaHD);
                return;
            }
        }
    }
    public int set(HoaDonPOJO hd){
           for(int i=0;i<DSHoaDon.size();i++){
               if(DSHoaDon.get(i).getMaHD().equals(hd.getMaHD())){
                   DSHoaDon.set(i,hd);
                   HoaDonDAO HDDAO=new HoaDonDAO();
                   HDDAO.Sua(hd);
                   return i;
               }
           }
               return -1;
    }
    public ArrayList<HoaDonPOJO> TimMAHD(String MaHD){
        ArrayList<HoaDonPOJO> mahd=new ArrayList<>();
        if(MaHD.equals("")) return DSHoaDon;
        for(HoaDonPOJO hd: DSHoaDon){
            if(hd.getMaHD().toUpperCase().equals(MaHD.toUpperCase())){
                mahd.add(hd);
            }
        }
        return mahd;
    }
    public ArrayList<HoaDonPOJO> TimMAHDKH(String MaHD,String MaKH){
        ArrayList<HoaDonPOJO> ds=TimMAHD(MaHD);
        ArrayList<HoaDonPOJO> makh=new ArrayList<>();
        if(MaKH.equals("")) return ds;
        for(HoaDonPOJO hd: ds){
            if(hd.getMaKH().toUpperCase().equals(MaKH.toUpperCase())){
                makh.add(hd);
            }
        }
        return makh;
    }
    public ArrayList<HoaDonPOJO> TimMAHDKHNV(String MaHD,String MaKH,String MaNV){
        ArrayList<HoaDonPOJO> ds=TimMAHDKH(MaHD,MaKH);
        ArrayList<HoaDonPOJO> manv=new ArrayList<>();
        if(MaNV.equals("")) return ds;
        for(HoaDonPOJO hd: ds){
            if(hd.getMaNV().toUpperCase().equals(MaNV.toUpperCase())){
                manv.add(hd);
            }
        }
        return manv;
    }
    public ArrayList<HoaDonPOJO> TimKiem(String DAYMIN, String DAYMAX,float max,float min,String MaHD,String MaKH,String MaNV){
        String MIN=DAYMIN.equals("")?"1970-01-01":DAYMIN;
        String MAX=DAYMAX.equals("")?"9999-12-31":DAYMAX;
        ArrayList<HoaDonPOJO> ds=TimMAHDKHNV(MaHD,MaKH,MaNV);
        ArrayList<HoaDonPOJO> TimKiem = new ArrayList<>();
        for(HoaDonPOJO hd : ds)
        {
           try {
               //Ngày Lập
                String date=hd.getNgayLap();
                SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd");
                Date b=a.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(b);
                int day= calendar.get(Calendar.DATE);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                
               //Ngày đầu
               Date dau=a.parse(MIN);
               Calendar calendar1=Calendar.getInstance();
               calendar1.setTime(dau);
               int day1=calendar1.get(Calendar.DATE);
               int month1=calendar1.get(Calendar.MONTH);
               int year1=calendar1.get(Calendar.YEAR);
               
               //Ngày cuối
               Date cuoi=a.parse(MAX);
               Calendar calendar2=Calendar.getInstance();
               calendar2.setTime(cuoi);
               int day2=calendar2.get(Calendar.DATE);
               int month2=calendar2.get(Calendar.MONTH);
               int year2=calendar2.get(Calendar.YEAR);
               
                if( hd.getThanhTien() >= min && hd.getThanhTien() <= max
                       && day>=day1 && day<=day2
                       && month>=month1 && month<=month2
                       && year>=year1 && year<=year2)
                {
                    TimKiem.add(hd);
                }
            } catch (ParseException ex) {
               System.out.println("Lỗi tìm kiếm.");
            }
        }
        return TimKiem;
    }
    public String AutoMaHD(){
        int max=0;
        String s="";
        for(HoaDonPOJO hd:DSHoaDon){
            int id=Integer.parseInt(hd.getMaHD());
            if(id>max){
                max=id;
            }
        }
       
        return s+(max+1);
    }
    public ArrayList<HoaDonPOJO> getList(){
        return DSHoaDon;
    }
   
   

}

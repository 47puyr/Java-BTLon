
package BUS;

import DAO.PhieuNhapDAO;
import POJO.PhieuNhapPOJO;
import POJO.DateCustomPOJO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class PhieuNhapBUS {
    static ArrayList<PhieuNhapPOJO> listPhieuNhap;

    public static void setListPhieuNhap(ArrayList<PhieuNhapPOJO> listPhieuNhap) {
        PhieuNhapBUS.listPhieuNhap = listPhieuNhap;
    }

    public static ArrayList<PhieuNhapPOJO> getListPhieuNhap() {
        return listPhieuNhap;
    }
     public void setlistPhieuNhap(ArrayList<PhieuNhapPOJO> listPhieuNhap) {
        PhieuNhapBUS.listPhieuNhap = listPhieuNhap;
    }

    public ArrayList<PhieuNhapPOJO> getlistPhieuNhap() {
        return listPhieuNhap;
    }
    public PhieuNhapBUS() {
    }
    public void  loadDSPhieuNhap() throws Exception{
        PhieuNhapDAO data =new PhieuNhapDAO();
        if(listPhieuNhap==null) listPhieuNhap = new ArrayList<PhieuNhapPOJO>();
        listPhieuNhap=data.loadDatabase();
    }
    
    public void addPhieuNhap(PhieuNhapPOJO sach) throws Exception{
        // validate data
        PhieuNhapDAO data =new PhieuNhapDAO();
        data.addPhieuNhap(sach);
        listPhieuNhap.add(sach);
        
    }
    public void deletePhieuNhap(String idPhieuNhap) throws Exception{
        
        for(PhieuNhapPOJO sach : listPhieuNhap )
        {
            if(sach.getMaPN().equalsIgnoreCase(idPhieuNhap))
            {   
                try {
                   listPhieuNhap.remove(sach);
                    PhieuNhapDAO data =new PhieuNhapDAO();
                    data.delete(idPhieuNhap);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa PhieuNhap vao database !!!");
                } 
                return;
            }
        }
        
    }
    public PhieuNhapPOJO getPhieuNhap(String MaPN) throws IOException, Exception{
         PhieuNhapDAO data =new PhieuNhapDAO();
         PhieuNhapPOJO pn =new PhieuNhapPOJO(); pn=data.getPhieuNhap(MaPN);
         return pn;
    }
    public void updatePhieuNhap(PhieuNhapPOJO sach) throws Exception{
         for(int i = 0 ; i < listPhieuNhap.size() ; i++)
        {
            if(listPhieuNhap.get(i).getMaPN().equals(sach.getMaPN()))
            {
                try {
                    listPhieuNhap.set(i, sach);// cap nhat arraylist
                PhieuNhapDAO data =new PhieuNhapDAO();
                data.updatePhieuNhap(sach);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat PhieuNhap vao database !!!");
                   
                }
                
                return;
            }
        }
    }
    
    public ArrayList<PhieuNhapPOJO> searchPhieuNhap(String mapn,String manv,String mancc,float tienmin,float tienmax,String min,String max) throws ParseException
    {
        ArrayList<PhieuNhapPOJO> search = new ArrayList<>();
        mapn = mapn.isEmpty()?mapn = "": mapn;
        manv = manv.equalsIgnoreCase("Không")?manv = "": manv;
        mancc = mancc.equalsIgnoreCase("Không")?mancc = "": mancc; 
        DateCustomPOJO daymin=new DateCustomPOJO();
        DateCustomPOJO daymax=new DateCustomPOJO();
        setDate(daymin,min);
        setDate(daymax,max);   
        DateCustomPOJO ngaynhap;
        for(PhieuNhapPOJO sach : listPhieuNhap)
        {
            ngaynhap =new DateCustomPOJO(); setDate(ngaynhap,sach.getNgayNhap());
            if( sach.getMaPN().contains(mapn) &&
                sach.getMaNV().contains(manv) &&
                sach.getMaNCC().contains(mancc) &&
                sach.getTongTien()>= tienmin && sach.getTongTien()<= tienmax &&
                 daymin.CompareTo(ngaynhap) <= 0 && daymax.CompareTo(ngaynhap) >= 0
               ) 
            {
                
                search.add(sach);
            }
        }
        return search;
    }
    public PhieuNhapPOJO SearchMaPhieuNhap(String id){
        for(PhieuNhapPOJO ncc : listPhieuNhap){
            if(ncc.getMaPN().equalsIgnoreCase(id)) return ncc;
        }
        return null;
    }
    public int TongTien(){
        int sum=0;
        for(PhieuNhapPOJO sach : listPhieuNhap){
            sum+=sach.getTongTien();
        } 
        return sum;
    }
    public int getLengthListPhieuNhap(){
        return listPhieuNhap.size();
    }
    private void  setDate(DateCustomPOJO date,String sdate){
        String[] arr = sdate.split("-",3);
        int y,d,m;
        d=Integer.parseInt(arr[2]);
        m=Integer.parseInt(arr[1]);
        y=Integer.parseInt(arr[0]); 
        date.setDay(d);
        date.setMonth(m);
        date.setYear(y);
    }
     private java.util.Date ConvertToDate(String date){
        String[] arr = date.split("-",3);
        int y,d,m;
        d=Integer.parseInt(arr[2]);
        m=Integer.parseInt(arr[1]);
        y=Integer.parseInt(arr[0]);  
        System.out.println("day: "+arr[2]+" months: "+arr[1]+" year: "+arr[0] );
        Calendar day= Calendar.getInstance();
        day.set(y, m, d);
       // sdf.format(day);
         System.out.println(day.getTime( ));
         return day.getTime();
    }
    private Date getNgayNhap(String date) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date day =new Date();
       String  Sdate =sdf.format(day);
        Date date1  = sdf1.parse(Sdate);
        return date1;
    }
    private int getDay(String S) throws ParseException{
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date =sdf.parse(S);
        Calendar carlen =Calendar.getInstance();
        carlen.setTime(date);
        int day =carlen.get(Calendar.DAY_OF_MONTH);
        return day; 
        } catch (ParseException e) {
            
        }
        
         return 0;      
    }
     private int getMonth(String S) throws ParseException{
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date =sdf.parse(S);
        Calendar carlen =Calendar.getInstance();
        carlen.setTime(date);
        int month =carlen.get(Calendar.MONTH);
        return month; 
        } catch (ParseException e) {
            
        }
        
         return 0;      
    }
      private int getYear(String S) throws ParseException{
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date =sdf.parse(S);
        Calendar carlen =Calendar.getInstance();
        carlen.setTime(date);
        int year =carlen.get(Calendar.YEAR);
        return year; 
        } catch (ParseException e) {
            
        }
        
         return 0;      
    }
    
}
//SELECT * FROM phieunhap WHERE NgayNhap BETWEEN '2020-01-12' AND '2021-12-01'
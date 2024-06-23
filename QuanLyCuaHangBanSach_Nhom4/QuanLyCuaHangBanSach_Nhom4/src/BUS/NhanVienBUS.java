package BUS;



import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import DAO.MyConnectUnit;
import DAO.NhanVienDAO;
import POJO.*;
import java.io.IOException;
public class NhanVienBUS {

	 
	
	
	private static ArrayList<NhanVienPOJO> dsnv;
	
	
        
        
        
	
	public ArrayList<NhanVienPOJO> getNhanVien(String Condition,String OrderBy) throws Exception
	{
		NhanVienDAO conn = new NhanVienDAO();
		dsnv = conn.getNhanVien(Condition, OrderBy);
		return dsnv;
	}
	
	public ArrayList<NhanVienPOJO> getNhanVien(String Condition) throws Exception
	{
		NhanVienDAO conn = new NhanVienDAO();
		dsnv = conn.getNhanVien(Condition);
		return dsnv;
	}
	public ArrayList<NhanVienPOJO> getNhanVien() throws Exception
	{
		NhanVienDAO conn = new NhanVienDAO();
		dsnv = conn.getNhanVien();
		return dsnv;
	}
	public void loadDatabase() throws IOException, Exception{
            NhanVienDAO conn = new NhanVienDAO();
                if(dsnv==null) dsnv = new ArrayList<NhanVienPOJO>();
                dsnv = conn.getNhanVien();
        }
	
	
	
	public NhanVienPOJO getMaNV(String mnv) throws Exception
	{
		
		ArrayList<NhanVienPOJO> nv = this.getNhanVien("MaNV ='" + mnv + "'" );
		if(dsnv.size()>0)
		{
			return dsnv.toArray(new NhanVienPOJO[dsnv.size()]) [0];
			
		}
		return null;
		
	}
	public void Insert(NhanVienPOJO nv) throws Exception
	{
		NhanVienDAO conn = new NhanVienDAO();
		conn.Insert(nv);
		dsnv.add(nv);
	}
	public void Insert(HashSet<NhanVienPOJO> nv) throws Exception
	{
		for(NhanVienPOJO n : nv)
		{
			this.Insert(n);
		}
	}

    public static ArrayList<NhanVienPOJO> getDsnv() {
        return dsnv;
    }

    public static void setDsnv(ArrayList<NhanVienPOJO> dsnv) {
        NhanVienBUS.dsnv = dsnv;
    }
	
	public void Delete(NhanVienPOJO nv) throws Exception
	{
		String Condition = "`MaNV` ='" + nv.getMaNV().toString() + "'";
		NhanVienDAO conn = new NhanVienDAO();
		conn.Delete(Condition);
		dsnv.remove(nv);
	}
	public void Update(NhanVienPOJO nv,int i) throws Exception
	{
		NhanVienDAO conn = new NhanVienDAO();
		conn.Update(nv);
		dsnv.set(i, nv);
	}
	public NhanVienPOJO timkiem_MaNV(String id) throws Exception
	{
		NhanVienPOJO n=new NhanVienPOJO();
		for(NhanVienPOJO nv: dsnv)
		{
			if(nv.getMaNV().compareTo(id)==0)
			{
				n=nv;
			}
		}
		return n;
	}
	
	public ArrayList<NhanVienPOJO> timkiem_Ho(String ho) throws Exception
	{
		ArrayList<NhanVienPOJO> dsnv_tk = new ArrayList<NhanVienPOJO>();
		for(NhanVienPOJO nv: dsnv)
		{
			if(nv.getHo().indexOf(ho)!=-1)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}

	public ArrayList<NhanVienPOJO> timkiem_Ten(String ten) throws Exception
	{
		ArrayList<NhanVienPOJO> dsnv_tk = new ArrayList<NhanVienPOJO>();
		for(NhanVienPOJO nv: dsnv)
		{
			if(nv.getTen().equalsIgnoreCase(ten))
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}

	public ArrayList<NhanVienPOJO> timkiem_SDT(String SDT) throws Exception
	{
		ArrayList<NhanVienPOJO> dsnv_tk = new ArrayList<NhanVienPOJO>();
		for(NhanVienPOJO nv: dsnv)
		{
			if(nv.getSDT().indexOf(SDT)!= -1)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}
	
	
	
	public ArrayList<NhanVienPOJO> timkiem_Email(String Email) throws Exception
	{
		ArrayList<NhanVienPOJO> dsnv_tk = new ArrayList<NhanVienPOJO>();
		for(NhanVienPOJO nv: dsnv)
		{
			if(nv.getEmail().indexOf(Email)!=-1)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}
	public ArrayList<NhanVienPOJO> timkiem_Luong(double luong) throws Exception
	{
		ArrayList<NhanVienPOJO> dsnv_tk = new ArrayList<NhanVienPOJO>();
		for(NhanVienPOJO nv: dsnv)
		{
			if(nv.getLuong() == luong)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}
        
        public ArrayList<NhanVienPOJO> timkiem_Nam() throws Exception
	{
		ArrayList<NhanVienPOJO> dsnv_tk = new ArrayList<NhanVienPOJO>();
		for(NhanVienPOJO nv: dsnv)
		{
			if(nv.isPhai() == 1)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}
        public ArrayList<NhanVienPOJO> timkiem_Nu() throws Exception
	{
		ArrayList<NhanVienPOJO> dsnv_tk = new ArrayList<NhanVienPOJO>();
		for(NhanVienPOJO nv: dsnv)
		{
			if(nv.isPhai() == 0)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}
        
	public ArrayList<NhanVienPOJO> timkiem_ChucVu(String cv) throws Exception
	{
		ArrayList<NhanVienPOJO> dsnv_tk = new ArrayList<NhanVienPOJO>();
		for(NhanVienPOJO nv: dsnv)
		{
			if(nv.getChucVu().indexOf(cv)!=-1)
			{
				dsnv_tk.add(nv);
			}
		}
		return dsnv_tk;
	}
        public ArrayList<NhanVienPOJO> timkiem_Ngaysinh(String day) throws Exception
	{
		ArrayList<NhanVienPOJO> dsnv_tk = new ArrayList<NhanVienPOJO>();
                
                            
                            String a[] = day.split("-");
                          
                            int dd =  Integer.parseInt(a[0]);
                            int mm =  Integer.parseInt(a[1]);
                            int yy =  Integer.parseInt(a[2]);
                                          
                            for(NhanVienPOJO nv : dsnv)
                            {
                               if(nv.getngay()==dd && nv.getthang() == mm && nv.getnam() == yy)
                               {
                                   dsnv_tk.add(nv);
                               }
                             
                            }
		
		return dsnv_tk;
	}
        
	
        public ArrayList<NhanVienPOJO> timkiemNC_Luong(String a,String b) throws Exception
	{
		ArrayList<NhanVienPOJO> dsnv_tk = new ArrayList<NhanVienPOJO>();
                int begin = Integer.parseInt(a);
                int end = Integer.parseInt(b);	
		for(NhanVienPOJO nv: dsnv)
		{
                  if(nv.getLuong() >= begin && nv.getLuong() <= end)
                    {
                        dsnv_tk.add(nv);
                    }
		}
		return dsnv_tk;
	}
        public ArrayList<NhanVienPOJO> timkiemNC_Ngaysinh(String a,String b) throws Exception
	{
		ArrayList<NhanVienPOJO> dsnv_tk = new ArrayList<NhanVienPOJO>();
                
                            
                            String c[] = a.split("-");
                            String d[] = b.split("-");
                            int Dbegin =  Integer.parseInt(c[0]);
                            int Mbegin =  Integer.parseInt(c[1]);
                            int Ybegin =  Integer.parseInt(c[2]);
                            
                            int Dend = Integer.parseInt(d[0]);
                            int Mend = Integer.parseInt(d[1]);
                            int Yend = Integer.parseInt(d[2]);
                            
                          
                            
                            for(NhanVienPOJO nv : dsnv)
                            {
                               
                             if(Ybegin < Yend)
                             {
                                if( nv.getnam() >= Ybegin && nv.getnam() <= Yend )
                                {            
                                    
                                    dsnv_tk.add(nv);
                                }
                             }
                             
                             if(Ybegin == Yend && Yend == nv.getnam())
                             {
                                 if(Mbegin < Mend)
                                {
                                    if( nv.getthang() >= Mbegin && nv.getthang() <= Mend)
                                    {                                 
                                         dsnv_tk.add(nv);
                                    }
                                 }else if(Mbegin == Mend)
                                 {
                                    if( nv.getngay() >= Dbegin && nv.getngay() <= Dend  && nv.getthang() == Mend)
                                    {                                 
                                         dsnv_tk.add(nv);
                                    }
                                 }
                             }
                            }
		
		return dsnv_tk;
	}
	
	  public ArrayList<NhanVienPOJO> list() throws Exception
            {
                if(this.dsnv == null)
                {
                    this.getNhanVien();
                    return this.dsnv;
                }
                else return this.dsnv;
            }
	
	
	
	
	
	
	
}

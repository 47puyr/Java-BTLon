package DAO;

import POJO.NhanVienPOJO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import DAO.MyConnectUnit;
import DAO.NhanVienDAO;

public class NhanVienDAO {	
	private MyConnectUnit conn;	
	public NhanVienDAO() throws Exception
	{
		this.conn = new MyConnectUnit("localhost","sa","12","bookstore");
	}	
	public ArrayList<NhanVienPOJO> getNhanVien(String Condition,String OrderBy) throws Exception
	{
		
		ResultSet rs = conn.Select("nhanvien", Condition, OrderBy);
		
		ArrayList<NhanVienPOJO> dsnv = new ArrayList<NhanVienPOJO>();
		
		while(rs.next())
		{
			NhanVienPOJO nv = new NhanVienPOJO();
			nv.setMaNV(rs.getString("MaNV"));
			nv.setHo(rs.getString("Ho"));
			nv.setTen(rs.getString("Ten"));
			nv.setEmail(rs.getString("Email"));
			nv.setSDT(rs.getString("SDT"));
			nv.setChucVu(rs.getString("ChucVu"));
			nv.setLuong(rs.getDouble("Luong"));
			if(rs.getInt("Phai") ==1)
				nv.setPhai(true);
			else nv.setPhai(false);
                        nv.setngaysinh(rs.getString("ngaysinh"));
			dsnv.add(nv);
		}
		return dsnv;
	}                       	
	public ArrayList<NhanVienPOJO> getNhanVien(String Condition) throws Exception
	{		
		return getNhanVien(Condition,null); 		
	}
	
	public ArrayList<NhanVienPOJO> getNhanVien() throws Exception
	{	
        	return getNhanVien(null,null); 		
	}
	
	
	public void Insert(NhanVienPOJO nv) throws Exception
	{
		HashMap<String,Object> map = new HashMap<String,Object>(); 	
		map.put("MaNV",nv.getMaNV());
		map.put("Ten", nv.getTen());	
		map.put("Ho",nv.getHo());
		map.put("Email", nv.getEmail());
		map.put("SDT",nv.getSDT());
		map.put("Luong", nv.getLuong());
		map.put("ChucVu",nv.getChucVu());
		map.put("Phai", nv.isPhai());
                map.put("ngaysinh", nv.getngaysinh());
		this.conn.Insert("nhanvien", map);
	}
	
	public void Delete(String Condition) throws Exception
	{
		conn.Delete("nhanvien", Condition);
	}
	public void Update(NhanVienPOJO nv) throws Exception
	{
		HashMap<String,Object> map = new HashMap<String,Object>(); 	
		map.put("MaNV",nv.getMaNV());
		map.put("Ten", nv.getTen());
		map.put("Ho",nv.getHo());
		map.put("Email", nv.getEmail());
		map.put("SDT",nv.getSDT());
		map.put("Luong", nv.getLuong());
		map.put("ChucVu",nv.getChucVu());
		map.put("Phai", nv.isPhai());
                map.put("ngaysinh", nv.getngaysinh());
		this.conn.Update("nhanvien", map, "MaNV = '" + nv.getMaNV() + "'");		
	}			
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.TaiKhoanPOJO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 *
 * @author Vu
 */
public class TaiKhoanDAO {
    private MyConnectUnit conn;
	
	
	public TaiKhoanDAO() throws Exception
	{
		this.conn = new MyConnectUnit("localhost","sa","12","bookstore");
	}
	
	
	
	public ArrayList<TaiKhoanPOJO> getTaiKhoan(String Condition,String OrderBy) throws Exception
	{
		
		ResultSet rs = conn.Select("taikhoan", Condition, OrderBy);
		
		ArrayList<TaiKhoanPOJO> dstk = new ArrayList<TaiKhoanPOJO>();
		
		while(rs.next())
		{
			TaiKhoanPOJO tk = new TaiKhoanPOJO();
			tk.setMaTK(rs.getString("MaTK"));
                        tk.setTenTK(rs.getString("TenTaiKhoan"));
                        tk.setMk(rs.getString("MatKhau"));
                        tk.setQuyen(rs.getString("Quyen"));
			if(rs.getInt("TrangThai") ==1)
				tk.setStatus(true);
			else tk.setStatus(false);
                        
			dstk.add(tk);
		}
		return dstk;
	}
	
	public ArrayList<TaiKhoanPOJO> getTaiKhoan(String Condition) throws Exception
	{
		
		return getTaiKhoan(Condition,null); 
		
	}
	
	public ArrayList<TaiKhoanPOJO> getTaiKhoan() throws Exception
	{
		
		return getTaiKhoan(null,null); 
		
	}
	
	
	public void Insert(TaiKhoanPOJO tk) throws Exception
	{
		HashMap<String,Object> map = new HashMap<String,Object>(); 
		
		map.put("MaTK",tk.getMaTK());
		map.put("TenTaiKhoan", tk.getTenTK());
		
		map.put("MatKhau",tk.getMk());
		map.put("Quyen", tk.getQuyen());
                if(tk.isStatus()==true)
		map.put("TrangThai",1);
                else map.put("TrangThai", 0);
		this.conn.Insert("taikhoan", map);
	}
	
	public void Delete(String Condition) throws Exception
	{
		conn.Delete("taikhoan", Condition);
	}
	public void Update(TaiKhoanPOJO tk) throws Exception
	{
		HashMap<String,Object> map = new HashMap<String,Object>(); 
		
		
		map.put("TenTaiKhoan", tk.getTenTK());
		map.put("MatKhau",tk.getMk());
		map.put("Quyen", tk.getQuyen());
		if(tk.isStatus()==true)
		map.put("TrangThai",1);
                else map.put("TrangThai", 0);
		this.conn.Update("taikhoan", map, "MaTK = '" +  tk.getMaTK() + "'");		
	}
}



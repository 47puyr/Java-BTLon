/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TaiKhoanDAO;
import POJO.TaiKhoanPOJO;
import java.util.ArrayList;

/**
 *
 * @author Vu
 */
public class TaiKhoanBUS {
    
    private static ArrayList<TaiKhoanPOJO> dstk =null;
    
    public ArrayList<TaiKhoanPOJO> getall_tk(String Condition,String OrderBy) throws Exception
    {
        TaiKhoanDAO conn = new TaiKhoanDAO();
        this.dstk = conn.getTaiKhoan(Condition, OrderBy);
        return this.dstk;
    }
    public ArrayList<TaiKhoanPOJO> getall_tk(String Condition) throws Exception
    {
        TaiKhoanDAO conn = new TaiKhoanDAO();
        this.dstk = conn.getTaiKhoan(Condition);
        return this.dstk;
    }
    public ArrayList<TaiKhoanPOJO> getall_tk() throws Exception
    {
        TaiKhoanDAO conn = new TaiKhoanDAO();
        this.dstk = conn.getTaiKhoan();
        return this.dstk;
    }
    
    public void Insert(TaiKhoanPOJO tk) throws Exception
    {
        
        TaiKhoanDAO conn = new TaiKhoanDAO();
        conn.Insert(tk);
        this.dstk.add(tk);
        
    }
    public void Update(TaiKhoanPOJO tk,int i) throws Exception
    {
        TaiKhoanDAO conn = new TaiKhoanDAO();
        conn.Update(tk);
        this.dstk.set(i, tk);
    }
    
    public void Delete(TaiKhoanPOJO tk) throws Exception
    {
        String Condition = "`MaTK` ='" + tk.getMaTK().toString() + "'";
        TaiKhoanDAO conn = new TaiKhoanDAO();
        conn.Delete(Condition);
        this.dstk.remove(tk);
    }
    
    public ArrayList<TaiKhoanPOJO> list() throws Exception
    {
        if(this.dstk == null)
        {
            this.getall_tk();
            return this.dstk;
        }
        else return this.dstk;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.DangNhapDAO;
import POJO.TaiKhoanPOJO;
import java.util.ArrayList;

/**
 *
 * @author tungk
 */
public class DangNhapBUS {
    public static ArrayList<TaiKhoanPOJO> taikhoan;
    public static TaiKhoanPOJO taiKhoanDaDangNhap;
    public DangNhapBUS(){
        //nothing happens
    }
    
    public void docTK(){
        DangNhapDAO dao = new DangNhapDAO();
        if(taikhoan == null){
            taikhoan = new ArrayList();
        }
        taikhoan = dao.docTK();
    }
    
    public boolean isExisted(String username, String password){
        boolean flag = false;
        for(TaiKhoanPOJO tk : taikhoan){
            if( (tk.getTenTK().equals( username ) && tk.getMk().equals( password )) ){
                flag = true;
                taiKhoanDaDangNhap = tk;
            }
        }
        return flag;
    }
    public boolean isBlock(String username, String password){
        for(TaiKhoanPOJO tk : taikhoan){
            if( (tk.getTenTK().equals( username ) && tk.getMk().equals( password )) ){
               return tk.isStatus();
            }
        }
        return false;
    }
    public TaiKhoanPOJO findUserbyUsername(String id){
        for(TaiKhoanPOJO tk:taikhoan){
            if(tk.getTenTK().compareTo(id)==0) return tk;
        }
        return null;
    }
}

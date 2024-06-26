/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.KhachHangPOJO;
import POJO.TaiKhoanPOJO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tungk
 */
public class DangNhapDAO {
    TungSqlConnect conn = new TungSqlConnect("localhost", "sa", "12", "bookstore");
    
    public DangNhapDAO(){
        try{
            conn.testDriver();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi kết nối database taikhoan");
        }
    }
    
    public ArrayList docTK(){
        ArrayList<TaiKhoanPOJO> taikhoan = new ArrayList<>();
        try {
            String query = "select * from taikhoan";
            ResultSet rs = conn.executeQuery(query);
            
            while(rs.next()){
                TaiKhoanPOJO tk = new TaiKhoanPOJO();
                tk.setMaTK(rs.getString("MaTK"));
                tk.setTenTK(rs.getString("TenTaiKhoan"));
                tk.setMk(rs.getString("MatKhau"));
                tk.setQuyen(rs.getString("Quyen"));
                tk.setStatus(rs.getInt("TrangThai")==1?true:false);                
                taikhoan.add(tk);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Không thể đọc dữ liệu từ database");
        }
        return taikhoan;
    }
}

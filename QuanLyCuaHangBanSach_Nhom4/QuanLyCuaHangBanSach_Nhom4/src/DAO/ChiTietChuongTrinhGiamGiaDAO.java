/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ChiTietChuongTrinhGiamGiaPOJO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tungk
 */
public class ChiTietChuongTrinhGiamGiaDAO {
    private TungSqlConnect conn = new TungSqlConnect("localhost", "sa", "12", "bookstore");
    
    public ChiTietChuongTrinhGiamGiaDAO(){
        try{
            conn.testDriver();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi kết nối database");
        }
    }
    
    public ArrayList<ChiTietChuongTrinhGiamGiaPOJO> docChiTiet(String MaGG){
        ArrayList<ChiTietChuongTrinhGiamGiaPOJO> dsChiTiet = new ArrayList<>();
        try {
            String query = "select * from chitietchuongtrinhgiamgia where MaGG = '" + MaGG + "'";
            System.out.println(query);
            ResultSet rs = conn.executeQuery(query);
            while(rs.next()){
                ChiTietChuongTrinhGiamGiaPOJO ct = new ChiTietChuongTrinhGiamGiaPOJO();
                System.out.println("ok");
                int i = 1;
                System.out.println(rs.getString(i));
                ct.setMaGG(rs.getString(i++));
                System.out.println(rs.getString(i));
                ct.setPercent(rs.getDouble(i++));
                System.out.println(rs.getString(i));
                ct.setMaSach(rs.getString(i++));
                dsChiTiet.add(ct);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Không thể đọc dữ liệu từ database");
        }
        return dsChiTiet;
    }
    
    public void them(ChiTietChuongTrinhGiamGiaPOJO cTrinh){
        String sql = String.format("insert into chitietchuongtrinhgiamgia values('%s', %f, '%s')",
                cTrinh.getMaGG(), cTrinh.getPercent(), cTrinh.getMaSach());
        System.out.println(sql);
        try{
            conn.executeUpdate(sql);
        }catch (Exception ex){
            System.out.println("DAO.ChuongTrinhGiamGiaDAO.them()");
        }
    }
    
    public void xoa(ChiTietChuongTrinhGiamGiaPOJO cTrinh){
        String query = String.format("delete from chitietchuongtrinhgiamgia where MaGG = '%s' and MaSach = '%s'", cTrinh.getMaGG(), cTrinh.getMaSach());
        System.out.println(query);
        try {
            conn.executeUpdate(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể xóa dữ liệu");
        }
    }
}

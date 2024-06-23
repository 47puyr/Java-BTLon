/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChiTietChuongTrinhGiamGiaDAO;
import POJO.ChiTietChuongTrinhGiamGiaPOJO;
import java.util.ArrayList;

/**
 *
 * @author tungk
 */
public class ChiTietChuongTrinhGiamGiaBUS {
    public static ArrayList<ChiTietChuongTrinhGiamGiaPOJO> dsChiTiet;

    public ChiTietChuongTrinhGiamGiaBUS() {
    }
    
    
    
    public void docDSCTGG(String MaGG){
        if(dsChiTiet == null)
            dsChiTiet = new ArrayList<>();
        ChiTietChuongTrinhGiamGiaDAO data = new ChiTietChuongTrinhGiamGiaDAO();
        dsChiTiet = data.docChiTiet(MaGG);
    }
    
    public void them(ChiTietChuongTrinhGiamGiaPOJO cTrinh){
        ChiTietChuongTrinhGiamGiaDAO data = new ChiTietChuongTrinhGiamGiaDAO();
        data.them(cTrinh);
    }
    
    public void xoa(ChiTietChuongTrinhGiamGiaPOJO cTrinh){
        ChiTietChuongTrinhGiamGiaDAO data = new ChiTietChuongTrinhGiamGiaDAO();
        data.xoa(cTrinh);
    }
}

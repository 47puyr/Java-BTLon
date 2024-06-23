/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ChuongTrinhGiamGiaDAO;
import POJO.ChuongTrinhGiamGiaPOJO;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author tungk
 */
public class ChuongTrinhGiamGiaBUS {
    public static ArrayList<ChuongTrinhGiamGiaPOJO> dsChuongTrinh;

    public ChuongTrinhGiamGiaBUS() {
    }
    
    public void docDSChuongTrinh(){
        ChuongTrinhGiamGiaDAO data = new ChuongTrinhGiamGiaDAO();
        if (dsChuongTrinh == null)
            dsChuongTrinh = data.docDSCT();
    }
    
    public void them(ChuongTrinhGiamGiaPOJO cTrinh){
        System.out.println("BUS.ChuongTrinhGiamGiaBUS.them()");
        boolean isOk = true;
        for(ChuongTrinhGiamGiaPOJO ct : dsChuongTrinh){
            if(ct.getId().equals(cTrinh.getId())){
                isOk = false;
                JOptionPane.showMessageDialog(null, "Mã KH bị trùng, xin hãy nhập lại");
                break;
            }
        }
        if(isOk){
            ChuongTrinhGiamGiaDAO data = new ChuongTrinhGiamGiaDAO();
            data.them(cTrinh);
            dsChuongTrinh.add(cTrinh);
        }
    }
    
    public void sua(ChuongTrinhGiamGiaPOJO cTrinh){
        ChuongTrinhGiamGiaDAO data = new ChuongTrinhGiamGiaDAO();
        data.sua(cTrinh);
        dsChuongTrinh = data.docDSCT();
    }
    
    public void xoa(ChuongTrinhGiamGiaPOJO cTrinh){
        ChuongTrinhGiamGiaDAO data = new ChuongTrinhGiamGiaDAO();
        data.xoa(cTrinh);
        int i = 0;
        for(ChuongTrinhGiamGiaPOJO ct : dsChuongTrinh){
            if(ct.getId().equals(cTrinh.getId())){
                dsChuongTrinh.remove(i);
                break;
            }
            i++;
        }
    }
    public ArrayList<ChuongTrinhGiamGiaPOJO> timkiem (Date ngayBD, Date ngayKT){
        ArrayList<ChuongTrinhGiamGiaPOJO> dsTimThay = new ArrayList<>();
        
        for(ChuongTrinhGiamGiaPOJO ct : dsChuongTrinh){
            Date ctBD = ct.getNgayBD();
            Date ctKT = ct.getNgayKT();
            
            if(ngayBD.compareTo(ctBD) <= 0 && ngayKT.compareTo(ctKT) >= 0){
                dsTimThay.add(ct);
                System.out.println("found");
            }
        }
        return dsTimThay;
    }
}

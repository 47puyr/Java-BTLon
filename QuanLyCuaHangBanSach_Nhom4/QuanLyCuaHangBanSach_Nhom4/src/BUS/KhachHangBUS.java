/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.KhachHangDAO;
import POJO.KhachHangPOJO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tungk
 */
public class KhachHangBUS {
    public static ArrayList<KhachHangPOJO> dskh;
    public KhachHangBUS(){}
    
    public void docDSKH(){
        KhachHangDAO data = new KhachHangDAO();
        if(dskh == null) dskh = new ArrayList<>();
        dskh = data.docDSKH();
    }
    
    public void them(KhachHangPOJO kh){
        boolean isOk = true;
        for(KhachHangPOJO KH : dskh){
            if(KH.getId().equals(kh.getId())){
                isOk = false;
                JOptionPane.showMessageDialog(null, "Mã KH bị trùng, xin hãy nhập lại");
                break;
            }
        }
        if(isOk){
            KhachHangDAO data = new KhachHangDAO();
            data.them(kh);
            dskh.add(kh);
        }
    }
    
    public void xoa(KhachHangPOJO kh){
        KhachHangDAO data = new KhachHangDAO();
        data.xoa(kh);
        for(KhachHangPOJO KH : dskh){
            if(KH.equals(kh)){
                dskh.remove(KH);
                break;
            }
        }
    }
    
    public void sua(KhachHangPOJO kh){
        KhachHangDAO data = new KhachHangDAO();
        data.sua(kh);
        dskh = data.docDSKH();
    }
    
    public ArrayList<KhachHangPOJO> timKiemId(String id){
        ArrayList result = new ArrayList();
        for(KhachHangPOJO kh : dskh){
            if(kh.getId().equals(id)){
                result.add(kh);
                break;
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangPOJO> timKiemHo(String id){
        ArrayList<KhachHangPOJO> result = new ArrayList<>();
        for(KhachHangPOJO kh : dskh){
            if(kh.getHo().indexOf(id) > -1){
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangPOJO> timKiemTen(String id){
        ArrayList result = new ArrayList();
        for(KhachHangPOJO kh : dskh){
            if(kh.getTen().equals(id)){
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangPOJO> timKiemPhai(boolean g){
        ArrayList result = new ArrayList();
        for(KhachHangPOJO kh : dskh){
            if(kh.isPhai() == g){
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangPOJO> timKiemTCT(boolean g, int tct){
        ArrayList result = new ArrayList();
        for(KhachHangPOJO kh : dskh){
            if(g == true && kh.getTct() > tct){
                result.add(kh);
            } else if(g == false && kh.getTct() < tct){
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangPOJO> timKiemSDT(String sdt){
        ArrayList result = new ArrayList();
        for(KhachHangPOJO kh : dskh){
            if(kh.getSdt().equals(sdt)){
                result.add(kh);
            }
        }
        return result;
    }
    
    public ArrayList<KhachHangPOJO> timKiemEmail(String email){
        ArrayList result = new ArrayList();
        for(KhachHangPOJO kh : dskh){
            if(kh.getEmail().equals(email)){
                result.add(kh);
            }
        }
        return result;
    }
}

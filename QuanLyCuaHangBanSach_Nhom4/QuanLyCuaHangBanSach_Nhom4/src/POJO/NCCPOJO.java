/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Admin
 */
public class NCCPOJO {
    String MaNCC,TenNCC,DiaChi;

    public NCCPOJO() {
    }

    public NCCPOJO(String MaNCC, String TenNCC, String DiaChi) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChi = DiaChi;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
}

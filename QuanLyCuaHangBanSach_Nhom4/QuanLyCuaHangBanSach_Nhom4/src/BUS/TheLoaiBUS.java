/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TheLoaiDAO;
import POJO.TheLoaiPOJO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TheLoaiBUS {

    static ArrayList<TheLoaiPOJO> listTG;

    public static void setListTheLoai(ArrayList<TheLoaiPOJO> listTheLoai) {
        TheLoaiBUS.listTG = listTheLoai;
    }

    public  ArrayList<TheLoaiPOJO> getListTheLoai() {
        return listTG;
    }
    
    public TheLoaiBUS() {
    }
    public void  loadDSTheLoai() throws Exception{
        TheLoaiDAO data =new TheLoaiDAO();
        if(listTG==null) listTG = new ArrayList<TheLoaiPOJO>();
        listTG=data.loadDatabase();
    }
    public void addTheLoai(TheLoaiPOJO tl) throws Exception{
        // validate data
        TheLoaiDAO data =new TheLoaiDAO();
        data.addNXB(tl);
        listTG.add(tl);
        
    }
    public void deleteNXB(String idNXB) throws Exception{
        
        for(TheLoaiPOJO tl : listTG )
        {
            if(tl.getMaTL().equalsIgnoreCase(idNXB))
            {   
                try {
                   listTG.remove(tl);
                    TheLoaiDAO data =new TheLoaiDAO();
                    data.delete(idNXB);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa Tac Gia vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void updateTheLoai(TheLoaiPOJO tl) throws Exception{
         for(int i = 0 ; i < listTG.size() ; i++)
        {
            if(listTG.get(i).getMaTL().equals(tl.getMaTL()))
            {
                try {
                    listTG.set(i, tl);
                TheLoaiDAO data =new TheLoaiDAO();
                data.updateTheLoai(tl);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat Tac Gia vao database !!!");
                }
                
                return;
            }
        }
    }
    public TheLoaiPOJO searchMaTL (String matl)
    {
        for(TheLoaiPOJO tl : listTG)
        {
            if( tl.getMaTL().equals(matl))
            {
                return tl;
            }
        }
        return null;
    }
    public ArrayList<TheLoaiPOJO> searchTheLoai(String matl,String tentl,String diachi,String sdt)
    {
        ArrayList<TheLoaiPOJO> search = new ArrayList<>();
        matl = matl.isEmpty()?matl = "": matl;
        tentl = tentl.isEmpty()?tentl = "": tentl;
        diachi = diachi.isEmpty()?diachi = "": diachi;
       
        
        for(TheLoaiPOJO tl : listTG)
        {
            if( tl.getMaTL().contains(matl) && 
                tl.getTenTL().contains(tentl) //&&
               // tl.getDiaChi().contains(matl) &&
                //tl.getSDT().contains(matl) 
               )
            {
                search.add(tl);
            }
        }
        return search;
    }
    
}


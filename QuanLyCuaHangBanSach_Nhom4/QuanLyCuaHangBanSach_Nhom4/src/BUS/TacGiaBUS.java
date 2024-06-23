/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.TacGiaDAO;
import POJO.TacGiaPOJO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TacGiaBUS {

    static ArrayList<TacGiaPOJO> listTG;

    public static void setListTacGia(ArrayList<TacGiaPOJO> listTacGia) {
        TacGiaBUS.listTG = listTacGia;
    }

    public  ArrayList<TacGiaPOJO> getListTacGia() {
        return listTG;
    }
    
    public TacGiaBUS() {
    }
    public void  loadDSTacGia() throws Exception{
        TacGiaDAO data =new TacGiaDAO();
        if(listTG==null) listTG = new ArrayList<TacGiaPOJO>();
        listTG=data.loadDatabase();
    }
    public void addTacGia(TacGiaPOJO tg) throws Exception{
        // validate data
        TacGiaDAO data =new TacGiaDAO();
        data.addTacGia(tg);
        listTG.add(tg);
        
    }
    public void deleteTG(String idTG) throws Exception{
        
        for(TacGiaPOJO tg : listTG )
        {
            if(tg.getMaTG().equalsIgnoreCase(idTG))
            {   
                try {
                   listTG.remove(tg);
                    TacGiaDAO data =new TacGiaDAO();
                    data.delete(idTG);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa Tac Gia vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void updateTacGia(TacGiaPOJO tg) throws Exception{
         for(int i = 0 ; i < listTG.size() ; i++)
        {
            if(listTG.get(i).getMaTG().equals(tg.getMaTG()))
            {
                try {
                    listTG.set(i, tg);
                TacGiaDAO data =new TacGiaDAO();
                data.updateTacGia(tg);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat Tac Gia vao database !!!");
                }
                
                return;
            }
        }
    }
    public TacGiaPOJO searchMaTG (String matg)
    {
        for(TacGiaPOJO tg : listTG)
        {
            if( tg.getMaTG().equals(matg))
            {
                return tg;
            }
        }
        return null;
    }
    public ArrayList<TacGiaPOJO> searchTacGia(String matg,String tentg,String diachi,String sdt)
    {
        ArrayList<TacGiaPOJO> search = new ArrayList<>();
        matg = matg.isEmpty()?matg = "": matg;
        tentg = tentg.isEmpty()?tentg = "": tentg;
        diachi = diachi.isEmpty()?diachi = "": diachi;
       
        
        for(TacGiaPOJO tg : listTG)
        {
            if( tg.getMaTG().contains(matg) && 
                tg.getTenTG().contains(tentg) //&&
               // tg.getDiaChi().contains(matg) &&
                //tg.getSDT().contains(matl) 
               )
            {
                search.add(tg);
            }
        }
        return search;
    }
    
}


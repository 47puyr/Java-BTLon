
package BUS;

import DAO.NCCDAO;
import POJO.NCCPOJO;
import java.util.ArrayList;


public class NCCBUS {
    static ArrayList<NCCPOJO> listNCC;

    public static void setListNCC(ArrayList<NCCPOJO> listNCC) {
        NCCBUS.listNCC = listNCC;
    }

    public static ArrayList<NCCPOJO> getListNCC() {
        return listNCC;
    }
    
    public NCCBUS() {
    }
    public void  loadDSNCC() throws Exception{
        NCCDAO data =new NCCDAO();
        if(listNCC==null) listNCC = new ArrayList<NCCPOJO>();
        listNCC=data.loadDatabase();
    }
    public void addNCC(NCCPOJO ncc) throws Exception{
        // validate data
        NCCDAO data =new NCCDAO();
        data.addNCC(ncc);
        listNCC.add(ncc);
        
    }
    public void deleteNCC(String idNCC) throws Exception{
        
        for(NCCPOJO ncc : listNCC )
        {
            if(ncc.getMaNCC().equalsIgnoreCase(idNCC))
            {   
                try {
                   listNCC.remove(ncc);
                    NCCDAO data =new NCCDAO();
                    data.delete(idNCC);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa NCC vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void updateNCC(NCCPOJO ncc) throws Exception{
         for(int i = 0 ; i < listNCC.size() ; i++)
        {
            if(listNCC.get(i).getMaNCC().equals(ncc.getMaNCC()))
            {
                try {
                    listNCC.set(i, ncc);
                NCCDAO data =new NCCDAO();
                data.updateNCC(ncc);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat NCC vao database !!!");
                   
                }
                
                return;
            }
        }
    }
    public NCCPOJO SearchMaNCC(String id){
        for(NCCPOJO ncc : listNCC){
            if(ncc.getMaNCC().equalsIgnoreCase(id)) return ncc;
        }
        return null;
    }
   
    public ArrayList<NCCPOJO> list() throws Exception
    {
        if (this.listNCC == null)
        {
            this.loadDSNCC();
        }
        return listNCC;
    }

    public NCCPOJO timkiem_MaNCC(String id)
    {
        NCCPOJO n = new NCCPOJO();
        for(NCCPOJO ncc : listNCC)
        {
            if(ncc.getMaNCC().compareTo(id) == 0)
            {
                n = ncc;
            }
        }
        return n;
    }
    public ArrayList<NCCPOJO> timkiem_TenNCC(String ten)
    {
        ArrayList<NCCPOJO> n = new ArrayList<NCCPOJO>();
        for(NCCPOJO ncc : listNCC)
        {
            if(ncc.getTenNCC().indexOf(ten) != -1)
            {
                n.add(ncc);
            }
        }
        return n;
    }
    public ArrayList<NCCPOJO> timkiem_DiaChi(String diachi)
    {
        ArrayList<NCCPOJO> n = new ArrayList<NCCPOJO>();
        for(NCCPOJO ncc : listNCC)
        {
            if(ncc.getDiaChi().indexOf(diachi) != -1)
            {
                n.add(ncc);
            }
        }
        return n;
    }
   
    
}


package BUS;

import DAO.NXBDAO;
import POJO.NXBPOJO;
import java.util.ArrayList;


public class NXBBUS {
    static ArrayList<NXBPOJO> listNXB;

    public void setListNXB(ArrayList<NXBPOJO> listNXB) {
        NXBBUS.listNXB = listNXB;
    }


     public  ArrayList<NXBPOJO> getlistNXB() {
        return listNXB;
    }
    public NXBBUS() {
    }
    public void  loadDSNXB() throws Exception{
        NXBDAO data =new NXBDAO();
        if(listNXB==null) listNXB = new ArrayList<NXBPOJO>();
        listNXB=data.loadDatabase();
    }
    public void addNXB(NXBPOJO nxb) throws Exception{
        // validate data
        NXBDAO data =new NXBDAO();
        data.addNXB(nxb);
        listNXB.add(nxb);
        
    }
    public void deleteNXB(String idNXB) throws Exception{
        
        for(NXBPOJO nxb : listNXB )
        {
            if(nxb.getMaNXB().equalsIgnoreCase(idNXB))
            {   
                try {
                   listNXB.remove(nxb);
                    NXBDAO data =new NXBDAO();
                    data.delete(idNXB);  
                } catch (Exception e) {
                    System.out.println("Khong the Xoa NXB vao database !!!");
                } 
                return;
            }
        }
        
    }
    public void updateNXB(NXBPOJO nxb) throws Exception{
         for(int i = 0 ; i < listNXB.size() ; i++)
        {
            if(listNXB.get(i).getMaNXB().equals(nxb.getMaNXB()))
            {
                try {
                    listNXB.set(i, nxb);
                NXBDAO data =new NXBDAO();
                data.updateNXB(nxb);
                } catch (Exception e) {
                    System.out.println("Khong the Cap nhat NXB vao database !!!");
                }
                
                return;
            }
        }
    }
    public NXBPOJO searchMaNXB (String manxb)
    {
        for(NXBPOJO nxb : listNXB)
        {
            if( nxb.getMaNXB().equals(manxb))
            {
                return nxb;
            }
        }
        return null;
    }
    public ArrayList<NXBPOJO> searchNXB(String manxb,String tennxb,String diachi,String dth)
    {
        ArrayList<NXBPOJO> search = new ArrayList<>();
        manxb = manxb.isEmpty()?manxb = "": manxb;
        tennxb = manxb.isEmpty()?tennxb = "": tennxb;
        diachi = diachi.isEmpty()?diachi = "": diachi;
        dth = dth.isEmpty()?dth = "": dth;
        
        for(NXBPOJO nxb : listNXB)
        {
            if( nxb.getMaNXB().contains(manxb) && 
                nxb.getTenNXB().contains(manxb) //&&
               // nxb.getDiaChi().contains(matg) &&
                //nxb.getSDT().contains(dth) 
               )
            {
                search.add(nxb);
            }
        }
        return search;
    }
    public ArrayList<NXBPOJO> list() throws Exception
    {
        if (this.listNXB == null)
        {
            this.loadDSNXB();
        }
        return listNXB;
    }

    public NXBPOJO timkiem_MaNXB(String id)
    {
        NXBPOJO n = new NXBPOJO();
        for(NXBPOJO nxb : listNXB)
        {
            if(nxb.getMaNXB().compareTo(id) == 0)
            {
                n = nxb;
            }
        }
        return n;
    }
    public ArrayList<NXBPOJO> timkiem_TenNXB(String ten)
    {
        ArrayList<NXBPOJO> n = new ArrayList<NXBPOJO>();
        for(NXBPOJO nxb : listNXB)
        {
            if(nxb.getTenNXB().indexOf(ten) != -1)
            {
                n.add(nxb);
            }
        }
        return n;
    }
    public ArrayList<NXBPOJO> timkiem_DiaChiNXB(String diachi)
    {
        ArrayList<NXBPOJO> n = new ArrayList<NXBPOJO>();
        for(NXBPOJO nxb : listNXB)
        {
            if(nxb.getDiaChi().indexOf(diachi) != -1)
            {
                n.add(nxb);
            }
        }
        return n;
    }
    public ArrayList<NXBPOJO> timkiem_SDT(String sdt)
    {
        ArrayList<NXBPOJO> n = new ArrayList<NXBPOJO>();
        for(NXBPOJO nxb : listNXB)
        {
            if(nxb.getSDT().indexOf(sdt) != -1)
            {
                n.add(nxb);
            }
        }
        return n;
    }
    
}

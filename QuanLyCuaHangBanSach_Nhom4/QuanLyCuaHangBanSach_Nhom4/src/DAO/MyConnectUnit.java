
package DAO;



import java.io.IOException;
import java.io.*;
import java.sql.*;
import java.sql.SQLException;
import java.util.HashMap;

public class MyConnectUnit  {
    SQLServerConnect connect;
    public MyConnectUnit() {
        connect =new SQLServerConnect("localhost","sa","12","bookstore");
    }

    public MyConnectUnit(SQLServerConnect connect) {
        this.connect = connect;
    }

    public MyConnectUnit( String host, String username, String password, String database) {
        connect =new SQLServerConnect(host, username, password, database);

    }   
    public ResultSet Select(String tableName, String condition,String Oderby) throws Exception {
        StringBuilder query = new StringBuilder("SELECT * FROM "+tableName);
        this.AddCondition(query,condition);
        this.AddOderby(query,Oderby);
        query.append(";");
         System.out.println(query);
        return connect.excuteQuery(query.toString());
    }
    public ResultSet Select(String tableName,String condition) throws Exception {
       return this.Select(tableName, condition, null);
    } 
    public ResultSet Select(String tableName) throws Exception {
       return this.Select(tableName, null);
    } 
    public ResultSet SelectCustom(String tableName,String Custom, String condition,String GroupBy,String Oderby) throws Exception {
        StringBuilder query = new StringBuilder("SELECT "+Custom+" FROM "+tableName);
        this.AddCondition(query,condition);
         this.AddGroupby(query, GroupBy);
        this.AddOderby(query,Oderby); 
        query.append(";");
         System.out.println(query);
        return connect.excuteQuery(query.toString());
    }
    public ResultSet SelectCustom(String tableName,String Custom, String condition,String Groupby) throws Exception {
        return SelectCustom(tableName,Custom,condition,Groupby,null);
    }
    public ResultSet SelectCustomGroupBy(String tableName,String Custom,String Groupby) throws Exception {
        return SelectCustom(tableName,Custom,null,Groupby,null);
    }
    public ResultSet SelectCustomGroupByOderby(String tableName,String Custom,String Groupby,String Oderby) throws Exception {
        return SelectCustom(tableName,Custom,null,Groupby,Oderby);
    }
    public ResultSet SelectCustom(String tableName,String Custom, String condition) throws Exception {
        return SelectCustom(tableName,Custom,condition,null,null);
    }
    public ResultSet SelectCustom(String tableName,String Custom) throws Exception {
        return SelectCustom(tableName,Custom,null,null,null);
    }
    
    public boolean Insert(String tableName,HashMap<String,Object> columnValue) throws Exception {
         StringBuilder query = new StringBuilder("INSERT INTO " +tableName);
        StringBuilder valueInsert = new StringBuilder();
        
        query.append("(");
        for(String key :columnValue.keySet()){
            query.append(key+",");
            valueInsert.append("'"+columnValue.get(key).toString()+ "' ,");
            
        }
        // cat bot ky tu , cuoi moi cau query
        query=query.delete(query.length()-1, query.length());
        valueInsert =valueInsert.delete(valueInsert.length()-1, valueInsert.length());
        // đưa giá trị của cột vào câu query
        query.append(") VALUES ("+valueInsert.toString() +" )");
        query.append(";");
        System.out.println(query);
        return connect.excuteUpdate(query.toString()) >0;
    }
    public boolean Update(String tableName,HashMap<String,Object> columnValue,String condition) throws Exception {
        // khai bao bien StringBuilder dề lưu câu truuy vấn
         StringBuilder query = new StringBuilder("UPDATE " +tableName+" SET  ");
        
        
       //Duyet va đưa thông ti giá tri cân update vào câu Query
        for(String key :columnValue.keySet()){
            query.append(key+" = '"+columnValue.get(key).toString() +"' ,");
            
        }
        // cat bot ky tu , cuoi moi cau query
        query=query.delete(query.length()-1, query.length());
        //Đưa câu lệnh điều kiện vào câu query
        this.AddCondition(query,condition);
        // đưa giá trị của cột vào câu query
        query.append(";");
        // thuc khi cau lệnh bên ngoài
         System.out.println(query+" ");
        return connect.excuteUpdate(query.toString()) >0;
    }
    public boolean Delete(String tableName,String condition) throws Exception {
        // khai bao bien StringBuilder dề lưu câu truuy vấn
         StringBuilder query = new StringBuilder("DELETE FROM " +tableName);
       
        //Đưa câu lệnh điều kiện vào câu query
        this.AddCondition(query, condition);
        // đưa giá trị của cột vào câu query
        query.append(";");
        // thuc khi cau lệnh bên ngoài
         System.out.println(query);
        return connect.excuteUpdate(query.toString()) >0;
    }
    
    public static int getColumnCount(ResultSet result)throws SQLException{
        return result.getMetaData().getColumnCount();
    }
    public static String[] getColumnName(ResultSet result)throws SQLException{
        ResultSetMetaData rsMetaData =(ResultSetMetaData)result.getMetaData();
        int ColumnCount = rsMetaData.getColumnCount();
        
       
        String[] list =new String[ColumnCount];
         for(int i=0;i<ColumnCount;i++){
             list[i]=rsMetaData.getCatalogName(i);
         }
         return list;
    }
    private void AddCondition (StringBuilder query,String condition){
        if(condition!=null) query.append(" WHERE "+condition);
    }
    private void AddOderby (StringBuilder query,String Oderby){
        if(Oderby!=null) query.append(" ORDER BY "+Oderby);
    }
    private void AddGroupby (StringBuilder query,String Groupby){
        if(Groupby!=null) query.append(" GROUP BY "+Groupby);
    }
    public void Close()throws SQLException{
        connect.Close();
    }
}

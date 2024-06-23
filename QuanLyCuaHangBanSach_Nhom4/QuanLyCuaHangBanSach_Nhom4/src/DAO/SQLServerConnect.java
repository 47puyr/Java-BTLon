
package DAO;


import java.sql.*;

public class SQLServerConnect {
    String host="localhost";
    String username="sa";
    String password="12";
    String database="bookstore";
    
    Statement statement=null;
    Connection connect=null;
    ResultSet result=null;

    public SQLServerConnect() {
    }
    public SQLServerConnect(String host,String username,String password, String database) {
        this.host=host;
        this.username=username;
        this.password=password;
        this.database=database;
    }
    public void DriverTest() throws Exception{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           
        }
        catch(java.lang.ClassNotFoundException e){
            throw new Exception("Canot Connect to MySQL !!!");
        };
    }

    public Connection getConnect() throws Exception  {
        if(this.connect==null){
            this.DriverTest();
            String url = "jdbc:sqlserver://" + this.host + "\\SQLEXPRESS:1433;databaseName=" + this.database + ";encrypt=true;trustServerCertificate=true";
            try{
                this.connect=DriverManager.getConnection(url,username,password);
            }
            catch(java.sql.SQLException e){
            throw new Exception("Canot Connect to MySQL !!!"+url+e.getMessage());
        }
        }
        System.out.println("jdbc:sqlserver://" + this.host + "\\SQLEXPRESS:1433;databaseName=" + this.database + ";encrypt=true;trustServerCertificate=true");
        return connect;
    }
    public Statement getStatement()throws Exception {
        if(statement==null?true:statement.isClosed()){
           this.statement=this.getConnect().createStatement();
        }
        return statement;
    }

    public ResultSet excuteQuery(String query) throws Exception  {
         try{
                this.result=getStatement().executeQuery(query);
            }
         catch(Exception e){
            throw new Exception("Lỗi :"+e.getMessage()+" - "+query);
        }
       return result;
    }
    public int excuteUpdate(String query) throws Exception  {
        int res =Integer.MIN_VALUE;
        
         try{
                res=getStatement().executeUpdate(query);
            }
         catch(Exception e){
            throw new Exception("Lỗi :"+e.getMessage()+" - "+query);
            }
            finally{
                    this.Close();
               }
       return res;
    }
    public void Close()throws SQLException{
        if(this.result!=null &&!this.result.isClosed()){
            this.result.close();
            this.result=null;
        }
        if(this.statement!=null &&!this.statement.isClosed()){
            this.statement.close();
            this.statement=null;
        }
        if(this.connect!=null &&!this.connect.isClosed()){
            this.connect.close();
            this.connect=null;
        }
    }
    
    
    
    
    
}

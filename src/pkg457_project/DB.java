package pkg457_project;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DB {
    Statement stmt;
    
    public DB(){
        setConnection();
    }
    
    public void setConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        
        final String ID, PW, SERVER;
        ID = "mpierc9";
        PW = "COSC*ke0su";
        SERVER = "jdbc:mysql://triton.towson.edu:3360/?serverTimezone=EST#/"+ID+"db";
        
        try{
            Connection con = DriverManager.getConnection(SERVER, ID, PW);
            this.stmt = con.createStatement();
                    
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
   
    
    public ResultSet getEmployee(){
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Employee order by mpierc9db.Employee.LName");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    
    public ResultSet getPatient(){
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Patient");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public ResultSet getPatientNotes(){
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Patient");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    
    public ResultSet getVendor(){
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Vendor");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    
    public ResultSet getClient(){
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Client");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public void insertData(String table){}
    public void deleteData(String table, String id, String col_name){ //col_name is supposed to be the column where the id is held
        try{
            ResultSet rs = stmt.executeQuery("select * from mpierc9db."+table+" where "+col_name+" = "+ id);
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
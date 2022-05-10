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
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Employee order by lname");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    public void addEmployee(String s,String fn,String ln,String se,String ph,String st,String ci,String sta,String dat,double p, String dep){
        try{
            stmt.executeUpdate("insert into mpierc9db.Employee values(\""+s+"\", \""+fn+"\", \""+ln+"\", \""+se+"\", \""+ph+"\", \""+
                                        st+"\", \""+ci+"\", \""+sta+"\", \""+dat+"\", "+p+");");
            stmt.executeUpdate("insert into mpierc9db.WorksFor values(\""+s+"\", \""+ dep+"\", "+0+");");
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    
    public ResultSet getPatient(){
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Patient order by p_id");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public void addPatient(String p, String  n, String  b, String  d, String  no, String own){
        //implement
        try{
            stmt.executeUpdate("insert into mpierc9db.Patient values(\""+p+"\", \""+n+"\", \""+b
                            +"\", \""+d+"\", \""+no +"\");");
            stmt.executeUpdate("insert into mpierc9db.Owns values(\""+p+"\",  \""+own+"\");");
        }catch(SQLException e){
            System.out.println(e);
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
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Vendor order by v_id");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public void addVendor(String v, String  n, String t, String  ph,String  em,String  st,String  ci){
        //implement
        try{
            stmt.executeUpdate("insert into mpierc9db.Vendor values(\""+v+"\", \""+n+"\",  \""+t
                            +"\", \""+ph+"\", \""+em+"\", \""+st+"\", \""+ci +"\");");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public ResultSet getClient(){
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Client order by lname");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    public void addClient(String c, String  fn, String ln,String  ph,String  em,String  st,String  ci){
        //implement
        try{
            stmt.executeUpdate("insert into mpierc9db.Client values(\""+c+"\", \""+fn+"\", \""+ln
                            +"\", \""+ph+"\", \""+em+"\", \""+st+"\", \""+ci +"\");");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void deleteData(String table, String col, String id){ 
        //may have to implement switch statement to figure out what table is being deleted from, and then delete dependencies
        
        try{
            int r = stmt.executeUpdate("delete from mpierc9db."+table+" where "+col+" = "+ "\""+id+ "\";");
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }         

    public ResultSet getService() {
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Service order by s_id");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    public ResultSet getBills() {
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Bills order by date");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    public ResultSet getContracts() {
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Contracts order by v_id");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }    
    
    public ResultSet getDepartment() {
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Department order by d_num");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }

    ResultSet getCheckIn() {
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.CheckIn order by date");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }    }

    ResultSet getOwns() {
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Owns order by c_id");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public ResultSet getAdminister() {
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.Administers");
            return rs;
            
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public void addAdminister(String p, String ssn, String sid){
        try{
            stmt.executeUpdate("insert into mpierc9db.Administers values(\""+p+"\", \""+ssn+"\", \""+sid+"\");");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void addCheckIn(String p, String o, String d, String ken){
        try{
            stmt.executeUpdate("insert into mpierc9db.CheckIn values(\""+p+"\", \""+o+"\", \""+d+"\",null, \""+ken+ "\");");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
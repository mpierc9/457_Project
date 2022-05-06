package pkg457_project;

import java.sql.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author killua
 */
public class DB {
    Statement stmt;
    
    public DB(){
        getConnection();
    }
    
    public void getConnection(){
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

    public ResultSet makeQuery(){
        try{
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.EMPLOYEE");
            return rs;
            
        }catch(SQLException e){
            System.out.println("makequery error");
            System.out.println(e);
            return null;
        }
    }
}
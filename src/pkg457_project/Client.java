/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg457_project;

import java.sql.*;

/**
 *
 * @author killua
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from mpierc9db.EMPLOYEE");
            
            while(rs.next()){
                String SSN = rs.getString("SSN");
                String FNAME = rs.getString("FNAME");
                String SEX = rs.getString("SEX");
                String SALARY = rs.getString("SALARY");
                System.out.println(SSN+",  "+FNAME+",  "+SEX+"  "+SALARY);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg457_project;


import java.awt.TextArea;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
        
        DB database = new DB();
        
        JFrame f; JTextField tf; JLabel l; JButton b; TextArea a;
        
        f=new JFrame();
        
        tf=new JTextField();  
        tf.setBounds(500,500, 150,20);  
        
        l=new JLabel();  
        l.setBounds(50,100, 250,20);      
        
        b=new JButton("Make Query");  
        b.setBounds(500,700,150,30);  
        
        a = new TextArea();
        a.setBounds(10,30, 500,500);
        b.addActionListener((ActionEvent event) -> {
            ResultSet rs = database.makeQuery();
            try{
                System.out.println("printing results");
                while(rs.next()){
                    String SSN = rs.getString("SSN");
                    String FNAME = rs.getString("FNAME");
                    String SEX = rs.getString("SEX");
                    String SALARY = rs.getString("SALARY");                
                    System.out.println("flag");
                    System.out.println(SSN+",  "+FNAME+",  "+SEX+"  "+SALARY);
                    a.append("\n"+SSN+",  "+FNAME+",  "+SEX+"  "+SALARY);
                
                }
            }catch(SQLException e){
                System.out.println("resGUI error");
                System.out.println(e);
            }
        });  
        
        
        f.add(a);f.add(b);f.add(tf);f.add(l);    
        f.setSize(800,800);  
        f.setLayout(null);  
        f.setVisible(true);  
        
        
    }
    
    
}
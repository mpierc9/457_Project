package pkg457_project;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author killua
 */
        
public class ResultGUI extends Frame implements ActionListener{
    ResultSet rs;
    JTextField tf; JLabel l; JButton b; TextArea a;
    ResultGUI(ResultSet rs){
        this.rs = rs;
        tf=new JTextField();  
        tf.setBounds(50,50, 150,20);  
        
        l=new JLabel();  
        l.setBounds(50,100, 250,20);      
        
        b=new JButton("Clear Results");  
        b.setBounds(50,150,95,30);  
        b.addActionListener(this);    
        
        try{
            System.out.println("printing results");
            while(rs.next()){
                String SSN = rs.getString("SSN");
                String FNAME = rs.getString("FNAME");
                String SEX = rs.getString("SEX");
                String SALARY = rs.getString("SALARY");                
                System.out.println("flag");
                System.out.println(SSN+",  "+FNAME+",  "+SEX+"  "+SALARY);
                l.setText(SSN+",  "+FNAME+",  "+SEX+"  "+SALARY);
                
            }
        }catch(SQLException e){
            System.out.println("resGUI error");
            System.out.println(e);
        }
        
        add(a);add(b);add(tf);add(l);    
        setSize(800,400);  
        setLayout(null);  
        setVisible(true);  
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        try{  
        String host=tf.getText();  
        String ip=java.net.InetAddress.getByName(host).getHostAddress();  
        l.setText("IP of "+host+" is: "+ip);  
        }catch(UnknownHostException ex){System.out.println(ex);}  
    }         
}

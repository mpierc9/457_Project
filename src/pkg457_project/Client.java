package pkg457_project;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;


/*
 *
 * this class makes the initial JFrame, with buttons that will
 * make new JFrames 
 * 
 */


public class Client {
    
    
    public static void main(String[] args) {
        
        DB database = new DB();
        
        JFrame f;
        f=new JFrame("Towson Vet Database");  
        
        Icon icon = new ImageIcon("./logo.png");
        JLabel logo = new JLabel(icon);
        logo.setBounds(500, 100, 400,400);

        
        
        JButton employee=new JButton("List Employees");  
        employee.setBounds(650,600,150,30);  
        employee.addActionListener((ActionEvent event) -> {
            ResultSet rs = database.getEmployee();
            new ResultGUI(rs);
        });
                
                
        JButton client=new JButton("List Clients");
        client.setBounds(650,500,150,30);  
        client.addActionListener((ActionEvent event) -> {
            ResultSet rs = database.getClient();
            new ResultGUI(rs);
        });  
        
        
        JButton patient=new JButton("List Patients");
        patient.setBounds(300,500,150,30);  
        patient.addActionListener((ActionEvent event) -> {
            ResultSet rs = database.getPatient();
            new ResultGUI(rs);
        });  
        
        
        JButton vendor=new JButton("List Vendors");
        vendor.setBounds(300,600,150,30);  
        vendor.addActionListener((ActionEvent event) -> {
            ResultSet rs = database.getVendor();
            new ResultGUI(rs);
        });  

  
        f.add(logo);
        f.add(employee);f.add(client);f.add(patient);f.add(vendor);    
        f.setSize(1000,800);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setVisible(true);  
        
        
    }
    
    
}
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
        
        JLabel logo = new JLabel("Towson Vet Database System");
        logo.setBounds(500, 100, 350,400);

        
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
        
        
        JButton service=new JButton("List Services");
        service.setBounds(650,400,150,30);  
        service.addActionListener((ActionEvent event) -> {
            ResultSet rs = database.getService();
            new ResultGUI(rs);
        });
        
        JButton bills =new JButton("List Bills");
        bills.setBounds(300,400,150,30);  
        bills.addActionListener((ActionEvent event) -> {
            ResultSet rs = database.getBills();
            new ResultGUI(rs);
        });
        
        JButton admin =new JButton("Administer a Service");
        admin.setBounds(300,350,150,30);  
        admin.addActionListener((ActionEvent event) -> {
            new AddAdministerGUI();
        });

        JButton check =new JButton("Check In a patient");
        check.setBounds(650,350,150,30);  
        check.addActionListener((ActionEvent event) -> {
            new AddCheckInGUI();
        });        
        JButton e = new JButton("Exit");
        e.setBounds(425, 700, 150, 30);
        e.addActionListener((ActionEvent event) -> {
            f.dispose();
            System.exit(0);
        });
        
        f.add(logo);f.add(e); f.add(bills);f.add(service);f.add(admin);
        f.add(employee);f.add(client);f.add(patient);f.add(vendor);    f.add(check);
        f.setSize(1000,800);  
        f.setLayout(null);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        f.setVisible(true);  
        
        
    }
    
    
}
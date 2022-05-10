/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg457_project;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author killua
 */
public class AddEmployeeGUI extends JFrame {

    private JLabel ssn, fName, lName, sex, phone, street, city, start, dob, pay, dept;
    private JTextField ssnF, fNameF, lNameF, sexF, phoneF, streetF, cityF, startF, dobF, payF, deptF;
    private JButton submit, exit;
    
    public AddEmployeeGUI() {
    
        ssn = new JLabel("SSN:");            ssn.setBounds(20,20, 100,30);
        fName = new JLabel("First Name:");   fName.setBounds(20,60, 100,30);
        lName = new JLabel("Last Name:");    lName.setBounds(20,100, 100,30);
        sex = new JLabel("Sex:");            sex.setBounds(20,140, 100,30);
        phone = new JLabel("Phone:");        phone.setBounds(20,180, 100,30);
        street = new JLabel("Street:");      street.setBounds(20,220, 100,30);
        city = new JLabel("City:");          city.setBounds(20,260, 100,30);
        start = new JLabel("Start:");        start.setBounds(20,300, 100,30);
        dob = new JLabel("DOB:");            dob.setBounds(20,340, 100,30);
        pay = new JLabel("Pay Rate:");       pay.setBounds(20,380, 100,30);
        dept = new JLabel("Department:");    dept.setBounds(20,420,100,30);
        
        ssnF = new JTextField();    ssnF.setBounds(200,20, 100,30);
        fNameF = new JTextField();  fNameF.setBounds(200,60, 100,30);
        lNameF = new JTextField();  lNameF.setBounds(200,100, 100,30);
        sexF = new JTextField();    sexF.setBounds(200,140, 100,30);
        phoneF = new JTextField();  phoneF.setBounds(200,180, 100,30);
        streetF = new JTextField(); streetF.setBounds(200,220, 100,30);
        cityF = new JTextField();   cityF.setBounds(200,260, 100,30);
        startF = new JTextField();  startF.setBounds(200,300, 100,30);
        dobF = new JTextField("YYYY-MM-DD");    dobF.setBounds(200,340, 100,30);
        payF = new JTextField();    payF.setBounds(200,380, 100,30);
        deptF = new JTextField();   deptF.setBounds(200,420,100,30);
        
        submit = new JButton("Submit");
        submit.setBounds(300,500,150,30);  
        submit.addActionListener((ActionEvent event) -> {
            //implement
            String s = ssnF.getText();
            String fn = fNameF.getText();
            String ln = lNameF.getText();
            String se = sexF.getText();
            String ph = phoneF.getText();
            String st = streetF.getText();
            String ci = cityF.getText();
            String sta = startF.getText();
            String dat = dobF.getText();
            String dep = deptF.getText();
            double p = Double.parseDouble(payF.getText());
            
            DB database = new DB();
            database.addEmployee(s, fn, ln, se, ph, st, ci, sta, dat, p, dep);
            dispose();
            new ResultGUI(database.getEmployee());
            new ResultGUI(database.getDepartment());
        });
        
        exit = new JButton("Exit");
        exit.setBounds(700,500,150,30);  
        exit.addActionListener((ActionEvent event) -> {
            //implement
            dispose();
        });
        
        add(ssn);add(fName);add(lName);add(sex);
        add(phone);add(street);add(city);
        add(start);add(dob);add(pay);
        
        add(ssnF);add(fNameF);add(lNameF);add(sexF);
        add(phoneF);add(streetF);add(cityF);
        add(startF);add(dobF);add(payF);
        add(submit);add(exit);
        
        setSize(1000,800);  
        setLayout(null);  
        
        setVisible(true); 
    }
    
}

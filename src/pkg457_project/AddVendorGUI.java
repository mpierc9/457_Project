/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg457_project;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author killua
 */
public class AddVendorGUI extends JFrame{

    private JLabel vid, name, type, phone, email, street, city;
    private JTextField cidF, nameF, typeF, phoneF, emailF, streetF, cityF;
    private JButton submit, exit;
    
    public AddVendorGUI() {
    
        vid = new JLabel("Client ID:");      vid.setBounds(20,20, 100,30);
        name = new JLabel("First Name:");    name.setBounds(20,60, 100,30);
        type = new JLabel("Phone:");        type.setBounds(20,100, 100,30);
        phone = new JLabel("Phone:");        phone.setBounds(20,180, 100,30);
        email = new JLabel("Email:");        email.setBounds(20,220, 100,30);
        street = new JLabel("Street:");      street.setBounds(20,260, 100,30);
        city = new JLabel("City:");          city.setBounds(20,300, 100,30);

        cidF = new JTextField();    cidF.setBounds(200,20, 100,30);
        nameF = new JTextField();  nameF.setBounds(200,600, 100,30);
        typeF = new JTextField();   typeF.setBounds(20,180, 100,30);
        phoneF = new JTextField();  phoneF.setBounds(200,180, 100,30);
        emailF = new JTextField();  emailF.setBounds(20,220, 100,30);
        streetF = new JTextField(); streetF.setBounds(200,260, 100,30);
        cityF = new JTextField();   cityF.setBounds(200,300, 100,30);
        
        
        submit = new JButton("Submit");
        submit.setBounds(300,500,150,30);  
        submit.addActionListener((ActionEvent event) -> {
            //implement
            String v = vid.getText();
            String fn = name.getText();
            String t  = type.getText();
            String ph = phone.getText();
            String em = email.getText();
            String st = street.getText();
            String ci = city.getText();
            
            DB database = new DB();
            database.addVendor(v, fn, t, ph, em, st, ci);
        });
        
        exit = new JButton("Exit");
        exit.setBounds(300,500,150,30);  
        exit.addActionListener((ActionEvent event) -> {
            //implement
            dispose();
        });
        
        add(vid);add(name);add(type);
        add(phone);add(street);add(city);
        add(email);add(emailF);
        add(cidF);add(nameF);add(typeF);
        add(phoneF);add(streetF);add(cityF);
        
        add(submit);add(exit);
        
        setSize(1000,800);  
        setLayout(null);  
        
        setVisible(true); 
    }
    
}

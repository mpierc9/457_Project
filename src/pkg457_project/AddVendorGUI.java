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
    private JTextField vidF, nameF, typeF, phoneF, emailF, streetF, cityF;
    private JButton submit, exit;
    
    public AddVendorGUI() {
    
        vid = new JLabel("Vendor ID:");      vid.setBounds(20,20, 100,30);
        name = new JLabel("Name:");    name.setBounds(20,60, 100,30);
        type = new JLabel("Type:");        type.setBounds(20,100, 100,30);
        phone = new JLabel("Phone:");        phone.setBounds(20,180, 100,30);
        email = new JLabel("Email:");        email.setBounds(20,220, 100,30);
        street = new JLabel("Street:");      street.setBounds(20,260, 100,30);
        city = new JLabel("City:");          city.setBounds(20,300, 100,30);

        vidF = new JTextField();    vidF.setBounds(200,20, 100,30);
        nameF = new JTextField();  nameF.setBounds(200,60, 100,30);
        typeF = new JTextField();   typeF.setBounds(200,100, 100,30);
        phoneF = new JTextField();  phoneF.setBounds(200,180, 100,30);
        emailF = new JTextField();  emailF.setBounds(200,220, 100,30);
        streetF = new JTextField(); streetF.setBounds(200,260, 100,30);
        cityF = new JTextField();   cityF.setBounds(200,300, 100,30);
        
        
        submit = new JButton("Submit");
        submit.setBounds(300,500,150,30);  
        submit.addActionListener((ActionEvent event) -> {
            //implement
            String v = vidF.getText();
            String fn = nameF.getText();
            String t  = typeF.getText();
            String ph = phoneF.getText();
            String em = emailF.getText();
            String st = streetF.getText();
            String ci = cityF.getText();
            
            DB database = new DB();
            database.addVendor(v, fn, t, ph, em, st, ci);
            dispose();
            new ResultGUI(database.getVendor());            
        });
        
        exit = new JButton("Exit");
        exit.setBounds(700,500,150,30);  
        exit.addActionListener((ActionEvent event) -> {
            //implement
            dispose();
        });
        
        add(vid);add(name);add(type);
        add(phone);add(street);add(city);
        add(email);add(emailF);
        add(vidF);add(nameF);add(typeF);
        add(phoneF);add(streetF);add(cityF);
        
        add(submit);add(exit);
        
        setSize(1000,800);  
        setLayout(null);  
        
        setVisible(true); 
    }
    
}

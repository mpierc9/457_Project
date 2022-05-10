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
public class AddAdministerGUI extends JFrame {

    private JLabel pid, ssn, sid;
    private JTextField pidF, ssnF, sidF;
    private JButton submit, exit;
    
    public AddAdministerGUI() {
    
        pid = new JLabel("Patient ID:");      pid.setBounds(20,20, 100,30);
        ssn = new JLabel("SSN of empl.:");    ssn.setBounds(20,60, 100,30);
        sid = new JLabel("Breed:");        sid.setBounds(20,180, 100,30);
        
        pidF = new JTextField();    pidF.setBounds(200,20, 100,30);
        ssnF = new JTextField();  ssnF.setBounds(200,60, 100,30);
        sidF = new JTextField();   sidF.setBounds(200,180, 100,30);
        
        submit = new JButton("Submit");
        submit.setBounds(300,500,150,30);  
        submit.addActionListener((ActionEvent event) -> {
            //implement
            String p = pidF.getText();
            String ss = ssnF.getText();
            String s  = sidF.getText();
            
            DB database = new DB();
            database.addAdminister(p, ss, s);
            dispose();
            new ResultGUI(database.getAdminister());
        });
        
        exit = new JButton("Exit");
        exit.setBounds(700,500,150,30);  
        exit.addActionListener((ActionEvent event) -> {
            //implement
            dispose();
        });
        
        add(pid);add(ssn);add(sid);
        
        add(pidF);add(ssnF);add(sidF);
        
        add(submit);add(exit);
        
        setSize(1000,800);  
        setLayout(null);  
        
        setVisible(true); 
    }
    
}

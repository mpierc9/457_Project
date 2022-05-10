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
public class AddPatientGUI extends JFrame {

    private JLabel pid, name, breed, dob, notes;
    private JTextField pidF, nameF, breedF, dobF, notesF;
    private JButton submit, exit;
    
    public AddPatientGUI() {
    
        pid = new JLabel("Patient ID:");      pid.setBounds(20,20, 100,30);
        name = new JLabel("Name:");         name.setBounds(20,60, 100,30);
        breed = new JLabel("Breed:");        breed.setBounds(20,180, 100,30);
        dob = new JLabel("DOB:");        dob.setBounds(20,220, 100,30);
        notes = new JLabel("Notes:");      notes.setBounds(20,260, 100,30);

        pidF = new JTextField();    pidF.setBounds(200,20, 100,30);
        nameF = new JTextField();  nameF.setBounds(200,60, 100,30);
        breedF = new JTextField();   breedF.setBounds(200,180, 100,30);
        dobF = new JTextField("YYYY-MM-DD");    dobF.setBounds(200,220, 100,30);
        notesF = new JTextField();  notesF.setBounds(200,260, 100,30);
        
        
        submit = new JButton("Submit");
        submit.setBounds(300,500,150,30);  
        submit.addActionListener((ActionEvent event) -> {
            //implement
            String p = pidF.getText();
            String n = nameF.getText();
            String b  = breedF.getText();
            String d = dobF.getText();
            String no = notesF.getText();
            
            DB database = new DB();
            database.addPatient(p, n, b, d, no);
            dispose();
            new ResultGUI(database.getPatient());            
        });
        
        exit = new JButton("Exit");
        exit.setBounds(700,500,150,30);  
        exit.addActionListener((ActionEvent event) -> {
            //implement
            dispose();
        });
        
        add(pid);add(name);add(breed);
        add(dob);add(notes);
        
        add(pidF);add(nameF);add(breedF);
        add(dobF);add(notesF);
        
        add(submit);add(exit);
        
        setSize(1000,800);  
        setLayout(null);  
        
        setVisible(true); 
    }
    
}

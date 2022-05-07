package pkg457_project;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;

        
public class ResultGUI extends JFrame{
    TextArea a; JButton b;JButton c;JButton d;JButton e;
    
    ResultGUI(ResultSet rs){
        a = new TextArea(); 
        a.setBounds(10,30, 750,600);
        
        b = new JButton("Add an entry");
        b.setBounds(800, 400, 150, 30);
        b.addActionListener((ActionEvent event) -> {
            //implement
        });
        c = new JButton("Change an entry");
        c.setBounds(800, 500, 150, 30);
        c.addActionListener((ActionEvent event) -> {
            //implement
        });
        d = new JButton("Delete an entry");
        d.setBounds(800, 600, 150, 30);
        d.addActionListener((ActionEvent event) -> {
            //implement
        });
        e = new JButton("Exit");
        e.setBounds(800, 700, 150, 30);
        e.addActionListener((ActionEvent event) -> {
            dispose();
        });
        try{
            int r = 1;
            ResultSetMetaData rsMeta = rs.getMetaData();
            String colNames = new String();
            String entry = new String();
            
            while(rs.next()){
                for(int i = 1; i < rsMeta.getColumnCount(); i++){
                    if(i == 1){
                        entry = entry + "\n"+rs.getString(i)+"\t";
                        if(r == 1){
                            colNames = colNames + rsMeta.getColumnName(i) + "\t";                        
                        }
                        
                    }else if(rsMeta.getColumnCount()-1 == i){
                        entry = entry + rs.getString(i);
                        if(r == 1){
                            colNames = colNames + rsMeta.getColumnName(i);                        
                        }
                        
                    }else{
                        entry = entry + rs.getString(i) + ",\t";
                        if(r == 1){
                            colNames = colNames + rsMeta.getColumnName(i) + "\t";                        
                        }
                    }
                }
                if(r == 1){
                    a.append(colNames);                        
                }
                a.append(entry);
                r++;
            }
            a.setEditable(false);
        }catch(SQLException e){
            System.out.println("resGUI error");
            System.out.println(e);
        }
        
        add(a);add(b);add(c);add(d);add(e);
        setSize(1000,800);  
        setLayout(null);  
        
        setVisible(true);  
    }  
    
    @Override
    protected void processWindowEvent(WindowEvent e) {
         if (e.getID() == (WindowEvent.WINDOW_CLOSING)) {
            setVisible(false);
        }
    }
}

package pkg457_project;



import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;

        
public class ResultGUI extends JFrame{
    TextArea a; JButton b;
    
    ResultGUI(ResultSet rs){
        a = new TextArea(); 
        a.setBounds(10,30, 750,600);
        
        b = new JButton("Clear Results");
        b.setBounds(600, 700, 150, 30);
        
        
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
        
        add(a);
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

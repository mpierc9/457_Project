package pkg457_project;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

        
public class ResultGUI extends JFrame{
    JTable a; JButton b;JButton c;JButton d;JButton e;
    JTextField del; JLabel delL; JButton dcon;
    String s; String col; JScrollPane sp;
    String title;
    ResultGUI(ResultSet rs){
        
        b = new JButton("Add an entry");
        b.setBounds(800, 400, 150, 30);
        b.addActionListener((ActionEvent event) -> {
            new AddGUI(s);
            dispose();
        });
        c = new JButton("Change Info");
        c.setBounds(800, 500, 150, 30);
        c.addActionListener((ActionEvent event) -> {
            //implement

        });            
        delL = new JLabel("ID to delete: ");
        del = new JTextField();
        delL.setBounds(200, 675, 150, 30);
        del.setBounds(375, 675, 150, 30);
            
        dcon = new JButton("DELETE");
        dcon.setBounds(550, 675, 150, 30);
        dcon.addActionListener((ActionEvent ev) -> {
                DB database = new DB();
                database.deleteData(s,  col, del.getText());
                dispose();
                
        });
        add(delL); add(del);add(dcon);
        del.setVisible(false);
        delL.setVisible(false);    
        dcon.setVisible(false);    
        d = new JButton("Delete an entry");
        d.setBounds(800, 600, 150, 30);
        d.addActionListener((ActionEvent event) -> {
            del.setVisible(true);
            delL.setVisible(true);
            dcon.setVisible(true);
            
        });
        
        e = new JButton("Exit");
        e.setBounds(800, 700, 150, 30);
        e.addActionListener((ActionEvent event) -> {
            dispose();
        });
        try{
            int r = 1;
            ResultSetMetaData rsMeta = rs.getMetaData();
            int colCount = rsMeta.getColumnCount();
            rs.last(); 
            int rowCount = rs.getRow(); rs.beforeFirst();
            
            String[] colNames = new String[colCount];
            String[][] rows = new String[rowCount][colCount];
            
            
            s = rsMeta.getTableName(1);
            col = rsMeta.getColumnName(1);
            
            while(rs.next()){
                for(int i = 1; i <= colCount; i++){
                    rows[r-1][i-1] = rs.getString(i);
                    
                    if(rs.wasNull()){
                        rows[r-1][i-1] = "null";
                    }
                        
                    if(r == 1){
                        colNames[i-1] = rsMeta.getColumnName(i);                        
                    }
                }
                
                r++;
            }
            a = new JTable(rows, colNames); 
            a.setBounds(20,70, 650,500);
            setTitle(s);
        }catch(SQLException e){
            System.out.println(e);
        }
        
        
        a.setLayout(new BorderLayout());
        JTableHeader jth = a.getTableHeader();
        jth.setBounds(20,35,800,30);
        add(jth);
        add(a);
        add(b);
        add(c);
        add(d);
        add(e);
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

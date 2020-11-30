package Databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class NoticesDao 
{
    public int countNotices()
    {
        int count=0;
        try
        {
            Databasec1 c=new Databasec1();
            ResultSet rs=c.s.executeQuery("SELECT * FROM NOTICES;");
            while(rs.next())
            {
                count++;
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ADDING RESIDENT TO THE DATABASE FAILED");
        } 
        return count;
    }
    public void addNotices(String name,String path)
    {
        try
        {
            Databasec1 c=new Databasec1();
            String q="INSERT INTO NOTICES (NAME, PATH) VALUES ('"+name+"', '"+path+"');";
            System.out.println(q);
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"NOTICE ADDED SUCCESSFULLY!");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ADDING NOTICE TO THE NOTICE BOARD\n          FAILED");
        }         
    }
}

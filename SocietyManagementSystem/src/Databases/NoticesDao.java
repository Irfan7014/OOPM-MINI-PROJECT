package Databases;

import java.awt.Desktop;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"NOTICE ADDED SUCCESSFULLY!");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ADDING NOTICE TO THE NOTICE BOARD\n          FAILED");
        }         
    }
    
    public ArrayList<String> getName()
    {
        ArrayList<String> names=new ArrayList<String>();
        try
        {
            Databasec1 c=new Databasec1();
            ResultSet rs=c.s.executeQuery("SELECT * FROM NOTICES;");
            while(rs.next())
            {
                names.add(rs.getString("NAME"));
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ADDING NOTICE TO THE NOTICE BOARD\n          FAILED");
        }        
        return names;
    }
    
    public void openNoticePdf(String name)
    {
        try
        {
            Databasec1 c=new Databasec1();
            ResultSet rs=c.s.executeQuery("SELECT * FROM NOTICES WHERE NAME='"+name+"';");
            while(rs.next())
            {
                String path="D:\\Cloned Repositories\\OOPM-MINI-PROJECT\\SocietyManagementSystem\\src\\NoticesAndReportsAndServices\\"+rs.getString("PATH");
                try 
                {
                    File pdfFile = new File(path);
                    if (pdfFile.exists()) {

                        if (Desktop.isDesktopSupported()) {
                            Desktop.getDesktop().open(pdfFile);
                        } else {
                            System.out.println("AWT Desktop is not supported!");
                        }

                    } else {
                        System.out.println("File does not exists!");
                    }

                    System.out.println("Done");

                } 
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"ERROR OPENING THE FILE!");
                }
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR EXTRACTING FILE PATH!");
        }                
    }
    
    public void deleteNotice(String name)
    {
        try
        {
            Databasec1 c=new Databasec1();
            String q="DELETE FROM NOTICES WHERE NAME= '"+name+"';";
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"NOTICE REMOVED SUCCESSFULLY!");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"REMOVING NOTICE FAILED!");
        }        
    }
}

package Databases;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MembersDao 
{
     public ArrayList<String> setToDisplay()
     {
        ArrayList<String> members=new ArrayList<String>();
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from members;");
            while(rs.next())
            {
                if(rs.getString("DESIGNATION").equals("CHAIRMAN"))
                {
                    members.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("SECRETARY"))
                {
                    members.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("TREASURER"))
                {
                    members.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 1"))
                {
                    members.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 2"))
                {
                    members.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 3"))
                {
                    members.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 4"))
                {
                    members.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 5"))
                {
                    members.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 6"))
                {
                    members.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 7"))
                {
                    members.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 8"))
                {
                    members.add(rs.getString("NAME"));
                    continue;
                }
            }
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
         return members;
     }
     
     public void updateMembersList(ArrayList<String> members)
     {
        int k=0;        
        try 
        {
            Databasec1 c=new Databasec1();
            String q;
            q="UPDATE members SET NAME='"+members.get(0)+"' WHERE DESIGNATION='CHAIRMAN';";
            System.out.println("Hey");
            c.s.executeUpdate(q);
            
            q="UPDATE members SET NAME='"+members.get(1)+"' WHERE DESIGNATION='SECRETARY';";
            c.s.executeUpdate(q);
            
            q="UPDATE members SET NAME='"+members.get(2)+"' WHERE DESIGNATION='TREASURER';";
            c.s.executeUpdate(q);
            
            q="UPDATE members SET NAME='"+members.get(3)+"' WHERE DESIGNATION='MEMBER 1';";
            c.s.executeUpdate(q);
            
            q="UPDATE members SET NAME='"+members.get(4)+"' WHERE DESIGNATION='MEMBER 2';";
            c.s.executeUpdate(q);
            
            q="UPDATE members SET NAME='"+members.get(5)+"' WHERE DESIGNATION='MEMBER 3';";
            c.s.executeUpdate(q);
            
            q="UPDATE members SET NAME='"+members.get(6)+"' WHERE DESIGNATION='MEMBER 4';";
            c.s.executeUpdate(q);
            
            q="UPDATE members SET NAME='"+members.get(7)+"' WHERE DESIGNATION='MEMBER 5';";
            c.s.executeUpdate(q);
            
            q="UPDATE members SET NAME='"+members.get(8)+"' WHERE DESIGNATION='MEMBER 6';";
            c.s.executeUpdate(q);
            
            q="UPDATE members SET NAME='"+members.get(9)+"' WHERE DESIGNATION='MEMBER 7';";
            c.s.executeUpdate(q);
            
            q="UPDATE members SET NAME='"+members.get(10)+"' WHERE DESIGNATION='MEMBER 8';";
            c.s.executeUpdate(q);
            k++;
            
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        if(k>0)
        {
            JOptionPane.showMessageDialog(null,"MEMBER DETAILS UPDATED SUCCESSFULLY");            
        }
     }
}

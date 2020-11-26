package gateinn;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GateDao 
{
    public ArrayList<String> viewEntriesByDate(String date)
    {
        ArrayList<String> entries=new ArrayList<String>();
        try 
        {
            Databaseconn c=new Databaseconn();
            ResultSet rs = c.s.executeQuery("select * from entries where Date='"+date+"';");
            while(rs.next()) 
            {
                entries.add(rs.getString("Name"));
                entries.add(rs.getString("Purpose"));
                entries.add(rs.getString("Phone"));
                entries.add(rs.getString("Flat"));
                entries.add(rs.getString("Date"));
                entries.add(rs.getString("Entry_Time"));
                entries.add(rs.getString("Exit_Time"));
                entries.add(rs.getString("Watchman_Present"));
                entries.add(rs.getString("Gate"));
                entries.add(rs.getString("Vehicle_Num"));
            }

        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return entries;
    }
    public ArrayList<String> viewEntriesByName(String name)
    {
        ArrayList<String> entries=new ArrayList<String>();
        try 
        {
            Databaseconn c=new Databaseconn();
            ResultSet rs = c.s.executeQuery("select * from entries where Name='"+name+"';");
            while(rs.next()) 
            {
                entries.add(rs.getString("Name"));
                entries.add(rs.getString("Purpose"));
                entries.add(rs.getString("Phone"));
                entries.add(rs.getString("Flat"));
                entries.add(rs.getString("Date"));
                entries.add(rs.getString("Entry_Time"));
                entries.add(rs.getString("Exit_Time"));
                entries.add(rs.getString("Watchman_Present"));
                entries.add(rs.getString("Gate"));
                entries.add(rs.getString("Vehicle_Num"));
            }

        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return entries;
    }
    public ArrayList<String> viewEntriesByPhone(String phno)
    {
        ArrayList<String> entries=new ArrayList<String>();
        try 
        {
            Databaseconn c=new Databaseconn();
            ResultSet rs = c.s.executeQuery("select * from entries where Phone='"+phno+"';");
            while(rs.next()) 
            {
                entries.add(rs.getString("Name"));
                entries.add(rs.getString("Purpose"));
                entries.add(rs.getString("Phone"));
                entries.add(rs.getString("Flat"));
                entries.add(rs.getString("Date"));
                entries.add(rs.getString("Entry_Time"));
                entries.add(rs.getString("Exit_Time"));
                entries.add(rs.getString("Watchman_Present"));
                entries.add(rs.getString("Gate"));
                entries.add(rs.getString("Vehicle_Num"));
            }

        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return entries;
    }
    
    public void addEntry(ArrayList<String> entry)
    {
        try
        {
            Databaseconn c=new Databaseconn();
            entry.get(0);
            String q="insert into Entries (Name, Purpose, Phone, Flat, Date, Entry_Time, Exit_Time, Watchman_Present, Gate, Vehicle_Num) values ('"+entry.get(0)+"',"+"'"+entry.get(1)+"',"+"'"+entry.get(2)+"',"+"'"+entry.get(3)+"',"+"'"+entry.get(4)+"',"+"'"+entry.get(5)+"',"+"'"+entry.get(6)+"',"+"'"+entry.get(7)+"',"+"'"+entry.get(8)+"',"+"'"+entry.get(9)+"')";
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Details Successfully Added");
            Entry e=new Entry(entry.get(7),entry.get(8));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

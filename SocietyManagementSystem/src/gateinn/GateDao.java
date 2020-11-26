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
}

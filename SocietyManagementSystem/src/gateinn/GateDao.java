package gateinn;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GateDao 
{
    public ArrayList<EntryObject> viewEntriesByDate(String date)
    {
        ArrayList<EntryObject> entries=new ArrayList<EntryObject>();
        try 
        {
            Databaseconn c=new Databaseconn();
            ResultSet rs = c.s.executeQuery("select * from entries where Date='"+date+"';");
            while(rs.next()) 
            {
                EntryObject obj=new EntryObject();
                obj.setWatchman(rs.getString("Watchman_Present"));
                obj.setName(rs.getString("Name"));
                obj.setGate(rs.getString("Gate"));
                obj.setPurpose(rs.getString("Purpose"));
                obj.setFlat(rs.getString("Flat"));
                obj.setVehicle(rs.getString("Vehicle_Num"));
                obj.setPhone(rs.getString("Phone"));
                obj.setDate(rs.getString("Date"));
                obj.setEntrytime(rs.getString("Entry_Time"));
                obj.setExittime(rs.getString("Exit_Time"));
                entries.add(obj);
            }
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return entries;
    }
    public ArrayList<EntryObject> viewEntriesByName(String name)
    {
        ArrayList<EntryObject> entries=new ArrayList<EntryObject>();
        try 
        {
            Databaseconn c=new Databaseconn();
            ResultSet rs = c.s.executeQuery("select * from entries where Name='"+name+"';");
            while(rs.next()) 
            {
                EntryObject obj=new EntryObject();
                obj.setWatchman(rs.getString("Watchman_Present"));
                obj.setName(rs.getString("Name"));
                obj.setGate(rs.getString("Gate"));
                obj.setPurpose(rs.getString("Purpose"));
                obj.setFlat(rs.getString("Flat"));
                obj.setVehicle(rs.getString("Vehicle_Num"));
                obj.setPhone(rs.getString("Phone"));
                obj.setDate(rs.getString("Date"));
                obj.setEntrytime(rs.getString("Entry_Time"));
                obj.setExittime(rs.getString("Exit_Time"));
                entries.add(obj);
            }
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return entries;
    }
    public ArrayList<EntryObject> viewEntriesByPhone(String phno)
    {
        ArrayList<EntryObject> entries=new ArrayList<EntryObject>();
        try 
        {
            Databaseconn c=new Databaseconn();
            ResultSet rs = c.s.executeQuery("select * from entries where Phone='"+phno+"';");
            while(rs.next()) 
            {
                EntryObject obj=new EntryObject();
                obj.setWatchman(rs.getString("Watchman_Present"));
                obj.setName(rs.getString("Name"));
                obj.setGate(rs.getString("Gate"));
                obj.setPurpose(rs.getString("Purpose"));
                obj.setFlat(rs.getString("Flat"));
                obj.setVehicle(rs.getString("Vehicle_Num"));
                obj.setPhone(rs.getString("Phone"));
                obj.setDate(rs.getString("Date"));
                obj.setEntrytime(rs.getString("Entry_Time"));
                obj.setExittime(rs.getString("Exit_Time"));
                entries.add(obj);
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
    public int gateLogin(String username,String password)
    {
        try
        {
            Databaseconn c = new Databaseconn();
            String q = "select * from login where username='"+username+"' and password='"+password+"'";
            ResultSet rs = c.s.executeQuery(q); 
            if(rs.next()){
                return 1;
            }else{
                return 0;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }
}

package gateinn;

import Databases.Databasec1;
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
            Databasec1 c=new Databasec1();
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
            Databasec1 c=new Databasec1();
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
            Databasec1 c=new Databasec1();
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
            Databasec1 c=new Databasec1();
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
            Databasec1 c = new Databasec1();
            String q = "select * from gate_login where username='"+username+"' and password='"+password+"'";
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
    
    public int checkKeyID(String id)
    {
        int k=0;
        try
        {
            Databasec1 c=new Databasec1();
            String str = "select * from gate_login where KEYID ='"+id+"';";
            ResultSet rs = c.s.executeQuery(str);
            if(rs.next())
            {
                String keyid = rs.getString(3);
                System.out.println(keyid+"  "+id);
                if(keyid.equals(id))
                    k=1;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return k;
    }
    
    public void changePassword(String newpassword,String confirmpassword,String newkeyid)
    {
        String displayid=newkeyid;
        try
        {
            Databasec1 c=new Databasec1();
            if(newpassword.equals(confirmpassword))
            {
                String str1="update gate_login set PASSWORD='"+newpassword+"',KEYID= '"+newkeyid+"';";
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"PASSWORD CHANGED SUCCESSFULLY AND NEW KEYID = "+displayid);
                GateinnLogin l=new GateinnLogin();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"NEW PASSWORD DOES NOT MATCH");
                ResetPassword fp=new ResetPassword();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public boolean checkForExitTime(String name,String phone,String date,String entryTime)
    {
        boolean k=false;
        try
        {
            Databasec1 c=new Databasec1();
            String q="select * from entries where name='"+name+"' and phone='"+phone+"' and date='"+date+"' and Entry_Time='"+entryTime+"' and Exit_Time=' ';";
            ResultSet rs = c.s.executeQuery(q);
            if(rs.next())
            {
                if(rs.getString(1).equals(name) && rs.getString(3).equals(phone) && rs.getString(6).equals(entryTime) && rs.getString(5).equals(date))
                {
                    k=true;
                    
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return k;
    }
    
    public void addExitTime(String name,String phone,String date,String entryTime,String exitTime)
    {
        try
        {
            String s=exitTime.substring(1,exitTime.length());
            Databasec1 c = new Databasec1();
            String str = "update entries set Exit_Time='"+exitTime+"' where Name='"+name+"' and Entry_Time='"+entryTime+"' and Phone='"+phone+"'and Date='"+date+"';";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"SUCCESSFULLY UPDATED");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

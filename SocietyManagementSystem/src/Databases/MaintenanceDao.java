package Databases;

import Maintenance.Maintenance;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaintenanceDao {

    public ArrayList<Maintenance> maintainanceDetails() 
    {
        ArrayList<Maintenance> maintainanceDetails = new ArrayList<Maintenance>();
        try {
            Databasec1 c = new Databasec1();
            ResultSet rs = c.s.executeQuery("SELECT * FROM MAINTAINANCE;");
            while (rs.next()) {
                Maintenance obj = new Maintenance();
                obj.setName(rs.getString("NAME"));
                obj.setFlat(rs.getString("FLAT"));
                maintainanceDetails.add(obj);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return maintainanceDetails;
    }
    
    public boolean isPresent(String building,String flat)
    {
        boolean k=false;
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from residents where BUILDING_NUMBER= '"+building+"' and FLAT_NUMBER= '"+flat+"';");
            while(rs.next())
            {
                k=true;
                break;
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Invalid SQLException");
            ex.printStackTrace();
        }
        return k;
    }
    
    public String returnName(String building,String flat)
    {
        String name="";
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from residents where BUILDING_NUMBER= '"+building+"' AND FLAT_NUMBER= '"+flat+"';");
            while(rs.next())
            {
                name=rs.getString("NAME");
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Invalid SQLException");
            ex.printStackTrace();
        }
        return name;
    }
    public int getVehicleCount(String building,String flat)
    {
        int count=0;
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from parking where FLAT= '"+building+" "+flat+"';");
            while(rs.next())
            {
                count++;
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Invalid SQLException");
            ex.printStackTrace();
        }
        return count;
    }
}

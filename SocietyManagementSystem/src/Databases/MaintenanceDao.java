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
            ResultSet rs = c.s.executeQuery("SELECT * FROM MAINTENANCE;");
            while (rs.next()) {
                Maintenance obj = new Maintenance();
                obj.setName(rs.getString("NAME"));
                obj.setBuilding(rs.getString("BUILDING_NUMBER"));
                obj.setFlat(rs.getString("FLAT_NUMBER"));
                obj.setPreviousDueAmount(rs.getString("BILL_AMOUNT"));
                obj.setCurrentBillAmount(rs.getString("ARREARS"));
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
    
    public double getArrears(String building,String flat)
    {
        double arrears=0;
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("SELECT * FROM MAINTENANCE WHERE BUILDING_NUMBER= '"+building+"' AND FLAT_NUMBER= '"+flat+"';");
            while(rs.next())
            {
                arrears=Double.parseDouble(rs.getString("ARREARS"));
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Invalid SQLException");
            ex.printStackTrace();
        }
        return arrears;
    }
    
    public void addAmount(String building,String flat,double amount)
    {
        double dueAmount=0,arrears=0;
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("SELECT * FROM MAINTENANCE WHERE BUILDING_NUMBER= '"+building+"' AND FLAT_NUMBER= '"+flat+"';");
            while(rs.next())
            {
                dueAmount=Double.parseDouble(rs.getString("BILL_AMOUNT"));
                arrears=dueAmount;
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Invalid SQLException");
            ex.printStackTrace();
        }    
        try
        {
            Databasec1 c=new Databasec1();
            c.s.executeUpdate("UPDATE MAINTENANCE SET BILL_AMOUNT= "+amount+", ARREARS= "+(dueAmount+arrears)+" WHERE BUILDING_NUMBER= '"+building+"' AND FLAT_NUMBER= '"+flat+"';");
            JOptionPane.showMessageDialog(null,"THE AMOUNT HAS BEEN UPDATED TO THE DATABASE");
        }
        catch (SQLException ex) 
        {
            System.out.println("Invalid SQLException");
            JOptionPane.showMessageDialog(null,"AMOUNT UPDATE FAILED!");
            ex.printStackTrace();
        } 
    }
    
    public void payAmount(String building,String flat,double amount)
    {
        double dueAmount=0,arrears=0;
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("SELECT * FROM MAINTENANCE WHERE BUILDING_NUMBER= '"+building+"' AND FLAT_NUMBER= '"+flat+"';");
            while(rs.next())
            {
                dueAmount=Double.parseDouble(rs.getString("BILL_AMOUNT"));
                arrears=Double.parseDouble(rs.getString("ARREARS"));
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Invalid SQLException");
            ex.printStackTrace();
        }  
        if(arrears>0)
        {
            arrears=arrears-amount;
            if(arrears<=0)
            {
                
                amount=arrears*-1;
                arrears=0;
            }
        }
        System.out.println(dueAmount+" "+arrears+" "+amount);
        if(arrears==0&&amount>0)
        {
            dueAmount-=amount;
        }
        System.out.println(dueAmount+" "+arrears+" "+amount);
        try
        {
            Databasec1 c=new Databasec1();
            c.s.executeUpdate("UPDATE MAINTENANCE SET BILL_AMOUNT= "+dueAmount+", ARREARS= "+(arrears)+" WHERE BUILDING_NUMBER= '"+building+"' AND FLAT_NUMBER= '"+flat+"';");
            JOptionPane.showMessageDialog(null,"THE AMOUNT HAS BEEN UPDATED TO THE DATABASE");
        }
        catch (SQLException ex) 
        {
            System.out.println("Invalid SQLException");
            JOptionPane.showMessageDialog(null,"AMOUNT UPDATION FAILED!");
            ex.printStackTrace();
        }         
    }
}

package Databases;

import Parking.Parking;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ParkingDao 
{
    public boolean checkReservedParking(int spot) 
    {
        boolean k=false;
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from parking where PARKING_SPOT= "+spot+";");
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
    public void assignParkingToResident(Parking parking)
    {
        try
        {
            Databasec1 c=new Databasec1();
            String q="INSERT INTO PARKING (NAME, FLAT, VEHICLE_NUMBER, VEHICLE_TYPE, PARKING_SPOT) VALUES ('"+parking.getName()+"', "+"'"+parking.getFlat()+"', "+"'"+parking.getVehicleNum()+"', "+"'"+parking.getVehicleType()+"', "+"'"+parking.getParkingSpot()+"');";
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "PARKING "+parking.getParkingSpot()+" ASSIGNED TO "+parking.getName());
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Parking Reserved/Assignment Unsuccessful");
        }
    }
    public ArrayList<Parking> parkingDetails()
    {
        ArrayList<Parking> parkingDetails=new ArrayList<Parking>();
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("SELECT * FROM PARKING;");
            while(rs.next()) 
            {
                Parking obj=new Parking();
                obj.setName(rs.getString("NAME"));
                obj.setFlat(rs.getString("FLAT"));
                obj.setVehicleNum(rs.getString("VEHICLE_NUMBER"));
                obj.setParkingSpot(rs.getString("PARKING_SPOT"));
                obj.setVehicleType(rs.getString("VEHICLE_TYPE"));             
                if(rs.getString("VEHICLE_TYPE").equals("FOUR WHEELER"))
                    parkingDetails.add(obj);
            }
            rs = c.s.executeQuery("SELECT * FROM PARKING;");
            while(rs.next()) 
            {
                Parking obj=new Parking();
                obj.setName(rs.getString("NAME"));
                obj.setFlat(rs.getString("FLAT"));
                obj.setVehicleNum(rs.getString("VEHICLE_NUMBER"));
                obj.setParkingSpot(rs.getString("PARKING_SPOT"));
                obj.setVehicleType(rs.getString("VEHICLE_TYPE"));             
                if(rs.getString("VEHICLE_TYPE").equals("TWO WHEELER"))
                    parkingDetails.add(obj);
            }
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return parkingDetails;
    }
    public void resetParking(String password)
    {
        boolean k=false;
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("SELECT * FROM ADMINLOGIN WHERE PASSWORD= '"+password+"';");
            while(rs.next()) 
            {
                k=true;
                break;
            }
            if(k)
            {
                String q="DELETE FROM PARKING";
                c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "PARKING DETAILS RESET SUCCESSFUL!");
            }
        }
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
}

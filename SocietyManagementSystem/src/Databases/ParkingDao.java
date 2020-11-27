package Databases;

import Parking.Parking;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ParkingDao 
{
    public boolean checkReservedParking(int spot) 
    {
        boolean k=false;
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from parking where PARKING_SPOT= '"+spot+"';");
            if(rs.next())
            {
                k=true;
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println("Invalid SQLException");
        }
        return k;
    }
    public void assignParkingToResident(Parking parking)
    {
        try
        {
            Databasec1 c=new Databasec1();
            String q="INSERT INTO PARKING VALUES (NAME= '"+parking.getName()+"', FLAT='"+parking.getFlat()+"', VEHICLE_NUM='"+parking.getVehicleNum()+"', VEHICLE_TYPE='"+parking.getVehicleType()+"', PARKING_SPOT='"+parking.getParkingSpot()+"';";
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Parking Successfully Assigned");
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"Parking Reserved/Assignment Unsuccessful");
        }
    }
}

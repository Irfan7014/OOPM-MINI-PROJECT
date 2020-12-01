package Databases;
import Residents.AddResidents;
import Residents.Residents;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class ResidentsDao 
{
    public void addResidents(Residents resident)
    {
        try
        {
            Databasec1 c=new Databasec1();
            String q="INSERT INTO RESIDENTS (NAME, BUILDING_NUMBER, FLAT_NUMBER, DOB, OCCUPATION, ARRIVAL_YEAR, TOTAL_FAMILY_MEMBERS, MARITAL_STATUS, RENT_OWNER) VALUES "
                    + "('"+resident.getName()+"', '"+resident.getBuildingNum()+"', '"+resident.getFlatNum()+"', '"+resident.getDOB()+"', '"+resident.getOccupation()+"', "+resident.getYearOfArrival()+", "
                    +resident.getTotalMembers()+", '"+resident.getMaritalStatus()+"', '"+resident.getRentOrOwner()+"');";
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "RESIDENT ADDED!");
            new AddResidents();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ADDING RESIDENT TO THE DATABASE FAILED");
        }        
    }
    
    public boolean checkResident(Residents resident)
    {
        boolean k=false;
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from residents where BUILDING_NUMBER= '"+resident.getBuildingNum()+"' and FLAT_NUMBER= '"+resident.getFlatNum()+"';");
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
    
    public Residents findDetailsAboutResident(String Building,String Flat)
    {
        Residents resident = new Residents();
        try
        {
            Databasec1 c=new Databasec1();
            ResultSet rs=c.s.executeQuery("SELECT * FROM RESIDENTS WHERE BUILDING_NUMBER= '"+Building+"' AND FLAT_NUMBER= '"+Flat+"';");
            while(rs.next())
            {
                resident.setName(rs.getString("NAME"));
                resident.setBuildingNum(rs.getString("BUILDING_NUMBER"));
                resident.setFlatNum(rs.getString("FLAT_NUMBER"));
                resident.setDOB(rs.getString("DOB"));
                resident.setOccupation(rs.getString("OCCUPATION"));
                resident.setYearOfArrival(Integer.parseInt(rs.getString("ARRIVAL_YEAR")));
                resident.setTotalMembers(Integer.parseInt(rs.getString("TOTAL_FAMILY_MEMBERS")));
                resident.setMaritalStatus(rs.getString("MARITAL_STATUS"));
                resident.setRentOrOwner(rs.getString("RENT_OWNER"));
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return resident;
    }
    public void updateResidentDetails(Residents resident)
    {
        try
        {
            Databasec1 c=new Databasec1();
            String q="UPDATE RESIDENTS SET NAME= '"+resident.getName()+"', BUILDING_NUMBER= '"+resident.getBuildingNum()+"', FLAT_NUMBER= '"+resident.getFlatNum()+"', DOB= '"+resident.getDOB()+"', OCCUPATION= '"+resident.getOccupation()+"', ARRIVAL_YEAR= "+resident.getYearOfArrival()+
                    ", TOTAL_FAMILY_MEMBERS= "+resident.getTotalMembers()+", MARITAL_STATUS= '"+resident.getMaritalStatus()+"', RENT_OWNER= '"+resident.getRentOrOwner()+"' WHERE BUILDING_NUMBER= '"+resident.getBuildingNum()+"' AND FLAT_NUMBER= '"+resident.getFlatNum()+"';";
            System.out.println(q);
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "RESIDENT DETAILS UPDATED!");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"UPDATE FAILED");
        }                
    }
    
    public ArrayList<Residents> residentDetails()
    {
        ArrayList<Residents> residentDetails=new ArrayList<Residents>();
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("SELECT * FROM RESIDENTS;");
            while(rs.next()) 
            {
                Residents obj=new Residents();
                obj.setName(rs.getString("NAME"));
                obj.setBuildingNum(rs.getString("BUILDING_NUMBER"));
                obj.setFlatNum(rs.getString("FLAT_NUMBER"));
                obj.setDOB(rs.getString("DOB"));
                obj.setOccupation(rs.getString("OCCUPATION"));
                obj.setYearOfArrival(Integer.parseInt(rs.getString("ARRIVAL_YEAR")));
                obj.setTotalMembers(Integer.parseInt(rs.getString("TOTAL_FAMILY_MEMBERS")));
                obj.setMaritalStatus(rs.getString("MARITAL_STATUS"));
                obj.setRentOrOwner(rs.getString("RENT_OWNER"));
                residentDetails.add(obj);
            }
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return residentDetails;
    }    
}

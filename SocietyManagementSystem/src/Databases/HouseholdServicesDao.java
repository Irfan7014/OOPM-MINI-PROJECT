package Databases;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class HouseholdServicesDao 
{
    public ArrayList<String> showHouseholdServicesName()
    {
        ArrayList<String> services=new ArrayList<String>();
        try
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from services;");
            while(rs.next())
            {
                if(rs.getString("SERVICE").equals("ELECTRICIAN"))
                {
                    services.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("PLUMBER"))
                {
                    services.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("PAINTER"))
                {
                    services.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("BABY SITTER"))
                {
                    services.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("LAUNDARY"))
                {
                    services.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("TUTOR"))
                {
                    services.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("CARPENTER"))
                {
                    services.add(rs.getString("NAME"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("MAID"))
                {
                    services.add(rs.getString("NAME"));
                    continue;
                }
            }
        }
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return services;
    }
    public ArrayList<String> showHouseholdServicesContact()
    {
        ArrayList<String> services=new ArrayList<String>();
        try
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from services;");
            while(rs.next())
            {
                if(rs.getString("SERVICE").equals("ELECTRICIAN"))
                {
                    services.add(rs.getString("CONTACT"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("PLUMBER"))
                {
                    services.add(rs.getString("CONTACT"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("PAINTER"))
                {
                    services.add(rs.getString("CONTACT"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("BABY SITTER"))
                {
                    services.add(rs.getString("CONTACT"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("LAUNDARY"))
                {
                    services.add(rs.getString("CONTACT"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("TUTOR"))
                {
                    services.add(rs.getString("CONTACT"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("CARPENTER"))
                {
                    services.add(rs.getString("CONTACT"));
                    continue;
                }
                if(rs.getString("SERVICE").equals("MAID"))
                {
                    services.add(rs.getString("CONTACT"));
                    continue;
                }
            }
        }
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return services;
    }
}

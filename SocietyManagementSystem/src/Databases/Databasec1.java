package Databases;
import java.sql.*;
public class Databasec1 
{
    public Connection c;
    public Statement s;
    public Databasec1()
    {  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///society","root","");    
            s =c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("SQLException");
            e.printStackTrace();
        }
    }
}

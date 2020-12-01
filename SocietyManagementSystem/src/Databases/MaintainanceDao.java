package Databases;

import Maintainance.Maintainance;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MaintainanceDao {

    public ArrayList<Maintainance> maintainanceDetails() {
        ArrayList<Maintainance> maintainanceDetails = new ArrayList<Maintainance>();
        try {
            Databasec1 c = new Databasec1();
            ResultSet rs = c.s.executeQuery("SELECT * FROM MAINTAINANCE;");
            while (rs.next()) {
                Maintainance obj = new Maintainance();
                obj.setName(rs.getString("NAME"));
                obj.setFlat(rs.getString("FLAT"));
                maintainanceDetails.add(obj);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return maintainanceDetails;
    }
}

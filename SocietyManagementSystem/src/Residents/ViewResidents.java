package Residents;

import Databases.ResidentsDao;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import societymanagementsystem.MainPage;

public class ViewResidents 
{
    JFrame jf,frame;
    JButton bcancel;
    JPanel contentPane;
    String column_names[]={"NAME","BUILDING NUMBER","FLAT NUMBER","DATE OF BIRTH","OCCUPATION","YEAR OF ARRIVAL","TOTAL FAMILY MEMBERS","MARITAL STATUS","RENTED/OWNER"};
    JTable table;
    public ViewResidents()
    {
        frame = new JFrame("Database Search Result");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocation(50, 50);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column_names);
        table = new JTable();
        table.getTableHeader().setFont(new Font("serif", Font.PLAIN, 20));
        table.setFont(new Font("serif", Font.PLAIN, 20));
        table.setRowHeight(25);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ResidentsDao residentDao=new ResidentsDao();
        ArrayList<Residents> resident_details=residentDao.residentDetails();
        try{
            for(Residents details:resident_details)
            {
                model.addRow(new Object[]{details.getName(),details.getBuildingNum(),details.getFlatNum(),details.getDOB(),details.getOccupation(),details.getYearOfArrival(),details.getTotalMembers(),details.getMaritalStatus(),details.getRentOrOwner()});
            }
            frame.add(scroll);
            frame.setResizable(false);
            frame.setSize(1825,350); 
            new MainPage();
            frame.setVisible(true);
        }
        catch(Exception e)
        {
            jf.dispose();
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
        int[] columnsWidth = {
            260, 260, 175, 175, 175, 175, 250, 175, 175
        };
        int i = 0;
        for (int width : columnsWidth) {
            TableColumn column = table.getColumnModel().getColumn(i++);
            column.setMinWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }
    }
    public ViewResidents(String ss)
    {
        frame = new JFrame("Database Search Result");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocation(50, 50);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column_names);
        table = new JTable();
        table.getTableHeader().setFont(new Font("serif", Font.PLAIN, 20));
        table.setFont(new Font("serif", Font.PLAIN, 20));
        table.setRowHeight(25);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ResidentsDao residentDao=new ResidentsDao();
        ArrayList<Residents> resident_details=residentDao.residentDetails();
        try{
            for(Residents details:resident_details)
            {
                model.addRow(new Object[]{details.getName(),details.getBuildingNum(),details.getFlatNum(),details.getDOB(),details.getOccupation(),details.getYearOfArrival(),details.getTotalMembers(),details.getMaritalStatus(),details.getRentOrOwner()});
            }
            frame.add(scroll);
            frame.setResizable(false);
            frame.setSize(1825,350);
            frame.setVisible(true);
        }
        catch(Exception e)
        {
            jf.dispose();
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
        int[] columnsWidth = {
            260, 260, 175, 175, 175, 175, 250, 175, 175
        };
        int i = 0;
        for (int width : columnsWidth) {
            TableColumn column = table.getColumnModel().getColumn(i++);
            column.setMinWidth(width);
            column.setMaxWidth(width);
            column.setPreferredWidth(width);
        }        
    }
    public static void main(String args[])
    {
        new ViewResidents();
    }
}

package Maintenance;

import Databases.MaintenanceDao;
import societymanagementsystem.MainPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewMaintenance {
    JFrame jf, frame;
    JButton bcancel;
    JPanel contentPane;
    String column_names[]={"OWNER", "FLAT"};
    JTable table;
    public ViewMaintenance() {
        frame = new JFrame("Database Search Result");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocation(50, 50);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column_names);
        table = new JTable();
        table.setFont(new Font("serif", Font.PLAIN, 20));
        table.setRowHeight(25);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        MaintenanceDao maintainanceDao = new MaintenanceDao();
        ArrayList<Maintenance> maintainance_details = maintainanceDao.maintainanceDetails();
        try{
            for(Maintenance details: maintainance_details) {
                model.addRow(new Object[]{details.getName(), details.getFlat()});
            }
            frame.add(scroll);
            frame.setResizable(false);
            frame.setSize(1160, 350);
            new MainPage();
            frame.setVisible(true);
        } catch (Exception e){
            jf.dispose();
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String args[]) {
        new ViewMaintenance();
    }
}

package ResidentView;

import Databases.ParkingDao;
import Parking.Parking;
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

public class ViewParkingByResidents 
{
    JFrame jf,frame;
    JButton bcancel;
    JPanel contentPane;
    String column_names[]={"OWNER","FLAT","VEHICLE NUMBER","PARKING SPOT","VEHICLE TYPE"};
    JTable table;
    public ViewParkingByResidents()
    {
        String column_names[]={"OWNER","FLAT","VEHICLE NUMBER","PARKING SPOT","VEHICLE TYPE"};
        JFrame frame = new JFrame("Database Search Result");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocation(100,100);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column_names);
        JTable table = new JTable();
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
        ParkingDao parkingDao=new ParkingDao();
        ArrayList<Parking> parking_details=parkingDao.parkingDetails();
        try{
            for(Parking details:parking_details)
            {
                model.addRow(new Object[]{details.getName(),details.getFlat(),details.getVehicleNum(),details.getParkingSpot(),details.getVehicleType()});
            }
            frame.add(scroll);
            frame.setResizable(false);
            frame.setSize(1160,350); 
            frame.setVisible(true);
        }
        catch(Exception e)
        {
            jf.dispose();
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

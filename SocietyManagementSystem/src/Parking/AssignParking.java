package Parking;
import Databases.ParkingDao;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import societymanagementsystem.MainPage;
public class AssignParking implements ActionListener
{
    JFrame jf;
    JLabel lbltitle, lblowner, lblvehicletype, lblflat, lblparkingspotno, lblvehicleno;   //Created Labels
    JTextField towner, tflat, tparkingspotno, tvehicleno;                  //Created TextFields
    JButton bback,bAssignParking,breset,bview;
    JComboBox tvehicletype;
    public AssignParking()
    {
        //Frame Details
        jf=new JFrame("ASSIGN PARKING");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(200, 200);
        jf.setSize(700, 450);

        //Label and TextField Details
        //Title
        lbltitle = new JLabel("ASSIGN PARKING");
        lbltitle.setBounds(20, 0, 400, 50);
        lbltitle.setFont(new Font("serif", Font.ITALIC, 36));
        lbltitle.setForeground(Color.BLUE);
        jf.add(lbltitle);

        //1.Owner
        lblowner = new JLabel("NAME OF OWNER :- ");
        lblowner.setBounds(20, 100, 200, 30);
        lblowner.setFont(new Font("Times_New_Roman", Font.PLAIN, 20));
        lblowner.setForeground(Color.BLACK);
        jf.add(lblowner);

        towner = new JTextField();
        towner.setBounds(320, 100, 240, 30);
        towner.setFont(new Font("serif", Font.PLAIN, 25));
        towner.setForeground(Color.BLACK);
        jf.add(towner);

        //2.Area
        lblflat = new JLabel("FLAT NO. :- ");
        lblflat.setBounds(20, 150, 200, 30);
        lblflat.setFont(new Font("Times_New_Roman", Font.PLAIN, 20));
        lblflat.setForeground(Color.BLACK);
        jf.add(lblflat);

        tflat = new JTextField();
        tflat.setBounds(320, 150, 240, 30);
        tflat.setFont(new Font("serif", Font.PLAIN, 25));
        tflat.setForeground(Color.BLACK);
        jf.add(tflat);
        
        //3. Number Plate
        lblvehicleno = new JLabel("VEHICLE NUMBER :- ");
        lblvehicleno.setBounds(20, 200, 200, 30);
        lblvehicleno.setFont(new Font("Times_Now_Roman", Font.PLAIN, 20));
        lblvehicleno.setForeground(Color.BLACK);
        jf.add(lblvehicleno);

        tvehicleno = new JTextField();
        tvehicleno.setBounds(320, 200, 240, 30);
        tvehicleno.setFont(new Font("serif", Font.PLAIN, 25));
        tvehicleno.setForeground(Color.BLACK);
        jf.add(tvehicleno);
        
        //4. Parking Spot Number
        lblparkingspotno = new JLabel("PARKING SPOT NO :- ");
        lblparkingspotno.setBounds(20, 250, 250, 30);
        lblparkingspotno.setFont(new Font("Times_Now_Roman", Font.PLAIN, 20));
        lblparkingspotno.setForeground(Color.BLACK);
        jf.add(lblparkingspotno);

        tparkingspotno = new JTextField();
        tparkingspotno.setBounds(320, 250, 240, 30);
        tparkingspotno.setFont(new Font("serif", Font.PLAIN, 25));
        tparkingspotno.setForeground(Color.BLACK);
        jf.add(tparkingspotno);

        //5.Vehicle Type
        lblvehicletype= new JLabel("VEHICLE TYPE :- ");
        lblvehicletype.setBounds(20, 300, 250, 30);     
        lblvehicletype.setFont(new Font("Times_New_Roman", Font.PLAIN, 20));
        lblvehicletype.setForeground(Color.BLACK);
        jf.add(lblvehicletype);
        
        String type[]={"FOUR WHEELER","TWO WHEELER"};
        tvehicletype = new JComboBox(type);
        tvehicletype.setBounds(320, 300, 240, 30);    
        tvehicletype.setFont(new Font("serif", Font.PLAIN, 25));
        tvehicletype.setForeground(Color.BLACK);
        tvehicletype.setSelectedIndex(0);
        jf.add(tvehicletype);
        
        //Reset all Parking
        breset=new JButton("RESET ALL PARKING DETAILS");
        breset.setBounds(350,10,330,30);
        breset.setBackground(Color.RED);
        breset.setForeground(Color.WHITE);
        breset.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,18));
        breset.addActionListener(this);
        jf.add(breset);

        //Assign Parking Button
        bAssignParking=new JButton("ASSIGN PARKING");
        bAssignParking.setBounds(65,350,200,30);
        bAssignParking.setBackground(Color.BLACK);
        bAssignParking.setForeground(Color.WHITE);
        bAssignParking.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        bAssignParking.addActionListener(this);
        jf.add(bAssignParking);
        
        //Cancel Button
        bback=new JButton("BACK");
        bback.setBounds(535,350,100,30);
        bback.setBackground(Color.BLACK);
        bback.setForeground(Color.WHITE);
        bback.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        bback.addActionListener(this);
        jf.add(bback);
        
        //View Button
        bview=new JButton("VIEW PARKING DETAILS");
        bview.setBounds(285,350,230,30);
        bview.setBackground(Color.BLACK);
        bview.setForeground(Color.WHITE);
        bview.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        bview.addActionListener(this);
        jf.add(bview);
        
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bback)
        {
            jf.dispose();
            new MainPage();
        }
        if(ae.getSource()==bAssignParking)
        {
            
            jf.dispose();
            Parking parking=new Parking();
            parking.setFlat(tflat.getText());
            parking.setName(towner.getText());
            parking.setVehicleNum(tvehicleno.getText());
            parking.setParkingSpot(tparkingspotno.getText());
            parking.setVehicleType(tvehicletype.getSelectedItem().toString());
            ParkingDao parkingdao=new ParkingDao();
            boolean check=parkingdao.checkReservedParking(Integer.parseInt(tparkingspotno.getText()));
            System.out.println(check);
            if(!check)
            {
                parkingdao.assignParkingToResident(parking);
                new AssignParking();
            }
            else
            {
                jf.dispose();
                JOptionPane.showMessageDialog(null,"The Parking Is Already Reserved");
                new AssignParking();
            }
        } 
        if(ae.getSource()==breset)
        {
            String answer = JOptionPane.showInputDialog(null, "PLEASE ENTER THE PASSWORD TO CONFIRM!", "Input", JOptionPane.QUESTION_MESSAGE);
            jf.dispose();
            ParkingDao parkingDao=new ParkingDao();
            parkingDao.resetParking(answer);
            new AssignParking();
        }
        if(ae.getSource()==bview)
        {
            new ViewParking(" ");
        }
    }
    public static void main(String args[])
    {
        AssignParking ap=new AssignParking();
    }
}

package Parking;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import societymanagementsystem.MainPage;
public class AssignParking implements ActionListener
{
    JFrame jf;
    JLabel lbltitle, lblowner, lblflat, lblvehicletype, lblparkingspotno, lblvehicleno;   //Created Labels
    JTextField towner, tflat, tvehicletype, tparkingspotno, tvehicleno;                  //Created TextFields
    JButton bcancel,bAssignParking;
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
        towner.setFont(new Font("serif", Font.PLAIN, 20));
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
        tflat.setFont(new Font("serif", Font.PLAIN, 20));
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
        tvehicleno.setFont(new Font("serif", Font.PLAIN, 20));
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
        tparkingspotno.setFont(new Font("serif", Font.PLAIN, 20));
        tparkingspotno.setForeground(Color.BLACK);
        jf.add(tparkingspotno);

        //5.Vehicle Type
        lblvehicletype= new JLabel("VEHICLE TYPE :- ");
        lblvehicletype.setBounds(20, 300, 250, 30);     
        lblvehicletype.setFont(new Font("Times_New_Roman", Font.PLAIN, 20));
        lblvehicletype.setForeground(Color.BLACK);
        jf.add(lblvehicletype);

        tvehicletype = new JTextField();
        tvehicletype.setBounds(320, 300, 240, 30);    
        tvehicletype.setFont(new Font("serif", Font.PLAIN, 20));
        tvehicletype.setForeground(Color.BLACK);
        jf.add(tvehicletype);

        //Assign Parking Button
        bAssignParking=new JButton("ASSIGN PARKING");
        bAssignParking.setBounds(165,350,200,30);
        bAssignParking.setBackground(Color.BLACK);
        bAssignParking.setForeground(Color.WHITE);
        bAssignParking.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        bAssignParking.addActionListener(this);
        jf.add(bAssignParking);
        
        //Cancel Button
        bcancel=new JButton("CANCEL");
        bcancel.setBounds(405,350,130,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        bcancel.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        bcancel.addActionListener(this);
        jf.add(bcancel);
        
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bcancel)
        {
            jf.dispose();
            MainPage mp=new MainPage();
        }
        if(ae.getSource()==bAssignParking)
        {
            jf.dispose();
            JOptionPane.showMessageDialog(jf, "PARKING "+tparkingspotno.getText()+" ASSIGNED TO "+towner.getText());
            new AssignParking();
        }
        
    }
    public static void main(String args[])
    {
        AssignParking ap=new AssignParking();
    }
}

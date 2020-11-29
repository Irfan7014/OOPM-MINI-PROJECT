package Parking;

import Databases.ParkingDao;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class VacateParking  implements ActionListener
{
    JFrame jf;
    JLabel lblParkingSpot,lblName,lblFlat,lblVehicleNum,lblVehicleType;
    JButton bFind,bBack,bVacate;
    JTextField tParkingSpot;
    JLabel ansName,ansFlat,ansVehicleNum,ansVehicleType;
    public VacateParking()
    {
        //Frame Details
        jf=new JFrame("VACATE PARKING SPACE");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setBackground(Color.green);
        jf.setLayout(null);

        //ParkingSpot JLabel 
        lblParkingSpot=new JLabel("ENTER PARKING SPOT:");
        lblParkingSpot.setVisible(true);
        lblParkingSpot.setBounds(30,30,270,35);
        lblParkingSpot.setForeground(Color.BLACK);
        lblParkingSpot.setFont(new Font("serif",Font.BOLD,22)); 
        jf.add(lblParkingSpot);

        //Parking Spot Text Field
        tParkingSpot=new JTextField();
        tParkingSpot.setBounds(295,30,220,35);
        tParkingSpot.setFont(new Font("sans-serif",Font.BOLD,20));
        jf.add(tParkingSpot); 
        
        //JButton For Vacate
        bFind=new JButton("FIND DETAILS");
        bFind.setBounds(150,85,170,35);
        bFind.setBackground(Color.BLACK);
        bFind.setForeground(Color.WHITE);
        bFind.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        jf.add(bFind);
        
        //JButton for Back
        bBack=new JButton("BACK");
        bBack.setBounds(360,85,120,35);
        bBack.setBackground(Color.BLACK);
        bBack.setForeground(Color.WHITE);
        bBack.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        jf.add(bBack);
        
        //JButton for VACATE
        bVacate=new JButton("VACATE");
        bVacate.setBounds(290,400,120,35);
        bVacate.setBackground(Color.BLACK);
        bVacate.setForeground(Color.WHITE);
        bVacate.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        jf.add(bVacate);
        
        //**********************************************
        //Name JLabel
        lblName=new JLabel("NAME: ");
        lblName.setVisible(true);
        lblName.setBounds(30,150,250,35);
        lblName.setForeground(Color.BLACK);
        lblName.setFont(new Font("serif",Font.BOLD,25));
        jf.add(lblName);

        //Show Name
        ansName=new JLabel();
        ansName.setVisible(true);
        ansName.setBounds(130,150,250,35);
        ansName.setForeground(Color.BLACK);
        ansName.setFont(new Font("serif",Font.BOLD,25)); 
        jf.add(ansName);
        
        //***********************************************
        //Flat JLabel
        lblFlat=new JLabel("FLAT: ");
        lblFlat.setVisible(true);
        lblFlat.setBounds(30,210,250,35);
        lblFlat.setForeground(Color.BLACK);
        lblFlat.setFont(new Font("serif",Font.BOLD,25));
        jf.add(lblFlat);

        //Show Flat
        ansFlat=new JLabel();
        ansFlat.setVisible(true);
        ansFlat.setBounds(130,210,250,35);
        ansFlat.setForeground(Color.BLACK);
        ansFlat.setFont(new Font("serif",Font.BOLD,25)); 
        jf.add(ansFlat);
        
        //*************************************************
        //Vehicle_Number JLabel
        lblVehicleNum=new JLabel("VEHICLE NUMBER: ");
        lblVehicleNum.setVisible(true);
        lblVehicleNum.setBounds(30,275,250,35);
        lblVehicleNum.setForeground(Color.BLACK);
        lblVehicleNum.setFont(new Font("serif",Font.BOLD,25));
        jf.add(lblVehicleNum);

        //Show Vehicle Number
        ansVehicleNum=new JLabel();
        ansVehicleNum.setVisible(true);
        ansVehicleNum.setBounds(280,275,250,35);
        ansVehicleNum.setForeground(Color.BLACK);
        ansVehicleNum.setFont(new Font("serif",Font.BOLD,25)); 
        jf.add(ansVehicleNum);
        
        //**************************************************
        //Vehicle Type JLabel
        lblVehicleType=new JLabel("VEHICLE TYPE: ");
        lblVehicleType.setVisible(true);
        lblVehicleType.setBounds(30,340,250,35);
        lblVehicleType.setForeground(Color.BLACK);
        lblVehicleType.setFont(new Font("serif",Font.BOLD,25));
        jf.add(lblVehicleType);

        //Show Vehicle Type
        ansVehicleType=new JLabel();
        ansVehicleType.setVisible(true);
        ansVehicleType.setBounds(240,340,250,35);
        ansVehicleType.setForeground(Color.BLACK);
        ansVehicleType.setFont(new Font("serif",Font.BOLD,25)); 
        jf.add(ansVehicleType);
        
        bFind.addActionListener(this);
        bBack.addActionListener(this);
        bVacate.addActionListener(this);
        
        lblName.setVisible(false);
        ansName.setVisible(false);
        lblFlat.setVisible(false);
        ansFlat.setVisible(false);
        lblVehicleNum.setVisible(false);
        ansVehicleNum.setVisible(false);
        lblVehicleType.setVisible(false);
        ansVehicleType.setVisible(false);
        bVacate.setVisible(false);
        
        jf.setSize(700,500);
        jf.setLocation(30,30);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bFind)
        {
            ParkingDao parkingDao=new ParkingDao();
            ArrayList<String> details=parkingDao.parkingDetails(Integer.parseInt(tParkingSpot.getText()));
            if(parkingDao.findParkingSpot(Integer.parseInt(tParkingSpot.getText())))
            {
                ansName.setText(details.get(0));
                ansFlat.setText(details.get(1));
                ansVehicleNum.setText(details.get(2));
                ansVehicleType.setText(details.get(3));
                
                lblName.setVisible(true);
                ansName.setVisible(true);
                lblFlat.setVisible(true);
                ansFlat.setVisible(true);
                lblVehicleNum.setVisible(true);
                ansVehicleNum.setVisible(true);
                lblVehicleType.setVisible(true);
                ansVehicleType.setVisible(true);
                bVacate.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "THE PARKING SPOT IS ALREADY VACANT");
            }
                
        }
        if(ae.getSource()==bVacate)
        {
            ParkingDao parkingDao=new ParkingDao();
            parkingDao.vacateParking(Integer.parseInt(tParkingSpot.getText()));
            jf.dispose();
        }
        if(ae.getSource()==bBack)
        {
            jf.dispose();
        }
    }
    public static void main(String args[])
    {
        new VacateParking();
    }
}

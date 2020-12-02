package Maintenance;
import Databases.MaintenanceDao;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import societymanagementsystem.MainPage;
public class CalculateMaintenance implements ActionListener
{
    JFrame jf;
    JButton btnBack,btnCalculate,btnUpdate,btnBack2,btnAdd;
    JLabel lblTitle,lblBuilding,lblFlat,lblName,lblDisplayName,lblVehicleNum,lblDisplayVehicleNum;
    JLabel lblServiceCharge,lblSinkingFund,lblParkingCharges,lblInsuranceCharges,lblRepairFund,lblInterest,lblArrears;
    JLabel DisplayServiceCharge,DisplaySinkingFund,DisplayParkingCharges,DisplayInsuranceCharges,DisplayRepairFund,DisplayInterest,DisplayArrears;
    JLabel lblAmount,DisplayAmount,lblBillDue,DisplayBillDue;
    JTextField tBuilding,tFlat;
    DecimalFormat df=new DecimalFormat("###.##");
    public final double serviceCharge=1554,sinkingFund=42,parkingCharge=200,insuranceCharge=15,repairFund=200,interestPercent=2.64;
    public double billAmount=0;
    public CalculateMaintenance()
    {
        //Frame Details
        jf=new JFrame("CALCULATE MAINTENANCE");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(800, 10);
        jf.setSize(700, 400);
        
        //Label and TextField Details
        //Title
        lblTitle = new JLabel("MAINTENANCE CALCULATOR");
        lblTitle.setBounds(20,0,450,50);
        lblTitle.setFont(new Font("SANS-SERIF",Font.BOLD,30));
        lblTitle.setForeground(Color.PINK);
        jf.add(lblTitle);
        
        //1.BUILDING NUMBER
        lblBuilding = new JLabel("BUILDING NUMBER:- ");
        lblBuilding.setBounds(40,100,250,30);
        lblBuilding.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblBuilding.setForeground(Color.BLUE);
        jf.add(lblBuilding);
        
        //2.FLAT NUMBER
        lblFlat = new JLabel("FLAT NUMBER:- ");
        lblFlat.setBounds(40,150,230,30);
        lblFlat.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblFlat.setForeground(Color.BLUE);
        jf.add(lblFlat);
        
        //TextField for Building and Flat Number
        tBuilding=new JTextField();
        tBuilding.setBounds(320,100,280,35);
        tBuilding.setFont(new Font("serif",Font.PLAIN,25));
        tBuilding.setForeground(Color.BLACK);
        jf.add(tBuilding);
        
        tFlat=new JTextField();
        tFlat.setBounds(320,150,280,35);
        tFlat.setFont(new Font("serif",Font.PLAIN,25));
        tFlat.setForeground(Color.BLACK);
        jf.add(tFlat);
        
        btnBack=new JButton("BACK");
        btnBack.setBounds(425,220,100,40);
        btnBack.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(Color.BLACK);
        jf.add(btnBack);
        
        btnCalculate=new JButton("FIND DETAILS");
        btnCalculate.setBounds(175,220,200,40);
        btnCalculate.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setBackground(Color.BLACK);
        jf.add(btnCalculate);

        btnBack.addActionListener(this);
        btnCalculate.addActionListener(this);
        
        //Name JLabel
        lblName = new JLabel("NAME:- ");
        lblName.setBounds(40,220,100,30);
        lblName.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblName.setForeground(Color.BLUE);
        jf.add(lblName);
        
        lblDisplayName = new JLabel();
        lblDisplayName.setBounds(200,220,500,30);
        lblDisplayName.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblDisplayName.setForeground(Color.BLACK);
        jf.add(lblDisplayName);
        
        //Vehicle Owned by Resident
        lblVehicleNum=new JLabel("TOTAL VEHICLES OWNED:-");
        lblVehicleNum.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblVehicleNum.setForeground(Color.BLUE);
        jf.add(lblVehicleNum);
        
        lblDisplayVehicleNum=new JLabel();
        lblDisplayVehicleNum.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblDisplayVehicleNum.setForeground(Color.BLACK);
        jf.add(lblDisplayVehicleNum);
        
        //Bill Charges JLabels
        //1. Sevice Charges
        lblServiceCharge=new JLabel("SERVICE CHARGES ");
        lblServiceCharge.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblServiceCharge.setForeground(Color.BLUE);
        lblServiceCharge.setBounds(40,340,350,30);
        jf.add(lblServiceCharge);
        
        DisplayServiceCharge=new JLabel();
        DisplayServiceCharge.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        DisplayServiceCharge.setForeground(Color.BLACK);
        DisplayServiceCharge.setBounds(320,340,350,30);
        jf.add(DisplayServiceCharge);
        
        //2. Sinking Fund
        lblSinkingFund=new JLabel("SINKING FUND ");
        lblSinkingFund.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblSinkingFund.setForeground(Color.BLUE);
        lblSinkingFund.setBounds(40,400,350,30);
        jf.add(lblSinkingFund);
        
        DisplaySinkingFund=new JLabel();
        DisplaySinkingFund.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        DisplaySinkingFund.setForeground(Color.BLACK);
        DisplaySinkingFund.setBounds(320,400,350,35);
        jf.add(DisplaySinkingFund);
        
        //3.Parking Charges
        lblParkingCharges=new JLabel("PARKING CHARGES ");
        lblParkingCharges.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblParkingCharges.setForeground(Color.BLUE);
        jf.add(lblParkingCharges);
        
        DisplayParkingCharges=new JLabel();
        DisplayParkingCharges.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        DisplayParkingCharges.setForeground(Color.BLACK);
        lblParkingCharges.setBounds(40,460,350,30);
        DisplayParkingCharges.setBounds(320,460,350,35);
        jf.add(DisplayParkingCharges);
        
        //4.Insurance Charges
        lblInsuranceCharges=new JLabel("INSURANCE CHARGES ");
        lblInsuranceCharges.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblInsuranceCharges.setForeground(Color.BLUE);
        jf.add(lblInsuranceCharges);
        
        DisplayInsuranceCharges=new JLabel();
        DisplayInsuranceCharges.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        DisplayInsuranceCharges.setForeground(Color.BLACK);
        lblInsuranceCharges.setBounds(40,520,350,30);
        DisplayInsuranceCharges.setBounds(320,520,350,35);
        jf.add(DisplayInsuranceCharges);
        
        //5.Repair Funds
        lblRepairFund=new JLabel("REPAIR FUND ");
        lblRepairFund.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblRepairFund.setForeground(Color.BLUE);
        jf.add(lblRepairFund);
        
        DisplayRepairFund=new JLabel();
        DisplayRepairFund.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        DisplayRepairFund.setForeground(Color.BLACK);
        lblRepairFund.setBounds(40,580,350,30);
        DisplayRepairFund.setBounds(320,580,350,35);
        jf.add(DisplayRepairFund);
        
        //6.Interest
        lblInterest=new JLabel("INTEREST ");
        lblInterest.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblInterest.setForeground(Color.BLUE);
        jf.add(lblInterest);
        
        DisplayInterest=new JLabel();
        DisplayInterest.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        DisplayInterest.setForeground(Color.BLACK);
        lblInterest.setBounds(40,640,350,30);
        DisplayInterest.setBounds(320,640,350,35);
        jf.add(DisplayInterest);
                
        //7.Total Amount
        lblAmount=new JLabel("BILL AMOUNT ");
        lblAmount.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblAmount.setForeground(Color.BLUE);
        jf.add(lblAmount);
        
        DisplayAmount=new JLabel();
        DisplayAmount.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        DisplayAmount.setForeground(Color.BLACK);
        lblAmount.setBounds(40,700,350,30);
        DisplayAmount.setBounds(320,700,350,35);
        jf.add(DisplayAmount);
        
        //8. Arrears
        lblArrears=new JLabel("ARREARS ");
        lblArrears.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblArrears.setForeground(Color.BLUE);
        jf.add(lblArrears);
        
        DisplayArrears=new JLabel();
        DisplayArrears.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        DisplayArrears.setForeground(Color.BLACK);
        lblArrears.setBounds(40,760,350,30);
        DisplayArrears.setBounds(320,760,350,35);
        jf.add(DisplayArrears);
        
        //9.Amount Due
        lblBillDue=new JLabel("AMOUNT DUE ");
        lblBillDue.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblBillDue.setForeground(Color.BLUE);
        jf.add(lblBillDue);
        
        DisplayBillDue=new JLabel();
        DisplayBillDue.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        DisplayBillDue.setForeground(Color.BLACK);
        lblBillDue.setBounds(40,820,350,30);
        DisplayBillDue.setBounds(320,820,350,35);
        jf.add(DisplayBillDue);
        
        //Button Update
        btnUpdate=new JButton("UPDATE BILL AMOUNT");
        btnUpdate.setBounds(30,880,250,40);
        btnUpdate.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.addActionListener(this);
        jf.add(btnUpdate);
        
        //Button Back
        btnBack2=new JButton("BACK");
        btnBack2.setBounds(570,880,100,40);
        btnBack2.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        btnBack2.setForeground(Color.WHITE);
        btnBack2.setBackground(Color.BLACK);
        btnBack2.addActionListener(this);
        jf.add(btnBack2);
        
        //Button Add Bill Amount
        btnAdd=new JButton("ADD BILL AMOUNT");
        btnAdd.setBounds(300,880,250,40);
        btnAdd.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.addActionListener(this);
        jf.add(btnAdd);
        
        lblServiceCharge.setVisible(false);
        lblSinkingFund.setVisible(false);
        lblParkingCharges.setVisible(false);
        lblInsuranceCharges.setVisible(false);
        lblRepairFund.setVisible(false);
        lblInterest.setVisible(false);
        lblArrears.setVisible(false);
        DisplayServiceCharge.setVisible(false);
        DisplaySinkingFund.setVisible(false);
        DisplayParkingCharges.setVisible(false);
        DisplayInsuranceCharges.setVisible(false);
        DisplayRepairFund.setVisible(false);
        DisplayInterest.setVisible(false);
        DisplayArrears.setVisible(false);
        lblVehicleNum.setVisible(false);
        lblAmount.setVisible(false);
        DisplayAmount.setVisible(false);
        lblBillDue.setVisible(false);
        DisplayBillDue.setVisible(false);
        lblDisplayVehicleNum.setVisible(false);
        lblName.setVisible(false);
        btnBack2.setVisible(false);
        btnAdd.setVisible(false);
        jf.setVisible(true);
    }
    
    public void showDetails()
    {
        MaintenanceDao dao=new MaintenanceDao();
        String name=dao.returnName(tBuilding.getText(),tFlat.getText());
        int number=dao.getVehicleCount(tBuilding.getText(),tFlat.getText());
        if(dao.isPresent(tBuilding.getText(),tFlat.getText()))
        {
            jf.setSize(700, 1000);
            showBillingAmounts();
            lblName.setBounds(40,100,100,30);
            lblDisplayName.setBounds(150,100,500,35);
            
            lblBuilding.setBounds(40,160,250,30);
            tBuilding.setBounds(320,160,280,35);
            
            lblFlat.setBounds(40,220,230,30);          
            tFlat.setBounds(320,220,280,35);
            
            lblVehicleNum.setBounds(40,280,350,30);
            lblDisplayVehicleNum.setBounds(370,280,100,30);
            
            lblVehicleNum.setVisible(true);
            lblDisplayVehicleNum.setVisible(true);
            lblName.setVisible(true);
            lblDisplayName.setVisible(true);
            lblServiceCharge.setVisible(true);
            lblSinkingFund.setVisible(true);
            lblParkingCharges.setVisible(true);
            lblInsuranceCharges.setVisible(true);
            lblRepairFund.setVisible(true);
            lblInterest.setVisible(true);
            lblArrears.setVisible(true);
            DisplayServiceCharge.setVisible(true);
            DisplaySinkingFund.setVisible(true);
            DisplayParkingCharges.setVisible(true);
            DisplayInsuranceCharges.setVisible(true);
            DisplayRepairFund.setVisible(true);
            DisplayInterest.setVisible(true);
            DisplayArrears.setVisible(true);
            lblAmount.setVisible(true);
            DisplayAmount.setVisible(true);
            lblBillDue.setVisible(true);
            DisplayBillDue.setVisible(true);
            btnAdd.setVisible(true);
            btnUpdate.setVisible(true);
            btnBack2.setVisible(true);
            tBuilding.setEditable(false);
            tFlat.setEditable(false);
            lblDisplayName.setText(name);
            lblDisplayVehicleNum.setText(Integer.toString(number));
        }
        
    }
    
    public void showBillingAmounts()
    {
        MaintenanceDao dao=new MaintenanceDao();
        int number=dao.getVehicleCount(tBuilding.getText(),tFlat.getText());
        double dueArrears=dao.getArrears(tBuilding.getText(),tFlat.getText());
        df.setRoundingMode(RoundingMode.DOWN);
        double totalWithoutInterest=0,totalParkingCharge=parkingCharge*number;
        DisplayServiceCharge.setText(df.format(serviceCharge));
        DisplaySinkingFund.setText(df.format(sinkingFund));
        DisplayParkingCharges.setText(df.format(totalParkingCharge));
        DisplayInsuranceCharges.setText(df.format(insuranceCharge));
        DisplayRepairFund.setText(df.format(repairFund));
        totalWithoutInterest=serviceCharge+sinkingFund+totalParkingCharge+totalParkingCharge+repairFund;
        double interest=((totalWithoutInterest/100)*2.64);
        DisplayInterest.setText(df.format(interest));
        DisplayAmount.setText(df.format(totalWithoutInterest+interest));
        DisplayArrears.setText(df.format(dueArrears));
        DisplayBillDue.setText(df.format((dueArrears+(dueArrears*0.21))+totalWithoutInterest+interest));
        billAmount=Double.parseDouble(DisplayBillDue.getText());
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btnBack)
        {
            jf.dispose();
            new MainPage();
        }
        if(ae.getSource()==btnCalculate)
        {
            btnCalculate.setVisible(false);
            btnBack.setVisible(false);
            showDetails();
        }
        if(ae.getSource()==btnAdd)
        {
            MaintenanceDao dao=new MaintenanceDao();
            dao.addAmount(tBuilding.getText(),tFlat.getText(),billAmount);
            jf.dispose();
            new CalculateMaintenance();
        }
        if(ae.getSource()==btnBack2)
        {
            jf.dispose();
            new CalculateMaintenance();
        }   
        if(ae.getSource()==btnUpdate)
        {
            jf.dispose();
            MaintenanceDao dao=new MaintenanceDao();
            double paidAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "PLEASE ENTER THE AMOUNT PAID!", "Input", JOptionPane.QUESTION_MESSAGE));
            dao.payAmount(tBuilding.getText(),tFlat.getText(),paidAmount);
            new CalculateMaintenance();
        }
    }
    
    public static void main(String args[])
    {
        new CalculateMaintenance();
    }
}

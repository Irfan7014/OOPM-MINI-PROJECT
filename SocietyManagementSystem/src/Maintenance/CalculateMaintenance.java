package Maintenance;
import Databases.MaintenanceDao;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import societymanagementsystem.MainPage;
public class CalculateMaintenance implements ActionListener
{
    JFrame jf;
    JButton btnBack,btnCalculate;
    JLabel lblTitle,lblBuilding,lblFlat,lblName,lblDisplayName,lblVehicleNum,lblDisplayVehicleNum;
    JTextField tBuilding,tFlat;
    public CalculateMaintenance()
    {
        //Frame Details
        jf=new JFrame("CALCULATE MAINTENANCE");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(800, 200);
        jf.setSize(700, 700);
        
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
        
        lblVehicleNum=new JLabel("TOTAL VEHICLES OWNED:-");
        lblVehicleNum.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblVehicleNum.setForeground(Color.BLUE);
        jf.add(lblVehicleNum);
        
        lblDisplayVehicleNum=new JLabel();
        lblDisplayVehicleNum.setFont(new Font("Times_New_Roman",Font.PLAIN,23));
        lblDisplayVehicleNum.setForeground(Color.BLACK);
        jf.add(lblDisplayVehicleNum);
        
        lblVehicleNum.setVisible(false);
        lblDisplayVehicleNum.setVisible(false);
        lblName.setVisible(false);
        lblDisplayName.setVisible(false);
        jf.setVisible(true);
    }
    public void showDetails()
    {
        MaintenanceDao dao=new MaintenanceDao();
        String name=dao.returnName(tBuilding.getText(),tFlat.getText());
        int number=dao.getVehicleCount(tBuilding.getText(),tFlat.getText());
        if(dao.isPresent(tBuilding.getText(),tFlat.getText()))
        {
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
            tBuilding.setEditable(false);
            tFlat.setEditable(false);
            lblDisplayName.setText(name);
            lblDisplayVehicleNum.setText(Integer.toString(number));
        }
        
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
    }
    public static void main(String args[])
    {
        new CalculateMaintenance();
    }
}

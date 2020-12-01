package Residents;

import Databases.ResidentsDao;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class UpdateResidents implements ActionListener
{
    JFrame jf,frame;
    JLabel lblBuilding,lblFlat,lbltitle,lblowner,lblDOB,lbloccupation,lblarriving_year,lbltotalfamilymem,lblmaritalstatus,lblRentOrOwner;
    JTextField tBuilding,tFlat,towner,tDOB,toccupation,tarriving_year,ttotalfamilymem,tBuildingNum,tFlatNum;
    JButton btnBack,btnUpdate,btnUpdateAgain,btnBack1;
    JRadioButton jrbSingle,jrbMarried,jrbRent,jrbOwner;
    ButtonGroup G1,G2;
    public UpdateResidents()
    {
        //Frame Details
        jf=new JFrame("UPDATE RESIDENT DETAILS");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(800, 200);
        jf.setSize(700, 300);

        //JLabel Building Number
        lblBuilding=new JLabel("ENTER BUILDING NUMBER:- ");
        lblBuilding.setBounds(20, 20, 350, 40);
        lblBuilding.setFont(new Font("serif", Font.BOLD, 23));
        lblBuilding.setForeground(Color.DARK_GRAY);
        jf.add(lblBuilding);
        
        tBuilding=new JTextField();
        tBuilding.setBounds(370, 22, 270, 40);
        tBuilding.setFont(new Font("serif", Font.PLAIN, 25));
        tBuilding.setForeground(Color.BLACK);
        jf.add(tBuilding);        
        
        //JLabel Flat Number
        lblFlat=new JLabel("ENTER FLAT NUMBER:- ");
        lblFlat.setBounds(20, 90, 300, 40);
        lblFlat.setFont(new Font("serif", Font.BOLD, 23));
        lblFlat.setForeground(Color.DARK_GRAY);
        jf.add(lblFlat);
        
        tFlat=new JTextField();
        tFlat.setBounds(370, 90, 270, 40);
        tFlat.setFont(new Font("serif", Font.PLAIN, 25));
        tFlat.setForeground(Color.BLACK);
        jf.add(tFlat);   
        
        //BACK Button
        btnBack=new JButton("BACK");
        btnBack.setBounds(380,180,100,30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        btnBack.addActionListener(this);
        jf.add(btnBack);
        
        //UPDATE Button
        btnUpdate=new JButton("UPDATE");
        btnUpdate.setBounds(220,180,120,30);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        btnUpdate.addActionListener(this);
        jf.add(btnUpdate);
        
        jf.setVisible(true);
    }
    public void UpdateResident(String buildingNum,String flatNum)
    {
        //Frame Details
        frame=new JFrame("UPDATE RESIDENT'S DETAILS");
        frame.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocation(20,20);
        frame.setSize(850,700);
        
        //Label and TextField Details
        //Title
        lbltitle = new JLabel("UPDATE RESIDENT DETAILS");
        lbltitle.setBounds(20,0,500,50);
        lbltitle.setFont(new Font("serif",Font.ITALIC,36));
        lbltitle.setForeground(Color.ORANGE);
        frame.add(lbltitle);
        
        //1.Owner
        lblowner = new JLabel("NAME OF RESIDENT: ");
        lblowner.setBounds(40,100,230,30);
        lblowner.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblowner.setForeground(Color.BLACK);
        frame.add(lblowner);
        
        towner=new JTextField();
        towner.setBounds(345,95,280,40);
        towner.setFont(new Font("serif",Font.PLAIN,20));
        towner.setForeground(Color.BLACK);
        frame.add(towner);
        
        //2.Wing
        lblBuilding = new JLabel("BUILDING NUMBER: ");
        lblBuilding.setBounds(40,150,200,30);
        lblBuilding.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblBuilding.setForeground(Color.BLACK);
        frame.add(lblBuilding);
        
        tBuildingNum=new JTextField();
        tBuildingNum.setBounds(345,145,280,40);
        tBuildingNum.setFont(new Font("serif",Font.PLAIN,20));
        tBuildingNum.setForeground(Color.BLACK);
        frame.add(tBuildingNum);
        
        //3.Flat No.
        lblFlat = new JLabel("FLAT NUMBER: ");
        lblFlat.setBounds(40,200,200,30);
        lblFlat.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblFlat.setForeground(Color.BLACK);
        frame.add(lblFlat);
        
        tFlatNum=new JTextField();
        tFlatNum.setBounds(345,195,280,40);
        tFlatNum.setFont(new Font("serif",Font.PLAIN,20));
        tFlatNum.setForeground(Color.BLACK);
        frame.add(tFlatNum);
        
        //4.DOB
        lblDOB = new JLabel("DATE OF BIRTH(DD/MM/YYYY):");
        lblDOB.setBounds(40,250,320,30);
        lblDOB.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblDOB.setForeground(Color.BLACK);
        frame.add(lblDOB);
        
        tDOB=new JTextField();
        tDOB.setBounds(345,245,280,40);
        tDOB.setFont(new Font("serif",Font.PLAIN,20));
        tDOB.setForeground(Color.BLACK);
        frame.add(tDOB);
        
        //4.Occupation
        lbloccupation = new JLabel("OCCUPATION: ");
        lbloccupation.setBounds(40,300,200,30);
        lbloccupation.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lbloccupation.setForeground(Color.BLACK);
        frame.add(lbloccupation);
        
        toccupation=new JTextField();
        toccupation.setBounds(345,295,280,40);
        toccupation.setFont(new Font("serif",Font.PLAIN,20));
        toccupation.setForeground(Color.BLACK);
        frame.add(toccupation);
        
        //6.Arrival Year
        lblarriving_year = new JLabel("YEAR OF ARRIVAL: ");
        lblarriving_year.setBounds(40,350,220,30);
        lblarriving_year.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblarriving_year.setForeground(Color.BLACK);
        frame.add(lblarriving_year);
        
        tarriving_year=new JTextField();
        tarriving_year.setBounds(345,345,280,40);
        tarriving_year.setFont(new Font("serif",Font.PLAIN,20));
        tarriving_year.setForeground(Color.BLACK);
        frame.add(tarriving_year);
        
        //7.Total Family Members
        lbltotalfamilymem = new JLabel("TOTAL FAMILY MEMBERS: ");
        lbltotalfamilymem.setBounds(40,400,300,30);
        lbltotalfamilymem.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lbltotalfamilymem.setForeground(Color.BLACK);
        frame.add(lbltotalfamilymem);
        
        ttotalfamilymem=new JTextField();
        ttotalfamilymem.setBounds(345,395,280,40);
        ttotalfamilymem.setFont(new Font("serif",Font.PLAIN,20));
        ttotalfamilymem.setForeground(Color.BLACK);
        frame.add(ttotalfamilymem);
        
        //8.Marital Status
        lblmaritalstatus = new JLabel("MARITAL STATUS: ");
        lblmaritalstatus.setBounds(40,450,300,30);
        lblmaritalstatus.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblmaritalstatus.setForeground(Color.BLACK);
        frame.add(lblmaritalstatus);
        
        jrbSingle=new JRadioButton("SINGLE");
        jrbSingle.setBounds(345,445,140,40);
        jrbSingle.setFont(new Font("serif",Font.PLAIN,25));
        jrbSingle.setForeground(Color.BLACK);
        frame.add(jrbSingle);
        
        jrbMarried=new JRadioButton("MARRIED");
        jrbMarried.setBounds(490,445,200,40);
        jrbMarried.setFont(new Font("serif",Font.PLAIN,25));
        jrbMarried.setForeground(Color.BLACK);
        frame.add(jrbMarried);
        
        //9.Rent or Owner
        lblRentOrOwner = new JLabel("RENTED/OWNER: ");
        lblRentOrOwner.setBounds(40,500,300,30);
        lblRentOrOwner.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblRentOrOwner.setForeground(Color.BLACK);
        frame.add(lblRentOrOwner);
        
        jrbOwner=new JRadioButton("OWNER");
        jrbOwner.setBounds(345,495,140,40);
        jrbOwner.setFont(new Font("serif",Font.PLAIN,25));
        jrbOwner.setForeground(Color.BLACK);
        frame.add(jrbOwner);
        
        jrbRent=new JRadioButton("RENT");
        jrbRent.setBounds(490,495,200,40);
        jrbRent.setFont(new Font("serif",Font.PLAIN,25));
        jrbRent.setForeground(Color.BLACK);
        frame.add(jrbRent);
        
        //Add Residents Button
        btnUpdateAgain=new JButton("UPDATE");
        btnUpdateAgain.setBounds(275,600,150,40);
        btnUpdateAgain.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        btnUpdateAgain.setForeground(Color.WHITE);
        btnUpdateAgain.setBackground(Color.BLACK);
        frame.add(btnUpdateAgain);
        
        //Back Button
        btnBack1=new JButton("BACK");
        btnBack1.setBounds(475,600,100,40);
        btnBack1.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        btnBack1.setForeground(Color.WHITE);
        btnBack1.setBackground(Color.BLACK);
        frame.add(btnBack1);
        
        G1=new ButtonGroup();
        G1.add(jrbMarried);
        G1.add(jrbSingle);
        
        G2=new ButtonGroup();
        G2.add(jrbOwner);
        G2.add(jrbRent);
        
        ResidentsDao dao=new ResidentsDao();
        Residents resident=dao.findDetailsAboutResident(buildingNum,flatNum);
        towner.setText(resident.getName());
        tBuildingNum.setText(buildingNum);
        tFlatNum.setText(flatNum);
        tDOB.setText(resident.getDOB());
        toccupation.setText(resident.getOccupation());
        tarriving_year.setText(Integer.toString(resident.getYearOfArrival()));
        ttotalfamilymem.setText(Integer.toString(resident.getTotalMembers()));
        if(resident.getMaritalStatus().equals("MARRIED"))
            jrbMarried.setSelected(true);
        if(resident.getMaritalStatus().equals("SINGLE"))
            jrbSingle.setSelected(true);
        if(resident.getRentOrOwner().equals("RENT"))
            jrbRent.setSelected(true);
        if(resident.getRentOrOwner().equals("OWNER"))
            jrbOwner.setSelected(true);
        tBuildingNum.setEditable(false);
        tFlatNum.setEditable(false);
        btnUpdateAgain.addActionListener(this);
        btnBack.addActionListener(this);
        btnBack1.addActionListener(this);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btnBack)
        {
            jf.dispose();
            new AddResidents();
        }
        if(ae.getSource()==btnUpdate)
        {
            jf.dispose();
            UpdateResident(tBuilding.getText(),tFlat.getText());
        }
        if(ae.getSource()==btnUpdateAgain)
        {
            frame.dispose();
            Residents resident=new Residents();
            resident.setName(towner.getText());
            resident.setBuildingNum(tBuilding.getText());
            resident.setFlatNum(tFlat.getText());
            resident.setDOB(tDOB.getText());
            resident.setOccupation(toccupation.getText());
            resident.setYearOfArrival(Integer.parseInt(tarriving_year.getText()));
            resident.setTotalMembers(Integer.parseInt(ttotalfamilymem.getText()));
            if(jrbMarried.isSelected())
                resident.setMaritalStatus("MARRIED");
            if(jrbSingle.isSelected())
                resident.setMaritalStatus("SINGLE");
            if(jrbOwner.isSelected())
                resident.setRentOrOwner("OWNER");
            if(jrbRent.isSelected())
                resident.setRentOrOwner("RENT");
            ResidentsDao residentDao=new ResidentsDao();
            residentDao.updateResidentDetails(resident);
            new UpdateResidents();
        }
        if(ae.getSource()==btnBack1)
        {
            frame.dispose();
            new UpdateResidents();
        }
    }
    public static void main(String args[])
    {
        new UpdateResidents();
    }
}

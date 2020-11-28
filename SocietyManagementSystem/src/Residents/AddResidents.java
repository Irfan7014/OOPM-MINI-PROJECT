package Residents;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import societymanagementsystem.MainPage;
public class AddResidents implements ActionListener
{
    JFrame jf;
    JLabel lbltitle,lblowner,lblBuilding,lblflatno,lblDOB,lbloccupation,lblarriving_year,lbltotalfamilymem,lblmaritalstatus,lblRentOrOwner;
    JTextField towner,tBuilding,tflatno,tDOB,toccupation,tarriving_year,ttotalfamilymem;
    JCheckBox jcbmarried,jcbsingle,jcbowner,jcbrent;
    ButtonGroup G1,G2;
    JButton bback,bAddResidents;
    public AddResidents()
    {
        //Frame Details
        jf=new JFrame("ADD RESIDENTS");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(20,20);
        jf.setSize(850,700);
        
        //Label and TextField Details
        //Title
        lbltitle = new JLabel("ADD  RESIDENTS");
        lbltitle.setBounds(20,0,400,50);
        lbltitle.setFont(new Font("serif",Font.ITALIC,36));
        lbltitle.setForeground(Color.BLUE);
        jf.add(lbltitle);
        
        //1.Owner
        lblowner = new JLabel("NAME OF RESIDENT: ");
        lblowner.setBounds(40,100,230,30);
        lblowner.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblowner.setForeground(Color.BLACK);
        jf.add(lblowner);
        
        towner=new JTextField();
        towner.setBounds(345,95,280,40);
        towner.setFont(new Font("serif",Font.PLAIN,20));
        towner.setForeground(Color.BLACK);
        jf.add(towner);
        
        //2.Wing
        lblBuilding = new JLabel("BUILDING NUMBER: ");
        lblBuilding.setBounds(40,150,200,30);
        lblBuilding.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblBuilding.setForeground(Color.BLACK);
        jf.add(lblBuilding);
        
        tBuilding=new JTextField();
        tBuilding.setBounds(345,145,280,40);
        tBuilding.setFont(new Font("serif",Font.PLAIN,20));
        tBuilding.setForeground(Color.BLACK);
        jf.add(tBuilding);
        
        //3.Flat No.
        lblflatno = new JLabel("FLAT NUMBER: ");
        lblflatno.setBounds(40,200,200,30);
        lblflatno.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblflatno.setForeground(Color.BLACK);
        jf.add(lblflatno);
        
        tflatno=new JTextField();
        tflatno.setBounds(345,195,280,40);
        tflatno.setFont(new Font("serif",Font.PLAIN,20));
        tflatno.setForeground(Color.BLACK);
        jf.add(tflatno);
        
        //4.DOB
        lblDOB = new JLabel("DATE OF BIRTH(DD/MM/YYYY):");
        lblDOB.setBounds(40,250,320,30);
        lblDOB.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblDOB.setForeground(Color.BLACK);
        jf.add(lblDOB);
        
        tDOB=new JTextField();
        tDOB.setBounds(345,245,280,40);
        tDOB.setFont(new Font("serif",Font.PLAIN,20));
        tDOB.setForeground(Color.BLACK);
        jf.add(tDOB);
        
        //4.Occupation
        lbloccupation = new JLabel("OCCUPATION: ");
        lbloccupation.setBounds(40,300,200,30);
        lbloccupation.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lbloccupation.setForeground(Color.BLACK);
        jf.add(lbloccupation);
        
        toccupation=new JTextField();
        toccupation.setBounds(345,295,280,40);
        toccupation.setFont(new Font("serif",Font.PLAIN,20));
        toccupation.setForeground(Color.BLACK);
        jf.add(toccupation);
        
        //6.Arrival Year
        lblarriving_year = new JLabel("YEAR OF ARRIVAL: ");
        lblarriving_year.setBounds(40,350,220,30);
        lblarriving_year.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblarriving_year.setForeground(Color.BLACK);
        jf.add(lblarriving_year);
        
        tarriving_year=new JTextField();
        tarriving_year.setBounds(345,345,280,40);
        tarriving_year.setFont(new Font("serif",Font.PLAIN,20));
        tarriving_year.setForeground(Color.BLACK);
        jf.add(tarriving_year);
        
        //7.Total Family Members
        lbltotalfamilymem = new JLabel("TOTAL FAMILY MEMBERS: ");
        lbltotalfamilymem.setBounds(40,400,300,30);
        lbltotalfamilymem.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lbltotalfamilymem.setForeground(Color.BLACK);
        jf.add(lbltotalfamilymem);
        
        ttotalfamilymem=new JTextField();
        ttotalfamilymem.setBounds(345,395,280,40);
        ttotalfamilymem.setFont(new Font("serif",Font.PLAIN,20));
        ttotalfamilymem.setForeground(Color.BLACK);
        jf.add(ttotalfamilymem);
        
        //8.Marital Status
        lblmaritalstatus = new JLabel("MARITAL STATUS: ");
        lblmaritalstatus.setBounds(40,450,300,30);
        lblmaritalstatus.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblmaritalstatus.setForeground(Color.BLACK);
        jf.add(lblmaritalstatus);
        
        jcbsingle=new JCheckBox("SINGLE");
        jcbsingle.setBounds(345,445,140,40);
        jcbsingle.setFont(new Font("serif",Font.PLAIN,25));
        jcbsingle.setForeground(Color.BLACK);
        jf.add(jcbsingle);
        
        jcbmarried=new JCheckBox("MARRIED");
        jcbmarried.setBounds(490,445,200,40);
        jcbmarried.setFont(new Font("serif",Font.PLAIN,25));
        jcbmarried.setForeground(Color.BLACK);
        jf.add(jcbmarried);
        
        //9.Rent or Owner
        lblRentOrOwner = new JLabel("RENTED/OWNER: ");
        lblRentOrOwner.setBounds(40,500,300,30);
        lblRentOrOwner.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblRentOrOwner.setForeground(Color.BLACK);
        jf.add(lblRentOrOwner);
        
        jcbowner=new JCheckBox("OWNER");
        jcbowner.setBounds(345,495,140,40);
        jcbowner.setFont(new Font("serif",Font.PLAIN,25));
        jcbowner.setForeground(Color.BLACK);
        jf.add(jcbowner);
        
        jcbrent=new JCheckBox("RENT");
        jcbrent.setBounds(490,495,200,40);
        jcbrent.setFont(new Font("serif",Font.PLAIN,25));
        jcbrent.setForeground(Color.BLACK);
        jf.add(jcbrent);
        
        //Add Residents Button
        bAddResidents=new JButton("ADD RESIDENT");
        bAddResidents.setBounds(230,600,250,40);
        bAddResidents.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        bAddResidents.setForeground(Color.WHITE);
        bAddResidents.setBackground(Color.BLACK);
        jf.add(bAddResidents);
        
        //Back Button
        bback=new JButton("BACK");
        bback.setBounds(520,600,100,40);
        bback.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        bback.setForeground(Color.WHITE);
        bback.setBackground(Color.BLACK);
        jf.add(bback);
        
        G1=new ButtonGroup();
        G1.add(jcbmarried);
        G1.add(jcbsingle);
        
        G2=new ButtonGroup();
        G2.add(jcbowner);
        G2.add(jcbrent);
        
        bAddResidents.addActionListener(this);
        bback.addActionListener(this);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bback)
        {
            jf.dispose();
            MainPage mp=new MainPage();
        }
        if(ae.getSource()==bAddResidents)
        {
            jf.dispose();
            JOptionPane.showMessageDialog(jf,"THE RESIDENT WAS SUCCESSFULLY ADDED!");
        }
    }
        
    public static void main(String args[])
    {
        AddResidents ar=new AddResidents();
    }
}

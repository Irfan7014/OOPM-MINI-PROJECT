package societymanagementsystem;
import Maintenance.CalculateMaintenance;
import Maintenance.CheckMaintenance;
import AdminLogin.Logins;
import Members.SocietyMembers;
import NoticesAndReportsAndServices.*;
import Parking.*;
import Residents.*;
import gateinn.GateinnLogin;
import gateinn.ViewVisitors;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class MainPage implements ActionListener
{
    JFrame jf;
    JPanel contentPane,panelborder1,panelborder2;
    JButton badd,bstats,bissue,breturn,b5,b6;
    JLabel lbltitle,lblimage;
    public static void main(String args[])
    {
        MainPage mp=new MainPage();
    }
    public MainPage() 
    {
        jf=new JFrame("HOME PAGE");
        jf.setBounds(10,10, 1296, 700);
        jf.setResizable(false);
        contentPane = new JPanel();
        jf.setContentPane(contentPane);
        contentPane.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
        menuBar.setBackground(Color.CYAN);
        menuBar.setBounds(0, 0, 1280, 35);
        contentPane.add(menuBar);

        //******************************************//
        JMenu mnRecordResidents = new JMenu("Residents");
        mnRecordResidents.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
        
        JMenuItem add_residents = new JMenuItem("Add Residents");
        add_residents.addActionListener(this);
        add_residents.setBackground(new Color(211, 211, 211));
        add_residents.setForeground(Color.DARK_GRAY);
        add_residents.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordResidents.add(add_residents);

        JMenuItem view_residents = new JMenuItem("View Residents");
        view_residents.setBackground(new Color(211, 211, 211));
        view_residents.setForeground(Color.DARK_GRAY);
        view_residents.addActionListener(this);
        view_residents.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordResidents.add(view_residents);
        
        //******************************************//
        JMenu mnRecordMaintenance = new JMenu("Maintainance");
        mnRecordMaintenance.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
        
        JMenuItem calculate_maintenance = new JMenuItem("Calculate Maintenance");
        calculate_maintenance.addActionListener(this);
        calculate_maintenance.setBackground(new Color(211, 211, 211));
        calculate_maintenance.setForeground(Color.DARK_GRAY);
        calculate_maintenance.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordMaintenance.add(calculate_maintenance);

        JMenuItem send_maintenance = new JMenuItem("Send Maintenance");
        send_maintenance.setBackground(new Color(211, 211, 211));
        send_maintenance.setForeground(Color.DARK_GRAY);
        send_maintenance.addActionListener(this);
        send_maintenance.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordMaintenance.add(send_maintenance);
        
        //******************************************//
        JMenu mnRecordParking = new JMenu("Parking");
        mnRecordParking.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
        
        JMenuItem parking_details = new JMenuItem("Parking Details");
        parking_details.addActionListener(this);
        parking_details.setBackground(new Color(211, 211, 211));
        parking_details.setForeground(Color.DARK_GRAY);
        parking_details.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordParking.add(parking_details);

        JMenuItem assign_parking_space = new JMenuItem("Assign Parking Space");
        assign_parking_space.setBackground(new Color(211, 211, 211));
        assign_parking_space.setForeground(Color.DARK_GRAY);
        assign_parking_space.addActionListener(this);
        assign_parking_space.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordParking.add(assign_parking_space);
        
        //******************************************//
        JMenu mnRecordGateinn = new JMenu("GateINN");
        mnRecordGateinn.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
        
        JMenuItem launch_gateinn = new JMenuItem("Launch GateINN Application");
        launch_gateinn.addActionListener(this);
        launch_gateinn.setBackground(new Color(211, 211, 211));
        launch_gateinn.setForeground(Color.DARK_GRAY);
        launch_gateinn.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordGateinn.add(launch_gateinn);
        
        JMenuItem view_visitors = new JMenuItem("View Visitors");
        view_visitors.addActionListener(this);
        view_visitors.setBackground(new Color(211, 211, 211));
        view_visitors.setForeground(Color.DARK_GRAY);
        view_visitors.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordGateinn.add(view_visitors);
        
        //******************************************//
        JMenu mnRecordOthers = new JMenu("Others");
        mnRecordOthers.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
        
        JMenuItem contact_service = new JMenuItem("Household Services Contacts");
        contact_service.addActionListener(this);
        contact_service.setBackground(new Color(211, 211, 211));
        contact_service.setForeground(Color.DARK_GRAY);
        contact_service.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordOthers.add(contact_service);
        
        JMenuItem notice_board = new JMenuItem("Notice Board");
        notice_board.addActionListener(this);
        notice_board.setBackground(new Color(211, 211, 211));
        notice_board.setForeground(Color.DARK_GRAY);
        notice_board.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordOthers.add(notice_board);
        
        //******************************************//
        JMenu mnRecordAbout = new JMenu("About Society");
        mnRecordAbout.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
        
        JMenuItem society_members = new JMenuItem("Society Members");
        society_members.addActionListener(this);
        society_members.setBackground(new Color(211, 211, 211));
        society_members.setForeground(Color.DARK_GRAY);
        society_members.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordAbout.add(society_members);
        
        JMenuItem annual_report = new JMenuItem("Annual Report");
        annual_report.addActionListener(this);
        annual_report.setBackground(new Color(211, 211, 211));
        annual_report.setForeground(Color.DARK_GRAY);
        annual_report.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordAbout.add(annual_report);
        
        //******************************************//
        JMenu mnRecordExit = new JMenu("Exit");
        mnRecordExit.setFont(new Font("Trebuchet MS", Font.BOLD,22));
        
        JMenuItem logout = new JMenuItem("Logout");
        logout.addActionListener(this);
        logout.setBackground(new Color(211, 211, 211));
        logout.setForeground(Color.DARK_GRAY);
        logout.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordExit.add(logout);
        
        JMenuItem close = new JMenuItem("Close");
        close.addActionListener(this);
        close.setBackground(new Color(211, 211, 211));
        close.setForeground(Color.DARK_GRAY);
        close.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordExit.add(close);
       
        
        menuBar.add(mnRecordResidents);
        menuBar.add(mnRecordMaintenance);
        menuBar.add(mnRecordParking);
        menuBar.add(mnRecordGateinn);
        menuBar.add(mnRecordOthers);
        menuBar.add(mnRecordAbout);
        menuBar.add(mnRecordExit);

        lbltitle= new JLabel("SOCIETY MANAGEMENT SYSTEM");
        lbltitle.setForeground(new Color(90,20,181));
        lbltitle.setFont(new Font("Segoe UI Semilight", Font.BOLD, 40));
        lbltitle.setBounds(318, 30, 650, 50);
        contentPane.add(lbltitle);
        
        lblimage=new JLabel();
        lblimage.setBounds(0,30,1300,665);
        lblimage.setLayout(null);
        ImageIcon img=new ImageIcon("src\\societymanagementsystem\\images\\.jpg");
        lblimage.setIcon(img);
        contentPane.add(lblimage);
        

        jf.getContentPane().setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();
        if(msg.equals("Close"))
        {
            jf.dispose();
        }
        if(msg.equals("Logout"))
        {
            jf.dispose();
            Logins ll=new Logins();
        }
        if(msg.equals("Society Members"))
        {
            jf.dispose();
            SocietyMembers sm=new SocietyMembers();
        }
        if(msg.equals("Notice Board"))
        {
            jf.dispose();
            NoticeBoard nb=new NoticeBoard();
        }
        if(msg.equals("Annual Report"))
        {
            AnnualReport ar=new AnnualReport();
        }
        if(msg.equals("Household Services Contacts"))
        {
            jf.dispose();
            Household_Services hs=new Household_Services();
        }
        if(msg.equals("View Visitors"))
        {
            jf.dispose();
            ViewVisitors v=new ViewVisitors();
        }
        if(msg.equals("Launch GateINN Application"))
        {
            jf.dispose();
            GateinnLogin gl=new GateinnLogin();
        }
        if(msg.equals("Assign Parking Space"))
        {
            jf.dispose();
            AssignParking ap=new AssignParking();
        }
        if(msg.equals("Parking Details"))
        {
            jf.dispose();
            ViewParking vp=new ViewParking();
        }
        if(msg.equals("Send Maintenance"))
        {
            jf.dispose();
            CheckMaintenance sm=new CheckMaintenance();
        }
        if(msg.equals("Calculate Maintenance"))
        {
            jf.dispose();
            CalculateMaintenance cm=new CalculateMaintenance();
        }
        if(msg.equals("View Residents"))
        {
            jf.dispose();
            new ViewResidents();
        }
        if(msg.equals("Add Residents"))
        {
            jf.dispose();
            AddResidents ar=new AddResidents();
        }
    }
}

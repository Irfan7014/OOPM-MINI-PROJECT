package ResidentView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

public class ResidentViewMainPage implements ActionListener
{
    JFrame jf1,jf;
    JPanel contentPane;
    JLabel lbltitle,lblimage;
    public ResidentViewMainPage()
    {
        jf1=new JFrame("HOME PAGE");
        jf1.setBounds(10,10, 1296, 700);
        jf1.setResizable(false);
        contentPane = new JPanel();
        jf1.setContentPane(contentPane);
        contentPane.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
        menuBar.setBackground(Color.CYAN);
        menuBar.setBounds(0, 0, 1280, 35);
        contentPane.add(menuBar);
        
        //******************************************//
        JMenu mnRecordParking = new JMenu("Parking");
        mnRecordParking.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
        
        JMenuItem parking_details = new JMenuItem("View Parking Details");
        parking_details.addActionListener(this);
        parking_details.setBackground(new Color(211, 211, 211));
        parking_details.setForeground(Color.DARK_GRAY);
        parking_details.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordParking.add(parking_details);
        
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
        
        JMenuItem close = new JMenuItem("Close");
        close.addActionListener(this);
        close.setBackground(new Color(211, 211, 211));
        close.setForeground(Color.DARK_GRAY);
        close.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        mnRecordExit.add(close);
       
        menuBar.add(mnRecordParking);
        menuBar.add(mnRecordOthers);
        menuBar.add(mnRecordAbout);
        menuBar.add(mnRecordExit);

        lbltitle= new JLabel("SOCIETY MANAGEMENT SYSTEM");
        lbltitle.setForeground(new Color(90,20,181));
        lbltitle.setFont(new Font("Segoe UI Semilight", Font.BOLD, 40));
        lbltitle.setBounds(318, 30, 650, 50);
        contentPane.add(lbltitle);
        
        lblimage=new JLabel();
        lblimage.setBounds(0,80,1300,665);
        lblimage.setLayout(null);
        ImageIcon img=new ImageIcon("src\\societymanagementsystem\\images\\main.jpg");
        lblimage.setIcon(img);
        contentPane.add(lblimage);
        

        jf1.getContentPane().setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        jf1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf1.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String msg = ae.getActionCommand();
        if(msg.equals("Close"))
        {
            jf1.dispose();            
        }
        if(msg.equals("View Parking Details"))
        {
            new ViewParkingByResidents();
        }
        if(msg.equals("Household Services Contacts"))
        {
            new ShowHouseholdServices();
        }
        if(msg.equals("Society Members"))
        {
            new ResidentViewSocietyMembers();
        }
        if(msg.equals("Notice Board"))
        {
            new ResidentViewNoticeBoard();            
        }
        if(msg.equals("Annual Report"))
        {
            new ResidentViewAnnualReport();            
        }
    }    
    
    public static void main(String args[])
    {
        new ResidentViewMainPage();
    }
}

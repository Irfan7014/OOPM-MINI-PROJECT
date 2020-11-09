package NoticesAndReportsAndServices;
import Databases.Databasec1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import societymanagementsystem.MainPage;
public class Household_Services implements ActionListener
{
    public static void main(String args[])
    {
        Household_Services hs=new Household_Services();
    }
    JFrame jf;
    JLabel lbltitle ,lblservice ,lblcontact ,lblnames ,lblelectrician,lblplumber,lblpainter,lblbabysitter,lbllaundary,lbltutor,lblcarpenter,lblmaid;
    JLabel lblelectrician_name,lblplumber_name,lblpainter_name,lblbabysitter_name,lbllaundary_name,lbltutor_name,lblcarpenter_name,lblmaid_name;
    String electrician_name,plumber_name,painter_name,babysitter_name,laundary_name,tutor_name,carpenter_name,maid_name;
    JLabel lblelectrician_contact,lblplumber_contact,lblpainter_contact,lblbabysitter_contact,lbllaundary_contact,lbltutor_contact,lblcarpenter_contact,lblmaid_contact;
    String electrician_contact,plumber_contact,painter_contact,babysitter_contact,laundary_contact,tutor_contact,carpenter_contact,maid_contact;
    JButton bdone;
    public Household_Services()
    {
        //Frame details
        jf=new JFrame("HOUSEHOLD SERVICES CONTACT LIST");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(5,5);
        jf.setSize(885,625);   
        
        //Title
        lbltitle = new JLabel("HOUSEHOLD SERVICES CONTACTS");
        lbltitle.setBounds(143,0,600,50);
        lbltitle.setFont(new Font("serif",Font.PLAIN,35));
        lbltitle.setForeground(new Color(90,76,218));
        jf.add(lbltitle);
        
        //JLabel Details
        lblservice = new JLabel("SERVICES");
        lblservice.setBounds(25,70,150,50);
        lblservice.setFont(new Font("serif",Font.PLAIN,30));
        lblservice.setForeground(new Color(240,28,85));
        jf.add(lblservice);
        
        lblnames = new JLabel("NAME");
        lblnames.setBounds(360,70,150,50);
        lblnames.setFont(new Font("serif",Font.PLAIN,30));
        lblnames.setForeground(new Color(240,28,85));
        jf.add(lblnames);
        
        lblcontact = new JLabel("CONTACTS");
        lblcontact.setBounds(630,70,160,50);
        lblcontact.setFont(new Font("serif",Font.PLAIN,30));
        lblcontact.setForeground(new Color(240,28,85));
        jf.add(lblcontact);
        
        lblelectrician = new JLabel("ELECTRICIAN");
        lblelectrician.setBounds(25,120,400,40);
        lblelectrician.setFont(new Font("serif",Font.PLAIN,30));
        lblelectrician.setForeground(new Color(0,0,0));
        jf.add(lblelectrician);
        
        lblplumber = new JLabel("PLUMBER");
        lblplumber.setBounds(25,170,400,40);
        lblplumber.setFont(new Font("serif",Font.PLAIN,30));
        lblplumber.setForeground(new Color(0,0,0));
        jf.add(lblplumber);
        
        lblpainter = new JLabel("PAINTER");
        lblpainter.setBounds(25,220,400,40);
        lblpainter.setFont(new Font("serif",Font.PLAIN,30));
        lblpainter.setForeground(new Color(0,0,0));
        jf.add(lblpainter);
        
        lblbabysitter = new JLabel("BABY SITTER");
        lblbabysitter.setBounds(25,270,400,40);
        lblbabysitter.setFont(new Font("serif",Font.PLAIN,30));
        lblbabysitter.setForeground(new Color(0,0,0));
        jf.add(lblbabysitter);
        
        lbllaundary = new JLabel("LAUNDARY");
        lbllaundary.setBounds(25,320,400,40);
        lbllaundary.setFont(new Font("serif",Font.PLAIN,30));
        lbllaundary.setForeground(new Color(0,0,0));
        jf.add(lbllaundary);
        
        lbltutor = new JLabel("TUTOR");
        lbltutor.setBounds(25,370,400,40);
        lbltutor.setFont(new Font("serif",Font.PLAIN,30));
        lbltutor.setForeground(new Color(0,0,0));
        jf.add(lbltutor);
        
        lblcarpenter = new JLabel("CARPENTER");
        lblcarpenter.setBounds(25,420,400,40);
        lblcarpenter.setFont(new Font("serif",Font.PLAIN,30));
        lblcarpenter.setForeground(new Color(0,0,0));
        jf.add(lblcarpenter);
        
        lblmaid = new JLabel("MAID");
        lblmaid.setBounds(25,470,400,40);
        lblmaid.setFont(new Font("serif",Font.PLAIN,30));
        lblmaid.setForeground(new Color(0,0,0));
        jf.add(lblmaid);
        
        show_names();
        
        show_contacts();
        
        bdone=new JButton("DONE");
        bdone.setBounds(360,530,100,35);
        bdone.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        bdone.setForeground(Color.WHITE);
        bdone.setBackground(Color.BLACK);
        bdone.addActionListener(this);
        jf.add(bdone); 
        
        jf.setVisible(true);
    }
    public void show_names()
    {
        //JLabel Name Details
        lblelectrician_name= new JLabel();
        lblelectrician_name.setBounds(360,120,400,40);
        lblelectrician_name.setFont(new Font("serif",Font.PLAIN,30));
        lblelectrician_name.setForeground(new Color(0,0,0));
        jf.add(lblelectrician_name);
        
        lblplumber_name = new JLabel();
        lblplumber_name.setBounds(360,170,400,40);
        lblplumber_name.setFont(new Font("serif",Font.PLAIN,30));
        lblplumber_name.setForeground(new Color(0,0,0));
        jf.add(lblplumber_name);
        
        lblpainter_name = new JLabel();
        lblpainter_name.setBounds(360,220,400,40);
        lblpainter_name.setFont(new Font("serif",Font.PLAIN,30));
        lblpainter_name.setForeground(new Color(0,0,0));
        jf.add(lblpainter_name);
        
        lblbabysitter_name= new JLabel();
        lblbabysitter_name.setBounds(360,270,400,40);
        lblbabysitter_name.setFont(new Font("serif",Font.PLAIN,30));
        lblbabysitter_name.setForeground(new Color(0,0,0));
        jf.add(lblbabysitter_name);
        
        lbllaundary_name = new JLabel();
        lbllaundary_name.setBounds(360,320,400,40);
        lbllaundary_name.setFont(new Font("serif",Font.PLAIN,30));
        lbllaundary_name.setForeground(new Color(0,0,0));
        jf.add(lbllaundary_name);
        
        lbltutor_name = new JLabel();
        lbltutor_name.setBounds(360,370,400,40);
        lbltutor_name.setFont(new Font("serif",Font.PLAIN,30));
        lbltutor_name.setForeground(new Color(0,0,0));
        jf.add(lbltutor_name);
        
        lblcarpenter_name = new JLabel();
        lblcarpenter_name.setBounds(360,420,400,40);
        lblcarpenter_name.setFont(new Font("serif",Font.PLAIN,30));
        lblcarpenter_name.setForeground(new Color(0,0,0));
        jf.add(lblcarpenter_name);
        
        lblmaid_name = new JLabel();
        lblmaid_name.setBounds(360,470,400,40);
        lblmaid_name.setFont(new Font("serif",Font.PLAIN,30));
        lblmaid_name.setForeground(new Color(0,0,0));
        jf.add(lblmaid_name);
        try
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from services;");
            while(rs.next())
            {
                if(rs.getString("SERVICE").equals("ELECTRICIAN"))
                {
                    electrician_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("SERVICE").equals("PLUMBER"))
                {
                    plumber_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("SERVICE").equals("PAINTER"))
                {
                    painter_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("SERVICE").equals("BABY SITTER"))
                {
                    babysitter_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("SERVICE").equals("LAUNDARY"))
                {
                    laundary_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("SERVICE").equals("TUTOR"))
                {
                    tutor_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("SERVICE").equals("CARPENTER"))
                {
                    carpenter_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("SERVICE").equals("MAID"))
                {
                    maid_name=rs.getString("NAME");
                    continue;
                }
            }
        }
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        lblelectrician_name.setText(electrician_name);
        lblplumber_name.setText(plumber_name);
        lblpainter_name.setText(painter_name);
        lblbabysitter_name.setText(babysitter_name);
        lbllaundary_name.setText(laundary_name);
        lbltutor_name.setText(tutor_name);
        lblcarpenter_name.setText(carpenter_name);
        lblmaid_name.setText(maid_name);        
    }
    
    public void show_contacts()
    {
        //JLabel Name Details
        lblelectrician_contact= new JLabel();
        lblelectrician_contact.setBounds(630,120,400,40);
        lblelectrician_contact.setFont(new Font("serif",Font.PLAIN,30));
        lblelectrician_contact.setForeground(new Color(0,0,0));
        jf.add(lblelectrician_contact);
        
        lblplumber_contact = new JLabel();
        lblplumber_contact.setBounds(630,170,400,40);
        lblplumber_contact.setFont(new Font("serif",Font.PLAIN,30));
        lblplumber_contact.setForeground(new Color(0,0,0));
        jf.add(lblplumber_contact);
        
        lblpainter_contact = new JLabel();
        lblpainter_contact.setBounds(630,220,400,40);
        lblpainter_contact.setFont(new Font("serif",Font.PLAIN,30));
        lblpainter_contact.setForeground(new Color(0,0,0));
        jf.add(lblpainter_contact);
        
        lblbabysitter_contact= new JLabel();
        lblbabysitter_contact.setBounds(630,270,400,40);
        lblbabysitter_contact.setFont(new Font("serif",Font.PLAIN,30));
        lblbabysitter_contact.setForeground(new Color(0,0,0));
        jf.add(lblbabysitter_contact);
        
        lbllaundary_contact = new JLabel();
        lbllaundary_contact.setBounds(630,320,400,40);
        lbllaundary_contact.setFont(new Font("serif",Font.PLAIN,30));
        lbllaundary_contact.setForeground(new Color(0,0,0));
        jf.add(lbllaundary_contact);
        
        lbltutor_contact = new JLabel();
        lbltutor_contact.setBounds(630,370,400,40);
        lbltutor_contact.setFont(new Font("serif",Font.PLAIN,30));
        lbltutor_contact.setForeground(new Color(0,0,0));
        jf.add(lbltutor_contact);
        
        lblcarpenter_contact = new JLabel();
        lblcarpenter_contact.setBounds(630,420,400,40);
        lblcarpenter_contact.setFont(new Font("serif",Font.PLAIN,30));
        lblcarpenter_contact.setForeground(new Color(0,0,0));
        jf.add(lblcarpenter_contact);
        
        lblmaid_contact = new JLabel();
        lblmaid_contact.setBounds(630,470,400,40);
        lblmaid_contact.setFont(new Font("serif",Font.PLAIN,30));
        lblmaid_contact.setForeground(new Color(0,0,0));
        jf.add(lblmaid_contact);
        try
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from services;");
            while(rs.next())
            {
                if(rs.getString("SERVICE").equals("ELECTRICIAN"))
                {
                    electrician_contact=rs.getString("CONTACT");
                    continue;
                }
                if(rs.getString("SERVICE").equals("PLUMBER"))
                {
                    plumber_contact=rs.getString("CONTACT");
                    continue;
                }
                if(rs.getString("SERVICE").equals("PAINTER"))
                {
                    painter_contact=rs.getString("CONTACT");
                    continue;
                }
                if(rs.getString("SERVICE").equals("BABY SITTER"))
                {
                    babysitter_contact=rs.getString("CONTACT");
                    continue;
                }
                if(rs.getString("SERVICE").equals("LAUNDARY"))
                {
                    laundary_contact=rs.getString("CONTACT");
                    continue;
                }
                if(rs.getString("SERVICE").equals("TUTOR"))
                {
                    tutor_contact=rs.getString("CONTACT");
                    continue;
                }
                if(rs.getString("SERVICE").equals("CARPENTER"))
                {
                    carpenter_contact=rs.getString("CONTACT");
                    continue;
                }
                if(rs.getString("SERVICE").equals("MAID"))
                {
                    maid_contact=rs.getString("CONTACT");
                    continue;
                }
            }
        }
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        lblelectrician_contact.setText(electrician_contact);
        lblplumber_contact.setText(plumber_contact);
        lblpainter_contact.setText(painter_contact);
        lblbabysitter_contact.setText(babysitter_contact);
        lbllaundary_contact.setText(laundary_contact);
        lbltutor_contact.setText(tutor_contact);
        lblcarpenter_contact.setText(carpenter_contact);
        lblmaid_contact.setText(maid_contact);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bdone)
        {
            jf.dispose();
            MainPage mp=new MainPage();
        }
    }
}

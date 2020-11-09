package Members;
import Databases.Databasec1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import societymanagementsystem.MainPage;
public class SocietyMembers implements ActionListener
{
    JFrame jf;
    JLabel lbltitle,lblnameofmem,lbldesignation,lblchairman,lblsec,lbltreasurer,lblmem1,lblmem2,lblmem3,lblmem4,lblmem5,lblmem6,lblmem7,lblmem8;
    JLabel lblchairman_name,lblsec_name,lbltreasurer_name,lblmem1_name,lblmem2_name,lblmem3_name,lblmem4_name,lblmem5_name,lblmem6_name,lblmem7_name,lblmem8_name;
    String chairman_name,sec_name,treasurer_name,mem1_name,mem2_name,mem3_name,mem4_name,mem5_name,mem6_name,mem7_name,mem8_name;
    JButton bupdate,bback;
    public SocietyMembers()
    {
        //Frame details
        jf=new JFrame("SOCIETY MEMBERS");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(5,5);
        jf.setSize(650,725);
        
        //Title
        lbltitle = new JLabel("SOCIETY MEMBERS");
        lbltitle.setBounds(125,0,400,50);
        lbltitle.setFont(new Font("serif",Font.PLAIN,42));
        lbltitle.setForeground(new Color(90,76,218));
        jf.add(lbltitle);
        
        //JLabel Details
        lblnameofmem = new JLabel("NAME OF MEMBERS");
        lblnameofmem.setBounds(25,50,400,50);
        lblnameofmem.setFont(new Font("serif",Font.PLAIN,30));
        lblnameofmem.setForeground(new Color(240,28,85));
        jf.add(lblnameofmem);
        
        lbldesignation = new JLabel("DESIGNATION");
        lbldesignation.setBounds(400,50,400,50);
        lbldesignation.setFont(new Font("serif",Font.PLAIN,30));
        lbldesignation.setForeground(new Color(240,28,85));
        jf.add(lbldesignation);
        
        
        lblchairman = new JLabel("CHAIRMAN");
        lblchairman.setBounds(400,100,400,40);
        lblchairman.setFont(new Font("serif",Font.PLAIN,30));
        lblchairman.setForeground(new Color(0,0,0));
        jf.add(lblchairman);
        
        lblsec = new JLabel("SECRETARY");
        lblsec.setBounds(400,150,400,40);
        lblsec.setFont(new Font("serif",Font.PLAIN,30));
        lblsec.setForeground(new Color(0,0,0));
        jf.add(lblsec);
        
        lbltreasurer = new JLabel("TREASURER");
        lbltreasurer.setBounds(400,200,400,40);
        lbltreasurer.setFont(new Font("serif",Font.PLAIN,30));
        lbltreasurer.setForeground(new Color(0,0,0));
        jf.add(lbltreasurer);
        
        lblmem1 = new JLabel("MEMBER");
        lblmem1.setBounds(400,250,400,40);
        lblmem1.setFont(new Font("serif",Font.PLAIN,30));
        lblmem1.setForeground(new Color(0,0,0));
        jf.add(lblmem1);
        
        lblmem2 = new JLabel("MEMBER");
        lblmem2.setBounds(400,300,400,40);
        lblmem2.setFont(new Font("serif",Font.PLAIN,30));
        lblmem2.setForeground(new Color(0,0,0));
        jf.add(lblmem2);
        
        lblmem3 = new JLabel("MEMBER");
        lblmem3.setBounds(400,350,400,40);
        lblmem3.setFont(new Font("serif",Font.PLAIN,30));
        lblmem3.setForeground(new Color(0,0,0));
        jf.add(lblmem3);
        
        lblmem4 = new JLabel("MEMBER");
        lblmem4.setBounds(400,400,400,40);
        lblmem4.setFont(new Font("serif",Font.PLAIN,30));
        lblmem4.setForeground(new Color(0,0,0));
        jf.add(lblmem4);
        
        lblmem5 = new JLabel("MEMBER");
        lblmem5.setBounds(400,450,400,40);
        lblmem5.setFont(new Font("serif",Font.PLAIN,30));
        lblmem5.setForeground(new Color(0,0,0));
        jf.add(lblmem5);
        
        lblmem6 = new JLabel("MEMBER");
        lblmem6.setBounds(400,500,400,40);
        lblmem6.setFont(new Font("serif",Font.PLAIN,30));
        lblmem6.setForeground(new Color(0,0,0));
        jf.add(lblmem6);
        
        lblmem7 = new JLabel("MEMBER");
        lblmem7.setBounds(400,550,400,40);
        lblmem7.setFont(new Font("serif",Font.PLAIN,30));
        lblmem7.setForeground(new Color(0,0,0));
        jf.add(lblmem7);
        
        lblmem8 = new JLabel("MEMBER");
        lblmem8.setBounds(400,600,400,40);
        lblmem8.setFont(new Font("serif",Font.PLAIN,30));
        lblmem8.setForeground(new Color(0,0,0));
        jf.add(lblmem8);
        
        display_names();
        
        //Update and Cancel Button
        bupdate=new JButton("UPDATE");
        bupdate.setBounds(195,645,110,35);
        bupdate.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bupdate.setForeground(Color.WHITE);
        bupdate.setBackground(Color.BLACK);
        jf.add(bupdate);
        
        bback=new JButton("BACK");
        bback.setBounds(325,645,100,35);
        bback.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bback.setForeground(Color.WHITE);
        bback.setBackground(Color.BLACK);
        jf.add(bback); 
        
        bupdate.addActionListener(this);
        bback.addActionListener(this);
        
        jf.setVisible(true);       
    }
    public void display_names()
    {
        //JLabel Name Details
        lblchairman_name= new JLabel();
        lblchairman_name.setBounds(25,100,400,40);
        lblchairman_name.setFont(new Font("serif",Font.PLAIN,30));
        lblchairman_name.setForeground(new Color(0,0,0));
        jf.add(lblchairman_name);
        
        lblsec_name = new JLabel();
        lblsec_name.setBounds(25,150,400,40);
        lblsec_name.setFont(new Font("serif",Font.PLAIN,30));
        lblsec_name.setForeground(new Color(0,0,0));
        jf.add(lblsec_name);
        
        lbltreasurer_name = new JLabel();
        lbltreasurer_name.setBounds(25,200,400,40);
        lbltreasurer_name.setFont(new Font("serif",Font.PLAIN,30));
        lbltreasurer_name.setForeground(new Color(0,0,0));
        jf.add(lbltreasurer_name);
        
        lblmem1_name= new JLabel();
        lblmem1_name.setBounds(25,250,400,40);
        lblmem1_name.setFont(new Font("serif",Font.PLAIN,30));
        lblmem1_name.setForeground(new Color(0,0,0));
        jf.add(lblmem1_name);
        
        lblmem2_name = new JLabel();
        lblmem2_name.setBounds(25,300,400,40);
        lblmem2_name.setFont(new Font("serif",Font.PLAIN,30));
        lblmem2_name.setForeground(new Color(0,0,0));
        jf.add(lblmem2_name);
        
        lblmem3_name = new JLabel();
        lblmem3_name.setBounds(25,350,400,40);
        lblmem3_name.setFont(new Font("serif",Font.PLAIN,30));
        lblmem3_name.setForeground(new Color(0,0,0));
        jf.add(lblmem3_name);
        
        lblmem4_name = new JLabel();
        lblmem4_name.setBounds(25,400,400,40);
        lblmem4_name.setFont(new Font("serif",Font.PLAIN,30));
        lblmem4_name.setForeground(new Color(0,0,0));
        jf.add(lblmem4_name);
        
        lblmem5_name = new JLabel();
        lblmem5_name.setBounds(25,450,400,40);
        lblmem5_name.setFont(new Font("serif",Font.PLAIN,30));
        lblmem5_name.setForeground(new Color(0,0,0));
        jf.add(lblmem5_name);
        
        lblmem6_name = new JLabel();
        lblmem6_name.setBounds(25,500,400,40);
        lblmem6_name.setFont(new Font("serif",Font.PLAIN,30));
        lblmem6_name.setForeground(new Color(0,0,0));
        jf.add(lblmem6_name);
        
        lblmem7_name = new JLabel();
        lblmem7_name.setBounds(25,550,400,40);
        lblmem7_name.setFont(new Font("serif",Font.PLAIN,30));
        lblmem7_name.setForeground(new Color(0,0,0));
        jf.add(lblmem7_name);
        
        lblmem8_name = new JLabel();
        lblmem8_name.setBounds(25,600,400,40);
        lblmem8_name.setFont(new Font("serif",Font.PLAIN,30));
        lblmem8_name.setForeground(new Color(0,0,0));
        jf.add(lblmem8_name); 
        
        //Set names
        try 
        {
            Databasec1 c=new Databasec1();
            ResultSet rs = c.s.executeQuery("select * from members;");
            while(rs.next())
            {
                if(rs.getString("DESIGNATION").equals("CHAIRMAN"))
                {
                    chairman_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("SECRETARY"))
                {
                    sec_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("TREASURER"))
                {
                    treasurer_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 1"))
                {
                    mem1_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 2"))
                {
                    mem2_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 3"))
                {
                    mem3_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 4"))
                {
                    mem4_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 5"))
                {
                    mem5_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 6"))
                {
                    mem6_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 7"))
                {
                    mem7_name=rs.getString("NAME");
                    continue;
                }
                if(rs.getString("DESIGNATION").equals("MEMBER 8"))
                {
                    mem8_name=rs.getString("NAME");
                    continue;
                }
            }
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        lblchairman_name.setText(chairman_name);
        lblsec_name.setText(sec_name);
        lbltreasurer_name.setText(treasurer_name);
        lblmem1_name.setText(mem1_name);
        lblmem2_name.setText(mem2_name);
        lblmem3_name.setText(mem3_name);
        lblmem4_name.setText(mem4_name);
        lblmem5_name.setText(mem5_name);
        lblmem6_name.setText(mem6_name);
        lblmem7_name.setText(mem7_name);
        lblmem8_name.setText(mem8_name);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bback)
        {
            jf.dispose();
            MainPage mp=new MainPage();
        }
        else if(ae.getSource()==bupdate)
        {
            jf.dispose();
            UpdateMembers um=new UpdateMembers();
        }
        
    }
    public static void main(String args[])
    {
        SocietyMembers sm=new SocietyMembers();
    }
}

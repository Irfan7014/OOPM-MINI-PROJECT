package Members;
import Databases.Databasec1;
import Databases.MembersDao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
public class UpdateMembers implements ActionListener
{
    JFrame jf;
    JLabel lbltitle,lblnameofmem,lbldesignation,lblchairman,lblsec,lbltreasurer,lblmem1,lblmem2,lblmem3,lblmem4,lblmem5,lblmem6,lblmem7,lblmem8;
    JTextField tchairman_name,tsec_name,ttreasurer_name,tmem1_name,tmem2_name,tmem3_name,tmem4_name,tmem5_name,tmem6_name,tmem7_name,tmem8_name;
    String chairman_name,sec_name,treasurer_name,mem1_name,mem2_name,mem3_name,mem4_name,mem5_name,mem6_name,mem7_name,mem8_name;
    JButton bupdate,bback;
    public UpdateMembers()
    {
        //Frame details
        jf=new JFrame("UPDATE MEMBERS LIST");
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
        lblnameofmem.setBounds(325,50,400,50);
        lblnameofmem.setFont(new Font("serif",Font.PLAIN,30));
        lblnameofmem.setForeground(new Color(240,28,85));
        jf.add(lblnameofmem);
        
        lbldesignation = new JLabel("DESIGNATION");
        lbldesignation.setBounds(25,50,400,50);
        lbldesignation.setFont(new Font("serif",Font.PLAIN,30));
        lbldesignation.setForeground(new Color(240,28,85));
        jf.add(lbldesignation);
        
        
        lblchairman = new JLabel("CHAIRMAN");
        lblchairman.setBounds(25,100,400,40);
        lblchairman.setFont(new Font("serif",Font.PLAIN,30));
        lblchairman.setForeground(new Color(0,0,0));
        jf.add(lblchairman);
        
        lblsec = new JLabel("SECRETARY");
        lblsec.setBounds(25,150,400,40);
        lblsec.setFont(new Font("serif",Font.PLAIN,30));
        lblsec.setForeground(new Color(0,0,0));
        jf.add(lblsec);
        
        lbltreasurer = new JLabel("TREASURER");
        lbltreasurer.setBounds(25,200,400,40);
        lbltreasurer.setFont(new Font("serif",Font.PLAIN,30));
        lbltreasurer.setForeground(new Color(0,0,0));
        jf.add(lbltreasurer);
        
        lblmem1 = new JLabel("MEMBER 1");
        lblmem1.setBounds(25,250,400,40);
        lblmem1.setFont(new Font("serif",Font.PLAIN,30));
        lblmem1.setForeground(new Color(0,0,0));
        jf.add(lblmem1);
        
        lblmem2 = new JLabel("MEMBER 2");
        lblmem2.setBounds(25,300,400,40);
        lblmem2.setFont(new Font("serif",Font.PLAIN,30));
        lblmem2.setForeground(new Color(0,0,0));
        jf.add(lblmem2);
        
        lblmem3 = new JLabel("MEMBER 3");
        lblmem3.setBounds(25,350,400,40);
        lblmem3.setFont(new Font("serif",Font.PLAIN,30));
        lblmem3.setForeground(new Color(0,0,0));
        jf.add(lblmem3);
        
        lblmem4 = new JLabel("MEMBER 4");
        lblmem4.setBounds(25,400,400,40);
        lblmem4.setFont(new Font("serif",Font.PLAIN,30));
        lblmem4.setForeground(new Color(0,0,0));
        jf.add(lblmem4);
        
        lblmem5 = new JLabel("MEMBER 5");
        lblmem5.setBounds(25,450,400,40);
        lblmem5.setFont(new Font("serif",Font.PLAIN,30));
        lblmem5.setForeground(new Color(0,0,0));
        jf.add(lblmem5);
        
        lblmem6 = new JLabel("MEMBER 6");
        lblmem6.setBounds(25,500,400,40);
        lblmem6.setFont(new Font("serif",Font.PLAIN,30));
        lblmem6.setForeground(new Color(0,0,0));
        jf.add(lblmem6);
        
        lblmem7 = new JLabel("MEMBER 7");
        lblmem7.setBounds(25,550,400,40);
        lblmem7.setFont(new Font("serif",Font.PLAIN,30));
        lblmem7.setForeground(new Color(0,0,0));
        jf.add(lblmem7);
        
        lblmem8 = new JLabel("MEMBER 8");
        lblmem8.setBounds(25,600,400,40);
        lblmem8.setFont(new Font("serif",Font.PLAIN,30));
        lblmem8.setForeground(new Color(0,0,0));
        jf.add(lblmem8);
        
        //Update and Cancel Button
        bupdate=new JButton("UPDATE LIST");
        bupdate.setBounds(160,645,200,35);
        bupdate.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bupdate.setForeground(Color.WHITE);
        bupdate.setBackground(Color.BLACK);
        jf.add(bupdate);
        
        bback=new JButton("BACK");
        bback.setBounds(385,645,100,35);
        bback.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bback.setForeground(Color.WHITE);
        bback.setBackground(Color.BLACK);
        jf.add(bback); 
        
        bupdate.addActionListener(this);
        bback.addActionListener(this);
        
        //JLabel Name Details
        tchairman_name= new JTextField();
        tchairman_name.setBounds(325,100,300,40);
        tchairman_name.setFont(new Font("serif",Font.PLAIN,30));
        tchairman_name.setForeground(new Color(0,0,0));
        jf.add(tchairman_name);
        
        tsec_name = new JTextField();
        tsec_name.setBounds(325,150,300,40);
        tsec_name.setFont(new Font("serif",Font.PLAIN,30));
        tsec_name.setForeground(new Color(0,0,0));
        jf.add(tsec_name);
        
        ttreasurer_name = new JTextField();
        ttreasurer_name.setBounds(325,200,300,40);
        ttreasurer_name.setFont(new Font("serif",Font.PLAIN,30));
        ttreasurer_name.setForeground(new Color(0,0,0));
        jf.add(ttreasurer_name);
        
        tmem1_name= new JTextField();
        tmem1_name.setBounds(325,250,300,40);
        tmem1_name.setFont(new Font("serif",Font.PLAIN,30));
        tmem1_name.setForeground(new Color(0,0,0));
        jf.add(tmem1_name);
        
        tmem2_name = new JTextField();
        tmem2_name.setBounds(325,300,300,40);
        tmem2_name.setFont(new Font("serif",Font.PLAIN,30));
        tmem2_name.setForeground(new Color(0,0,0));
        jf.add(tmem2_name);
        
        tmem3_name = new JTextField();
        tmem3_name.setBounds(325,350,300,40);
        tmem3_name.setFont(new Font("serif",Font.PLAIN,30));
        tmem3_name.setForeground(new Color(0,0,0));
        jf.add(tmem3_name);
        
        tmem4_name = new JTextField();
        tmem4_name.setBounds(325,400,300,40);
        tmem4_name.setFont(new Font("serif",Font.PLAIN,30));
        tmem4_name.setForeground(new Color(0,0,0));
        jf.add(tmem4_name);
        
        tmem5_name = new JTextField();
        tmem5_name.setBounds(325,450,300,40);
        tmem5_name.setFont(new Font("serif",Font.PLAIN,30));
        tmem5_name.setForeground(new Color(0,0,0));
        jf.add(tmem5_name);
        
        tmem6_name = new JTextField();
        tmem6_name.setBounds(325,500,300,40);
        tmem6_name.setFont(new Font("serif",Font.PLAIN,30));
        tmem6_name.setForeground(new Color(0,0,0));
        jf.add(tmem6_name);
        
        tmem7_name = new JTextField();
        tmem7_name.setBounds(325,550,300,40);
        tmem7_name.setFont(new Font("serif",Font.PLAIN,30));
        tmem7_name.setForeground(new Color(0,0,0));
        jf.add(tmem7_name);
        
        tmem8_name = new JTextField();
        tmem8_name.setBounds(325,600,300,40);
        tmem8_name.setFont(new Font("serif",Font.PLAIN,30));
        tmem8_name.setForeground(new Color(0,0,0));
        jf.add(tmem8_name); 
        
        jf.setVisible(true);       
    }
    public void update_names()
    {
        ArrayList<String> members=new ArrayList<String>();
        members.add(tchairman_name.getText());
        members.add(tsec_name.getText());
        members.add(ttreasurer_name.getText());
        members.add(tmem1_name.getText());
        members.add(tmem2_name.getText());
        members.add(tmem3_name.getText());
        members.add(tmem4_name.getText());
        members.add(tmem5_name.getText());
        members.add(tmem6_name.getText());
        members.add(tmem7_name.getText());
        members.add(tmem8_name.getText());
        
        MembersDao membersdao=new MembersDao();
        membersdao.updateMembersList(members);
        jf.dispose();
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bupdate)
        {
            update_names();
            jf.dispose();
            SocietyMembers sm=new SocietyMembers();
        }
        else if(ae.getSource()==bback)
        {
            jf.dispose();
            SocietyMembers sm=new SocietyMembers();
        }
    }
    public static void main(String args[])
    {
        UpdateMembers um=new UpdateMembers();
    }
}

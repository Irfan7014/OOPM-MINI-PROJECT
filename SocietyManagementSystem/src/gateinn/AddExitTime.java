package gateinn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddExitTime implements ActionListener
{
    JFrame jf;
    JLabel lbltitle,lblname,lblphone,lbldate,lblentrytime,lblexittime;
    JTextField tname,tphone,tdate,tentrytime,texittime;
    JButton bupdate,bback,bview,bsearch,bcancel;
    boolean check=false;
    String name,phone,date,entryTime,watchman,gate;
    public AddExitTime(String w,String g)
    {
        watchman=w;
        gate=g;
        //Frame details
        jf=new JFrame("ADD EXIT TIME");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(30,30);
        jf.setSize(500,500);
        
        //Label details
        //Title
        lbltitle = new JLabel("ENTER DETAILS TO UPDATE EXIT TIME");
        lbltitle.setBounds(25,5,450,50);
        lbltitle.setFont(new Font("serif",Font.ITALIC,24));
        lbltitle.setForeground(Color.BLUE);
        jf.add(lbltitle);
        
        //1.Name
        lblname = new JLabel("Name Of Visitor:- ");
        lblname.setBounds(30,50,190,30);
        lblname.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblname.setForeground(Color.BLACK);
        jf.add(lblname);
        
        tname=new JTextField();
        tname.setBounds(240,50,240,30);
        tname.setFont(new Font("serif",Font.PLAIN,18));
        tname.setForeground(Color.BLACK);
        jf.add(tname);
        
        //2.Phone
        lblphone = new JLabel("Phone No. Of Visitor:- ");
        lblphone.setBounds(30,100,200,30);
        lblphone.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblphone.setForeground(Color.BLACK);
        jf.add(lblphone);
        
        tphone=new JTextField();
        tphone.setBounds(240,100,240,30);
        tphone.setFont(new Font("serif",Font.PLAIN,18));
        tphone.setForeground(Color.BLACK);
        jf.add(tphone);
        
        //3.Date
        lbldate = new JLabel("Date:- ");
        lbldate.setBounds(30,150,190,30);
        lbldate.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lbldate.setForeground(Color.BLACK);
        jf.add(lbldate);
        
        tdate=new JTextField();
        tdate.setBounds(240,150,240,30);
        tdate.setFont(new Font("serif",Font.PLAIN,18));
        tdate.setForeground(Color.BLACK);
        jf.add(tdate);
        
        //4.Entry Time
        lblentrytime = new JLabel("Entry Time:- ");
        lblentrytime.setBounds(30,200,190,30);
        lblentrytime.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblentrytime.setForeground(Color.BLACK);
        jf.add(lblentrytime);
        
        tentrytime=new JTextField();
        tentrytime.setBounds(240,200,240,30);
        tentrytime.setFont(new Font("serif",Font.PLAIN,18));
        tentrytime.setForeground(Color.BLACK);
        jf.add(tentrytime);
        
        //5.Exit Time
        lblexittime = new JLabel("Exit Time:- ");
        lblexittime.setBounds(30,320,190,30);
        lblexittime.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblexittime.setForeground(Color.BLACK);
        jf.add(lblexittime);
        
        texittime=new JTextField();
        texittime.setBounds(240,320,240,30);
        texittime.setFont(new Font("serif",Font.PLAIN,18));
        texittime.setForeground(Color.BLACK);
        texittime.setText(" ");
        jf.add(texittime);
        
        //Button Details
        bsearch=new JButton("SEARCH");
        bsearch.setBounds(30,250,120,40);
        bsearch.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bsearch.setForeground(Color.WHITE);
        bsearch.setBackground(Color.BLACK);
        jf.add(bsearch);
        
        bcancel=new JButton("CANCEL");
        bcancel.setBounds(180,250,120,40);
        bcancel.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bcancel.setForeground(Color.WHITE);
        bcancel.setBackground(Color.BLACK);
        jf.add(bcancel);     
        
        bupdate=new JButton("UPDATE");
        bupdate.setBounds(45,370,120,40);
        bupdate.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bupdate.setForeground(Color.WHITE);
        bupdate.setBackground(Color.BLACK);
        jf.add(bupdate);
        
        bview=new JButton("VIEW");
        bview.setBounds(185,370,120,40);
        bview.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bview.setForeground(Color.WHITE);
        bview.setBackground(Color.BLACK);
        jf.add(bview);    
        
        bback=new JButton("BACK");
        bback.setBounds(325,370,120,40);
        bback.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bback.setForeground(Color.WHITE);
        bback.setBackground(Color.BLACK);
        jf.add(bback);
        
        bupdate.addActionListener(this);
        bback.addActionListener(this);
        bview.addActionListener(this);
        bsearch.addActionListener(this);
        bcancel.addActionListener(this);
        
        lblexittime.setVisible(false);
        texittime.setVisible(false);
        bupdate.setVisible(false);
        bback.setVisible(false);
        bview.setVisible(false);
        
        jf.setVisible(true);
    }
    public void Search()
    {
        String q;
        name=tname.getText();
        phone=tphone.getText();
        date=tdate.getText();
        entryTime=tentrytime.getText();
        GateDao gatedao=new GateDao();
        check=gatedao.checkForExitTime(name, phone, date, entryTime);
        if(check)
        {
            lblexittime.setVisible(true);
            texittime.setVisible(true);
            bupdate.setVisible(true);
            bback.setVisible(true);
            bview.setVisible(true);
        }
        if(!check)
        {
            jf.dispose();
            JOptionPane.showMessageDialog(null,"NO SUCH VISITOR FOUND");
            AddExitTime aet=new AddExitTime(watchman,gate);
        }
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bcancel)
        {
            jf.dispose();
            Entry e=new Entry(watchman,gate);
        }
        if(ae.getSource()==bview)
        {
            jf.dispose();
            ViewVisitors v=new ViewVisitors();
        }
        if(ae.getSource()==bback)
        {
            jf.dispose();
            Entry e=new Entry(watchman,gate);
        }
        if(ae.getSource()==bsearch)
        {
            Search();
        }
        if(ae.getSource()==bupdate && check)
        {
            GateDao gatedao=new GateDao();
            gatedao.addExitTime(name,phone,date,entryTime,texittime.getText()); 
            jf.dispose();
            AddExitTime aet=new AddExitTime(watchman,gate);            
        }
    }
}

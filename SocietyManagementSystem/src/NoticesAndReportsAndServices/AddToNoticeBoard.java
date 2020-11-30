package NoticesAndReportsAndServices;

import Databases.NoticesDao;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AddToNoticeBoard implements ActionListener
{
    JFrame jf;
    JLabel lblTitle,lblName,lblPath;
    JTextField tName,tPath;
    JButton btnAdd,btnBack;
    public AddToNoticeBoard()
    {
        //Frame Details
        jf=new JFrame("ADD NOTICE'S");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(100, 100);
        jf.setSize(750, 450);
        
        //Title
        lblTitle = new JLabel("INPUT NOTICE DETAILS");
        lblTitle.setBounds(15, 10, 550, 55);
        lblTitle.setFont(new Font("SANS-SERIF", Font.BOLD, 45));
        lblTitle.setForeground(Color.ORANGE);
        jf.add(lblTitle);
        
        //JLabel Name
        lblName = new JLabel("DISPLAY NAME OF FILE:- ");
        lblName.setBounds(30, 100, 320, 35);
        lblName.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        lblName.setForeground(Color.BLACK);
        jf.add(lblName);
        
        //JTextField Name
        tName = new JTextField();
        tName.setBounds(360, 100, 300, 40);
        tName.setFont(new Font("serif", Font.PLAIN, 28));
        tName.setForeground(Color.BLACK);
        jf.add(tName);
        
        //JLabel Path
        lblPath = new JLabel("ENTER FILE NAME:- ");
        lblPath.setBounds(30, 200, 300, 40);
        lblPath.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        lblPath.setForeground(Color.BLACK);
        jf.add(lblPath);
        
        //JTextField Path
        tPath = new JTextField();
        tPath.setBounds(360, 200, 300, 40);
        tPath.setFont(new Font("serif", Font.PLAIN, 28));
        tPath.setForeground(Color.BLACK);
        jf.add(tPath);
        
        //JButton Add Notice
        btnAdd=new JButton("ADD NOTICE");
        btnAdd.setBounds(210,300,150,30);
        btnAdd.setBackground(Color.RED);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,18));
        btnAdd.addActionListener(this);
        jf.add(btnAdd);
        
        //JButton Back
        btnBack=new JButton("BACK");
        btnBack.setBounds(390,300,100,30);
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,18));
        btnBack.addActionListener(this);
        jf.add(btnBack);
        
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btnBack)
        {
            jf.dispose();
            NoticeBoard noticeBoard=new NoticeBoard();            
        }
        if(ae.getSource()==btnAdd)
        {
            NoticesDao noticesDao=new NoticesDao();
            int noticesCount=noticesDao.countNotices();
            if(noticesCount==5)
            {
                jf.dispose();
                JOptionPane.showMessageDialog(null,"The Number Of Notices Have Reached\nIts Maximum Value Of  '5' Remove To\nAdd More");
                new AddToNoticeBoard();
            }
            else
            {
                System.out.println("HELLO");
                System.out.println(tName.getText()+" : "+tPath.getText());
                noticesDao.addNotices(tName.getText(), tPath.getText());
            }
                
        }
    }
    public static void main(String args[])
    {
        new AddToNoticeBoard();
    }
}

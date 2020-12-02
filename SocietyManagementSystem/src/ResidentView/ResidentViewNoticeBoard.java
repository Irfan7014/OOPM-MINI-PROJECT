package ResidentView;

import Databases.NoticesDao;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ResidentViewNoticeBoard implements ActionListener
{
    JFrame jf;
    JLabel Notice1,Notice2,Notice3,Notice4,Notice5;
    JLabel lblTitle;
    JButton btnAdd,btnRemove,btnBack;
    public ResidentViewNoticeBoard()
    {
        //Frame Details
        jf=new JFrame("ADD NOTICE'S");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(100, 100);
        jf.setSize(750, 610);
        
        //Title
        lblTitle = new JLabel("NOTICE BOARD");
        lblTitle.setBounds(200, 10, 350, 55);
        lblTitle.setFont(new Font("SANS-SERIF", Font.BOLD, 45));
        lblTitle.setForeground(Color.ORANGE);
        jf.add(lblTitle);
        
        //JLabel Name
        Notice1 = new JLabel();
        Notice1.setBounds(30, 120, 300, 35);
        Notice1.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        Notice1.setForeground(Color.BLACK);
        jf.add(Notice1);
        
        Notice2 = new JLabel();
        Notice2.setBounds(30, 205, 300, 35);
        Notice2.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        Notice2.setForeground(Color.BLACK);
        jf.add(Notice2);
        
        Notice3 = new JLabel();
        Notice3.setBounds(30, 290, 300, 35);
        Notice3.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        Notice3.setForeground(Color.BLACK);
        jf.add(Notice3);
        
        Notice4 = new JLabel();
        Notice4.setBounds(30, 375, 300, 35);
        Notice4.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        Notice4.setForeground(Color.BLACK);
        jf.add(Notice4);
        
        Notice5 = new JLabel();
        Notice5.setBounds(30, 460, 300, 35);
        Notice5.setFont(new Font("Times_New_Roman", Font.BOLD, 25));
        Notice5.setForeground(Color.BLACK);
        jf.add(Notice5);
        
        JLabel notices[]={Notice1,Notice2,Notice3,Notice4,Notice5};
        NoticesDao noticeDao=new NoticesDao();
        ArrayList<String> names=noticeDao.getName();
        for(int i=0;i<noticeDao.countNotices();i++)
        {
            notices[i].setText((i+1)+". "+names.get(i));
        }
        Notice1.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                noticeDao.openNoticePdf(Notice1.getText().substring(3));
            }
        });
        Notice2.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                noticeDao.openNoticePdf(Notice2.getText().substring(3));
            }
        });
        Notice3.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                noticeDao.openNoticePdf(Notice3.getText().substring(3));
            }
        });
        Notice4.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                noticeDao.openNoticePdf(Notice4.getText().substring(3));
            }
        });
        Notice5.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                noticeDao.openNoticePdf(Notice5.getText().substring(3));
            }
        });
                
        
        //JButton Back
        btnBack=new JButton("BACK");
        btnBack.setBounds(325,525,100,30);
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
       }
    }    
}

package AdminLogin;
import Databases.Databasec1;
import ResidentView.ResidentViewMainPage;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import societymanagementsystem.MainPage;
public class Logins extends JFrame implements ActionListener 
{
    JButton blogin,bcancel,bforget,bViewAsResident;
    JLabel lblusername,lblpassword,image;
    JTextField tusername;
    JPasswordField tpassword;
    public Logins(){
        super("LOGIN");
        
        //Label Details
        lblusername=new JLabel("USERNAME: ");
        lblusername.setBounds(20,50,120,30);
        lblusername.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,18));
        lblusername.setForeground(Color.BLACK);
        add(lblusername);
        
        lblpassword=new JLabel("PASSWORD: ");
        lblpassword.setBounds(20,120,125,30);
        lblpassword.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,18));
        lblpassword.setForeground(Color.BLACK);
        add(lblpassword);
        
        //TextField Details
        tusername=new JTextField();
        tusername.setBounds(135,50,180,30);
        tusername.setFont(new Font("TIMES_NEW_ROMAN",Font.PLAIN,16));
        tusername.setForeground(Color.BLACK);
        tusername.setBackground(Color.WHITE);
        add(tusername);
        
        //PasswordField Details
        tpassword=new JPasswordField();
        tpassword.setBounds(135,120,180,30);
        tpassword.setFont(new Font("TIMES_NEW_ROMAN",Font.PLAIN,16));
        tpassword.setForeground(Color.BLACK);
        tpassword.setBackground(Color.WHITE);
        add(tpassword);
        
        //ButtonsDetails
        blogin=new JButton("LOGIN");
        bcancel=new JButton("CANCEL");
        bforget=new JButton("FORGOT  PASSWORD");
        
        blogin.setBounds(13,195,130,30);
        blogin.setBackground(Color.BLACK);
        blogin.setForeground(Color.WHITE);
        blogin.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        blogin.addActionListener(this);
        add(blogin);
        
        bcancel.setBounds(163,195,130,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        bcancel.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        bcancel.addActionListener(this);
        add(bcancel);
        
        bforget.setBounds(313,195,220,30);
        bforget.setBackground(Color.BLACK);
        bforget.setForeground(Color.WHITE);
        bforget.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        bforget.addActionListener(this);
        add(bforget);
        
        //View Button As Resident
        bViewAsResident=new JButton("VIEW AS RESIDENT");
        bViewAsResident.setBounds(13,0,250,30);
        bViewAsResident.setBackground(Color.RED);
        bViewAsResident.setForeground(Color.WHITE);
        bViewAsResident.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        bViewAsResident.addActionListener(this);
        add(bViewAsResident);
        
        //Image Details        
        ImageIcon i=new ImageIcon("src\\societymanagementsystem\\images\\login.jpg");
        Image i1 = i.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        image=new JLabel(i2);
        image.setBounds(335,0,200,220);
        add(image);
        
        //Frame Details 
        setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        setSize(560,270);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==blogin)
        {
            try{
                Databasec1 c = new Databasec1();
                String u = tusername.getText();
                String v = tpassword.getText();

                String q = "select * from adminlogin where username='"+u+"' and password='"+v+"'";

                ResultSet rs = c.s.executeQuery(q); 
                if(rs.next()){
                    MainPage mp=new MainPage();
                    dispose();
                }else{
                    setVisible(false);
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    Logins l=new Logins();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==bcancel)
        {
            dispose();
        }
        else if(ae.getSource()==bforget)
        {
            dispose();
            ForgotPassword fp=new ForgotPassword();
        }
        else if(ae.getSource()==bViewAsResident)
        {
            dispose();
            new ResidentViewMainPage();
        }
    }
    public static void main(String args[]){
        Logins l=new Logins();
    }
}

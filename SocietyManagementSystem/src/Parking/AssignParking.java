package Parking;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import societymanagementsystem.MainPage;
public class AssignParking implements ActionListener
{
    JButton bcancel;
    JFrame jf;
    JPanel contentPane;
    public AssignParking()
    {
        jf=new JFrame("ASSIGN PARKING");
        jf.setBounds(10,10, 1296, 700);
        jf.setResizable(false);
        contentPane = new JPanel();
        jf.setContentPane(contentPane);
        contentPane.setLayout(null);
        jf.getContentPane().setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        bcancel=new JButton("CANCEL");
        bcancel.setBounds(163,195,130,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        bcancel.setFont(new Font("TIMES_NEW_ROMAN",Font.BOLD,16));
        bcancel.addActionListener(this);
        jf.add(bcancel);
        
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bcancel)
        {
            jf.dispose();
            MainPage mp=new MainPage();
        }
    }
    public static void main(String args[])
    {
        AssignParking ap=new AssignParking();
    }
}

package Residents;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import societymanagementsystem.MainPage;
public class AddResidents implements ActionListener
{
    JFrame jf;
    JLabel lbltitle,lblowner,lblwing,lblflatno,lblage,lbloccupation,lblarriving_year,lbltotalfamilymem,lblnamefamilymem;
    JTextField towner,twing,tflatno,tage,toccupation,tarriving_year,ttotalfamilymem,tnamefamilymem;
    JButton bback;
    //Test
    public AddResidents()
    {
        //Frame Details
        jf=new JFrame("ADD RESIDENTS");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(20,20);
        jf.setSize(1000,700);
        
        //Label and TextField Details
        //Title
        lbltitle = new JLabel("ADD RESIDENT");
        lbltitle.setBounds(20,0,400,50);
        lbltitle.setFont(new Font("serif",Font.ITALIC,36));
        lbltitle.setForeground(Color.BLUE);
        jf.add(lbltitle);
        
        //1.Owner
        lblowner = new JLabel("NAME OF OWNER :- ");
        lblowner.setBounds(20,100,200,30);
        lblowner.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblowner.setForeground(Color.BLACK);
        jf.add(lblowner);
        
        towner=new JTextField();
        towner.setBounds(320,100,240,30);
        towner.setFont(new Font("serif",Font.PLAIN,20));
        towner.setForeground(Color.BLACK);
        jf.add(towner);
        
        //2.Wing
        lblwing = new JLabel("WING :- ");
        lblwing.setBounds(20,150,200,30);
        lblwing.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblwing.setForeground(Color.BLACK);
        jf.add(lblwing);
        
        twing=new JTextField();
        twing.setBounds(320,150,240,30);
        twing.setFont(new Font("serif",Font.PLAIN,20));
        twing.setForeground(Color.BLACK);
        jf.add(twing);
        
        //3.Flat No.
        lblflatno = new JLabel("FLAT NO. :- ");
        lblflatno.setBounds(20,200,200,30);
        lblflatno.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblflatno.setForeground(Color.BLACK);
        jf.add(lblflatno);
        
        tflatno=new JTextField();
        tflatno.setBounds(320,200,240,30);
        tflatno.setFont(new Font("serif",Font.PLAIN,20));
        tflatno.setForeground(Color.BLACK);
        jf.add(tflatno);
        
        //4.Age
        lblage = new JLabel("AGE :- ");
        lblage.setBounds(20,250,200,30);
        lblage.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblage.setForeground(Color.BLACK);
        jf.add(lblage);
        
        tage=new JTextField();
        tage.setBounds(320,250,240,30);
        tage.setFont(new Font("serif",Font.PLAIN,20));
        tage.setForeground(Color.BLACK);
        jf.add(tage);
        
        //4.Occupation
        lbloccupation = new JLabel("OCCUPATION :- ");
        lbloccupation.setBounds(20,300,200,30);
        lbloccupation.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lbloccupation.setForeground(Color.BLACK);
        jf.add(lbloccupation);
        
        toccupation=new JTextField();
        toccupation.setBounds(320,300,240,30);
        toccupation.setFont(new Font("serif",Font.PLAIN,20));
        toccupation.setForeground(Color.BLACK);
        jf.add(toccupation);
        
        //6.Arrival Year
        lblarriving_year = new JLabel("YEAR OF ARRIVAL :- ");
        lblarriving_year.setBounds(20,350,220,30);
        lblarriving_year.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblarriving_year.setForeground(Color.BLACK);
        jf.add(lblarriving_year);
        
        tarriving_year=new JTextField();
        tarriving_year.setBounds(320,350,240,30);
        tarriving_year.setFont(new Font("serif",Font.PLAIN,20));
        tarriving_year.setForeground(Color.BLACK);
        jf.add(tarriving_year);
        
        //7.Total Family Members
        lbltotalfamilymem = new JLabel("TOTAL FAMILY MEMBERS :- ");
        lbltotalfamilymem.setBounds(20,400,300,30);
        lbltotalfamilymem.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lbltotalfamilymem.setForeground(Color.BLACK);
        jf.add(lbltotalfamilymem);
        //test
        
        ttotalfamilymem=new JTextField();
        ttotalfamilymem.setBounds(320,400,240,30);
        ttotalfamilymem.setFont(new Font("serif",Font.PLAIN,20));
        ttotalfamilymem.setForeground(Color.BLACK);
        jf.add(ttotalfamilymem);
        
        //8.Name Of Family Members
        lblnamefamilymem = new JLabel("NAME OF FAMILY MEMBERS :- ");
        lblnamefamilymem.setBounds(20,450,300,30);
        lblnamefamilymem.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        lblnamefamilymem.setForeground(Color.BLACK);
        jf.add(lblnamefamilymem);
        
        tnamefamilymem=new JTextField();
        tnamefamilymem.setBounds(320,450,240,30);
        tnamefamilymem.setFont(new Font("serif",Font.PLAIN,20));
        tnamefamilymem.setForeground(Color.BLACK);
        jf.add(tnamefamilymem);
        
        bback=new JButton("BACK");
        bback.setBounds(245,600,100,40);
        bback.setFont(new Font("Times_New_Roman",Font.PLAIN,20));
        bback.setForeground(Color.WHITE);
        bback.setBackground(Color.BLACK);
        jf.add(bback);
    
        bback.addActionListener(this);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bback)
        {
            jf.dispose();
            MainPage mp=new MainPage();
        }
    }
    public static void main(String args[])
    {
        AddResidents ar=new AddResidents();
    }
}

package gateinn;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import societymanagementsystem.MainPage;
public class ViewVisitors implements ActionListener{
   
    JFrame jf,viewFrame;
    JLabel lblimage,lbltitle;
    JButton bname,bphone,bdate,bcancel;
    String column_names[]={"Name","Purpose","Phone","Flat","Date","Entry_Time","Exit Time","Watchman_Present","Gate","Vehicle_Num"};
    public ViewVisitors()
    {
        //Frame details
        jf=new JFrame("VIEW DETAILS");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(30,30);
        jf.setSize(700,500);
        
        //Background Image
        lblimage= new JLabel();
        lblimage.setBounds(0,0,700,500);
        lblimage.setLayout(null);
        ImageIcon i = new ImageIcon("src\\gateinn\\images\\details.jpg");
        lblimage.setIcon(i);
        jf.add(lblimage);
        
        //Title
        lbltitle = new JLabel("VIEW DETAILS");
        lbltitle.setBounds(5,5,400,50);
        lbltitle.setFont(new Font("serif",Font.ITALIC,36));
        lbltitle.setForeground(Color.ORANGE);
        lblimage.add(lbltitle);
        
        //Adding Buttons
        //1.Name button
        bname=new JButton("VIEW BY NAME");
        bname.setBounds(450,80,200,40);
        bname.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bname.setForeground(Color.BLACK);
        bname.setBackground(Color.LIGHT_GRAY);
        lblimage.add(bname);
        
        //2.Phone Button
        bphone=new JButton("VIEW BY PHONE NO.");
        bphone.setBounds(450,140,200,40);
        bphone.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bphone.setForeground(Color.BLACK);
        bphone.setBackground(Color.LIGHT_GRAY);
        lblimage.add(bphone);
        
        //3.View Button
        bdate=new JButton("VIEW BY DATE");
        bdate.setBounds(450,200,200,40);
        bdate.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bdate.setForeground(Color.BLACK);
        bdate.setBackground(Color.LIGHT_GRAY);
        lblimage.add(bdate);
        
        //4.Cancel button
        bcancel=new JButton("CANCEL");
        bcancel.setBounds(450,260,200,40);
        bcancel.setFont(new Font("Times_New_Roman",Font.BOLD,16));
        bcancel.setForeground(Color.BLACK);
        bcancel.setBackground(Color.LIGHT_GRAY);
        lblimage.add(bcancel);
        
        //Add Action Listeners to buttons
        bdate.addActionListener(this);
        bphone.addActionListener(this);
        bname.addActionListener(this);
        bcancel.addActionListener(this);
        
        jf.setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bname)
        {
            viewVisitorsByName();
        }
        if(ae.getSource()==bdate)
        {
            viewVisitorsByDate();
        }
        if(ae.getSource()==bphone)
        {
            viewVisitorsByPhone();
        }
        if(ae.getSource()==bcancel)
        {
            jf.dispose();
            new MainPage();
        }
    }
    
    public void viewVisitorsByName()
    {
        JFrame frame;
        JLabel lbltitle,lblname;
        JTextField tname;
        JButton bsearch,bback,bdone;
        JTable table;
        //Frame details
        frame=new JFrame("VIEW DETAILS");
        frame.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocation(20,20);
        frame.setSize(650,300);
        
        //Title
        lbltitle = new JLabel("VIEW DETAILS BY NAME");
        lbltitle.setBounds(5,5,500,50);
        lbltitle.setFont(new Font("serif",Font.ITALIC,42));
        lbltitle.setForeground(Color.ORANGE);
        frame.add(lbltitle);
        
        //Date Input
        lblname = new JLabel("ENTER NAME:-");
        lblname.setBounds(20,65,180,30);
        lblname.setFont(new Font("serif",Font.BOLD,24));
        lblname.setForeground(Color.BLACK);
        frame.add(lblname);
        
        tname=new JTextField();
        tname.setBounds(220,65,180,30);
        tname.setFont(new Font("serif",Font.PLAIN,18));
        tname.setForeground(Color.BLACK);
        frame.add(tname);
        
        
        //Search and Cancel Button
        bsearch=new JButton("SEARCH");
        bsearch.setBounds(410,65,110,30);
        bsearch.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bsearch.setForeground(Color.WHITE);
        bsearch.setBackground(Color.BLACK);
        frame.add(bsearch);
        
        bback=new JButton("BACK");
        bback.setBounds(530,65,100,30);
        bback.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bback.setForeground(Color.WHITE);
        bback.setBackground(Color.BLACK);
        frame.add(bback); 
        
        bback.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
         }
        });
        
        bsearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            GateDao gatedao=new GateDao();
            ArrayList<EntryObject> entries=gatedao.viewEntriesByName(tname.getText());
            showTable(entries);
         }
        });
        frame.setVisible(true);        
    }
    
    public void viewVisitorsByPhone()
    {
        JFrame frame;
        JLabel lbltitle,lblphone;
        JTextField tphone;
        JButton bsearch,bback,bdone;
        JTable table;
        //Frame details
        frame=new JFrame("VIEW DETAILS");
        frame.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocation(20,20);
        frame.setSize(750,300);
        
        //Title
        lbltitle = new JLabel("VIEW DETAILS BY PHONE NO.");
        lbltitle.setBounds(5,5,600,50);
        lbltitle.setFont(new Font("serif",Font.ITALIC,42));
        lbltitle.setForeground(Color.ORANGE);
        frame.add(lbltitle);
        
        //Date Input
        lblphone = new JLabel("ENTER PHONE NO.:-");
        lblphone.setBounds(20,65,240,30);
        lblphone.setFont(new Font("serif",Font.BOLD,24));
        lblphone.setForeground(Color.BLACK);
        frame.add(lblphone);
        
        tphone=new JTextField();
        tphone.setBounds(280,65,180,30);
        tphone.setFont(new Font("serif",Font.PLAIN,18));
        tphone.setForeground(Color.BLACK);
        frame.add(tphone);
        
        
        //Search and Cancel Button
        bsearch=new JButton("SEARCH");
        bsearch.setBounds(470,65,110,30);
        bsearch.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bsearch.setForeground(Color.WHITE);
        bsearch.setBackground(Color.BLACK);
        frame.add(bsearch);
        
        bback=new JButton("BACK");
        bback.setBounds(590,65,100,30);
        bback.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bback.setForeground(Color.WHITE);
        bback.setBackground(Color.BLACK);
        frame.add(bback); 
        
        bback.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
         }
        });
        
        bsearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            GateDao gatedao=new GateDao();
            ArrayList<EntryObject> entries=gatedao.viewEntriesByPhone(tphone.getText());
            showTable(entries);
         }
        });
        frame.setVisible(true);         
        frame.setVisible(true);
    }
    
    public void viewVisitorsByDate()
    {
        JFrame frame;
        JLabel lbltitle,lbldate;
        JTextField tdate;
        JButton bsearch,bback,bdone;
        JTable table;
        
        //Frame details
        frame=new JFrame("VIEW DETAILS");
        frame.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocation(20,20);
        frame.setSize(650,300);
        
        //Title
        lbltitle = new JLabel("VIEW DETAILS BY DATE");
        lbltitle.setBounds(5,5,500,50);
        lbltitle.setFont(new Font("serif",Font.ITALIC,42));
        lbltitle.setForeground(Color.ORANGE);
        frame.add(lbltitle);
        
        //Date Input
        lbldate = new JLabel("ENTER DATE:-");
        lbldate.setBounds(20,65,180,30);
        lbldate.setFont(new Font("serif",Font.BOLD,24));
        lbldate.setForeground(Color.BLACK);
        frame.add(lbldate);
        
        tdate=new JTextField();
        tdate.setBounds(220,65,180,30);
        tdate.setFont(new Font("serif",Font.PLAIN,18));
        tdate.setForeground(Color.BLACK);
        frame.add(tdate);
        
        
        //Search and Cancel Button
        bsearch=new JButton("SEARCH");
        bsearch.setBounds(410,65,110,30);
        bsearch.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bsearch.setForeground(Color.WHITE);
        bsearch.setBackground(Color.BLACK);
        frame.add(bsearch);
        
        bback=new JButton("BACK");
        bback.setBounds(530,65,100,30);
        bback.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bback.setForeground(Color.WHITE);
        bback.setBackground(Color.BLACK);
        frame.add(bback); 
        
        bback.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
         }
        });
        
        bsearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
            GateDao gatedao=new GateDao();
            ArrayList<EntryObject> entries=gatedao.viewEntriesByDate(tdate.getText());
            showTable(entries);
         }
        });
        frame.setVisible(true);
    }
    
    public void showTable(ArrayList<EntryObject> entries)
    {
        String name="",pur="",ph="",flat="",date="",entry="",exit="",watchman="",gate="",vehicle="";
        viewFrame = new JFrame("Database Search Result");
        viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewFrame.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column_names);
        JTable table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        try{
            for(EntryObject entryobject:entries)
            {
                model.addRow(new Object[]{entryobject.getName(),entryobject.getPurpose(),entryobject.getPhone(),entryobject.getFlat(),entryobject.getDate(),entryobject.getEntrytime(),entryobject.getExittime(),entryobject.getWatchman(),entryobject.getGate(),entryobject.getVehicle()});
            }
            viewFrame.add(scroll);
            viewFrame.setResizable(false);
            viewFrame.setSize(1160,350);    
            viewFrame.setVisible(true);
        }
        catch(Exception e)
        {
            jf.dispose();
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
    public static void main(String args[])
    {
        ViewVisitors v=new ViewVisitors();
    }
}
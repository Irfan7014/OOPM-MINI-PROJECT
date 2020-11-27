package gateinn;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
class ViewByPhone implements ActionListener
{
    JFrame jf,frame;
    JLabel lbltitle,lblphone;
    JTextField tphone;
    JButton bsearch,bback,bdone;
    JTable table;
    int k=0;
    String column_names[]={"Name","Purpose","Phone","Flat","Date","Entry_Time","Exit Time","Watchman_Present","Gate","Vehicle_Num"};
    ViewByPhone()
    {
        //Frame details
        jf=new JFrame("VIEW DETAILS");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(20,20);
        jf.setSize(750,300);
        
        //Title
        lbltitle = new JLabel("VIEW DETAILS BY PHONE NO.");
        lbltitle.setBounds(5,5,600,50);
        lbltitle.setFont(new Font("serif",Font.ITALIC,42));
        lbltitle.setForeground(Color.ORANGE);
        jf.add(lbltitle);
        
        //Date Input
        lblphone = new JLabel("ENTER PHONE NO.:-");
        lblphone.setBounds(20,65,240,30);
        lblphone.setFont(new Font("serif",Font.BOLD,24));
        lblphone.setForeground(Color.BLACK);
        jf.add(lblphone);
        
        tphone=new JTextField();
        tphone.setBounds(280,65,180,30);
        tphone.setFont(new Font("serif",Font.PLAIN,18));
        tphone.setForeground(Color.BLACK);
        jf.add(tphone);
        
        
        //Search and Cancel Button
        bsearch=new JButton("SEARCH");
        bsearch.setBounds(470,65,110,30);
        bsearch.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bsearch.setForeground(Color.WHITE);
        bsearch.setBackground(Color.BLACK);
        jf.add(bsearch);
        
        bback=new JButton("BACK");
        bback.setBounds(590,65,100,30);
        bback.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bback.setForeground(Color.WHITE);
        bback.setBackground(Color.BLACK);
        jf.add(bback); 
        
        bsearch.addActionListener(this);
        bback.addActionListener(this);
        
        jf.setVisible(true);
    }
    public void showTable()
    {
        String name="",pur="",ph="",flat="",date="",entry="",exit="",watchman="",gate="",vehicle="";
        frame = new JFrame("Database Search Result");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(column_names);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        GateDao gatedao=new GateDao();
        ArrayList<EntryObject> entries=gatedao.viewEntriesByPhone(tphone.getText());
        try{
            for(EntryObject entryobject:entries)
            {
                model.addRow(new Object[]{entryobject.getName(),entryobject.getPurpose(),entryobject.getPhone(),entryobject.getFlat(),entryobject.getDate(),entryobject.getEntrytime(),entryobject.getExittime(),entryobject.getWatchman(),entryobject.getGate(),entryobject.getVehicle()});
            }
            frame.add(scroll);
            frame.setResizable(false);
            frame.setSize(1160,350);    
            frame.setVisible(true);
        }
        catch(Exception e)
        {
            jf.dispose();
            JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
        }  
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==bback)
        {
            jf.dispose();
            ViewVisitors v=new ViewVisitors();
        }
        if(ae.getSource()==bsearch)
        {
            jf.dispose();
            ViewByPhone vd=new ViewByPhone();
            showTable();
        }
    }
    public static void main(String args[])
    {
        ViewByPhone vd=new ViewByPhone();
    }
}
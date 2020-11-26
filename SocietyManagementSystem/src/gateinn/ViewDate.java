package gateinn;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
class ViewDate implements ActionListener
{
    JFrame jf,frame;
    JLabel lbltitle,lbldate;
    JTextField tdate;
    JButton bsearch,bback,bdone;
    JTable table;
    String column_names[]={"Name","Purpose","Phone","Flat","Date","Entry Time","Exit Time","Watchman Present","Gate","Vehicle Num"};
    public ViewDate()
    {
        //Frame details
        jf=new JFrame("VIEW DETAILS");
        jf.setDefaultCloseOperation(WindowConstants. EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(20,20);
        jf.setSize(650,300);
        
        //Title
        lbltitle = new JLabel("VIEW DETAILS BY DATE");
        lbltitle.setBounds(5,5,500,50);
        lbltitle.setFont(new Font("serif",Font.ITALIC,42));
        lbltitle.setForeground(Color.ORANGE);
        jf.add(lbltitle);
        
        //Date Input
        lbldate = new JLabel("ENTER DATE:-");
        lbldate.setBounds(20,65,180,30);
        lbldate.setFont(new Font("serif",Font.BOLD,24));
        lbldate.setForeground(Color.BLACK);
        jf.add(lbldate);
        
        tdate=new JTextField();
        tdate.setBounds(220,65,180,30);
        tdate.setFont(new Font("serif",Font.PLAIN,18));
        tdate.setForeground(Color.BLACK);
        jf.add(tdate);
        
        
        //Search and Cancel Button
        bsearch=new JButton("SEARCH");
        bsearch.setBounds(410,65,110,30);
        bsearch.setFont(new Font("Times_New_Roman",Font.PLAIN,18));
        bsearch.setForeground(Color.WHITE);
        bsearch.setBackground(Color.BLACK);
        jf.add(bsearch);
        
        bback=new JButton("BACK");
        bback.setBounds(530,65,100,30);
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
        ArrayList<EntryObject> entries=gatedao.viewEntriesByDate(tdate.getText());
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
            View_Visitors v=new View_Visitors();
        }
        if(ae.getSource()==bsearch)
        {
            jf.dispose();
            new ViewDate();
            showTable();
        }
    }
    public static void main(String args[])
    {
        ViewDate vd=new ViewDate();
    }
}
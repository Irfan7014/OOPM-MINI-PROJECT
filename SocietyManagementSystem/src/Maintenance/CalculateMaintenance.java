package Maintenance;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
public class CalculateMaintenance implements ActionListener
{
    JFrame jf;
    JButton bcancel,bAssignParking;
    JPanel jp111;
    JLabel lblvehicleno;
    public CalculateMaintenance()
    {
        //Frame Details
        jf=new JFrame("ASSIGN PARKING");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(200, 200);
        jf.setSize(700, 450);
        
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        
    }
    public static void main(String args[])
    {
        new CalculateMaintenance();
    }
}

package NoticesAndReportsAndServices;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class NoticeBoard 
{
    JFrame jf;
    public NoticeBoard()
    {
        //Frame Details
        jf=new JFrame("ADD NOTICE'S");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setLocation(500, 500);
        jf.setSize(750, 450);
        
        jf.setVisible(true);
    }
}

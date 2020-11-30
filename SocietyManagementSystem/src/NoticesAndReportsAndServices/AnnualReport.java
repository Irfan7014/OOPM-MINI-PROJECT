package NoticesAndReportsAndServices;

import java.awt.Desktop;
import java.io.File;

public class AnnualReport 
{
    public AnnualReport()
    {
        try 
        {
            File pdfFile = new File("D:\\Cloned Repositories\\OOPM-MINI-PROJECT\\SocietyManagementSystem\\src\\NoticesAndReportsAndServices\\Annual Report.pdf");
            if (pdfFile.exists()) 
            {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("AWT Desktop is not supported!");
                }
            } 
            else 
            {
                System.out.println("File is not exists!");
            }
            System.out.println("Done");
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }
}

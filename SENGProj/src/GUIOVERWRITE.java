import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;


/**
 * The class containing most of the Graphical User Interface information.
 * 
 * @author Team 28
 */
public class GUIOVERWRITE
{
   /**
     * Gives the GUI overwrite the panels for later switching 
     */
    
   private JPanel contentPane;
   private LoginPanel log;
   private StaffRegister sr;
   private MainMenuForm mmf;
   private CourseCalendar cc;
   private AddProgram ap;
   private EditCourse ec;
   private EditDepartment ed;
   private AddCourse ac;
   private DepartmentDisplay dd;
   private ProgramDisplay pd;
   private EditProgram ep;
   private AddDepartment ad;
   
   /**
    * Gives GUI a copy of Game class 
    * 
    */
   private Run run;
   
   
   
   public GUIOVERWRITE(Run run){
       GUI(run);
      
    }
   
   private void GUI( Run run){
       /**
        * Creates a new JFrame for the GUI to be applied to 
        * GUI is set to exit upon close or termination 
        */
       JFrame frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       /**
        * Creates a new JPanel and a Container Panel
        * 
        */
       
       JPanel contentPane = new JPanel();
       
       /**
        * Creates the panels using the variable and passes them the necessary parameters to be used 
        */
       contentPane.setLayout(new CardLayout());
       log = new LoginPanel(contentPane);
       sr = new StaffRegister(contentPane);
       mmf = new MainMenuForm(contentPane);
       ac = new AddCourse(contentPane);
       cc = new CourseCalendar(contentPane);
       ap = new AddProgram(contentPane);
       ec = new EditCourse(contentPane);
       ed = new EditDepartment(contentPane);
       dd = new DepartmentDisplay(contentPane);
       pd = new ProgramDisplay(contentPane);
       ep = new EditProgram(contentPane);
       ad = new AddDepartment(contentPane);
       
       /**
        * Adds the frames to the Container parent and initializes a string name for them to be called by. 
        */
       
       contentPane.add(log,"login");
       contentPane.add(sr,"sr");
       contentPane.add(mmf,"mmf");
       contentPane.add(ac,"ac");
       contentPane.add(cc,"cc");
       contentPane.add(ap,"ap");
       contentPane.add(ec,"ec");
       contentPane.add(ed,"ed");
       contentPane.add(dd,"dd");
       contentPane.add(pd,"pd");
       contentPane.add(ed,"ed");
       contentPane.add(ad,"ad");
       
       
       
      
       
       /**
        * Sets the frame dimensions to (900,900)
        * Grabs the first JPanel and displays it until an ActionPerformed will swap it for another 
        */
       frame.pack();
       frame.setSize(1000,1000);
       frame.setContentPane(contentPane);
       frame.setVisible(true);
    }
  
   
}

    
       
       
       
       
       
       
       
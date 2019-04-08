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
   private StaffRegister lo;
   private MainMenuForm mmf;
   public String u;
   
  
   
   /**
    * Gives GUI a copy of Game class 
    * 
    */
   private Run run;
   
   
   /**
     * Constructor that calls a instance of the GUI and gives it
     * @param EmployeeBurger, an instance of EmployeeBurger
     * @param CustomerBurger, an instance of CustomberBurger
     * @param Game, an instance of the Game class
     */
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
       lo = new StaffRegister(contentPane);
       mmf = new MainMenuForm(contentPane,u);
       
       
       /**
        * Adds the frames to the Container parent and initializes a string name for them to be called by. 
        */
       
       contentPane.add(log,"login");
       contentPane.add(lo,"lo");
       contentPane.add(mmf,"mmf");
       
       
       
      
       
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
class LoginPanel extends JPanel{                 
    JPanel p1 = new JPanel(null) ;       
     private JPanel contentPane;
   private LoginPanel lp;
   
   
    public String user = "Bob";
    private String pass = "password";
    
    private RWTools tool = new RWTools();
    
    ImageLibrary img = new ImageLibrary();
    private JButton nuButton;
    private JButton stuButton;
    private JButton login;    
    
    private JLabel UserID;
    private JLabel Pass;
    private JPasswordField passfield;
    private JTextField userfield;    
    private JFrame frame;
    private JLabel loginError = new JLabel("");
    
    public LoginPanel(JPanel pane){        
        
        contentPane = pane;
        
        p1.setPreferredSize(new Dimension(1000,1000));
       
        JPanel image1 = new JPanel();
        ImageIcon pic = img.titlepage;
        image1.setSize(1000,1000);
        image1.add(new JLabel(pic));
        image1.setEnabled(true);
        image1.setVisible(true);
       
    
        loginError.setForeground(Color.RED);
        loginError.setFont(new Font("Tahoma", Font.BOLD, 15));
        loginError.setBounds(350, 425,300, 200);
        
        
        
        
        //Labels here 
        UserID = new JLabel("UserID");
        UserID.setBounds(300,370, 171,57);        
        UserID.setEnabled(true);
        UserID.setFont(new Font("Tahoma", Font.BOLD, 20));
        UserID.setVisible(true);
                
        Pass = new JLabel("Password");
        Pass.setBounds(300, 440, 171,57);        
        Pass.setEnabled(true);
        Pass.setFont(new Font("Tahoma", Font.BOLD, 20));
        Pass.setVisible(true);
        
        //TextFields
        passfield = new JPasswordField();
        passfield.setBounds(420, 450, 170,35);
        
        userfield = new JTextField();
        userfield.setBounds(420, 380, 170,35);
        userfield.setColumns(10);
    
        login = new JButton("Login");
        login.setBounds(420,550,170,50);
        login.setForeground(Color.BLACK);
        login.setFont(new Font("Tahoma", Font.BOLD,18));
        login.setEnabled(true);
        login.setVisible(true);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String entry = new String(passfield.getPassword());
                if (userfield.getText().isEmpty()){
                    loginError.setText("Please enter valid username/password");
                }
                if (entry.isEmpty()){
                    loginError.setText("Please enter valid username/password");
                }
                if (tool.verifyUser(userfield.getText(), entry)){
                    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                                cardLayout.show(contentPane, "mmf");
                }
            }
        });
        
            
            
        nuButton = new JButton("New Faculty?");
        nuButton.setBounds(240,550,170,50);
        nuButton.setForeground(Color.BLACK);
        nuButton.setFont(new Font("Tahoma", Font.BOLD,18));
        nuButton.setEnabled(true);
        nuButton.setVisible(true);
        nuButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "lo");
            }
        });
        
        stuButton = new JButton("Student?");
        stuButton.setBounds(600,550,170,50);
        stuButton.setForeground(Color.BLACK);
        stuButton.setFont(new Font("Tahoma", Font.BOLD,18));
        stuButton.setEnabled(true);
        stuButton.setVisible(true);
        stuButton.addActionListener(new ActionListener()
        { 
            public void actionPerformed(ActionEvent event)
            {
                 CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "mmf");
            }
        });
        p1.add(image1);
        p1.add(login);
        p1.add(UserID);
        p1.add(Pass);
        p1.add(passfield);
        p1.add(userfield);
        p1.add(stuButton);
        p1.add(nuButton);
        p1.add(loginError);
       
        p1.add(image1);
        
        contentPane.add(p1);
        add(p1);
    }
    @Override
    public Dimension getPreferredSize()
    { 
        return (new Dimension(1000,1000));
    }


}
    
    
       
       
       
       
       
       
       


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;

  
/**
 * This class contains an image to be brought up upon a Game of strike 3
 * as well as a back button to return the user to the MainMenu
 * 
 * @author Team 28
 *
 */

class StaffRegister extends JPanel{
    
    
        private JButton back;
        private JPanel contentPane;
        
        private JLabel Title;
        private JLabel FNLabel;
        private JLabel LNLabel;
        private JLabel PhLabel;
        private JLabel ELabel;
        private JLabel MLabel;
        private JLabel DPLabel;
        private JLabel SfLabel;
        
        private JLabel UIDLabel;
        private JLabel PassLabel;
        private JLabel ConPass;
        
        private JRadioButton DH;
        private JRadioButton TA;
        private JRadioButton I;
        
        private JTextField firstName;
        private JTextField lastName;
        private JTextField EmailField;
        private JTextField MailField;
        private JTextField DepartField;
        private JTextField textField_5;
        private JTextField userID;
        private JTextField passWord;
        private JTextField confirmPass;
        private JButton AddStaff;

    private RWTools tool = new RWTools();
    
  
    ImageLibrary img = new ImageLibrary();
    
    
    /**
     * The EndCardLose constructor takes a JPanel and builds upon
     * it to add an ImageIcon containing the "l" image.
     * 
     * @param panel is a JPanel that is assigned to contentPane
     */
    public StaffRegister(JPanel panel) {
        JPanel p1 = new JPanel(null) ;
        p1.setPreferredSize(new Dimension(1000,1000));
        contentPane = panel;
        
        //IMG
        JPanel staffbg = new JPanel();
        ImageIcon pic = new ImageIcon("ImgLib/Staffr.png");
        staffbg.setSize(1000,1000);
        staffbg.add(new JLabel(pic));
        staffbg.setEnabled(true);
        staffbg.setVisible(true);
        
        //Labels 
        JLabel lblNewLabel = new JLabel("Please Enter Your Information Below");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(300, 300, 1000,100);
        p1.add(lblNewLabel);
        
        FNLabel = new JLabel("First Name");
        FNLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        FNLabel.setBounds(150,350,200,100);
        p1.add(FNLabel);
        
        LNLabel = new JLabel("Last Name");
        LNLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        LNLabel.setBounds(150,400,200,100);
        p1.add(LNLabel);
        
        PhLabel = new JLabel("Phone Number");
        PhLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        PhLabel.setBounds(150,450,200,100);
        p1.add(PhLabel);
        
        ELabel = new JLabel("Email Address");
        ELabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        ELabel.setBounds(150,500,200,100);
        p1.add(ELabel);
        
        MLabel = new JLabel("Mailing Address");
        MLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        MLabel.setBounds(150,550,200,100);
        p1.add(MLabel);
        
        DPLabel = new JLabel("Department");
        DPLabel .setFont(new Font("Tahoma", Font.BOLD, 18));
        DPLabel .setBounds(150,600,200,100);
        p1.add(DPLabel);
        
        SfLabel = new JLabel("Staff Type");
        SfLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        SfLabel.setBounds(150,620,200,100);
        p1.add(SfLabel);
        
        UIDLabel = new JLabel("User ID");
        UIDLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        UIDLabel.setBounds(150,700,200,100);
        p1.add(UIDLabel);
        
        PassLabel = new JLabel("Password");
        PassLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        PassLabel.setBounds(150,750,200,100);
        p1.add(PassLabel);
        
        ConPass = new JLabel("Confirm Password");
        ConPass.setFont(new Font("Tahoma", Font.BOLD, 18));
        ConPass.setBounds(150,800,200,100);
        p1.add(ConPass);
        
        
        //TextFields here 
        firstName = new JTextField();
        firstName.setBounds(400,380,200,25);
        p1.add(firstName);
        firstName.setColumns(10);
        
        lastName = new JTextField();
        lastName.setColumns(10);
        lastName.setBounds(400,430,200,25);
        p1.add(lastName);
        
        EmailField = new JTextField();
        EmailField.setColumns(10);
        EmailField.setBounds(400,480,200,25);
        p1.add(EmailField);
        
        MailField = new JTextField();
        MailField.setColumns(10);
        MailField.setBounds(400,530,200,25);
        p1.add(MailField);
        
        DepartField = new JTextField();
        DepartField.setColumns(10);
        DepartField.setBounds(400,580,200,25);
        p1.add(DepartField);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(400,630,200,25);
        p1.add(textField_5);
        
        userID = new JTextField();
        userID.setColumns(10);
        userID.setBounds(400,750,200,25);
        p1.add(userID);
        
        passWord = new JTextField();
        passWord.setColumns(10);
        passWord.setBounds(400,790,200,25);
        p1.add(passWord);
        
        confirmPass = new JTextField();
        confirmPass.setColumns(10);
        confirmPass.setBounds(400,840,200,25);
        p1.add(confirmPass);
        
        //Buttons here 
        
        DH = new JRadioButton("Department Head");
        DH.setFont(new Font("Tahoma", Font.PLAIN, 15));
        DH.setBounds(200, 690, 150, 30);
        p1.add(DH);
        
        TA = new JRadioButton("Teaching Assistant");
        TA.setFont(new Font("Tahoma", Font.PLAIN, 15));
        TA.setBounds(400, 690, 150, 30);
        p1.add(TA);
        
        I = new JRadioButton("Instructor");
        I.setFont(new Font("Tahoma", Font.PLAIN, 15));
        I.setBounds(600, 690, 150, 30);
        p1.add(I);
        
        JLabel passError = new JLabel("");
        passError.setForeground(new Color(255, 0, 0));
        passError.setBackground(new Color(255, 0, 0));
        passError.setFont(new Font("Tahoma", Font.PLAIN, 13));
        passError.setBounds(620, 790,200, 26);
        p1.add(passError);
        
        JLabel confirmError = new JLabel("");
        confirmError.setForeground(new Color(255, 0, 0));
        confirmError.setFont(new Font("Tahoma", Font.PLAIN, 13));
        confirmError.setBackground(Color.RED);
        confirmError.setBounds(620, 840, 200, 26);
        p1.add(confirmError);
        
       

      //back is a Button that takes you the the MainMenu JPanel using an ActionListener and a subsequent ActionEvent        //construct components
        back = new JButton ("Back to MainMenu");
        back.setBounds(250,900,231,48);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));        
        back.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "login");
            }
        });
       
        AddStaff = new JButton("Add Staff");
	AddStaff.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(!passWord.getText().equals(confirmPass.getText())){
				passError.setText("Passwords do not match");
				confirmError.setText("Passwords do not match");
			}
			if(passWord.getText().isEmpty()){
				passError.setText("Please enter valid password");
			}
			else{
			tool.writeToUser(userID.getText(), passWord.getText(), firstName.getText(), lastName.getText());
			setVisible(false);
			CardLayout tologin = (CardLayout) contentPane.getLayout();
			tologin.show(contentPane, "log");
			}
		}
	});
        
	AddStaff.setFont(new Font("Tahoma", Font.BOLD, 15));
	AddStaff.setBounds(600,900,230,50);
	p1.add(AddStaff);
	
     
       p1.add(back);
       p1.add(staffbg);
      
       contentPane.add(p1);
       add(p1);
       
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(1000, 1000));
    }
    
    
    
    
    
    
}
   



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
import java.util.ArrayList;

  
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
        private JTextField PhoneField;
        private JTextField MailField;
        private JTextField MailingAField;
        private JTextField userID;
        private JTextField passWord;
        private JTextField confirmPass;
        private JTextField inputError;
        
        private JButton AddStaff;
        
        private JComboBox DepartmentField;

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
        ImageIcon pic = img.staffbg;
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
        
        PhoneField = new JTextField();
        PhoneField.setColumns(10);
        PhoneField.setBounds(400,480,200,25);
        p1.add(PhoneField);
        
        MailField = new JTextField();
        MailField.setColumns(10);
        MailField.setBounds(400,530,200,25);
        p1.add(MailField);
        
        MailingAField = new JTextField();
        MailingAField.setColumns(10);
        MailingAField.setBounds(400,580,200,25);
        p1.add(MailingAField);
      
        userID = new JTextField();
       
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
        
        
        
        
        //ComboBox
        ArrayList arr = tool.getDepartment();
		String [] departments = new String[arr.size()];
    		for (int x = 0; x < departments.length; x++){
    			departments[x] = (String) arr.get(x);
    }
      
              
       DepartmentField = new JComboBox();  
       DepartmentField.setModel(new DefaultComboBoxModel(departments));
       DepartmentField.setBounds(400,630,200,25);
        p1.add(DepartmentField);
        
        
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
        
     
        
        JLabel inputError = new JLabel("");
       inputError.setForeground(new Color(255, 0, 0));
       inputError.setFont(new Font("Tahoma", Font.PLAIN, 13));
       inputError.setBackground(Color.RED);
       inputError.setBounds(620, 840, 200, 26);
        p1.add(inputError);
        
       

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
                setEmpty();
            }
        });
       
        AddStaff = new JButton("Add Staff");
    AddStaff.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            // Error Handlers 
            // If the user does not enter a first or last name
            if((firstName.getText().isEmpty()) || (lastName.getText().isEmpty())){
                inputError.setText("Please Enter Your Full Name");
            }
            //If the email address is not valid
            else if(MailField.getText().isEmpty() || (!MailField.getText().contains("@"))){
                inputError.setText("Please enter Valid Email");
            }
            //if the user does not select a type of staff
            else if((!DH.isSelected()) && (!I.isSelected()) && (!TA.isSelected())){
                inputError.setText("Please select the type of staff");
            }
            //if the user enters a blank user name
            else if(userID.getText().isEmpty()){
                inputError.setText("Please enter a valid username");
            }
            //if the user enters a user name that is already taken
            else if(tool.userFound(userID.getText())){
                inputError.setText("User name is already taken");
            }
            // if the password entered is empty
            else if(passWord.getText().isEmpty()){
                inputError.setText("Please enter valid password");
            }
            //if the passwords don't match
            else if(!passWord.getText().equals(confirmPass.getText())){
                inputError.setText("Passwords do not match");
            }
            //write to the database if no errors
            else{
                // if the user is a department head
                if(DH.isSelected()){
                    tool.writeToUser(userID.getText(), passWord.getText(), firstName.getText(), lastName.getText(), MailField.getText(), 
                    MailingAField.getText(), (String)DepartmentField.getSelectedItem(), "Department Head", PhoneField.getText());
                    
                    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                    cardLayout.show(contentPane, "login");
                    firstName.setText("");
                    lastName.setText("");
                    PhoneField.setText("");
                    MailField.setText("");
                    MailingAField.setText("");
                    userID.setText("");
                    passWord.setText("");
                    confirmPass.setText("");
                    inputError.setText("");
                }
                // if the user is an instructor
                else if(I.isSelected()){
                    tool.writeToUser(userID.getText(), passWord.getText(), firstName.getText(), lastName.getText(), MailField.getText(), 
                            MailingAField.getText(), (String)DepartmentField.getSelectedItem(), "Instructor", PhoneField.getText());
                  
                    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                    cardLayout.show(contentPane, "login");
                    firstName.setText("");
                    lastName.setText("");
                    PhoneField.setText("");
                    MailField.setText("");
                    MailingAField.setText("");
                    userID.setText("");
                    passWord.setText("");
                    confirmPass.setText("");
                    inputError.setText("");
                }
                // if the user is a Teaching Assistant
                else{
                    tool.writeToUser(userID.getText(), passWord.getText(), firstName.getText(), lastName.getText(), MailField.getText(), 
                            MailingAField.getText(), (String)DepartmentField.getSelectedItem(), "Teaching Assistant", PhoneField.getText());
                 
                    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                    cardLayout.show(contentPane, "login");
                     firstName.setText("");
                    lastName.setText("");
                    PhoneField.setText("");
                    MailField.setText("");
                    MailingAField.setText("");
                    userID.setText("");
                    passWord.setText("");
                    confirmPass.setText("");
                    inputError.setText("");
                    
                }
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
    
    public void setEmpty(){
        firstName.setText("");
        lastName.setText("");
        PhoneField.setText("");
        MailField.setText("");
        MailingAField.setText("");
        userID.setText("");
        passWord.setText("");
        confirmPass.setText("");
        inputError.setText("");
    }
    
    
    
    
    
    
}
   

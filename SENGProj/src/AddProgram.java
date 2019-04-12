// Imported libraries


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

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
* AddProgram form that allows staff users to add a program to the system
* @author   Teddy Kalp, Angeli Manipon
* @version  2.0
*/

public class AddProgram extends JPanel {
    // Class attributes
    private JPanel contentPane;
    
    //Buttons
    private JTextArea programName;
    private JTextArea programDesc;
    
    //Label
    private JLabel PRLabel;
    private JLabel PNLabel; 
    private JLabel PDLabel;
    private JLabel DePLabel;
    private JLabel LoPLabel;
    private JLabel ToPLabel;
    private JLabel inputError;
    private JLabel PCLabel;
    private JLabel RGLabel;
    
    //ComboBox 
    private JComboBox ProgramCBox;
    private JComboBox  PTCBox;
    
    //CheckBox 
    private JCheckBox DPCheckBox;
    
    //RWTools
    private RWTools tool = new RWTools();
    
    ImageLibrary img = new ImageLibrary();
    
    /**
     * Launch the application.
     */

    /**
     * AddProgram constructor that creates the frame and adds its components.
     * @param   user - staff user that is adding a course
     */
    public AddProgram(JPanel panel) {
        
        // Closes window when the user exits the frame 
        
        JPanel p1 = new JPanel(null) ;
         p1.setPreferredSize(new Dimension(1000,1000));
         contentPane = panel;
          
                  //IMG
                JPanel editpbg = new JPanel();
                ImageIcon pic = img.editpbg;
                editpbg.setSize(1000,1000);
                editpbg.add(new JLabel(pic));
                editpbg.setEnabled(true);
                editpbg.setVisible(true);  
                
         JLabel DView = new JLabel("Add Program");
         DView.setFont(new Font("Tahoma", Font.BOLD, 30));
         DView.setForeground(Color.WHITE);
         DView.setBounds(410, 50, 500,50);
        p1.add( DView);
        
        JLabel lblNewLabel = new JLabel("What Program would you like to add?");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(300, 100, 500, 26);
        p1.add(lblNewLabel);
        
       
        // Program name label attributes
        PNLabel = new JLabel("Program Name");
        PNLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        PNLabel.setBounds(300, 150, 92, 26);
        p1.add(PNLabel);
        
        // Program description label attributes
        PDLabel = new JLabel("Program Description");
        PDLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        PDLabel.setBounds(300, 200, 131, 26);
        p1.add(PDLabel);
        
        
        // Department label attributes
        DePLabel = new JLabel("Department");
        DePLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        DePLabel.setBounds(300, 300, 131, 26);
        p1.add(DePLabel);
        
        // Level of Program label Attributes
        LoPLabel = new JLabel("Level of Program");
        LoPLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        LoPLabel.setBounds(300, 350, 131, 26);
        p1.add(LoPLabel);
        
        // Type of Program label attributes
        ToPLabel = new JLabel("Type of Program");
        ToPLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ToPLabel.setBounds(300, 400, 131, 26);
        p1.add(ToPLabel);
        
        inputError = new JLabel("");
        inputError.setForeground(Color.RED);
        inputError.setBackground(Color.RED);
        inputError.setFont(new Font("Tahoma", Font.PLAIN, 12));
        inputError.setBounds(155, 534, 223, 26);
        p1.add(inputError);
        
        PCLabel = new JLabel("Program Code (XXXX)");
        PCLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        PCLabel.setBounds(300,450, 146, 26);
        p1.add(PCLabel);
        
        // Required GPA label attributes
        RGLabel = new JLabel("Required GPA (If Any)");
        RGLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        RGLabel.setBounds(300, 500, 146, 26);
        p1.add(RGLabel);
        
        // Takes user input for program name
        // Attributes for text area
        programName = new JTextArea();
        programName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        programName.setBounds(500, 150, 186, 27);
        p1.add(programName);
       
        
        // Takes user input for program description
        // Attributes for text area
        programDesc = new JTextArea();
        programDesc.setFont(new Font("Tahoma", Font.PLAIN, 11));
        programDesc.setBounds(500,200, 238, 84);
        programDesc.setLineWrap(true);
        p1.add(programDesc);
  
        
        
        // Dropbox attributes for program level
        ProgramCBox = new JComboBox();
        ProgramCBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        ProgramCBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Bachelor's", "Master's", "PhD"}));
        ProgramCBox.setBounds(500, 350, 186, 26);
        ProgramCBox.setEnabled(true);
        p1.add(ProgramCBox);
        

        
        // Program type selection menu attributes
         PTCBox = new JComboBox();
         PTCBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
         PTCBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Science", "Arts", "Other"}));
         PTCBox.setBounds(500, 400, 186, 26);
         PTCBox.setEnabled(true);
        p1.add( PTCBox);
        
              
        
        // text area for program code 
        JTextArea programCode = new JTextArea();
        programCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
        programCode.setColumns(10);
        programCode.setBounds(500, 450, 186, 27);
        p1.add(programCode);
        
        

        
        // Checkbox for specifying diploma program
        DPCheckBox = new JCheckBox("Diploma Program");
        DPCheckBox.setBackground(new Color(173, 173, 173));
        DPCheckBox.setBounds(500, 600, 179, 35);
        DPCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        DPCheckBox.addActionListener(new ActionListener() {
            /**
            * actionPerformed for diploma checkbox
            * @param    ActionEvent - if checkbox is checked off
            * @return   void
            **/

            public void actionPerformed(ActionEvent e) {
                // Checks if program added is a diploma program (checked)
                if (DPCheckBox.isSelected()) {
                    // Sets program level and type for diploma program
                    ProgramCBox.setEnabled(false);
                     PTCBox.setEnabled(false);
                }
                // For non-diploma programs
                else
                {
                    // Sets program level and type for program
                    ProgramCBox.setEnabled(true);
                     PTCBox.setEnabled(true);
                }
            }
        });
        p1.add(DPCheckBox);
        
        // Takes user input for requiredGPA
        JTextArea reqGPA = new JTextArea();
        reqGPA.setFont(new Font("Tahoma", Font.PLAIN, 13));
        reqGPA.setBounds(500, 500, 186, 26);
        p1.add(reqGPA);
        
        // Go Back button returns user to main menu
        JButton btnNewButton = new JButton("Go Back");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout) contentPane.getLayout();
                    card.show(contentPane, "mmf");
                    programName.setText("");
                    programDesc.setText("");
                    reqGPA.setText("");
                    programCode.setText("");
                    
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(850, 10, 100, 25);
        p1.add(btnNewButton);
        
        ArrayList arr = tool.getDepartment();
        String [] departments = new String[arr.size()];
        for (int x = 0; x < departments.length; x++){
            departments[x] = (String) arr.get(x);
        }
        
        JComboBox comboDepartment = new JComboBox();
        comboDepartment.setModel(new DefaultComboBoxModel(departments));
        comboDepartment.setBounds(500, 300, 193, 27);
        p1.add(comboDepartment);
  
        // Submit button
        JButton submitBtn = new JButton("Submit");
       
        submitBtn.setFont(new Font("Tahoma", Font.BOLD, 21));
        submitBtn.addActionListener(new ActionListener() {
            /**
            * actionPerformed handles submit button
            * @param    ActionEvent - when submit button is clicked
            * @return   void
            */
            public void actionPerformed(ActionEvent arg0) {
                if(programName.getText().isEmpty()){
                    inputError.setText("Please Enter Valid Name");
                }
                else if(programDesc.getText().isEmpty()){
                    inputError.setText("Please Enter Valid Description");
                }
                else if(reqGPA.getText().isEmpty())
                {
                    inputError.setText("Please enter \"None\" or a required GPA");
                }
                else if(programCode.getText().isEmpty()){
                    inputError.setText("Please enter a valid code");
                }
                // If diploma program - writes diploma info to programDB.txt
                else
                {   
                    if(DPCheckBox.isSelected())
                    {
                        tool.writeToProgram(programName.getText(), programDesc.getText(), (String)comboDepartment.getSelectedItem(), 
                                "None", "Diploma", reqGPA.getText(), programCode.getText());
                    }
                    // For non-diploma programs writes program info to programDB.txt
                    else {
                    
                        tool.writeToProgram(programName.getText(), programDesc.getText(), (String)comboDepartment.getSelectedItem(),
                            ProgramCBox.getSelectedItem(),  PTCBox.getSelectedItem(), reqGPA.getText(), programCode.getText());
                    }
                    
                    // Returns user to main menu
                    CardLayout card = (CardLayout) contentPane.getLayout();
                    card.show(contentPane, "mmf");
                      programName.setText("");
                    programDesc.setText("");
                    reqGPA.setText("");
                    programCode.setText("");
                    
                }
            }
        });
        submitBtn.setBounds(500, 600, 141, 35);
        p1.add(submitBtn);
        p1.add(editpbg);
        contentPane.add(p1);
        add(p1);
        
        
    }
}

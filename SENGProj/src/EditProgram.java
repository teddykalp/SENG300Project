// import libraries 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;


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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


// EditProgram allows the user to select an existing program in the DB and modify its fields 
public class EditProgram extends JPanel {

    // Class attributes
    private JPanel contentPane;
    private JTextArea programName, programDesc, reqGPA, programCode, programLvl, programType;
    private JComboBox comboDepartment, comboProgramBox;
    private JCheckBox chckDiplomaProgram;
    private JLabel lblDepartment;

    private RWTools tool = new RWTools();
    private String oldName, oldCode, oldDesc, oldDepartment, oldLvl, oldType, oldGPA;
    private String newName, newCode, newDesc, newDepartment, newLvl, newType, newGPA;
    
    ImageLibrary img = new ImageLibrary();
        
    /**
     * Launch the application.
     */

    /**
     * editProgram constructor that creates the frame and adds its components.
     * @param   user - staff user that is editing a course
     */
    public EditProgram(JPanel panel) {
         JPanel p1 = new JPanel(null);
                p1.setPreferredSize(new Dimension(1000,1000));
                contentPane = panel;
                
        
        
          //IMG
        JPanel editpbg = new JPanel();
        ImageIcon pic = img.editpbg;
       editpbg.setSize(1000,1000);
       editpbg.add(new JLabel(pic));
       editpbg.setEnabled(true);
       editpbg.setVisible(true);  
        
        //Creates Arraylist of programs to choose to edit
        ArrayList programsL = tool.getPrograms();
        String [] programs = new String[programsL.size()];
        for (int x = 0; x < programs.length; x++){
            programs[x] = (String)programsL.get(x);
        }
        
        // Drop menu of programs to choose from
        comboProgramBox = new JComboBox();
        comboProgramBox.setModel(new DefaultComboBoxModel(programs));
        comboProgramBox.setBounds(500, 150, 193, 26);
        p1.add(comboProgramBox);
        
        // choose program label
        JLabel lblChooseProgram = new JLabel("Choose Program");
        lblChooseProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblChooseProgram.setBounds(300, 150, 113, 26);
        p1.add(lblChooseProgram);
            
        // Program registration label
        JLabel CView = new JLabel("Edit Program");
         CView.setFont(new Font("Tahoma", Font.BOLD, 30));
         CView.setForeground(Color.WHITE);
         CView.setBounds(410, 20, 500,50);
        p1.add( CView);
        
        // message label
        JLabel lblNewLabel = new JLabel("Which Program would you like to edit?");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(300, 100, 500, 26);
        p1.add(lblNewLabel);
        
        // Program name label
        JLabel lblProgramName = new JLabel("Program Name");
        lblProgramName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblProgramName.setBounds(300, 200, 92, 26);
        p1.add(lblProgramName);
        
        // Program description label
        JLabel lblProgramDesc = new JLabel("Program Description");
        lblProgramDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblProgramDesc.setBounds(300, 250, 131, 26);
        p1.add(lblProgramDesc);
        
        // Takes user input for program name
        // Attributes for text area
        programName = new JTextArea();
        programName.setEditable(false);
        programName.setBounds(500, 200, 186, 27);
        p1.add(programName);
        programName.setColumns(10);
        
        // Takes user input for program description
        // Attributes for text area
        programDesc = new JTextArea();
        programDesc.setEditable(false);
        programDesc.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        programDesc.setBounds(500, 250, 238, 84);
        programDesc.setLineWrap(true);
        p1.add(programDesc);
        programDesc.setColumns(10);
        
        // Department label
        lblDepartment = new JLabel("Department");
        lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDepartment.setBounds(300, 400, 131, 26);
        p1.add(lblDepartment);
            
        // Level of Program label Attributes
        JLabel lblLevelOfProgram = new JLabel("Level of Program");
        lblLevelOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblLevelOfProgram.setBounds(300, 450, 131, 26);
        p1.add(lblLevelOfProgram);
        
        // Text area attribute for program level
        programLvl = new JTextArea();
        programLvl.setEditable(false);
        programLvl.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        programLvl.setBounds(500, 450, 186, 26);
        programLvl.setEnabled(true);
        p1.add(programLvl);
            
        // Type of Program label attributes
        JLabel lblTypeOfProgram = new JLabel("Type of Program");
        lblTypeOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTypeOfProgram.setBounds(300, 500, 131, 26);
        p1.add(lblTypeOfProgram);
        
        // Program type attribute
        programType = new JTextArea();
        programType.setEditable(false);
        programType.setFont(new Font("Monospaced", Font.PLAIN, 11));
        programType.setBounds(500, 500, 186, 26);
        programType.setEnabled(true);
        p1.add(programType);
            
        // Required GPA label attributes
        JLabel lblRequiredGpa = new JLabel("Required GPA (If Any)");
        lblRequiredGpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblRequiredGpa.setBounds(300,550, 146, 26);
        p1.add(lblRequiredGpa);
    
        // Checkbox for specifying diploma program
        chckDiplomaProgram = new JCheckBox("Diploma Program");
        chckDiplomaProgram.setBackground(new Color(255, 222, 173));
        chckDiplomaProgram.setBounds(500, 600, 179, 35);
        chckDiplomaProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
        chckDiplomaProgram.addActionListener(new ActionListener() {
            
            /**
            * actionPerformed for diploma checkbox
            * @param    ActionEvent - if checkbox is checked off
            * @return   void
            **/

            public void actionPerformed(ActionEvent e) {
                // Checks if program added is a diploma program (checked)
                if (chckDiplomaProgram.isSelected()) {
                // Disables setting program level and type for diploma program
                    programLvl.setEnabled(false);
                    programType.setEnabled(false);
                }
                // For non-diploma programs
                else
                {
                    // Enables setting program level and type for program
                    programLvl.setEnabled(true);
                    programType.setEnabled(true);
                }
            }
        });
        p1.add(chckDiplomaProgram);
        
        // Takes user input for requiredGPA
        reqGPA = new JTextArea();
        reqGPA.setEditable(false);
        reqGPA.setBounds(500,550, 186, 26);
        p1.add(reqGPA);
        
        // Creates Arraylist of departments
        ArrayList arr = tool.getDepartment();
        String [] departments = new String[arr.size()];
        for (int x = 0; x < departments.length; x++){
        departments[x] = (String) arr.get(x);
        }
        
        // Drop menu of departments available
        comboDepartment = new JComboBox();
        comboDepartment.setModel(new DefaultComboBoxModel(departments));
        comboDepartment.setBounds(500, 400, 193, 27);
        p1.add(comboDepartment);
        
        // input error handling label
        JLabel inputError = new JLabel("");
        inputError.setForeground(Color.RED);
        inputError.setBackground(Color.RED);
        inputError.setFont(new Font("Tahoma", Font.PLAIN, 12));
        inputError.setBounds(500,700, 223, 26);
        p1.add(inputError);
        
        // program code hint label
        JLabel lblProgramCode = new JLabel("Program Code (XXXX)");
        lblProgramCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblProgramCode.setBounds(300, 360, 146, 26);
        p1.add(lblProgramCode);
        
        // Takes user input for program code
        programCode = new JTextArea();
        programCode.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        programCode.setEditable(false);
        programCode.setColumns(10);
        programCode.setBounds(500, 360, 186, 27);
        p1.add(programCode);
        
        // Button for editing the chosen program
        JButton btnEdit = new JButton("Edit");
        btnEdit.setBounds(700, 150, 100, 26);
        btnEdit.addActionListener(new ActionListener() { 
            
            /**
            * actionPerformed for edit button
            * @param    ActionEvent - if button is clicked
            * @return   void
            */
            
            public void actionPerformed(ActionEvent e) {
                programName.setEditable(true);
                programDesc.setEditable(true);
                programCode.setEditable(true);
                comboDepartment.setEditable(true);
                programLvl.setEditable(true);
                programType.setEditable(true);
                reqGPA.setEditable(true);
                
                
                
                // gets program information and sets text to new information
                ArrayList programInfo = tool.getProgramInfo((String)comboProgramBox.getSelectedItem());
                programName.setText((String)comboProgramBox.getSelectedItem());
                programCode.setText((String)programInfo.get(0));
                programDesc.setText((String)programInfo.get(1));
                String depName = (String)programInfo.get(2);
                String deps;
                int index = -1;
                for(int j = 0; j < (tool.getDepartment()).size(); j++) {
                    deps = ((String)tool.getDepartment().get(j));
                    if(deps.equals(depName))
                    {
                        index = j;
                    }
                }
                comboDepartment.setSelectedIndex(index);
                programLvl.setText((String)programInfo.get(3));
                programType.setText((String)programInfo.get(4));
                reqGPA.setText((String)programInfo.get(5));
                
                // If program chosen is diploma, checkbox is checked
                // and program level and type are disabled
                if(((String)programInfo.get(3)).equals("None") && ((String)programInfo.get(4)).equals("Diploma")) 
                {
                    chckDiplomaProgram.setSelected(true);
                    programLvl.setEnabled(false);
                    programType.setEnabled(false);
                }
                
                oldName = "PROGRAM NAME: " + ((String)comboProgramBox.getSelectedItem());
                oldCode = "PROGRAM CODE: " + ((String)programInfo.get(0));
                oldDesc = "PROGRAM DESCRIPTION: " + ((String)programInfo.get(1));
                oldDepartment = "DEPARTMENT: " + (String)comboDepartment.getSelectedItem();
                oldLvl = "PROGRAM LEVEL: " + ((String)programInfo.get(3));
                oldType = "PROGRAM TYPE: " + ((String)programInfo.get(4));
                oldGPA = "REQUIRED GPA: " + ((String)programInfo.get(5));
                
            }
        });
        btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        p1.add(btnEdit);
        
        // Save button that will overwrite existing program in db with new information 
        JButton btnSaveProgram = new JButton("Commit Changes");
        btnSaveProgram.addActionListener(new ActionListener() {
            /**
            * actionPerformed handles save button
            * @param    ActionEvent - when save button is clicked
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
                
                // If diploma program - writes diploma info to programDB.txt
                else
                {   
                    newName = "PROGRAM NAME: " + programName.getText();
                    newCode = "PROGRAM CODE: " + programCode.getText();
                    newDesc = "PROGRAM DESCRIPTION: " + programDesc.getText();
                    newDepartment = "DEPARTMENT: " + (String)comboDepartment.getSelectedItem();
                    newGPA = "REQUIRED GPA: " + reqGPA.getText();
                    
                    if(chckDiplomaProgram.isSelected())
                    {
                        newLvl = "PROGRAM LEVEL: None";
                        newType = "PROGRAM TYPE: Diploma";
                    }
                    // For non-diploma programs writes program info to programDB.txt
                    else {
                        newLvl = "PROGRAM LEVEL: " + programLvl.getText();
                        newType = "PROGRAM TYPE: " + programType.getText(); 
                    }
                    
                    String db = "programDB/txt";
                    
                    tool.editDB(oldName, newName, db);
                    tool.editDB(oldCode, newCode, db);
                    tool.editDB(oldDesc, newDesc, db);
                    tool.editDB(oldDepartment, newDepartment, db);
                    tool.editDB(oldLvl, newLvl, db);
                    tool.editDB(oldType, newType, db);
                    tool.editDB(oldGPA, newGPA, db);
                    
                    // Returns user to main menu
                    CardLayout cardLayout = (CardLayout) p1.getLayout();
                            cardLayout.show(contentPane, "mmf");
                }
            }
        });
        btnSaveProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnSaveProgram.setBounds(500, 650, 163, 35);
        p1.add(btnSaveProgram);
        
        // Cancel button returns user to main menu
        JButton btnCancel = new JButton("Go Back");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    CardLayout cardLayout = (CardLayout)contentPane.getLayout();
                            cardLayout.show(contentPane, "mmf");
            }
        });
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCancel.setBounds(850, 10, 100, 25);
        p1.add(btnCancel);
        p1.add(editpbg);
        contentPane.add(p1);
        add(p1);
            
    }
}

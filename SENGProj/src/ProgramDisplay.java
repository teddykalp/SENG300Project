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


public class ProgramDisplay extends JPanel {

    private JPanel contentPane;
    private JTextArea programName, programDesc, reqGPA, programLvl, programType;
    private JComboBox comboDepartment, comboProgramBox;
    private RWTools tool = new RWTools();
    ImageLibrary img = new ImageLibrary();
    
    private JLabel lblDepartment;
    
    private JLabel lblChooseProgram;
    private JLabel lblView;
    private JLabel lblProgramName;
    private JLabel lblProgramDesc;
    private JLabel lblLevelOfProgram;
    private JLabel lblTypeOfProgram;
    private JLabel lblRequiredGpa;
    private JLabel lblCode;
    
    private JTextArea departDesc;
    private JTextArea programCode;
    
    private JButton btnView;
    private JButton buttonCancel;
    



    /**
     * Create the frame.
     */
    public ProgramDisplay(JPanel panel) {
                JPanel p1 = new JPanel(null);
                p1.setPreferredSize(new Dimension(1000,1000));
                contentPane = panel;
                
                //Creates Arraylist of programs to choose to edit
                ArrayList programsL = tool.getPrograms();
                String [] programs = new String[programsL.size()];
                for (int x = 0; x < programs.length; x++){
                    programs[x] = (String)programsL.get(x);
                }
                
                
                  //IMG
                JPanel editpbg = new JPanel();
                ImageIcon pic = img.editpbg;
                editpbg.setSize(1000,1000);
                editpbg.add(new JLabel(pic));
                editpbg.setEnabled(true);
                editpbg.setVisible(true);  
                
                // Drop menu of programs to choose from
                comboProgramBox = new JComboBox();
                comboProgramBox.setModel(new DefaultComboBoxModel(programs));
                comboProgramBox.setBounds(500, 150, 200, 25);
                p1.add(comboProgramBox);
                
                JLabel DView = new JLabel("View Program");
                 DView.setFont(new Font("Tahoma", Font.BOLD, 30));
                 DView.setForeground(Color.WHITE);
                 DView.setBounds(410, 50, 500,50);
                p1.add( DView);
                
                JLabel lblNewLabel = new JLabel("What Program would you like to see?");
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblNewLabel.setForeground(Color.WHITE);
                lblNewLabel.setBounds(300, 100, 500, 26);
                p1.add(lblNewLabel);
                        
                lblChooseProgram = new JLabel("Choose Program");
                lblChooseProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
                lblChooseProgram.setBounds(300, 150, 113, 26);
                p1.add(lblChooseProgram);
                    
           
                // Program name label
                lblProgramName = new JLabel("Program Name");
                lblProgramName.setFont(new Font("Tahoma", Font.PLAIN, 14));
                lblProgramName.setBounds(300, 200, 100, 50);
                p1.add(lblProgramName);
                
                // Program description label
                lblProgramDesc = new JLabel("Program Description");
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
                programDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
                lblLevelOfProgram = new JLabel("Level of Program");
                lblLevelOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
                lblLevelOfProgram.setBounds(300, 450, 131, 26);
                p1.add(lblLevelOfProgram);
                
                // Text area attribute for program level
                programLvl = new JTextArea();
                programLvl.setEditable(false);
                programLvl.setFont(new Font("Tahoma", Font.PLAIN, 11));
                programLvl.setBounds(500, 450, 186, 26);
                programLvl.setEnabled(true);
                p1.add(programLvl);
                    
                // Type of Program label attributes
                lblTypeOfProgram = new JLabel("Type of Program");
                lblTypeOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
                lblTypeOfProgram.setBounds(300, 500, 131, 26);
                p1.add(lblTypeOfProgram);
                
                // Program type attribute
                programType = new JTextArea();
                programType.setEditable(false);
                programType.setFont(new Font("Tahoma", Font.PLAIN, 11));
                programType.setBounds(500, 500, 186, 26);
                programType.setEnabled(true);
                p1.add(programType);
                    
                // Required GPA label attributes
                lblRequiredGpa = new JLabel("Required GPA ");
                lblRequiredGpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
                lblRequiredGpa.setBounds(300, 550, 146, 26);
                p1.add(lblRequiredGpa);
                
                reqGPA = new JTextArea();
                reqGPA.setEditable(false);
                reqGPA.setBounds(500, 550, 186, 26);
                p1.add(reqGPA);
                
                departDesc = new JTextArea();
                departDesc.setFont(new Font("Tahoma", Font.PLAIN, 11));
                departDesc.setEnabled(true);
                departDesc.setEditable(false);
                departDesc.setBounds(500, 250, 186, 26);
                p1.add(departDesc);
                
                lblCode = new JLabel("Program Code (XXXX)");
                lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
                lblCode.setBounds(300, 400, 146, 26);
                p1.add(lblCode);
                
                programCode = new JTextArea();
                programCode.setFont(new Font("Tahoma", Font.PLAIN, 11));
                programCode.setEnabled(true);
                programCode.setEditable(false);
                programCode.setBounds(500, 400, 186, 26);
                p1.add(programCode);
                
                btnView = new JButton("View");
                btnView.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ArrayList programInfo = tool.getProgramInfo((String)comboProgramBox.getSelectedItem());
                        programName.setText((String)comboProgramBox.getSelectedItem());
                        programCode.setText((String)programInfo.get(0));
                        programDesc.setText((String)programInfo.get(1));
                        departDesc.setText((String)programInfo.get(2));
                        programLvl.setText((String)programInfo.get(3));
                        programType.setText((String)programInfo.get(4));
                        String gpa = (String)programInfo.get(5);
                        if(gpa.isEmpty()){
                            reqGPA.setText("None");
                        }
                        else{
                        reqGPA.setText(gpa);
                        }
                        
                    }
                });
                btnView.setFont(new Font("Tahoma", Font.BOLD, 18));
                btnView.setBounds(500, 600, 141, 35);
                p1.add(btnView);
                
                buttonCancel = new JButton("Go back");
                buttonCancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                            cardLayout.show(contentPane, "mmf");
                    }
                });
                buttonCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
                buttonCancel.setBounds(850, 10, 141, 25);
                p1.add(buttonCancel);
                p1.add(editpbg);
                contentPane.add(p1);
                add(p1);
    }
}

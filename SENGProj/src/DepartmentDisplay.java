// Import libraries 

import java.awt.EventQueue;

import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
* departmentDisplay class UI for showing departments
* @author   Teddy Kalp
* @version  1.0
*/

public class DepartmentDisplay extends JPanel {
    
    // Class attributes 
    private JPanel contentPane;
    private RWTools tool = new RWTools();
    
    
    private JComboBox departmentBox;
    
    private JLabel lblChooseDepartment;
    private JLabel lblDescription;
    private JLabel lblCode;
    private JLabel lblViewDepartment;
    
    private JTextArea departmentCode;
    private JTextArea departmentD;
    
    private JButton btnView;
    private JButton btnReturn;
    ImageLibrary img = new ImageLibrary();
    
    /**
     * departmentDisplay constructor that creates the frame and adds its components.
     * @param   user - staff user that is adding a department
     */
    public DepartmentDisplay(JPanel panel) {
        JPanel p1 = new JPanel(null);
        p1.setPreferredSize(new Dimension(1000,1000));
        contentPane = panel;
        
          //IMG
                JPanel editdbg = new JPanel();
                ImageIcon pic = img.editdbg;
                editdbg.setSize(1000,1000);
                editdbg.add(new JLabel(pic));
                editdbg.setEnabled(true);
                editdbg.setVisible(true);  
        
       
        
        // Gets list of departments available
        ArrayList arr = tool.getDepartment();
        String [] departments = new String[arr.size()];
        for (int x = 0; x < departments.length; x++){
            departments[x] = (String) arr.get(x);
        }
        
        JLabel DView = new JLabel("View Department");
                 DView.setFont(new Font("Tahoma", Font.BOLD, 30));
                 DView.setForeground(Color.WHITE);
                 DView.setBounds(410, 50, 500,50);
                p1.add( DView);
                
                JLabel lblNewLabel = new JLabel("What Department would you like to see?");
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblNewLabel.setForeground(Color.WHITE);
                lblNewLabel.setBounds(300, 100, 500, 26);
                p1.add(lblNewLabel);
        
        // Shows list of departments available to be selected from
        departmentBox = new JComboBox();
        departmentBox.setModel(new DefaultComboBoxModel(departments));
        departmentBox.setBounds(500, 150, 235, 32);
        p1.add(departmentBox);
        
        // Department text area and attributes
        departmentD = new JTextArea();
        departmentD.setEditable(false);
        departmentD.setBounds(500, 200, 245, 86);
        p1.add(departmentD);
        
        // Choose department label and attributes
        lblChooseDepartment = new JLabel("Choose Department");
        lblChooseDepartment.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblChooseDepartment.setBounds(300, 150, 201, 26);
        p1.add(lblChooseDepartment);
        
        // Department description label and attributes
        lblDescription = new JLabel("Description");
        lblDescription.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblDescription.setBounds(300, 200, 201, 26);
        p1.add(lblDescription);
        
        // Department code label and attributes
        lblCode = new JLabel("Code");
        lblCode.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblCode.setBounds(300, 300, 201, 26);
        p1.add(lblCode);
        
        departmentCode = new JTextArea();
        departmentCode.setEditable(false);
        departmentCode.setBounds(500,300, 245, 26);
        p1.add(departmentCode);
        
        btnView = new JButton("View");
        btnView.addActionListener(new ActionListener() {
            /**
            * actionPerformed for view button
            * @param    ActionEvent - when view button is clicked
            * @return   void
            */
            public void actionPerformed(ActionEvent e) {
                // Displays department info to UI
                departmentD.setText("");
                ArrayList departmentInfo = tool.getDepartmentInfo((String)departmentBox.getSelectedItem());
                departmentD.setText((String)departmentInfo.get(0));
                departmentCode.setText((String)departmentInfo.get(1));
                
            }
        });
        
        btnView.setFont(new Font("Tahoma", Font.BOLD, 21));
        btnView.setBounds(600, 350, 141, 35);
        p1.add(btnView);
        
        // Go Back button returns user to main menu
        btnReturn = new JButton("Go Back");
        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                            cardLayout.show(contentPane, "mmf");
            }
        });
     
        btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnReturn.setBounds(850, 10, 100, 25);
         
        p1.add(btnReturn);
        p1.add(editdbg);
        
        contentPane.add(p1);
        add(p1);
    }
}

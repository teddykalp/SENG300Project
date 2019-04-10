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
import java.util.ArrayList;


public class EditDepartment extends JPanel {

    private JPanel contentPane;
    private JTextField departName;
    private JTextField departCode;
    private RWTools tool = new RWTools();
    
    private JLabel lblNewLabel;
    private JComboBox comboDepartment;
    private JLabel lblDepartName;
    private JLabel lblDepartmentDesc;
    private JLabel lbldepartmentCode;
    
    private JTextArea departDesc;
    
    private JScrollPane scrollPane;
    
    private JButton btnCancel;
    private JButton editButton;
    private JButton commitChanges;
    
    // functionality purposes
    private String oldName;
    private String oldDesc;
    private String oldCode;
    private String newName;
    private String newDesc;
    private String newCode;
    
    ImageLibrary img = new ImageLibrary();
    /**
     * Create the frame.
     */
    public EditDepartment(JPanel panel) {
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
        
        JLabel DView = new JLabel("Edit Department");
         DView.setFont(new Font("Tahoma", Font.BOLD, 30));
         DView.setForeground(Color.WHITE);
         DView.setBounds(410, 50, 500,50);
        p1.add( DView);
        
        JLabel lblNewLabel = new JLabel("Which Department would you like to edit?");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(300, 100, 500, 26);
        p1.add(lblNewLabel);
        
        lblDepartName = new JLabel("Department Name");
        lblDepartName.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblDepartName.setBounds(300, 250, 200, 50);
        p1.add(lblDepartName);
        
        lblDepartmentDesc = new JLabel("<html><p>Department Description<p><html>");
        lblDepartmentDesc.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblDepartmentDesc.setBounds(300,320, 200, 50);
        p1.add(lblDepartmentDesc);
        
         
        lbldepartmentCode = new JLabel("<html><p>Department Code<p><html>");
        lbldepartmentCode.setFont(new Font("Tahoma", Font.BOLD, 17));
        lbldepartmentCode.setBounds(300, 520, 200, 50);
        p1.add(lbldepartmentCode);
        
        
        
        ArrayList arr = tool.getDepartment();
        String [] departments = new String[arr.size()];
        for (int x = 0; x < departments.length; x++){
            departments[x] = (String) arr.get(x);
        }
        
        
        JComboBox comboDepartment = new JComboBox();
        comboDepartment.setModel(new DefaultComboBoxModel(departments));
        comboDepartment.setBounds(400, 200, 100, 25);
        p1.add(comboDepartment);
        
        
        departName = new JTextField();
        departName.setBounds(500, 273, 200, 25);
        departName.setFont(new Font("Tahoma", Font.PLAIN, 17));
        p1.add(departName);

        
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(500, 328, 200, 150);
        p1.add(scrollPane);
        
        departDesc = new JTextArea();
        scrollPane.setViewportView(departDesc);
       
        
        departCode = new JTextField();
        departCode.setBounds(500, 520, 200, 25);
        p1.add(departCode);
        
        
        
        
        btnCancel = new JButton("Go Back");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "mmf");
            }
        });
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCancel.setBounds(800, 50, 100, 25);
        p1.add(btnCancel);
        
        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Displays department info to UI
                departName.setText((String) comboDepartment.getSelectedItem());
                ArrayList departmentInfo = tool.getDepartmentInfo((String)comboDepartment.getSelectedItem());
                departDesc.setText((String)departmentInfo.get(0));
                departCode.setText((String)departmentInfo.get(1));
                oldName = "DEPARTMENT NAME: " + (String) comboDepartment.getSelectedItem();
                oldDesc = "DEPARTMENT DESCRIPTION: " + (String)departmentInfo.get(0);
                oldCode = "DEPARTMENT CODE: " + (String)departmentInfo.get(1);
            }
        });
        editButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        editButton.setBounds(550, 200, 100, 25);
        p1.add(editButton);
        
        JButton commitChanges = new JButton("Commit Changes");
        commitChanges.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newName = "DEPARTMENT NAME: " + departName.getText();
                newDesc = "DEPARTMENT DESCRIPTION: "+ departDesc.getText();
                newCode = "DEPARTMENT CODE: " + departCode.getText();
                String db = "departmentDB.txt";
                
                tool.editDB(oldName, newName, db);
                tool.editDB(oldDesc, newDesc, db);
                tool.editDB(oldCode, newCode, db);
                
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                            cardLayout.show(contentPane, "mmf");
            }
        });
        commitChanges.setFont(new Font("Tahoma", Font.BOLD, 15));
        commitChanges.setBounds(400, 600, 200, 25);
        p1.add(commitChanges);
        
        
        
        p1.add(editdbg);
        contentPane.add(p1);
        add(p1);
    }
}

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

// editDepartment updates any existing departments in the dept db
public class EditDepartment extends JPanel {
    
    // class attributes 
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
        
        // edit dept label
        JLabel DView = new JLabel("Edit Department");
         DView.setFont(new Font("Tahoma", Font.BOLD, 30));
         DView.setForeground(Color.WHITE);
         DView.setBounds(410, 50, 500,50);
        p1.add( DView);
        
        // edit dept label
        JLabel lblNewLabel = new JLabel("Which Department would you like to edit?");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(300, 100, 500, 26);
        p1.add(lblNewLabel);
        
        // dept name label
        lblDepartName = new JLabel("Department Name");
        lblDepartName.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblDepartName.setBounds(300, 250, 200, 50);
        p1.add(lblDepartName);
        
        // dept description label
        lblDepartmentDesc = new JLabel("<html><p>Department Description<p><html>");
        lblDepartmentDesc.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblDepartmentDesc.setBounds(300,320, 200, 50);
        p1.add(lblDepartmentDesc);
        
         // dept code label
        lbldepartmentCode = new JLabel("<html><p>Department Code<p><html>");
        lbldepartmentCode.setFont(new Font("Tahoma", Font.BOLD, 17));
        lbldepartmentCode.setBounds(300, 520, 200, 50);
        p1.add(lbldepartmentCode);
        
        
        // array that is used to retrieve all existing depts in db
        ArrayList arr = tool.getDepartment();
        String [] departments = new String[arr.size()];
        for (int x = 0; x < departments.length; x++){
            departments[x] = (String) arr.get(x);
        }
        
        // drop down list of all depts that are available to edit 
        JComboBox comboDepartment = new JComboBox();
        comboDepartment.setModel(new DefaultComboBoxModel(departments));
        comboDepartment.setBounds(300, 200, 300, 25);
        p1.add(comboDepartment);
        
        // dept name text field 
        departName = new JTextField();
        departName.setBounds(500, 273, 200, 25);
        departName.setFont(new Font("Tahoma", Font.PLAIN, 17));
        p1.add(departName);

        
        // scroll bar for pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(500, 328, 200, 150);
        p1.add(scrollPane);
        
        // dept description text area
        departDesc = new JTextArea();
        scrollPane.setViewportView(departDesc);
       
        // dept code text field
        departCode = new JTextField();
        departCode.setBounds(500, 520, 200, 25);
        p1.add(departCode);
        
        
        
        // cancel button that does not save any changes made to selected dept 
        btnCancel = new JButton("Go Back");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "mmf");
            }
        });
         btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCancel.setBounds(850, 10, 100, 25);
        p1.add(btnCancel);
        
        // edit button that retrieves a selected depts information and displays it to the user
        // the user can then update the given fields and commit the change to the db 
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
        editButton.setBounds(630, 200, 100, 25);
        p1.add(editButton);
        
        // commit button that overwrites the exsting dept in the db 
        JButton commitChanges = new JButton("Commit Changes");
        commitChanges.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newName = "DEPARTMENT NAME: " + departName.getText();
                newDesc = "DEPARTMENT DESCRIPTION: "+ departDesc.getText();
                newCode = "DEPARTMENT CODE: " + departCode.getText();
                String db = "departmentDB.txt";
                
                // call RWTools to update dept entry in db
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
        
        
        // add content to panel 
        p1.add(editdbg);
        contentPane.add(p1);
        add(p1);
    }
}

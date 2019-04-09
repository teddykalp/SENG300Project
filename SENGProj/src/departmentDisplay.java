// Import libraries 
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* departmentDisplay class UI for showing departments
* @author	Teddy Kalp
* @version	1.0
*/

public class departmentDisplay extends JPanel {
	
	// Class attributes 
	private JPanel contentPane;
	private RWTools tool = new RWTools();
	private mainMenuForm menu;
	
	
	private JComboBox departmentBox;
	
	private JLabel lblChooseDepartment;
	private JLabel lblDescription;
	private JLabel lblCode;
	private JLabel lblViewDepartment;
	
	private JTextArea departmentCode;
	private JTextArea departmentD;
	
	private JButton btnView;
	private JButton btnReturn;
	
	/**
	 * departmentDisplay constructor that creates the frame and adds its components.
	 * @param	user - staff user that is adding a department
	 */
	public departmentDisplay(JPanel panel) {
		JPanel p1 = new JPanel(null);
		p1.setPreferredSize(new Dimension(1000,1000));
		contentPane = panel;
		
		// View department label and attributes
		lblViewDepartment = new JLabel("View Department");
		lblViewDepartment.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblViewDepartment.setBounds(211, 0, 187, 26);
		p1.add(lblViewDepartment);
		
		// Gets list of departments available
		ArrayList arr = tool.getDepartment();
		String [] departments = new String[arr.size()];
		for (int x = 0; x < departments.length; x++){
			departments[x] = (String) arr.get(x);
		}
		
		
		// Shows list of departments available to be selected from
		departmentBox = new JComboBox();
		departmentBox.setModel(new DefaultComboBoxModel(departments));
		departmentBox.setBounds(51, 74, 235, 32);
		p1.add(departmentBox);
		
		// Department text area and attributes
		departmentD = new JTextArea();
		departmentD.setEditable(false);
		departmentD.setBounds(51, 146, 245, 86);
		p1.add(departmentD);
		
		// Choose department label and attributes
		lblChooseDepartment = new JLabel("Choose Department");
		lblChooseDepartment.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblChooseDepartment.setBounds(51, 47, 201, 26);
		p1.add(lblChooseDepartment);
		
		// Department description label and attributes
		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblDescription.setBounds(51, 118, 201, 26);
		p1.add(lblDescription);
		
		// Department code label and attributes
	    lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblCode.setBounds(51, 241, 201, 26);
		p1.add(lblCode);
		
		departmentCode = new JTextArea();
		departmentCode.setEditable(false);
		departmentCode.setBounds(51, 268, 245, 26);
		p1.add(departmentCode);
		
		btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			/**
			* actionPerformed for view button
			* @param	ActionEvent - when view button is clicked
			* @return 	void
			*/
			public void actionPerformed(ActionEvent e) {
				// Displays department info to UI
				departmentD.setText("");
				ArrayList departmentInfo = tool.getDepartmentInfo((String)departmentBox.getSelectedItem());
				departmentD.setText((String)departmentInfo.get(0));
				departmentCode.setText((String)departmentInfo.get(1));
				
			}
		});
		btnView.setBackground(new Color(173, 255, 47));
		btnView.setFont(new Font("Sylfaen", Font.BOLD, 21));
		btnView.setBounds(397, 241, 141, 35);
		p1.add(btnView);
		
		// Go Back button returns user to main menu
		btnReturn = new JButton("Go Back");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnReturn.setBackground(new Color(255, 105, 180));
		btnReturn.setFont(new Font("Sylfaen", Font.BOLD, 21));
		btnReturn.setBounds(397, 52, 141, 35);
		p1.add(btnReturn);
		
		contentPane.add(p1);
		add(p1);
	}
}

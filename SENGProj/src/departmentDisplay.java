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
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* departmentDisplay class UI for showing departments
* @author	Teddy Kalp
* @version	1.0
*/

public class departmentDisplay extends JFrame {
	
	// Class attributes 
	private JPanel contentPane;
	private RWTools tool = new RWTools();
	private mainMenuForm menu;

	/**
	 * main function: launches the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					departmentDisplay frame = new departmentDisplay(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * departmentDisplay constructor that creates the frame and adds its components.
	 * @param	user - staff user that is adding a department
	 */
	public departmentDisplay(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// View department label and attributes
		JLabel lblViewDepartment = new JLabel("View Department");
		lblViewDepartment.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblViewDepartment.setBounds(211, 0, 187, 26);
		contentPane.add(lblViewDepartment);
		
		// Gets list of departments available
		ArrayList arr = tool.getDepartment();
		String [] departments = new String[arr.size()];
		for (int x = 0; x < departments.length; x++){
			departments[x] = (String) arr.get(x);
		}
		
		
		// Shows list of departments available to be selected from
		JComboBox departmentBox = new JComboBox();
		departmentBox.setModel(new DefaultComboBoxModel(departments));
		departmentBox.setBounds(51, 74, 235, 32);
		contentPane.add(departmentBox);
		
		// Department text area and attributes
		JTextArea departmentD = new JTextArea();
		departmentD.setEditable(false);
		departmentD.setBounds(51, 146, 245, 86);
		contentPane.add(departmentD);
		
		// Choose department label and attributes
		JLabel lblChooseDepartment = new JLabel("Choose Department");
		lblChooseDepartment.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblChooseDepartment.setBounds(51, 47, 201, 26);
		contentPane.add(lblChooseDepartment);
		
		// Department description label and attributes
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblDescription.setBounds(51, 118, 201, 26);
		contentPane.add(lblDescription);
		
		// Department code label and attributes
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblCode.setBounds(51, 241, 201, 26);
		contentPane.add(lblCode);
		
		JTextArea departmentCode = new JTextArea();
		departmentCode.setEditable(false);
		departmentCode.setBounds(51, 268, 245, 26);
		contentPane.add(departmentCode);
		
		JButton btnView = new JButton("View");
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
		contentPane.add(btnView);
		
		// Go Back button returns user to main menu
		JButton btnReturn = new JButton("Go Back");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		btnReturn.setBackground(new Color(255, 105, 180));
		btnReturn.setFont(new Font("Sylfaen", Font.BOLD, 21));
		btnReturn.setBounds(397, 52, 141, 35);
		contentPane.add(btnReturn);
	}
}

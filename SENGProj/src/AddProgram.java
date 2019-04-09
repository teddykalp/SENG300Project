// Imported libraries
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.TextField;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
* AddProgram form that allows staff users to add a program to the system
* @author	Teddy Kalp, Angeli Manipon
* @version 	2.0
*/

public class AddProgram extends JFrame {
	// Class attributes
	private JPanel contentPane;
	private JTextArea programName;
	private JTextArea programDesc;
	private JLabel lblDepartment;
	private mainMenuForm menu;
	private RWTools tool = new RWTools();
	
	/**
	 * Launch the application.
	 */

	/**
	 * AddProgram constructor that creates the frame and adds its components.
	 * @param	user - staff user that is adding a course
	 */
	public AddProgram(String user) {
		
		// Closes window when the user exits the frame 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Creates the window and set bounds
		setBounds(100, 100, 1040, 1050);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Program registration label attributes
		JLabel lblNewLabel = new JLabel("Program Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(455, 16, 231, 26);
		contentPane.add(lblNewLabel);
		
		// Program name label attributes
		JLabel lblProgramName = new JLabel("<html>Course Title<br>\r\n (E.g. Computer Science)<html>");
		lblProgramName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgramName.setBounds(250, 53, 225, 51);
		contentPane.add(lblProgramName);
		
		// Program description label attributes
		JLabel lblProgramDesc = new JLabel("Program Description");
		lblProgramDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgramDesc.setBounds(250, 120, 131, 26);
		contentPane.add(lblProgramDesc);
		
		// Takes user input for program name
		// Attributes for text area
		programName = new JTextArea();
		programName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		programName.setBounds(525, 74, 200, 26);
		contentPane.add(programName);
		programName.setColumns(10);
		
		// Takes user input for program description
		// Attributes for text area
		programDesc = new JTextArea();
		programDesc.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		JScrollPane progsDescScroll = new JScrollPane (programDesc, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		progsDescScroll.setBounds(525, 126, 238, 84);
		programDesc.setLineWrap(true);
		contentPane.add(progsDescScroll);
		programDesc.setColumns(10);
		
		// Department label attributes
		lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartment.setBounds(250, 288, 131, 26);
		contentPane.add(lblDepartment);
		
		// Level of Program label Attributes
		JLabel lblLevelOfProgram = new JLabel("Level of Program");
		lblLevelOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLevelOfProgram.setBounds(250, 345, 131, 26);
		contentPane.add(lblLevelOfProgram);
		
		// Dropbox attributes for program level
		JComboBox programLvl = new JComboBox();
		programLvl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		programLvl.setModel(new DefaultComboBoxModel(new String[] {"None", "Bachelor's", "Master's", "PhD"}));
		programLvl.setBounds(525, 345, 186, 26);
		programLvl.setEnabled(true);
		contentPane.add(programLvl);
		
		// Type of Program label attributes
		JLabel lblTypeOfProgram = new JLabel("Type of Program");
		lblTypeOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTypeOfProgram.setBounds(250, 404, 131, 26);
		contentPane.add(lblTypeOfProgram);
		
		// Program type selection menu attributes
		JComboBox programType = new JComboBox();
		programType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		programType.setModel(new DefaultComboBoxModel(new String[] {"None", "Science", "Arts", "Other"}));
		programType.setBounds(525, 404, 186, 26);
		programType.setEnabled(true);
		contentPane.add(programType);
		
		// Required GPA label attributes
		JLabel lblRequiredGpa = new JLabel("Required GPA (If Any)");
		lblRequiredGpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRequiredGpa.setBounds(250, 449, 146, 26);
		contentPane.add(lblRequiredGpa);
		
		// Checkbox for specifying diploma program
		JCheckBox chckDiplomaProgram = new JCheckBox("Diploma Program");
		chckDiplomaProgram.setBackground(new Color(255, 222, 173));
		chckDiplomaProgram.setBounds(525, 509, 179, 35);
		chckDiplomaProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckDiplomaProgram.addActionListener(new ActionListener() {
			/**
			* actionPerformed for diploma checkbox
			* @param	ActionEvent - if checkbox is checked off
			* @return 	void
			**/

			public void actionPerformed(ActionEvent e) {
				// Checks if program added is a diploma program (checked)
				if (chckDiplomaProgram.isSelected()) {
					// Sets program level and type for diploma program
					programLvl.setEnabled(false);
					programType.setEnabled(false);
				}
				// For non-diploma programs
				else
				{
					// Sets program level and type for program
					programLvl.setEnabled(true);
					programType.setEnabled(true);
				}
			}
		});
		contentPane.add(chckDiplomaProgram);
		
		// Takes user input for requiredGPA
		JTextArea reqGPA = new JTextArea();
		reqGPA.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		reqGPA.setBounds(525, 455, 200, 26);
		contentPane.add(reqGPA);
		
		// Go Back button returns user to main menu
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 21));
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		btnNewButton.setBounds(250,609,231,48);
		contentPane.add(btnNewButton);
		
		ArrayList arr = tool.getDepartment();
		String [] departments = new String[arr.size()];
		for (int x = 0; x < departments.length; x++){
			departments[x] = (String) arr.get(x);
		}
		
		JComboBox comboDepartment = new JComboBox();
		comboDepartment.setModel(new DefaultComboBoxModel(departments));
		comboDepartment.setBounds(525, 290, 193, 27);
		contentPane.add(comboDepartment);
		
		JLabel inputError = new JLabel("");
		inputError.setForeground(Color.RED);
		inputError.setBackground(Color.RED);
		inputError.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputError.setBounds(525, 562, 223, 26);
		contentPane.add(inputError);
		
		JLabel lblProgramCode = new JLabel("<html>Course Title (XXXX)<br>\r\n (E.g. CPSC)<html>");
		lblProgramCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgramCode.setBounds(250, 230, 146, 35);
		contentPane.add(lblProgramCode);
		
		JTextArea programCode = new JTextArea();
		programCode.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		programCode.setColumns(10);
		programCode.setBounds(525, 235, 200, 27);
		contentPane.add(programCode);
		
		// Submit button
		JButton submitBtn = new JButton("Submit");
		submitBtn.setBackground(new Color(176, 196, 222));
		submitBtn.setFont(new Font("Candara", Font.BOLD, 21));
		submitBtn.addActionListener(new ActionListener() {
			/**
			* actionPerformed handles submit button
			* @param	ActionEvent - when submit button is clicked
			* @return 	void
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
					if(chckDiplomaProgram.isSelected())
					{
						tool.writeToProgram(programName.getText(), programDesc.getText(), (String)comboDepartment.getSelectedItem(), 
								"None", "Diploma", reqGPA.getText(), programCode.getText());
					}
					// For non-diploma programs writes program info to programDB.txt
					else {
					
						tool.writeToProgram(programName.getText(), programDesc.getText(), (String)comboDepartment.getSelectedItem(),
							            programLvl.getSelectedItem(), programType.getSelectedItem(), reqGPA.getText(), programCode.getText());
					}
					
					// Returns user to main menu
					menu = new mainMenuForm(user);
					setVisible(false);
					menu.setVisible(true);
				}
			}
		});
		submitBtn.setBounds(645, 610, 157, 48);
		contentPane.add(submitBtn);
		
		JLabel checkDipLabel = new JLabel("Check if Diploma Program:");
		checkDipLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkDipLabel.setBounds(250, 509, 170, 26);
		contentPane.add(checkDipLabel);
		
		
	}
}

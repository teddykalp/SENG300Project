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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
* AddProgram form for staff users to add a program to the system
* @author	TeddyKalp
* @version 	1.0
*/



public class AddProgram extends JFrame {

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
	 * Create the frame.
	 */
	
	/**
	* AddProgram function that contains form created from WindowsBuilder
	* @param	user - Staff user that is adding the course
	* @return 	N/A
	*/
	
	public AddProgram(String user) {
		
		// Window settings for WindowBuilder
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Program registration label
		JLabel lblNewLabel = new JLabel("Program Registration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(185, 19, 214, 26);
		contentPane.add(lblNewLabel);
		
		// Label for program name
		JLabel lblProgramName = new JLabel("Program Name");
		lblProgramName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgramName.setBounds(21, 66, 92, 26);
		contentPane.add(lblProgramName);
		
		// Label for program description
		JLabel lblProgramDesc = new JLabel("Program Description");
		lblProgramDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgramDesc.setBounds(21, 119, 131, 26);
		contentPane.add(lblProgramDesc);
		
		// Takes user input for program name in text area
		programName = new JTextArea();
		programName.setBounds(185, 66, 186, 27);
		contentPane.add(programName);
		programName.setColumns(10);
		
		// Takes user input for program description in text area
		programDesc = new JTextArea();
		programDesc.setFont(new Font("Monospaced", Font.PLAIN, 11));
		programDesc.setBounds(185, 114, 238, 84);
		programDesc.setLineWrap(true);
		contentPane.add(programDesc);
		programDesc.setColumns(10);
		
		// Label for department
		lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartment.setBounds(21, 275, 131, 26);
		contentPane.add(lblDepartment);
		
		// Label for level of program
		JLabel lblLevelOfProgram = new JLabel("Level of Program");
		lblLevelOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLevelOfProgram.setBounds(21, 330, 131, 26);
		contentPane.add(lblLevelOfProgram);
		
		// Label for program level selection
		JComboBox programLvl = new JComboBox();
		programLvl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		programLvl.setModel(new DefaultComboBoxModel(new String[] {"None", "Bachelor's", "Master's", "PhD"}));
		programLvl.setBounds(185, 325, 186, 26);
		programLvl.setEnabled(false);
		contentPane.add(programLvl);
		
		// Label for type of program
		JLabel lblTypeOfProgram = new JLabel("Type of Program");
		lblTypeOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTypeOfProgram.setBounds(21, 377, 131, 26);
		contentPane.add(lblTypeOfProgram);
		
		// Program type selection
		JComboBox programType = new JComboBox();
		programType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		programType.setModel(new DefaultComboBoxModel(new String[] {"None", "Science", "Arts", "Other"}));
		programType.setBounds(185, 372, 186, 26);
		programType.setEnabled(false);
		contentPane.add(programType);
		
		// Label for requiredGPA
		JLabel lblRequiredGpa = new JLabel("Required GPA (If Any)");
		lblRequiredGpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRequiredGpa.setBounds(21, 424, 146, 26);
		contentPane.add(lblRequiredGpa);
		
		// Checkbox for specifying diploma program or not
		JCheckBox chckDiplomaProgram = new JCheckBox("Diploma Program");
		chckDiplomaProgram.setBackground(new Color(255, 222, 173));
		chckDiplomaProgram.setBounds(185, 482, 179, 35);
		chckDiplomaProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckDiplomaProgram.addActionListener(new ActionListener() {
			/**
			* actionPerformed for when checkbox for diploma program is checked or not
			* @param	ActionEvent - if checkbox is checked off
			* @return 	void
			*/
			public void actionPerformed(ActionEvent e) {
				// Checks if program added is a diploma program (checked)
				if (chckDiplomaProgram.isSelected()) {
					// Sets program level and type for diploma
					programLvl.setEnabled(true);
					programType.setEnabled(true);
				}
				// For non-diploma programs
				else
				{
					// Sets program level and type
					programLvl.setEnabled(false);
					programType.setEnabled(false);
				}
			}
		});
		contentPane.add(chckDiplomaProgram);
		
		// Takes user input for requiredGPA
		JTextArea reqGPA = new JTextArea();
		reqGPA.setBounds(185, 423, 186, 26);
		contentPane.add(reqGPA);
		
		// Takes user input for programDepartment
		JTextArea programDepart = new JTextArea();
		programDepart.setColumns(10);
		programDepart.setBounds(185, 275, 186, 27);
		contentPane.add(programDepart);
		
		// Go Back button returns user to main menu
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 21));
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.addActionListener(new ActionListener() {
			// ActionHandler for button
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		btnNewButton.setBounds(433, 10, 141, 35);
		contentPane.add(btnNewButton);
		
		// Submit button
		JButton submitBtn = new JButton("Submit");
		submitBtn.setBackground(new Color(176, 196, 222));
		submitBtn.setFont(new Font("Candara", Font.BOLD, 21));
		submitBtn.addActionListener(new ActionListener() {
			/**
			* actionPerformed handles user input in AddProgram form
			* @param	ActionEvent - when submit button is clicked
			* @return 	void
			*/
			public void actionPerformed(ActionEvent arg0) {
				// If diploma program - writes diploma info to programDB.txt
				if(chckDiplomaProgram.isSelected())
				{
					tool.writeToProgram(programName.getText(), programDesc.getText(), programDepart.getText(), 
							"None", "Diploma", reqGPA.getText());
				}
				// For non-diploma programs writes program info to programDB.txt
				else {
					tool.writeToProgram(programName.getText(), programDesc.getText(), programDepart.getText(),
						            programLvl.getSelectedItem(), programType.getSelectedItem(), reqGPA.getText());
				}
				
				menu = new mainMenuForm(user);
				setVisible(false);
				menu.setVisible(true);
				
			}
		});
		submitBtn.setBounds(422, 505, 141, 35);
		contentPane.add(submitBtn);
		
		
		
	}
}

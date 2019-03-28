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



public class AddProgram extends JFrame {

	private JPanel contentPane;
	private JTextArea programName;
	private JTextArea programDesc;
	private JLabel lblDepartment;
	private JLabel lblProgramAbbreviation;
	private mainMenuForm menu;
	private RWTools tool = new RWTools();
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddProgram(String user) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Program Registration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(185, 19, 214, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblProgramName = new JLabel("Program Name");
		lblProgramName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgramName.setBounds(21, 66, 92, 26);
		contentPane.add(lblProgramName);
		
		JLabel lblProgramDesc = new JLabel("Program Description");
		lblProgramDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgramDesc.setBounds(21, 119, 131, 26);
		contentPane.add(lblProgramDesc);
		
		programName = new JTextArea();
		programName.setBounds(185, 66, 186, 27);
		contentPane.add(programName);
		programName.setColumns(10);
		
		programDesc = new JTextArea();
		programDesc.setFont(new Font("Monospaced", Font.PLAIN, 11));
		programDesc.setBounds(185, 114, 238, 84);
		programDesc.setLineWrap(true);
		contentPane.add(programDesc);
		programDesc.setColumns(10);
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartment.setBounds(21, 275, 131, 26);
		contentPane.add(lblDepartment);
		
		lblProgramAbbreviation = new JLabel("Program Abbreviation");
		lblProgramAbbreviation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgramAbbreviation.setBounds(21, 228, 146, 26);
		contentPane.add(lblProgramAbbreviation);
		
		JTextArea programAbb = new JTextArea();
		programAbb.setColumns(10);
		programAbb.setBounds(185, 219, 186, 27);
		contentPane.add(programAbb);
		
		JLabel lblLevelOfProgram = new JLabel("Level of Program");
		lblLevelOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLevelOfProgram.setBounds(21, 330, 131, 26);
		contentPane.add(lblLevelOfProgram);
		
		JComboBox programLvl = new JComboBox();
		programLvl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		programLvl.setModel(new DefaultComboBoxModel(new String[] {"None", "Bachelor's", "Master's", "PhD"}));
		programLvl.setBounds(185, 325, 186, 26);
		programLvl.setEnabled(false);
		contentPane.add(programLvl);
		
		JLabel lblTypeOfProgram = new JLabel("Type of Program");
		lblTypeOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTypeOfProgram.setBounds(21, 377, 131, 26);
		contentPane.add(lblTypeOfProgram);
		
		JComboBox programType = new JComboBox();
		programType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		programType.setModel(new DefaultComboBoxModel(new String[] {"None", "Science", "Arts", "Other"}));
		programType.setBounds(185, 372, 186, 26);
		programType.setEnabled(false);
		contentPane.add(programType);
		
		JLabel lblRequiredGpa = new JLabel("Required GPA (If Any)");
		lblRequiredGpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRequiredGpa.setBounds(21, 424, 146, 26);
		contentPane.add(lblRequiredGpa);
		
		JCheckBox chckDiplomaProgram = new JCheckBox("Diploma Program");
		chckDiplomaProgram.setBackground(new Color(255, 222, 173));
		chckDiplomaProgram.setBounds(185, 482, 179, 35);
		chckDiplomaProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckDiplomaProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckDiplomaProgram.isSelected()) {
					programLvl.setEnabled(true);
					programType.setEnabled(true);
				}
				else
				{
					programLvl.setEnabled(false);
					programType.setEnabled(false);
				}
			}
		});
		contentPane.add(chckDiplomaProgram);
		
		JTextArea reqGPA = new JTextArea();
		reqGPA.setBounds(185, 423, 186, 26);
		contentPane.add(reqGPA);
		
		JTextArea programDepart = new JTextArea();
		programDepart.setColumns(10);
		programDepart.setBounds(185, 275, 186, 27);
		contentPane.add(programDepart);
		
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
		btnNewButton.setBounds(433, 10, 141, 35);
		contentPane.add(btnNewButton);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setBackground(new Color(176, 196, 222));
		submitBtn.setFont(new Font("Candara", Font.BOLD, 21));
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckDiplomaProgram.isSelected())
				{
					tool.writeToProgram(programName.getText(), programDesc.getText(), programDepart.getText(), 
							"None", "Diploma", reqGPA.getText());
				}
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

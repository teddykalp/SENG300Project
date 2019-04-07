import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class programDisplay extends JFrame {

	private JPanel contentPane;
	private JTextArea programName, programDesc, reqGPA, programLvl, programType;
	private JComboBox comboDepartment, comboProgramBox;
	private RWTools tool = new RWTools();
	private JLabel lblDepartment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					programDisplay frame = new programDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public programDisplay() {
		// Closes window when the user exits the frame 
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Creates the window and set bounds
				setBounds(100, 100, 621, 632);
				contentPane = new JPanel();
				contentPane.setBackground(new Color(255, 222, 173));
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				//Creates Arraylist of programs to choose to edit
				ArrayList programsL = tool.getPrograms();
				String [] programs = new String[programsL.size()];
				for (int x = 0; x < programs.length; x++){
					programs[x] = (String)programsL.get(x);
				}
				
				// Drop menu of programs to choose from
				comboProgramBox = new JComboBox();
				comboProgramBox.setModel(new DefaultComboBoxModel(programs));
				comboProgramBox.setBounds(185, 64, 193, 26);
				contentPane.add(comboProgramBox);
				
				JLabel lblChooseProgram = new JLabel("Choose Program");
				lblChooseProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblChooseProgram.setBounds(21, 63, 113, 26);
				contentPane.add(lblChooseProgram);
					
				// Program registration label
				JLabel lblView = new JLabel("View Program");
				lblView.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
				lblView.setBounds(215, 19, 113, 26);
				contentPane.add(lblView);
				
				// Program name label
				JLabel lblProgramName = new JLabel("Program Name");
				lblProgramName.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblProgramName.setBounds(21, 110, 92, 26);
				contentPane.add(lblProgramName);
				
				// Program description label
				JLabel lblProgramDesc = new JLabel("Program Description");
				lblProgramDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblProgramDesc.setBounds(21, 152, 131, 26);
				contentPane.add(lblProgramDesc);
				
				// Takes user input for program name
				// Attributes for text area
				programName = new JTextArea();
				programName.setEditable(false);
				programName.setBounds(185, 110, 186, 27);
				contentPane.add(programName);
				programName.setColumns(10);
				
				// Takes user input for program description
				// Attributes for text area
				programDesc = new JTextArea();
				programDesc.setEditable(false);
				programDesc.setFont(new Font("Times New Roman", Font.PLAIN, 13));
				programDesc.setBounds(185, 155, 238, 84);
				programDesc.setLineWrap(true);
				contentPane.add(programDesc);
				programDesc.setColumns(10);
				
				// Department label
				lblDepartment = new JLabel("Department");
				lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblDepartment.setBounds(21, 305, 131, 26);
				contentPane.add(lblDepartment);
					
				// Level of Program label Attributes
				JLabel lblLevelOfProgram = new JLabel("Level of Program");
				lblLevelOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblLevelOfProgram.setBounds(21, 350, 131, 26);
				contentPane.add(lblLevelOfProgram);
				
				// Text area attribute for program level
				programLvl = new JTextArea();
				programLvl.setEditable(false);
				programLvl.setFont(new Font("Times New Roman", Font.PLAIN, 11));
				programLvl.setBounds(185, 350, 186, 26);
				programLvl.setEnabled(true);
				contentPane.add(programLvl);
					
				// Type of Program label attributes
				JLabel lblTypeOfProgram = new JLabel("Type of Program");
				lblTypeOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblTypeOfProgram.setBounds(21, 397, 131, 26);
				contentPane.add(lblTypeOfProgram);
				
				// Program type attribute
				programType = new JTextArea();
				programType.setEditable(false);
				programType.setFont(new Font("Monospaced", Font.PLAIN, 11));
				programType.setBounds(185, 397, 186, 26);
				programType.setEnabled(true);
				contentPane.add(programType);
					
				// Required GPA label attributes
				JLabel lblRequiredGpa = new JLabel("Required GPA ");
				lblRequiredGpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblRequiredGpa.setBounds(21, 443, 146, 26);
				contentPane.add(lblRequiredGpa);
				
				reqGPA = new JTextArea();
				reqGPA.setEditable(false);
				reqGPA.setBounds(185, 443, 186, 26);
				contentPane.add(reqGPA);
				
				JTextArea departDesc = new JTextArea();
				departDesc.setFont(new Font("Times New Roman", Font.PLAIN, 11));
				departDesc.setEnabled(true);
				departDesc.setEditable(false);
				departDesc.setBounds(185, 305, 186, 26);
				contentPane.add(departDesc);
				
				JLabel label = new JLabel("Program Code (XXXX)");
				label.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label.setBounds(21, 258, 146, 26);
				contentPane.add(label);
				
				JTextArea programCode = new JTextArea();
				programCode.setFont(new Font("Times New Roman", Font.PLAIN, 11));
				programCode.setEnabled(true);
				programCode.setEditable(false);
				programCode.setBounds(185, 258, 186, 26);
				contentPane.add(programCode);
				
				JButton btnNewButton = new JButton("View");
				btnNewButton.addActionListener(new ActionListener() {
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
				btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
				btnNewButton.setBounds(421, 461, 141, 35);
				contentPane.add(btnNewButton);
				
				JButton button = new JButton("Cancel");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				button.setFont(new Font("Tahoma", Font.PLAIN, 15));
				button.setBounds(433, 13, 141, 35);
				contentPane.add(button);
	}
}

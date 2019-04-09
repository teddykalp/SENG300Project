import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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


public class programDisplay extends JPanel {

	private JPanel contentPane;
	private JTextArea programName, programDesc, reqGPA, programLvl, programType;
	private JComboBox comboDepartment, comboProgramBox;
	private RWTools tool = new RWTools();
	
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
	public programDisplay(JPanel panel) {
		JPanel p1 = new JPanel(null);
		p1.setPreferredSize(new Dimension(1000,1000));
		contentPane = panel;
				
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
				p1.add(comboProgramBox);
				
				lblChooseProgram = new JLabel("Choose Program");
				lblChooseProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblChooseProgram.setBounds(21, 63, 113, 26);
				p1.add(lblChooseProgram);
					
				// Program registration label
				lblView = new JLabel("View Program");
				lblView.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
				lblView.setBounds(215, 19, 113, 26);
				p1.add(lblView);
				
				// Program name label
				lblProgramName = new JLabel("Program Name");
				lblProgramName.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblProgramName.setBounds(21, 110, 92, 26);
				p1.add(lblProgramName);
				
				// Program description label
				lblProgramDesc = new JLabel("Program Description");
				lblProgramDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblProgramDesc.setBounds(21, 152, 131, 26);
				p1.add(lblProgramDesc);
				
				// Takes user input for program name
				// Attributes for text area
				programName = new JTextArea();
				programName.setEditable(false);
				programName.setBounds(185, 110, 186, 27);
				p1.add(programName);
				programName.setColumns(10);
				
				// Takes user input for program description
				// Attributes for text area
				programDesc = new JTextArea();
				programDesc.setEditable(false);
				programDesc.setFont(new Font("Times New Roman", Font.PLAIN, 13));
				programDesc.setBounds(185, 155, 238, 84);
				programDesc.setLineWrap(true);
				p1.add(programDesc);
				programDesc.setColumns(10);
				
				// Department label
				lblDepartment = new JLabel("Department");
				lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblDepartment.setBounds(21, 305, 131, 26);
				p1.add(lblDepartment);
					
				// Level of Program label Attributes
				lblLevelOfProgram = new JLabel("Level of Program");
				lblLevelOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblLevelOfProgram.setBounds(21, 350, 131, 26);
				p1.add(lblLevelOfProgram);
				
				// Text area attribute for program level
				programLvl = new JTextArea();
				programLvl.setEditable(false);
				programLvl.setFont(new Font("Times New Roman", Font.PLAIN, 11));
				programLvl.setBounds(185, 350, 186, 26);
				programLvl.setEnabled(true);
				p1.add(programLvl);
					
				// Type of Program label attributes
				lblTypeOfProgram = new JLabel("Type of Program");
				lblTypeOfProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblTypeOfProgram.setBounds(21, 397, 131, 26);
				p1.add(lblTypeOfProgram);
				
				// Program type attribute
				programType = new JTextArea();
				programType.setEditable(false);
				programType.setFont(new Font("Monospaced", Font.PLAIN, 11));
				programType.setBounds(185, 397, 186, 26);
				programType.setEnabled(true);
				p1.add(programType);
					
				// Required GPA label attributes
				lblRequiredGpa = new JLabel("Required GPA ");
				lblRequiredGpa.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblRequiredGpa.setBounds(21, 443, 146, 26);
				p1.add(lblRequiredGpa);
				
				reqGPA = new JTextArea();
				reqGPA.setEditable(false);
				reqGPA.setBounds(185, 443, 186, 26);
				p1.add(reqGPA);
				
				departDesc = new JTextArea();
				departDesc.setFont(new Font("Times New Roman", Font.PLAIN, 11));
				departDesc.setEnabled(true);
				departDesc.setEditable(false);
				departDesc.setBounds(185, 305, 186, 26);
				p1.add(departDesc);
				
				lblCode = new JLabel("Program Code (XXXX)");
				lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblCode.setBounds(21, 258, 146, 26);
				p1.add(lblCode);
				
				programCode = new JTextArea();
				programCode.setFont(new Font("Times New Roman", Font.PLAIN, 11));
				programCode.setEnabled(true);
				programCode.setEditable(false);
				programCode.setBounds(185, 258, 186, 26);
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
				btnView.setBounds(421, 461, 141, 35);
				p1.add(btnView);
				
				buttonCancel = new JButton("Cancel");
				buttonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				buttonCancel.setBounds(433, 13, 141, 35);
				p1.add(buttonCancel);
				
				contentPane.add(p1);
				add(p1);
	}
}

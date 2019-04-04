import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class staffRegister extends JFrame {

	
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField phoneNumber;
	private JTextField userEmail;
	private JTextField mailingAddress;
	private JTextField userID;
	private JTextField passWord;
	private JTextField confirmPass;
	private LoginForm form;
	private RWTools tool = new RWTools();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffRegister frame = new staffRegister();
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
	public staffRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblWelcome = new JLabel("Staff Registration Form");
		lblWelcome.setForeground(Color.GRAY);
		lblWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblWelcome.setBounds(204, 101, 230, 26);
		contentPane.add(lblWelcome);
		
		JLabel fNamelbl = new JLabel("First Name");
		fNamelbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		fNamelbl.setBounds(21, 135, 111, 26);
		contentPane.add(fNamelbl);
		
		JLabel lNamelbl = new JLabel("Last Name");
		lNamelbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lNamelbl.setBounds(21, 176, 111, 26);
		contentPane.add(lNamelbl);
		
		JLabel phoneLbl = new JLabel("Phone Number");
		phoneLbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		phoneLbl.setBounds(21, 212, 136, 26);
		contentPane.add(phoneLbl);
		
		JLabel emailAddlbl = new JLabel("Email Address");
		emailAddlbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		emailAddlbl.setBounds(21, 255, 124, 26);
		contentPane.add(emailAddlbl);
		
		JLabel mailingLbl = new JLabel("Mailing Address");
		mailingLbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		mailingLbl.setBounds(21, 293, 149, 26);
		contentPane.add(mailingLbl);
		
		JLabel dptLbl = new JLabel("Department");
		dptLbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		dptLbl.setBounds(21, 332, 149, 26);
		contentPane.add(dptLbl);
		
		JLabel stfTypelbl = new JLabel("Staff Type");
		stfTypelbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		stfTypelbl.setBounds(21, 373, 149, 26);
		contentPane.add(stfTypelbl);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblUserId.setBounds(21, 410, 149, 26);
		contentPane.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblPassword.setBounds(21, 449, 149, 26);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblConfirmPassword.setBounds(21, 493, 149, 26);
		contentPane.add(lblConfirmPassword);
		
		firstName = new JTextField();
		firstName.setBounds(180, 134, 186, 26);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(180, 176, 186, 26);
		contentPane.add(lastName);
		
		phoneNumber = new JTextField();
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(178, 212, 186, 26);
		contentPane.add(phoneNumber);
		
		userEmail = new JTextField();
		userEmail.setColumns(10);
		userEmail.setBounds(180, 248, 186, 26);
		contentPane.add(userEmail);
		
		mailingAddress = new JTextField();
		mailingAddress.setColumns(10);
		mailingAddress.setBounds(180, 286, 356, 26);
		contentPane.add(mailingAddress);
		
		userID = new JTextField();
		userID.setColumns(10);
		userID.setBounds(180, 403, 186, 26);
		contentPane.add(userID);
		
		passWord = new JTextField();
		passWord.setColumns(10);
		passWord.setBounds(180, 442, 186, 26);
		contentPane.add(passWord);
		
		confirmPass = new JTextField();
		confirmPass.setColumns(10);
		confirmPass.setBounds(180, 486, 186, 26);
		contentPane.add(confirmPass);
		
		JRadioButton rdbtnDH = new JRadioButton("Department Head");
		rdbtnDH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnDH.setBounds(128, 368, 136, 30);
		contentPane.add(rdbtnDH);
		
		JRadioButton rdbtnTeachingAssistant = new JRadioButton("Teaching Assistant");
		rdbtnTeachingAssistant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnTeachingAssistant.setBounds(290, 368, 157, 29);
		contentPane.add(rdbtnTeachingAssistant);
		
		JRadioButton rdbtnInstructor = new JRadioButton("Instructor");
		rdbtnInstructor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnInstructor.setBounds(443, 368, 157, 29);
		contentPane.add(rdbtnInstructor);
		
		JLabel inputError = new JLabel("");
		inputError.setForeground(new Color(255, 0, 0));
		inputError.setBackground(new Color(255, 0, 0));
		inputError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		inputError.setBounds(179, 533, 187, 26);
		contentPane.add(inputError);
		
		JButton button = new JButton("Go Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				form = new LoginForm();
				form.setVisible(true);
				}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(416, 23, 157, 35);
		contentPane.add(button);
		
		ArrayList arr = tool.getDepartment();
		String [] departments = new String[arr.size()];
		for (int x = 0; x < departments.length; x++){
			departments[x] = (String) arr.get(x);
		}
		
		JComboBox comboDepartment = new JComboBox();
		comboDepartment.setModel(new DefaultComboBoxModel(departments));
		comboDepartment.setBounds(180, 331, 186, 26);
		contentPane.add(comboDepartment);
		
		JButton btnNewButton = new JButton("Add Staff");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Error Handlers 
				// If the user does not enter a first or last name
				if((firstName.getText().isEmpty()) || (lastName.getText().isEmpty())){
					inputError.setText("Please Enter Your Full Name");
				}
				//If the email address is not valid
				else if(userEmail.getText().isEmpty() || (!userEmail.getText().contains("@"))){
					inputError.setText("Please enter Valid Email");
				}
				//if the user does not select a type of staff
				else if((!rdbtnDH.isSelected()) && (!rdbtnInstructor.isSelected()) && (!rdbtnTeachingAssistant.isSelected())){
					inputError.setText("Please select the type of staff");
				}
				//if the user enters a blank user name
				else if(userID.getText().isEmpty()){
					inputError.setText("Please enter a valid username");
				}
				//if the user enters a user name that is already taken
				else if(tool.userFound(userID.getText())){
					inputError.setText("User name is already taken");
				}
				// if the password entered is empty
				else if(passWord.getText().isEmpty()){
					inputError.setText("Please enter valid password");
				}
				//if the passwords don't match
				else if(!passWord.getText().equals(confirmPass.getText())){
					inputError.setText("Passwords do not match");
				}
				//write to the database if no errors
				else{
					// if the user is a department head
					if(rdbtnDH.isSelected()){
						tool.writeToUser(userID.getText(), passWord.getText(), firstName.getText(), lastName.getText(), userEmail.getText(), 
								mailingAddress.getText(), (String)comboDepartment.getSelectedItem(), "Department Head", phoneNumber.getText());
						setVisible(false);
						form = new LoginForm();
						form.setVisible(true);
					}
					// if the user is an instructor
					else if(rdbtnInstructor.isSelected()){
						tool.writeToUser(userID.getText(), passWord.getText(), firstName.getText(), lastName.getText(), userEmail.getText(), 
								mailingAddress.getText(), (String)comboDepartment.getSelectedItem(), "Instructor", phoneNumber.getText());
						setVisible(false);
						form = new LoginForm();
						form.setVisible(true);
					}
					// if the user is a Teaching Assistant
					else{
						tool.writeToUser(userID.getText(), passWord.getText(), firstName.getText(), lastName.getText(), userEmail.getText(), 
								mailingAddress.getText(), (String)comboDepartment.getSelectedItem(), "Teaching Assistant", phoneNumber.getText());
						setVisible(false);
						form = new LoginForm();
						form.setVisible(true);
					}
				}
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(404, 536, 157, 39);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		
		
	}
}

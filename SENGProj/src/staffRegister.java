// imported libraries
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
import java.awt.event.ActionEvent;

public class staffRegister extends JFrame {
	// class attributes
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField userID;
	private JTextField passWord;
	private JTextField confirmPass;
	private LoginForm form;
	private RWTools tool = new RWTools();

	/**
	 * main function: launch the application.
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
	 * staffRegister constructor that creates the frame and adds all components to it
	 */
	public staffRegister() {
		// closes window when the user exits the frame 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// create the window and set bounds
		setBounds(100, 100, 599, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Staff registration form label created and added to pane
		JLabel lblNewLabel = new JLabel("Staff Registration Form");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(204, 101, 230, 26);
		contentPane.add(lblNewLabel);
		
		// First name label created and added to pane 
		JLabel fNamelbl = new JLabel("First Name");
		fNamelbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		fNamelbl.setBounds(21, 135, 111, 26);
		contentPane.add(fNamelbl);
		
		// Last name label created and added to pane
		JLabel lNamelbl = new JLabel("Last Name");
		lNamelbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lNamelbl.setBounds(21, 176, 111, 26);
		contentPane.add(lNamelbl);
		
		// Phone number label created and added to pane
		JLabel phoneLbl = new JLabel("Phone Number");
		phoneLbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		phoneLbl.setBounds(21, 212, 136, 26);
		contentPane.add(phoneLbl);
		
		// Email address label created and added to pane 
		JLabel emailAddlbl = new JLabel("Email Address");
		emailAddlbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		emailAddlbl.setBounds(21, 255, 124, 26);
		contentPane.add(emailAddlbl);
		
		// Mailing address label created and added to pane
		JLabel mailingLbl = new JLabel("Mailing Address");
		mailingLbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		mailingLbl.setBounds(21, 293, 149, 26);
		contentPane.add(mailingLbl);
		
		// Department label created and added to pane 
		JLabel dptLbl = new JLabel("Department");
		dptLbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		dptLbl.setBounds(21, 332, 149, 26);
		contentPane.add(dptLbl);
		
		// Staff label created and added to pane
		JLabel stfTypelbl = new JLabel("Staff Type");
		stfTypelbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		stfTypelbl.setBounds(21, 373, 149, 26);
		contentPane.add(stfTypelbl);
		
		// User ID label created and added to pane 
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblUserId.setBounds(21, 410, 149, 26);
		contentPane.add(lblUserId);
		
		// Password label created and added to pane
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblPassword.setBounds(21, 449, 149, 26);
		contentPane.add(lblPassword);
		
		// Confirm password label created and added to pane
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblConfirmPassword.setBounds(21, 493, 149, 26);
		contentPane.add(lblConfirmPassword);
		
		// first name text field for user input
		firstName = new JTextField();
		firstName.setBounds(180, 134, 186, 26);
		contentPane.add(firstName);
		firstName.setColumns(10);

		// last name text field for user input		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(180, 176, 186, 26);
		contentPane.add(lastName);
		
		// phone number text field for user input
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(178, 212, 186, 26);
		contentPane.add(textField_2);
		
		// email address text field for user input
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(180, 248, 186, 26);
		contentPane.add(textField_3);
		
		// mailing address text field for user input
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(180, 286, 356, 26);
		contentPane.add(textField_4);
		
		// department text field for user input
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(180, 325, 356, 26);
		contentPane.add(textField_5);
		
		// user id text field for user input 
		userID = new JTextField();
		userID.setColumns(10);
		userID.setBounds(180, 403, 186, 26);
		contentPane.add(userID);
		
		// password text field for user input
		passWord = new JTextField();
		passWord.setColumns(10);
		passWord.setBounds(180, 442, 186, 26);
		contentPane.add(passWord);
		
		// confirm password text field for user input 
		confirmPass = new JTextField();
		confirmPass.setColumns(10);
		confirmPass.setBounds(180, 486, 186, 26);
		contentPane.add(confirmPass);
		
		// radio buttons that are for staff type 
		// department head implementation
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Department Head");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(128, 368, 136, 30);
		contentPane.add(rdbtnNewRadioButton);
		
		// teaching assistant implementation
		JRadioButton rdbtnTeachingAssistant = new JRadioButton("Teaching Assistant");
		rdbtnTeachingAssistant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnTeachingAssistant.setBounds(290, 368, 157, 29);
		contentPane.add(rdbtnTeachingAssistant);
		
		// instructor implementation
		JRadioButton rdbtnInstructor = new JRadioButton("Instructor");
		rdbtnInstructor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnInstructor.setBounds(443, 368, 157, 29);
		contentPane.add(rdbtnInstructor);
		
		// password verification label created and added to pane
		JLabel passError = new JLabel("");
		passError.setForeground(new Color(255, 0, 0));
		passError.setBackground(new Color(255, 0, 0));
		passError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passError.setBounds(387, 442, 174, 26);
		contentPane.add(passError);
		
		// confirm error label created and added to pane
		JLabel confirmError = new JLabel("");
		confirmError.setForeground(new Color(255, 0, 0));
		confirmError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		confirmError.setBackground(Color.RED);
		confirmError.setBounds(387, 486, 186, 26);
		contentPane.add(confirmError);
		
		// go back button that lets the user go back to the main login screen
		JButton button = new JButton("Go Back");
		// event hangler that executes login form if the button is pressed 
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				form = new LoginForm();
				form.setVisible(true);
				}
		});
		// set button appearance and add it to pane
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(416, 23, 157, 35);
		contentPane.add(button);
		
		// add staff button that saves user entry and error checks before writing it to staffDB.txt
		JButton btnNewButton = new JButton("Add Staff");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// checks if passwords match
				if(!passWord.getText().equals(confirmPass.getText())){
					passError.setText("Passwords do not match");
					confirmError.setText("Passwords do not match");
				}
				// checks if password field is empty
				if(passWord.getText().isEmpty()){
					passError.setText("Please enter valid password");
				}
				// valid entry by user, information is added to the staffDb.txt
				else {
				tool.writeToUser(userID.getText(), passWord.getText(), firstName.getText(), lastName.getText());
				setVisible(false);
				form = new LoginForm();
				form.setVisible(true);
				}
			}
		});
		// set button appearance and add it to pane 
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		btnNewButton.setBounds(404, 536, 157, 39);
		contentPane.add(btnNewButton);
		
		
	}
}

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
	private JTextField textField_2;
	private JTextField userEmail;
	private JTextField textField_4;
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(178, 212, 186, 26);
		contentPane.add(textField_2);
		
		userEmail = new JTextField();
		userEmail.setColumns(10);
		userEmail.setBounds(180, 248, 186, 26);
		contentPane.add(userEmail);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(180, 286, 356, 26);
		contentPane.add(textField_4);
		
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
		
		JLabel passError = new JLabel("");
		passError.setForeground(new Color(255, 0, 0));
		passError.setBackground(new Color(255, 0, 0));
		passError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passError.setBounds(387, 442, 174, 26);
		contentPane.add(passError);
		
		JLabel confirmError = new JLabel("");
		confirmError.setForeground(new Color(255, 0, 0));
		confirmError.setFont(new Font("Tahoma", Font.PLAIN, 13));
		confirmError.setBackground(Color.RED);
		confirmError.setBounds(387, 486, 186, 26);
		contentPane.add(confirmError);
		
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
		
		JLabel lblNameError = new JLabel("");
		lblNameError.setForeground(Color.RED);
		lblNameError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNameError.setBounds(416, 148, 145, 26);
		contentPane.add(lblNameError);
		
		JLabel labelEmailError = new JLabel("");
		labelEmailError.setForeground(Color.RED);
		labelEmailError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		labelEmailError.setBounds(416, 248, 145, 26);
		contentPane.add(labelEmailError);
		
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
				if((firstName.getText().isEmpty()) || (lastName.getText().isEmpty())){
					lblNameError.setText("Please Enter Your Full Name");
				}
				else if(userEmail.getText().isEmpty() || (!userEmail.getText().contains("@"))){
					labelEmailError.setText("Please enter Valid Email");
				}
				else if(passWord.getText().isEmpty()){
					passError.setText("Please enter valid password");
				}
				else if(!passWord.getText().equals(confirmPass.getText())){
					passError.setText("Passwords do not match");
					confirmError.setText("Passwords do not match");
				}
				else{
				tool.writeToUser(userID.getText(), passWord.getText(), firstName.getText(), lastName.getText());
				setVisible(false);
				form = new LoginForm();
				form.setVisible(true);
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

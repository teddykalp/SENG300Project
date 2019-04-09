// Import libraries 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;

/**
* Login Form to authenticate staff users to access software
* @author	Teddy Kalp
* @version	1.0
*/

public class LoginForm extends JFrame{

	private JFrame frame;
	private JTextField userID;
	private JPasswordField passWord;
	private JLabel loginError = new JLabel("");
	private String user = "Bob";
	private String pass = "password";
	private staffRegister staff;
	private CourseCalendar courseCal;
	private RWTools tool = new RWTools();
	

	/**
	 * main function: launches the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm form = new LoginForm();
					form.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * LoginForm constructor
	 */
	public LoginForm() {
		initialize();
	}

	/**
	 * Initializes, creates the frame and adds LoginForm components.
	 */
	private void initialize() {
		
		// error label attributes
		loginError.setForeground(Color.RED);
		loginError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		loginError.setBounds(237, 218, 227, 32);
		getContentPane().add(loginError);
		
		// window frame attributes
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 628, 560);
		// Closes window when the user exits the frame
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		// user ID text field for input
		userID = new JTextField();
		userID.setBounds(256, 127, 133, 28);
		userID.setColumns(10);
		
		// label attributes for user ID
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setBounds(110, 127, 36, 28);
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		// label attributes for password
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(102, 183, 56, 27);
		lblPassword.setFont(new Font("Comic Sans", Font.PLAIN, 12));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 623, 61);
		panel.setBackground(Color.RED);
		
		// Login button
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(272, 260, 102, 37);
		loginBtn.setForeground(Color.BLACK);
		loginBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		loginBtn.setBackground(new Color(255, 204, 204));
		loginBtn.addActionListener(new ActionListener() {
			/**
			* actionListener for Login button
			* @param	ActionEvent when login button is clicked
			* @return	N/A
			*/
			public void actionPerformed(ActionEvent arg0) {
				String pass = new String(passWord.getPassword());
				// Error handling for empty input user ID
				if (userID.getText().isEmpty()){
					loginError.setText("Please enter username/password");
				}
				// Error handling for empty input password
				if (pass.isEmpty()){
					loginError.setText("Please enter username/password");
				}
				// When user is authenticated they get acccess to main menu page
				if (tool.verifyUser(userID.getText(), pass)){
					setVisible(false);
					mainMenuForm menu = new mainMenuForm(userID.getText());
					menu.setVisible(true);
				}
				// Handling for invalid user input
				else{
					loginError.setText("Invalid username or password");
				}
			}
		});
		
		// Password input field attributes 
		passWord = new JPasswordField();
		passWord.setBounds(256, 179, 133, 27);
		
		// When "New Faculty" button is pressed, sends user to staff registration form
		JButton facultyBtn = new JButton("New Faculty?");
		facultyBtn.setBounds(110, 312, 145, 29);
		facultyBtn.setForeground(Color.BLACK);
		facultyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				staff = new staffRegister();
				staff.setVisible(true);
			}
		});
		facultyBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		facultyBtn.setBackground(new Color(255, 204, 204));
		
		// Button for student users
		JButton studentBtn = new JButton("Student?");
		studentBtn.setBounds(409, 312, 117, 29);
		studentBtn.setForeground(Color.BLACK);
		studentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				courseCal = new CourseCalendar();
				courseCal.setVisible(true);
			}
		});
		studentBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		studentBtn.setBackground(new Color(255, 204, 204));
		
		
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter your UserID and Password");
		lblPleaseEnterYour.setBounds(186, 85, 250, 18);
		lblPleaseEnterYour.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("University Of Winnipeg");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Gabriola", Font.PLAIN, 42));
		getContentPane().add(panel);
		getContentPane().add(lblUserid);
		getContentPane().add(lblPassword);
		getContentPane().add(userID);
		getContentPane().add(passWord);
		getContentPane().add(loginBtn);
		getContentPane().add(facultyBtn);
		getContentPane().add(studentBtn);
		getContentPane().add(lblPleaseEnterYour);
		
		
		
	}
}

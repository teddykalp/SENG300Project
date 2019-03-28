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


public class LoginForm extends JFrame{

	private JFrame frame;
	private JTextField userID;
	private JPasswordField passWord;
	private JLabel loginError = new JLabel("");
	private String user = "Bob";
	private String pass = "password";
	private staffRegister staff;
	private RWTools tool = new RWTools();
	

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		
		loginError.setForeground(Color.RED);
		loginError.setFont(new Font("Tahoma", Font.PLAIN, 11));
		loginError.setBounds(220, 217, 250, 32);
		getContentPane().add(loginError);
		
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 628, 560);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		userID = new JTextField();
		userID.setBounds(256, 127, 133, 28);
		userID.setColumns(10);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setBounds(110, 127, 36, 28);
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(102, 183, 56, 27);
		lblPassword.setFont(new Font("Comic Sans", Font.PLAIN, 12));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 623, 61);
		panel.setBackground(Color.RED);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(272, 260, 102, 37);
		loginBtn.setForeground(Color.BLACK);
		loginBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		loginBtn.setBackground(new Color(255, 204, 204));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String entry = new String(passWord.getPassword());
				if (userID.getText().isEmpty()){
					loginError.setText("Please enter valid username/password");
				}
				if (entry.isEmpty()){
					loginError.setText("Please enter valid username/password");
				}
				if (tool.verifyUser(userID.getText(), entry)){
					setVisible(false);
					mainMenuForm menu = new mainMenuForm(userID.getText());
					menu.setVisible(true);
				}
			}
		});
		
		passWord = new JPasswordField();
		passWord.setBounds(256, 179, 133, 27);
		
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
		
		JButton studentBtn = new JButton("Student?");
		studentBtn.setBounds(409, 312, 117, 29);
		studentBtn.setForeground(Color.BLACK);
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

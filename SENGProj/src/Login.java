import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login {

	private JFrame frame;
	private JTextField userID;
	private JTextField passWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 621, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Welcome = new JLabel("University of Winnipeg");
		Welcome.setBounds(188, 21, 225, 26);
		frame.getContentPane().add(Welcome);
		
		JLabel userLabel = new JLabel("UserID");
		userLabel.setBounds(104, 117, 92, 26);
		frame.getContentPane().add(userLabel);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(104, 179, 92, 26);
		frame.getContentPane().add(passLabel);
		
		userID = new JTextField();
		userID.setBounds(227, 114, 186, 32);
		frame.getContentPane().add(userID);
		userID.setColumns(10);
		
		passWord = new JTextField();
		passWord.setColumns(10);
		passWord.setBounds(227, 176, 186, 32);
		frame.getContentPane().add(passWord);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(237, 229, 141, 35);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewStaff = new JButton("Register as Staff Member");
		btnNewStaff.setBounds(56, 305, 211, 35);
		frame.getContentPane().add(btnNewStaff);
		
		JButton btnNewButton = new JButton("Students");
		btnNewButton.setBounds(407, 305, 141, 35);
		frame.getContentPane().add(btnNewButton);
	}
}

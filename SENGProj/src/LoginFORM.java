import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
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


public class LoginFORM {

	private JFrame frame;
	private JTextField userID;
	private JPasswordField passWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFORM window = new LoginFORM();
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
	public LoginFORM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 640, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
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
		loginBtn.setBounds(287, 224, 71, 37);
		loginBtn.setForeground(Color.BLACK);
		loginBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		loginBtn.setBackground(new Color(255, 204, 204));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		passWord = new JPasswordField();
		passWord.setBounds(256, 179, 133, 27);
		
		JButton facultyBtn = new JButton("New Faculty?");
		facultyBtn.setBounds(131, 330, 125, 29);
		facultyBtn.setForeground(Color.BLACK);
		facultyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		facultyBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		facultyBtn.setBackground(new Color(255, 204, 204));
		
		JButton studentBtn = new JButton("Student?");
		studentBtn.setBounds(401, 330, 95, 29);
		studentBtn.setForeground(Color.BLACK);
		studentBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		studentBtn.setBackground(new Color(255, 204, 204));
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter your UserID and Password");
		lblPleaseEnterYour.setBounds(186, 85, 250, 18);
		lblPleaseEnterYour.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("University Of Winnipeg");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Gabriola", Font.PLAIN, 42));
		frame.getContentPane().add(panel);
		frame.getContentPane().add(lblUserid);
		frame.getContentPane().add(lblPassword);
		frame.getContentPane().add(userID);
		frame.getContentPane().add(passWord);
		frame.getContentPane().add(loginBtn);
		frame.getContentPane().add(facultyBtn);
		frame.getContentPane().add(studentBtn);
		frame.getContentPane().add(lblPleaseEnterYour);
	}
}

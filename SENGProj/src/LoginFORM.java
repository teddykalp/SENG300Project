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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

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
		userID.setColumns(10);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Comic Sans", Font.PLAIN, 12));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setForeground(Color.BLACK);
		loginBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		loginBtn.setBackground(new Color(255, 204, 204));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		passWord = new JPasswordField();
		
		JButton facultyBtn = new JButton("New Faculty?");
		facultyBtn.setForeground(Color.BLACK);
		facultyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		facultyBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		facultyBtn.setBackground(new Color(255, 204, 204));
		
		JButton studentBtn = new JButton("Student?");
		studentBtn.setForeground(Color.BLACK);
		studentBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		studentBtn.setBackground(new Color(255, 204, 204));
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter your UserID and Password");
		lblPleaseEnterYour.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("256px"),
				ColumnSpec.decode("133px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("222px"),},
			new RowSpec[] {
				RowSpec.decode("61px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("18px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("28px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("27px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("37px"),
				RowSpec.decode("69px"),
				RowSpec.decode("29px"),}));
		
		JLabel lblNewLabel = new JLabel("University Of Winnipeg");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Gabriola", Font.PLAIN, 42));
		frame.getContentPane().add(panel, "1, 1, 4, 1, fill, fill");
		frame.getContentPane().add(lblUserid, "1, 5, center, fill");
		frame.getContentPane().add(lblPassword, "1, 7, center, fill");
		frame.getContentPane().add(userID, "2, 5, fill, fill");
		frame.getContentPane().add(passWord, "2, 7, fill, fill");
		frame.getContentPane().add(loginBtn, "2, 9, center, fill");
		frame.getContentPane().add(facultyBtn, "1, 11, right, top");
		frame.getContentPane().add(studentBtn, "4, 11, left, top");
		frame.getContentPane().add(lblPleaseEnterYour, "1, 3, 4, 1, center, top");
	}
}

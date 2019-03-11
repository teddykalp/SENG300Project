import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JPanel;



public class mainMenuForm extends JFrame {

	private LoginForm login;
	private AddProgram programAdd;
	private AddCourse courseAdd;
	private String user;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenuForm menu = new mainMenuForm("Teddy");
					menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainMenuForm(String user) {
		getContentPane().setForeground(Color.GRAY);
		getContentPane().setBackground(new Color(102, 102, 102));
		setUser(user);
		initialize();
		
	}

	/**
	 * Initialize the contents of the 
	 */
	public void setUser(String user){
		this.user = user;
	}
	
	
	private void initialize() {
		setTitle("Program");
		setBounds(100, 100, 637, 646);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		
		JLabel lblWhichActionWould = new JLabel("Which Action Would you like to perform?");
		lblWhichActionWould.setBackground(Color.RED);
		lblWhichActionWould.setForeground(Color.PINK);
		lblWhichActionWould.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 18));
		lblWhichActionWould.setBounds(87, 64, 446, 26);
		getContentPane().add(lblWhichActionWould);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setForeground(Color.RED);
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				courseAdd = new AddCourse(user);
				courseAdd.setVisible(true);
			}
		});
		btnAddCourse.setBackground(Color.WHITE);
		btnAddCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddCourse.setBounds(217, 119, 141, 35);
		getContentPane().add(btnAddCourse);
		
		JButton btnEditCourse = new JButton("Edit Course");
		btnEditCourse.setForeground(Color.WHITE);
		btnEditCourse.setBackground(Color.RED);
		btnEditCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditCourse.setBounds(217, 183, 141, 35);
		getContentPane().add(btnEditCourse);
		
		JButton btnViewDepartment = new JButton("View Department");
		btnViewDepartment.setForeground(Color.WHITE);
		btnViewDepartment.setBackground(Color.RED);
		btnViewDepartment.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnViewDepartment.setBounds(395, 246, 161, 32);
		getContentPane().add(btnViewDepartment);
		
		JButton btnViewProgram = new JButton("View Program");
		btnViewProgram.setForeground(Color.WHITE);
		btnViewProgram.setBackground(Color.RED);
		btnViewProgram.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewProgram.setBounds(35, 244, 141, 35);
		getContentPane().add(btnViewProgram);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login = new LoginForm();
				login.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnLogout.setBackground(Color.PINK);
		btnLogout.setBounds(217, 375, 141, 35);
		getContentPane().add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		Image img = new ImageIcon(this.getClass().getResource("/passion-bug.jpg")).getImage();
		img = img.getScaledInstance(180, 170, 0);
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(395, 415, 192, 131);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add Program");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				programAdd = new AddProgram(user);
				programAdd.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(35, 119, 141, 35);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Department");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(395, 122, 161, 32);
		getContentPane().add(btnNewButton_1);
		
		JButton btnEditProgram = new JButton("Edit Program");
		btnEditProgram.setForeground(Color.RED);
		btnEditProgram.setBackground(Color.WHITE);
		btnEditProgram.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditProgram.setBounds(35, 183, 141, 35);
		getContentPane().add(btnEditProgram);
		
		JButton btnEditDepartment = new JButton("Edit Department");
		btnEditDepartment.setForeground(Color.RED);
		btnEditDepartment.setBackground(Color.WHITE);
		btnEditDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditDepartment.setBounds(395, 181, 161, 32);
		getContentPane().add(btnEditDepartment);
		
		JLabel label_1 = new JLabel(" ");
		Image img1 = new ImageIcon(this.getClass().getResource("/UW-logo.png")).getImage();
		img1 = img1.getScaledInstance(210, 80, 0);
		label_1.setIcon(new ImageIcon(img1));
		label_1.setBounds(10, 428, 268, 126);
		getContentPane().add(label_1);
		
		JLabel lblNewLabel = new JLabel("Welcome " + this.user);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 0, 141, 26);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 54, 611, 44);
		getContentPane().add(panel);
	}
}

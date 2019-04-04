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
import javax.swing.UIManager;



public class MainMenu extends JFrame {

	private LoginForm login;
	private AddProgram programAdd;
	private AddCourse courseAdd;
	private String user;
	private courseDisplay courseMenu;
	private departmentDisplay viewDepartment;
	private CourseCalendar courseCalendar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu menu = new MainMenu("Teddy");
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
	public MainMenu(String user) {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		getContentPane().setForeground(Color.GRAY);
		getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
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
		setBounds(100, 100, 586, 405);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		// main header display
		JLabel lblMessage = new JLabel("Which action would you like to perform?");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBackground(Color.RED);
		lblMessage.setForeground(new Color(255, 0, 0));
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMessage.setBounds(6, 64, 574, 26);
		getContentPane().add(lblMessage);
		
		// add course button and functionality
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setForeground(new Color(0, 0, 0));
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				courseAdd = new AddCourse(user);
				courseAdd.setVisible(true);
			}
		});
		btnAddCourse.setBackground(Color.WHITE);
		btnAddCourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddCourse.setBounds(222, 179, 141, 35);
		getContentPane().add(btnAddCourse);
		
		// edit course button and functionality
		JButton btnEditCourse = new JButton("Edit Course");
		btnEditCourse.setForeground(new Color(0, 0, 0));
		btnEditCourse.setBackground(new Color(255, 255, 255));
		btnEditCourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditCourse.setBounds(222, 243, 141, 35);
		getContentPane().add(btnEditCourse);

		// view course button and functionality
		JButton bttnViewCourse = new JButton("View Course");
		bttnViewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				courseCalendar = new CourseCalendar();
				courseCalendar.setVisible(true);
			}
		});
		bttnViewCourse.setForeground(new Color(0, 0, 0));
		bttnViewCourse.setBackground(new Color(255, 255, 255));
		bttnViewCourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bttnViewCourse.setBounds(222, 304, 141, 35);
		getContentPane().add(bttnViewCourse);		
		
		
		// view department button and functionality
		JButton btnViewDepartment = new JButton("View Department");
		btnViewDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				viewDepartment = new departmentDisplay(user);
				viewDepartment.setVisible(true);
			}
		});
		btnViewDepartment.setForeground(new Color(0, 0, 0));
		btnViewDepartment.setBackground(new Color(255, 255, 255));
		btnViewDepartment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewDepartment.setBounds(403, 304, 141, 35);
		getContentPane().add(btnViewDepartment);
		
		// view program button and functionality
		JButton btnViewProgram = new JButton("View Program");
		btnViewProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				courseMenu = new courseDisplay(user);
				courseMenu.setVisible(true);
				
			}
		});
		btnViewProgram.setForeground(new Color(0, 0, 0));
		btnViewProgram.setBackground(new Color(255, 255, 255));
		btnViewProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewProgram.setBounds(37, 304, 141, 35);
		getContentPane().add(btnViewProgram);
		
		// logout button and functionality
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login = new LoginForm();
				login.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogout.setBackground(UIManager.getColor("CheckBox.background"));
		btnLogout.setBounds(496, 6, 73, 35);
		getContentPane().add(btnLogout);
		
		// add graphic
		JLabel lblNewLabel_1 = new JLabel(" ");
//		Image img = new ImageIcon(this.getClass().getResource("/passion-bug.jpg")).getImage();
//		img = img.getScaledInstance(180, 170, 0);
//		lblNewLabel_1.setIcon(new ImageIcon(img));
//		lblNewLabel_1.setBounds(395, 415, 192, 131);
//		getContentPane().add(lblNewLabel_1);
		
		// add program button and functionality
		JButton btnNewButton = new JButton("Add Program");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				programAdd = new AddProgram(user);
				programAdd.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(37, 179, 141, 35);
		getContentPane().add(btnNewButton);
		
		// add department button and functionality
		JButton btnAddDepartment = new JButton("Add Department");
		btnAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				departForm depart = new departForm(user);
				depart.setVisible(true);
				
			}
		});
		btnAddDepartment.setForeground(new Color(0, 0, 0));
		btnAddDepartment.setBackground(new Color(255, 255, 255));
		btnAddDepartment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddDepartment.setBounds(403, 179, 141, 35);
		getContentPane().add(btnAddDepartment);
		
		// edit program button and functionality
		JButton btnEditProgram = new JButton("Edit Program");
		btnEditProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditProgram.setForeground(new Color(0, 0, 0));
		btnEditProgram.setBackground(Color.WHITE);
		btnEditProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditProgram.setBounds(37, 243, 141, 35);
		getContentPane().add(btnEditProgram);
		
		
		// edit department button and functionality
		JButton btnEditDepartment = new JButton("Edit Department");
		btnEditDepartment.setForeground(new Color(0, 0, 0));
		btnEditDepartment.setBackground(new Color(255, 250, 250));
		btnEditDepartment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditDepartment.setBounds(403, 243, 141, 35);
		getContentPane().add(btnEditDepartment);
		
		// welcome banner with logged in user 
		JLabel lblNewLabel = new JLabel("Welcome " + this.user);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(6, 9, 141, 26);
		getContentPane().add(lblNewLabel);
		
		// create panel 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(0, 54, 611, 44);
		getContentPane().add(panel);
		
		JLabel lblProgram = new JLabel("PROGRAM");
		lblProgram.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgram.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProgram.setBounds(37, 126, 141, 30);
		getContentPane().add(lblProgram);
		
		JLabel lblCourse = new JLabel("COURSE");
		lblCourse.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCourse.setBounds(222, 126, 141, 30);
		getContentPane().add(lblCourse);
		
		JLabel lblDepartment = new JLabel("DEPARTMENT");
		lblDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDepartment.setBounds(403, 124, 141, 35);
		getContentPane().add(lblDepartment);
	}
}

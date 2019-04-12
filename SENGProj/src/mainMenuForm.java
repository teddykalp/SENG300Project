// import libraries
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


// mainMenuForm displays all navigation buttons for the staff user 
public class mainMenuForm extends JFrame {
	// class attributes 
	private LoginForm login;
	private AddProgram programAdd;
	private AddCourse courseAdd;
	private String user;
	private courseDisplay courseMenu;
	private departmentDisplay viewDepartment;
	
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
		getContentPane().setBackground(new Color(224, 255, 255));
		setUser(user);
		initialize();
		
	}

	/**
	 * Initialize the contents of the 
	 */
	public void setUser(String user){
		this.user = user;
	}
	
	// initialize method sets up UI and has event handling for user activity 
	private void initialize() {
		setTitle("Program");
		setBounds(100, 100, 637, 646);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		// message label
		JLabel lblMessage = new JLabel("Which Action Would you like to perform?");
		lblMessage.setBackground(Color.RED);
		lblMessage.setForeground(new Color(255, 0, 0));
		lblMessage.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD, 18));
		lblMessage.setBounds(87, 64, 446, 26);
		getContentPane().add(lblMessage);
		
		// add course button that will take the user to the add course page if clicked 
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
		btnAddCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddCourse.setBounds(217, 119, 141, 35);
		getContentPane().add(btnAddCourse);
		
		// edit course button that will take the user to the edit course page if clicked 
		JButton btnEditCourse = new JButton("Edit Course");
		btnEditCourse.setForeground(Color.WHITE);
		btnEditCourse.setBackground(new Color(0, 0, 0));
		btnEditCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				editCourse edit = new editCourse(user);
				edit.setVisible(true);
			}
		});
		btnEditCourse.setBounds(217, 183, 141, 35);
		getContentPane().add(btnEditCourse);
		
		// view dept button that will take the user to the view dept page if clicked 
		JButton btnViewDepartment = new JButton("View Department");
		btnViewDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				viewDepartment = new departmentDisplay(user);
				viewDepartment.setVisible(true);
			}
		});
		btnViewDepartment.setForeground(Color.WHITE);
		btnViewDepartment.setBackground(new Color(0, 0, 0));
		btnViewDepartment.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnViewDepartment.setBounds(395, 246, 161, 32);
		getContentPane().add(btnViewDepartment);
		
		// view program button that will take the user to the view program page if selected 
		JButton btnViewProgram = new JButton("View Program");
		btnViewProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				programDisplay display = new programDisplay(user);
				display.setVisible(true);
				
			}
		});
		btnViewProgram.setForeground(Color.WHITE);
		btnViewProgram.setBackground(new Color(0, 0, 0));
		btnViewProgram.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewProgram.setBounds(35, 244, 141, 35);
		getContentPane().add(btnViewProgram);
		
		// logout button that exits the menu and takes the user to the login page 
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login = new LoginForm();
				login.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setBounds(217, 310, 141, 35);
		getContentPane().add(btnLogout);
		
		// label for passion bug img
		JLabel lblNewLabel_1 = new JLabel(" ");
		Image img = new ImageIcon(this.getClass().getResource("/passion-bug.jpg")).getImage();
		img = img.getScaledInstance(180, 170, 0);
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(395, 415, 192, 131);
		getContentPane().add(lblNewLabel_1);
		
		// add program button that takes the user to the add program page if clicked 
		JButton btnNewButton = new JButton("Add Program");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				programAdd = new AddProgram(user);
				programAdd.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(35, 119, 141, 35);
		getContentPane().add(btnNewButton);
		
		// add department button that takes the user to the add dept page if clicked 
		JButton btnNewButton_1 = new JButton("Add Department");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				departForm depart = new departForm(user);
				depart.setVisible(true);
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(395, 122, 161, 32);
		getContentPane().add(btnNewButton_1);
		
		// edit program button that takes the user to the edit program button if clicked
		JButton btnEditProgram = new JButton("Edit Program");
		btnEditProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				editProgram edit = new editProgram(user);
				edit.setVisible(true);
			}
		});
		btnEditProgram.setForeground(new Color(0, 0, 0));
		btnEditProgram.setBackground(Color.WHITE);
		btnEditProgram.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditProgram.setBounds(35, 183, 141, 35);
		getContentPane().add(btnEditProgram);
		
		// edit dept button that takes the user to the edit department page if clicked 
		JButton btnEditDepartment = new JButton("Edit Department");
		btnEditDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				editDepartment edit = new editDepartment(user);
				edit.setVisible(true);
			}
		});
		btnEditDepartment.setForeground(new Color(0, 0, 0));
		btnEditDepartment.setBackground(new Color(255, 250, 250));
		btnEditDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditDepartment.setBounds(395, 181, 161, 32);
		getContentPane().add(btnEditDepartment);
		
		// welcome label that is customized to user logged in
		JLabel lblNewLabel = new JLabel("Welcome " + this.user);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 0, 141, 26);
		getContentPane().add(lblNewLabel);
		
		// add panel to screen 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(0, 54, 611, 44);
		getContentPane().add(panel);
		
		// view course button that takes the user to the view course page if selected 
		JButton btnViewCourse = new JButton("View Course");
		btnViewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				courseMenu = new courseDisplay(user);
				courseMenu.setVisible(true);
			}
		});
		btnViewCourse.setForeground(Color.BLACK);
		btnViewCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnViewCourse.setBackground(Color.WHITE);
		btnViewCourse.setBounds(217, 242, 141, 35);
		getContentPane().add(btnViewCourse);
	}
}

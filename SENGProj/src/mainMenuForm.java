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

public class mainMenuForm extends JFrame {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenuForm menu = new mainMenuForm();
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
	public mainMenuForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		setBounds(100, 100, 613, 617);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel Welcome = new JLabel("Welcome User");
		Welcome.setForeground(Color.RED);
		Welcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		Welcome.setBounds(0, 0, 147, 26);
		getContentPane().add(Welcome);
		
		JLabel lblNewLabel = new JLabel("University of Winnipeg");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(366, -1, 239, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel lblWhichActionWould = new JLabel("Which Action Would you like to preform?");
		lblWhichActionWould.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWhichActionWould.setBounds(138, 61, 325, 26);
		getContentPane().add(lblWhichActionWould);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				AddCourse add = new AddCourse();
				add.setVisible(true);
			}
		});
		btnAddCourse.setBackground(Color.GREEN);
		btnAddCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddCourse.setBounds(217, 119, 141, 35);
		getContentPane().add(btnAddCourse);
		
		JButton btnEditCourse = new JButton("Edit Course");
		btnEditCourse.setBackground(Color.YELLOW);
		btnEditCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditCourse.setBounds(217, 183, 141, 35);
		getContentPane().add(btnEditCourse);
		
		JButton btnViewDepartment = new JButton("View Department");
		btnViewDepartment.setBackground(Color.MAGENTA);
		btnViewDepartment.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnViewDepartment.setBounds(395, 246, 161, 32);
		getContentPane().add(btnViewDepartment);
		
		JButton btnViewProgram = new JButton("View Program");
		btnViewProgram.setBackground(Color.MAGENTA);
		btnViewProgram.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewProgram.setBounds(35, 244, 141, 35);
		getContentPane().add(btnViewProgram);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.PINK);
		btnLogout.setBounds(217, 475, 141, 35);
		getContentPane().add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		Image img = new ImageIcon(this.getClass().getResource("/passion-bug.jpg")).getImage();
		img = img.getScaledInstance(150, 100, 0);
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(21, 391, 175, 119);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add Program");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(35, 121, 141, 35);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Department");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(395, 122, 161, 32);
		getContentPane().add(btnNewButton_1);
		
		JButton btnEditProgram = new JButton("Edit Program");
		btnEditProgram.setBackground(Color.YELLOW);
		btnEditProgram.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditProgram.setBounds(35, 183, 141, 35);
		getContentPane().add(btnEditProgram);
		
		JButton btnEditDepartment = new JButton("Edit Department");
		btnEditDepartment.setBackground(Color.YELLOW);
		btnEditDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditDepartment.setBounds(395, 181, 161, 32);
<<<<<<< Upstream, based on origin/master
		getContentPane().add(btnEditDepartment);
=======
		frame.getContentPane().add(btnEditDepartment);
		
		
>>>>>>> d3adc1c changes
	}

	
}

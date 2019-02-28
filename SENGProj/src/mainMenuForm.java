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

public class mainMenuForm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenuForm window = new mainMenuForm();
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
	public mainMenuForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 613, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Welcome = new JLabel("Welcome User");
		Welcome.setForeground(Color.RED);
		Welcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		Welcome.setBounds(0, 0, 147, 26);
		frame.getContentPane().add(Welcome);
		
		JLabel lblNewLabel = new JLabel("University of Winnipeg");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(366, -1, 239, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblWhichActionWould = new JLabel("Which Action Would you like to preform?");
		lblWhichActionWould.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWhichActionWould.setBounds(138, 61, 325, 26);
		frame.getContentPane().add(lblWhichActionWould);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				AddCourse add = new AddCourse();
				add.setVisible(true);
			}
		});
		btnAddCourse.setBackground(Color.GREEN);
		btnAddCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddCourse.setBounds(217, 119, 141, 35);
		frame.getContentPane().add(btnAddCourse);
		
		JButton btnEditCourse = new JButton("Edit Course");
		btnEditCourse.setBackground(Color.YELLOW);
		btnEditCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditCourse.setBounds(217, 197, 141, 35);
		frame.getContentPane().add(btnEditCourse);
		
		JButton btnViewDepartment = new JButton("View Department");
		btnViewDepartment.setBackground(Color.MAGENTA);
		btnViewDepartment.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnViewDepartment.setBounds(217, 342, 147, 35);
		frame.getContentPane().add(btnViewDepartment);
		
		JButton btnViewProgram = new JButton("View Program");
		btnViewProgram.setBackground(Color.ORANGE);
		btnViewProgram.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewProgram.setBounds(217, 271, 141, 35);
		frame.getContentPane().add(btnViewProgram);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.PINK);
		btnLogout.setBounds(217, 475, 141, 35);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		Image img = new ImageIcon(this.getClass().getResource("/passion-bug.jpg")).getImage();
		img = img.getScaledInstance(150, 100, 0);
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(21, 145, 175, 119);
		frame.getContentPane().add(lblNewLabel_1);
	}
}

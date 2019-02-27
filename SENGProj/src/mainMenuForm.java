import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		Welcome.setBounds(0, 0, 147, 26);
		frame.getContentPane().add(Welcome);
		
		JLabel lblNewLabel = new JLabel("University of Winnipeg");
		lblNewLabel.setBounds(443, 0, 239, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblWhichActionWould = new JLabel("Which Action Would you like to preform?");
		lblWhichActionWould.setBounds(162, 60, 307, 26);
		frame.getContentPane().add(lblWhichActionWould);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setBounds(217, 119, 141, 35);
		frame.getContentPane().add(btnAddCourse);
		
		JButton btnEditCourse = new JButton("Edit/Delete Course");
		btnEditCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEditCourse.setBounds(217, 197, 141, 35);
		frame.getContentPane().add(btnEditCourse);
		
		JButton btnViewDepartment = new JButton("View Department");
		btnViewDepartment.setBounds(217, 272, 141, 35);
		frame.getContentPane().add(btnViewDepartment);
		
		JButton btnViewProgram = new JButton("View Program");
		btnViewProgram.setBounds(217, 353, 141, 35);
		frame.getContentPane().add(btnViewProgram);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(217, 431, 141, 35);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel("Insert Meme Here");
		lblNewLabel_1.setBounds(21, 145, 175, 119);
		frame.getContentPane().add(lblNewLabel_1);
	}
}

// Import libraries
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
* departForm to show add department form to UI
* @author	Teddy Kalp, Angeli Manipon
* @version	1.0
*/
public class departForm extends JFrame {
	
	// Class attributes
	private JPanel contentPane;
	private JTextField departName;
	private JTextField departCode;
	private mainMenuForm menu;
	private String name;
	private RWTools tool = new RWTools();

	/**
	 * Launch the application.
	 */
	

	/**
	 * departForm constructor that creates the frame and adds its components.
	 * @param	user - staff user that is adding a course
	 */
	public departForm(String user) {
		
		this.name = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Department");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(455, 16, 231, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Department Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(250, 53, 225, 51);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDepartmentDescription = new JLabel("<html><p>Department Description<p><html>");
		lblDepartmentDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartmentDescription.setBounds(250, 120, 180, 26);
		contentPane.add(lblDepartmentDescription);
		
		JLabel lblDepartmentCode = new JLabel("Department Code");
		lblDepartmentCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartmentCode.setBounds(250, 234, 146, 35);
		contentPane.add(lblDepartmentCode);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 417, 131, 22);
		contentPane.add(label_2);
		
		JTextArea departDescription = new JTextArea();
		JScrollPane departDescScroll = new JScrollPane (departDescription, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		departDescScroll.setBounds(525, 126, 238, 84);
		departDescription.setLineWrap(true);
		departDescription.setBounds(196, 204, 267, 103);
		contentPane.add(departDescScroll);
		
		departName = new JTextField();
		departName.setBounds(525, 74, 200, 26);
		contentPane.add(departName);
		departName.setColumns(10);
	
		departCode = new JTextField();
		departCode.setBounds(525, 236, 146, 35);
		contentPane.add(departCode);
		departCode.setColumns(10);

		JLabel dError = new JLabel("");
		dError.setForeground(Color.RED);
		dError.setBounds(196, 405, 180, 15);
		dError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(dError);
		
		JButton addDepartmentBtn = new JButton("Add Department");
		addDepartmentBtn.setBackground(new Color(176, 196, 222));
		addDepartmentBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		addDepartmentBtn.setBounds(593, 384, 157, 48);
		addDepartmentBtn.addActionListener(new ActionListener() {
			/**
			* actionListener for Add Department button
			* @param	ActionEvent - when button is clicked
			* @return 	void
			*/
			public void actionPerformed(ActionEvent e) {
				// Error handling for empty input
				if (departName.getText().isEmpty() || departDescription.getText().isEmpty() 
						|| departCode.getText().isEmpty()){
					dError.setText("Please fill in any empty fields");
				}
				// Writes department info to departmentDB.txt
				else{
					
					tool.writeToDepartment(departName.getText(), departDescription.getText(), 
							departCode.getText());
					
					// returns user to main menu
					setVisible(false);
					menu = new mainMenuForm(user);
					menu.setVisible(true);
				}
				
			}
		});
		contentPane.add(addDepartmentBtn);
		
		// Go back button returns user to main menu
		JButton button = new JButton("Go Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				menu = new mainMenuForm(name);
				menu.setVisible(true);
				}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(250,384,163,48);
		contentPane.add(button);
		
		
		
	}
}

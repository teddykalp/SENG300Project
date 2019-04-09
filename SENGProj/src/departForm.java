// Import libraries
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
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
public class departForm extends JPanel {
	
	// Class attributes
	private JPanel contentPane;
	private JTextField departName;
	private JTextField departCode;
	private mainMenuForm menu;
	private String name;
	private RWTools tool = new RWTools();
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1; 
	private JLabel lblDepartmentDescription;
	private JLabel lblDepartmentCode;
	private JLabel label_2; 
	private JTextArea departDescription;
	private JLabel dError;
	private JButton btnNewButton;
	private JButton button;

	/**
	 * Launch the application.
	 */
	

	/**
	 * departForm constructor that creates the frame and adds its components.
	 * @param	user - staff user that is adding a course
	 */
	public departForm(JPanel panel) {
		
		JPanel p1 = new JPanel(null);
		p1.setPreferredSize(new Dimension(1000,1000));
		contentPane = panel;
		
		lblNewLabel = new JLabel("Register Department");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(209, 66, 190, 31);
		p1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Department Name");
		lblNewLabel_1.setFont(new Font("Noto Serif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 145, 131, 22);
		p1.add(lblNewLabel_1);
		
		lblDepartmentDescription = new JLabel("<html><p>Department Description<p><html>");
		lblDepartmentDescription.setFont(new Font("Noto Serif", Font.PLAIN, 14));
		lblDepartmentDescription.setBounds(10, 219, 131, 39);
		p1.add(lblDepartmentDescription);
		
		lblDepartmentCode = new JLabel("Department Code");
		lblDepartmentCode.setFont(new Font("Noto Serif", Font.PLAIN, 14));
		lblDepartmentCode.setBounds(10, 346, 131, 22);
		p1.add(lblDepartmentCode);
		
		label_2 = new JLabel("");
		label_2.setFont(new Font("Noto Serif", Font.PLAIN, 14));
		label_2.setBounds(10, 417, 131, 22);
		p1.add(label_2);
		
		departDescription = new JTextArea();
		departDescription.setLineWrap(true);
		departDescription.setBounds(196, 204, 267, 103);
		p1.add(departDescription);
		
		departName = new JTextField();
		departName.setBounds(192, 147, 271, 20);
		p1.add(departName);
		departName.setColumns(10);
	
		departCode = new JTextField();
		departCode.setBounds(196, 348, 267, 20);
		p1.add(departCode);
		departCode.setColumns(10);

		dError = new JLabel("");
		dError.setForeground(Color.RED);
		dError.setBounds(196, 405, 180, 15);
		dError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		p1.add(dError);
		
		btnNewButton = new JButton("Add Department");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(439, 408, 156, 31);
		btnNewButton.addActionListener(new ActionListener() {
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
					
				}
				
			}
		});
		p1.add(btnNewButton);
		
		// Go back button returns user to main menu
	    button = new JButton("Go Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(Color.DARK_GRAY);
		button.setBounds(458, 21, 157, 35);
		p1.add(button);
		
		contentPane.add(p1);
		add(p1);
		
	}
}

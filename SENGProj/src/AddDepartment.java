// Import libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;

/**
* departForm to show add department form to UI
* @author	Teddy Kalp, Angeli Manipon
* @version	1.0
*/
public class AddDepartment extends JPanel {
	
	// Class attributes
	private JPanel contentPane;
	private JTextField departName;
	private JTextField departCode;
	
	private String name;
	private RWTools tool = new RWTools();
	
	private JLabel NRLabel;
	private JLabel DPLabel; 
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
	    ImageLibrary img = new ImageLibrary();

	/**
	 * departForm constructor that creates the frame and adds its components.
	 * @param	user - staff user that is adding a course
	 */
	public AddDepartment(JPanel panel) {
		
		JPanel p1 = new JPanel(null);
		p1.setPreferredSize(new Dimension(1000,1000));
		contentPane = panel;
		
		  //IMG
                JPanel editdbg = new JPanel();
                ImageIcon pic = img.editdbg;
                editdbg.setSize(1000,1000);
                editdbg.add(new JLabel(pic));
                editdbg.setEnabled(true);
                editdbg.setVisible(true);  
                
		// Labels for users specifying data that needs to be entered into fields
		// for department 
		NRLabel = new JLabel("Add a New Department");
		NRLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		NRLabel.setForeground(Color.WHITE);
		NRLabel.setBounds(410, 50, 500,50);
		p1.add(NRLabel);
		JLabel lblNewLabel = new JLabel("What Department would you like to add?");
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                lblNewLabel.setForeground(Color.WHITE);
                lblNewLabel.setBounds(300, 100, 500, 26);
                p1.add(lblNewLabel);
		
		DPLabel= new JLabel("Department Name");
		DPLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		DPLabel.setBounds(300, 150, 131, 22);
		p1.add(DPLabel);
		
		lblDepartmentDescription = new JLabel("<html><p>Department Description<p><html>");
		lblDepartmentDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDepartmentDescription.setBounds(300, 200, 131, 39);
		p1.add(lblDepartmentDescription);
		
		lblDepartmentCode = new JLabel("Department Code");
		lblDepartmentCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDepartmentCode.setBounds(300, 350, 131, 22);
		p1.add(lblDepartmentCode);
		
		departDescription = new JTextArea();
		departDescription.setLineWrap(true);
		departDescription.setBounds(500, 200, 267, 103);
		p1.add(departDescription);
		
		
		departName = new JTextField();
		departName.setBounds(500, 150, 271, 20);
		p1.add(departName);
		
	
		departCode = new JTextField();
		departCode.setBounds(500, 350, 267, 20);
		p1.add(departCode);
		departCode.setColumns(10);

		dError = new JLabel("");
		dError.setForeground(Color.RED);
		dError.setBounds(600, 400, 180, 15);
		dError.setFont(new Font("Tahoma", Font.BOLD, 10));
		p1.add(dError);
		
		// button that adds new department information to the department DB
		btnNewButton = new JButton("Add Department");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(500, 400, 200, 50);
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
					CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                                        cardLayout.show(contentPane, "mmf");
                                        departDescription.setText(" ");
                                        departName.setText("");
                                        departCode.setText("");
					
				}
				
			}
		});
		p1.add(btnNewButton);
		
		// Go back button returns user to main menu
	    button = new JButton("Go Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                                cardLayout.show(contentPane, "mmf");
                                departDescription.setText(" ");
                                departName.setText("");
                                departCode.setText("");
				}
		});
	
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		button.setBounds(850, 10, 100, 25);
        
		// add button to pane
		p1.add(button);
		p1.add(editdbg);
		contentPane.add(p1);
		add(p1);
		
	}
}

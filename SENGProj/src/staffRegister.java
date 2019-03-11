import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class staffRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffRegister frame = new staffRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public staffRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel(" ");
		label.setBounds(163, 10, 258, 103);
		Image img1 = new ImageIcon(this.getClass().getResource("/UW-logo.png")).getImage();
		img1 = img1.getScaledInstance(210, 80, 0);
		label.setIcon(new ImageIcon(img1));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Staff Registration Form");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(204, 101, 230, 26);
		contentPane.add(lblNewLabel);
		
		JLabel fNamelbl = new JLabel("First Name");
		fNamelbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		fNamelbl.setBounds(21, 135, 111, 26);
		contentPane.add(fNamelbl);
		
		JLabel lNamelbl = new JLabel("Last Name");
		lNamelbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lNamelbl.setBounds(21, 176, 111, 26);
		contentPane.add(lNamelbl);
		
		JLabel phoneLbl = new JLabel("Phone Number");
		phoneLbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		phoneLbl.setBounds(21, 212, 136, 26);
		contentPane.add(phoneLbl);
		
		JLabel emailAddlbl = new JLabel("Email Address");
		emailAddlbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		emailAddlbl.setBounds(21, 255, 124, 26);
		contentPane.add(emailAddlbl);
		
		JLabel mailingLbl = new JLabel("Mailing Address");
		mailingLbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		mailingLbl.setBounds(21, 293, 149, 26);
		contentPane.add(mailingLbl);
		
		JLabel dptLbl = new JLabel("Department");
		dptLbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		dptLbl.setBounds(21, 332, 149, 26);
		contentPane.add(dptLbl);
		
		JLabel stfTypelbl = new JLabel("Staff Type");
		stfTypelbl.setFont(new Font("Sylfaen", Font.BOLD, 14));
		stfTypelbl.setBounds(21, 373, 149, 26);
		contentPane.add(stfTypelbl);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblUserId.setBounds(21, 410, 149, 26);
		contentPane.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblPassword.setBounds(21, 449, 149, 26);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblConfirmPassword.setBounds(21, 493, 149, 26);
		contentPane.add(lblConfirmPassword);
		
		textField = new JTextField();
		textField.setBounds(180, 134, 186, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 176, 186, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(178, 212, 186, 26);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(180, 248, 186, 26);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(180, 286, 356, 26);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(180, 325, 356, 26);
		contentPane.add(textField_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(180, 403, 186, 26);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(180, 442, 186, 26);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(180, 486, 186, 26);
		contentPane.add(textField_9);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Department Head");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(128, 368, 136, 30);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnTeachingAssistant = new JRadioButton("Teaching Assistant");
		rdbtnTeachingAssistant.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnTeachingAssistant.setBounds(290, 368, 157, 29);
		contentPane.add(rdbtnTeachingAssistant);
		
		JRadioButton rdbtnInstructor = new JRadioButton("Instructor");
		rdbtnInstructor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnInstructor.setBounds(443, 368, 157, 29);
		contentPane.add(rdbtnInstructor);
	}
}

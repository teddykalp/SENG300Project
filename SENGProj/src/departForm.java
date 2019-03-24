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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class departForm extends JFrame {

	private JPanel contentPane;
	private JTextField departName;
	private JTextField departCode;
	private mainMenuForm menu;
	private String name;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public departForm(String user) {
		
		this.name = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Register Department");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setBounds(209, 66, 190, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Department Name");
		lblNewLabel_1.setFont(new Font("Noto Serif", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 145, 131, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDepartmentDescription = new JLabel("<html><p>Department Description<p><html>");
		lblDepartmentDescription.setFont(new Font("Noto Serif", Font.PLAIN, 14));
		lblDepartmentDescription.setBounds(10, 219, 131, 39);
		contentPane.add(lblDepartmentDescription);
		
		JLabel lblDepartmentCode = new JLabel("Department Code");
		lblDepartmentCode.setFont(new Font("Noto Serif", Font.PLAIN, 14));
		lblDepartmentCode.setBounds(10, 346, 131, 22);
		contentPane.add(lblDepartmentCode);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Noto Serif", Font.PLAIN, 14));
		label_2.setBounds(10, 417, 131, 22);
		contentPane.add(label_2);
		
		JTextArea departDescription = new JTextArea();
		departDescription.setLineWrap(true);
		departDescription.setBounds(196, 204, 267, 103);
		contentPane.add(departDescription);
		
		departName = new JTextField();
		departName.setBounds(192, 147, 271, 20);
		contentPane.add(departName);
		departName.setColumns(10);
		
		departCode = new JTextField();
		departCode.setBounds(196, 348, 267, 20);
		contentPane.add(departCode);
		departCode.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Department");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(439, 408, 156, 31);
		contentPane.add(btnNewButton);
		
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
		button.setBounds(458, 21, 157, 35);
		contentPane.add(button);
	}
}

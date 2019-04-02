import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class departmentDisplay extends JFrame {

	private JPanel contentPane;
	private RWTools tool = new RWTools();
	private mainMenuForm menu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					departmentDisplay frame = new departmentDisplay(null);
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
	public departmentDisplay(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewDepartment = new JLabel("View Department");
		lblViewDepartment.setFont(new Font("Sylfaen", Font.BOLD, 21));
		lblViewDepartment.setBounds(211, 0, 187, 26);
		contentPane.add(lblViewDepartment);
		
		ArrayList arr = tool.getDepartment();
		String [] departments = new String[arr.size()];
		for (int x = 0; x < departments.length; x++){
			departments[x] = (String) arr.get(x);
		}
		
		
		JComboBox departmentBox = new JComboBox();
		departmentBox.setModel(new DefaultComboBoxModel(departments));
		departmentBox.setBounds(51, 74, 235, 32);
		contentPane.add(departmentBox);
		
		JTextArea departmentD = new JTextArea();
		departmentD.setEditable(false);
		departmentD.setBounds(51, 146, 245, 86);
		contentPane.add(departmentD);
		
		JLabel lblChooseDepartment = new JLabel("Choose Department");
		lblChooseDepartment.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblChooseDepartment.setBounds(51, 47, 201, 26);
		contentPane.add(lblChooseDepartment);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblDescription.setBounds(51, 118, 201, 26);
		contentPane.add(lblDescription);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblCode.setBounds(51, 241, 201, 26);
		contentPane.add(lblCode);
		
		JTextArea departmentCode = new JTextArea();
		departmentCode.setEditable(false);
		departmentCode.setBounds(51, 268, 245, 26);
		contentPane.add(departmentCode);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				departmentD.setText("");
				ArrayList departmentInfo = tool.getDepartmentInfo((String)departmentBox.getSelectedItem());
				departmentD.setText((String)departmentInfo.get(0));
				departmentCode.setText((String)departmentInfo.get(1));
				
			}
		});
		btnView.setBackground(new Color(173, 255, 47));
		btnView.setFont(new Font("Sylfaen", Font.BOLD, 21));
		btnView.setBounds(397, 241, 141, 35);
		contentPane.add(btnView);
		
		JButton btnReturn = new JButton("Go Back");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		btnReturn.setBackground(new Color(255, 105, 180));
		btnReturn.setFont(new Font("Sylfaen", Font.BOLD, 21));
		btnReturn.setBounds(397, 52, 141, 35);
		contentPane.add(btnReturn);
	}
}

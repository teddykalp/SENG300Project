import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class editDepartment extends JFrame {

	private JPanel contentPane;
	private JTextField departCode;
	private RWTools tool = new RWTools();
	private String oldName;
	private String oldDesc;
	private String oldCode;
	private String newName;
	private String newDesc;
	private String newCode;
	private mainMenuForm menu;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editDepartment frame = new editDepartment("Teddy");
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
	public editDepartment(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Which Department would you like to edit?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(21, 64, 315, 26);
		contentPane.add(lblNewLabel);
		
		ArrayList arr = tool.getDepartment();
		String [] departments = new String[arr.size()];
		for (int x = 0; x < departments.length; x++){
			departments[x] = (String) arr.get(x);
		}
		
		
		JComboBox comboDepartment = new JComboBox();
		comboDepartment.setModel(new DefaultComboBoxModel(departments));
		comboDepartment.setBounds(75, 111, 213, 26);
		contentPane.add(comboDepartment);
		
		JLabel lblDepartmentDesc = new JLabel("<html><p>Department Description<p><html>");
		lblDepartmentDesc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDepartmentDesc.setBounds(8, 185, 147, 47);
		contentPane.add(lblDepartmentDesc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(196, 177, 193, 131);
		contentPane.add(scrollPane);
		
		JTextArea departDesc = new JTextArea();
		departDesc.setEditable(false);
		scrollPane.setViewportView(departDesc);
		
		JLabel lbldepartmentCode = new JLabel("<html><p>Department Code<p><html>");
		lbldepartmentCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbldepartmentCode.setBounds(8, 329, 147, 47);
		contentPane.add(lbldepartmentCode);
		
		departCode = new JTextField();
		departCode.setEditable(false);
		departCode.setBounds(196, 338, 186, 26);
		contentPane.add(departCode);
		departCode.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(380, 21, 129, 24);
		contentPane.add(btnNewButton);
		
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Displays department info to UI
				departDesc.setEditable(true);
				departCode.setEditable(true);
				
				ArrayList departmentInfo = tool.getDepartmentInfo((String)comboDepartment.getSelectedItem());
				departDesc.setText((String)departmentInfo.get(0));
				departCode.setText((String)departmentInfo.get(1));
				oldName = (String) comboDepartment.getSelectedItem();
				oldDesc = (String)departmentInfo.get(0);
				oldCode = (String)departmentInfo.get(1);
			}
		});
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editButton.setBounds(331, 113, 85, 26);
		contentPane.add(editButton);
		
		JButton commitChanges = new JButton("Commit Changes");
		commitChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newDesc = departDesc.getText();
				newCode = departCode.getText();
				tool.editDepartment(oldDesc, newDesc);
				tool.editDepartment(oldCode, newCode);
				
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		commitChanges.setFont(new Font("Tahoma", Font.BOLD, 15));
		commitChanges.setBounds(352, 421, 168, 26);
		contentPane.add(commitChanges);
		
		JButton btnRemove = new JButton("Remove Department");
		btnRemove.setHorizontalAlignment(SwingConstants.LEFT);
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRemove.setBounds(21, 421, 186, 26);
		contentPane.add(btnRemove);
		
		
	}
}

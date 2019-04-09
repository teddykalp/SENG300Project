import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class editDepartment extends JPanel {

	private JPanel contentPane;
	private JTextField departName;
	private JTextField departCode;
	private RWTools tool = new RWTools();
	
	private JLabel lblNewLabel;
	private JComboBox comboDepartment;
	private JLabel lblDepartName;
	private JLabel lblDepartmentDesc;
	private JLabel lbldepartmentCode;
	
	private JTextArea departDesc;
	
	private JScrollPane scrollPane;
	
	private JButton btnCancel;
	private JButton editButton;
	private JButton commitChanges;
	
	// functionality purposes
	private String oldName;
	private String oldDesc;
	private String oldCode;
	private String newName;
	private String newDesc;
	private String newCode;

	



	/**
	 * Create the frame.
	 */
	public editDepartment(JPanel panel) {
		JPanel p1 = new JPanel(null);
		p1.setPreferredSize(new Dimension(1000,1000));
		contentPane = panel;
		
		JLabel lblNewLabel = new JLabel("Which Department would you like to edit?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(21, 64, 315, 26);
		p1.add(lblNewLabel);
		
		ArrayList arr = tool.getDepartment();
		String [] departments = new String[arr.size()];
		for (int x = 0; x < departments.length; x++){
			departments[x] = (String) arr.get(x);
		}
		
		
		JComboBox comboDepartment = new JComboBox();
		comboDepartment.setModel(new DefaultComboBoxModel(departments));
		comboDepartment.setBounds(75, 111, 213, 26);
		p1.add(comboDepartment);
		
		lblDepartName = new JLabel("Department Name");
		lblDepartName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDepartName.setBounds(8, 175, 147, 26);
		p1.add(lblDepartName);
		
		departName = new JTextField();
		departName.setBounds(176, 173, 186, 28);
		p1.add(departName);
		departName.setColumns(10);
		
		lblDepartmentDesc = new JLabel("<html><p>Department Description<p><html>");
		lblDepartmentDesc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDepartmentDesc.setBounds(8, 251, 147, 47);
		p1.add(lblDepartmentDesc);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(176, 228, 193, 131);
		p1.add(scrollPane);
		
		departDesc = new JTextArea();
		scrollPane.setViewportView(departDesc);
		
		lbldepartmentCode = new JLabel("<html><p>Department Code<p><html>");
		lbldepartmentCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbldepartmentCode.setBounds(8, 372, 147, 47);
		p1.add(lbldepartmentCode);
		
		departCode = new JTextField();
		departCode.setBounds(176, 381, 186, 26);
		p1.add(departCode);
		departCode.setColumns(10);
		
		
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancel.setBounds(370, 21, 129, 24);
		p1.add(btnCancel);
		
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Displays department info to UI
				departName.setText((String) comboDepartment.getSelectedItem());
				ArrayList departmentInfo = tool.getDepartmentInfo((String)comboDepartment.getSelectedItem());
				departDesc.setText((String)departmentInfo.get(0));
				departCode.setText((String)departmentInfo.get(1));
				oldName = "DEPARTMENT NAME: " + (String) comboDepartment.getSelectedItem();
				oldDesc = "DEPARTMENT DESCRIPTION: " + (String)departmentInfo.get(0);
				oldCode = "DEPARTMENT CODE: " + (String)departmentInfo.get(1);
			}
		});
		editButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		editButton.setBounds(331, 113, 85, 26);
		p1.add(editButton);
		
		JButton commitChanges = new JButton("Commit Changes");
		commitChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newName = "DEPARTMENT NAME: " + departName.getText();
				newDesc = "DEPARTMENT DESCRIPTION: "+ departDesc.getText();
				newCode = "DEPARTMENT CODE: " + departCode.getText();
				String db = "departmentDB.txt";
				
				tool.editDB(oldName, newName, db);
				tool.editDB(oldDesc, newDesc, db);
				tool.editDB(oldCode, newCode, db);
				
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		commitChanges.setFont(new Font("Tahoma", Font.BOLD, 15));
		commitChanges.setBounds(331, 442, 168, 26);
		p1.add(commitChanges);
		
		contentPane.add(p1);
		add(p1);
	}
}

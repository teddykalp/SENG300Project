import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextArea;

public class AddCourse extends JFrame {

	private JPanel contentPane;
	private JTextField courseName;
	private JTextField courseID;
	private JTextField startTime;
	private JTextField finishTime;
	private mainMenuForm menu;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AddCourse() {
		
		JLabel nameError = new JLabel("");
		nameError.setForeground(Color.RED);
		nameError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nameError.setBounds(412, 62, 123, 17);
		getContentPane().add(nameError);
		
		JLabel descError = new JLabel("");
		descError.setForeground(Color.RED);
		descError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		descError.setBounds(412, 100, 123, 17);
		getContentPane().add(descError);
		
		JLabel idError = new JLabel("");
		idError.setForeground(Color.RED);
		idError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		idError.setBounds(412, 206, 123, 17);
		getContentPane().add(idError);
		
		JLabel stError = new JLabel("");
		stError.setForeground(Color.RED);
		stError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		stError.setBounds(474, 612, 121, 17);
		getContentPane().add(stError);
		
		JLabel ftError = new JLabel("");
		ftError.setForeground(Color.RED);
		ftError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ftError.setBounds(371, 635, 92, 17);
		getContentPane().add(ftError);
		setBounds(100, 100, 642, 869);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAddCourse = new JLabel("Register a Course");
		lblAddCourse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAddCourse.setBounds(211, 16, 165, 26);
		getContentPane().add(lblAddCourse);
		
		JLabel lblNewLabel = new JLabel("Course Level");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 109, 92, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseName.setBounds(21, 62, 92, 26);
		getContentPane().add(lblCourseName);
		
		JLabel lblCourseDescription = new JLabel("Course Description ");
		lblCourseDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseDescription.setBounds(21, 548, 119, 26);
		getContentPane().add(lblCourseDescription);
		
		JLabel lblCourseId = new JLabel("Course ID (00-99)");
		lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseId.setBounds(21, 147, 119, 26);
		getContentPane().add(lblCourseId);
		
		JLabel lblInstructor = new JLabel("<html><p>Prerequisite \r\nCourses (Seperate courses with a comma)<p><html>");
		lblInstructor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstructor.setBounds(21, 223, 157, 51);
		getContentPane().add(lblInstructor);
		
		JLabel label = new JLabel("Instructor");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(21, 185, 92, 26);
		getContentPane().add(label);
		
		JLabel lblDaysThisCourse = new JLabel("<html><p>Days this Course will be offered<p><html>");
		lblDaysThisCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDaysThisCourse.setBounds(21, 295, 102, 51);
		getContentPane().add(lblDaysThisCourse);
		
		courseName = new JTextField();
		courseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseName.setColumns(10);
		courseName.setBounds(211, 63, 186, 26);
		getContentPane().add(courseName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(263, 107, 48, 27);
		getContentPane().add(comboBox);
		
		courseID = new JTextField();
		courseID.setBounds(211, 147, 186, 26);
		getContentPane().add(courseID);
		courseID.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(211, 183, 186, 26);
		getContentPane().add(comboBox_3);
		
		JRadioButton rdbtnMonday = new JRadioButton("Monday");
		rdbtnMonday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnMonday.setBounds(211, 307, 149, 29);
		getContentPane().add(rdbtnMonday);
		
		JRadioButton rdbtnTuesday = new JRadioButton("Tuesday");
		rdbtnTuesday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnTuesday.setBounds(211, 349, 149, 29);
		getContentPane().add(rdbtnTuesday);
		
		JRadioButton rdbtnWednesday = new JRadioButton("Wednesday");
		rdbtnWednesday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnWednesday.setBounds(211, 391, 149, 29);
		getContentPane().add(rdbtnWednesday);
		
		JRadioButton rdbtnThursday = new JRadioButton("Thursday");
		rdbtnThursday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnThursday.setBounds(363, 307, 172, 29);
		getContentPane().add(rdbtnThursday);
		
		JRadioButton rdbtnFriday = new JRadioButton("Friday");
		rdbtnFriday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnFriday.setBounds(363, 349, 130, 29);
		getContentPane().add(rdbtnFriday);
		
		JRadioButton rdbtnSaturday = new JRadioButton("Saturday");
		rdbtnSaturday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnSaturday.setBounds(363, 391, 130, 29);
		getContentPane().add(rdbtnSaturday);
		
		JLabel lblTimeslot = new JLabel("Time Slot");
		lblTimeslot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimeslot.setBounds(21, 440, 92, 26);
		getContentPane().add(lblTimeslot);
		
		startTime = new JTextField();
		startTime.setBounds(195, 437, 80, 32);
		getContentPane().add(startTime);
		startTime.setColumns(10);
		
		finishTime = new JTextField();
		finishTime.setColumns(10);
		finishTime.setBounds(347, 437, 80, 32);
		getContentPane().add(finishTime);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStartTime.setBounds(120, 440, 69, 26);
		getContentPane().add(lblStartTime);
		
		JLabel lblFinishTime = new JLabel("Finish Time");
		lblFinishTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFinishTime.setBounds(276, 440, 69, 26);
		getContentPane().add(lblFinishTime);
		
		JLabel lblCourseCredits = new JLabel("Course Credits");
		lblCourseCredits.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseCredits.setBounds(21, 487, 92, 26);
		getContentPane().add(lblCourseCredits);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4"}));
		comboBox_4.setBounds(272, 490, 57, 26);
		getContentPane().add(comboBox_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(211, 221, 216, 65);
		getContentPane().add(textArea);
		
		JTextArea courseDesc = new JTextArea();
		courseDesc.setBounds(209, 551, 244, 113);
		getContentPane().add(courseDesc);
		
		JButton btnRegisterCourse = new JButton("Submit");
		btnRegisterCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (courseName.getText().isEmpty()){
					nameError.setText("Please enter valid name");
				}else{
					nameError.setText("");
				}
				if (courseDesc.getText().isEmpty()){
					descError.setText("Please enter description");
				}
			}
		});
		btnRegisterCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegisterCourse.setBounds(226, 715, 157, 35);
		getContentPane().add(btnRegisterCourse);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu = new mainMenuForm();
				menu.setVisible(true);
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGoBack.setBounds(438, 21, 157, 35);
		getContentPane().add(btnGoBack);
		
		
		
		
	}
}

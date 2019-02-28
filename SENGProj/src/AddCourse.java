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

public class AddCourse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse frame = new AddCourse();
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
	public AddCourse() {
		new JFrame();
		setBounds(100, 100, 641, 782);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAddCourse = new JLabel("Add Course");
		lblAddCourse.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAddCourse.setBounds(249, 10, 122, 26);
		getContentPane().add(lblAddCourse);
		
		JLabel lblNewLabel = new JLabel("Course Level");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 159, 92, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseName.setBounds(21, 62, 92, 26);
		getContentPane().add(lblCourseName);
		
		JLabel lblCourseDescription = new JLabel("Course Description ");
		lblCourseDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseDescription.setBounds(21, 109, 119, 26);
		getContentPane().add(lblCourseDescription);
		
		JLabel lblCourseId = new JLabel("Course ID (00-99)");
		lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseId.setBounds(21, 206, 119, 26);
		getContentPane().add(lblCourseId);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgram.setBounds(21, 247, 92, 26);
		getContentPane().add(lblProgram);
		
		JLabel lblInstructor = new JLabel("<html><p>Prerequisite \r\nCourses (Seperate courses with a comma)<p><html>");
		lblInstructor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstructor.setBounds(21, 414, 157, 51);
		getContentPane().add(lblInstructor);
		
		JLabel label = new JLabel("Instructor");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(21, 351, 92, 26);
		getContentPane().add(label);
		
		JLabel lblDaysThisCourse = new JLabel("<html><p>Days this Course will be offered<p><html>");
		lblDaysThisCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDaysThisCourse.setBounds(21, 484, 102, 51);
		getContentPane().add(lblDaysThisCourse);
		
		textField = new JTextField();
		textField.setBounds(211, 110, 186, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(211, 63, 186, 26);
		getContentPane().add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(275, 159, 44, 27);
		getContentPane().add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(211, 207, 186, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartment.setBounds(21, 298, 92, 26);
		getContentPane().add(lblDepartment);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(211, 300, 186, 26);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(211, 247, 186, 27);
		getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(211, 351, 186, 26);
		getContentPane().add(comboBox_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(211, 404, 186, 61);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JRadioButton rdbtnMonday = new JRadioButton("Monday");
		rdbtnMonday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnMonday.setBounds(211, 482, 149, 29);
		getContentPane().add(rdbtnMonday);
		
		JRadioButton rdbtnTuesday = new JRadioButton("Tuesday");
		rdbtnTuesday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnTuesday.setBounds(211, 524, 149, 29);
		getContentPane().add(rdbtnTuesday);
		
		JRadioButton rdbtnWednesday = new JRadioButton("Wednesday");
		rdbtnWednesday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnWednesday.setBounds(211, 566, 149, 29);
		getContentPane().add(rdbtnWednesday);
		
		JRadioButton rdbtnThursday = new JRadioButton("Thursday");
		rdbtnThursday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnThursday.setBounds(363, 480, 172, 29);
		getContentPane().add(rdbtnThursday);
		
		JRadioButton rdbtnFriday = new JRadioButton("Friday");
		rdbtnFriday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnFriday.setBounds(363, 524, 130, 29);
		getContentPane().add(rdbtnFriday);
		
		JRadioButton rdbtnSaturday = new JRadioButton("Saturday");
		rdbtnSaturday.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rdbtnSaturday.setBounds(363, 566, 130, 29);
		getContentPane().add(rdbtnSaturday);
	}

}

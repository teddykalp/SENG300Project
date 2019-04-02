import java.awt.BorderLayout;
import java.io.*;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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

/**
* AddCourse form that for staff users to add a course to the program system
* @author	TeddyKalp
* @version 	1.0
*/

public class AddCourse extends JFrame {

	private JPanel contentPane;
	private JTextField courseName;
	private JTextField courseID;
	private JTextField startTime;
	private JTextField finishTime;
	private mainMenuForm menu;
	File file = new File("courseDB.txt");
	private JTextField courseProgram;
	private JTextField courseInstructor;
	//private File file = new File("courseDB.txt");
	
	
	
	

	/**
	 * Launch the application.
	 */


	/**
	* AddCourse function that contains form created from WindowsBuilder
	* @param	user - Staff user that is adding the course
	* @return 	N/A
	*/
	public AddCourse(String user) {
		
		
		// Window and Label settings for WindowBuilder
		JLabel nameError = new JLabel("");
		nameError.setForeground(Color.RED);
		nameError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nameError.setBounds(412, 62, 123, 17);
		getContentPane().add(nameError);
		
		JLabel descError = new JLabel("");
		descError.setForeground(Color.RED);
		descError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		descError.setBounds(461, 557, 123, 17);
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
		
		// Label for Register Course
		JLabel lblAddCourse = new JLabel("Register Course");
		lblAddCourse.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAddCourse.setBounds(221, 16, 165, 26);
		getContentPane().add(lblAddCourse);
		
		// Label for Course Level
		JLabel lblNewLabel = new JLabel("Course Level");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 100, 92, 26);
		getContentPane().add(lblNewLabel);
		
		// Label for Course Name
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseName.setBounds(21, 62, 92, 26);
		getContentPane().add(lblCourseName);
		
		// Label for Course Description
		JLabel lblCourseDescription = new JLabel("Course Description ");
		lblCourseDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseDescription.setBounds(21, 603, 119, 26);
		getContentPane().add(lblCourseDescription);
		
		// Label for Course ID
		JLabel lblCourseId = new JLabel("Course ID (00-99)");
		lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseId.setBounds(21, 135, 119, 26);
		getContentPane().add(lblCourseId);
		
		// Label for Prerequisite Courses
		JLabel lblInstructor = new JLabel("<html><p>Prerequisite \r\nCourses (Seperate courses with a comma)<p><html>");
		lblInstructor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstructor.setBounds(21, 265, 157, 51);
		getContentPane().add(lblInstructor);
		
		// Label for Instructor
		JLabel label = new JLabel("Instructor");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(21, 218, 92, 26);
		getContentPane().add(label);
		
		// Label for course dates selections
		JLabel lblDaysThisCourse = new JLabel("<html><p>Days this Course will be offered<p><html>");
		lblDaysThisCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDaysThisCourse.setBounds(21, 381, 102, 51);
		getContentPane().add(lblDaysThisCourse);
		
		// User input for course name
		courseName = new JTextField();
		courseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseName.setColumns(10);
		courseName.setBounds(211, 63, 186, 26);
		getContentPane().add(courseName);
		
		// Takes user input for course level 
		JComboBox courseLvl = new JComboBox();
		courseLvl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseLvl.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		courseLvl.setSelectedIndex(0);
		courseLvl.setBounds(258, 99, 48, 27);
		getContentPane().add(courseLvl);
		
		// Takes course ID from user input
		courseID = new JTextField();
		courseID.setBounds(211, 133, 186, 26);
		getContentPane().add(courseID);
		courseID.setColumns(10);
		
		// Takes course dates from radio button selection input
		JRadioButton monDay = new JRadioButton("Monday");
		monDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		monDay.setBounds(211, 335, 149, 29);
		getContentPane().add(monDay);
		
		JRadioButton tuesDay = new JRadioButton("Tuesday");
		tuesDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tuesDay.setBounds(211, 377, 149, 29);
		getContentPane().add(tuesDay);
		
		JRadioButton wednesDay = new JRadioButton("Wednesday");
		wednesDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		wednesDay.setBounds(211, 418, 149, 29);
		getContentPane().add(wednesDay);
		
		JRadioButton thursDay = new JRadioButton("Thursday");
		thursDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		thursDay.setBounds(371, 335, 172, 29);
		getContentPane().add(thursDay);
		
		JRadioButton friDay = new JRadioButton("Friday");
		friDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		friDay.setBounds(371, 377, 130, 29);
		getContentPane().add(friDay);
		
		JRadioButton saturDay = new JRadioButton("Saturday");
		saturDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		saturDay.setBounds(371, 418, 130, 29);
		getContentPane().add(saturDay);
		
		// Label for time slot
		JLabel lblTimeslot = new JLabel("Time Slot");
		lblTimeslot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimeslot.setBounds(21, 486, 92, 26);
		getContentPane().add(lblTimeslot);
		
		// Takes start time from user input
		startTime = new JTextField();
		startTime.setBounds(196, 481, 80, 32);
		getContentPane().add(startTime);
		startTime.setColumns(10);
		
		// Takes finish time from user input
		finishTime = new JTextField();
		finishTime.setColumns(10);
		finishTime.setBounds(371, 481, 80, 32);
		getContentPane().add(finishTime);
		
		// Label for start time
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStartTime.setBounds(116, 486, 69, 26);
		getContentPane().add(lblStartTime);
		
		// Label for finish time
		JLabel lblFinishTime = new JLabel("Finish Time");
		lblFinishTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFinishTime.setBounds(291, 486, 69, 26);
		getContentPane().add(lblFinishTime);
		
		// Label for course credits
		JLabel lblCourseCredits = new JLabel("Course Credits");
		lblCourseCredits.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseCredits.setBounds(21, 533, 92, 26);
		getContentPane().add(lblCourseCredits);
		
		// Dropbox selection for course credits
		JComboBox courseCredit = new JComboBox();
		courseCredit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseCredit.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4"}));
		courseCredit.setBounds(272, 532, 57, 26);
		getContentPane().add(courseCredit);
		
		// Takes course prerequisites form user input
		JTextArea coursePreReq = new JTextArea();
		coursePreReq.setLineWrap(true);
		coursePreReq.setBounds(211, 263, 216, 65);
		getContentPane().add(coursePreReq);
		
		// Takes course description from user input
		JTextArea courseDesc = new JTextArea();
		courseDesc.setLineWrap(true);
		courseDesc.setBounds(183, 600, 244, 113);
		getContentPane().add(courseDesc);
		
		// Takes program from user input
		courseProgram = new JTextField();
		courseProgram.setBounds(211, 180, 186, 26);
		getContentPane().add(courseProgram);
		courseProgram.setColumns(10);
		
		// Takes instructor from user input
		courseInstructor = new JTextField();
		courseInstructor.setBounds(211, 218, 186, 27);
		getContentPane().add(courseInstructor);
		courseInstructor.setColumns(10);
		
		// Submit button
		JButton btnRegisterCourse = new JButton("Submit");
		btnRegisterCourse.setBackground(Color.DARK_GRAY);
		btnRegisterCourse.setForeground(Color.GREEN);
		btnRegisterCourse.addActionListener(new ActionListener() {
			/**
			* actionPerformed handles user input in AddCourse form
			* @param	ActionEvent - when submit button is clicked
			* @return 	void
			*/
			public void actionPerformed(ActionEvent e) {
				// Error handling when courseName input is empty
				if (courseName.getText().isEmpty()){
					nameError.setText("Please enter valid name");
				}else{
						// Creates array for selection of days that class occurs
						ArrayList<String> list = new ArrayList<String>();
						if (monDay.isSelected()){
							list.add("Monday");
						}
						if (tuesDay.isSelected()){
							list.add("Tuesday");
						}
						if (wednesDay.isSelected()){
							list.add("Wednesday");
						}
						if (thursDay.isSelected()){
							list.add("Thursday");
						}
						if (friDay.isSelected()){
							list.add("Friday");
						}
						if (saturDay.isSelected()){
							list.add("Saturday");
						}
						RWTools tool = new RWTools();
						// Writes course information to courseDB.txt using RWTools
						tool.writeToCourse(courseName.getText(), courseID.getText(), courseProgram.getText(), courseLvl.getSelectedItem(),
								          courseInstructor.getText(), coursePreReq.getText(), list, startTime.getText(), finishTime.getText(), courseCredit.getSelectedItem());
						setVisible(false);
						menu = new mainMenuForm(user);
						menu.setVisible(true);
					}
				}
		});
		btnRegisterCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegisterCourse.setBounds(221, 731, 157, 35);
		getContentPane().add(btnRegisterCourse);
		
		// GoBack button returns user to main menu
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBackground(Color.DARK_GRAY);
		btnGoBack.setForeground(Color.RED);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGoBack.setBounds(438, 21, 157, 35);
		getContentPane().add(btnGoBack);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgram.setBounds(21, 179, 119, 26);
		getContentPane().add(lblProgram);
	}
}

// Imported libraries
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
* AddCourse form that allows staff users to add a course to system
* @author	TeddyKalp
* @version 	1.0
*/

public class AddCourse extends JFrame {
	
	// class attributes
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
	 * AddCourse constructor that creates the frame and adds its components.
	 * @param	user - staff user that is adding a course
	 */
	public AddCourse(String user) {
		
		// course name label attributes
		JLabel nameError = new JLabel("");
		nameError.setForeground(Color.RED);
		nameError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nameError.setBounds(412, 62, 123, 17);
		getContentPane().add(nameError);
		
		// course description label attributes
		JLabel descError = new JLabel("");
		descError.setForeground(Color.RED);
		descError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		descError.setBounds(461, 557, 123, 17);
		getContentPane().add(descError);
		
		// course ID label attributes
		JLabel idError = new JLabel("");
		idError.setForeground(Color.RED);
		idError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		idError.setBounds(412, 206, 123, 17);
		getContentPane().add(idError);
		
		// start time label attributes
		JLabel stError = new JLabel("");
		stError.setForeground(Color.RED);
		stError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		stError.setBounds(474, 612, 121, 17);
		getContentPane().add(stError);
		
		// finish time label attributes
		JLabel ftError = new JLabel("");
		ftError.setForeground(Color.RED);
		ftError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ftError.setBounds(371, 635, 92, 17);
		getContentPane().add(ftError);
		setBounds(100, 100, 642, 869);
		
		// Closes window when the user exits the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		// Adds register course label
		JLabel lblAddCourse = new JLabel("Register Course");
		lblAddCourse.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAddCourse.setBounds(221, 16, 165, 26);
		getContentPane().add(lblAddCourse);
		
		// Adds course level label
		JLabel lblNewLabel = new JLabel("Course Level");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 100, 92, 26);
		getContentPane().add(lblNewLabel);
		
		// Adds course name label
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseName.setBounds(21, 62, 92, 26);
		getContentPane().add(lblCourseName);
		
		// Adds course description label
		JLabel lblCourseDescription = new JLabel("Course Description ");
		lblCourseDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseDescription.setBounds(21, 603, 119, 26);
		getContentPane().add(lblCourseDescription);
		
		// Adds course ID label
		JLabel lblCourseId = new JLabel("Course ID (00-99)");
		lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseId.setBounds(21, 135, 119, 26);
		getContentPane().add(lblCourseId);
		
		// Adds prerequisite label
		JLabel lblInstructor = new JLabel("<html><p>Prerequisite \r\nCourses (Seperate courses with a comma)<p><html>");
		lblInstructor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstructor.setBounds(21, 265, 157, 51);
		getContentPane().add(lblInstructor);
		
		// Adds instructor label
		JLabel label = new JLabel("Instructor");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(21, 218, 92, 26);
		getContentPane().add(label);
		
		// Adds daysOffered selection
		JLabel lblDaysThisCourse = new JLabel("<html><p>Days this Course will be offered<p><html>");
		lblDaysThisCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDaysThisCourse.setBounds(21, 381, 102, 51);
		getContentPane().add(lblDaysThisCourse);
		
		// Takes user input for course name
		courseName = new JTextField();
		courseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseName.setColumns(10);
		courseName.setBounds(211, 63, 186, 26);
		getContentPane().add(courseName);
		
		// Takes user input for course level from selection
		JComboBox courseLvl = new JComboBox();
		courseLvl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseLvl.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		courseLvl.setSelectedIndex(0);
		courseLvl.setBounds(258, 99, 48, 27);
		getContentPane().add(courseLvl);
		
		// Takes user input for course ID
		courseID = new JTextField();
		courseID.setBounds(211, 133, 186, 26);
		getContentPane().add(courseID);
		courseID.setColumns(10);
		
		// Radio buttons for daysOffered selection
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
		
		// Time slot label
		JLabel lblTimeslot = new JLabel("Time Slot");
		lblTimeslot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimeslot.setBounds(21, 486, 92, 26);
		getContentPane().add(lblTimeslot);
		
		// Takes user input for start time
		startTime = new JTextField();
		startTime.setBounds(196, 481, 80, 32);
		getContentPane().add(startTime);
		startTime.setColumns(10);
		
		// Takes user input for finish time
		finishTime = new JTextField();
		finishTime.setColumns(10);
		finishTime.setBounds(371, 481, 80, 32);
		getContentPane().add(finishTime);
		
		// Start time label
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStartTime.setBounds(116, 486, 69, 26);
		getContentPane().add(lblStartTime);
		
		// Finish time label
		JLabel lblFinishTime = new JLabel("Finish Time");
		lblFinishTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFinishTime.setBounds(291, 486, 69, 26);
		getContentPane().add(lblFinishTime);
		
		// Course credits label
		JLabel lblCourseCredits = new JLabel("Course Credits");
		lblCourseCredits.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseCredits.setBounds(21, 533, 92, 26);
		getContentPane().add(lblCourseCredits);
		
		// Takes user input for course credit from selection	
		JComboBox courseCredit = new JComboBox();
		courseCredit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseCredit.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4"}));
		courseCredit.setBounds(272, 532, 57, 26);
		getContentPane().add(courseCredit);
		
		// Takes user input for course prerequisites
		JTextArea coursePreReq = new JTextArea();
		coursePreReq.setLineWrap(true);
		coursePreReq.setBounds(211, 263, 216, 65);
		getContentPane().add(coursePreReq);
		
		// Takes user input for course description
		JTextArea courseDesc = new JTextArea();
		courseDesc.setLineWrap(true);
		courseDesc.setBounds(183, 600, 244, 113);
		getContentPane().add(courseDesc);
		
		// Takes user input for course program
		courseProgram = new JTextField();
		courseProgram.setBounds(211, 180, 186, 26);
		getContentPane().add(courseProgram);
		courseProgram.setColumns(10);
		
		// Takes user input for instructor
		courseInstructor = new JTextField();
		courseInstructor.setBounds(211, 218, 186, 27);
		getContentPane().add(courseInstructor);
		courseInstructor.setColumns(10);
		
		// Submit button and its attributes
		JButton btnRegisterCourse = new JButton("Submit");
		btnRegisterCourse.setBackground(Color.DARK_GRAY);
		btnRegisterCourse.setForeground(Color.GREEN);
		btnRegisterCourse.addActionListener(new ActionListener() {
			/**
			* actionPerformed for submit button
			* @param	ActionEvent - when submit button is clicked
			* @return 	void
			*/

			public void actionPerformed(ActionEvent e) {
				// Error handling when courseName input is empty
				if (courseName.getText().isEmpty()){
					nameError.setText("Please enter valid name");
				}else{
						// Creates array for daysOffered
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
						// Writes course information to courseDB.txt using RWTools
						RWTools tool = new RWTools();
						tool.writeToCourse(courseName.getText(), courseID.getText(), courseProgram.getText(), courseLvl.getSelectedItem(),
								          courseInstructor.getText(), coursePreReq.getText(), list, startTime.getText(), finishTime.getText(), courseCredit.getSelectedItem());
						setVisible(false);
						// Returns user to main menu
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

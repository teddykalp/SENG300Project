// Imported libraries

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;
import java.util.ArrayList;


/**
* AddCourse form that allows staff users to add a course to system
* @author	TeddyKalp
* @version 	1.0
*/

public class AddCourse extends JPanel {
        ImageLibrary img = new ImageLibrary();
	// class attributes
	private JPanel contentPane;
	private JButton back;
	private JButton AddCourse;
	
	private JLabel CTLabel;
	private JLabel CLLabel;
	private JLabel CILabel;
	private JLabel PLabel;
	private JLabel ILabel;
	private JLabel CDLabel;
	private JLabel PCLabel;
	private JLabel ACLabel;
	private JLabel CCLabel;
	private JLabel DaysLabel;
	private JLabel TimeLabel;
	private JLabel CreditsLabel;
	
	private JLabel instructorError;
	private JLabel nameError;
	private JLabel descError;
	private JLabel idError;
	private JLabel stError;
	private JLabel ftError;
	
	private JTextField courseName;
	private JTextField courseID;
	private JComboBox programBox;
	private JTextField courseInstructor;
	private JTextField startTime;
	private JTextField finishTime;
	
	File file = new File("courseDB.txt");
	
	private RWTools tool = new RWTools();
	
	

	/**
	 * Launch the application.
	 */

	/**
	 * AddCourse constructor that creates the frame and adds its components.
	 * @param	user - staff user that is adding a course
	 */
	public AddCourse(JPanel pane) {
		JPanel p1 = new JPanel(null) ;       
                 contentPane = pane;
                 
                 JPanel addcbg = new JPanel();
                ImageIcon pic = img.addcbg;
                addcbg.setSize(1000,1000);
                addcbg.add(new JLabel(pic));
                addcbg.setEnabled(true);
                addcbg.setVisible(true);
                
  
		// course name label attributes
		JLabel nameError = new JLabel("");
		nameError.setForeground(Color.RED);
		nameError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nameError.setBounds(412, 62, 123, 17);
		p1.add(nameError);
		
		// course description label attributes
		JLabel descError = new JLabel("");
		descError.setForeground(Color.RED);
		descError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		descError.setBounds(461, 557, 123, 17);
		p1.add(descError);
		
		// course ID label attributes
		JLabel idError = new JLabel("");
		idError.setForeground(Color.RED);
		idError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		idError.setBounds(412, 206, 123, 17);
		p1.add(idError);
		
		// start time label attributes
		JLabel stError = new JLabel("");
		stError.setForeground(Color.RED);
		stError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		stError.setBounds(474, 612, 121, 17);
		p1.add(stError);
		
		// finish time label attributes
		JLabel ftError = new JLabel("");
		ftError.setForeground(Color.RED);
		ftError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ftError.setBounds(371, 635, 92, 17);
		p1.add(ftError);
		setBounds(100, 100, 642, 869);
		
		
		

		
		// Adds register course label
		JLabel lblAddCourse = new JLabel("Register Course");
		lblAddCourse.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAddCourse.setBounds(221, 16, 165, 26);
		p1.add(lblAddCourse);
		
		// Adds course level label
		JLabel lblNewLabel = new JLabel("Course Level");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 100, 92, 26);
		p1.add(lblNewLabel);
		
		// Adds course name label
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseName.setBounds(21, 62, 92, 26);
		p1.add(lblCourseName);
		
		// Adds course description label
		JLabel lblCourseDescription = new JLabel("Course Description ");
		lblCourseDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseDescription.setBounds(21, 603, 119, 26);
		p1.add(lblCourseDescription);
		
		// Adds course ID label
		JLabel lblCourseId = new JLabel("Course ID (00-99)");
		lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseId.setBounds(21, 135, 119, 26);
		p1.add(lblCourseId);
		
		// Adds prerequisite label
		JLabel lblInstructor = new JLabel("<html><p>Prerequisite \r\nCourses (Seperate courses with a comma)<p><html>");
		lblInstructor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstructor.setBounds(21, 265, 157, 51);
		p1.add(lblInstructor);
		
		// Adds instructor label
		JLabel label = new JLabel("Instructor");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(21, 218, 92, 26);
		p1.add(label);
		
		// Adds daysOffered selection
		JLabel lblDaysThisCourse = new JLabel("<html><p>Days this Course will be offered<p><html>");
		lblDaysThisCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDaysThisCourse.setBounds(21, 381, 102, 51);
		p1.add(lblDaysThisCourse);
		
		// Takes user input for course name
		courseName = new JTextField();
		courseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseName.setColumns(10);
		courseName.setBounds(211, 63, 186, 26);
		p1.add(courseName);
		
		// Takes user input for course level from selection
		JComboBox courseLvl = new JComboBox();
		courseLvl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseLvl.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		courseLvl.setSelectedIndex(0);
		courseLvl.setBounds(258, 99, 48, 27);
		p1.add(courseLvl);
		
		// Takes user input for course ID
		courseID = new JTextField();
		courseID.setBounds(211, 133, 186, 26);
		p1.add(courseID);
		courseID.setColumns(10);
		
		// Radio buttons for daysOffered selection
		JRadioButton monDay = new JRadioButton("Monday");
		monDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		monDay.setBounds(211, 335, 149, 29);
		p1.add(monDay);
		
		JRadioButton tuesDay = new JRadioButton("Tuesday");
		tuesDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tuesDay.setBounds(211, 377, 149, 29);
		p1.add(tuesDay);
		
		JRadioButton wednesDay = new JRadioButton("Wednesday");
		wednesDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		wednesDay.setBounds(211, 418, 149, 29);
		p1.add(wednesDay);
		
		JRadioButton thursDay = new JRadioButton("Thursday");
		thursDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		thursDay.setBounds(371, 335, 172, 29);
		p1.add(thursDay);
		
		JRadioButton friDay = new JRadioButton("Friday");
		friDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		friDay.setBounds(371, 377, 130, 29);
		p1.add(friDay);
		
		JRadioButton saturDay = new JRadioButton("Saturday");
		saturDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		saturDay.setBounds(371, 418, 130, 29);
		p1.add(saturDay);
		
		// Time slot label
		JLabel lblTimeslot = new JLabel("Time Slot");
		lblTimeslot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimeslot.setBounds(21, 486, 92, 26);
		p1.add(lblTimeslot);
		
		// Takes user input for start time
		startTime = new JTextField();
		startTime.setBounds(196, 481, 80, 32);
		p1.add(startTime);
		startTime.setColumns(10);
		
		// Takes user input for finish time
		finishTime = new JTextField();
		finishTime.setColumns(10);
		finishTime.setBounds(371, 481, 80, 32);
		p1.add(finishTime);
		
		// Start time label
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStartTime.setBounds(116, 486, 69, 26);
		p1.add(lblStartTime);
		
		// Finish time label
		JLabel lblFinishTime = new JLabel("Finish Time");
		lblFinishTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFinishTime.setBounds(291, 486, 69, 26);
		p1.add(lblFinishTime);
		
		// Course credits label
		JLabel lblCourseCredits = new JLabel("Course Credits");
		lblCourseCredits.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseCredits.setBounds(21, 533, 92, 26);
		p1.add(lblCourseCredits);
		
		// Takes user input for course credit from selection	
		JComboBox courseCredit = new JComboBox();
		courseCredit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseCredit.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4"}));
		courseCredit.setBounds(272, 532, 57, 26);
		p1.add(courseCredit);
		
		// Takes user input for course prerequisites
		JTextArea coursePreReq = new JTextArea();
		coursePreReq.setLineWrap(true);
		coursePreReq.setBounds(211, 263, 216, 65);
		p1.add(coursePreReq);
		
		
		
		
		// Takes user input for course description
		JTextArea courseDesc = new JTextArea();
		
		
		// Takes user input for instructor
		courseInstructor = new JTextField();
		courseInstructor.setBounds(211, 218, 186, 27);
		p1.add(courseInstructor);
		courseInstructor.setColumns(10);
		
		JLabel inputError = new JLabel("");
		inputError.setForeground(Color.RED);
		inputError.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		inputError.setBounds(183, 734, 165, 26);
		p1.add(inputError);
		
		ArrayList proGram = tool.getPrograms();
		String [] programs = new String[proGram.size()];
		for (int x = 0; x < programs.length; x++){
			programs[x] = (String)proGram.get(x);
		}
			
		programBox = new JComboBox();
		programBox.setModel(new DefaultComboBoxModel(programs));
		programBox.setBounds(211, 177, 180, 26);
		p1.add(programBox);
		
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
				// Error handling
				// if the course entered by the user is empty
				// Error handling when courseName input is empty
				if (courseName.getText().isEmpty()){
					inputError.setText("Please enter valid name");
				}
				// if the id is empty
				else if (courseID.getText().isEmpty()){
					inputError.setText("Please enter valid ID");
				}
				// if the user did not enter a valid instructor
				else if(courseInstructor.getText().isEmpty()){
					inputError.setText("Please enter an Instructor");
				}
				// if the user did not enter proper start/end times
				else if(startTime.getText().isEmpty()){
					inputError.setText("Please enter valid start time");
				}
				else if(finishTime.getText().isEmpty()){
					inputError.setText("Please enter valid finish time");
				}
			    else{
						// Creates array for daysOffered
						ArrayList<String> days = new ArrayList<String>();
						if (monDay.isSelected()){
							days.add("Monday");
						}
						if (tuesDay.isSelected()){
							days.add("Tuesday");
						}
						if (wednesDay.isSelected()){
							days.add("Wednesday");
						}
						if (thursDay.isSelected()){
							days.add("Thursday");
						}
						if (friDay.isSelected()){
							days.add("Friday");
						}
						if (saturDay.isSelected()){
							days.add("Saturday");
						}
						tool.writeToCourse(courseName.getText(), courseID.getText(), (String)programBox.getSelectedItem(), courseLvl.getSelectedItem(),
								          courseInstructor.getText(), coursePreReq.getText(), days, startTime.getText(), finishTime.getText(), courseCredit.getSelectedItem(),
								          courseDesc.getText(), tool.getProgramCode((String)programBox.getSelectedItem()), (String)programBox.getSelectedItem());
						CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                                                cardLayout.show(contentPane, "mmf");
						
					}
				}
		});
		btnRegisterCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegisterCourse.setBounds(438, 731, 157, 35);
		p1.add(btnRegisterCourse);
		
		// GoBack button returns user to main menu
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBackground(Color.DARK_GRAY);
		btnGoBack.setForeground(Color.RED);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                                cardLayout.show(contentPane, "mmf");
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGoBack.setBounds(438, 21, 157, 35);
		p1.add(btnGoBack);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgram.setBounds(21, 179, 119, 26);
		p1.add(lblProgram);
		
		
		
		p1.add(addcbg);
		contentPane.add(p1);
                add(p1);
	}
}

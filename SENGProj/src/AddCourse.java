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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
* AddCourse form that allows staff users to add a course to system
* @author	TeddyKalp
* @version 	1.0
*/

public class AddCourse extends JFrame {
	
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
	
	private mainMenuForm menu;
	
	File file = new File("courseDB.txt");

	private RWTools tool = new RWTools();

	/**
	 * Launch the application.
	 */

	/**
	 * AddCourse constructor that creates the frame and adds its components.
	 * @param	user - staff user that is adding a course
	 */
	public AddCourse(String user) {
		
		// ERROR LABELS //
		
    	// Error label for input
    	instructorError = new JLabel("");
    	instructorError.setForeground(Color.RED);
    	instructorError.setFont(new Font("Tahoma", Font.PLAIN, 10));
    	instructorError.setBounds(90, 275, 123, 20);
    	getContentPane().add(instructorError);
		
		// course name label attributes
		nameError = new JLabel("");
		nameError.setForeground(Color.RED);
		nameError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nameError.setBounds(90, 74, 123, 20);
		getContentPane().add(nameError);
		
		// course description label attributes
		descError = new JLabel("");
		descError.setForeground(Color.RED);
		descError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		descError.setBounds(90, 340, 123, 20);
		getContentPane().add(descError);
		
		// course ID label attributes
		idError = new JLabel("");
		idError.setForeground(Color.RED);
		idError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		idError.setBounds(90, 185, 123, 20);
		getContentPane().add(idError);
		
		// start time label attributes
		stError = new JLabel("");
		stError.setForeground(Color.RED);
		stError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		stError.setBounds(529, 816, 121, 20);
		getContentPane().add(stError);
		
		// finish time label attributes
		ftError = new JLabel("");
		ftError.setForeground(Color.RED);
		ftError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ftError.setBounds(738, 816, 92, 20);
		getContentPane().add(ftError);
		setBounds(100, 100, 1040, 1050);
		
		// Closes window when the user exits the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		// Adds register course label
		JLabel RegisterCourseLabel = new JLabel("Register Course");
		RegisterCourseLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		RegisterCourseLabel.setBounds(486, 16, 200, 26);
		getContentPane().add(RegisterCourseLabel);
		
		// Adds course level label
		CLLabel = new JLabel("<html>Course Level<br>\r\n (E.g. 1 = First Year)<html>");
		CLLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CLLabel.setBounds(250, 115, 225, 44);
		getContentPane().add(CLLabel);
		
		// Adds course name label
		CTLabel = new JLabel("<html>Course Title<br>\r\n (E.g. Intro to Computer Science)<html>");
		CTLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CTLabel.setBounds(250, 53, 225, 51);
		getContentPane().add(CTLabel);
		
		// Adds course description label
		CDLabel = new JLabel("Course Description ");
		CDLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CDLabel.setBounds(250, 320, 119, 26);
		getContentPane().add(CDLabel);
		
		// Adds course ID label
		CILabel = new JLabel("Course ID (00-99)");
		CILabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CILabel.setBounds(250, 170, 119, 26);
		getContentPane().add(CILabel);
		
		// Adds Program Label
		PLabel = new JLabel("Program");
		PLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PLabel.setBounds(250, 219, 119, 26);
		getContentPane().add(PLabel);
		
		// Adds instructor label
		ILabel = new JLabel("Instructor");
		ILabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ILabel.setBounds(250, 275, 92, 26);
		getContentPane().add(ILabel);
		
		// Adds Prerequisite Courses label
		PCLabel = new JLabel("<html><p>Prerequisite \r\nCourses (Separate courses with a comma)<p><html>");
		PCLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PCLabel.setBounds(250, 409, 157, 51);
		getContentPane().add(PCLabel);
		
		// Adds Antirequisite Courses label
		ACLabel = new JLabel("<html><p>Antirequisite \r\nCourses (Separate courses with a comma)<p><html>");
		ACLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ACLabel.setBounds(250, 495, 157, 51);
		getContentPane().add(ACLabel);
		
		// Adds Corequisites Courses Label
		CCLabel = new JLabel("<html><p>Corequisite \r\nCourses (Separate courses with a comma)<p><html>");
		CCLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CCLabel.setBounds(250, 593, 157, 51);
		getContentPane().add(CCLabel);
		
		// Adds daysOffered selection
		DaysLabel = new JLabel("Days Offered");
		DaysLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DaysLabel.setBounds(250, 698, 200, 51);
		getContentPane().add(DaysLabel);
		
		// Start time label
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStartTime.setBounds(490, 776, 69, 26);
		getContentPane().add(lblStartTime);
		
		// Finish time label
		JLabel lblFinishTime = new JLabel("Finish Time");
		lblFinishTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFinishTime.setBounds(670, 776, 69, 26);
		getContentPane().add(lblFinishTime);
		
		// Course credits label
		CreditsLabel = new JLabel("Course Credits");
		CreditsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CreditsLabel.setBounds(250, 844, 92, 26);
		getContentPane().add(CreditsLabel);
		
		// USER INPUT //
		
		// Takes user input for course title/name
		courseName = new JTextField();
		courseName.setToolTipText("E.g. Introduction to Computer Science");
		courseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseName.setColumns(10);
		courseName.setBounds(525, 74, 200, 26);
		getContentPane().add(courseName);
		
		// Takes user input for course level from selection
		JComboBox courseLvl = new JComboBox();
		courseLvl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseLvl.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		courseLvl.setSelectedIndex(0);
		courseLvl.setBounds(525, 123, 200, 27);
		getContentPane().add(courseLvl);
		
		// Takes user input for course ID
		courseID = new JTextField();
		courseID.setBounds(525, 172, 200, 26);
		getContentPane().add(courseID);
		courseID.setColumns(10);
		
		// Gets list of programs
		ArrayList proGram = tool.getPrograms();
		String [] programs = new String[proGram.size()];
		for (int x = 0; x < programs.length; x++){
			programs[x] = (String)proGram.get(x);
		}
		
		// Program Selection from DropBox
		programBox = new JComboBox();
		programBox.setModel(new DefaultComboBoxModel(programs));
		programBox.setBounds(525, 221, 200, 26);
		getContentPane().add(programBox);
		
		// Takes user input for instructor
		courseInstructor = new JTextField();
		courseInstructor.setBounds(525, 277, 200, 26);
		getContentPane().add(courseInstructor);
		courseInstructor.setColumns(10);
		
		// Takes user input for course description
		JTextArea courseDesc = new JTextArea();
		courseDesc.setLineWrap(true);
		courseDesc.setBounds(525, 323, 220, 65);
		getContentPane().add(courseDesc);
		
		// Takes user input for course prerequisites
		JTextArea preReqs = new JTextArea();
		preReqs.setLineWrap(true);
		preReqs.setBounds(525, 407, 220, 65);
		getContentPane().add(preReqs);
		
		// Takes user input for course antirequisites
		JTextArea antiReqs = new JTextArea();
		antiReqs.setLineWrap(true);
		antiReqs.setBounds(525, 493, 220, 65);
		getContentPane().add(antiReqs);
		
		// Takes user input for course corequisites
		JTextArea coReqs = new JTextArea();
		coReqs.setLineWrap(true);
		coReqs.setBounds(525, 591, 220, 65);
		getContentPane().add(coReqs);
		
		// Radio buttons for daysOffered selection
		JRadioButton monDay = new JRadioButton("Monday");
		monDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		monDay.setBounds(525, 688, 80, 29);
		getContentPane().add(monDay);
		
		JRadioButton tuesDay = new JRadioButton("Tuesday");
		tuesDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tuesDay.setBounds(525, 720, 80, 29);
		getContentPane().add(tuesDay);
		
		JRadioButton wednesDay = new JRadioButton("Wednesday");
		wednesDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		wednesDay.setBounds(620, 688, 92, 29);
		getContentPane().add(wednesDay);
		
		JRadioButton thursDay = new JRadioButton("Thursday");
		thursDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		thursDay.setBounds(620, 720, 85, 29);
		getContentPane().add(thursDay);
		
		JRadioButton friDay = new JRadioButton("Friday");
		friDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		friDay.setBounds(730, 688, 130, 29);
		getContentPane().add(friDay);
		
		JRadioButton saturDay = new JRadioButton("Saturday");
		saturDay.setFont(new Font("Tahoma", Font.PLAIN, 10));
		saturDay.setBounds(730, 720, 130, 29);
		getContentPane().add(saturDay);
		
		// Time slot label
		TimeLabel = new JLabel("Time Slot");
		TimeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TimeLabel.setBounds(250, 776, 92, 26);
		getContentPane().add(TimeLabel);
		
		// Takes user input for start time
		startTime = new JTextField();
		startTime.setBounds(570, 776, 80, 32);
		getContentPane().add(startTime);
		startTime.setColumns(10);
		
		// Takes user input for finish time
		finishTime = new JTextField();
		finishTime.setColumns(10);
		finishTime.setBounds(750, 775, 80, 32);
		getContentPane().add(finishTime);
		
		// Takes user input for course credit from selection	
		JComboBox courseCredit = new JComboBox();
		courseCredit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseCredit.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4"}));
		courseCredit.setBounds(525, 844, 186, 26);
		getContentPane().add(courseCredit);
		
		// Submit button and its attributes
		AddCourse = new JButton("Submit");
		AddCourse.setBackground(Color.DARK_GRAY);
		AddCourse.setForeground(Color.GREEN);
		AddCourse.addActionListener(new ActionListener() {
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
					nameError.setText("Please enter valid name");
				}
				// if the id is empty
				else if (courseID.getText().isEmpty()){
					idError.setText("Please enter valid ID");
				}
				// if the user did not enter a valid instructor
				else if(courseInstructor.getText().isEmpty()){
					instructorError.setText("Please enter an Instructor");
				}
				// if the user did not enter proper start/end times
				else if(startTime.getText().isEmpty()){
					stError.setText("Please enter valid start time");
				}
				else if(finishTime.getText().isEmpty()){
					ftError.setText("Please enter valid finish time");
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
								          courseInstructor.getText(), preReqs.getText(), coReqs.getText(), antiReqs.getText(), days, startTime.getText(), finishTime.getText(), courseCredit.getSelectedItem(),
								          courseDesc.getText(), tool.getProgramCode((String)programBox.getSelectedItem()), (String)programBox.getSelectedItem());
						
						
						setVisible(false);
						// Returns user to main menu
						menu = new mainMenuForm(user);
						menu.setVisible(true);
					}
				}
		});
		AddCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		AddCourse.setBounds(645, 900, 157, 48);
		getContentPane().add(AddCourse);
		
		// GoBack button returns user to main menu
		back = new JButton("Go Back");
		back.setBackground(Color.DARK_GRAY);
		back.setForeground(Color.RED);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 15));
		back.setBounds(250,900,231,48);
		getContentPane().add(back);
		
	}
}

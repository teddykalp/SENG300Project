import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class editCourse extends JFrame {

	private JPanel contentPane;
	private mainMenuForm menu;
	private JTextField courseName, courseLvl, courseID, courseInstructor;
	private JTextField startTime, finishTime;
	private JTextArea coursePreReq, courseAntiReq, courseCoReq, daysOffered, courseCredit, courseDesc;
	private RWTools tool = new RWTools();
	private String oldName, oldLvl, oldID, oldProgram, oldInstructor, oldPreReq, oldAntiReq, oldCoReq, oldDaysOffered, oldCode,
		oldStart, oldFinish, oldCredit, oldDesc, oldDaysO;
	private String newName, newLvl, newID, newProgram, newInstructor, newPreReq, newAntiReq, newCoReq, newCode, newDays,
		newStart, newFinish, newCredit, newDesc;
	private List newDaysOffered;
	private String programName;
	private JTextField programCourse;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editCourse frame = new editCourse(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public editCourse(String user) {
		setBounds(100, 100, 1040, 1050);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList coursesL = tool.getCourses();
		String [] courses = new String[coursesL.size()];
		for (int x = 0; x < courses.length; x++){
			courses[x] = (String)coursesL.get(x);
		}
		
		JComboBox coursesSelect = new JComboBox();
		coursesSelect.setModel(new DefaultComboBoxModel(courses));
		coursesSelect.setBounds(525, 68, 216, 25);
		contentPane.add(coursesSelect);
		
		// ERROR LABELS
		
		// Error label for course name
		JLabel nameError = new JLabel("");
		nameError.setForeground(Color.RED);
		nameError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nameError.setBounds(100, 140, 123, 17);
		getContentPane().add(nameError);
		
		// Error label for course description
		JLabel descError = new JLabel("");
		descError.setForeground(Color.RED);
		descError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		descError.setBounds(100, 312, 123, 17);
		getContentPane().add(descError);
		
		// Error label for course ID
		JLabel idError = new JLabel("");
		idError.setForeground(Color.RED);
		idError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		idError.setBounds(100, 223, 123, 17);
		getContentPane().add(idError);
		
		// Error label for start time
		JLabel stError = new JLabel("");
		stError.setForeground(Color.RED);
		stError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		stError.setBounds(100, 636, 121, 17);
		getContentPane().add(stError);
		
		// Error label for finish time
		JLabel ftError = new JLabel("");
		ftError.setForeground(Color.RED);
		ftError.setFont(new Font("Tahoma", Font.PLAIN, 10));
		ftError.setBounds(100, 666, 92, 17);
		getContentPane().add(ftError);
		
		// FORM LABELS
		
		JLabel lblEditCourse = new JLabel("Edit Course");
		lblEditCourse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEditCourse.setBounds(486, 16, 200, 26);
		getContentPane().add(lblEditCourse);
		
		// Choose course label
		JLabel lblchooseCourse = new JLabel("Choose Course");
		lblchooseCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblchooseCourse.setBounds(250, 53, 225, 51);
		contentPane.add(lblchooseCourse);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProgram.setBounds(250, 94, 225, 44);
		contentPane.add(lblProgram);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseName.setBounds(250, 140, 119, 26);
		getContentPane().add(lblCourseName);
		
		JLabel lblCourseLvl = new JLabel("Course Level");
		lblCourseLvl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseLvl.setBounds(250, 177, 119, 26);
		getContentPane().add(lblCourseLvl);
		
		JLabel lblCourseId = new JLabel("Course ID (00-99)");
		lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseId.setBounds(250, 214, 119, 26);
		getContentPane().add(lblCourseId);
		
		JLabel lblInstructor = new JLabel("Instructor");
		lblInstructor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstructor.setBounds(250, 251, 119, 26);
		getContentPane().add(lblInstructor);
		
		JLabel lblCourseDescription = new JLabel("Course Description ");
		lblCourseDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseDescription.setBounds(250, 297, 157, 32);
		getContentPane().add(lblCourseDescription);
	
		JLabel lblCoursePrereqs = new JLabel("<html><p>Prerequisite \r\nCourses (Seperate courses with a comma)<p><html>");
		lblCoursePrereqs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCoursePrereqs.setBounds(250, 386, 213, 51);
		getContentPane().add(lblCoursePrereqs);
		
		JLabel lblCourseAntireqs = new JLabel("<html><p>Antirequisite \r\nCourses (Seperate courses with a comma)<p><html>");
		lblCourseAntireqs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseAntireqs.setBounds(250, 456, 213, 51);
		getContentPane().add(lblCourseAntireqs);

		JLabel lblCourseCoreqs = new JLabel("<html><p>Corequisite \r\nCourses (Seperate courses with a comma)<p><html>");
		lblCourseCoreqs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseCoreqs.setBounds(250, 518, 200, 51);
		getContentPane().add(lblCourseCoreqs);
		
		JLabel lblDaysThisCourse = new JLabel("Days offered");
		lblDaysThisCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDaysThisCourse.setBounds(250, 580, 162, 51);
		getContentPane().add(lblDaysThisCourse);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStartTime.setBounds(513, 652, 69, 26);
		getContentPane().add(lblStartTime);
		
		JLabel lblFinishTime = new JLabel("Finish Time");
		lblFinishTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFinishTime.setBounds(673, 652, 69, 26);
		getContentPane().add(lblFinishTime);
		
		JLabel lblTimeslot = new JLabel("Time Slot");
		lblTimeslot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimeslot.setBounds(250, 652, 92, 26);
		getContentPane().add(lblTimeslot);
		
		courseName = new JTextField();
		courseName.setEditable(false);
		courseName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		courseName.setColumns(10);
		courseName.setBounds(525, 141, 216, 26);
		getContentPane().add(courseName);
		
		courseLvl = new JTextField();
		courseLvl.setEditable(false);
		courseLvl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseLvl.setColumns(10);
		courseLvl.setBounds(525, 177, 72, 26);
		getContentPane().add(courseLvl);
		
		courseID = new JTextField();
		courseID.setEditable(false);
		courseID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseID.setColumns(10);
		courseID.setBounds(525, 214, 186, 26);
		contentPane.add(courseID);
		
		startTime = new JTextField();
		startTime.setEditable(false);
		startTime.setBounds(583, 651, 80, 32);
		getContentPane().add(startTime);
		startTime.setColumns(10);
		
		finishTime = new JTextField();
		finishTime.setEditable(false);
		finishTime.setColumns(10);
		finishTime.setBounds(746, 651, 80, 32);
		getContentPane().add(finishTime);
		
		JLabel lblCourseCredits = new JLabel("Course Credits");
		lblCourseCredits.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseCredits.setBounds(250, 713, 92, 26);
		getContentPane().add(lblCourseCredits);
		
		courseCredit = new JTextArea();
		courseCredit.setEditable(false);
		courseCredit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseCredit.setBounds(525, 712, 72, 26);
		getContentPane().add(courseCredit);
		
		coursePreReq = new JTextArea();
		coursePreReq.setEditable(false);
		coursePreReq.setLineWrap(true);
		JScrollPane coursePrereqScroll = new JScrollPane (coursePreReq, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		coursePrereqScroll.setBounds(525, 384, 216, 50);
		getContentPane().add(coursePrereqScroll);
		
		courseAntiReq = new JTextArea();
		courseAntiReq.setEditable(false);
		courseAntiReq.setLineWrap(true);
		JScrollPane courseAntireqScroll = new JScrollPane (courseAntiReq, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		courseAntireqScroll.setBounds(525, 447, 216, 50);
		getContentPane().add(courseAntireqScroll);
		
		courseCoReq = new JTextArea();
		courseCoReq.setEditable(false);
		courseCoReq.setLineWrap(true);
		JScrollPane courseCoreqScroll = new JScrollPane (courseCoReq, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		courseCoreqScroll.setBounds(525, 511, 216, 50);
		getContentPane().add(courseCoreqScroll);
		
		courseDesc = new JTextArea();
		courseDesc.setEditable(false);
		courseDesc.setLineWrap(true);
		JScrollPane courseDescScroll = new JScrollPane (courseDesc, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		courseDescScroll.setBounds(525, 303, 216, 70);
		getContentPane().add(courseDescScroll);
		
		ArrayList proGram = tool.getPrograms();
		String [] programs = new String[proGram.size()];
		for (int x = 0; x < programs.length; x++){
			programs[x] = (String)proGram.get(x);
		}
		
		courseInstructor = new JTextField();
		courseInstructor.setEditable(false);
		courseInstructor.setBounds(525, 253, 186, 27);
		getContentPane().add(courseInstructor);
		courseInstructor.setColumns(10);
		
		daysOffered = new JTextArea();
		daysOffered.setEditable(false);
		JScrollPane daysOfferedScroll = new JScrollPane (daysOffered, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		daysOfferedScroll.setBounds(525, 578, 216, 51);
		contentPane.add(daysOfferedScroll);
		daysOffered.setColumns(10);
		
		programCourse = new JTextField();
		programCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		programCourse.setEditable(false);
		programCourse.setColumns(10);
		programCourse.setBounds(525, 104, 216, 26);
		contentPane.add(programCourse);
		
		
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Displays Course info on UI
				courseName.setEditable(true);
				courseLvl.setEditable(true);
				startTime.setEditable(true);
				finishTime.setEditable(true);
				courseCredit.setEditable(true);
				coursePreReq.setEditable(true);
				courseAntiReq.setEditable(true);
				courseCoReq.setEditable(true);
				courseDesc.setEditable(true);
				daysOffered.setEditable(true);
				courseInstructor.setEditable(true);
				courseID.setEditable(true);
				programCourse.setEditable(true);
				
				ArrayList courseInfo = tool.getCourseInfo((String)coursesSelect.getSelectedItem());
				String courseCode = ((String)courseInfo.get(0));
				StringBuilder prgCode = new StringBuilder();
				String level = "";
				StringBuilder courseNum = new StringBuilder();
				for (int i = 0; i < courseCode.length(); i++)
				{
					if(i < 4) {
						prgCode.append(courseCode.charAt(i));
					}
					else if(i == 4) { level = "" + courseCode.charAt(i); }
					else { courseNum.append(courseCode.charAt(i)); }
				}
				String codes;
				int index = -1;
				for(int j = 0; j < (tool.getPrograms()).size(); j++) {
					codes = (tool.getProgramCode((String)tool.getPrograms().get(j)));
					if(codes.equals(prgCode.toString()))
					{
						index = j;
					}
				}
				/* setting the text boxes in the GUI to show existing data for
				 * selected course
				 */
				courseName.setText((String)coursesSelect.getSelectedItem());
				courseLvl.setText(level);
				courseID.setText(courseNum.toString());
				courseInstructor.setText((String)courseInfo.get(1));
				coursePreReq.setText((String)courseInfo.get(2));
				courseAntiReq.setText((String)courseInfo.get(3));
				courseCoReq.setText((String)courseInfo.get(4));
				daysOffered.setText((String)courseInfo.get(5));
				startTime.setText((String)courseInfo.get(6));
				finishTime.setText((String)courseInfo.get(7));
				courseCredit.setText((String)courseInfo.get(8));
				courseDesc.setText((String)courseInfo.get(9));
				programCourse.setText((String)courseInfo.get(10));
				/*
				 * saving old course information for modification
				 */
				oldName = (String)coursesSelect.getSelectedItem();
				oldLvl = level;
				oldID = courseNum.toString();
				
				oldCode = oldLvl + oldID + oldProgram;
				oldInstructor = (String)courseInfo.get(1);
				oldPreReq = (String)courseInfo.get(2);
				oldAntiReq = (String)courseInfo.get(3);
				oldCoReq = (String)courseInfo.get(4);
				oldDaysOffered = (String)courseInfo.get(5);
				oldStart = (String)courseInfo.get(6);
				oldFinish = (String)courseInfo.get(7);
				oldCredit = (String)courseInfo.get(8);
				oldDesc = (String)courseInfo.get(9);
				oldProgram = (String)courseInfo.get(10);
				
				List<String> oldDays = new ArrayList<String>();
				oldDays = Arrays.asList(oldDaysOffered.split("\\s*,\\s*"));
				StringBuilder dayso = new StringBuilder();
				for(int i = 0; i < oldDays.size(); i++) {
					dayso.append(oldDays.get(i));
					dayso.append("\n");
				}
				oldDaysO = (dayso.toString()).trim();
				
				
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setBounds(780, 66, 92, 25);
		contentPane.add(btnEdit);
		
		JButton btnSaveCourse = new JButton("Commit Changes");
		btnSaveCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (courseName.getText().isEmpty()){
					nameError.setText("Please enter valid name");
				}else{
						List<String> days = new ArrayList<String>();
						String ds = daysOffered.getText();
						days = Arrays.asList(ds.split("\\s*,\\s*"));
						
						newName = courseName.getText();
						newLvl = courseLvl.getText();
						newID = courseID.getText();
						newProgram = programCourse.getText();
						newInstructor = courseInstructor.getText();
						newPreReq = coursePreReq.getText();
						newAntiReq = courseAntiReq.getText();
						newCoReq = courseCoReq.getText();
						newDaysOffered = days;
						newStart = startTime.getText();
						newFinish = finishTime.getText();
						newCredit = courseCredit.getText();
						newDesc = courseDesc.getText();
						
						if(!newLvl.equals(oldLvl) || !newID.equals(oldID) || !newProgram.equals(oldProgram))
						{
							newCode = newProgram + newLvl + newID;
						}
						
						StringBuilder day = new StringBuilder();
						for(int i = 0; i < days.size(); i++) {
							day.append(days.get(i));
							day.append("\n");
						}
						newDays = (day.toString()).trim();
						
						
						String dbName = "COURSE NAME: ";
						String dbCode = "COURSE CODE: ";
						String dbInstructor = "COURSE INSTRUCTOR: ";
						String dbPreReq = "PREREQUISITE COURSES: ";
						String dbAntiReq = "ANTIREQUISITE COURSES: ";
						String dbCoReq = "COREQUISITE COURSES: ";
						String dbStart = "START TIME: ";
						String dbFinish = "FINISH TIME: ";
						String dbCredits = "COURSE CREDITS: ";
						String dbCourseD = "COURSE DESCRIPTION: ";
						String dbProgram = "PROGRAM: ";
						String db = "courseDB.txt";
						
						tool.editDB(dbName + oldName, dbName + newName, db);
						tool.editDB(dbCode + oldCode, dbCode + newCode, db);
						tool.editDB(dbInstructor + oldInstructor, dbInstructor + newInstructor, db);
						tool.editDB(dbPreReq + oldPreReq,dbPreReq + newPreReq, db);
						tool.editDB(dbAntiReq + oldAntiReq,dbAntiReq + newAntiReq, db);
						tool.editDB(dbCoReq + oldCoReq,dbCoReq + newCoReq, db);
						tool.editDB(oldDaysO, newDays, db);
						tool.editDB(dbStart + oldStart, dbStart + newStart, db);
						tool.editDB(dbFinish + oldFinish, dbFinish + newFinish, db);
						tool.editDB(dbCredits + oldCredit, dbCredits + newCredit, db);
						tool.editDB(dbCourseD + oldDesc, dbCourseD + newDesc, db);
						tool.editDB(dbProgram + oldProgram, dbProgram + newProgram, db);

						setVisible(false);
						menu = new mainMenuForm(user);
						menu.setVisible(true);
					}
				}
		});
		btnSaveCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSaveCourse.setBackground(Color.DARK_GRAY);
		btnSaveCourse.setForeground(Color.GREEN);
		btnSaveCourse.setBounds(669, 810, 157, 48);
		getContentPane().add(btnSaveCourse);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(250,810,167,48);
		getContentPane().add(btnCancel);
		
		
	}
}


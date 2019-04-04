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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class editCourse extends JFrame {

	private JPanel contentPane;
	private mainMenuForm menu;
	private JTextField courseName, courseLvl, courseID, courseInstructor;
	private JTextField startTime, finishTime;
	private JComboBox programBox;
	private JTextArea coursePreReq, daysOffered, courseCredit, courseDesc;
	private RWTools tool = new RWTools();
	private String oldName, oldLvl, oldID, oldProgram, oldInstructor, oldPreReq, oldDaysOffered, oldCode,
		oldStart, oldFinish, oldCredit, oldDesc, oldDaysO;
	private String newName, newLvl, newID, newProgram, newInstructor, newPreReq, newCode, newDays,
		newStart, newFinish, newCredit, newDesc;
	private List newDaysOffered;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseDisplay frame = new courseDisplay(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public editCourse(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList coursesL = tool.getCourses();
		String [] courses = new String[coursesL.size()];
		for (int x = 0; x < courses.length; x++){
			courses[x] = (String)coursesL.get(x);
		}
		
		JComboBox coursesSelect = new JComboBox();
		coursesSelect.setModel(new DefaultComboBoxModel(courses));
		coursesSelect.setBounds(211, 88, 216, 25);
		contentPane.add(coursesSelect);
		
		JLabel lblchooseCourse = new JLabel("Choose Course");
		lblchooseCourse.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		lblchooseCourse.setBounds(21, 86, 115, 26);
		contentPane.add(lblchooseCourse);
		
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
		
		JLabel lblAddCourse = new JLabel("Register Course");
		lblAddCourse.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAddCourse.setBounds(221, 16, 165, 26);
		getContentPane().add(lblAddCourse);
		
		JLabel lblNewLabel = new JLabel("Course Level");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 170, 92, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseName.setBounds(21, 131, 92, 26);
		getContentPane().add(lblCourseName);
		
		JLabel lblCourseDescription = new JLabel("Course Description ");
		lblCourseDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseDescription.setBounds(21, 603, 119, 26);
		getContentPane().add(lblCourseDescription);
		
		JLabel lblCourseId = new JLabel("Course ID (00-99)");
		lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseId.setBounds(21, 210, 119, 26);
		getContentPane().add(lblCourseId);
		
		JLabel lblInstructor = new JLabel("<html><p>Prerequisite \r\nCourses (Seperate courses with a comma)<p><html>");
		lblInstructor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInstructor.setBounds(21, 347, 157, 51);
		getContentPane().add(lblInstructor);
		
		JLabel label = new JLabel("Instructor");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(21, 299, 92, 26);
		getContentPane().add(label);
		
		JLabel lblDaysThisCourse = new JLabel("<html><p>Days this Course will be offered<p><html>");
		lblDaysThisCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDaysThisCourse.setBounds(21, 431, 102, 51);
		getContentPane().add(lblDaysThisCourse);
		
		courseName = new JTextField();
		courseName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseName.setColumns(10);
		courseName.setBounds(211, 132, 186, 26);
		getContentPane().add(courseName);
		
		courseLvl = new JTextField();
		courseLvl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseLvl.setColumns(10);
		courseLvl.setBounds(265, 170, 72, 26);
		getContentPane().add(courseLvl);
		
		courseID = new JTextField();
		courseID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		courseID.setColumns(10);
		courseID.setBounds(211, 210, 186, 26);
		contentPane.add(courseID);
		
		JLabel lblTimeslot = new JLabel("Time Slot");
		lblTimeslot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTimeslot.setBounds(21, 503, 92, 26);
		getContentPane().add(lblTimeslot);
		
		startTime = new JTextField();
		startTime.setBounds(196, 503, 80, 32);
		getContentPane().add(startTime);
		startTime.setColumns(10);
		
		finishTime = new JTextField();
		finishTime.setColumns(10);
		finishTime.setBounds(371, 503, 80, 32);
		getContentPane().add(finishTime);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStartTime.setBounds(116, 503, 69, 26);
		getContentPane().add(lblStartTime);
		
		JLabel lblFinishTime = new JLabel("Finish Time");
		lblFinishTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFinishTime.setBounds(291, 503, 69, 26);
		getContentPane().add(lblFinishTime);
		
		JLabel lblCourseCredits = new JLabel("Course Credits");
		lblCourseCredits.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourseCredits.setBounds(21, 556, 92, 26);
		getContentPane().add(lblCourseCredits);
		
		courseCredit = new JTextArea();
		courseCredit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		courseCredit.setBounds(265, 553, 72, 26);
		getContentPane().add(courseCredit);
		
		coursePreReq = new JTextArea();
		coursePreReq.setLineWrap(true);
		coursePreReq.setBounds(211, 345, 216, 65);
		getContentPane().add(coursePreReq);
		
		courseDesc = new JTextArea();
		courseDesc.setLineWrap(true);
		courseDesc.setBounds(183, 600, 244, 113);
		getContentPane().add(courseDesc);
		
		ArrayList proGram = tool.getPrograms();
		String [] programs = new String[proGram.size()];
		for (int x = 0; x < programs.length; x++){
			programs[x] = (String)proGram.get(x);
		}
			
		programBox = new JComboBox();
		programBox.setModel(new DefaultComboBoxModel(programs));
		programBox.setBounds(211, 255, 180, 26);
		getContentPane().add(programBox);
		
		courseInstructor = new JTextField();
		courseInstructor.setBounds(211, 299, 186, 27);
		getContentPane().add(courseInstructor);
		courseInstructor.setColumns(10);
		
		daysOffered = new JTextArea();
		daysOffered.setBounds(211, 431, 216, 51);
		contentPane.add(daysOffered);
		daysOffered.setColumns(10);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(448, 88, 92, 25);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Displays Course info on UI
				
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
				
				programBox.setSelectedIndex(index);
				courseName.setText((String)coursesSelect.getSelectedItem());
				courseLvl.setText(level);
				courseID.setText(courseNum.toString());
				courseInstructor.setText((String)courseInfo.get(1));
				coursePreReq.setText((String)courseInfo.get(2));
				daysOffered.setText((String)courseInfo.get(3));
				startTime.setText((String)courseInfo.get(4));
				finishTime.setText((String)courseInfo.get(5));
				courseCredit.setText((String)courseInfo.get(6));
				courseDesc.setText((String)courseInfo.get(7));		
				
				oldName = (String)coursesSelect.getSelectedItem();
				oldLvl = level;
				oldID = courseNum.toString();
				oldProgram = (String)programBox.getSelectedItem();
				oldCode = oldLvl + oldID + oldProgram;
				oldInstructor = (String)courseInfo.get(1);
				oldPreReq = (String)courseInfo.get(2);
				oldDaysOffered = (String)courseInfo.get(3);
				oldStart = (String)courseInfo.get(4);
				oldFinish = (String)courseInfo.get(5);
				oldCredit = (String)courseInfo.get(6);
				oldDesc = (String)courseInfo.get(7);
				
				List<String> oldDays = new ArrayList<String>();
				oldDays = Arrays.asList(oldDaysOffered.split("\\s*,\\s*"));
				StringBuilder dayso = new StringBuilder();
				for(int i = 0; i < oldDays.size(); i++) {
					dayso.append(oldDays.get(i));
					dayso.append("\n");
				}
				oldDaysO = (dayso.toString()).trim();
				System.out.println(oldDaysO);
				
			}
		});
		contentPane.add(btnEdit);
		
				
		
		JButton btnSaveCourse = new JButton("Commit Changes");
		btnSaveCourse.setForeground(Color.BLACK);
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
						newProgram = tool.getProgramCode((String)programBox.getSelectedItem());
						newInstructor = courseInstructor.getText();
						newPreReq = coursePreReq.getText();
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
						System.out.println(newDays);
						
						tool.editCourse(oldName, newName);
						tool.editCourse(oldCode, newCode);
						tool.editCourse(oldInstructor, newInstructor);
						tool.editCourse(oldPreReq, newPreReq);
						tool.editCourse(oldDaysO, newDays);
						tool.editCourse(oldStart, newStart);
						tool.editCourse(oldFinish, newFinish);
						tool.editCourse(oldCredit, newCredit);
						tool.editCourse(oldDesc, newDesc);

						setVisible(false);
						menu = new mainMenuForm(user);
						menu.setVisible(true);
					}
				}
		});
		btnSaveCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSaveCourse.setBounds(221, 731, 157, 35);
		getContentPane().add(btnSaveCourse);
		
		JButton btnGoBack = new JButton("Cancel");
		btnGoBack.setForeground(Color.BLACK);
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
		lblProgram.setBounds(21, 254, 119, 26);
		getContentPane().add(lblProgram);
		
		
	}
}


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;



public class CourseCalendar extends JFrame {

	private JPanel contentPane;
	private mainMenuForm menu;
	private RWTools tool = new RWTools();
	private LoginForm loginForm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseCalendar frame = new CourseCalendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/*
	 * Create the application
	 */
	public CourseCalendar() {
		initialize();
	}
	
	/**
	 * Create the frame.
	 */
	public void initialize() {
		setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// add university logo to pane
		JLabel lblLogo = new JLabel(" ");
		Image img = new ImageIcon(this.getClass().getResource("/University of Winnipeg-logo.png")).getImage();
		img = img.getScaledInstance(200, 100, 0);
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(360, 5, 200, 100);
		getContentPane().add(lblLogo);
		
		// add and initialize go back button for login screen
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				loginForm = new LoginForm();
				loginForm.setVisible(true);
				
			}
		});
		btnGoBack.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnGoBack.setBounds(783, 11, 89, 23);
		contentPane.add(btnGoBack);
		
		// label for selecting program from combobox
		JLabel selectProgLabel = new JLabel("Select a program:");
		selectProgLabel.setBounds(22, 187, 114, 18);
		selectProgLabel.setBackground(new Color(105, 105, 105));
		selectProgLabel.setForeground(new Color(105, 105, 105));
		selectProgLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		// title for jframe
		JLabel titleLabel = new JLabel("Course Calendar");
		titleLabel.setBounds(10, 116, 864, 48);
		titleLabel.setBackground(new Color(119, 136, 153));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(112, 128, 144));
		titleLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 26));
		
		JSeparator separator = new JSeparator();
		
		// text areas for all classes for a given program
		JTextArea txtrEnterCourses = new JTextArea();
		
		txtrEnterCourses.setBounds(408, 423, 416, 286);
		txtrEnterCourses.setBackground(new Color(245, 245, 245));
		txtrEnterCourses.setWrapStyleWord(true);
		txtrEnterCourses.setLineWrap(true);
		txtrEnterCourses.setFont(new Font("Dialog", Font.PLAIN, 14));

		// create an array that gets all the programs in the database
		ArrayList progList = tool.getPrograms();
		String [] programs = new String[progList.size()];
		for(int i = 0; i < programs.length; i++) {
			programs[i] = (String)progList.get(i);
		}
		
		// create combo box for user to select a given program
		JComboBox selectProgComboBox = new JComboBox();
		selectProgComboBox.setModel(new DefaultComboBoxModel(programs));
		selectProgComboBox.setBounds(148, 184, 255, 27);
		selectProgComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		// program level label
		JLabel lblProgCode = new JLabel("Program Code: ");
		lblProgCode.setBounds(22, 238, 114, 28);
		lblProgCode.setFont(new Font("Dialog", Font.BOLD, 14));
		
		// program type label
		JLabel lblDeptName = new JLabel("Department: ");
		lblDeptName.setBounds(22, 277, 90, 27);
		lblDeptName.setFont(new Font("Dialog", Font.BOLD, 14));
		
		// program description label
		JLabel lblProgramLvl = new JLabel("Program Level: ");
		lblProgramLvl.setBounds(350, 279, 116, 23);
		lblProgramLvl.setFont(new Font("Dialog", Font.BOLD, 14));
		
		// department label
		JLabel lblProgType = new JLabel("Program Type: ");
		lblProgType.setBounds(350, 311, 116, 32);
		lblProgType.setFont(new Font("Dialog", Font.BOLD, 14));
		
		// required gpa label
		JLabel lblGpa = new JLabel("Required GPA: ");
		lblGpa.setBounds(23, 315, 113, 27);
		lblGpa.setFont(new Font("Dialog", Font.BOLD, 14));
		
		// sub-heading label
		JLabel lblRequiredCourses = new JLabel("Required Courses");
		lblRequiredCourses.setBounds(22, 380, 198, 24);
		lblRequiredCourses.setHorizontalAlignment(SwingConstants.LEFT);
		lblRequiredCourses.setForeground(new Color(112, 128, 144));
		lblRequiredCourses.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 353, 850, 16);
		
		// Program description result
		JLabel labelProgCodeResult = new JLabel("E.g. MATH");
		labelProgCodeResult.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		labelProgCodeResult.setBounds(135, 239, 152, 27);
		contentPane.add(labelProgCodeResult);
		
		// Department result
		JLabel labelDepResult = new JLabel("E.g. Math");
		labelDepResult.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		labelDepResult.setBounds(117, 277, 170, 27);
		contentPane.add(labelDepResult);
		
		// Program Description Result
		JLabel labelProgLvlResult = new JLabel("E.g. Bachelor's");
		labelProgLvlResult.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		labelProgLvlResult.setBounds(463, 279, 190, 23);
		contentPane.add(labelProgLvlResult);
		
		// Program Type Result
		JLabel labelProgTypeResult = new JLabel("Bachelor of Science");
		labelProgTypeResult.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		labelProgTypeResult.setBounds(463, 310, 170, 34);
		contentPane.add(labelProgTypeResult);
		
		// GPA Result
		JLabel labelGPAResult = new JLabel("E.g. 3.2");
		labelGPAResult.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		labelGPAResult.setBounds(137, 313, 93, 29);
		contentPane.add(labelGPAResult);

		
		JLabel lblProgramDescription = new JLabel("Program Description: ");
		lblProgramDescription.setFont(new Font("Dialog", Font.BOLD, 14));
		lblProgramDescription.setBounds(350, 238, 152, 28);
		contentPane.add(lblProgramDescription);
		
		JLabel lblProgramDescriptionResult = new JLabel("This program is for...");
		lblProgramDescriptionResult.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblProgramDescriptionResult.setBounds(506, 239, 368, 27);
		contentPane.add(lblProgramDescriptionResult);
		
		JLabel lblSelectedCourse = new JLabel("Selected Course");
		lblSelectedCourse.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectedCourse.setForeground(new Color(112, 128, 144));
		lblSelectedCourse.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSelectedCourse.setBounds(408, 380, 198, 24);
		contentPane.add(lblSelectedCourse);
		
		
		// add course ArrayList to JList 
		// list to display all the courses of a given program
		DefaultListModel model = new DefaultListModel();
		JList list = new JList(model);
		list.setBackground(new Color(245, 245, 245));
		list.setFont(new Font("Dialog", Font.PLAIN, 14));
		model.addElement("");
		list.setBounds(22, 424, 337, 410);
		contentPane.add(list);
//		JScrollPane pane = new JScrollPane(list);
		String[] courseTemplate = {"Course Code: ", "Instructor: ", "Prequisites: ", "Days Offered: ", "Start Time: ", 
									"Finish Time: ", "Course Credits: ", "Course Description: ", "Program: "};
		list.addMouseListener(new MouseAdapter() {
			   public void mouseClicked(MouseEvent evt) {
				    txtrEnterCourses.setText("");
			        JList list = (JList)evt.getSource();
			        if (evt.getClickCount() == 2) {

			            // Double-click detected
			        	System.out.println("double click");
			            int index = list.locationToIndex(evt.getPoint());
			            System.out.println("index: " + index);
			            // get the index of the course and set text area based on getCourse Info
			            String s = (String) list.getSelectedValue();
			            System.out.println("s: " + s);
			            
			            ArrayList courseInfo = tool.getCourseInfo(s);
			            for(int i = 0; i < courseInfo.size(); i++) {
			            	txtrEnterCourses.append(courseTemplate[i] + " ");
			            	txtrEnterCourses.append(courseInfo.get(i) + "\n");
			            }
			            System.out.println("courseInfo from s: " + courseInfo);
			            // now we want to display that course info (based on s) into the text area
			            
			        }   

			    }
		});
		
		
		// display all the info on user interface
		JButton btnGoButton = new JButton("Go");
		btnGoButton.setBounds(408, 183, 58, 29);
		btnGoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//get info from RW tools class
				String selectedCourse = (String)selectProgComboBox.getSelectedItem();			
//				System.out.println("Selected course: " + selectedCourse);
				
//				ArrayList programInfo = tool.getCourseCalProgramInfo(selectedCourse);
				//System.out.println(programInfo.get(1));
				
				ArrayList programInfo = tool.getProgramInfo(selectedCourse);
				System.out.println("programInfo: " + programInfo );
				
				// getting program info from the combo box and setting the fields based on selected program
				for (int i = 0; i < programInfo.size(); i ++) {
					//System.out.println("getting program info: " + programInfo.get(i));
					if (i == 0) 
						labelProgCodeResult.setText((String) programInfo.get(i)); 
					if (i == 1) 
						lblProgramDescriptionResult.setText((String) programInfo.get(i)); 
					if(i == 2)
						labelDepResult.setText((String) programInfo.get(i));
					if (i == 2) 
						labelProgLvlResult.setText((String) programInfo.get(i)); 
					if (i == 3) 
						labelProgTypeResult.setText((String) programInfo.get(i)); 
					if (i == 4)
						labelGPAResult.setText((String) programInfo.get(i)); 

				}
				
				// get program code from combo box 
				txtrEnterCourses.setText("");
				String programCode = tool.getProgramCode((String)selectProgComboBox.getSelectedItem());
				System.out.println("programCode " + programCode);
		
				
				
				// create an array list to get all courses based on selected program
				ArrayList courses = tool.getCourseName(programCode);
				// sort the array in ascending order
//				Collections.sort(courses);
				
				// trying something new
				ArrayList coursesL = tool.getCourses();
				String [] coursesList = new String[coursesL.size()];
				for (int x = 0; x < coursesList.length; x++){
					coursesList[x] = (String)coursesL.get(x);
				
					// adding course codes to the list for user to select
					model.addElement(coursesList[x]);
//					System.out.println("coursesList: " + coursesList[x]);
				}
				//
				
				
//				String[] courseTemplate = {"Instructor: ", "Prerequisites: ", "Days Offered: ", "Start Time: ", "Finish Time: ", "Course Credits: ", "Course Description: ", "Program: ", ""};
				System.out.println("CourseCal * courses ArrayList from getCourseName: " + courses);
				
				// adding course codes to the list for user to select
//				for(int i = 0; i < courses.size(); i+=2) {
////					model.addElement("test!!");
//					model.addElement(courses.get(i) + "\n");
//				}

				
//				System.out.println("SORTED/FILTERED courses ArrayList: " + courses);
//				for(int i = 0; i < courses.size(); i+=2) {
//					txtrEnterCourses.append((String)courses.get(i) + "\n");
//					
//					// now we need to get course information for each course in courses array
////					System.out.println("1. Courses " + courses);
//					
//					///// NOT WORKING HERE !!!!!!!!!!
//					String courseIndex = (String) courses.get(i);
////					System.out.println("courseIndex " + courseIndex);
//				
//					ArrayList courseInfo = tool.getCalCourseInfo(courseIndex);
////					System.out.println("courseInfo ArrayList " + courseInfo);
//					System.out.println(courseInfo);
//					
//					for(int j = 0; j < courseInfo.size(); j++) {
//						txtrEnterCourses.append(courseTemplate[j] + " ");
//						txtrEnterCourses.append((String)courseInfo.get(j) + " \n");
//					}
//					txtrEnterCourses.append("\n\n");
//				}
//				
				
				
				
			}
		});
		btnGoButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		contentPane.add(btnGoButton);
		
		// add elements to content pane 
		contentPane.setLayout(null);
		contentPane.add(selectProgComboBox);
		contentPane.add(lblLogo);
		contentPane.add(selectProgLabel);
		contentPane.add(lblRequiredCourses);
		contentPane.add(separator_1);
		contentPane.add(txtrEnterCourses);
		contentPane.add(lblProgCode);
		contentPane.add(lblDeptName);
		contentPane.add(lblGpa);
		contentPane.add(lblProgType);
		contentPane.add(lblProgramLvl);
//		contentPane.add(programInfoArea);
		contentPane.add(titleLabel);


		

		

		


		
	}
}

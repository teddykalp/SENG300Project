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
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;



public class CalBackup extends JFrame {

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
	public CalBackup() {
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
		
		// label for selecting program from combobox
		JLabel selectProgLabel = new JLabel("Select a program:");
		selectProgLabel.setBounds(22, 170, 114, 18);
		selectProgLabel.setBackground(new Color(105, 105, 105));
		selectProgLabel.setForeground(new Color(105, 105, 105));
		selectProgLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		// title for jframe
		JLabel titleLabel = new JLabel("Course Calendar");
		titleLabel.setBounds(11, 104, 881, 48);
		titleLabel.setBackground(new Color(119, 136, 153));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(112, 128, 144));
		titleLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 26));
		
		JSeparator separator = new JSeparator();
		
		// text areas for all classes for a given program
		JTextArea txtrEnterCourses = new JTextArea();
		
		txtrEnterCourses.setBounds(299, 340, 327, 499);
		txtrEnterCourses.setBackground(new Color(245, 245, 245));
		txtrEnterCourses.setWrapStyleWord(true);
		txtrEnterCourses.setText("Enter courses here...");
		txtrEnterCourses.setLineWrap(true);
		txtrEnterCourses.setFont(new Font("Dialog", Font.PLAIN, 11));

		// create an array that gets all the programs in the database
		ArrayList progList = tool.getPrograms();
		String [] programs = new String[progList.size()];
		for(int i = 0; i < programs.length; i++) {
			programs[i] = (String)progList.get(i);
		}
		
		// create combo box for user to select a given program
		JComboBox selectProgComboBox = new JComboBox();
		selectProgComboBox.setModel(new DefaultComboBoxModel(programs));
		selectProgComboBox.setBounds(148, 167, 255, 27);
		selectProgComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		// program level label
		JLabel lblProgramDes = new JLabel("Program Description:");
		lblProgramDes.setBounds(22, 215, 141, 18);
		lblProgramDes.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		// program type label
		JLabel lblDept = new JLabel("Department: ");
		lblDept.setBounds(22, 241, 90, 18);
		lblDept.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		// program description label
		JLabel lblProgramLvl = new JLabel("Program Level: ");
		lblProgramLvl.setBounds(22, 266, 114, 18);
		lblProgramLvl.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		// department label
		JLabel lblProgType = new JLabel("Program Type: ");
		lblProgType.setBounds(466, 219, 99, 18);
		lblProgType.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		// required gpa label
		JLabel lblRequiredGpa = new JLabel("Required GPA: ");
		lblRequiredGpa.setBounds(466, 243, 99, 18);
		lblRequiredGpa.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		// sub-heading label
		JLabel lblRequiredCourses = new JLabel("Required Courses");
		lblRequiredCourses.setBounds(22, 315, 198, 24);
		lblRequiredCourses.setHorizontalAlignment(SwingConstants.LEFT);
		lblRequiredCourses.setForeground(new Color(112, 128, 144));
		lblRequiredCourses.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 297, 850, 16);
		
		// Program description result
		JLabel labelProgDesResult = new JLabel("program description");
		labelProgDesResult.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		labelProgDesResult.setBounds(158, 212, 152, 27);
		contentPane.add(labelProgDesResult);
		
		// Department result
		JLabel labelDepResult = new JLabel("");
		labelDepResult.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		labelDepResult.setBounds(108, 241, 327, 18);
		contentPane.add(labelDepResult);
		
		// Program Description Result
		JLabel labelProgDescResult = new JLabel("program level");
		labelProgDescResult.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		labelProgDescResult.setBounds(129, 266, 190, 18);
		contentPane.add(labelProgDescResult);
		
		// Program Type Result
		JLabel labelProgTypeResult = new JLabel("");
		labelProgTypeResult.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		labelProgTypeResult.setBounds(570, 221, 170, 18);
		contentPane.add(labelProgTypeResult);
		
		// GPA Result
		JLabel labelGPAResult = new JLabel("");
		labelGPAResult.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		labelGPAResult.setBounds(570, 241, 190, 18);
		contentPane.add(labelGPAResult);
		
		//Program info text area
//		JTextArea programInfoArea = new JTextArea();
//		programInfoArea.setBounds(22,213,300,200);
//		programInfoArea.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		
		// display all the info on user interface
		JButton btnGoButton = new JButton("Go");
		btnGoButton.setBounds(408, 166, 58, 29);
		btnGoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//get info from RW tools class
				String selectedCourse = (String)selectProgComboBox.getSelectedItem();			
//				System.out.println("Selected course: " + selectedCourse);
				
				ArrayList programInfo = tool.getCourseCalProgramInfo(selectedCourse);
				//System.out.println(programInfo.get(1));
				
				// getting program info from the combo box and setting the fields based on selected program
				for (int i = 0; i < programInfo.size(); i ++) {
					//System.out.println("getting program info: " + programInfo.get(i));
					if (i == 0) 
						labelProgDesResult.setText((String) programInfo.get(i)); 
					if (i == 1) 
						labelDepResult.setText((String) programInfo.get(i)); 
					if (i == 2) 
						labelProgDescResult.setText((String) programInfo.get(i)); 
					if (i == 3) 
						labelProgTypeResult.setText((String) programInfo.get(i)); 
					if (i == 4) 
						labelGPAResult.setText((String) programInfo.get(i)); 
					
				}
				
				txtrEnterCourses.setText("");
				String programCode = tool.getProgramCode((String)selectProgComboBox.getSelectedItem());
				
				//System.out.println("programCode " + programCode);
			
				
				// create an array list to get all courses based on selected program
				ArrayList courses = tool.getCourseName(programCode);
				String[] courseTemplate = {"Instructor: ", "Prequisites: ", "Days Offered: ", "Start Time: ", "Finish Time: ", "Course Credits: ", "Course Description: ", "Program: ", ""};
				System.out.println("courses ArrayList: " + courses);
				
//				System.out.println("SORTED/FILTERED courses ArrayList: " + courses);

				for(int i = 0; i < courses.size(); i+=2) {
					txtrEnterCourses.append((String)courses.get(i) + "\n");
					
					// now we need to get course information for each course in courses array
//					System.out.println("1. Courses " + courses);
					
					///// NOT WORKING HERE !!!!!!!!!!
					String courseIndex = (String) courses.get(i);
//					System.out.println("courseIndex " + courseIndex);
				
					ArrayList courseInfo = tool.getCalCourseInfo(courseIndex);
//					System.out.println("courseInfo ArrayList " + courseInfo);
					System.out.println(courseInfo);
					
					
					
					for(int j = 0; j < courseInfo.size(); j++) {
						txtrEnterCourses.append(courseTemplate[j] + " ");
						txtrEnterCourses.append((String)courseInfo.get(j) + " \n");
						
					}
					txtrEnterCourses.append("\n\n");
				}
				
				
				
				
			}
		});
		btnGoButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		contentPane.add(btnGoButton);
		
		contentPane.setLayout(null);
		contentPane.add(selectProgComboBox);
		contentPane.add(lblLogo);
		contentPane.add(selectProgLabel);
		contentPane.add(lblRequiredCourses);
		contentPane.add(separator_1);
		contentPane.add(txtrEnterCourses);
		contentPane.add(lblProgramDes);
		contentPane.add(lblDept);
		contentPane.add(lblRequiredGpa);
		contentPane.add(lblProgType);
		contentPane.add(lblProgramLvl);
//		contentPane.add(programInfoArea);
		contentPane.add(titleLabel);
		
		JList list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(345, 644, -255, -243);
		contentPane.add(list);
		
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

		
	}
}

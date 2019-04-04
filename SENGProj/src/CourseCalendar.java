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
import javax.swing.DefaultComboBoxModel;



public class CourseCalendar extends JFrame {

	private JPanel contentPane;
	private mainMenuForm menu;
	private RWTools tool = new RWTools();

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
		
		JLabel lblLogo = new JLabel(" ");
		Image img = new ImageIcon(this.getClass().getResource("/University of Winnipeg-logo.png")).getImage();
		img = img.getScaledInstance(200, 100, 0);
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(360, 5, 200, 100);
		getContentPane().add(lblLogo);
		
		JLabel selectProgLabel = new JLabel("Select a program:");
		selectProgLabel.setBounds(22, 170, 114, 18);
		selectProgLabel.setBackground(new Color(105, 105, 105));
		selectProgLabel.setForeground(new Color(105, 105, 105));
		selectProgLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel titleLabel = new JLabel("Course Calendar");
		titleLabel.setBounds(11, 104, 881, 48);
		titleLabel.setBackground(new Color(119, 136, 153));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(112, 128, 144));
		titleLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 26));
		
		JSeparator separator = new JSeparator();
		
		
		JTextArea txtrEnterYear1 = new JTextArea();
		txtrEnterYear1.setBounds(22, 387, 172, 480);
		txtrEnterYear1.setBackground(new Color(245, 245, 245));
		txtrEnterYear1.setWrapStyleWord(true);
		txtrEnterYear1.setText("Enter first year courses here...");
		txtrEnterYear1.setLineWrap(true);
		txtrEnterYear1.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JTextArea txtrEnterYear2 = new JTextArea();
		txtrEnterYear2.setBounds(240, 387, 172, 480);
		txtrEnterYear2.setBackground(new Color(245, 245, 245));
		txtrEnterYear2.setWrapStyleWord(true);
		txtrEnterYear2.setLineWrap(true);
		txtrEnterYear2.setText("Enter second year courses here...");
		txtrEnterYear2.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JTextArea txtrEnterYear3 = new JTextArea();
		txtrEnterYear3.setBounds(466, 387, 172, 480);
		txtrEnterYear3.setBackground(new Color(245, 245, 245));
		txtrEnterYear3.setWrapStyleWord(true);
		txtrEnterYear3.setLineWrap(true);
		txtrEnterYear3.setText("Enter third year courses here...");
		txtrEnterYear3.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JTextArea txtrEnterYear4 = new JTextArea();
		txtrEnterYear4.setBounds(700, 387, 172, 480);
		txtrEnterYear4.setBackground(new Color(245, 245, 245));
		txtrEnterYear4.setWrapStyleWord(true);
		txtrEnterYear4.setLineWrap(true);
		txtrEnterYear4.setText("Enter fourth year courses here...");
		txtrEnterYear4.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		ArrayList progList = tool.getPrograms();
		String [] programs = new String[progList.size()];
		for(int i = 0; i < programs.length; i++) {
			programs[i] = (String)progList.get(i);
		}
		
		JComboBox selectProgComboBox = new JComboBox();
		selectProgComboBox.setModel(new DefaultComboBoxModel(programs));
		selectProgComboBox.setBounds(148, 167, 255, 27);
		selectProgComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		selectProgComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		contentPane.add(selectProgComboBox);

		
		JButton btnGoButton = new JButton("Go");
		btnGoButton.setBounds(408, 166, 58, 29);
		btnGoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Go button clicked");
				txtrEnterYear1.setText("1");
				txtrEnterYear2.setText("2");
				txtrEnterYear3.setText("3");
				txtrEnterYear4.setText("4");
				ArrayList course = tool.getCourseName((String) selectProgComboBox.getSelectedItem());
				for (int i = 0; i < course.size(); i++) {
					txtrEnterYear1.append((String)course.get(i) + "\n");
				}
					
			}
		});
		btnGoButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		contentPane.add(btnGoButton);

		JLabel lblFirstYear = new JLabel("First Year");
		lblFirstYear.setBounds(22, 357, 152, 24);
		lblFirstYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstYear.setForeground(new Color(105, 105, 105));
		lblFirstYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel lblSecondYear = new JLabel("Second Year");
		lblSecondYear.setBounds(240, 357, 152, 24);
		lblSecondYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblSecondYear.setForeground(new Color(105, 105, 105));
		lblSecondYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel lblThirdYear = new JLabel("Third Year");
		lblThirdYear.setBounds(466, 357, 152, 24);
		lblThirdYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblThirdYear.setForeground(new Color(105, 105, 105));
		lblThirdYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel lblFourthYear = new JLabel("Fourth Year");
		lblFourthYear.setBounds(700, 357, 152, 24);
		lblFourthYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblFourthYear.setForeground(new Color(105, 105, 105));
		lblFourthYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel lblUniversityOfWinniped = new JLabel("University of Winnipeg");
		lblUniversityOfWinniped.setBounds(892, 124, 270, 18);
		lblUniversityOfWinniped.setBackground(new Color(238, 238, 238));
		lblUniversityOfWinniped.setForeground(new Color(245, 245, 245));
		lblUniversityOfWinniped.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
		
		JLabel lblProgram = new JLabel("Program: ");
		lblProgram.setBounds(22, 213, 124, 18);
		lblProgram.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel lblProgramLevel = new JLabel("Program Level: ");
		lblProgramLevel.setBounds(22, 237, 124, 18);
		lblProgramLevel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel lblProgramType = new JLabel("Program Type:  ");
		lblProgramType.setBounds(22, 261, 124, 18);
		lblProgramType.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel lblProgramDescription = new JLabel("Program Description:  ");
		lblProgramDescription.setBounds(466, 213, 152, 18);
		lblProgramDescription.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel lblDepartment = new JLabel("Department: ");
		lblDepartment.setBounds(466, 237, 152, 18);
		lblDepartment.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel lblRequiredGpa = new JLabel("Required GPA: ");
		lblRequiredGpa.setBounds(466, 261, 152, 18);
		lblRequiredGpa.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel lblRequiredCourses = new JLabel("Required Courses");
		lblRequiredCourses.setBounds(22, 315, 198, 24);
		lblRequiredCourses.setHorizontalAlignment(SwingConstants.LEFT);
		lblRequiredCourses.setForeground(new Color(112, 128, 144));
		lblRequiredCourses.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 297, 850, 16);
		contentPane.setLayout(null);
		contentPane.add(lblLogo);
		contentPane.add(selectProgLabel);
		contentPane.add(lblRequiredCourses);
		contentPane.add(separator_1);
		contentPane.add(lblFirstYear);
		contentPane.add(txtrEnterYear1);
		contentPane.add(lblSecondYear);
		contentPane.add(txtrEnterYear2);
		contentPane.add(txtrEnterYear3);
		contentPane.add(lblThirdYear);
		contentPane.add(lblFourthYear);
		contentPane.add(txtrEnterYear4);
		contentPane.add(lblProgram);
		contentPane.add(lblProgramLevel);
		contentPane.add(lblProgramType);
		contentPane.add(lblRequiredGpa);
		contentPane.add(lblDepartment);
		contentPane.add(lblProgramDescription);
		contentPane.add(lblUniversityOfWinniped);
		contentPane.add(titleLabel);
		
	}
}

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

public class Calendar extends JFrame {

	private JPanel contentPane;

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
	public Calendar() {
		initialize();
	}
	
	/**
	 * Create the frame.
	 */
	public void initialize() {
		setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel selectProgLabel = new JLabel("Select a program:");
		selectProgLabel.setBounds(40, 75, 114, 18);
		selectProgLabel.setBackground(new Color(105, 105, 105));
		selectProgLabel.setForeground(new Color(105, 105, 105));
		selectProgLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel titleLabel = new JLabel("Course Calendar");
		titleLabel.setBounds(400, 17, 152, 24);
		titleLabel.setForeground(new Color(100, 149, 237));
		titleLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 19));
		
		JSeparator separator = new JSeparator();
		
		JComboBox selectProgComboBox = new JComboBox();
		selectProgComboBox.setBounds(166, 72, 255, 27);
		selectProgComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton("Go");
		btnNewButton.setBounds(426, 71, 58, 29);
		btnNewButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JLabel lblFirstYear = new JLabel("First Year");
		lblFirstYear.setBounds(40, 134, 152, 24);
		lblFirstYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstYear.setForeground(new Color(105, 105, 105));
		lblFirstYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel lblSecondYear = new JLabel("Second Year");
		lblSecondYear.setBounds(258, 134, 152, 24);
		lblSecondYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblSecondYear.setForeground(new Color(105, 105, 105));
		lblSecondYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel lblThirdYear = new JLabel("Third Year");
		lblThirdYear.setBounds(499, 134, 152, 24);
		lblThirdYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblThirdYear.setForeground(new Color(105, 105, 105));
		lblThirdYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel lblFourthYear = new JLabel("Fourth Year");
		lblFourthYear.setBounds(747, 134, 152, 24);
		lblFourthYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblFourthYear.setForeground(new Color(105, 105, 105));
		lblFourthYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel FirstYrCourse = new JLabel("Required Courses");
		FirstYrCourse.setBounds(40, 170, 124, 16);
		FirstYrCourse.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel SndYrCourse = new JLabel("Required Courses");
		SndYrCourse.setBounds(258, 170, 124, 16);
		SndYrCourse.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel ThdYrCourse = new JLabel("Required Courses");
		ThdYrCourse.setBounds(499, 170, 124, 16);
		ThdYrCourse.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel FthYrCourse = new JLabel("Required Courses");
		FthYrCourse.setBounds(747, 170, 124, 16);
		FthYrCourse.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		contentPane.setLayout(null);
		contentPane.add(titleLabel);
		contentPane.add(selectProgLabel);
		contentPane.add(selectProgComboBox);
		contentPane.add(btnNewButton);
		contentPane.add(lblFirstYear);
		contentPane.add(lblSecondYear);
		contentPane.add(lblThirdYear);
		contentPane.add(lblFourthYear);
		contentPane.add(FirstYrCourse);
		contentPane.add(SndYrCourse);
		contentPane.add(ThdYrCourse);
		contentPane.add(FthYrCourse);
		
	}
}

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

public class CourseCalendar extends JFrame {

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
	public CourseCalendar() {
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
		selectProgLabel.setBackground(new Color(105, 105, 105));
		selectProgLabel.setForeground(new Color(105, 105, 105));
		selectProgLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel titleLabel = new JLabel("Course Calendar");
		titleLabel.setForeground(new Color(105, 105, 105));
		titleLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 19));
		
		JSeparator separator = new JSeparator();
		
		JComboBox selectProgComboBox = new JComboBox();
		selectProgComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton("Go");
		btnNewButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		
		JLabel lblFirstYear = new JLabel("First Year");
		lblFirstYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstYear.setForeground(new Color(105, 105, 105));
		lblFirstYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel lblSecondYear = new JLabel("Second Year");
		lblSecondYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblSecondYear.setForeground(new Color(105, 105, 105));
		lblSecondYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel lblThirdYear = new JLabel("Third Year");
		lblThirdYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblThirdYear.setForeground(new Color(105, 105, 105));
		lblThirdYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel lblFourthYear = new JLabel("Fourth Year");
		lblFourthYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblFourthYear.setForeground(new Color(105, 105, 105));
		lblFourthYear.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
		
		JLabel FirstYrCourse = new JLabel("Required Courses");
		FirstYrCourse.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel SndYrCourse = new JLabel("Required Courses");
		SndYrCourse.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel ThdYrCourse = new JLabel("Required Courses");
		ThdYrCourse.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		JLabel FthYrCourse = new JLabel("Required Courses");
		FthYrCourse.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(395)
					.addComponent(titleLabel))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(selectProgLabel)
					.addGap(12)
					.addComponent(selectProgComboBox, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblFirstYear, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addComponent(lblSecondYear, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(89)
					.addComponent(lblThirdYear, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(96)
					.addComponent(lblFourthYear, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(FirstYrCourse, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(94)
					.addComponent(SndYrCourse, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(117)
					.addComponent(ThdYrCourse, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(124)
					.addComponent(FthYrCourse, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(titleLabel)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(selectProgLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(selectProgComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFirstYear, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSecondYear, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThirdYear, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFourthYear, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(FirstYrCourse, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(SndYrCourse, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(ThdYrCourse, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(FthYrCourse, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}

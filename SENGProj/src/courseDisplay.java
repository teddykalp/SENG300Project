import java.awt.BorderLayout;
import java.awt.EventQueue;

// Import libraries
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Scrollbar;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

/**
* courseDisplay class handles UI for course display
* @author	Teddy Kalp
* @version	1.0
*/

public class courseDisplay extends JFrame {

	private JPanel contentPane;
	private mainMenuForm menu;
	private RWTools tool = new RWTools();

	/**
	 * main function: Launches the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseDisplay frame = new courseDisplay("Test");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * courseDisplay constructor that creates the frame and adds its components.
	 * @param	user - staff user that is adding a course
	 */
	public courseDisplay(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 485);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    	// List of programs to be selected from
	   	ArrayList proGram = tool.getPrograms();
		String [] programs = new String[proGram.size()];
		for (int x = 0; x < programs.length; x++){
			programs[x] = (String)proGram.get(x);
		}
		
		// Choose program from list of programs
		JComboBox programsSelect = new JComboBox();
		programsSelect.setModel(new DefaultComboBoxModel(programs));
		programsSelect.setBounds(44, 81, 216, 32);
		contentPane.add(programsSelect);
		
		JLabel lblchooseProgram = new JLabel("Choose Program");
		lblchooseProgram.setFont(new Font("Source Sans Pro", Font.PLAIN, 21));
		lblchooseProgram.setBounds(44, 46, 182, 26);
		contentPane.add(lblchooseProgram);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 156, 279, 237);
		contentPane.add(scrollPane);
		
		JTextArea courseDisplay = new JTextArea();
		scrollPane.setViewportView(courseDisplay);
		courseDisplay.setEditable(false);
		
		// Shows list of courses to UI
		JButton btnView = new JButton("View");
		btnView.setBackground(new Color(173, 255, 47));
		btnView.setFont(new Font("Source Sans Pro", Font.BOLD, 21));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseDisplay.setText("");
				String programCode = tool.getProgramCode((String)programsSelect.getSelectedItem());
				ArrayList course = tool.getCourseName(programCode);
				for (int x = 0; x < course.size(); x++){
					courseDisplay.append((String)course.get(x) + "\n");
				}
			
			}
		});
		btnView.setBounds(366, 217, 141, 35);
		contentPane.add(btnView);
		
		JButton btnReturn = new JButton("Go Back");
		btnReturn.setBackground(new Color(255, 105, 180));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Source Sans Pro", Font.BOLD, 21));
		btnReturn.setBounds(366, 42, 141, 35);
		contentPane.add(btnReturn);
		
		JLabel programCourses = new JLabel("Courses Offered");
		programCourses.setFont(new Font("Source Sans Pro", Font.PLAIN, 21));
		programCourses.setBounds(44, 120, 182, 26);
		contentPane.add(programCourses);
		
		JLabel lblNewLabel = new JLabel("View Courses by Program");
		lblNewLabel.setFont(new Font("Sitka Banner", Font.BOLD, 21));
		lblNewLabel.setBounds(116, -1, 254, 26);
		contentPane.add(lblNewLabel);
		
		}
	
	
}

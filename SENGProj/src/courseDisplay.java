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
import java.awt.Dimension;

/**
* courseDisplay class handles UI for course display
* @author	Teddy Kalp
* @version	1.0
*/

public class courseDisplay extends JPanel {
	// class attributes 
	private JPanel contentPane;
	private JComboBox programsSelect;
	
	private JTextArea courseDisplay;
	private JScrollPane scrollPane;
	private JButton btnView;
	private JButton btnReturn;
	
	private JLabel programCourses; 
	private JLabel lblNewLabel;
	private JLabel lblchooseProgram;
	
	private RWTools tool = new RWTools();

	
	/**
	 * courseDisplay constructor that creates the frame and adds its components.
	 * @param	user - staff user that is adding a course
	 */
	public courseDisplay(JPanel panel) {

		JPanel p1 = new JPanel(null);
		p1.setPreferredSize(new Dimension(1000,1000));
		contentPane = panel;
		
	    	// List of programs to be selected from
	   	ArrayList proGram = tool.getPrograms();
		String [] programs = new String[proGram.size()];
		for (int x = 0; x < programs.length; x++){
			programs[x] = (String)proGram.get(x);
		}
		
		// Choose program from list of programs
		programsSelect = new JComboBox();
		programsSelect.setModel(new DefaultComboBoxModel(programs));
		programsSelect.setBounds(44, 81, 216, 32);
		p1.add(programsSelect);
		
		// choose program label
		lblchooseProgram = new JLabel("Choose Program");
		lblchooseProgram.setFont(new Font("Source Sans Pro", Font.PLAIN, 21));
		lblchooseProgram.setBounds(44, 46, 182, 26);
		p1.add(lblchooseProgram);
		
		// scroll bar for all programs 
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 156, 279, 237);
		p1.add(scrollPane);
		
		// course display text area 
		courseDisplay = new JTextArea();
		scrollPane.setViewportView(courseDisplay);
		courseDisplay.setEditable(false);
		
		// Shows list of courses to UI
		btnView = new JButton("View");
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
		p1.add(btnView);
		
		// go back button that will take the user back to the main menu 
		btnReturn = new JButton("Go Back");
		btnReturn.setBackground(new Color(255, 105, 180));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnReturn.setFont(new Font("Source Sans Pro", Font.BOLD, 21));
		btnReturn.setBounds(366, 42, 141, 35);
		p1.add(btnReturn);
		
		// courses offered label
		programCourses = new JLabel("Courses Offered");
		programCourses.setFont(new Font("Source Sans Pro", Font.PLAIN, 21));
		programCourses.setBounds(44, 120, 182, 26);
		p1.add(programCourses);
		
		// view courses label
		lblNewLabel = new JLabel("View Courses by Program");
		lblNewLabel.setFont(new Font("Sitka Banner", Font.BOLD, 21));
		lblNewLabel.setBounds(116, -1, 254, 26);
		p1.add(lblNewLabel);
		
		contentPane.add(p1);
		add(p1);
		
		}
	
	  
}

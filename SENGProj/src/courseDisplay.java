import java.awt.BorderLayout;
import java.awt.EventQueue;

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

public class courseDisplay extends JFrame {

	private JPanel contentPane;
	private RWTools tool = new RWTools();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courseDisplay frame = new courseDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public courseDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea courseDisplay = new JTextArea();
		courseDisplay.setEditable(false);
		courseDisplay.setBounds(157, 123, 215, 147);
		JScrollPane pane = new JScrollPane(courseDisplay);
	    contentPane.add(courseDisplay);
		
		
		
		JButton btnNewButton = new JButton("Courses");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList course = tool.getCourseName();
				for (int x = 0; x < course.size(); x++){
					courseDisplay.append((String)course.get(x) + "\n");
				}
			}
		});
		btnNewButton.setBounds(192, 45, 141, 35);
		contentPane.add(btnNewButton);
		
		
	}
}

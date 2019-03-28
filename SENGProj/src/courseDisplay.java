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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class courseDisplay extends JFrame {

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
					courseDisplay frame = new courseDisplay("Test");
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
	public courseDisplay(String user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea courseDisplay = new JTextArea();
		courseDisplay.setEditable(false);
		courseDisplay.setBounds(21, 82, 324, 269);
	    contentPane.add(courseDisplay);
	    
	    ArrayList proGram = tool.getPrograms();
		String [] programs = new String[proGram.size()];
		for (int x = 0; x < programs.length; x++){
			programs[x] = (String)proGram.get(x);
		}
		
		JComboBox programsSelect = new JComboBox();
		programsSelect.setModel(new DefaultComboBoxModel(programs));
		programsSelect.setBounds(59, 40, 216, 32);
		contentPane.add(programsSelect);
		
		JLabel lblNewLabel = new JLabel("Choose Program");
		lblNewLabel.setFont(new Font("Source Sans Pro", Font.PLAIN, 21));
		lblNewLabel.setBounds(83, 10, 182, 26);
		contentPane.add(lblNewLabel);
		
		
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.setFont(new Font("Source Sans Pro", Font.PLAIN, 21));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseDisplay.setText("");
				ArrayList course = tool.getCourseName((String) programsSelect.getSelectedItem());
				for (int x = 0; x < course.size(); x++){
					courseDisplay.append((String)course.get(x) + "\n");
				}
			
			}
		});
		btnNewButton.setBounds(362, 21, 141, 35);
		contentPane.add(btnNewButton);
		
		JButton btnReturn = new JButton("Go Back");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu = new mainMenuForm(user);
				menu.setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Source Sans Pro", Font.PLAIN, 21));
		btnReturn.setBounds(366, 316, 141, 35);
		contentPane.add(btnReturn);
		
		
		
	}
}

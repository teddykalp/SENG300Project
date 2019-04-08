

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;



public class MainMenuForm extends JPanel {
        private JPanel contentPane;
        ImageLibrary img = new ImageLibrary();
        
        private JLabel option;
        private JLabel Welcome;
        
        private JButton AddCourse;
        private JButton AddProgram;
        private JButton AddDepartment;
        private JButton EditCourse;
        private JButton ViewDepartment;
        private JButton ViewProgram;
        private JButton Logout;
        private JButton EditP;
        private JButton EditD;
     
    public MainMenuForm(JPanel panel, String s) {
        JPanel p1 = new JPanel(null) ;
        p1.setPreferredSize(new Dimension(1000,1000));
        contentPane = panel;
        
        String user = s; 
        
        //IMG
        JPanel mainmenubg = new JPanel();
        ImageIcon pic = new ImageIcon("ImgLib/Mmf.png");
        mainmenubg.setSize(1000,1000);
        mainmenubg.add(new JLabel(pic));
        mainmenubg.setEnabled(true);
        mainmenubg.setVisible(true);  
        
        //Labels 
        Welcome = new JLabel("Welcome " + user);
	Welcome.setForeground(Color.RED);
	Welcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
	Welcome.setBounds(10, 0, 141, 26);
	
	option = new JLabel("Which Action Would you like to perform?");
	option.setBackground(Color.RED);
	option.setForeground(new Color(255, 0, 0));
	option.setFont(new Font("Tahoma", Font.PLAIN, 18));
	option.setBounds(87, 64, 446, 26);
	
		
        //Buttons
        
        AddCourse = new JButton("Add Course");
	AddCourse.setForeground(new Color(0, 0, 0));
	AddCourse.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "lo");
		}
	});
	AddCourse.setBackground(Color.WHITE);
	AddCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
	AddCourse.setBounds(150, 300, 200, 50);
	
	ViewDepartment = new JButton("View Department");
	ViewDepartment.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                        cardLayout.show(contentPane, "lo");
		}
	});
	ViewDepartment.setForeground(Color.WHITE);
	ViewDepartment.setBackground(new Color(0, 0, 0));
	ViewDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
	ViewDepartment.setBounds(150, 400, 200, 50);
	
	EditCourse = new JButton("Edit Course");
	EditCourse.setForeground(Color.BLACK);
	EditCourse.setBackground(new Color(255, 255, 255));
	EditCourse.setFont(new Font("Tahoma", Font.BOLD,14));
	EditCourse.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                    cardLayout.show(contentPane, "lo");
		}
	});
	EditCourse.setBounds(150, 500, 200, 50);
	
	
	
	ViewProgram = new JButton("View Program");
	ViewProgram.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                        cardLayout.show(contentPane, "lo");
			
		}
	});
	ViewProgram.setForeground(Color.WHITE);
	ViewProgram.setBackground(new Color(0, 0, 0));
	ViewProgram.setFont(new Font("Tahoma", Font.BOLD, 14));
	ViewProgram.setBounds(250, 300, 200, 50);
	
	
	Logout = new JButton("Logout");
	Logout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                        cardLayout.show(contentPane, "login");
		}
	});
	Logout.setFont(new Font("Tahoma", Font.BOLD, 16));
	Logout.setBackground(new Color(255, 255, 255));
	Logout.setBounds(850, 100, 200, 50);
	
	AddProgram = new JButton("Add Program");
	AddProgram.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                        cardLayout.show(contentPane, "log");
		}
	});
	AddProgram.setForeground(Color.WHITE);
	AddProgram.setBackground(new Color(0, 0, 0));
	AddProgram.setFont(new Font("Tahoma", Font.BOLD, 16));
	AddProgram.setBounds(200, 119, 141, 100);
	
	AddDepartment= new JButton("Add Department");
	AddDepartment.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                        cardLayout.show(contentPane, "log");
		}
	});
	AddDepartment.setForeground(Color.WHITE);
	AddDepartment.setBackground(new Color(0, 0, 0));
	AddDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
	AddDepartment.setBounds(550, 122, 161, 100);
	
	EditP = new JButton("Edit Program");
	EditP.setForeground(new Color(0, 0, 0));
	EditP.setBackground(Color.WHITE);
	EditP.setFont(new Font("Tahoma", Font.BOLD, 16));
	EditP.setBounds(200, 183, 141, 100);
	
	EditD = new JButton("Edit Department");
	EditD.setForeground(new Color(0, 0, 0));
	EditD.setBackground(new Color(255, 250, 250));
	EditD.setFont(new Font("Tahoma", Font.BOLD, 14));
	EditD.setBounds(550, 181, 161, 100);
	

        
        p1.add(Welcome);
        p1.add(option);
        
        p1.add(AddCourse);
        p1.add(EditCourse);
        p1.add(ViewDepartment);
        p1.add(ViewProgram);
        p1.add(Logout);
        p1.add(AddProgram);
        p1.add(AddDepartment);
        p1.add(EditP);
        p1.add(EditD);
        
        
        p1.add(mainmenubg);
        
        
         contentPane.add(p1);
         add(p1);
       
    }
    
        @Override
        public Dimension getPreferredSize()
        { 
            return (new Dimension(1000,1000));
        }

}

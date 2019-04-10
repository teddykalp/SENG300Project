

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
        private JButton ViewCourse;
        private JButton ViewDepartment;
        private JButton ViewProgram;
        private JButton Logout;
        private JButton EditP;
        private JButton EditD;
     
    public MainMenuForm(JPanel panel) {
        JPanel p1 = new JPanel(null) ;
        p1.setPreferredSize(new Dimension(1000,1000));
        contentPane = panel;
        
        
        //IMG
        JPanel mainmenubg = new JPanel();
        ImageIcon pic = img.mmfbg;
        mainmenubg.setSize(1000,1000);
        mainmenubg.add(new JLabel(pic));
        mainmenubg.setEnabled(true);
        mainmenubg.setVisible(true);  
        
        //Labels 
       Welcome = new JLabel("Welcome, ");
        Welcome.setForeground(Color.WHITE);
        Welcome.setFont(new Font("Tahoma", Font.BOLD, 30));
        Welcome.setBounds(25, 50, 250, 50);
        
        option = new JLabel("Which Action Would you like to perform?");
        option.setBackground(Color.WHITE);
        option.setFont(new Font("Tahoma", Font.PLAIN, 15));
        option.setBounds(25, 80, 500, 50);
        
            
            //Buttons
        ViewCourse = new JButton("View Course");
        ViewCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                    cardLayout.show(contentPane, "lo");
            }
        });
        ViewCourse.setBackground(Color.WHITE);
        ViewCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
        ViewCourse.setBounds(100, 250, 200, 50);   
            
            
        
        ViewProgram = new JButton("View Program");
        ViewProgram.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                            cardLayout.show(contentPane, "pd");
                
            }
        });
        ViewProgram.setForeground(Color.WHITE);
        ViewProgram.setBackground(new Color(0, 0, 0));
        ViewProgram.setFont(new Font("Tahoma", Font.BOLD, 14));
        ViewProgram.setBounds(100, 350, 200, 50 );
        
        
        ViewDepartment = new JButton("View Department");
        ViewDepartment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "dd");
            }
        });
        ViewDepartment.setForeground(Color.BLACK);
        ViewDepartment.setBackground(new Color(255,255,255));
        ViewDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
        ViewDepartment.setBounds(100, 450, 200, 50);
        
        AddCourse = new JButton("Add Course");
        AddCourse.setForeground(Color.WHITE);
        AddCourse.setBackground(new Color(0, 0, 0));
        AddCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                    cardLayout.show(contentPane, "ac");
            }
        });
         AddCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
        AddCourse.setBounds(400, 250, 200, 50);
        
        AddProgram = new JButton("Add Program");
        AddProgram.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                            cardLayout.show(contentPane, "ap");
            }
        });
        AddProgram.setForeground(Color.BLACK);
        AddProgram.setBackground(new Color(255,255,255));
        AddProgram.setFont(new Font("Tahoma", Font.BOLD, 14));
        AddProgram.setBounds(400, 350, 200, 50);
        
        AddDepartment= new JButton("Add Department");
        AddDepartment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                            cardLayout.show(contentPane, "ad");
            }
        });
        AddDepartment.setForeground(Color.WHITE);
        AddDepartment.setBackground(new Color(0, 0, 0));
        AddDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
        AddDepartment.setBounds(400, 450, 200, 50);
        
        
        EditCourse = new JButton("Edit Course");
        EditCourse.setForeground(Color.BLACK);
        EditCourse.setBackground(new Color(255,255,255));
        EditCourse.setFont(new Font("Tahoma", Font.BOLD,14));
        EditCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                        cardLayout.show(contentPane, "ec");
            }
        });
        EditCourse.setBounds(700, 250, 200, 50);
        
        
        EditP = new JButton("Edit Program");
        EditP.setForeground(Color.WHITE);
        EditP.setBackground(new Color(0,0,0));
        EditP.setFont(new Font("Tahoma", Font.BOLD, 14));
        EditP.setBounds(700,350, 200, 50);
        EditP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                        cardLayout.show(contentPane, "ep");
            }
        });
        
        
        EditD = new JButton("Edit Department");
        EditD.setForeground(new Color(0, 0, 0));
        EditD.setBackground(new Color(255, 255, 255));
        EditD.setFont(new Font("Tahoma", Font.BOLD, 14));
        EditD.setBounds(700, 450, 200, 50);
        EditD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                        cardLayout.show(contentPane, "ed");
            }
        });
        
        
        Logout = new JButton("Logout");
        Logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                            cardLayout.show(contentPane, "login");
            }
        });
        Logout.setFont(new Font("Tahoma", Font.BOLD, 16));
        Logout.setBackground(new Color(255, 255, 255));
        Logout.setBounds(750, 100, 200, 50);

        
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
        p1.add(ViewCourse);
        
        
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

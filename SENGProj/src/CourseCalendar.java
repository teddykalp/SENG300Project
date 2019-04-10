
import java.awt.EventQueue;

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
import java.util.ArrayList;

import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Collections;


public class CourseCalendar extends JPanel {

    private JPanel contentPane;

    private RWTools tool = new RWTools();
    ImageLibrary img = new ImageLibrary();
    

    /**
     * Create the application
     */
    public CourseCalendar(JPanel panel) {
        
        JPanel image1 = new JPanel();
        ImageIcon pic = img.calendar;
        image1.setSize(1000,1000);
        image1.add(new JLabel(pic));
        image1.setEnabled(true);
        image1.setVisible(true);
    
    
    
        JPanel p1 = new JPanel(null) ;
                 p1.setPreferredSize(new Dimension(1000,1000));
                contentPane= panel;
    
    
        
        
        // add and initialize go back button for login screen
        JButton btnGoBack = new JButton("Go Back");
        btnGoBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                   CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                                cardLayout.show(contentPane, "login");
            }
        });
        btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnGoBack.setBounds(763, 16, 89, 23);
        p1.add(btnGoBack);
        
        // label for selecting program from combobox
        JLabel selectProgLabel = new JLabel("Select a program:");
        selectProgLabel.setBounds(24, 192, 114, 18);
        selectProgLabel.setBackground(new Color(105, 105, 105));
        selectProgLabel.setForeground(new Color(105, 105, 105));
        selectProgLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        // title for jframe
        JLabel titleLabel = new JLabel("Course Calendar");
        titleLabel.setBounds(6, 111, 859, 48);
        titleLabel.setBackground(new Color(119, 136, 153));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(112, 128, 144));
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        
        JSeparator separator = new JSeparator();
        
        // text areas for all classes for a given program
        JTextArea txtrEnterCourses = new JTextArea();
        txtrEnterCourses.setBounds(353, 459, 438, 343);
        txtrEnterCourses.setBackground(new Color(245, 245, 245));
        txtrEnterCourses.setWrapStyleWord(true);
        txtrEnterCourses.setLineWrap(true);
        txtrEnterCourses.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        // create an array that gets all the programs in the database
        ArrayList progList = tool.getPrograms();
        String [] programs = new String[progList.size()];
        for(int i = 0; i < programs.length; i++) {
            programs[i] = (String)progList.get(i);
        }
        
        // create combo box for user to select a given program
        JComboBox selectProgComboBox = new JComboBox();
        selectProgComboBox.setModel(new DefaultComboBoxModel(programs));
        selectProgComboBox.setBounds(150, 189, 322, 27);
        selectProgComboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        // program level label
        JLabel lblProgCode = new JLabel("Program Code: ");
        lblProgCode.setBounds(22, 238, 114, 28);
        lblProgCode.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        // program type label
        JLabel lblDeptName = new JLabel("Department: ");
        lblDeptName.setBounds(22, 277, 100, 27);
        lblDeptName.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        // program description label
        JLabel lblProgramLvl = new JLabel("Program Level: ");
        lblProgramLvl.setBounds(350, 239, 116, 23);
        lblProgramLvl.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        // department label
        JLabel lblProgType = new JLabel("Program Type: ");
        lblProgType.setBounds(350, 271, 116, 32);
        lblProgType.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        // required gpa label
        JLabel lblGpa = new JLabel("Required GPA: ");
        lblGpa.setBounds(23, 315, 113, 27);
        lblGpa.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        // sub-heading label
        JLabel lblRequiredCourses = new JLabel("Required Courses");
        lblRequiredCourses.setBounds(25, 385, 198, 24);
        lblRequiredCourses.setHorizontalAlignment(SwingConstants.LEFT);
        lblRequiredCourses.setForeground(new Color(112, 128, 144));
        lblRequiredCourses.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(15, 369, 850, 16);
        
        // Program description result
        JLabel labelProgCodeResult = new JLabel("E.g. MATH");
        labelProgCodeResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelProgCodeResult.setBounds(135, 239, 152, 27);
        p1.add(labelProgCodeResult);
        
        // Department result
        JLabel labelDepResult = new JLabel("E.g. Math");
        labelDepResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelDepResult.setBounds(115, 278, 163, 27);
        p1.add(labelDepResult);
        
        // Program Description Result
        JLabel labelProgLvlResult = new JLabel("E.g. Bachelor's");
        labelProgLvlResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelProgLvlResult.setBounds(463, 239, 190, 23);
        p1.add(labelProgLvlResult);
        
        // Program Type Result
        JLabel labelProgTypeResult = new JLabel("Bachelor of Science");
        labelProgTypeResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelProgTypeResult.setBounds(463, 270, 170, 34);
        p1.add(labelProgTypeResult);
        
        // GPA Result
        JLabel labelGPAResult = new JLabel("E.g. 3.2");
        labelGPAResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelGPAResult.setBounds(135, 314, 93, 29);
        p1.add(labelGPAResult);

        // Program Description label
        JLabel lblProgramDescription = new JLabel("Program Description: ");
        lblProgramDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblProgramDescription.setBounds(350, 314, 162, 28);
        p1.add(lblProgramDescription);
        
        // Program Description result label
        JTextArea lblProgramDescriptionResult = new JTextArea("This program is for...");
        lblProgramDescriptionResult.setBackground(new Color(245, 245, 245));
        lblProgramDescriptionResult.setLineWrap(true);
        lblProgramDescriptionResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblProgramDescriptionResult.setBounds(504, 319, 349, 48);
        p1.add(lblProgramDescriptionResult);
        
        // Selected Course label
        JLabel lblSelectedCourse = new JLabel("Selected Course");
        lblSelectedCourse.setHorizontalAlignment(SwingConstants.LEFT);
        lblSelectedCourse.setForeground(new Color(112, 128, 144));
        lblSelectedCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSelectedCourse.setBounds(353, 416, 381, 31);
        p1.add(lblSelectedCourse);
        
        // Course detail label
        JLabel lblCourseDetails = new JLabel("Course Details");
        lblCourseDetails.setHorizontalAlignment(SwingConstants.LEFT);
        lblCourseDetails.setForeground(new Color(112, 128, 144));
        lblCourseDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblCourseDetails.setBounds(353, 385, 381, 31);
        p1.add(lblCourseDetails);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(15, 160, 850, 16);
        p1.add(separator_2);
        
        // legend for user
        JTextArea txtrNotexx = new JTextArea();
        txtrNotexx.setForeground(new Color(102, 0, 51));
        txtrNotexx.setBackground(new Color(245, 245, 245));
        txtrNotexx.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtrNotexx.setText("Note: \n- 1XX = 1st year course, 2XX = 2nd year course\n- 3XX = 3rd year course, 4XX = 4th year course");
        txtrNotexx.setBounds(27, 416, 278, 48);
        p1.add(txtrNotexx);
        
        // add course ArrayList to JList 
        // list to display all the courses of a given program
        DefaultListModel model = new DefaultListModel();
        JList list = new JList(model);
        list.setBackground(new Color(245, 245, 245));
        list.setFont(new Font("Tahoma", Font.PLAIN, 14));
        model.addElement("");
        list.setBounds(27, 474, 278, 328);
        p1.add(list);
        
        // array used for displaying course attributes in text area
        String[] courseTemplate = {"Course Code: ", "Instructor: ", "Prequisites: ", "Days Offered: ", "Start Time: ", 
                                    "Finish Time: ", "Course Credits: ", "Course Description: ", "Program: "};
        
        // event handler for when item in list is selected
        list.addMouseListener(new MouseAdapter() {
               public void mouseClicked(MouseEvent evt) {
                    txtrEnterCourses.setText("");
                    
                    JList list = (JList)evt.getSource();
                    if (evt.getClickCount() == 1 || evt.getClickCount() == 2) {
                        // Double-click detected
                        int index = list.locationToIndex(evt.getPoint());
                        //System.out.println("index: " + index);
                        
                        // get the index of the course and set text area based on getCourse Info
                        String s = (String) list.getSelectedValue();
                        //System.out.println("s: " + s);
                        
                        
                        // Add course information to text area
                        lblSelectedCourse.setText(s);
                        ArrayList courseInfo = tool.getCourseInfo(s);
                        for(int i = 0; i < courseInfo.size(); i++) {
                            txtrEnterCourses.append(courseTemplate[i] + " ");
                            txtrEnterCourses.append(courseInfo.get(i) + "\n");
                        }
                        // System.out.println("courseInfo from s: " + courseInfo);
                        // now we want to display that course info (based on s) into the text area
                    }   
                }
        });
        
        
        // display all the info on user interface
        JButton btnGoButton = new JButton("Go");
        btnGoButton.setBounds(482, 188, 58, 29);
        
        // event handler for go button
        btnGoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.clear();
                
                //get info from RW tools class
                String selectedCourse = (String)selectProgComboBox.getSelectedItem();           
//              System.out.println("Selected course: " + selectedCourse);
                                
                ArrayList programInfo = tool.getProgramInfo(selectedCourse);
//              System.out.println("programInfo: " + programInfo );
                
                // getting program info from the combo box and setting the fields based on selected program
                for (int i = 0; i < programInfo.size(); i ++) {
                    if (i == 0) 
                        labelProgCodeResult.setText((String) programInfo.get(i)); 
                    if (i == 1) 
                        lblProgramDescriptionResult.setText((String) programInfo.get(i)); 
                    if(i == 2)
                        labelDepResult.setText((String) programInfo.get(i));
                    if (i == 3) 
                        labelProgLvlResult.setText((String) programInfo.get(i)); 
                    if (i == 4) 
                        labelProgTypeResult.setText((String) programInfo.get(i)); 
                    if (i == 5)
                        labelGPAResult.setText((String) programInfo.get(i)); 
                }
                
                // get program code from combo box 
                txtrEnterCourses.setText("");
                String programCode = tool.getProgramCode((String)selectProgComboBox.getSelectedItem());
//              System.out.println("programCode " + programCode);
                        
                // create an array list to get all courses based on selected program
                ArrayList courses = tool.getCourseName(programCode);
                // sort the array in ascending order
                Collections.sort(courses);
                
                // get courses list
                ArrayList coursesL = tool.getCourses();
                String [] coursesList = new String[coursesL.size()];
                for (int x = 0; x < coursesList.length; x++){
                    coursesList[x] = (String)coursesL.get(x);
                
                    // adding course codes to the list for user to select
                    model.addElement(coursesList[x]);
                }
                
                // testing which array is being used
                //System.out.println("courses ArrayList from getCourseName: " + courses);
            
            }
        });
        btnGoButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        p1.add(btnGoButton);
        
        // add elements to content pane 
        p1.setLayout(null);
        p1.add(selectProgComboBox);
        
        p1.add(selectProgLabel);
        p1.add(lblRequiredCourses);
        p1.add(separator_1);
        p1.add(txtrEnterCourses);
        p1.add(lblProgCode);
        p1.add(lblDeptName);
        p1.add(lblGpa);
        p1.add(lblProgType);
        p1.add(lblProgramLvl);
        p1.add(titleLabel);
        p1.add(image1);
        
        contentPane.add(p1);
        add(p1);
        
        
        
    }
           @Override
        public Dimension getPreferredSize()
        { 
            return (new Dimension(1000,1000));
        }

}

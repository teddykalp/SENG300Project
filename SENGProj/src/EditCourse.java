
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Imported libraries


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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

// this class allows the ability for the user to modify an existing course in the courseDB
// all changes will be overwrite the existing entry
public class EditCourse extends JPanel {
    
    // class attributes
    private JPanel contentPane;
    
    private JTextField courseName, courseLvl, courseID, courseInstructor;
    private JTextField startTime, finishTime;
    private JTextArea coursePreReq, daysOffered, courseCredit, courseDesc;
    private RWTools tool = new RWTools();
    
    private JComboBox coursesSelect;
    private JLabel lblchooseCourse;
    private JLabel nameError;
    
    private List newDaysOffered;
    private String programName;
    private JTextField programCourse;

    // these variables are used for functionality purposes
    private String oldName, oldLvl, oldID, oldProgram, oldInstructor, oldPreReq, oldDaysOffered, oldCode,
    oldStart, oldFinish, oldCredit, oldDesc, oldDaysO;
    private String newName, newLvl, newID, newProgram, newInstructor, newPreReq, newCode, newDays,
    newStart, newFinish, newCredit, newDesc;
    
    ImageLibrary img = new ImageLibrary();
    
    // editCourse construvtor that creates the frame and adds its components 
    // @paeam - panel that holds the the contents of the window 
    public EditCourse(JPanel panel) {
        JPanel p1 = new JPanel(null);
        p1.setPreferredSize(new Dimension(1000,1000));
        contentPane = panel;
        
        
          //IMG
        JPanel editcbg = new JPanel();
        ImageIcon pic = img.editcbg;
       editcbg.setSize(1000,1000);
       editcbg.add(new JLabel(pic));
       editcbg.setEnabled(true);
       editcbg.setVisible(true);  
        
        //Creates Arraylist of courses to choose to edit
        ArrayList coursesL = tool.getCourses();
        String [] courses = new String[coursesL.size()];
        for (int x = 0; x < courses.length; x++){
            courses[x] = (String)coursesL.get(x);
        }
        
        // panel title 
        JLabel CView = new JLabel("Edit Course");
         CView.setFont(new Font("Tahoma", Font.BOLD, 30));
         CView.setForeground(Color.WHITE);
         CView.setBounds(410, 20, 500,50);
        p1.add( CView);
        
        // label for user to specify page function
        JLabel lblNewLabel = new JLabel("Which Course would you like to edit?");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(300, 65, 500, 26);
        p1.add(lblNewLabel);
        
        // drop menu of program to choose from
        JComboBox coursesSelect = new JComboBox();
        coursesSelect.setModel(new DefaultComboBoxModel(courses));
        coursesSelect.setBounds(500, 150, 216, 25);
        p1.add(coursesSelect);
        
        // label that specifies combo box that holds all existing courses
        JLabel lblchooseCourse = new JLabel("Choose Course");
        lblchooseCourse.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
        lblchooseCourse.setBounds(300, 150, 115, 26);
        p1.add(lblchooseCourse);
        
        // label for name error handling
        JLabel nameError = new JLabel("");
        nameError.setForeground(Color.RED);
        nameError.setFont(new Font("Tahoma", Font.PLAIN, 10));
        nameError.setBounds(600, 200, 123, 17);
        p1.add(nameError);
        
        // label that describes description error 
        JLabel descError = new JLabel("");
        descError.setForeground(Color.RED);
        descError.setFont(new Font("Tahoma", Font.PLAIN, 10));
        descError.setBounds(600, 700, 123, 17);
        p1.add(descError);
        
        // label for id errors
        JLabel idError = new JLabel("");
        idError.setForeground(Color.RED);
        idError.setFont(new Font("Tahoma", Font.PLAIN, 10));
        idError.setBounds(600, 300, 123, 17);
        p1.add(idError);
        
        // label for st error
        JLabel stError = new JLabel("");
        stError.setForeground(Color.RED);
        stError.setFont(new Font("Tahoma", Font.PLAIN, 10));
        stError.setBounds(600, 700, 121, 17);
        p1.add(stError);
        
        // label for ft error
        JLabel ftError = new JLabel("");
        ftError.setForeground(Color.RED);
        ftError.setFont(new Font("Tahoma", Font.PLAIN, 10));
        ftError.setBounds(600, 750, 92, 17);
        p1.add(ftError);
        
        // label for selected course level
        lblNewLabel = new JLabel("Course Level");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(300, 200, 92, 26);
        p1.add(lblNewLabel);
        
        // label for selected course name 
        JLabel lblCourseName = new JLabel("Course Name");
        lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCourseName.setBounds(300, 300, 92, 26);
        p1.add(lblCourseName);
        
        // label for selected course description 
        JLabel lblCourseDescription = new JLabel("Course Description ");
        lblCourseDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCourseDescription.setBounds(300, 700, 119, 26);
        p1.add(lblCourseDescription);
        
        // label for selected course id
        JLabel lblCourseId = new JLabel("Course ID (00-99)");
        lblCourseId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCourseId.setBounds(300, 350, 119, 26);
        p1.add(lblCourseId);
        
        // label for selected course pre-reqs
        JLabel lblInstructor = new JLabel("<html><p>Prerequisite \r\nCourses (Seperate courses with a comma)<p><html>");
        lblInstructor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblInstructor.setBounds(300, 450, 157, 51);
        p1.add(lblInstructor);
        
        // label for selected course instructor 
        JLabel label = new JLabel("Instructor");
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setBounds(300, 400, 92, 26);
        p1.add(label);
        
        // label for selected course's schedule 
        JLabel lblDaysThisCourse = new JLabel("<html><p>Days this Course will be offered<p><html>");
        lblDaysThisCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDaysThisCourse.setBounds(300, 530, 102, 51);
        p1.add(lblDaysThisCourse);
        
        // course name text field
        courseName = new JTextField();
        courseName.setEditable(false);
        courseName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        courseName.setColumns(10);
        courseName.setBounds(500, 300, 186, 26);
        p1.add(courseName);
 
        // course level text field
        courseLvl = new JTextField();
        courseLvl.setEditable(false);
        courseLvl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        courseLvl.setColumns(10);
        courseLvl.setBounds(500, 200, 72, 26);
        p1.add(courseLvl);
        
        // course id text field
        courseID = new JTextField();
        courseID.setEditable(false);
        courseID.setFont(new Font("Tahoma", Font.PLAIN, 16));
        courseID.setColumns(10);
        courseID.setBounds(500, 350, 186, 26);
        p1.add(courseID);
        
        // course id timeslot label
        JLabel lblTimeslot = new JLabel("Time Slot");
        lblTimeslot.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTimeslot.setBounds(300, 600, 92, 26);
        p1.add(lblTimeslot);
        
        // start time text field
        startTime = new JTextField();
        startTime.setEditable(false);
        startTime.setBounds(600, 600, 80, 32);
        p1.add(startTime);
        startTime.setColumns(10);
        
        // finish time text field
        finishTime = new JTextField();
        finishTime.setEditable(false);
        finishTime.setColumns(10);
        finishTime.setBounds(800, 600, 80, 32);
        p1.add(finishTime);
        
        // start time label
        JLabel lblStartTime = new JLabel("Start Time");
        lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblStartTime.setBounds(500, 600, 69, 26);
        p1.add(lblStartTime);
        
        // finish time label
        JLabel lblFinishTime = new JLabel("Finish Time");
        lblFinishTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFinishTime.setBounds(700, 600, 69, 26);
        p1.add(lblFinishTime);
        
        // course credit label
        JLabel lblCourseCredits = new JLabel("Course Credits");
        lblCourseCredits.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCourseCredits.setBounds(300, 650, 92, 26);
        p1.add(lblCourseCredits);
        
        // course credit text area
        courseCredit = new JTextArea();
        courseCredit.setEditable(false);
        courseCredit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        courseCredit.setBounds(500, 650, 72, 26);
        p1.add(courseCredit);
        
        // course pre-req text area
        coursePreReq = new JTextArea();
        coursePreReq.setEditable(false);
        coursePreReq.setLineWrap(true);
        coursePreReq.setBounds(500, 450, 216, 65);
        p1.add(coursePreReq);
        
        // course description text area
        courseDesc = new JTextArea();
        courseDesc.setEditable(false);
        courseDesc.setLineWrap(true);
        courseDesc.setBounds(500, 700, 244, 113);
        p1.add(courseDesc);
        
        // array list that retrieves all programs in db 
        ArrayList proGram = tool.getPrograms();
        String [] programs = new String[proGram.size()];
        for (int x = 0; x < programs.length; x++){
            programs[x] = (String)proGram.get(x);
        }
        
        // instructor text field
        courseInstructor = new JTextField();
        courseInstructor.setEditable(false);
        courseInstructor.setBounds(500, 400, 186, 27);
        p1.add(courseInstructor);
        courseInstructor.setColumns(10);
        
        // schedule text area
        daysOffered = new JTextArea();
        daysOffered.setEditable(false);
        daysOffered.setBounds(500, 530, 216, 51);
        p1.add(daysOffered);
        daysOffered.setColumns(10);
        
        // program text field
        programCourse = new JTextField();
        programCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
        programCourse.setEditable(false);
        programCourse.setColumns(10);
        programCourse.setBounds(500, 240, 186, 26);
        p1.add(programCourse);
        
        // program label
        JLabel lblProgram = new JLabel("Program");
        lblProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblProgram.setBounds(300, 240, 92, 26);
        p1.add(lblProgram);
        
        
        // edit button that allows fields to be editable by user
        JButton btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Displays Course info on UI
                courseName.setEditable(true);
                courseLvl.setEditable(true);
                startTime.setEditable(true);
                finishTime.setEditable(true);
                courseCredit.setEditable(true);
                coursePreReq.setEditable(true);
                courseDesc.setEditable(true);
                daysOffered.setEditable(true);
                courseInstructor.setEditable(true);
                courseID.setEditable(true);
                programCourse.setEditable(true);
                
                // get course info, code, program name to create string with extracted information
                ArrayList courseInfo = tool.getCourseInfo((String)coursesSelect.getSelectedItem());
                String courseCode = ((String)courseInfo.get(0));
                StringBuilder prgCode = new StringBuilder();
                String level = "";
                StringBuilder courseNum = new StringBuilder();
                for (int i = 0; i < courseCode.length(); i++)
                {
                    if(i < 4) {
                        prgCode.append(courseCode.charAt(i));
                    }
                    else if(i == 4) { level = "" + courseCode.charAt(i); }
                    else { courseNum.append(courseCode.charAt(i)); }
                }
                String codes;
                int index = -1;
                for(int j = 0; j < (tool.getPrograms()).size(); j++) {
                    codes = (tool.getProgramCode((String)tool.getPrograms().get(j)));
                    if(codes.equals(prgCode.toString()))
                    {
                        index = j;
                    }
                }
                /* setting the text boxes in the GUI to show existing data for
                 * selected course
                 */
                courseName.setText((String)coursesSelect.getSelectedItem());
                courseLvl.setText(level);
                courseID.setText(courseNum.toString());
                courseInstructor.setText((String)courseInfo.get(1));
                coursePreReq.setText((String)courseInfo.get(2));
                daysOffered.setText((String)courseInfo.get(3));
                startTime.setText((String)courseInfo.get(4));
                finishTime.setText((String)courseInfo.get(5));
                courseCredit.setText((String)courseInfo.get(6));
                courseDesc.setText((String)courseInfo.get(7));
                programCourse.setText((String)courseInfo.get(8));
               
                /*
                 * saving old course information for modification
                 */
                oldName = (String)coursesSelect.getSelectedItem();
                oldLvl = level;
                oldID = courseNum.toString();
                
                oldCode = oldLvl + oldID + oldProgram;
                oldInstructor = (String)courseInfo.get(1);
                oldPreReq = (String)courseInfo.get(2);
                oldDaysOffered = (String)courseInfo.get(3);
                oldStart = (String)courseInfo.get(4);
                oldFinish = (String)courseInfo.get(5);
                oldCredit = (String)courseInfo.get(6);
                oldDesc = (String)courseInfo.get(7);
                oldProgram = (String)courseInfo.get(8);
                
                List<String> oldDays = new ArrayList<String>();
                oldDays = Arrays.asList(oldDaysOffered.split("\\s*,\\s*"));
                StringBuilder dayso = new StringBuilder();
                for(int i = 0; i < oldDays.size(); i++) {
                    dayso.append(oldDays.get(i));
                    dayso.append("\n");
                }
                oldDaysO = (dayso.toString()).trim();
                
                
            }
        });
        btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEdit.setBounds(750,150, 100, 25);
        p1.add(btnEdit);
        
        // save button that overwrites existing entry in db with new information entred by user 
        JButton btnSaveCourse = new JButton("Commit Changes");
        btnSaveCourse.setForeground(Color.BLACK);
        btnSaveCourse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (courseName.getText().isEmpty()){
                    nameError.setText("Please enter valid name");
                }else{
                        // update with new information
                        List<String> days = new ArrayList<String>();
                        String ds = daysOffered.getText();
                        days = Arrays.asList(ds.split("\\s*,\\s*"));
                        
                        newName = courseName.getText();
                        newLvl = courseLvl.getText();
                        newID = courseID.getText();
                        newProgram = programCourse.getText();
                        newInstructor = courseInstructor.getText();
                        newPreReq = coursePreReq.getText();
                        newDaysOffered = days;
                        newStart = startTime.getText();
                        newFinish = finishTime.getText();
                        newCredit = courseCredit.getText();
                        newDesc = courseDesc.getText();
                        
                        // generate new course id if needed 
                        if(!newLvl.equals(oldLvl) || !newID.equals(oldID) || !newProgram.equals(oldProgram))
                        {
                            newCode = newProgram + newLvl + newID;
                        }
                        
                        StringBuilder day = new StringBuilder();
                        for(int i = 0; i < days.size(); i++) {
                            day.append(days.get(i));
                            day.append("\n");
                        }
                        newDays = (day.toString()).trim();
                        
                        // attributes for course db
                        String dbName = "COURSE NAME: ";
                        String dbCode = "COURSE CODE: ";
                        String dbInstructor = "COURSE INSTRUCTOR: ";
                        String dbPreReq = "PREQUISITE COURSES: ";
                        String dbStart = "START TIME: ";
                        String dbFinish = "FINISH TIME: ";
                        String dbCredits = "COURSE CREDITS: ";
                        String dbCourseD = "COURSE DESCRIPTION: ";
                        String dbProgram = "PROGRAM: ";
                        String db = "courseDB.txt";
                        
                        // using RWtools to edit database 
                        tool.editDB(dbName + oldName, dbName + newName, db);
                        tool.editDB(dbCode + oldCode, dbCode + newCode, db);
                        tool.editDB(dbInstructor + oldInstructor, dbInstructor + newInstructor, db);
                        tool.editDB(dbPreReq + oldPreReq,dbPreReq + newPreReq, db);
                        tool.editDB(oldDaysO, newDays, db);
                        tool.editDB(dbStart + oldStart, dbStart + newStart, db);
                        tool.editDB(dbFinish + oldFinish, dbFinish + newFinish, db);
                        tool.editDB(dbCredits + oldCredit, dbCredits + newCredit, db);
                        tool.editDB(dbCourseD + oldDesc, dbCourseD + newDesc, db);
                        tool.editDB(dbProgram + oldProgram, dbProgram + newProgram, db);
                        CardLayout card = (CardLayout) contentPane.getLayout();
                        card.show(contentPane, "mmf");
                    }
                }
        });
        btnSaveCourse.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSaveCourse.setBounds(500, 830, 300, 35);
        p1.add(btnSaveCourse);
        
        // cancel button that does not save entered information and closes window 
        JButton btnCancel = new JButton("Go Back");
        btnCancel.setForeground(Color.BLACK);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout) contentPane.getLayout();
                        card.show(contentPane, "mmf");
            }
        });
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnCancel.setBounds(850, 10, 100, 25);
        p1.add(btnCancel);
        
        p1.add(editcbg);
        
        contentPane.add(p1);
        add(p1);
        
        
    }
}


import java.util.ArrayList;

/**
* Course class for user input from AddCourse form
* @author	Angeli Manipon
* @version 	1.0
*/

public class Course {
	
	// Initialize class attributes
	private String name;
	private int level;
	private int id;
	private Program program;
	private String instructor;
	private String prerequisite;
	private String daysOffered;
	private String timeSlot;
	private double credits;
	private String description;
	public String coursename = "";
	
	// Constructor for course array in database
	public Course() { };
	private ArrayList<Course> dataBase = new ArrayList<Course>();
	
	/**
	* Course function that sets course info created from AddCourse form
	* @param	name		sets course name
	* @param	level		sets course year level (1,2,3,4)
	* @param	id		sets course ID number
	* @param	program		sets program
	* @param	instructor	sets instructor name
	* @param	prerequisite	sets prerequisite courses
	* @param	daysOffered	sets daysOffered from user selection (Mon, Tues, Wed, Thur, Fri)
	* @param	timeslot	gets StartTime and FinishTime for course
	* @param	credits		gets course credits
	* @param	description	gets course description
	* @return 	N/A
	*/
	// course class with attributes
	public Course(String name, int level, int id, Program program, String instructor, String prerequisite, String daysOffered,
			String timeSlot, double credits, String description)
	{
		setName(name);
		setLevel(level);
		setID(id);
		setProgram(program);
		setInstructor(instructor);
		setPrerequisite(prerequisite);
		setDaysOffered(daysOffered);
		setTimeSlot(timeSlot);
		setCredits(credits);
		setDescription(description);
	}
	Course(Course c)
	{
		this.name = c.name;
		this.level = c.level;
		this.id = c.id;
		this.program = c.program;
		this.instructor = c.instructor;
		this.prerequisite = c.prerequisite;
		this.daysOffered = c.daysOffered;
		this.timeSlot = c.timeSlot;
		this.credits = c.credits;
		this.description = c.description;
	}
	
	// sets course name
	public void setName(String name)
	{
		this.name = name;
	}
	
	// gets course name
	public String getName()
	{
		return name;
	}
	
	// sets course level
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	// gets course level
	public int getLevel()
	{
		return level;
	}
	
	// sets course ID
	public void setID(int id)
	{
		this.id = id;
	}
	
	// gets course ID
	public int getID()
	{
		return id;
	}
	
	// sets program
	public void setProgram(Program program)
	{
		this.program = program;
	}
	
	// gets program
	public Program getProgram()
	{
		return program;
	}
	
	// sets instructor
	public void setInstructor(String instructor)
	{
		this.instructor = instructor;
	}
	
	// gets instructor
	public String getInstructor()
	{
		return instructor;
	}
	
	// sets prerequisite
	public void setPrerequisite(String prerequisite)
	{
		this.prerequisite = prerequisite;
	}
	
	// gets prerequisite
	public String getPrerequisite()
	{
		return prerequisite;
	}
	
	// sets daysOffered
	public void setDaysOffered(String daysOffered)
	{
		this.daysOffered = daysOffered;
	}
	
	// gets daysOffered
	public String getDaysOffered()
	{
		return daysOffered;
	}
	
	// sets TimeSlot
	public void setTimeSlot(String timeSlot)
	{
		this.timeSlot = timeSlot;
	}
	
	// gets TimeSlot
	public String getTimeSlot()
	{
		return timeSlot;
	}
	
	// sets Credits
	public void setCredits(double credits)
	{
		this.credits = credits;
	}
	
	// gets Credits
	public double getCredits()
	{
		return credits;
	}
	
	// sets course name
	public void setCourseName(String name, int id)
	{
		coursename = this.name + " " + this.id;
	}
	
	// gets course name
	public String getCourseName()
	{
		coursename = this.name + " " + this.id;
		return coursename;
	}
	
	// sets description
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	// gets description
	public String getDescription()
	{
		return description;
	}
	
	// @return String of course information to send to courseDB.txt
	public String toString()
	{
		setCourseName(name, id);
		return "Course: " + coursename + "\n" + "Level: " + level + "\n" + "Program: " + program + "\n" + 
				"Instructor: " + instructor + "\n" + "Prerequisite(s): " + prerequisite + "\n" + 
				"Days Offered: " + daysOffered + "\n" + "Time Slot: " + timeSlot + "\n" + "Credits: " + credits +
				"\n" + "Description:" + description + "\n";
	}
	
}

import java.util.ArrayList;

public class Course {
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
	
	public Course() { };
	
	private ArrayList<Course> dataBase = new ArrayList<Course>();
	
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
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public int getID()
	{
		return id;
	}
	
	public void setProgram(Program program)
	{
		this.program = program;
	}
	
	public Program getProgram()
	{
		return program;
	}
	
	public void setInstructor(String instructor)
	{
		this.instructor = instructor;
	}
	
	public String getInstructor()
	{
		return instructor;
	}
	
	public void setPrerequisite(String prerequisite)
	{
		this.prerequisite = prerequisite;
	}
	
	public String getPrerequisite()
	{
		return prerequisite;
	}
	
	public void setDaysOffered(String daysOffered)
	{
		this.daysOffered = daysOffered;
	}
	
	public String getDaysOffered()
	{
		return daysOffered;
	}
	
	public void setTimeSlot(String timeSlot)
	{
		this.timeSlot = timeSlot;
	}
	
	public String getTimeSlot()
	{
		return timeSlot;
	}
	
	public void setCredits(double credits)
	{
		this.credits = credits;
	}
	
	public double getCredits()
	{
		return credits;
	}
	
	public void setCourseName(String name, int id)
	{
		coursename = this.name + " " + this.id;
	}
	
	public String getCourseName()
	{
		coursename = this.name + " " + this.id;
		return coursename;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getDescription()
	{
		return description;
	}

	public String toString()
	{
		setCourseName(name, id);
		return "Course: " + coursename + "\n" + "Level: " + level + "\n" + "Program: " + program + "\n" + 
				"Instructor: " + instructor + "\n" + "Prerequisite(s): " + prerequisite + "\n" + 
				"Days Offered: " + daysOffered + "\n" + "Time Slot: " + timeSlot + "\n" + "Credits: " + credits +
				"\n" + "Description:" + description + "\n";
	}
	
}

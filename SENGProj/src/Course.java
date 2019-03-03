
public class Course {
	
	private String name;
	private int level;
	private int id;
	private String instructor;
	private String description;
	private String[] preReq;
	private String[] daysOffered;
	private String startTime;
	private String finishTime;
	
	public Course(String name, int level, int id, String instructor, String description, String[] preReq, 
			String[] daysOffered, String startTime, String finishTime)
	{
		this.setName(name);
		this.setLevel(level);
		this.setId(id);
		this.setInstructor(instructor);
		this.setDescription(description);
		this.setPreReq(preReq);
		this.setDaysOffered(daysOffered);
		this.setStartTime(startTime);
		this.setFinishTime(finishTime);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getPreReq() {
		return preReq;
	}

	public void setPreReq(String[] preReq) {
		this.preReq = preReq;
	}

	public String[] getDaysOffered() {
		return daysOffered;
	}

	public void setDaysOffered(String[] daysOffered) {
		this.daysOffered = daysOffered;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	
	
}

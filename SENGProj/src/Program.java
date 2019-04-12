/**
* Program class for user input from AddCourse form
* @author	Teddy Kalp
* @version 	1.0
*/

public class Program {
	
	// Class attributes
	private String name;
	private String description;
	private String department;
	private String abbr;
	private String type;
	private String level;
	private float gpa;
	private String[] required;
	
	/**
	* Program function that sets program info from AddProgram input
	* @param	name		course name
	* @param	description	course description
	* @param	department	course dept
	* @param	level		course level
	* @param	type		course type
	* @param	gpa		required GPA
	* @param	abbr		course abbreviation
	* @return 	N/A
	*/
	public Program(String name, String description, String department, String level , String type, float gpa, String abbr){
		this.setName(name);
		this.setDescription(description);
		this.setDepartment(department);
		this.setType(type);
		this.setGpa(gpa);
		this.setLevel(level);
		this.setAbbr(abbr);
		}

	// get program name
	public String getName() {
		return name;
	}
	
	// set program name
	public void setName(String name) {
		this.name = name;
	}
	
	// get program description
	public String getDescription() {
		return description;
	}
	
	// set program description
	public void setDescription(String description) {
		this.description = description;
	}
	
	// get department
	public String getDepartment() {
		return department;
	}
	
	// set department
	public void setDepartment(String department) {
		this.department = department;
	}
	
	// get program type
	public String getType() {
		return type;
	}
	
	// set program type
	public void setType(String type) {
		this.type = type;
	}

	// get program gpa
	public float getGpa() {
		return gpa;
	}
	
	// set program gpa
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	
	// get program level
	public String getLevel() {
		return level;
	}
	
	// set program level
	public void setLevel(String level) {
		this.level = level;
	}
	
	// get required array
	public String[] getRequired() {
		return required;
	}
	
	// set required array
	public void setRequired(String[] required) {
		this.required = required;
	}

	// get abbreviation
	public String getAbbr() {
		return abbr;
	}
	
	// set abbreviation 
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
	
}


public class Program {
	
	private String name;
	private String description;
	private String department;
	private String abbr;
	private String type;
	private String level;
	private float gpa;
	private String[] required;
	
	public Program(String name, String description, String department, String level , String type, float gpa, String abbr){
		this.setName(name);
		this.setDescription(description);
		this.setDepartment(department);
		this.setType(type);
		this.setGpa(gpa);
		this.setLevel(level);
		this.setAbbr(abbr);
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String[] getRequired() {
		return required;
	}

	public void setRequired(String[] required) {
		this.required = required;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
	
}

import java.util.ArrayList;

/**
* CourseData class extends Course for user input from AddCourse form
* @author	Angeli Manipon
* @version 	1.0
*/

public class CourseData extends Course {
	
	public CourseData(String name, int level, int id, Program program, String instructor, String prerequisite, String daysOffered,
			String timeSlot, double credits, String description) {
		super(name, level, id, program, instructor, prerequisite, daysOffered,
			timeSlot, credits, description);
	}

	public static ArrayList<Course> courseL = new ArrayList<Course>();
	
	/**
	* addCourse function to add a course to the course list
	* @param	course - course to be added to list
	* @return	N/A
	*/
	public static void addCourse(Course course)
	{
		courseL.add(new Course(course));
		arrange(courseL, 0, courseL.size()-1);
	}
	
	/**
	* arrange function to arrange course list
	* @param	ArrayList<Course> - course to be added to list
	* @param	l 
	* @param	h
	* @return	N/A
	*/
	public static void arrange(ArrayList<Course> c, int l, int h) {
		if(c.size() <= 1)
			return;
		else 
		{
			if(l < h)
			{
				int p = part(c, l, h);
				arrange(c, l, p - 1);
				arrange(c, p + 1, h);
			}
		}
	}
	/**
	* part function to arrange course list
	* @param	ArrayList<Course> - course to be added to list
	* @param	l 
	* @param	h
	* @return	N/A
	*/
	private static int part(ArrayList<Course> c, int l, int h) {
		int i = l - 1;
		Course piv = c.get(h);
		
		for(int j = l; j < h; j++) {
			if(c.get(j).getCourseName().compareTo(piv.getCourseName()) < 0)
			{
					i++;
					swap(c, i, j);
			}
		}
		swap(c, i + 1, h);
		return i + 1;
	}

	/**
	* swap function to help arrange course list
	* @param	ArrayList<Course> - course to be added to list
	* @param	l 
	* @param	h
	* @return	N/A
	*/
	private static void swap(ArrayList<Course> c, int i, int j) {
		Course temp = c.get(i);
		c.set(i, c.get(j));
		c.set(j, temp);
	}
	
}

import java.util.ArrayList;

public class CourseData extends Course {
	
	public CourseData(String name, int level, int id, Program program, String instructor, String prerequisite, String daysOffered,
			String timeSlot, double credits, String description) {
		super(name, level, id, program, instructor, prerequisite, daysOffered,
			timeSlot, credits, description);
	}

	public static ArrayList<Course> courseL = new ArrayList<Course>();
	
	public static void addCourse(Course course)
	{
		courseL.add(new Course(course));
		arrange(courseL, 0, courseL.size()-1);
	}

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
	
	private static void swap(ArrayList<Course> c, int i, int j) {
		Course temp = c.get(i);
		c.set(i, c.get(j));
		c.set(j, temp);
	}
	
}

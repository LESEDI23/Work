import java.util.*;
public class CourseNameComparator implements Comparator<Course> {

	@Override
	public int compare(Course course1, Course course2) {
		
		return course1.getCourseName().compareTo(course2.getCourseName());
		
	}
	
	

}

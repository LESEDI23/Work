import java.util.*;
public class CourseStudentComparator implements Comparator<Course> {

	@Override
	public int compare(Course course1, Course course2) {
		return course1.getNumberOfStudents() - course2.getNumberOfStudents();
	}

	
}

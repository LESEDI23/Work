import java.util.*;
public class Course implements Comparable<Course> {

	String courseName;
	int numberOfStudents;
	String courseLecturer;


	public Course(String courseName, int numberOfStudents, String courseLecturer) {
		this.courseName = courseName;
		this.numberOfStudents = numberOfStudents;
		this.courseLecturer = courseLecturer;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public int getNumberOfStudents() {
		return numberOfStudents;
	}


	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}


	public String getCourseLecturer() {
		return courseLecturer;
	}


	public void setCourseLecturer(String courseLecturer) {
		this.courseLecturer = courseLecturer;
	}


	public String toString() {
		return String.format("%s, %s, %d", courseName, courseLecturer, numberOfStudents);
	}


	public int compareTo(Course course2) {
		return this.getNumberOfStudents() -  course2.getNumberOfStudents();
	}

}

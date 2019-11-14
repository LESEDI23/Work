import java.util.*;
public class App {

	public static void main(String[] args) {
		
		List<Course> courses1 = new ArrayList<>();
		
		courses1.add(new Course("Java", 23, "Peter"));
		courses1.add(new Course("Python", 20, "Paul"));
		courses1.add(new Course("MySQL", 32, "Jason"));
		courses1.add(new Course("C++",13,"Leonard"));
		courses1.add(new Course("JavaScript", 52, "Kyle"));
		
		//Sort the list-- using the comparable interface insode the class declaration
		Collections.sort(courses1);
		System.out.println("Courses after sorting: " + courses1);
		
		//Swap the elements at position 1 and position 2
		Collections.swap(courses1,1,2);
		System.out.println("Courses after swapping: " + courses1);
		
		//Create a new array called courses2
		List<Course> courses2 = new ArrayList<>();
		Collections.addAll(courses2, 
				new Course ("Python Machine Learning", 43, "Heather"),
				new Course ("C++ for Dummies", 31, "Jessica"),
				new Course ("JavaScript in a Nutshell", 21, "Lauren"),
				new Course ("Advanced Algorithms", 11, "Amy"),
				new Course ("Basic Algorithms", 19, "Tammy"));
		System.out.println("The new list: " + courses2);
		
		//Copy all of the courses from courses1 to courses2
		Collections.copy(courses2, courses1);
		
		//Add 2 elements to courses2
		courses2.add(new Course("Java 101", 34, "P.Green"));
		courses2.add(new Course("Advanced Programming", 18, "Prof. M Milton"));
		
		//Sort the courses in course 2 -- Using the CourseNameComparator
		Collections.sort(courses2,new CourseNameComparator());
		System.out.println("After sorting by Course Name: " + courses2);
		
		
		//Search for the course Java 101 in courses 2 --- I cannot understand why this comparator is working in the above sort, but won't work here.
		//int index = Collections.binarySearch(courses2, "Java 101", new CourseNameComparator());
		
		courses2.add (new Course("Java", 23, "Peter")); // Added to test the disjoint method.
		
		boolean disjointed = Collections.disjoint(courses1, courses2); // I specifically added an identical Course to courses 2, so that this would set to true. But it is not working. How is this happening?
		System.out.println(disjointed ? "The lists share elements" : "The lists don't share elements");
		
		
		//Find the class with the most students and with the least students
		System.out.println("The class with the most students is " + Collections.max(courses2, new CourseStudentComparator()));
		System.out.println("The class with the least students is " + Collections.min(courses2, new CourseStudentComparator()));
		
		
	}

}

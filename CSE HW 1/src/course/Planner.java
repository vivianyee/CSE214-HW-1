package course;

/**
 * The <code>Planner</code> class implements a list of <code>Course</code>
 * objects.
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class Planner {	
	Course[] arr = new Course[50]; // The planner has a maximum of 50 courses
	private int size = 0; // The size of the array (how many courses are in the planner
						  // starting with 0 courses
	
	/**
	 * 
	 */
	public Planner() {
		
	}
	
	/**
	 * 
	 * @return	
	 * 		Returns how many courses are in the planner
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Adds the course given by the user
	 * 
	 * @param newCourse
	 * 		Course is what the user provides
	 * @param position
	 * 		Position is the input the user provides
	 * 		of where they want the course to be
	 */
	public void addCourse(Course newCourse, int position) {
		if(arr[position-1]==null) {
			arr[position-1] = newCourse;
		}else {
			int y = size();
			for(int i = y+1; i > position-1; i--) {
				arr[i] = arr[i-1];
			}
			arr[position-1] = newCourse;
		}
		size++;
	}
	
	/**
	 * Removes the course of the given position
	 * 
	 * @param position
	 * 		Position is the input the user provides 
	 * 		of what they want to remove
	 */
	public void removeCourse(int position) {
		int y = size();
		for(int i = position-1; i < y; i++) {
			arr[i] = arr[i+1];
		}
		size--;
	}
	
	/**
	 * Gives the course of the given position
	 * 
	 * @param position
	 * 		Position is the input that the user provides
	 * 		of what course they want to get
	 * @return
	 * 		Returns the course that is in the position
	 * 		(the parameter - 1) since the position the 
	 * 		user gives is 1 more than the array because
	 * 		the array starts at position 0
	 */
	public Course getCourse(int position) {
		return(arr[position-1]);
	}
	
	/**
	 * Filters out everything except the courses that have the 
	 * department code and prints it
	 * 
	 * @param planner
	 * 		Planner that holds all the courses
	 * @param department
	 * 		The department that the user inputs
	 */
	public static void filter(Planner planner, String department) {
		int y = 0;
		int count = 0;
		for(int i = 0;i < planner.size();i++) {
			Course x = planner.getCourse(i+1);
			if(x.getDepartment().compareTo(department)==0) {
				if(count==0) {
					System.out.println("No. Course Name          "
							+ "Department  Code  Section Instructor"+
							"\n------------------------------------"
							+ "------------------------------------");
				}
				System.out.printf("%-3s %-20s %-11s %-5s %-7s %-5s %n",
						i+1,x.getCname(),x.getDepartment(),x.getCode(),
						0+x.getSection(),x.getInstructor());
				y++;
				count++;
			}
		}
		if(y==0) {
			System.out.println(department
					+ " department is not found in the planner");
		}
		
	}
	
	/**
	 * Sees if the course exists within the planner
	 * 
	 * @param course
	 * 		The course that the user inputs to see if it exists
	 * 		in the planner
	 * @return
	 * 		Returns true or false if the course exists within
	 * 		the planner
	 */
	public boolean exists(Course course) {
		int y = size();
		for(int i = 0; i < y; i++) {
			if(arr[i].equals(course)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Gives the position of the course that the user
	 * provides
	 * 
	 * @param course
	 * 		The course that the user wants to find 
	 * @return
	 * 		Returns the position of the course
	 */
	public int position(Course course) {
		for(int i = 0; i < size; i++) {
			if(arr[i].equals(course)) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * Gives a backup of the current planner the user is using
	 * 
	 * @return
	 * 		Returns the new planner object <code>planb<code> so that
	 * 		it can be the backup of the actual planner
	 */
	public Object clone() {
		Planner planb = new Planner();
		for(int i = 0; i < size; i++) {
			planb.addCourse((Course) arr[i].clone(), i+1);
		}
		return planb;
	}
	
	/**
	 * Prints the courses that the user wants
	 * 
	 */
	public void printAllCourses() {
		int y = size();
		System.out.println(toString());
		for(int i = 0; i < y; i++) {
			System.out.printf("%-3s %-20s %-11s %-5s %-7s %-5s %n",
					(i+1),arr[i].getCname(),arr[i].getDepartment(),
					arr[i].getCode(),0+arr[i].getSection(),arr[i].getInstructor());
		}
	}
	
	/**
	 * Prints heading of planner
	 * 
	 * @return
	 * 		Returns string of the top portion of the <code>printAllCourses<code>
	 * 		method
	 */
	public String toString() {
		return("\nNo. Course Name          "
				+ "Department  Code  Section Instructor"+
				"\n------------------------------------"
				+ "------------------------------------");
	}
}

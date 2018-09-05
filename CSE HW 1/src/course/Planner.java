package course;

public class Planner {	
	Course[] arr = new Course[50];
	
	public Planner() {
	
	}
	
	public int size() {
		int x = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]!=null) {
				x++;
			}
		}
		return x;
	}
	
	public void addCourse(Course newCourse, int position) {
		arr[position-1] = newCourse;
	}
	
	public void removeCourse(int position) {
		for(int i = position-1; i < arr.length; i++) {
			arr[i] = arr[i+1];
		}
	}
	
	public Course getCourse(int position) {
		return(arr[position-1]);
	}
	
	public static void filter(Planner planner, String department) {
		
	}
	
	public boolean exists(Course course) {
		
	}
	
	public Object clone() {
		
	}
	
	public void printAllCourses() {
		int y = 0;
		System.out.printf("%-3s %-20s %-11s %-5s %-7s %-5s %n","No.","Course Name","Department", "Code", "Section", "Instructor");
		System.out.println("\r\n" + "------------------------------------------------------------------------------" + "\r\n");
		while(arr[y]!=null) {
			y++;
		}
		for(int i = 0; i < y; i++) {
			System.out.printf("%-3s %-20s %-11s %-5s %-7s %-5s %n",(i+1),arr[i].getCname(),arr[i].getDepartment(),arr[i].getCode(),arr[i].getSection(),arr[i].getInstructor());
		}
	}
	
	public String toString() {
		
	}
}

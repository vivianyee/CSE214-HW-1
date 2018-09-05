package course;

public class Planner {	
	Course[] arr = new Course[50];
	
	public Planner() {
	
	}
	
	public int size() {
		int y = 0;
		while(arr[y]!=null) {
			y++;
		}
		return y;
	}
	
	public void addCourse(Course newCourse, int position) {
		if(arr[position-1]==null) {
			arr[position-1] = newCourse;
		}else {
			int y = 0;
			while(arr[y]!=null) {
				y++;
			}
			for(int i = y+1; i > position-1; i--) {
				arr[i] = arr[i-1];
			}
			arr[position-1] = newCourse;
		}
	}
	
	public void removeCourse(int position) {
		int y = 0;
		while(arr[y]!=null) {
			y++;
		}
		for(int i = position-1; i < y; i++) {
			arr[i] = arr[i+1];
		}
	}
	
	public Course getCourse(int position) {
		return(arr[position-1]);
	}
	
	public static void filter(Planner planner, String department) {
		System.out.println("\n");
		System.out.printf("%-3s %-20s %-11s %-5s %-7s %-5s %n","No.","Course Name","Department", "Code", "Section", "Instructor");
		System.out.println("------------------------------------------------------------------------");
		for(int i = 0;i < planner.size();i++) {
			if(planner.getCourse(i).getDepartment() == department) {
				System.out.printf("%-3s %-20s %-11s %-5s %-7s %-5s %n","No.","Course Name","Department", "Code", "Section", "Instructor");
			}
		}
	}
	
	public boolean exists(Course course) {
		
	}
	
	public Object clone() {
		
	}
	
	public void printAllCourses() {
		int y = 0;
		System.out.println("/n");
		System.out.printf("%-3s %-20s %-11s %-5s %-7s %-5s %n","No.","Course Name","Department", "Code", "Section", "Instructor");
		System.out.println("------------------------------------------------------------------------");
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

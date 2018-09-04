package course;

import java.util.Scanner;

public class PlannerManager {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("(A) Add Course\r\n" + 
				"(G) Get Course\r\n" + 
				"(R) Remove Course\r\n" + 
				"(P) Print Courses in Planner\r\n" + 
				"(F) Filter by Department Code\r\n" + 
				"(L) Look For Course\r\n" + 
				"(S) Size\r\n" + 
				"(B) Backup\r\n" + 
				"(PB) Print Courses in Backup\r\n" + 
				"(RB) Revert to Backup\r\n" + 
				"(Q) Quit\r\n\n" + 
				"Enter a selection: ");
		String n = scanner.nextLine();
		if(n == "A") {
			Planner x = new Planner();
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter course name: ");
			String a = scanner.nextLine();
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter position: ");
			String a = scanner.nextLine();
			x.addCourse(newCourse, position);
		}else if(n == "G") {
			
		}else if(n == "R") {
			
		}else if(n == "P") {
			
		}else if(n == "F") {
			
		}else if(n == "L") {
			
		}else if(n == "S") {
			
		}else if(n == "B") {
			
		}else if(n == "PB") {
			
		}else if(n == "RB") {
			
		}else if(n == "Q") {
			 System.exit(0);
		}
	}
}

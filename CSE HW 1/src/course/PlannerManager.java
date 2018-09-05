package course;

import java.util.Scanner;

public class PlannerManager {
	static Planner plan = new Planner();
	
	public static void main(String[] args) {
		Input();
	}
	
	public static void Input() {
		Scanner scanner = new Scanner(System.in);
		displayMenu();
		String n = scanner.nextLine();
		
		if(n.compareTo("A")==0) { // ADD COURSE
			addCourse();
		}else if(n.compareTo("G")==0) { // GET COURSE
			getCourse();
		}else if(n.compareTo("R")==0) { // REMOVE COURSE
			removeCourse();
		}else if(n.compareTo("P")==0) { // PRINT PLANNER
			printPlanner();
		}else if(n.compareTo("F")==0) { // FILTER PLANNER
			filterPlanner();
		}else if(n.compareTo("L")==0) { // LOOK COURSE
			lookCourse();
		}else if(n.compareTo("S")==0) { // SIZE PLANNER
			sizePlanner();
		}else if(n.compareTo("B")==0) { // BACKUP PLANNER
			backupPlanner();
		}else if(n.compareTo("BP")==0) { // PRINT BACKUP
			printBackup();
		}else if(n.compareTo("RB")==0) { // REVERT BACKUP
			revertBackup();
		}else if(n.compareTo("Q")==0) { // QUIT
			System.exit(0);
		}
	}
	
	public static void displayMenu() {
		System.out.print("\n\n(A) Add Course\r\n" + 
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
	}
	
	public static void addCourse() { //nice
		Scanner scanner1 = new Scanner(System.in);
		System.out.print("Enter course name: ");
		String aa = scanner1.nextLine();
		System.out.print("Enter department: ");
		String ac = scanner1.nextLine();
		System.out.print("Enter instructor: ");
		String af = scanner1.nextLine();
		System.out.print("Enter course code: ");
		int ad = scanner1.nextInt();
		System.out.print("Enter course section: ");
		byte ae = scanner1.nextByte();
		System.out.print("Enter position: ");
		int ab = scanner1.nextInt();
		System.out.print("\n" + ab + " " + ac + "." + ad + " successfully added to planner\n");
		Course ax = new Course(aa,ac,ae,ad,af);
		plan.addCourse(ax,ab);
		Input();
	}
	
	public static void getCourse() { //nice
		Scanner scanner3 = new Scanner(System.in);
		System.out.println("Enter position: ");
		int ga = scanner3.nextInt();
		Course gx = plan.getCourse(ga);
		System.out.printf("%-3s %-20s %-11s %-5s %-7s %-5s %n","No.","Course Name","Department", "Code", "Section", "Instructor");
		System.out.println("------------------------------------------------------------------------");
		System.out.printf("%-3s %-20s %-11s %-5s %-7s %-5s %n",ga,gx.getCname(),gx.getDepartment(),gx.getCode(),gx.getSection(),gx.getInstructor());
		Input();
	}
	
	public static void removeCourse() { //nice
		Scanner scanner4 = new Scanner(System.in);
		System.out.println("Enter position: ");
		int ra = scanner4.nextInt();
		plan.removeCourse(ra);
		System.out.println("");
		Input();
	}
	
	public static void printPlanner() { //nice
		plan.printAllCourses();
		Input();
	}
	
	public static void filterPlanner() { //nice
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Enter department code: ");
		String fa = scanner2.nextLine();
		Planner.filter(plan,fa);
		Input();
	}
	
	public static void lookCourse() { 
		Scanner scanner5 = new Scanner(System.in);
		System.out.print("Enter course name: ");
		String la = scanner5.nextLine();
		System.out.print("Enter department: ");
		String lb = scanner5.nextLine();
		System.out.print("Enter instructor: ");
		String le = scanner5.nextLine();
		System.out.print("Enter course code: ");
		int lc = scanner5.nextInt();
		System.out.print("Enter course section: ");
		byte ld = scanner5.nextByte();
		System.out.print("Enter position: ");
		int lf = scanner5.nextInt();
		System.out.print("");
		Input();
	}
	
	public static void sizePlanner() {
		System.out.print("There are " + plan.size() + " courses in the planner");
		Input();
	}
	
	public static void backupPlanner() {
		System.out.println("Created a backup of the current planner.");
		Input();
	}
	
	public static void printBackup() {
		System.out.printf("%-3s %-20s %-11s %-5s %-7s %-5s %n","No.","Course Name","Department", "Code", "Section", "Instructor");
		System.out.println("------------------------------------------------------------------------");
		Input();
	}
	
	public static void revertBackup() {
		System.out.println("Planner successfully reverted to the backup copy.");
		Input();
	}

}

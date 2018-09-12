package course;

import java.util.Scanner;

/**
 * The <code>PlannerManager</code> class runs the project
 * and directs where the user input goes
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class PlannerManager {
	static Planner plan = new Planner(); // Original planner for user
	static Planner planb = new Planner(); // Holds backup planner
	
	/**
	 * Goes to <code>input<code>
	 * 
	 * @param args
	 * @throws IllegalElementException 
	 */
	public static void main(String[] args) throws IllegalElementException{
		Input();
	}
	
	/**
	 * Provides inputs and which methods to go to depending on 
	 * user input
	 * 
	 * Case insensitive
	 * If put anything else, program will terminate
	 * @throws IllegalElementException 
	 * 
	 */
	public static void Input() throws IllegalElementException {
		Scanner scanner = new Scanner(System.in);
		displayMenu();
		String n = scanner.nextLine();
		if(n.equalsIgnoreCase("A")) { // ADD COURSE
			addCourse();
		}else if(n.equalsIgnoreCase("G")) { // GET COURSE
			getCourse();
		}else if(n.equalsIgnoreCase("R")) { // REMOVE COURSE
			removeCourse();
		}else if(n.equalsIgnoreCase("P")) { // PRINT PLANNER
			printPlanner();
		}else if(n.equalsIgnoreCase("F")) { // FILTER PLANNER
			filterPlanner();
		}else if(n.equalsIgnoreCase("L")) { // LOOK COURSE
			lookCourse();
		}else if(n.equalsIgnoreCase("S")) { // SIZE PLANNER
			sizePlanner();
		}else if(n.equalsIgnoreCase("B")) { // BACKUP PLANNER
			backupPlanner();
		}else if(n.equalsIgnoreCase("PB")) { // PRINT BACKUP
			printBackup();
		}else if(n.equalsIgnoreCase("RB")) { // REVERT BACKUP
			revertBackup();
		}else if(n.equalsIgnoreCase("Q")) { // QUIT
			System.out.println("\nProgram terminating successfully...");
			System.exit(0);
		}else {
			Input();
		}
	}
	
	/**
	 * Displays menu
	 * 
	 */
	public static void displayMenu() {
		System.out.print("\n\n------------------------------\r\n" +
				"(A) Add Course\r\n" + 
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
	
	/**
	 * Adds courses to planner by asking user to input different 
	 * sections of the new course
	 * 
	 * <dt>Precondition:
	 * 		User must input String for course name, department, and instructor
	 * 		User must input int for course code, section, and position
	 * 
	 * <dt>Postcondition:
	 * 		Adds the course to the planner <code>plan<code>
	 * @throws IllegalElementException 
	 */
	public static void addCourse() throws IllegalElementException { //nice
		int count=0;
		Scanner scanner1 = new Scanner(System.in);
		System.out.print("\nEnter course name: ");
		String aa = scanner1.nextLine();
		System.out.print("Enter department: ");
		String ac = scanner1.nextLine();
		System.out.print("Enter course code: ");
		int ad = scanner1.nextInt();
		System.out.print("Enter course section: ");
		byte ae = scanner1.nextByte();
		scanner1.nextLine();
		System.out.print("Enter instructor: ");
		String af = scanner1.nextLine();
		System.out.print("Enter position: ");
		int ab = scanner1.nextInt();
		Course ax = null;
		try {
			ax = new Course(aa, ac, ae, ad, af);
		} catch (IllegalElementException e) {
			count++;
			System.out.println(e);
		}
		if(count==0) {
			plan.addCourse(ax,ab);
			System.out.print("\n" + ac + " " + ad + "." + 0 + ae 
					+ " successfully added to planner\n");
			Input();
		}else {
			Input();
		}
	}
	
	/**
	 * Gets course based on position given by user by asking for
	 * what position the user wants to get
	 * 
	 * <dt>Precondition:
	 * 		User must input a position that is within Planner's size
	 * 
	 * <dt>Postcondition:
	 * 		Prints out the course name, department, code, section,
	 * 		and instructor based on the position given
	 * @throws IllegalElementException 
	 */
	public static void getCourse() throws IllegalElementException { //nice
		Scanner scanner3 = new Scanner(System.in);
		System.out.println("\nEnter position: ");
		int ga = scanner3.nextInt();
		if(plan.size()<ga) {
			System.out.println("\nPosition not found in planner");
		}else {
			Course gx = plan.getCourse(ga);
			System.out.println("\nNo. Course Name          "
					+ "Department  Code  Section Instructor"+
					"\n------------------------------------"
					+ "------------------------------------");
			System.out.printf("%-3s %-20s %-11s %-5s %-7s %-5s %n",
					ga,gx.getCname(),gx.getDepartment(),gx.getCode(),
					 0+gx.getSection(),gx.getInstructor());
		}
		Input();
	}
	
	/**
	 * Removes course based on position given by user by asking what
	 * position the user wants the course to be removed
	 * 
	 * <dt>Precondition:
	 * 		User must input a position that is within Planner's size
	 * 
	 * <dt>Postcondition:
	 * 		Prints either if the position is not found in planner or
	 * 		removes the course in the position
	 * @throws IllegalElementException 
	 */
	public static void removeCourse() throws IllegalElementException { //nice
		Scanner scanner4 = new Scanner(System.in);
		System.out.println("\nEnter position: ");
		int ra = scanner4.nextInt();
		if(plan.size()<ra) {
			System.out.println("\nPosition not found in planner");
		}else {
			System.out.println(plan.getCourse(ra).getCname() + " " 
					+ plan.getCourse(ra).getCode() + "." + 0 
					+ plan.getCourse(ra).getSection() + " has been successfully"
					+ " removed from the planner.");
			plan.removeCourse(ra);
		}
		Input();
	}
	
	/**
	 * Prints planner
	 * @throws IllegalElementException 
	 * 
	 */
	public static void printPlanner() throws IllegalElementException { //nice
		plan.printAllCourses();
		Input();
	}
	
	/**
	 * Prints courses with department user inputs
	 * 
	 * <dt>Precondition:
	 * 		Department has to be String and within the Planner
	 * 
	 * <dt>Postcondition:
	 * 		Prints out the filtered courses based on the department
	 * 		given by the user
	 * @throws IllegalElementException 
	 */
	public static void filterPlanner() throws IllegalElementException { //nice
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("\nEnter department code: ");
		String fa = scanner2.nextLine();
		System.out.println("\n");
		Planner.filter(plan,fa);
		Input();
	}
	
	/**
	 * Looks up if course exists and prints position
	 * 
	 * <dt>Precondition:
	 * 		Course name, department, instructor, code, and 
	 * 		section must be a part of planner
	 * 
	 * <dt>Postcondition:
	 * 		Prints the course and where it is located in the planner
	 * @throws IllegalElementException 
	 */
	public static void lookCourse() throws IllegalElementException { 
		Scanner scanner5 = new Scanner(System.in);
		System.out.print("\nEnter course name: ");
		String la = scanner5.nextLine();
		System.out.print("Enter department: ");
		String lb = scanner5.nextLine();
		System.out.print("Enter course code: ");
		int lc = scanner5.nextInt();
		System.out.print("Enter course section: ");
		byte ld = scanner5.nextByte();
		scanner5.nextLine();
		System.out.print("Enter instructor: ");
		String le = scanner5.nextLine();
		Course x = new Course(la,lb,ld,lc,le);
		int pos = plan.position(x)+1;
		if(plan.exists(x)) {
			System.out.println("\n" + lb + " " + lc + "." + 0+ld 
					+ " is found in the planner at position " 
					+ pos);
		}else {
			System.out.println("\n" + lb + " " + lc + "." + 0+ld
					+ " is not found in the planner");
		}
		Input();
	}
	
	/**
	 * Prints how many courses planner has
	 * 
	 * <dt>Postcondition:
	 * 		Prints size of planner
	 * @throws IllegalElementException 
	 */
	public static void sizePlanner() throws IllegalElementException { //nice
		System.out.print("\nThere are " + plan.size() + " courses in the planner");
		Input();
	}
	
	/**
	 * Backs planner up
	 * 
	 * <dt>Postcondition:
	 * 		Saves current planner
	 * @throws IllegalElementException 
	 */
	public static void backupPlanner() throws IllegalElementException { //nice
		planb = (Planner) plan.clone();
		System.out.println("\nCreated a backup of the current planner.");
		Input();
	}
	
	/**
	 * Prints backup planner
	 * @throws IllegalElementException 
	 * 
	 */
	public static void printBackup() throws IllegalElementException { //nice
		planb.printAllCourses();
		Input();
	}
	
	/**
	 * Turns planner into backup planner
	 * @throws IllegalElementException 
	 * 
	 */
	public static void revertBackup() throws IllegalElementException { //nice
		plan = (Planner) planb.clone();
		System.out.println("\nPlanner successfully reverted to the backup copy.");
		Input();
	}
		

}

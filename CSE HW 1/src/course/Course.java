package course;

/**
 * 
 * The <code>Course</code> class initiates what the course
 * has to contain
 * 
 * @author Vivian Yee
 * 		e-mail: vivian.yee@stonybrook.edu
 * 		Stonybrook ID: 112145534
 */
public class Course {
	private String cname; // The name of the course
	private String department; // The name of the department
	private int code; // The course code
	private byte section; // The section of the course
	private String instructor; // The instructor's name
	
	/**
	 * Constructor for the Course class
	 * 
	 * @param cname
	 * 		The name of the course
	 * @param department
	 * 		The name of the department
	 * @param section
	 * 		The section of the course
	 * @param code
	 * 		The course code
	 * @param instructor
	 * 		The instructor's name
	 */
	public Course(String cname, String department, byte section, int code, String instructor){
		this.cname = cname;
		this.department = department;
		this.code = code;
		this.section = section;
		this.instructor = instructor;
	}
	
	/**
	 * Returns the object <code>Course<code> that is called
	 * 
	 * @return
	 * 		Returns the new object
	 */
	public Object clone() {
		Course x = new Course(cname, department, section, code, instructor);
		return x;
	}
	
	/**
	 * Returns true or false if obj is equal to any object in planner
	 * 
	 * @param obj
	 * 		The object that is being cloned
	 */
	public boolean equals (Object obj) {
		if(((Course) clone()).getCname().compareTo(((Course) obj).getCname())==0){
			if(((Course) clone()).getDepartment().compareTo(((Course) obj).getDepartment())==0){
				if(((Course) clone()).getInstructor().compareTo(((Course) obj).getInstructor())==0){
					if(((Course) clone()).getCode()==(((Course) obj).getCode())){
						if(((Course) clone()).getSection()==(((Course) obj).getSection())){
							return true;
						}	
					}	
				}	
			}
		}
		return false;
	}

	/**
	 * Getter for cname
	 * 
	 * @return
	 * 		Returns string of course name
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * Setter for cname
	 * 
	 * @param cname
	 * 		Course name
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * Getter for Department
	 * 
	 * @return
	 * 		Returns string for department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * Setter for Department
	 * 
	 * @param department
	 * 		Department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Getter for Code
	 * 
	 * @return
	 * 		Returns int for code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * Setter for code
	 * 
	 * @param code
	 * 		Code
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	/**
	 * Getter for Section
	 * 
	 * @return
	 * 		Returns byte for section
	 */
	public byte getSection() {
		return section;
	}
	/**
	 * Setter for section
	 * 
	 * @param section
	 * 		Section
	 */
	public void setSection(byte section) {
		this.section = section;
	}
	
	/**
	 * Getter for Instructor
	 * 
	 * @return
	 * 		Returns string for instructor
	 */
	public String getInstructor() {
		return instructor;
	}
	/**
	 * Setter for Instructor
	 * 
	 * @param instructor
	 * 		Instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
}
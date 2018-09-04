package course;

public class Course {
	private String cname;
	private String department;
	private int code;
	private byte section;
	private String instructor;
	
	public Course(String cname, String department, byte section, int code, String instructor){
		this.cname = cname;
		this.department = department;
		this.code = code;
		this.section = section;
		this.instructor = instructor;
	}
	
	public Object clone() {
		
	}
	
	public boolean equals (Object obj) {
		Planner x = new Planner();
		return(obj == x.getCourse(section));
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public byte getSection() {
		return section;
	}

	public void setSection(byte section) {
		this.section = section;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
}

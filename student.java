
public class student implements Student_{
	private String firstname;
	private String lastname;
	private String Hostel;
	private String Department;
	private String Scgpa;
	
	public student(String first_name,String last_name,String hostel_name,String department_name,String Cgpa){
		firstname=first_name;
		lastname=last_name;
		Hostel=hostel_name;
		Department=department_name;
		Scgpa=Cgpa;
	}

	public String fname(){
		return firstname;
	}


	public String lname(){
		return lastname;
	}


	public String hostel(){
		return Hostel;
	}


	public String department(){
		return Department;
	}


	public String cgpa(){
		return Scgpa;
	}
}

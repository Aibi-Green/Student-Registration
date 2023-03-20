package main;

public class Students {
	private String student_id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String email;
	private String contactNumber;
	
	public Students (
			String id, 
			String first, 
			String middle, 
			String last, 
			String dob, 
			String gender, 
			String email, 
			String contact
			) {
		this.setStudent_id(id);
		this.setFirstName(first);
		this.setMiddleName(middle);
		this.setLastName(last);
		this.setDateOfBirth(dob);
		this.setGender(gender);
		this.setEmail(email);
		this.setContactNumber(contact);
	}
	
	public void studentString() {
		System.out.println(student_id + "\n" + firstName + "\n" + middleName + "\n"
				+ lastName + "\n" + dateOfBirth + "\n" + gender + "\n" 
				+ email + "\n" + contactNumber);
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}

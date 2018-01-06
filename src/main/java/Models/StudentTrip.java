package Models;

public class StudentTrip implements IStudentProvider {
	
	private Student student;
	
	private Boolean paid;
	private Boolean authorisation;
	private Integer studentTripId;
	
	public StudentTrip(Student student)
	{
		this.student = student;
	}

	public Student getStudent() {
		return this.student;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public Boolean getAuthorisation() {
		return authorisation;
	}

	public void setAuthorisation(Boolean authorised) {
		this.authorisation = authorised;
	}

	public Integer getStudentTripId() {
		return studentTripId;
	}

	public void setStudentTripId(Integer studentTripId) {
		this.studentTripId = studentTripId;
	}
}

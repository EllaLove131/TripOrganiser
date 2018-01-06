package Models;

/**
 * 
 * @author Ella Love
 *
 *         A student container class for storing student information.
 */
public class Student implements IStudentProvider {

	/**
	 * Phone number regex, taken from http://regexlib.com/
	 */
	private final static String PHONE_NO_REGEX = "^(((\\+44\\s?\\d{4}|\\(?0\\d{4}\\)?)\\s?\\d{3}\\s?\\d{3})|((\\+44\\s?\\d{3}|\\(?0\\d{3}\\)?)\\s?\\d{3}\\s?\\d{4})|((\\+44\\s?\\d{2}|\\(?0\\d{2}\\)?)\\s?\\d{4}\\s?\\d{4}))(\\s?\\#(\\d{4}|\\d{3}))?$";

	private int studentId;
	private String firstName;
	private String lastName;
	private String mobileNo;

	// getters and setters
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public boolean setFirstName(String firstName) {
		if (firstName.isEmpty() || firstName.length() > 30) {
			return false;
		}

		this.firstName = firstName;
		return true;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean setLastName(String lastName) {
		if (lastName.isEmpty() || lastName.length() > 30) {
			return false;
		}
		this.lastName = lastName;
		return true;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public boolean setMobileNo(String mobileNo) {
		if (mobileNo.isEmpty() || !mobileNo.matches(PHONE_NO_REGEX)) {
			return false;
		}
		this.mobileNo = mobileNo;
		return true;
	}

	public String toString() {
		return "Student Id: " + studentId + ", " + "First Name: " + firstName + ", " + "Second Name: " + lastName + ", "
				+ "Mobile No: " + mobileNo + ".";
	}

	public Student getStudent() {
		return this;
	}
}

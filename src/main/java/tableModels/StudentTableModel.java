package tableModels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import models.IStudentProvider;
import models.Student;

/**
 * @author Ella Love
 *
 *         Specifies the methods the student table will use to interrogate a
 *         tabular data model
 */
@SuppressWarnings("serial")
public class StudentTableModel extends AbstractTableModel {

	public static final int FIRST_NAME_COLUMN = 0;
	public static final int LAST_NAME_COLUMN = 1;
	public static final int MOBILE_NO_COLUMN = 2;
	public static final int STUDENT_ID_COLUMN = -1;

	protected IStudentProvider[] students;
	protected String[] columns;

	public StudentTableModel(IStudentProvider[] studentList) {
		super();
		students = studentList;
		columns = new String[] { "First Name", "Last Name", "Mobile Number" };
	}

	public StudentTableModel(ArrayList<Student> studentList) {
		super();
		students = studentList.toArray(new Student[studentList.size()]);
		columns = new String[] { "First Name", "Last Name", "Mobile Number" };
	}

	// Number of columns in the table
	public int getColumnCount() {
		return columns.length;
	}

	// Number of row in the table
	public int getRowCount() {
		return students.length;
	}

	// The object to place into a cell
	public Object getValueAt(int row, int col) {
		Student student = students[row].getStudent();
		switch (col) {
		case FIRST_NAME_COLUMN:
			return student.getFirstName();
		case LAST_NAME_COLUMN:
			return student.getLastName();
		case MOBILE_NO_COLUMN:
			return student.getMobileNo();
		case STUDENT_ID_COLUMN:
			return student.getStudentId();
		default:
			return null;
		}
	}

	// Get the name of the column
	public String getColumnName(int col) {
		return columns[col];
	}
}

package triporganiser.triporganiser;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {

	private ArrayList<Student> students;
	private String[] columns;

	public StudentTableModel(ArrayList<Student> studentList) {
		super();
		students = studentList;
		columns = new String[] { "First Name", "Last Name", "Mobile Number" };
	}

	// Number of columns in the table
	public int getColumnCount() {
		return columns.length;
	}

	// Number of row in the table
	public int getRowCount() {
		return students.size();
	}

	// The object to place into a cell
	public Object getValueAt(int row, int col) {
		Student student = students.get(row);
		switch (col) {
		case 0:
			return student.getFirstName();
		case 1:
			return student.getLastName();
		case 2:
			return student.getMobileNo();
		default:
			return null;
		}
	}

	// Get the name of the column
	public String getColumnName(int col) {
		return columns[col];
	}
}

package tableModels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import models.Group;

/**
 * @author Ella Love
 *
 *         Specifies the methods the group table will use to interrogate a
 *         tabular data model
 */
@SuppressWarnings("serial")
public class GroupTableModel extends AbstractTableModel {

	public static final int GROUP_NAME_COLUMN = 0;
	public static final int GROUP_ID_COLUMN = 1;

	private ArrayList<Group> groups;
	private String[] columns;

	public GroupTableModel(ArrayList<Group> groupList) {
		super();
		groups = groupList;
		columns = new String[] { "Groups:" };
	}

	// Number of columns in the table
	public int getColumnCount() {
		return columns.length;
	}

	// Number of row in the table
	public int getRowCount() {
		return groups.size();
	}

	// The object to place into a cell
	public Object getValueAt(int row, int col) {
		if (groups.isEmpty()) {
			return null;
		}

		// check the row is valid
		if (row > groups.size() || row < 0) {
			return null;
		}

		Group group = groups.get(row);
		switch (col) {
		case GROUP_NAME_COLUMN:
			return group.getGroupName();
		case GROUP_ID_COLUMN:
			return group.getGroupId();
		default:
			return null;
		}
	}

	// Get the name of the column
	public String getColumnName(int col) {
		return columns[col];
	}
}

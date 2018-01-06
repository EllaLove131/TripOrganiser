/**
 * 
 */
package userInterface.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Models.Group;
import Models.Student;
import Queries.GroupQueries;
import Queries.StudentQueries;
import TableModels.GroupTableModel;
import TableModels.StudentTableModel;
import userInterface.dialogs.AddGroupDialog;
import userInterface.dialogs.AddStudentDialog;

import javax.swing.JLabel;

/**
 * @author Ella Love
 *
 */
@SuppressWarnings("serial")
public class GroupsTabPanel extends JPanel {
	private static JTable tblStudents;
	private JButton btnAddGroup;
	private JButton btnAddStudent;
	private JButton btnRemoveStudent;
	private JButton btnRemoveGroup;
	private static JTable tblGroups;

	/**
	 * Constructor
	 */
	public GroupsTabPanel() {

		initComponents();
		eventHandler();
	}

	/**
	 * Creates interface
	 */
	private void initComponents() {

		//Create selected students label
		JLabel lblSelectedStudents = new JLabel("Students within the selected group:");
		
		// Add group button, with image
		btnAddGroup = new JButton("");
		btnAddGroup.setToolTipText("Add a new group");
		btnAddGroup.setIcon(new ImageIcon(GroupsTabPanel.class.getResource("/resources/add.png")));

		// Remove group button, with image
		btnRemoveGroup = new JButton("");
		btnRemoveGroup.setToolTipText("Remove the selected group");
		btnRemoveGroup.setEnabled(false);
		btnRemoveGroup.setIcon(new ImageIcon(GroupsTabPanel.class.getResource("/resources/remove.png")));

		// Group Table
		// Query the db to get the data to fill the rows and add it to an array
		// list
		GroupQueries groupQueries = new GroupQueries();
		ArrayList<Group> groups = groupQueries.getGroups();
		// Create the table model for groups
		GroupTableModel groupTableModel = new GroupTableModel(groups);
		// Create the table using the table model
		tblGroups = new JTable(groupTableModel);
		tblGroups.setToolTipText("The avaliable groups");

		Integer groupId = getGroupId();

		// Student Table
		// Query the db to get the data to fill the rows and add it to an array
		// list
		ArrayList<Student> students = new ArrayList<Student>();
		// If there are any groups
		if (groupId != null) {
			students = groupQueries.getStudentsFromGroup(groupId.intValue());
		}
		// Create the table model for students
		StudentTableModel studentTableModel = new StudentTableModel(students);
		// Create the table using the table model
		tblStudents = new JTable(studentTableModel);
		tblStudents.setToolTipText("The students in your selected group");

		// Add student button, with image
		btnAddStudent = new JButton("");
		btnAddStudent.setToolTipText("Add a student to the selected group");
		btnAddStudent.setEnabled(false);
		btnAddStudent.setIcon(new ImageIcon(GroupsTabPanel.class.getResource("/resources/add.png")));

		// Remove student button, with image
		btnRemoveStudent = new JButton("");
		btnRemoveStudent.setToolTipText("Remove the selected student");
		btnRemoveStudent.setEnabled(false);
		btnRemoveStudent.setIcon(new ImageIcon(GroupsTabPanel.class.getResource("/resources/remove.png")));

		// Create the scroll pane for group table
		JScrollPane spGroup = new JScrollPane();
		// Add the group table to the scroll panel
		spGroup.setViewportView(tblGroups);

		// Create the scroll pane for the student table
		JScrollPane spStudents = new JScrollPane();
		// Add the student table to the scroll panel
		spStudents.setViewportView(tblStudents);

		// Layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(spGroup, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAddGroup)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemoveGroup)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAddStudent)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemoveStudent))
						.addComponent(lblSelectedStudents)
						.addComponent(spStudents, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(spGroup, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSelectedStudents)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStudents, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAddGroup)
							.addComponent(btnAddStudent))
						.addComponent(btnRemoveGroup)
						.addComponent(btnRemoveStudent))
					.addGap(4))
		);

		setLayout(groupLayout);
	}

	/**
	 * Handles events
	 */
	private void eventHandler() {

		// Add group button clicked
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Create and show the add group dialog
				AddGroupDialog addGroupDialog = new AddGroupDialog();
				addGroupDialog.setVisible(true);
			}
		});

		// Remove group button clicked
		btnRemoveGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Get Group id from the selected row
				int groupId = getGroupId();

				// Delete the group with that id
				new GroupQueries().removeGroup(groupId);

				// Update the table
				updateGroupTable();
			}
		});

		// Add student button clicked
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Create and show the add student dialog
				AddStudentDialog addStudentDialog = new AddStudentDialog();
				addStudentDialog.setVisible(true);
			}
		});

		// Remove student button clicked
		btnRemoveStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Get Student id from the selected row
				int selectedRow = tblStudents.getSelectedRow();
				int studentId = (Integer) tblStudents.getModel().getValueAt(selectedRow,
						StudentTableModel.STUDENT_ID_COLUMN);

				// Delete the student with that id
				new StudentQueries().removeStudent(studentId);

				// Update the table
				updateStudentTable();
			}
		});

		// When a selection is made in the groups table
		tblGroups.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				// update the student table
				updateStudentTable();
				// set the following buttons to enabled:
				btnAddStudent.setEnabled(true);
				btnRemoveGroup.setEnabled(true);
			}
		});

		// When a selection is made in the students table
		tblStudents.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				// enable the remove student button if a group is selected
				if (btnRemoveGroup.isEnabled()) {
					btnRemoveStudent.setEnabled(true);
				}
			}
		});
	}

	/**
	 * Updates the table of students
	 */
	public static void updateStudentTable() {
		GroupQueries groupQueries = new GroupQueries();
		int groupId = getGroupId();
		ArrayList<Student> students = groupQueries.getStudentsFromGroup(groupId);
		StudentTableModel studentTableModel = new StudentTableModel(students);
		tblStudents.setModel(studentTableModel);
	}

	/**
	 * Updates the groups table
	 */
	public static void updateGroupTable() {
		GroupQueries groupQueries = new GroupQueries();
		ArrayList<Group> groups = groupQueries.getGroups();
		GroupTableModel groupTableModel = new GroupTableModel(groups);
		tblGroups.setModel(groupTableModel);
	}

	/**
	 * Get the id of the selected group
	 * 
	 * @return groupId
	 */
	public static Integer getGroupId() {
		// Get Group id from the selected row
		int selectedRow = tblGroups.getSelectedRow();

		// Check for no row selected.
		if (selectedRow == -1) {
			selectedRow = 0;
		}

		Integer groupId = (Integer) tblGroups.getModel().getValueAt(selectedRow, GroupTableModel.GROUP_ID_COLUMN);

		return groupId;
	}
}

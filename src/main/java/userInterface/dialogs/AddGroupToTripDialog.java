package userInterface.dialogs;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.Group;
import models.Student;
import queries.GroupQueries;
import queries.StudentQueries;
import tableModels.GroupTableModel;
import tableModels.StudentTableModel;
import userInterface.panels.TripsTabPanel;

/**
 * @author Ella Love
 *
 *         Dialog used for adding groups to trips in the database, creates the
 *         dialog and its event handlers accesses the database for student and
 *         group information
 */
@SuppressWarnings("serial")
public class AddGroupToTripDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private static JTable tblStudents;
	private JButton btnOk;
	private JButton btnCancel;
	private static JTable tblGroups;

	/**
	 * Constructor
	 */
	public AddGroupToTripDialog() {

		initComponents();
		eventHandler();
	}

	/**
	 * Creates the dialog
	 */
	public void initComponents() {

		// Ensures that the dialog is disposed of when closed
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// Displays the dialog in front of any others
		setModalityType(ModalityType.APPLICATION_MODAL);

		// The window title and image
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(AddGroupToTripDialog.class.getResource("/resources/add.png")));
		setModal(true);
		setTitle("Add Students");
		setBounds(100, 100, 951, 300);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Create the scroll panels
		JScrollPane spGroups = new JScrollPane();

		JScrollPane spStudents = new JScrollPane();
		{
			// Create a pane for the buttons
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				// Add the OK button to the panel
				btnOk = new JButton("");
				btnOk.setToolTipText("Add students to trip");
				btnOk.setIcon(new ImageIcon(AddGroupToTripDialog.class.getResource("/resources/add.png")));
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				// Add the cancel button to the panel
				btnCancel = new JButton("");
				btnCancel.setToolTipText("Cancel action");
				btnCancel.setIcon(new ImageIcon(AddGroupToTripDialog.class.getResource("/resources/remove.png")));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		// Apply a group layout to the panel
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(
						gl_contentPanel
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										gl_contentPanel.createSequentialGroup()
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
														.addComponent(
																buttonPane, GroupLayout.DEFAULT_SIZE, 546,
																Short.MAX_VALUE)
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addComponent(spGroups, GroupLayout.PREFERRED_SIZE, 281,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(spStudents, GroupLayout.DEFAULT_SIZE, 259,
																		Short.MAX_VALUE)))
												.addContainerGap()));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(spStudents, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
								.addComponent(spGroups, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(buttonPane,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)));

		// Group Table
		// Query the db to get the data to fill the rows and add it to an array
		// list
		GroupQueries groupQueries = new GroupQueries();
		ArrayList<Group> groups = groupQueries.getGroups();
		// Create the table model for groups
		GroupTableModel groupTableModel = new GroupTableModel(groups);
		// Create the table using the table model
		tblGroups = new JTable(groupTableModel);
		tblGroups.setToolTipText("Avaliable groups");
		// Add the table to the scroll panel
		spGroups.setViewportView(tblGroups);

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
		tblStudents.setToolTipText("Students in the selected group");
		// Add the Students table to the scroll panel
		spStudents.setViewportView(tblStudents);

		// Set layouts
		contentPanel.setLayout(gl_contentPanel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(contentPanel,
				GroupLayout.PREFERRED_SIZE, 485, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(contentPanel,
				GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE));
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * Handles events
	 */
	public void eventHandler() {

		// Cancel button clicked, close the dialog
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// The OK button is clicked
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Get the trip ID
				int tripId = TripsTabPanel.getTripId();
				// Get the selected group ID
				int groupId = getGroupId();

				// Get the students from the group
				ArrayList<Student> students = new GroupQueries().getStudentsFromGroup(groupId);

				// For each student in the list:
				for (Student student : students) {

					// Get the student ID
					int studentId = student.getStudentId();
					// Add the student to the db
					new StudentQueries().addStudentToTrip(studentId, tripId);
				}
				// Update the student table on the trip panel
				TripsTabPanel.updateStudentTripTable();

				// Show a dialog to the user, verifying that the action was
				// successful
				JOptionPane.showMessageDialog(null, "Students added to trip succesfully.");
			}
		});

		// When a selection is made in the groups table
		tblGroups.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				// update the student table
				updateStudentTable();
				// set the following buttons to enabled:
				btnOk.setEnabled(true);
				btnCancel.setEnabled(true);
			}
		});
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
}

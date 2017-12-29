package userInterfaces;

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
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import triporganiser.triporganiser.Student;
import triporganiser.triporganiser.StudentQueries;
import triporganiser.triporganiser.StudentTableModel;

public class GroupsTabPanel extends JPanel {
	private JTable tblStudents;
	private JButton btnAddGroup;
	private JButton btnAddStudent;

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
		
		//Scroll pane for group tree
		JScrollPane spGroupTree = new JScrollPane();
		
		//Add group button, with image
		btnAddGroup = new JButton("");
		btnAddGroup.setIcon(new ImageIcon(GroupsTabPanel.class.getResource("/resources/add.png")));
		
		//Remove group button, with image
		JButton btnRemoveGroup = new JButton("");
		btnRemoveGroup.setIcon(new ImageIcon(GroupsTabPanel.class.getResource("/resources/remove.png")));
		
		//Table
		//Query the db to get the info to fill the rows
		StudentQueries studentqueries = new StudentQueries();
		ArrayList<Student> students = studentqueries.getStudents();
		//Create the table model for students
		StudentTableModel tableModel = new StudentTableModel(students);
		//Create the table
		tblStudents = new JTable(tableModel);
		
		//Add student button, with image
		btnAddStudent = new JButton("");
		btnAddStudent.setIcon(new ImageIcon(GroupsTabPanel.class.getResource("/resources/add.png")));
		
		//Remove student button, with image
		JButton btnRemoveStudent = new JButton("");
		btnRemoveStudent.setIcon(new ImageIcon(GroupsTabPanel.class.getResource("/resources/remove.png")));
		
		//Create the scroll pane and add the students 
		JScrollPane spStudents = new JScrollPane();
		spStudents.add(tblStudents);
		
		//Layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(spGroupTree, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
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
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(spStudents, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tblStudents, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(tblStudents, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
						.addComponent(spGroupTree, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
						.addComponent(spStudents, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAddGroup)
							.addComponent(btnAddStudent))
						.addComponent(btnRemoveGroup)
						.addComponent(btnRemoveStudent))
					.addContainerGap())
		);
		
		//Create the groups tree
		JTree treeGroups = new JTree();
		treeGroups.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Current Groups") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Science");
						node_1.add(new DefaultMutableTreeNode("Ella Love"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Maths ");
						node_1.add(new DefaultMutableTreeNode("Ella Love"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("English");
						node_1.add(new DefaultMutableTreeNode("Ella Love"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Music");
						node_1.add(new DefaultMutableTreeNode("Ella Love"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Orchestra ");
						node_1.add(new DefaultMutableTreeNode("Ella Love"));
					add(node_1);
				}
			}
		));
		spGroupTree.setViewportView(treeGroups);
		setLayout(groupLayout);
	}
	
	/**
	 * Handles events
	 */
	private void eventHandler() {
		
		//Add group button clicked
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				AddGroupDialog addGroupDialog = new AddGroupDialog(); 
				addGroupDialog.setModal(true); 
				addGroupDialog.setVisible(true);
			}
		});
		
		//Add student button clicked 
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddStudentDialog addStudentDialog = new AddStudentDialog();
				addStudentDialog.setModal(true);
				addStudentDialog.setVisible(true);
			}
		});
	}
}

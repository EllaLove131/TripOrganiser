package userInterfaces;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class AddGroupToTripDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTable studentsTable;
	private JButton btnOk;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddGroupToTripDialog dialog = new AddGroupToTripDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	public void initComponents(){ 
		
		//The window title and image
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddGroupToTripDialog.class.getResource("/resources/add.png")));
		setModal(true);
		setTitle("Add Students");
		setBounds(100, 100, 501, 300);
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//Create the scroll panels 
		JScrollPane spGroups = new JScrollPane();
		
		JScrollPane spStudents = new JScrollPane();
		{
			//Create a pane for the buttons 
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				//Add the OK button to the panel
				btnOk = new JButton("");
				btnOk.setIcon(new ImageIcon(AddGroupToTripDialog.class.getResource("/resources/add.png")));
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				//Add the cancel button to the panel
				btnCancel = new JButton("");
				btnCancel.setIcon(new ImageIcon(AddGroupToTripDialog.class.getResource("/resources/remove.png")));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		//Apply a group layout to the panel
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(spGroups, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStudents, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(spStudents, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(spGroups, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		//Create the students table 
		studentsTable = new JTable();
		spStudents.setViewportView(studentsTable);
		
		//Create the groups tree
		JTree groupsTree = new JTree();
		groupsTree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Groups") {
				{

				}
			}
		));
		//Add the groups tree to the scroll panel
		spGroups.setViewportView(groupsTree);
		//Set layouts
		contentPanel.setLayout(gl_contentPanel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 485, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * Handles events 
	 */
	public void eventHandler(){
		
		//Cancel button clicked, close the dialog
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}

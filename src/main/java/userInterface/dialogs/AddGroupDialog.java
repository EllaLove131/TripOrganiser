package userInterface.dialogs;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import models.Group;
import queries.GroupQueries;
import userInterface.panels.GroupsTabPanel;

/**
 * @author Ella Love
 *
 * Dialog used for adding groups to the database, creates the dialog and 
 * its event handlers
 */
@SuppressWarnings("serial")
public class AddGroupDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTextField txtName;
	private JButton btnCancel;
	private JButton btnOk;

	/**
	 * Constructor
	 */
	public AddGroupDialog() {

		initComponents();
		eventHandler();
	}

	/**
	 * Creates the dialog
	 */
	public void initComponents() {

		//Ensures that the dialog is disposed of when closed
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//Displays the dialog in front of any others
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		// Set the title bar image and text
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddGroupDialog.class.getResource("/resources/add.png")));
		setTitle("New Group");

		setBounds(100, 100, 378, 117);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			// Create the panel to contain the buttons and set it's layout
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				// Add the OK button to the panel
				btnOk = new JButton("");
				btnOk.setToolTipText("Add the new group");
				btnOk.setIcon(new ImageIcon(AddGroupDialog.class.getResource("/resources/add.png")));
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				// Add the Cancel button to the panel
				btnCancel = new JButton("");
				btnCancel.setToolTipText("Cancel adding a new group");
				btnCancel.setIcon(new ImageIcon(AddGroupDialog.class.getResource("/resources/remove.png")));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}

		// Apply a group layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addComponent(contentPanel, 0, 0, Short.MAX_VALUE).addGap(1))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(1).addComponent(buttonPane,
						GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(buttonPane,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(245)));

		// Create a 'Name' label
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));

		// Create a name text field
		txtName = new JTextField();
		txtName.setToolTipText("Enter the for the new group");
		txtName.setColumns(10);

		// Set the layout for the content panel to group
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * Handles events
	 */
	public void eventHandler() {

		// When the cancel button is clicked, close dialog
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// When the OK button is clicked
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Get the name from the text box
				String groupName = txtName.getText();

				//Error message to be populated if there is a verification issue 
				String errorMessage = "";

				// Create a new group
				Group newGroup = new Group();

				// Verify the data
				if (!newGroup.setGroupName(groupName)) {
					errorMessage = "Name field is empty or contains too many characters.";
				}

				// If there is no validation issue
				if (errorMessage.isEmpty()) {
					// Add the group to the db
					new GroupQueries().addGroup(newGroup);

					//Update the groups table with the new changes
					GroupsTabPanel.updateGroupTable();
					
					// Show a dialog to the user, verifying that the action was
					// successful
					JOptionPane.showMessageDialog(null, "Group added succesfully.");
					
					//Close the dialog
					dispose();
				} else {
					// Show the invalid data dialog
					InvalidDataDialog invalidDialog = new InvalidDataDialog();
					invalidDialog.lblInfoText.setText(errorMessage);
					invalidDialog.setVisible(true);
				}
			}
		});
	}
}

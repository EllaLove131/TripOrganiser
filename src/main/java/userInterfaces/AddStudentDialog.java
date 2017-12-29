package userInterfaces;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import triporganiser.triporganiser.Student;
import triporganiser.triporganiser.StudentQueries;

public class AddStudentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JButton btnCancel;
	private JButton btnOk;
	private JTextField txtMobileNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddStudentDialog dialog = new AddStudentDialog();
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddStudentDialog() {

		initComponents();
		eventHandler();
	}

	private void initComponents() {
		//Ensures that the dialog is disposed of when closed
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//Displays the dialog in front of any others
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		// Window image and title
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddStudentDialog.class.getResource("/resources/add.png")));
		setTitle("New Student");
		setBounds(100, 100, 294, 183);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			// Create a panel for buttons
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				// Add the OK button to the button panel
				btnOk = new JButton("");
				btnOk.setIcon(new ImageIcon(AddStudentDialog.class.getResource("/resources/add.png")));
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				// Add the cancel button to the button panel
				btnCancel = new JButton("");
				btnCancel.setIcon(new ImageIcon(AddStudentDialog.class.getResource("/resources/remove.png")));
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		// Apply a group layout to the panels
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addComponent(contentPanel, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(buttonPane,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(118)));
		// Create labels
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 11));

		// Create the text fields
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);

		txtLastName = new JTextField();
		txtLastName.setColumns(10);

		txtMobileNo = new JTextField();
		txtMobileNo.setColumns(10);

		// Apply group layouts
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblFirstName)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtFirstName,
												GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblLastName)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtLastName))
								.addGroup(gl_contentPanel.createSequentialGroup().addComponent(lblMobileNumber)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtMobileNo)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblFirstName)
								.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblLastName)
								.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblMobileNumber)
								.addComponent(txtMobileNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(144, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * Handles events
	 */
	public void eventHandler() {

		// Cancel button is clicked, close dialog
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// OK button is clicked, add the student to the db and clear fields
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String firstName = txtFirstName.getText();
				String lastName = txtLastName.getText();
				String mobileNo = txtMobileNo.getText();

				String errorMessage = "";

				Student newStudent = new Student();
				if (!newStudent.setFirstName(firstName)) {
					errorMessage = "First Name field is empty";
				}

				if (!newStudent.setLastName(lastName)) {
					errorMessage = "Last Name field is empty";
				}

				if (!newStudent.setMobileNo(mobileNo)) {
					errorMessage = "Mobile Number field is invalid";
				}

				if (errorMessage.isEmpty()) {
					new StudentQueries().addStudent(newStudent);
				} else {
					InvalidDataDialog invalidDialog = new InvalidDataDialog();
					invalidDialog.lblInfoText.setText(errorMessage);
					invalidDialog.setVisible(true);
				}
			}
		});
	}
}

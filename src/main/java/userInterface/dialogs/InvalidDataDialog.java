/**
 * Dialog used for informing the user of an invalid data entry, creates the dialog
 * and its event handlers the dialog takes in a string to display a relevant message
 */
package userInterface.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * @author Ella Love
 *
 */
@SuppressWarnings("serial")
public class InvalidDataDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnClose;
	public JLabel lblInfoText;

	/**
	 * Constructor
	 */
	public InvalidDataDialog() {

		initComponents();
		eventHandler();
	}

	/**
	 * Create the dialog
	 */
	private void initComponents() {

		// Ensures that the dialog is disposed of when closed
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// Displays the dialog in front of any others
		setModalityType(ModalityType.APPLICATION_MODAL);

		// Set the dialog title and image
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(InvalidDataDialog.class.getResource("/resources/invalid.png")));
		setTitle("Invalid Input");

		// Creates the content panel, sets a layout
		setBounds(100, 100, 450, 112);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			// Creates the label for the addition of text
			lblInfoText = new JLabel("The data you have inputted is invalid");
			contentPanel.add(lblInfoText);
		}
		{
			// Creates a panel for the buttons
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			// Adds the panel to the content Panel
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				// Creates the close button within the button panel
				btnClose = new JButton("Close");
				btnClose.setToolTipText("Close the dialog");
				btnClose.setActionCommand("OK");
				buttonPane.add(btnClose);
				getRootPane().setDefaultButton(btnClose);
			}
		}
	}

	/**
	 * Handles events.
	 */
	private void eventHandler() {

		// Closes the dialog when the close button is clicked
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}

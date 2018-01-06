/**
 * 
 */
package userInterface.panels;

import java.awt.Font;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import LabelFormatters.DateLabelFormatter;

/**
 * 
 * @author Ella Love
 * 
 *         An input panel used for trip details (name, start date and end date)
 *         when added to a panel. Handles the retreiving of data inputted into
 *         the input fields.
 */
@SuppressWarnings("serial")
public class TripPanel extends JPanel {
	private JTextField txtName;
	private JDatePickerImpl txtEndDate;
	private JDatePickerImpl txtStartDate;

	/**
	 * Create the panel.
	 */
	public TripPanel() {

		initComponents();
	}

	private void initComponents() {

		// Create the labels
		JLabel lblEnd = new JLabel("End Date:");
		lblEnd.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblStart = new JLabel("Start Date:");
		lblStart.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));

		// Create the text boxe
		txtName = new JTextField();
		txtName.setToolTipText("Enter the name of the trip");

		// Set the date entry fields properties
		Properties p = DateLabelFormatter.setProperties();

		// Create the arrival date entry field
		UtilDateModel modelStart = new UtilDateModel();
		JDatePanelImpl datePanelStart = new JDatePanelImpl(modelStart, p);
		txtStartDate = new JDatePickerImpl(datePanelStart, new DateLabelFormatter());
		txtStartDate.setToolTipText("Select the trip start date");

		// Create the departure date entry field
		UtilDateModel modelEnd = new UtilDateModel();
		JDatePanelImpl datePanelEnd = new JDatePanelImpl(modelEnd, p);
		txtEndDate = new JDatePickerImpl(datePanelEnd, new DateLabelFormatter());
		txtEndDate.setToolTipText("Select the trip end date");

		// Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblName)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtName,
												GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblStart)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtStartDate, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblEnd)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtEndDate, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
										.addGap(2)))
						.addGap(14)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblName).addComponent(
						txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lblStart)
						.addComponent(txtEndDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnd).addComponent(txtStartDate, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(240, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	/**
	 * gets the trip name from the text box
	 * 
	 * @return name
	 */
	public String getTripName() {
		String name = txtName.getText();
		return name;
	}

	/**
	 * Gets the start date from the text box
	 * 
	 * @return startDate
	 */
	public String getStartDate() {
		String startDate = txtStartDate.getJFormattedTextField().getText();
		return startDate;
	}

	/**
	 * gets the end date from the text box
	 * 
	 * @return endDate
	 */
	public String getEndDate() {
		String endDate = txtEndDate.getJFormattedTextField().getText();
		return endDate;
	}
}

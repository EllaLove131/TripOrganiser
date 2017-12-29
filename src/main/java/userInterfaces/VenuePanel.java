package userInterfaces;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VenuePanel extends JPanel {
	private JTextField txtVenue;

	/**
	 * Create the panel.
	 */
	public VenuePanel() {
		
		initComponents();
	}

	private void initComponents() {
		
		//Create the label
		JLabel lblVenue = new JLabel("Venue:");
		lblVenue.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//Create the text field
		txtVenue = new JTextField();
		txtVenue.setColumns(10);
		
		//Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblVenue, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtVenue, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVenue)
						.addComponent(txtVenue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(275, Short.MAX_VALUE))
		);
		setLayout(groupLayout);		
	}
}

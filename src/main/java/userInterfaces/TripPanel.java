/**
 * 
 */
package userInterfaces;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * 
 * @author Ella Love
 *
 */
@SuppressWarnings("serial")
public class TripPanel extends JPanel {
	private JTextField txtName;
	private JTextField txtEnd;
	private JTextField txtStart;

	/**
	 * Create the panel.
	 */
	public TripPanel() {
		
		initComponents();
	}

	private void initComponents() {
		
		//Create the labels		
		JLabel lblEnd = new JLabel("End Date:");
		lblEnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblStart = new JLabel("Start Date:");
		lblStart.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//Create the text boxes
		txtName = new JTextField();
		
		txtStart = new JTextField();
		txtStart.setColumns(10);
		
		txtEnd = new JTextField();
		txtEnd.setColumns(10);
		
		//Apply a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtName))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblStart)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblEnd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStart)
						.addComponent(lblEnd)
						.addComponent(txtEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);		
	}
}

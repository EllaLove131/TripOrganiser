package helpFiles;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Ella Love
 *
 *         The panel added to the help tab to display the add groups help page.
 */
@SuppressWarnings("serial")
public class HelpAddGroups extends JPanel {

	/**
	 * Create the panel.
	 */
	public HelpAddGroups() {

		// Adds the image to the JPanel using a label
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HelpTrip.class.getResource("/helpFiles/groupsAddHelp.PNG")));
		add(lblNewLabel);
	}
}

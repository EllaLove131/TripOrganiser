package helpFiles;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Ella Love
 *
 *         The panel added to the help tab to display the add trip help page.
 */
@SuppressWarnings("serial")
public class HelpAddTrip extends JPanel {

	/**
	 * Create the panel.
	 */
	public HelpAddTrip() {

		// Adds the image to the JPanel using a label
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HelpTrip.class.getResource("/helpFiles/tripsAddHelp.PNG")));
		add(lblNewLabel);
	}
}

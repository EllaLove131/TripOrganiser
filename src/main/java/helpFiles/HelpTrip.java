package helpFiles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * 
 * @author Ella Love
 *
 *         The panel added to the help tab to display the trip help page.
 */
@SuppressWarnings("serial")
public class HelpTrip extends JPanel {

	/**
	 * Create the panel.
	 */
	public HelpTrip() {

		// Adds the image to the JPanel using a label
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HelpTrip.class.getResource("/helpFiles/tripsHelp.PNG")));
		add(lblNewLabel);
	}
}
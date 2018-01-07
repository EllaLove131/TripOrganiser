package userInterface.panels;

/**
 * @author Ella Love
 *
 * The panel added to the tabular display within the main container. 
 * Displays the help files.
 */
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import helpFiles.HelpAddGroups;
import helpFiles.HelpAddTrip;
import helpFiles.HelpGroups;
import helpFiles.HelpTrip;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

@SuppressWarnings("serial")
public class HelpTabPanel extends JPanel {
	private JButton btnBack;
	private JButton btnNext;
	private JPanel helpDisplayPanel;
	private CardLayout cardLayout = new CardLayout(0, 0);

	/**
	 * Create the panel.
	 */
	public HelpTabPanel() {

		initComponents();
		eventHandler();
	}

	/**
	 * Creates the display.
	 */
	private void initComponents() {

		// Creates the button panel
		JPanel buttonPanel = new JPanel();
		// Creates the buttons and adds them to the panel
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(HelpTabPanel.class.getResource("/resources/back.png")));
		buttonPanel.add(btnBack);

		btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(HelpTabPanel.class.getResource("/resources/next.png")));
		buttonPanel.add(btnNext);

		// Creates the help file display panel
		helpDisplayPanel = new JPanel();
		// Apply a card layout
		helpDisplayPanel.setLayout(cardLayout);

		// Add the 4 panels to the card layout
		helpDisplayPanel.add(new HelpTrip(), "Trip help panel");
		helpDisplayPanel.add(new HelpAddTrip(), "Add trip help panel");
		helpDisplayPanel.add(new HelpGroups(), "Group help panel");
		helpDisplayPanel.add(new HelpAddGroups(), "Add group help panel");

		// Creates and applies a group layout
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(buttonPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 701,
										Short.MAX_VALUE)
								.addComponent(helpDisplayPanel, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
						.addGap(2)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(helpDisplayPanel, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)));

		setLayout(groupLayout);
	}

	/**
	 * Handles events.
	 */
	private void eventHandler() {
		// Goes back to the previous help file
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Display the previous card
				cardLayout.previous(helpDisplayPanel);
			}
		});
		// Shows the next help file
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display the next card
				cardLayout.next(helpDisplayPanel);
			}
		});
	}
}

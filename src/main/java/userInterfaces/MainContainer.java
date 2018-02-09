package userInterfaces;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import queries.HealthQueries;
import userInterface.panels.GroupsTabPanel;
import userInterface.panels.HelpTabPanel;
import userInterface.panels.TripsTabPanel;

/**
 * 
 * @author Ella Love
 *
 *         The main container JFrame for all of the panels.
 */
@SuppressWarnings("serial")
public class MainContainer extends JFrame {
	static JPanel contentPane;

	/**
	 * Constructor.
	 */
	public MainContainer() {

		// Check to see if a database connection an be made
		if (!HealthQueries.isHealthy()) {
			// Show a dialog informing of no database connection
			JOptionPane.showMessageDialog(null, "There is no database connection, cannot run the application");
			// Exit the application
			System.exit(ERROR);
		}
		
		initComponents();
	}

	/**
	 * Initialise components.
	 */
	public void initComponents() {

		// Ensures that the dialog is disposed of when closed
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// Title bar
		setTitle("Trip Organiser");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainContainer.class.getResource("/resources/bus.png")));

		// JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1147, 557);

		// Create a tabbed pane
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		// Content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Content pane layout
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE));

		contentPane.setLayout(gl_contentPane);
		
		// Create tabs within the tabbed pane
		TripsTabPanel trips = new TripsTabPanel();
		GroupsTabPanel groups = new GroupsTabPanel();
		HelpTabPanel help = new HelpTabPanel();

		tabbedPane.addTab("Trips", null, trips, "Trips Tab");
		tabbedPane.addTab("Groups", null, groups, "Groups Tab");
		tabbedPane.addTab("Help", null, help, "Tab containing help content");
	}
}
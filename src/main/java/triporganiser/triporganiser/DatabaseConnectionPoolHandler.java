package triporganiser.triporganiser;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Ella Love
 *
 *         Database connection pool handler, handles database connections
 */
public class DatabaseConnectionPoolHandler {

	private String databaseUrl = "jdbc:mysql://programming2.clql2aelajju.us-east-2.rds.amazonaws.com/TripOrganiser";
	private String databaseUserName = "tripOrganiser";
	private String databasePassword = "spocktallbatterywelly123";
	
	private static DatabaseConnectionPoolHandler instance;

	private ComboPooledDataSource dataSource;

	private DatabaseConnectionPoolHandler() {
		dataSource = new ComboPooledDataSource();

		dataSource.setJdbcUrl(databaseUrl);
		dataSource.setUser(databaseUserName);
		dataSource.setPassword(databasePassword);
		
		dataSource.setTestConnectionOnCheckout( true );
		dataSource.setPreferredTestQuery( "SELECT 1" );	}

	/** 
	 * Get the instance of the data source
	 * @return the data source instance
	 */
	public static DatabaseConnectionPoolHandler getInstance() {
		if (instance == null) {
			instance = new DatabaseConnectionPoolHandler();
		}
		return instance;
	}

	/**
	 * Gets the data source
	 * @return the data source
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
}

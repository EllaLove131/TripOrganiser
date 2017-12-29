/**
 * 
 */
package triporganiser.triporganiser;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Ella Love
 *
 */
public class DatabaseConnectionPoolHandler {
	
	private static DatabaseConnectionPoolHandler instance;
	
	private ComboPooledDataSource dataSource;

	private DatabaseConnectionPoolHandler()
	{
		dataSource = new ComboPooledDataSource();          
		
		dataSource.setJdbcUrl( "jdbc:mysql://programming2.clql2aelajju.us-east-2.rds.amazonaws.com/TripOrganiser" );
		dataSource.setUser("ella");                                  
		dataSource.setPassword("ekvS!61^fh%llfkD");                                  
	}
	
	public static DatabaseConnectionPoolHandler getInstance()
	{
		if (instance == null)
		{
			instance = new DatabaseConnectionPoolHandler();
		}
		return instance;
	}
	
	public DataSource getDataSource()
	{
		return dataSource;
	}
}

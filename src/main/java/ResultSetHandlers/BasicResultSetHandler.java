/**
 * 
 */
package ResultSetHandlers;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.ResultSetHandler;

/**
 * @author Ella Love
 *
 */
public class BasicResultSetHandler implements ResultSetHandler<ArrayList<Object[]>> {

    public ArrayList<Object[]> handle(ResultSet rs) throws SQLException {
    
    	// get the number of columns
        ResultSetMetaData meta = rs.getMetaData();
        int cols = meta.getColumnCount();

        ArrayList<Object[]> results = new ArrayList<Object[]>();
        while (rs.next())
        {
            Object[] result = new Object[cols];

	        for (int i = 0; i < cols; i++) {
	            result[i] = rs.getObject(i + 1);
	        }
	        results.add(result);
        }
        return results;
    }
}

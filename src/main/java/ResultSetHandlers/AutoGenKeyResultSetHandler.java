/**
 * 
 */
package ResultSetHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

/**
 * @author Ella Love
 *
 */
public class AutoGenKeyResultSetHandler implements ResultSetHandler<Integer> {

    public Integer handle(ResultSet rs) throws SQLException {

        if (rs.next())
        {
        	return rs.getInt(1);
        }
        return null;
    }
}

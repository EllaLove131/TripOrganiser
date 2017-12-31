/**
 * 
 */
package ResultSetHandlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.ResultSetHandler;

import Models.Group;

/**
 * @author Ella Love
 *
 */
public class GroupResultSetHandler implements ResultSetHandler<ArrayList<Group>> {

public ArrayList<Group> handle(ResultSet rs) throws SQLException {
		
        ArrayList<Group> results = new ArrayList<Group>();
        
        while (rs.next())
        {
            Group group = new Group();

            group.setGroupId(rs.getInt("groupId"));
            group.setGroupName(rs.getString("groupName"));

	        results.add(group);
        }
        return results;
	}
}

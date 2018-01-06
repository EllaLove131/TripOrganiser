package Models;

/**
 * 
 * @author Ella Love
 * 
 *         A group container class for storing student information.
 */
public class Group {

	private String groupName;
	private int groupId;

	// Getters and Setters
	public String getGroupName() {
		return groupName;
	}

	public boolean setGroupName(String groupName) {
		if (groupName.isEmpty() || groupName.length() > 40) {
			return false;
		}
		this.groupName = groupName;
		return true;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
}

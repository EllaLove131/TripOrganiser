package Models;

public class Group {

	private String groupName;

	private int groupId;

	// Getters and Setters
	public String getGroupName() {
		return groupName;
	}

	public boolean setGroupName(String groupName) {
		if (groupName.isEmpty()) {
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

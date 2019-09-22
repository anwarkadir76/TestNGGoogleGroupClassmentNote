package _ProgrammaticinjectionofListeners;

public class GroupTracker {
	private String groupName = null;
	private String dependsOnGroups = null;
	private String lastGroupName = null;
	private boolean isMasterGroupTaken = false;
	private static GroupTracker gp = null;
	private GroupTracker(){		
	}
	public static GroupTracker getInstance(){
		if (gp == null){
			gp = new GroupTracker();
			gp.groupName = "MasterGroup";
			gp.dependsOnGroups = "";
		}
		return gp;
	}
	public synchronized String[] setDependency(){
		String[]  returnValues = new String[2];
		if (isMasterGroupTaken){
			this.lastGroupName = groupName;
			groupName = "Group" + System.nanoTime();
			this.dependsOnGroups = this.lastGroupName;
		}
		if ("MasterGroup".equals(groupName)){
			this.isMasterGroupTaken = true;
		}
		returnValues[0] = groupName;
		returnValues[1] = dependsOnGroups;
		return returnValues;
	}
}
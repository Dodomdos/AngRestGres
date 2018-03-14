package com.service.Role;

public class RoleDetails {
	int roleId;
	String roleName;
	String roleNamenew;
	String roleDescription;
	String moduleNames;
	
	public RoleDetails() {
		roleId = -1;
		roleName = "";
		roleDescription="";
		moduleNames="";
	}	
	
	public String getRoleNamenew() {
		return roleNamenew;
	}
	
	public void setRoleNamenew(String roleNamenew) {
		this.roleNamenew = roleNamenew;
	}
	
	public String getModuleNames() {
		return moduleNames;
	}	
	public void setModuleNames(String moduleNames) {
		this.moduleNames = moduleNames;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}		
}

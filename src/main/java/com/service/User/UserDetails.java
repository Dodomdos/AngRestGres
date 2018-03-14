package com.service.User;

public class UserDetails {
	
	int userId;
	
	//String emailId ;
	//String emailIdnew;
	
	String username;
	String usernamenew;
	String firstName;
	String lastName;
	String fullName;
	String password;
	int roleId;
	String roleName;
	int userDetailsId;
	String moduleNames;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getModuleNames() {
		return moduleNames;
	}

	public void setModuleNames(String moduleNames) {
		this.moduleNames = moduleNames;
	}

	public UserDetails() {
		userId = -1;
		username = "";
		usernamenew = "";
		firstName = "";
		lastName = "";
		password = "";
		roleId = 0;
		roleName = "";
		userDetailsId = 0;
		moduleNames = "";
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernamenew() {
		return usernamenew;
	}

	public void setUsernamenew(String usernamenew) {
		this.usernamenew = usernamenew;
	}
	
	public int getUserDetailsId() {
		return userDetailsId;
	}
	
	public void setUserDetailsId(int userDetailsId) {
		this.userDetailsId = userDetailsId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}

package com.service.User;

import com.PostGresUtilities.*;
import com.service.Role.RoleDetails;

public class MainRole {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		
		user.setUsername("dodo@gmail.com");
		user.setPassword("dell");
		user.setUserId(2);
		user.setFirstName("dodo");
		user.setLastName("mdos");
		
		System.out.println("User Id " + user.getUserId());
		System.out.println("Email Id " + user.getUsername());
		System.out.println("Password " + user.getPassword());
		System.out.println("Role Id " + user.getRoleId());
		System.out.println("First Name " + user.getFirstName());
		System.out.println("Last Name " + user.getLastName());			
		
		
		RoleDetails role = new RoleDetails();
		role.setRoleName("Admin");		
		
		//System.out.println(CreateUser.insertUserDetails(PostGresqlUtilities.connectionDBWindows(),user));		
		//System.out.println(CreateUser.insertUser(PostGresqlUtilities.connectionDBWindows(),user, role));
		
		/*user.setEmailId("m@gmail.com");
		user.setEmailIdnew("dodomdos@gmail.com");
		user.setPassword("dell2");
		user.setFirstName("dodo2");
		user.setLastName("mdos2");	*/	
		
		//System.out.println(UpdateUser.update2User(PostGresqlUtilities.connectionDBWindows(), user));
		
	}
}

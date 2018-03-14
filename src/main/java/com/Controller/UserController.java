package com.Controller;

import java.net.URLDecoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.PostGresUtilities.PostGresqlUtilities;
import com.service.Modules.DeleteModules;
import com.service.Modules.ModuleDetails;
import com.service.Role.ReadRole;
import com.service.Role.RoleDetails;
import com.service.User.CreateUser;
import com.service.User.DeleteUser;
import com.service.User.ReadUser;
import com.service.User.UpdateUser;
import com.service.User.UserDetails;

@Path("/User")
public class UserController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetails> getAllUserInfo() {
		Connection conn = PostGresqlUtilities.getDBConnection();
		List<UserDetails> listmoddetails = new ArrayList<UserDetails>();

		boolean sqlStatus = (new ReadUser()).selectAllUsersDetails(conn, listmoddetails);
		// log message
		System.out.println("inside getAllUserInfo " + sqlStatus);
		return listmoddetails;
	}
	
	//userName(emailId) should be unique
	/*@GET
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDetails getUserDetailsbyName(@PathParam("user") UserDetails usrdetails) {
		Connection conn = PostGresqlUtilities.connectLoginlinux();
		boolean sqlStatus = (new ReadUser()).selectUser(conn, usrdetails);
		
		return usrdetails;
	}*/
	
	@GET
	@Path("/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDetails getUserDetailsbyName
	(@PathParam("username") String username,
			@PathParam("password") String password) {
		
		UserDetails usrd = new UserDetails();
		usrd.setUsername(username);
		usrd.setPassword(password);
		
		Connection conn = PostGresqlUtilities.getDBConnection();
		boolean userStatus = (new ReadUser()).selectUserRoleDetails(conn, usrd);
	
		System.out.println("username inside UserController getbyuserId " 
				+ usrd.getUserId());
				
		return usrd;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDetails addUserDetails(UserDetails ud)
	{
		boolean userStatus = false;
		Connection conn = PostGresqlUtilities.getDBConnection();
		
		CreateUser cusr = new CreateUser();
		
		boolean cusrbool = cusr.insertUser(conn, ud);
		if(cusrbool) {
			userStatus = (new ReadUser()).selectUserId(conn, ud);
			
		}else {
			ud.setUserId(0);
			return ud;
		}
		
		if(userStatus) {
			boolean insStatus = cusr.insertUserDetails(conn, ud);
		}else {
			ud.setUserId(-1);
			return ud;	
		}
		System.out.println("Inside addUserDetails " + ud.getUserId());
		return ud;
		
	}
	
	@PUT
	@Path("/{userId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDetails updateUserDetails
	(@PathParam("userId") int userId,UserDetails ud)
	{
		UserDetails readUser = new UserDetails();
		
		ud.setUserId(userId);
		readUser.setUserId(userId);
		
		boolean userStatus = false;
		Connection conn = PostGresqlUtilities.getDBConnection();
	
		//write a stored procedure for this ; for now call different methods
		System.out.println("Inside updateUserDetails " + ud.getUserId());		
		//select from tbl_user first using user_id;get the role id		
		//userStatus = (new ReadUser()).selectUserDetailsFromID(conn, readUser);
		//ud.setRoleId(readUser.getRoleId());
		
		//select the role id for the rolename
		RoleDetails rd = new RoleDetails();
		rd.setRoleName(ud.getRoleName());
		ReadRole rr = new ReadRole();
		userStatus = rr.selectRoleByName(conn,rd);
		ud.setRoleId(rd.getRoleId());
		
		System.out.println("Inside updateUserDetails getRoleId()" + rd.getRoleId());
		
		UpdateUser uu = new UpdateUser();
		userStatus = uu.updateUserusingID(conn, ud);
		userStatus = uu.updateUserDetails(conn,ud);		
		return ud;		
		
	}	
	
	@DELETE
    @Path("/{un}")
    @Produces(MediaType.APPLICATION_JSON)
	public boolean deleteUser(@PathParam("un") String un)
	{
    	Connection conn = PostGresqlUtilities.getDBConnection();
    	
    	UserDetails ud = new UserDetails();
    	ud.setUsername(un);
    	
    	//write a stored procedure for the same
    	
    	boolean sqlStatus = (new DeleteUser()).deleteUserDetails(conn, ud);    	
		sqlStatus = (new DeleteUser()).deleteUser(conn, ud);		
		
		//log message 
		System.out.println(sqlStatus);
		return sqlStatus;
	}	
}

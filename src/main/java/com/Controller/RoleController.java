package com.Controller;

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
import com.service.Role.CreateRole;
import com.service.Role.DeleteRole;
import com.service.Role.ReadRole;
import com.service.Role.RoleDetails;
import com.service.Role.UpdateRole;


@Path("/Role")
public class RoleController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RoleDetails> getAllRoleInfo() {
		
		Connection conn = PostGresqlUtilities.getDBConnection();
		
		List<RoleDetails> listroledetails = new ArrayList<RoleDetails>();

		boolean sqlStatus = (new ReadRole()).selectAllRoles(conn, listroledetails);
		// log message
		System.out.println(sqlStatus);
		return listroledetails;
	}
	
	@GET
	@Path("/{rolename}")
	@Produces(MediaType.APPLICATION_JSON)
	public RoleDetails getRoleDetailsbyName
	(@PathParam("rolename") String rolename) {
		RoleDetails rd = new RoleDetails();
		rd.setRoleName(rolename);
		
		Connection conn = PostGresqlUtilities.getDBConnection();
		boolean userStatus = (new ReadRole()).selectRoleByName(conn, rd);
	
		System.out.println("username inside UserController getbyuserId " 
				+ rd.getRoleId());
				
		return rd;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RoleDetails addUserDetails(RoleDetails rd)
	{
		Connection conn = PostGresqlUtilities.getDBConnection();
		
		CreateRole cusr = new CreateRole();
		
		boolean cusrbool = cusr.insertRole(conn, rd);
		
		return rd;		
	}
	
	@PUT
	@Path("/{roleId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RoleDetails updateUserDetails
	(@PathParam("roleId") int roleId,RoleDetails rd)
	{
		rd.setRoleId(roleId);
		
		Connection conn = PostGresqlUtilities.getDBConnection();
	
		System.out.println("Inside updateRoleDetails roleId is" + rd.getRoleId());
		
		System.out.println("Inside updateRoleDetails roleName is" + rd.getRoleName());
		
		UpdateRole uu = new UpdateRole();
		boolean userStatus = uu.updateRoleusingId(conn, rd);		
		return rd;		
	}	
	
	@DELETE
    @Path("/{rid}")
    @Produces(MediaType.APPLICATION_JSON)
	public boolean deleteRole(@PathParam("rid") int rid)
	{
    	Connection conn = PostGresqlUtilities.getDBConnection();
    	
    	RoleDetails rd = new RoleDetails();
    	rd.setRoleId(rid);
    	//write a stored procedure for the same    	
    	return (new DeleteRole()).deleteRolebyId(conn, rd); 
	}
}

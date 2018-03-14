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
import com.service.Modules.CreateModules;
import com.service.Modules.DeleteModules;
import com.service.Modules.ModuleDetails;
import com.service.Modules.ReadModules;
import com.service.Modules.UpdateModules;

@Path("/Module")
public class ModuleController {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<ModuleDetails> getAllModuleInfo()
	{
		Connection conn = PostGresqlUtilities.getDBConnection();
		List<ModuleDetails> listmoddetails = new ArrayList<ModuleDetails> ();
		
		boolean sqlStatus = (new ReadModules()).selectAllModule(conn,listmoddetails);
		
		//log message 
		System.out.println(sqlStatus);
		
		return listmoddetails;
	}	
       
	@GET
	@Path("/{moduleName}")
	@Produces(MediaType.APPLICATION_JSON)
	public ModuleDetails getModuleByName
	(@PathParam("moduleName") String moduleName) {
		ModuleDetails md = new ModuleDetails();
		md.setModuleName(moduleName);
		
		System.out.println("Inside Module getByname " + md.getModuleName());
		Connection conn = PostGresqlUtilities.getDBConnection();
		ModuleDetails md1 = (new ReadModules()).selectModuleByName(conn, md);
		
		System.out.println("Inside Module after db call getByname " + md1.getModuleName());
		System.out.println("Inside Module after db call getModuleDescription " + md1.getModuleDescription());
				
		return (md1);	
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ModuleDetails addUserDetails(ModuleDetails moddetails)
	{
		Connection conn = PostGresqlUtilities.getDBConnection();
		
		System.out.println(moddetails.getModuleName());
		System.out.println(moddetails.getModuleDescription());
		
		ModuleDetails md = (new CreateModules()).insertModule(conn, moddetails);
		
		return md;		
	}
	
	@PUT
	@Path("/{moduleId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ModuleDetails updateModuleDetails
	(@PathParam("moduleId") int moduleId,ModuleDetails md)
	{
		md.setModuleId(moduleId);
		
		Connection conn = PostGresqlUtilities.getDBConnection();
	
		System.out.println("Inside updateModuleDetails roleId is" + md.getModuleId());
		
		System.out.println("Inside updateModuleDetails roleName is" + md.getModuleName());
		
		UpdateModules uu = new UpdateModules();
		ModuleDetails md1 =  uu.updateModuleById(conn, md);
		
		return md1;				
	}
	
	@DELETE
    @Path("/{mid}")
    @Produces(MediaType.APPLICATION_JSON)
	public boolean deleteRole(@PathParam("mid") int mid)
	{
    	Connection conn = PostGresqlUtilities.getDBConnection();
    	
    	ModuleDetails md = new ModuleDetails();
    	md.setModuleId(mid);
    	    	
    	return (new DeleteModules()).deleteModuleById(conn, md); 
	}
	
    /*@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	public void deleteAllModules()
	{
    	Connection conn = PostGresqlUtilities.connectLoginlinux();
		
    	boolean sqlStatus = (new DeleteModules()).deleteModuleTable(conn);    	
		//log message
		System.out.println(sqlStatus);		
	}*/
	
}

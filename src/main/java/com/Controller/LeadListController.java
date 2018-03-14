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
import com.service.LeadList.CreateLeadList;
import com.service.LeadList.DeleteLeadList;
import com.service.LeadList.LeadListDetails;
import com.service.LeadList.ReadLeadList;
import com.service.LeadList.UpdateLeadList;


@Path("/Lead_List")
public class LeadListController {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<LeadListDetails> getAllLeadListInfo()
	{
		Connection conn = PostGresqlUtilities.getDBConnection();
		
		//List<LeadListDetails> listlldetails = new ArrayList<LeadListDetails> ();		
		//listlldetails = (new ReadLeadList()).selectAllLeadsTL(conn);
		
		return (new ReadLeadList()).selectAllLeadsTL(conn);
	}	
    //@Path("/{id}/{name}")  
	
	@GET
	@Path("/{leadname}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public LeadListDetails getLeadListById
	(@PathParam("leadname") String leadname,
	          @PathParam("userId") int userId) {

		LeadListDetails lld = new LeadListDetails();
		lld.setLead_name(leadname);
		lld.setFuser_id(userId);
		
		System.out.println("inside getLeadListById leadname " + leadname);
		System.out.println("inside getLeadListById userId " + userId);
		
		Connection conn = PostGresqlUtilities.getDBConnection();
				
		return ((new ReadLeadList()).selectAllLeadsByUser(conn,lld));	
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LeadListDetails addUserDetails(LeadListDetails lldetails)
	{
		Connection conn = PostGresqlUtilities.getDBConnection();				
		LeadListDetails sqlStatus = (new CreateLeadList()).insertLeadList(conn, lldetails);
		
		return sqlStatus;		
	}
	
	@PUT
	@Path("/{leadId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public LeadListDetails updateModuleDetails
	(@PathParam("leadId") int leadId,LeadListDetails lld)
	{
		lld.setLead_id(leadId);		
		Connection conn = PostGresqlUtilities.getDBConnection();
		
		UpdateLeadList uu = new UpdateLeadList();
		LeadListDetails upstatus =  uu.updateLeadListById(conn, lld);
		
		return upstatus;				
	}
	
	@DELETE
    @Path("/{llid}")
    @Produces(MediaType.APPLICATION_JSON)
	public boolean deleteRole(@PathParam("llid") int llid)
	{
    	Connection conn = PostGresqlUtilities.getDBConnection();
    	
    	LeadListDetails lld = new LeadListDetails();
    	lld.setLead_id(llid);
    	    	
    	return (new DeleteLeadList()).deleteLeadListById(conn, lld); 
	}	
}

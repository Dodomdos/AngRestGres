package com.Controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.PostGresUtilities.PostGresqlUtilities;
import com.service.User.ReadUser;
import com.service.User.UserDetails;

@Path("/Authenticate")
public class AuthenticateController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetails> getAllUserInfo() {
		//Connection conn = PostGresqlUtilities.connectLoginlinux();
		Connection conn = PostGresqlUtilities.connectionDBWindows();
		List<UserDetails> listmoddetails = new ArrayList<UserDetails>();

		boolean sqlStatus = (new ReadUser()).selectAllUsers(conn, listmoddetails);

		// log message
		System.out.println(sqlStatus);

		return listmoddetails;

	}

}
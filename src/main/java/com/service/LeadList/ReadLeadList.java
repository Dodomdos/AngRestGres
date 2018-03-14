package com.service.LeadList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.service.Modules.ModuleDetails;
import com.service.User.UserDetails;

public class ReadLeadList {
	// TODO get all leads as per lead name,company name and country with user_id
	// TODO get all leads as per lead name,company name and country with all user_id
	// TODO apply filters as per lead name, company and country
	// TODO modify the lead list to include the contact id as well

	public List<LeadListDetails> selectAllLeadsTL(Connection conn) {
		PreparedStatement st;
		List<LeadListDetails> leadlistall = new ArrayList<LeadListDetails>();
		
		try {
			// need to add address validation
			String sql = "select * from tbl_lead_list";
			st = conn.prepareStatement(sql);

			/*st.setString(1, lld.getLead_name());
			st.setString(2, lld.getCompany_name());
			st.setString(3, lld.getCountry());*/

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				// traversing the first one lead name only for now
				// TODO write a generic function for multiple lead names
				// with same company name and country for all users
				LeadListDetails lldone = new LeadListDetails();
				
				lldone.setLead_id(rs.getInt(1));
				lldone.setLead_name(rs.getString(2));
				lldone.setDesignation(rs.getString(3));
				lldone.setCompany_name(rs.getString(4));
				lldone.setCountry(rs.getString(5));
				lldone.setCompany_website(rs.getString(6));
				lldone.setTelephone(rs.getString(7));
				lldone.setEmail(rs.getString(8));
				lldone.setAreaoi(rs.getString(9));
				lldone.setRemarks(rs.getString(10));
				lldone.setNext_date(rs.getString(11));
				lldone.setStatus(rs.getString(12));
				lldone.setCur_remarks(rs.getString(13));
				lldone.setDegree(rs.getString(14));
				
				lldone.setFrole_id(rs.getInt(15));
				lldone.setFuser_id(rs.getInt(16));

				leadlistall.add(lldone);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return leadlistall;
	}

	public LeadListDetails selectAllLeadsByUser(Connection conn, LeadListDetails lld) {
		PreparedStatement st;
		List<LeadListDetails> leadlistall = new ArrayList<LeadListDetails>();
		LeadListDetails lldone = new LeadListDetails();
		
		try {
			// need to add address validation
			String sql = "select * from tbl_lead_list where user_id=? and lead_name =?";
			st = conn.prepareStatement(sql);

			//st.setString(1, lld.getLead_name());
			//st.setString(2, lld.getCompany_name());
			//st.setString(3, lld.getCountry());
			st.setInt(1,lld.getFuser_id());
			st.setString(2,lld.getLead_name());	
			
			ResultSet rs = st.executeQuery();		
			
			while (rs.next()) {
				// traversing the first one lead name only for now
				// TODO write a generic function for multiple lead names
				// with same company name and country for all users
				
						
				lldone.setLead_id(rs.getInt(1));
				lldone.setLead_name(rs.getString(2));
				
				System.out.println(" lld name " + lldone.getLead_name());
				
				lldone.setDesignation(rs.getString(3));
				lldone.setCompany_name(rs.getString(4));
				lldone.setCountry(rs.getString(5));
				lldone.setCompany_website(rs.getString(6));
				lldone.setTelephone(rs.getString(7));
				lldone.setEmail(rs.getString(8));
				lldone.setAreaoi(rs.getString(9));
				lldone.setRemarks(rs.getString(10));
				lldone.setNext_date(rs.getString(11));
				lldone.setStatus(rs.getString(12));
				lldone.setCur_remarks(rs.getString(13));
				lldone.setDegree(rs.getString(14));
				
				lldone.setFrole_id(rs.getInt(15));
				lldone.setFuser_id(rs.getInt(16));

				leadlistall.add(lldone);				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return 	lldone;
	}	

}

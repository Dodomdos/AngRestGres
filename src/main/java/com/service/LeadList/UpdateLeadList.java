package com.service.LeadList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.service.Modules.ModuleDetails;

public class UpdateLeadList {

	public LeadListDetails updateLeadListById(Connection conn,LeadListDetails lld) {
		
		PreparedStatement st;		
		
		System.out.println(" lead id in update " + lld.getLead_id());

		try {
			String sql = "update tbl_lead_list set lead_name=?,designation=?,"
					+ "company_name=?,country=?,company_website=?,telephone=?,"
					+ "email=?,areaoi=?,remarks=?,next_date=?,status=?,"
					+ "cur_remarks=?,degree=?,role_id=?,user_id=? where lead_id=?";
			
			st = conn.prepareStatement(sql);

			st.setString(1,lld.getLead_name());
			st.setString(2, lld.getDesignation());
			st.setString(3, lld.getCompany_name());
			st.setString(4, lld.getCountry());
			st.setString(5, lld.getCompany_website());
			st.setString(6, lld.getTelephone());
			st.setString(7, lld.getEmail());
			st.setString(8, lld.getAreaoi());
			st.setString(9, lld.getRemarks());
			st.setString(10, lld.getNext_date());
			st.setString(11, lld.getStatus());
			st.setString(12, lld.getCur_remarks());
			st.setString(13, lld.getDegree());
			st.setInt(14, lld.getFrole_id());
			st.setInt(15, lld.getFuser_id());
			st.setInt(16,lld.getLead_id());	
			
			st.execute();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//return false;
		}				
		return lld;
	}	
}

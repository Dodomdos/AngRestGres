package com.service.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.service.Modules.ModuleDetails;
import com.service.User.UserDetails;

public class ReadProject {
	// TODO get all leads as per lead name,company name and country with user_id
	// TODO get all leads as per lead name,company name and country with all user_id
	// TODO apply filters as per lead name, company and country

	public static boolean selectLead(Connection conn, ProjectDetails lld, ModuleDetails md, UserDetails ud) {
		PreparedStatement st;
		try {
			// need to add address validation
			String sql = "select * from tbl_lead_list where lead_name=? and company_name=? " + "and country=?";
			st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				// traversing the first one lead name only for now
				// TODO write a generic function for multiple lead names
				// with same company name and country for all users

				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
}

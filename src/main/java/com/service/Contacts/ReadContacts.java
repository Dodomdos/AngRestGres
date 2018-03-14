package com.service.Contacts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.service.Modules.ModuleDetails;
import com.service.User.UserDetails;

public class ReadContacts {
	// TODO get all leads as per lead name,company name and country with user_id
	// TODO get all leads as per lead name,company name and country with all user_id
	// TODO apply filters as per lead name, company and country

	public static boolean selectLead(Connection conn, ContactsDetails lld, ModuleDetails md, UserDetails ud) {
		PreparedStatement st;
		try {
			// need to add address validation
			String sql = "select * from tbl_lead_list where lead_name=? and company_name=? " + "and country=?";
			st = conn.prepareStatement(sql);

			st.setString(1, lld.getLead_name());
			st.setString(2, lld.getCompany_name());
			st.setString(3, lld.getCountry());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				// traversing the first one lead name only for now
				// TODO write a generic function for multiple lead names
				// with same company name and country for all users

				lld.setLead_id(rs.getInt(1));
				lld.setLead_name(rs.getString(2));
				lld.setDesignation(rs.getString(3));
				lld.setCompany_name(rs.getString(4));
				lld.setCountry(rs.getString(5));
				lld.setCompany_website(rs.getString(6));
				lld.setTelephone(rs.getString(7));
				lld.setEmail(rs.getString(8));
				lld.setAreaoi(rs.getString(9));
				lld.setRemarks(rs.getString(10));
				lld.setNext_date(rs.getDate(11));
				lld.setStatus(rs.getString(12));
				lld.setCur_remarks(rs.getString(13));
				lld.setDegree(rs.getString(14));
				md.setModuleId(rs.getInt(15));
				ud.setUserId(rs.getInt(16));

				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
}

package com.service.PO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.service.Modules.ModuleDetails;
import com.service.User.UserDetails;

public class ReadPO {
	// TODO get all leads as per lead name,company name and country with user_id
	// TODO get all leads as per lead name,company name and country with all user_id
	// TODO apply filters as per lead name, company and country

	public static boolean selectPO(Connection conn, PODetails pd,
			ModuleDetails md, UserDetails ud) {
		PreparedStatement st;
		try {

			String sql = "select * from tbl_purchase_order where po_name=?";
			st = conn.prepareStatement(sql);

			st.setString(1, pd.getPo_name());			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				// traversing the only po name
				pd.setPo_id(rs.getInt(1));
				pd.setPo_name(rs.getString(2));
				pd.setPo_createdt(rs.getDate(3));
				pd.setPo_details(rs.getString(4));
				pd.setPo_to(rs.getNString(5));
				pd.setPo_from(rs.getString(6));
				pd.setModule_id(rs.getInt(7));
				pd.setUser_id(rs.getInt(8));				
				
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
}

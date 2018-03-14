package com.service.BankInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadBank {
	// TODO get all banks

	public static boolean selectRole(Connection conn, BankDetails bd) {
		PreparedStatement st;
		try {
			//need to add address validation
			String sql = "select * from tbl_bank where bank_name=?";
			st = conn.prepareStatement(sql);

			st.setString(1, bd.getBank_name());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				// traversing the first one bank name only for now
				//TODO need to check with address validation 
				bd.setBank_id(rs.getInt(1));
				bd.setBank_name(rs.getString(2));
				bd.setBank_ifsc_code(rs.getString(3));
				bd.setBank_swift_code(rs.getString(4));
				bd.setBank_address(rs.getString(5));
				bd.setBank_account_number(rs.getString(6));
				bd.setPan_number(rs.getString(7));
				bd.setBank_international_code(rs.getString(8));
				
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
}

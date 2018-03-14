package com.service.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.service.BankInfo.BankDetails;
import com.service.Modules.ModuleDetails;
import com.service.PO.PODetails;
import com.service.User.UserDetails;

public class ReadInvoice {
	// TODO get all leads as per lead name,company name and country with user_id
	// TODO get all leads as per lead name,company name and country with all user_id
	// TODO apply filters as per lead name, company and country

	public static boolean selectInvoice(Connection conn, InvoiceDetails id, BankDetails bd, PODetails pd,
			ModuleDetails md, UserDetails ud) {

		PreparedStatement st;
		try {

			String sql = "select * from tbl_invoice_details where invoice_name=?";
			st = conn.prepareStatement(sql);

			st.setString(1, id.getInvoice_name());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				// traversing the only invoice name
				id.setInvoice_id(rs.getInt(1));
				id.setInvoice_name(rs.getString(2));
				id.setInvoice_date(rs.getDate(3));
				id.setInvoice_name(rs.getString(4));
				id.setInvoice_details(rs.getString(5));
				id.setInvoice_gst_code(rs.getString(6));
				id.setPo_id(rs.getInt(7));
				id.setBank_id(rs.getInt(8));
				id.setModule_id(rs.getInt(9));
				id.setUser_id(rs.getInt(10));

				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
}

package com.service.Contacts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.service.BankInfo.BankDetails;

public class DeleteContacts {
	
	public static boolean dropLeadListTable(Connection conn) {
		PreparedStatement st;
		try {			
			String sql = "drop table tbl_lead_list cascade";
			st = conn.prepareStatement(sql);			
			return st.execute();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public static boolean deleteBankTable(Connection conn) {
		PreparedStatement st;
		try {			
			String sql = "delete from tbl_lead_list";
			st = conn.prepareStatement(sql);			
			return st.execute();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public static boolean deleteLeadList(Connection conn,ContactsDetails lld) {
		PreparedStatement st;
		try {
			String sql = "delete from tbl_lead_list where lead_name= ? and company_name=?"
					+ " and country=?";
			
			st = conn.prepareStatement(sql);	
			
			st.setString(1, lld.getLead_name());
			st.setString(2, lld.getCompany_name());
			st.setString(3,lld.getCountry());
			
			return st.execute();				
		}catch(SQLException q)
		{
			System.out.println(q.getMessage());
			return false;
		}		
	}	


}

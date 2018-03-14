package com.service.LeadList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.service.BankInfo.BankDetails;

public class DeleteLeadList {
	
	public boolean dropLeadListTable(Connection conn) {
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
	
	public boolean deleteBankTable(Connection conn) {
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
	
	public boolean deleteLeadListById(Connection conn,LeadListDetails lld) {
		PreparedStatement st;
		try {
			String sql = "delete from tbl_lead_list where lead_id= ?";
			
			st = conn.prepareStatement(sql);	
			
			st.setInt(1,lld.getLead_id());			
			return st.execute();				
		}catch(SQLException q)
		{
			System.out.println(q.getMessage());
			return false;
		}		
	}	

}

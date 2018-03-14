package com.service.BankInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.service.Role.RoleDetails;

public class DeleteBank {
	
	public static boolean dropBankTable(Connection conn) {
		PreparedStatement st;
		try {			
			String sql = "drop table tbl_bank_details cascade";
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
			String sql = "delete from tbl_bank_details";
			st = conn.prepareStatement(sql);			
			return st.execute();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public static boolean deleteBank(Connection conn,BankDetails bd) {
		PreparedStatement st;
		try {
			String sql = "delete from tbl_bank_details where bank_name= ?";
			
			st = conn.prepareStatement(sql);			
			st.setString(1, bd.getBank_name());
			
			return st.execute();						
		}catch(SQLException q)
		{
			System.out.println(q.getMessage());
			return false;
		}		
	}	
}

package com.service.PO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePO {
	public static boolean dropPOTable(Connection conn) {
		PreparedStatement st;
		try {			
			String sql = "drop table tbl_purchase_order cascade";
			st = conn.prepareStatement(sql);			
			return st.execute();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public static boolean deletePOTable(Connection conn) {
		PreparedStatement st;
		try {			
			String sql = "delete from tbl_purchase_order";
			st = conn.prepareStatement(sql);			
			return st.execute();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public static boolean deletePO(Connection conn,PODetails pd) {
		PreparedStatement st;
		try {
			String sql = "delete from tbl_purchase_order where po_name= ?";
			
			st = conn.prepareStatement(sql);			
			st.setString(1, pd.getPo_name());
			
			return st.execute();						
		}catch(SQLException q)
		{
			System.out.println(q.getMessage());
			return false;
		}		
	}	
}

package com.service.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.service.BankInfo.BankDetails;

public class DeleteInvoice {

	public static boolean dropInvoiceTable(Connection conn) {
		PreparedStatement st;
		try {			
			String sql = "drop table tbl_invoice_details cascade";
			st = conn.prepareStatement(sql);			
			return st.execute();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public static boolean deleteInvoiceTable(Connection conn) {
		PreparedStatement st;
		try {			
			String sql = "delete from tbl_invoice_details";
			st = conn.prepareStatement(sql);			
			return st.execute();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public static boolean deleteInvoice(Connection conn,InvoiceDetails id) {
		PreparedStatement st;
		try {
			String sql = "delete from tbl_invoice_details where invoice_name= ?";
			
			st = conn.prepareStatement(sql);			
			st.setString(1, id.getInvoice_name());
			
			return st.execute();						
		}catch(SQLException q)
		{
			System.out.println(q.getMessage());
			return false;
		}		
	}	
}

package com.service.BankInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.service.Role.RoleDetails;

public class CreateBank {

	public static boolean createBankTable(Connection conn) {
		PreparedStatement st = null;
		try {
			// add reference restriction on bank_id
			//how to avoid duplicate entries using address
			//break up bank address into bank no,street name,pin code etc...
			String sql = "create table tbl_bank_details(" + "bank_id serial primary key,"
					+ "bank_name varchar(255) not null,"
					+ "bank_ifsc_code varchar(45),"
					+ "bank_swift_code varchar(45) ,"
					+ "bank_address text not null,"
					+ "bank_account_number varchar(255) not null,"
					+ "pan_number varchar(255) ,"
					+ "bank_international_code varchar(255))";

			st = conn.prepareStatement(sql);
			return (st.execute());
		} catch (SQLException q) {
			System.out.println(q.getMessage());
		}
		return false;
	}
	
	public static boolean insertBank(Connection conn,BankDetails bd) {
		PreparedStatement st;
		try {
			String sql = "insert into tbl_bank_details(bank_name ,bank_ifsc_code ,"
					+ "bank_swift_code ,bank_address,bank_account_number," + 
					"pan_number, bank_international_code) values(?,?,?,?,?,?,?)";
			
			st = conn.prepareStatement(sql);
			
			st.setString(1,bd.getBank_name());
			st.setString(2,bd.getBank_ifsc_code());
			st.setString(3,bd.getBank_swift_code());
			st.setString(4, bd.getBank_address());
			st.setString(5, bd.getBank_account_number());
			st.setString(6, bd.getPan_number());
			st.setString(7, bd.getBank_international_code());
			
			return (st.execute());
			
		}catch(SQLException q)
		{
			return false;
		}
	}
}

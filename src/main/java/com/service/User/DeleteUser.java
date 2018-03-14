package com.service.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUser {
	
	public boolean deleteUser(Connection conn, UserDetails usr)
	{	
		PreparedStatement st;
		try {		
			st = conn.prepareStatement("delete from tbl_user where user_name= ?");					
			
			st.setString(1, usr.getUsername());
					
			int rs = st.executeUpdate();
			while (rs > 0)
			{
			   System.out.print("Column 1 returned ");
			   //TODO connection close is missing
			   st.close();
			   return true;			   
			}									
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean deleteUserDetails(Connection conn, UserDetails usr)
	{	
		PreparedStatement st;
		try {		
			st = conn.prepareStatement("delete from tbl_user_details tud using tbl_user tu where tu.user_name= ? and tud.user_id = tu.user_id");					
			
			st.setString(1, usr.getUsername());
					
			int rs = st.executeUpdate();
			while (rs > 0)
			{
			   System.out.print("Column 1 returned ");
			   st.close();
			   return true;			   
			}									
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

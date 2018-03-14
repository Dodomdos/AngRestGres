package com.service.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRole {
	
	public boolean updateRoleusingName(Connection conn,RoleDetails rd) {
		PreparedStatement st;		
		try {
			String sql = "update tbl_role set role_name=?,role_description=?,modules_names=? "
					+ "where role_name=?";
			st = conn.prepareStatement(sql);
			
			st.setString(1, rd.getRoleNamenew());
			st.setString(2, rd.getRoleDescription());
			st.setString(3, rd.getModuleNames());
			st.setString(4, rd.getRoleName());
			
			return st.execute();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public boolean updateRoleusingId(Connection conn,RoleDetails rd) {
		PreparedStatement st;		
		try {
			String sql = "update tbl_role set role_name=?,role_description=?,modules_names=? "
					+ "where role_id=?";
			
			st = conn.prepareStatement(sql);
			
			st.setString(1, rd.getRoleName());
			st.setString(2, rd.getRoleDescription());
			st.setString(3, rd.getModuleNames());
			st.setInt(4, rd.getRoleId());
			
			return st.execute();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
}

package com.service.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRole {
	
	public static boolean dropRoleTable(Connection conn) {
		PreparedStatement st;
		try {			
			String sql = "drop table tbl_role cascade";
			st = conn.prepareStatement(sql);			
			return st.execute();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public static boolean deleteRoleTable(Connection conn) {
		PreparedStatement st;
		try {			
			String sql = "delete from tbl_role";
			st = conn.prepareStatement(sql);			
			return st.execute();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public boolean deleteRolebyName(Connection conn, RoleDetails rd) {
		PreparedStatement st;
		try {
			String sql = "delete from tbl_role where role_name= ?";
			
			st = conn.prepareStatement(sql);			
			st.setString(1, rd.getRoleName());
			return st.execute();						
		}catch(SQLException q)
		{
			System.out.println(q.getMessage());
			return false;
		}		
	}
	
	public boolean deleteRolebyId(Connection conn, RoleDetails rd) {
		PreparedStatement st;
		try {
			String sql = "delete from tbl_role where role_id= ?";
			
			st = conn.prepareStatement(sql);			
			st.setInt(1, rd.getRoleId());
			return st.execute();		
			
		}catch(SQLException q)
		{
			System.out.println(q.getMessage());
			return false;
		}		
	}
}

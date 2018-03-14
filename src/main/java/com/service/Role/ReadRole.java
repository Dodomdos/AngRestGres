package com.service.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.service.Modules.ModuleDetails;
import com.service.User.UserDetails;

public class ReadRole {
	
	//get all roles
	public boolean selectAllRoles(Connection conn, List<RoleDetails> arraylistrd) {
		PreparedStatement st;
		try {
			String sql = "select * from tbl_role";
			st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				RoleDetails roledetails = new RoleDetails();

				roledetails.setRoleId(rs.getInt(1));
				
				roledetails.setRoleName(rs.getString(2));
				
				roledetails.setRoleDescription(rs.getString(3));
				
				roledetails.setModuleNames(rs.getString(4));
				
						
				arraylistrd.add(roledetails);
			}
			
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean selectRoleByName(Connection conn,RoleDetails rd)
	{
		PreparedStatement st;
		try {
			String sql = "select * from tbl_role where role_name=?";
			st = conn.prepareStatement(sql);
			
			st.setString(1,rd.getRoleName());
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				//traversing only once role module name is unique
				rd.setRoleId(rs.getInt(1));
				rd.setRoleName(rs.getString(2));
				rd.setRoleDescription(rs.getString(3));
				rd.setModuleNames(rs.getString(rs.getString(4)));
				return true;
			}		
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean selectRoleIdDetails(Connection conn,RoleDetails rd,UserDetails ud)
	{
		PreparedStatement st;
		try {
			String sql = "select * from tbl_role where role_id=?";
			st = conn.prepareStatement(sql);
			
			st.setInt(1,ud.getRoleId());
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				//traversing only once role module name is unique
				rd.setRoleId(rs.getInt(1));
				rd.setRoleName(rs.getString(2));
				rd.setRoleDescription(rs.getString(3));
				rd.setModuleNames(rs.getString(rs.getString(4)));
				ud.setModuleNames(rs.getString(rs.getString(4)));
				System.out.println("inside read role " + ud.getModuleNames());
				//return true;
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}

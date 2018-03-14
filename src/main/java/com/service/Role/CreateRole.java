package com.service.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateRole {
	
	public static boolean createRoleTable(Connection conn) {
		PreparedStatement st = null;
		try {
			//add reference restriction on role_id
			String sql = "create table tbl_role(role_id serial primary key,"+
					"role_name varchar(255) not null unique,"+
					"role_description varchar(255),"+
					"modules_names text)";	
					
			st = conn.prepareStatement(sql);
			return (st.execute());
		} catch (SQLException q) {
			System.out.println(q.getMessage());
		}
		return false;
	}
	
	public boolean insertRole(Connection conn,RoleDetails rd) {
		PreparedStatement st;
		try {
			String sql = "insert into tbl_role(role_name,role_description,"
					+ "modules_names) values(?,?,?)";
			st = conn.prepareStatement(sql);
			
			st.setString(1,rd.getRoleName() );
			st.setString(2,rd.getRoleDescription() );
			st.setString(3,rd.getModuleNames() );
			return (st.execute());
			
		}catch(SQLException q)
		{
			return false;
		}
	}
}

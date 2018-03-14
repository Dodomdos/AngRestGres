package com.service.Modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateModules {
	
	public boolean createModule(Connection conn) {
		PreparedStatement st = null;
		try {
			//add reference restriction on module_id
			String sql = "create table tbl_module(" + "module_id serial primary key, "
					+ "module_name varchar(255) not null unique," + "module_description text)";
			st = conn.prepareStatement(sql);

			return (st.execute());
		} catch (SQLException q) {
			System.out.println(q.getMessage());
		}
		return false;
	}
	
	public ModuleDetails insertModule(Connection conn,ModuleDetails md) {
		PreparedStatement st;
		try {
			String sql = "insert into tbl_module(module_name,module_description) values(?,?)";
			st = conn.prepareStatement(sql);
			
			st.setString(1, md.getModuleName());
			st.setString(2, md.getModuleDescription());
			st.execute();
			
		}catch(SQLException q)
		{
			//return false;
		}
		return md;
	}
}

package com.service.Modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateModules {

	public boolean updateModuleByName(Connection conn,ModuleDetails md) {
		PreparedStatement st;
		
		try {
			String sql = "update tbl_module set module_name=?,module_description=? "
					+ "where module_name=?";
			st = conn.prepareStatement(sql);
			
			st.setString(1, md.getModuleName());
			st.setString(2, md.getModuleDescription());
			st.setString(3, md.getModuleName());
			
			return st.execute();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public ModuleDetails updateModuleById(Connection conn,ModuleDetails md) {
		PreparedStatement st;
		
		try {
			String sql = "update tbl_module set module_name=?,module_description=? "
					+ "where module_id=?";
			st = conn.prepareStatement(sql);
			
			st.setString(1, md.getModuleName());
			
			System.out.print("Inside updateModuleById " + md.getModuleDescription());;
			
			st.setString(2, md.getModuleDescription());
			st.setInt(3, md.getModuleId());
			
			st.execute();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			//return false;
		}		
		return md;
	}

}

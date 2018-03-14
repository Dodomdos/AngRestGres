package com.service.Modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteModules {
	
	public boolean dropModuleTable(Connection conn) {
		PreparedStatement st;
		try {			
			String sql = "drop table tbl_module cascade";
			st = conn.prepareStatement(sql);			
			return st.execute();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public boolean deleteModuleTable(Connection conn) {
		PreparedStatement st;
		try {			
			String sql = "delete from tbl_module";
			st = conn.prepareStatement(sql);			
			return st.execute();			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public boolean deleteModuleByName(Connection conn, ModuleDetails md) {
		PreparedStatement st;
		try {
			String sql = "delete from tbl_module where module_name= ?";
			
			st = conn.prepareStatement(sql);			
			st.setString(1, md.getModuleName());
			return st.execute();
						
		}catch(SQLException q)
		{
			System.out.println(q.getMessage());
			return false;
		}		
	}	
	
	public boolean deleteModuleById(Connection conn, ModuleDetails md) {
		PreparedStatement st;
		try {
			String sql = "delete from tbl_module where module_id= ?";
			
			st = conn.prepareStatement(sql);			
			st.setInt(1, md.getModuleId());
			return st.execute();
						
		}catch(SQLException q)
		{
			System.out.println(q.getMessage());
			return false;
		}		
	}	
}

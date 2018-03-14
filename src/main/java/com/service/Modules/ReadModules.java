package com.service.Modules;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReadModules {
	//TODO get all modules
	
	public ModuleDetails selectModuleByName(Connection conn,ModuleDetails md)
	{
		PreparedStatement st;
		try {
			String sql = "select * from tbl_module where module_name=?";
			st = conn.prepareStatement(sql);
			
			System.out.println("Inside Readmodules before execution " + md.getModuleName());
			
			st.setString(1,md.getModuleName());
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				//traversing only once since module name is unique
				md.setModuleId(rs.getInt(1));
				
				md.setModuleName(rs.getString(2));
				System.out.println("Inside Readmodules " + md.getModuleName());
				md.setModuleDescription(rs.getString(3));	
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return md;
	}
	
	public boolean selectAllModule(Connection conn,
			List<ModuleDetails> arraylistmd)
	{
		PreparedStatement st;
		try {
			String sql = "select * from tbl_module";
			st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				ModuleDetails md = new ModuleDetails();
				
				md.setModuleId(rs.getInt(1));
				//System.out.print(md.getModuleId());
				md.setModuleName(rs.getString(2));
				//System.out.print(md.getModuleName());
				md.setModuleDescription(rs.getString(3));	
				//System.out.print(md.getModuleDescription());
				
				arraylistmd.add(md);			
			}
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}		
	}
}

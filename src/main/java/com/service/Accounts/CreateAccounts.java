package com.service.Accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.service.Modules.ModuleDetails;
import com.service.User.UserDetails;

public class CreateAccounts {
	
	public static boolean createModule(Connection conn) {
		PreparedStatement st = null;
		try {
			String sql = "create table tbl_lead_list(" + 
					"lead_id serial primary key," + 
					"lead_name varchar(255) not null," + 
					"designation varchar(255) not null," + 
					"company_name text not null," + 
					"country varchar(255) not null," + 
					"company_website text ," + 
					"telephone varchar(255) not null," + 
					"email varchar(255)," + 
					"areaoi text," + 
					"remarks text," + 
					"next_date date," + 
					"status varchar(10)," + 
					"cur_remarks text," + 
					"degree varchar(10)," + 
					"module_id integer," + 
					"foreign key (module_id)" + 
					"references tbl_module(module_id)," + 
					"user_id integer," + 
					"foreign key (user_id)" + 
					"references tbl_user(user_id)" + 
					")";
			System.out.println(sql);
			st = conn.prepareStatement(sql);
			return (st.execute());
			
		} catch (SQLException q) {
			System.out.println(q.getMessage());
		}
		return false;
	}
	
	public static boolean insertLeadList(Connection conn,AccountsDetails lld,ModuleDetails md,
			UserDetails ud) 
	{
		PreparedStatement st;		
		try {
			String sql = "insert into tbl_lead_list(lead_name,designation,company_name," + 
						 "country,company_website,telephone,email,areaoi,remarks," + 
						 "next_date,status,cur_remarks,degree,module_id,user_id) "
						 + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			st = conn.prepareStatement(sql);
			
			
			return (st.execute());
			
		}catch(SQLException q)
		{
			return false;
		}
	}
	
	
}

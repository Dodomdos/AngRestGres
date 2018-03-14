package com.service.LeadList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.service.Modules.ModuleDetails;
import com.service.User.UserDetails;

public class CreateLeadList {
	
	public boolean createLeadList(Connection conn) {
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
					"role_id integer," + 
					"foreign key (role_id)" + 
					"references tbl_role(role_id)," + 
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
	
	public LeadListDetails insertLeadList(Connection conn,LeadListDetails lld) 
	{
		PreparedStatement st;		
		try {
			String sql = "insert into tbl_lead_list(lead_name,designation,company_name," + 
						 "country,company_website,telephone,email,areaoi,remarks," + 
						 "next_date,status,cur_remarks,degree,role_id,user_id) "
						 + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			st = conn.prepareStatement(sql);
			
			st.setString(1,lld.getLead_name());
			st.setString(2,lld.getDesignation());
			st.setString(3,lld.getCompany_name());
			st.setString(4, lld.getCountry());
			st.setString(5,lld.getCompany_website());
			st.setString(6, lld.getTelephone());
			st.setString(7, lld.getEmail());
			st.setString(8, lld.getAreaoi());
			st.setString(9, lld.getRemarks());
			st.setString(10, lld.getNext_date());
			st.setString(11, lld.getStatus());
			st.setString(12, lld.getCur_remarks());
			st.setString(13, lld.getDegree());
			st.setInt(14, lld.getFrole_id());
			st.setInt(15, lld.getFuser_id());
			
			st.execute();
			
		}catch(SQLException q)
		{
			//return false;
		}
		return lld;
	}	
}
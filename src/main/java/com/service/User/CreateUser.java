package com.service.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.service.Role.RoleDetails;

public class CreateUser {

	public static boolean createUserTables(Connection conn) throws SQLException {
		//TODO :Exception handling classes to catch the error messages better		
		PreparedStatement st = null;		
		try {
		
			String c_tbl_user="create table tbl_user(" +     
         			 "		user_id serial primary key," +
                     "		user_name varchar(255) not null UNIQUE," +
                     "		password varchar(100) not null," +
                     "		role_id integer," +
                     "		foreign key (role_id)" +
                     "		references tbl_role(role_id)" +
                     ")"; 
	        
	        String c_tbl_user_details = " create table tbl_user_details( "+
                    "		user_dtl_id serial primary key," +
                    "		first_name varchar(255) not null," +
                    "		last_name varchar(255) not null," +
                    "		user_id integer," +
                    "		foreign key (user_id)" +
                    "		references tbl_user(user_id)" +
                    "		on update cascade on delete cascade)";
	        
	        String createsqls[] = {c_tbl_user,c_tbl_user_details};
			
	        for (String sql : createsqls) {
	       	 st.executeUpdate(sql);
	        }
	        
	        st.close();
	        conn.close();
		}
		catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         return false;	    
	    }
		
		return true;
	}
	
	public boolean insertUser(Connection conn,UserDetails usr) {
		
		PreparedStatement st;
		
		try {			
			String sql = "WITH ins (user_name, password) AS " + 
					"( VALUES " + 
					"    ( ?, ?) " + 
					")" + 
					"insert into tbl_user(user_name,password,role_id)" + 
					"select " + 
					" u.user_name,u.password, r.role_id " + 
					"from " + 
					" ins u,tbl_role r " + 
					"	where r.role_name=?";			
			
			st = conn.prepareStatement(sql);
			
			st.setString(1, usr.getUsername());
			st.setString(2, usr.getPassword());
			st.setString(3, usr.getRoleName());			
					
			boolean b = st.execute();
			if (st.getUpdateCount() > 0)
			{
				return true;
			}			
			
			st.close();				

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			return false;
		}
		return false;
	}
	
	public boolean insertUserDetails(Connection con,UserDetails usr) {
		
		PreparedStatement st;
						
		try {					
			st = con.prepareStatement("insert into tbl_user_details(first_name,last_name,user_id)"
					+ " values (?,?,?)");
			
			st.setString(1, usr.getFirstName());
			st.setString(2, usr.getLastName());
			st.setInt(3, usr.getUserId());			
				
			boolean b = st.execute();
			if (st.getUpdateCount() > 0)
			{
				return true;
			}				
			st.close();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
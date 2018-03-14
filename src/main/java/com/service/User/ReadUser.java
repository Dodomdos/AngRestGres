package com.service.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.service.Modules.ModuleDetails;
import com.service.Role.RoleDetails;

public class ReadUser {

	public boolean selectAllUsers(Connection conn, List<UserDetails> arraylistud) {
		PreparedStatement st;
		try {
			String sql = "select * from tbl_user";
			st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				UserDetails usrdetails = new UserDetails();

				usrdetails.setUserId(rs.getInt(1));
				System.out.println(usrdetails.getUserId());
				usrdetails.setUsername(rs.getString(2));
				System.out.println(usrdetails.getUsername());
				usrdetails.setPassword(rs.getString(3));
				System.out.println(usrdetails.getPassword());
				usrdetails.setRoleId(rs.getInt(4));
				System.out.println(usrdetails.getRoleId());
		
				arraylistud.add(usrdetails);
			}
			
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean selectAllUsersDetails(Connection conn, List<UserDetails> arraylistud) {
		PreparedStatement st;
		try {
			
			//you need to use a left outer join instead of a cross join
			String sql = "select t.user_id,t.user_name,ud.first_name,ud.last_name,t.password,t.role_id,r.role_name,r.modules_names "
					+ " from tbl_user t,tbl_role r,tbl_user_details ud where t.user_id = ud.user_id and t.role_id = r.role_id ";  
			
			st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				UserDetails usrdetails = new UserDetails();

				usrdetails.setUserId(rs.getInt(1));
				usrdetails.setUsername(rs.getString(2));
				usrdetails.setFirstName(rs.getString(3));
				usrdetails.setLastName(rs.getString(4));
				usrdetails.setPassword(rs.getString(5));
				usrdetails.setRoleId(rs.getInt(6));
				usrdetails.setRoleName(rs.getString(7));
				usrdetails.setModuleNames(rs.getString(8));
				
				arraylistud.add(usrdetails);
			}
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}


	public boolean selectUserId(Connection conn, UserDetails usrdetails) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select user_id from tbl_user where user_name= ?");
			st.setString(1, usrdetails.getUsername());
			rs = st.executeQuery();

			while (rs.next()) {
				usrdetails.setUserId(rs.getInt(1));
				System.out.println(usrdetails.getUserId());
			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO write an exception class
			// rs.close();
			// st.close();
			return false;
		}
		return true;
	}

	public boolean selectUser(Connection conn, UserDetails usrdetails) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select * from tbl_user where user_name= ?");
			st.setString(1, usrdetails.getUsername());
			rs = st.executeQuery();
		
			//clearing the user name
			usrdetails.setUsername("");
			
			while (rs.next()) {
				usrdetails.setUserId(rs.getInt(1));
				System.out.println(usrdetails.getUserId());
				usrdetails.setUsername(rs.getString(2));
				System.out.println(usrdetails.getUsername());
				usrdetails.setPassword(rs.getString(3));
				System.out.println(usrdetails.getPassword());
				usrdetails.setRoleId(rs.getInt(4));
				System.out.println(usrdetails.getRoleId());
			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO write an exception class
			// rs.close();
			// st.close();
		}
		return true;
	}
	
	

	public boolean selectUserDetailsFromID(Connection conn, UserDetails usrdetails) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select t.user_id,t.user_name,t.password,t.role_id,"
					+ "td.first_name,td.last_name from tbl_user t,tbl_user_details td "
					+ "where td.user_id = t.user_id and t.user_id = ? ");
			
			st.setInt(1, usrdetails.getUserId());
			//st.setString(2, usrdetails.getPassword());
			
			rs = st.executeQuery();

			while (rs.next()) {
				usrdetails.setUserId(rs.getInt(1));
				
				usrdetails.setUsername(rs.getString(2));
				
				usrdetails.setPassword(rs.getString(3));
				
				usrdetails.setRoleId(rs.getInt(4));
				
				usrdetails.setFirstName(rs.getString(5));
							
				usrdetails.setLastName(rs.getString(6));
				
			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO write an exception class
			// rs.close();
			// st.close();
		}
		return true;
	}

	public boolean selectUserRole(Connection conn, UserDetails usrdetails, RoleDetails rd) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("select t.user_id,t.user_name,t.password,t.role_id,r.role_name,r.modules_names "
					+ "from tbl_user t,tbl_role r where user_name=? and " + "t.role_id=r.role_id");

			st.setString(1, usrdetails.getUsername());
			rs = st.executeQuery();

			while (rs.next()) {
				usrdetails.setUserId(rs.getInt(1));
				System.out.println(usrdetails.getUserId());
				usrdetails.setUsername(rs.getString(2));
				System.out.println(usrdetails.getUsername());
				usrdetails.setPassword(rs.getString(3));
				System.out.println(usrdetails.getPassword());
				usrdetails.setRoleId(rs.getInt(4));
				System.out.println(usrdetails.getRoleId());
				rd.setRoleName(rs.getString(5));
				rd.setModuleNames(rs.getString(6));
			}
			rs.close();
			st.close();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO write an exception class
			// rs.close();
			// st.close();
		}
		return false;
	}

	public boolean selectUserRoleDetails(Connection conn, 
			UserDetails usrdetails) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//inner join or cross join			
			st = conn.prepareStatement("select t.user_id,t.user_name,t.password,t.role_id,r.role_name,r.modules_names, "
					+ "(select ud.first_name || ud.last_name as name from tbl_user_details ud, tbl_user t where "  
					+ "ud.user_id = t.user_id and t.user_name=?) from tbl_user t,tbl_role r where t.role_id = r.role_id "  
					+ "and t.user_name=? and t.password=?");
		
			//ideally you should use a left outer join on tbl_user but it is ignoring the user_name condition and reporting 
			//all the rows
			//select t.user_id,t.user_name,t.password,t.role_id,r.role_name,r.modules_names, 
			//(select ud.first_name || ud.last_name as name from tbl_user_details ud, tbl_user t 
			//where ud.user_id = t.user_id and t.user_name='mamatha') from tbl_user t 
			//LEFT OUTER JOIN tbl_role r ON t.role_id = r.role_id and t.user_name='mamatha';
			//so we are using the cross join
			st.setString(1, usrdetails.getUsername());
			st.setString(2, usrdetails.getUsername());
			st.setString(3, usrdetails.getPassword());
			
			rs = st.executeQuery();

			usrdetails.setUsername("");
			System.out.println("usrdetails.setUsername " + usrdetails.getUsername());
			usrdetails.setPassword("");
			
			while (rs.next()) {
				usrdetails.setUserId(rs.getInt(1));
				System.out.println(usrdetails.getUserId());
				usrdetails.setUsername(rs.getString(2));
				System.out.println(usrdetails.getUsername());
				usrdetails.setPassword(rs.getString(3));
				System.out.println(usrdetails.getPassword());
				usrdetails.setRoleId(rs.getInt(4));
				System.out.println(usrdetails.getRoleId());
				usrdetails.setRoleName(rs.getString(5));
				usrdetails.setModuleNames(rs.getString(6));
				usrdetails.setFullName(rs.getString(7));				
			}
			
			System.out.println("usrdetails.setUsername1 after while " + usrdetails.getUsername());
			rs.close();
			st.close();			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			// TODO write an exception class
			// rs.close();
			// st.close();
		}
		return true;
	}	
}

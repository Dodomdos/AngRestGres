package com.service.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateUser {

	public static boolean updateUser(Connection conn, UserDetails usrdetails) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("update tbl_user set user_name=?,password=? where user_name= ?");

			st.setString(1, usrdetails.getUsernamenew());
			st.setString(2, usrdetails.getPassword());
			st.setString(3, usrdetails.getUsername());

			boolean s = st.execute();
			if (st.getUpdateCount() > 0) {
				return true;
			}
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO write an exception class
			return false;
		}
		return false;
	}
	
	public boolean updateUserusingID(Connection conn, UserDetails usrdetails) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("update tbl_user set user_name=?,password=?,"
					+ "role_id=? where user_id= ?");

			st.setString(1, usrdetails.getUsername());
			st.setString(2, usrdetails.getPassword());
			st.setInt(3, usrdetails.getRoleId());
			st.setInt(4, usrdetails.getUserId());

			boolean s = st.execute();
			if (st.getUpdateCount() > 0) {
				return true;
			}
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO write an exception class
			return false;
		}
		return false;
	}


	public boolean updateUserDetails(Connection conn, UserDetails usrdetails) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("update tbl_user_details set first_name=?,last_name=? where user_id= ?");

			st.setString(1, usrdetails.getFirstName());
			st.setString(2, usrdetails.getLastName());
			st.setInt(3, usrdetails.getUserId());

			boolean s = st.execute();
			if (st.getUpdateCount() > 0) {
				st.close();
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO write an exception class
			return false;
		}
		return false;
	}

	public static boolean update2User(Connection conn, UserDetails usrdetails) {
		PreparedStatement st = null;

		try {

			String sql1 = "WITH upduser(user_name_old,user_name_new,passwordnew,first_name_new,last_name_new) as "
					+ "(select ?::text,?::text,?::text, " + "?::text,?::text  " + ")update tbl_user_details "
					+ "set first_name=u.first_name_new,last_name=u.last_name_new " + "from upduser u , tbl_user t "
					+ "WHERE t.user_id = tbl_user_details.user_id and t.user_name=u.user_name_old";

			st = conn.prepareStatement(sql1);

			st.setString(1, usrdetails.getUsername());
			st.setString(2, usrdetails.getUsernamenew());
			st.setString(3, usrdetails.getPassword());
			st.setString(4, usrdetails.getFirstName());
			st.setString(5, usrdetails.getLastName());

			boolean r = st.execute();
			if (st.getUpdateCount() > 0) {
				System.out.println("tbl_user_details updated successfully");
			}

			String sql = "WITH upduser(user_name_old,user_name_new,passwordnew,first_name_new,last_name_new) as "
					+ "(select ?::text,?::text,?::text, " + "?::text,?::text  "
					+ ")UPDATE tbl_user SET user_name = u.user_name_new,password=u.passwordnew "
					+ "FROM upduser u WHERE user_name = u.user_name_old";

			st = conn.prepareStatement(sql);

			st.setString(1, usrdetails.getUsername());
			st.setString(2, usrdetails.getUsernamenew());
			st.setString(3, usrdetails.getPassword());
			st.setString(4, usrdetails.getFirstName());
			st.setString(5, usrdetails.getLastName());

			boolean s = st.execute();
			if (st.getUpdateCount() > 0) {
				st.close();
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO write an exception class
			return false;
		} finally {

		}
		return false;
	}
}
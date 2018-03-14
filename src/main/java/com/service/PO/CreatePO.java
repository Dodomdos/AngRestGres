package com.service.PO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.service.Modules.ModuleDetails;
import com.service.User.UserDetails;

public class CreatePO {
	
	public static boolean createModule(Connection conn) {
		PreparedStatement st = null;
		try {
			String sql = "create table tbl_purchase_order(" + 
					"po_id serial primary key," + 
					"po_name varchar(255) not null unique," + 
					"po_createdt date,po_details text not null," + 
					"po_to text not null," + 
					"po_from text not null," + 
					"module_id integer," + 
					"foreign key (module_id)" + 
					"references tbl_module(module_id)," + 
					"user_id integer," + 
					"foreign key (user_id)" + 
					"references tbl_user(user_id))";

			System.out.println(sql);
			st = conn.prepareStatement(sql);
			return (st.execute());

		} catch (SQLException q) {
			System.out.println(q.getMessage());
		}
		return false;
	}

	public static boolean insertInvoiceDetails(Connection conn,
			ModuleDetails md, UserDetails ud,PODetails pd) {
		PreparedStatement st;
		try {
			String sql = "insert into tbl_purchase_order(po_name,po_createdt,po_details,po_to,"
					+ "po_from,module_id,user_id)"
					+ " values(?,?,?,?,?,?,?)";
			
			st = conn.prepareStatement(sql);

			st.setString(1, pd.getPo_name());
			st.setDate(2, pd.getPo_createdt());
			st.setString(3, pd.getPo_details());
			st.setString(4, pd.getPo_to());
			st.setString(5, pd.getPo_from());
			st.setInt(6, pd.getModule_id());
			st.setInt(7, pd.getUser_id());
			
			return (st.execute());
		} catch (SQLException q) {
			return false;
		}
	}
}

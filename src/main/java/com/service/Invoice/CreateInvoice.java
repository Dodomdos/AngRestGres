package com.service.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.service.BankInfo.BankDetails;
import com.service.Modules.ModuleDetails;
import com.service.PO.PODetails;
import com.service.User.UserDetails;

public class CreateInvoice {
	public static boolean createModule(Connection conn) {
		PreparedStatement st = null;
		try {
			String sql = "create table tbl_invoice_details(invoice_id serial primary key,"
					+ "invoice_name varchar(255) not null unique,invoice_date date not null,"
					+ "invoice_to varchar(255) not null,invoice_from varchar(255) not null,"
					+ "invoice_details text not null,invoice_gst_code varchar(255) not null,"
					+ "po_id integer,"
					+ "bank_id integer,module_id integer,foreign key (po_id)"
					+ "references tbl_purchase_order(po_id),foreign key (bank_id)"
					+ "references tbl_bank_details(bank_id),foreign key (module_id)"
					+ "references tbl_module(module_id),user_id integer,foreign key (user_id)"
					+ "references tbl_user(user_id))";

			System.out.println(sql);
			st = conn.prepareStatement(sql);
			return (st.execute());

		} catch (SQLException q) {
			System.out.println(q.getMessage());
		}
		return false;
	}

	public static boolean insertInvoiceDetails(Connection conn, InvoiceDetails id,
			BankDetails bd,ModuleDetails md, UserDetails ud,PODetails pd) {
		PreparedStatement st;
		try {
			String sql = "insert into tbl_invoice_details(invoice_name,invoice_date,invoice_to,"
					+ "invoice_from,invoice_details,invoice_gst_code,po_id,"
					+ "bank_id,module_id,user_id) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			
			st = conn.prepareStatement(sql);

			st.setString(1, id.getInvoice_name());
			st.setDate(2, id.getInvoice_date());
			st.setString(3, id.getInvoice_to());
			st.setString(4, id.getInvoice_from());
			st.setString(5, id.getInvoice_details());
			st.setString(6, id.getInvoice_gst_code());
			st.setInt(7, pd.getPo_id());
			st.setInt(8,bd.getBank_id());
			st.setInt(9,md.getModuleId());
			st.setInt(10, ud.getUserId());
			
			return (st.execute());

		} catch (SQLException q) {
			return false;
		}
	}
}

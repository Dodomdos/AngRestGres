package com.service.Invoice;

import java.sql.Date;

public class InvoiceDetails {
	int invoice_id;
	String invoice_name;
	Date invoice_date;
    String invoice_to;
    String invoice_from;
    String invoice_details;
    String invoice_gst_code;
    int po_id;
    int bank_id;
    int module_id;
    int user_id;
        
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	
	public String getInvoice_name() {
		return invoice_name;
	}
	
	public void setInvoice_name(String invoice_name) {
		this.invoice_name = invoice_name;
	}
	
	public Date getInvoice_date() {
		return invoice_date;
	}
	public void setInvoice_date(Date invoice_date) {
		this.invoice_date = invoice_date;
	}
	public String getInvoice_to() {
		return invoice_to;
	}
	public void setInvoice_to(String invoice_to) {
		this.invoice_to = invoice_to;
	}
	public String getInvoice_from() {
		return invoice_from;
	}
	public void setInvoice_from(String invoice_from) {
		this.invoice_from = invoice_from;
	}
	public String getInvoice_details() {
		return invoice_details;
	}
	public void setInvoice_details(String invoice_details) {
		this.invoice_details = invoice_details;
	}
	public String getInvoice_gst_code() {
		return invoice_gst_code;
	}
	public void setInvoice_gst_code(String invoice_gst_code) {
		this.invoice_gst_code = invoice_gst_code;
	}
	public int getPo_id() {
		return po_id;
	}
	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}
	public int getBank_id() {
		return bank_id;
	}
	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}	
}
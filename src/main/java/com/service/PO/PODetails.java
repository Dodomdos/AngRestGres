package com.service.PO;

import java.sql.Date;

public class PODetails {
	
	int po_id;
	String po_name;
    Date po_createdt;
    String po_details;
    String po_to;
    String po_from;
    int module_id;
    int user_id;
    
    public int getPo_id() {
		return po_id;
	}
	public void setPo_id(int po_id) {
		this.po_id = po_id;
	}
	public String getPo_name() {
		return po_name;
	}
	public void setPo_name(String po_name) {
		this.po_name = po_name;
	}
	public Date getPo_createdt() {
		return po_createdt;
	}
	public void setPo_createdt(Date po_createdt) {
		this.po_createdt = po_createdt;
	}
	public String getPo_details() {
		return po_details;
	}
	public void setPo_details(String po_details) {
		this.po_details = po_details;
	}
	public String getPo_to() {
		return po_to;
	}
	public void setPo_to(String po_to) {
		this.po_to = po_to;
	}
	public String getPo_from() {
		return po_from;
	}
	public void setPo_from(String po_from) {
		this.po_from = po_from;
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

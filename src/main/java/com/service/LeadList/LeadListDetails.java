package com.service.LeadList;

public class LeadListDetails {
	
	int lead_id;
	String lead_name;
    String designation ;
    String company_name ;
    String country ;
    String company_website;
    String telephone ;
    String email;
    String areaoi ;
    String remarks ;
    String next_date;
    String status;
    String cur_remarks;
    String degree;    
    int frole_id;
    int fuser_id;
    
    public LeadListDetails() {
		this.lead_id = -1;
		this.lead_name = "";
		this.designation = "";
		this.company_name = "";
		this.country = "";
		this.company_website = "";
		this.telephone = "";
		this.email = "";
		this.areaoi = "";
		this.remarks = "";
		this.next_date = "";
		this.status = "";
		this.cur_remarks = "";
		this.degree = "";
		this.frole_id = -1;
		this.fuser_id = -1;
	}
    
	public int getLead_id() {
		return lead_id;
	}
	public void setLead_id(int lead_id) {
		this.lead_id = lead_id;
	}
	
	public int getFrole_id() {
		return frole_id;
	}
	public void setFrole_id(int frole_id) {
		this.frole_id = frole_id;
	}
	
	public int getFuser_id() {
		return fuser_id;
	}
	public void setFuser_id(int fuser_id) {
		this.fuser_id = fuser_id;
	}
	public String getLead_name() {
		return lead_name;
	}
	public void setLead_name(String lead_name) {
		this.lead_name = lead_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCompany_website() {
		return company_website;
	}
	public void setCompany_website(String company_website) {
		this.company_website = company_website;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAreaoi() {
		return areaoi;
	}
	public void setAreaoi(String areaoi) {
		this.areaoi = areaoi;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getNext_date() {
		return next_date;
	}

	public void setNext_date(String next_date) {
		this.next_date = next_date;
	}
	public String getStatus() {
		return status;
	}	
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCur_remarks() {
		return cur_remarks;
	}
	public void setCur_remarks(String cur_remarks) {
		this.cur_remarks = cur_remarks;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
}

package com.service.Accounts;

public class AccountsDetails {
	
	int account_id;
	String account_name;
    String legaladdress;
    String postaladdress;
    String servicetaxregno;
    String corporateidentitynumber;
    String gst;
    int fbank_id;    
	int fmodule_id;
    int fuser_id;
    
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getLegaladdress() {
		return legaladdress;
	}
	public void setLegaladdress(String legaladdress) {
		this.legaladdress = legaladdress;
	}
	public String getPostaladdress() {
		return postaladdress;
	}
	public void setPostaladdress(String postaladdress) {
		this.postaladdress = postaladdress;
	}
	public String getServicetaxregno() {
		return servicetaxregno;
	}
	public void setServicetaxregno(String servicetaxregno) {
		this.servicetaxregno = servicetaxregno;
	}
	public String getCorporateidentitynumber() {
		return corporateidentitynumber;
	}
	public void setCorporateidentitynumber(String corporateidentitynumber) {
		this.corporateidentitynumber = corporateidentitynumber;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public int getFbank_id() {
		return fbank_id;
	}
	public void setFbank_id(int fbank_id) {
		this.fbank_id = fbank_id;
	}
	public int getFmodule_id() {
		return fmodule_id;
	}
	public void setFmodule_id(int fmodule_id) {
		this.fmodule_id = fmodule_id;
	}
	public int getFuser_id() {
		return fuser_id;
	}
	public void setFuser_id(int fuser_id) {
		this.fuser_id = fuser_id;
	} 
    
}

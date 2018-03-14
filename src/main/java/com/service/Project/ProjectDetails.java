package com.service.Project;

import java.sql.Date;

public class ProjectDetails {
	int project_id;
	String project_name;
    Date start_date;
    Date end_date;
    int faccount_id;
	int fmodule_id;
    int fuser_id;
    
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getFaccount_id() {
		return faccount_id;
	}
	public void setFaccount_id(int faccount_id) {
		this.faccount_id = faccount_id;
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

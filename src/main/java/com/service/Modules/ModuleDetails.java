package com.service.Modules;

public class ModuleDetails {
	int moduleId;
	String moduleName;
	String moduleNamenew;
	String moduleDescription;
	
	public ModuleDetails() {
		moduleId = -1;
		moduleNamenew="";
		moduleName ="";
		moduleDescription = "";
	}
	
	public void clear() {
		moduleId = -1;
		moduleNamenew="";
		moduleName ="";
		moduleDescription = "";
	}
		
	public String getModuleNamenew() {
		return moduleNamenew;
	}
	public void setModuleNamenew(String moduleNamenew) {
		this.moduleNamenew = moduleNamenew;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleDescription() {
		return moduleDescription;
	}
	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}	
}
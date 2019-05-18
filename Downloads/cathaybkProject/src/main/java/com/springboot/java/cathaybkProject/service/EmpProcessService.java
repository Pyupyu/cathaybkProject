package com.springboot.java.cathaybkProject.service;


import com.springboot.java.cathaybkProject.model.EmpDept;
import com.springboot.java.cathaybkProject.model.EmpPersonalData;

public interface EmpProcessService{
	public String deptAdd(EmpDept dept);
	
	public String deptUpdate(EmpDept dept);
	
	public String deptDelete(EmpDept dept);
	
	public String empAdd(EmpPersonalData empData);
	
	public String empUpdate(EmpPersonalData empData);
	
	public String empDelete(EmpPersonalData empData);
	
	public String empQuery(EmpPersonalData empData);
}

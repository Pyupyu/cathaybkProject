package com.springboot.java.cathaybkProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.springboot.java.cathaybkProject.model.EmpDept;
import com.springboot.java.cathaybkProject.model.EmpPersonalData;
import com.springboot.java.cathaybkProject.service.EmpProcessService;


@RestController
public class ProjectController {
	@Autowired
	private EmpProcessService empProcess;

	//新增部門資料
	@RequestMapping(value="/addDept" ,method=RequestMethod.POST)
	public String addDept(@RequestBody EmpDept dept) {
		String result="";
		try {
			result = empProcess.deptAdd(dept);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//修改部門資料
	@RequestMapping(value="/updateDept" ,method=RequestMethod.POST)
	public String updateDept(@RequestBody EmpDept dept) {
		String result="";
		try {
			result = empProcess.deptUpdate(dept);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//刪除部門資料
	@RequestMapping(value="/deleteDept" ,method=RequestMethod.POST)
	public String deleteDept(@RequestBody EmpDept dept) {
		String result="";
		try {
			result = empProcess.deptDelete(dept);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//新增員工資料
	@RequestMapping(value="/addEmp" ,method=RequestMethod.POST)
	public String addEmp(@RequestBody EmpPersonalData empData) {
		String result="";
		try {
			result = empProcess.empAdd(empData);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//修改員工資料
	@RequestMapping(value="/updateEmp" ,method=RequestMethod.POST)
	public String updateEmp(@RequestBody EmpPersonalData empData) {
		String result="";
		try {
			result = empProcess.empUpdate(empData);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//刪除員工資料
	@RequestMapping(value="/deleteEmp" ,method=RequestMethod.POST)
	public String deleteEmp(@RequestBody EmpPersonalData empData) {
		String result="";
		try {
			result = empProcess.empDelete(empData);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//查詢員工資料
	@RequestMapping(value="/queryEmp" ,method=RequestMethod.POST)
	public String queryEmp(@RequestBody EmpPersonalData empData) {
		String result="";
		try {
			result = empProcess.empQuery(empData);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}

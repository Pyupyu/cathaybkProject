package com.springboot.java.cathaybkProject.serviceImpl;

import com.springboot.java.cathaybkProject.model.EmpDept;
import com.springboot.java.cathaybkProject.model.EmpPersonalData;
import com.springboot.java.cathaybkProject.model.EmpPersonalDataHistory;
import com.springboot.java.cathaybkProject.model.ReturnResult;
import com.springboot.java.cathaybkProject.service.EmpProcessService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.java.cathaybkProject.Dao.EmpRepository;
import com.springboot.java.cathaybkProject.Dao.EmpRepositoryDAO;
import com.springboot.java.cathaybkProject.Dao.EmpRepositoryHistory;


@Service
public class EmpProcessServiceImpl implements EmpProcessService{
	@Autowired
	private EmpRepositoryDAO empPersonal;
	@Autowired
	private EmpRepository empDept;
	@Autowired
	private EmpRepositoryHistory empPersonalH;
	@Autowired
	ObjectMapper mapper;
	private static final int PAGESIZE = 10;
	
	//新增部門
	public String deptAdd(EmpDept dept) {
		String result="";
		try {
			empDept.save(dept);
			
			ReturnResult resultMessage = new ReturnResult();
			resultMessage.setStatus("Success");
			resultMessage.setMessage("Insert Success");
			result = mapper.writeValueAsString(resultMessage);
		}catch(Exception e) {
			e.getMessage();
		}
		return result;
	}
	
	//更新部門
	public String deptUpdate(EmpDept dept) {
		String result="";
		try {
			empDept.save(dept);
			ReturnResult resultMessage = new ReturnResult();
			resultMessage.setStatus("Success");
			resultMessage.setMessage("Update Success");
			result = mapper.writeValueAsString(resultMessage);
		}catch(Exception e) {
			e.getMessage();
		}
		return result;
	}
	
	//刪除部門
	public String deptDelete(EmpDept dept) {
		String result="";
		try {
			empDept.delete(dept);
			ReturnResult resultMessage = new ReturnResult();
			resultMessage.setStatus("Success");
			resultMessage.setMessage("Delete Success");
			result = mapper.writeValueAsString(resultMessage);
		}catch(Exception e) {
			e.getMessage();
		}
		return result;
	}
	
	//新增員工
	public String empAdd(EmpPersonalData emptData) {
		EmpPersonalDataHistory empH = new EmpPersonalDataHistory();
		ReturnResult resultMessage = new ReturnResult();
		String result="";
		try {
			boolean tempValue = empDept.existsById(emptData.getEmpDeptId());
			if(tempValue){
				emptData.setCreateTime(new Date());
				emptData.setUpdateTime(new Date());
				empPersonal.save(emptData);
				
				//異動紀錄
				empH.setStatus("Success");
				empH.setType("Insert");
				empH.setName(emptData.getName());
				empH.setEmpNumber(emptData.getEmpNumber());
				empH.setEmpDeptId(emptData.getEmpDeptId());
				empH.setGender(emptData.getGender());
				empH.setPhoneNumber(emptData.getPhoneNumber());
				empH.setAddress(emptData.getAddress());
				empH.setAge(emptData.getAge());
				empH.setCreateTime(new Date());
				empH.setUpdateTime(new Date());
				empPersonalH.save(empH);
				
				resultMessage.setStatus("Success");
				resultMessage.setMessage("Insert Success");
				result = mapper.writeValueAsString(resultMessage);
				
			}else{
				//異動紀錄
				empH.setStatus("Fail");
				empH.setType("Insert");
				empH.setErrorMessage("EmpDept is not exists");
				empH.setName(emptData.getName());
				empH.setEmpNumber(emptData.getEmpNumber());
				empH.setEmpDeptId(emptData.getEmpDeptId());
				empH.setGender(emptData.getGender());
				empH.setPhoneNumber(emptData.getPhoneNumber());
				empH.setAddress(emptData.getAddress());
				empH.setAge(emptData.getAge());
				empH.setCreateTime(new Date());
				empH.setUpdateTime(new Date());
				empPersonalH.save(empH);
				
				resultMessage.setStatus("Fail");
				resultMessage.setMessage("Dept Id is not exist");
				result = mapper.writeValueAsString(resultMessage);
			}
		}catch(Exception e) {
			empH.setStatus("Error");
			empH.setType("Insert");
			empH.setErrorMessage(e.getMessage());
			empPersonalH.save(empH);
		}
		return result;
	}
	
	//更新員工
	public String empUpdate(EmpPersonalData emptData) {
		EmpPersonalDataHistory empH = new EmpPersonalDataHistory();
		ReturnResult resultMessage = new ReturnResult();
		String result="";
		try {
			emptData.setUpdateTime(new Date());
			empPersonal.save(emptData);
			
			//異動紀錄
			empH.setStatus("Success");
			empH.setType("Update");
			empH.setName(emptData.getName());
			empH.setEmpNumber(emptData.getEmpNumber());
			empH.setEmpDeptId(emptData.getEmpDeptId());
			empH.setGender(emptData.getGender());
			empH.setPhoneNumber(emptData.getPhoneNumber());
			empH.setAddress(emptData.getAddress());
			empH.setAge(emptData.getAge());
			empH.setCreateTime(new Date());
			empH.setUpdateTime(new Date());
			empPersonalH.save(empH);
			
			resultMessage.setStatus("Success");
			resultMessage.setMessage("Update Success");
			result = mapper.writeValueAsString(resultMessage);
			
		}catch(Exception e) {
			empH.setStatus("Error");
			empH.setType("Update");
			empH.setErrorMessage(e.getMessage());
			empPersonalH.save(empH);
		}
		return result;
	}
	
	//刪除員工
	public String empDelete(EmpPersonalData emptData) {
		EmpPersonalDataHistory empH = new EmpPersonalDataHistory();
		ReturnResult resultMessage = new ReturnResult();
		String result="";
		try {
			empPersonal.delete(emptData);
			
			//異動紀錄
			empH.setStatus("Success");
			empH.setType("Delete");
			empH.setName(emptData.getName());
			empH.setEmpNumber(emptData.getEmpNumber());
			empH.setEmpDeptId(emptData.getEmpDeptId());
			empH.setGender(emptData.getGender());
			empH.setPhoneNumber(emptData.getPhoneNumber());
			empH.setAddress(emptData.getAddress());
			empH.setAge(emptData.getAge());
			empH.setCreateTime(new Date());
			empH.setUpdateTime(new Date());
			empPersonalH.save(empH);
			
			resultMessage.setStatus("Success");
			resultMessage.setMessage("Update Success");
			result = mapper.writeValueAsString(resultMessage);
			
		}catch(Exception e) {
			empH.setStatus("Error");
			empH.setType("Delete");
			empH.setErrorMessage(e.getMessage());
			empPersonalH.save(empH);
		}
		return result;
	}
	
	//員工查詢
	public String empQuery(EmpPersonalData empData) {
		EmpPersonalData  empfinalData = new  EmpPersonalData();
		String result = "";
		String name = "";
		String empNumber = "";
		String empDeptId = "";
		String age = "";
		
		try {
			if(!StringUtils.isEmpty(empData.getName())) {
				name = empData.getName();
			}else {
				name =null;
			}
			if(!StringUtils.isEmpty(empData.getEmpNumber())) {
				empNumber = empData.getEmpNumber();
			}else {
				empNumber =null;
			}
			if(!StringUtils.isEmpty(empData.getEmpDeptId())) {
				empDeptId = empData.getEmpDeptId();
			}else {
				empDeptId =null;
			}
			if(!StringUtils.isEmpty(empData.getAge())) {
				age = empData.getAge();
			}else {
				age = null;
			}
			
			//查詢
			List<EmpPersonalData> tempListValue = empPersonal.queryEmpData(name,empNumber,empDeptId,age);
			
			if(null!=tempListValue && tempListValue.size()>0) {
				StringBuffer sb = new StringBuffer();
				for(int i =0;i<tempListValue.size();i++) {
					empfinalData = tempListValue.get(i);
					result = mapper.writeValueAsString(empfinalData);
					sb.append(result+",");
				}
				result= sb.toString();
			}
			//分頁
			int currentPage = this.setPageItemsAndGetCurrentPage("0",tempListValue.size());
			
		}catch(Exception e) {
			e.getMessage();
		}
		return result;
	}
	
	private int setPageItemsAndGetCurrentPage(String nowPage ,int totalRecordSize){
		
		String size = String.valueOf(PAGESIZE);
		String recordSize= String.valueOf(totalRecordSize);		
		
		int totalPages = 1;
		int currentPage = 1;

		if (StringUtils.isEmpty(nowPage)) {
			currentPage = Integer.parseInt(nowPage);
			totalPages = Integer.parseInt(recordSize);
			if(currentPage > totalPages){
				currentPage = totalPages;
			}
		}else{
			currentPage = 1;
		}		
		return currentPage;
	}
}

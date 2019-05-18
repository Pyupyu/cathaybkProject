package com.springboot.java.cathaybkProject.mockitodemo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.springboot.java.cathaybkProject.Dao.EmpRepository;
import com.springboot.java.cathaybkProject.Dao.EmpRepositoryDAO;
import com.springboot.java.cathaybkProject.Dao.EmpRepositoryHistory;
import com.springboot.java.cathaybkProject.model.EmpDept;
import com.springboot.java.cathaybkProject.model.EmpPersonalData;
import com.springboot.java.cathaybkProject.model.EmpPersonalDataHistory;
import com.springboot.java.cathaybkProject.serviceImpl.EmpProcessServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmpProcessServiceTest {
	
	@Mock
	EmpRepository empDeptDao; 
	@Mock
	EmpRepositoryDAO empDataDao;
	@Mock
	EmpRepositoryHistory empHistoryDao;
	
  
	@InjectMocks
	EmpProcessServiceImpl empServiceImpl = new EmpProcessServiceImpl();
	
	@Test
	public void addTest() {
		EmpDept dept = new EmpDept();
		EmpPersonalData empData = new EmpPersonalData();
		EmpPersonalDataHistory empDataHistory = new EmpPersonalDataHistory();
		//新增部門
		dept.setEmpDeptId("IH");
		dept.setEmpDeptName("業務研發部");
		when(empServiceImpl.deptAdd(dept)).thenReturn("");
		empServiceImpl.deptAdd(dept);
		verify(empDeptDao, times(1)).save(dept);
		
		//新增員工
		empData.setEmpDeptId("IH");
		empData.setEmpNumber("7906");
		empData.setName("Ricky");
		dept.setEmpDeptId(empData.getEmpDeptId());
		verify(empDeptDao.existsById(dept.getEmpDeptId()));
		when(empServiceImpl.empAdd(empData)).thenReturn("");
		empServiceImpl.empAdd(empData);
		verify(empDataDao, times(1)).save(empData);
		empDataHistory.setEmpDeptId(empData.getEmpDeptId());
		empDataHistory.setEmpNumber(empData.getEmpNumber());
		empDataHistory.setName(empData.getName());
		verify(empHistoryDao, times(1)).save(empDataHistory);
	}
	
	@Test
	public void updateTest(){
		EmpDept dept = new EmpDept();
		EmpPersonalData empData = new EmpPersonalData();
		EmpPersonalDataHistory empDataHistory = new EmpPersonalDataHistory();
		//更新部門
		dept.setEmpDeptId("IA");
		when(empServiceImpl.deptUpdate(dept)).thenReturn("");
		empServiceImpl.deptUpdate(dept);
		verify(empDeptDao, times(1)).save(dept);
		
		//更新員工
		empData.setEmpDeptId("IA");
		empData.setEmpNumber("7907");
		empData.setName("Ricky");
		dept.setEmpDeptId(empData.getEmpDeptId());
		verify(empDeptDao.existsById(dept.getEmpDeptId()));
		when(empServiceImpl.empUpdate(empData)).thenReturn("");
		empServiceImpl.empUpdate(empData);
		verify(empDataDao, times(1)).save(empData);
		empDataHistory.setEmpDeptId(empData.getEmpDeptId());
		empDataHistory.setEmpNumber(empData.getEmpNumber());
		empDataHistory.setName(empData.getName());
		verify(empHistoryDao, times(1)).save(empDataHistory);
	}
	
	@Test
	public void deleteTest(){
		EmpDept dept = new EmpDept();
		EmpPersonalData empData = new EmpPersonalData();
		EmpPersonalDataHistory empDataHistory = new EmpPersonalDataHistory();
		
		//刪除部門
		dept.setEmpDeptId("IA");
		when(empServiceImpl.deptDelete(dept)).thenReturn("");
		empServiceImpl.deptDelete(dept);
		verify(empDeptDao, times(1)).delete(dept);
		
		//刪除員工
		empData.setEmpDeptId("IA");
		empData.setName("Ricky");
		when(empServiceImpl.empDelete(empData)).thenReturn("");
		empServiceImpl.empDelete(empData);
		verify(empDataDao, times(1)).delete(empData);
		empDataHistory.setEmpDeptId(empData.getEmpDeptId());
		empDataHistory.setEmpNumber(empData.getEmpNumber());
		empDataHistory.setName(empData.getName());
		verify(empHistoryDao, times(1)).save(empDataHistory);
	}
}

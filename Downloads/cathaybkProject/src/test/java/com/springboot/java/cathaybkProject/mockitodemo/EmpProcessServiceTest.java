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
import com.springboot.java.cathaybkProject.model.EmpDept;
import com.springboot.java.cathaybkProject.serviceImpl.EmpProcessServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmpProcessServiceTest {
	
	@Mock
	EmpRepository empDeptDao; 
  
	@InjectMocks
	EmpProcessServiceImpl empServiceImpl = new EmpProcessServiceImpl();
	
	@Test
	public void simpleTest() {
		EmpDept dept = new EmpDept();
		//新增部門
		dept.setEmpDeptId("IH");
		dept.setEmpDeptName("業務研發部");
		when(empServiceImpl.deptAdd(dept)).thenReturn("");
		empServiceImpl.deptAdd(dept);
		verify(empDeptDao, times(1)).save(dept);
	}
}

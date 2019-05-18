package com.springboot.java.cathaybkProject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.java.cathaybkProject.model.EmpDept;

public interface EmpRepository extends JpaRepository<EmpDept, String> {
	
	boolean existsById(String empDeptId);
	
}

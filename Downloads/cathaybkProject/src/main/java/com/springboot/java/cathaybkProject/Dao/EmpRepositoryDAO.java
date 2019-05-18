package com.springboot.java.cathaybkProject.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.java.cathaybkProject.model.EmpPersonalData;

public interface EmpRepositoryDAO extends JpaRepository<EmpPersonalData, String>{

	@Query(value = "select p.* from EMP_PERSONAL_DATA p where 1=1  "
			+ "AND (:name is null or p.NAME =:name)"
			+ "AND (:empNumber is null or p.EMP_NUMBER =:empNumber)"
			+ "AND (:empDeptId is null or p.EMP_DEPT_ID =:empDeptId)"
			+ "AND (:age is null or p.AGE =:age)"
//			,countQuery = "SELECT count(*) FROM EMP_PERSONAL_DATA"
			,nativeQuery = true)
	
	List<EmpPersonalData> queryEmpData(
			@Param("name")String name,
			@Param("empNumber")String empNumber,
			@Param("empDeptId")String empDeptId,
			@Param("age")String age
			);
}

package com.springboot.java.cathaybkProject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "EMP_DEPT")
public class EmpDept implements Serializable {
    /** *  */ private static final long serialVersionUID = 1L;
    @Id
    @Column
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String empDeptId;
    @Column
    private String empDeptName;
    
	public String getEmpDeptId() {
		return empDeptId;
	}
	public void setEmpDeptId(String empDeptId) {
		this.empDeptId = empDeptId;
	}
	public String getEmpDeptName() {
		return empDeptName;
	}
	public void setEmpDeptName(String empDeptName) {
		this.empDeptName = empDeptName;
	}
}

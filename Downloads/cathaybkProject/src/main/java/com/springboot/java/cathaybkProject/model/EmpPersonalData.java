package com.springboot.java.cathaybkProject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor; 

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "EMP_PERSONAL_DATA")
public class EmpPersonalData implements Serializable{
	/** *  */ private static final long serialVersionUID = 1L;

    @Column
    private String name;
    @Id
    @Column
    private String empNumber;  
    @Column
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String empDeptId;
    @Column
    private String gender;
    @Column
    private String phoneNumber;
    @Column
    private String address;
    @Column
    private String age;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpDeptId() {
		return empDeptId;
	}
	public void setEmpDeptId(String empDeptId) {
		this.empDeptId = empDeptId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
}



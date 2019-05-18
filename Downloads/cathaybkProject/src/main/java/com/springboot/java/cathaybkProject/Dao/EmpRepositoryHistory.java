package com.springboot.java.cathaybkProject.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.java.cathaybkProject.model.EmpPersonalDataHistory;

public interface EmpRepositoryHistory extends JpaRepository<EmpPersonalDataHistory, String> {

}

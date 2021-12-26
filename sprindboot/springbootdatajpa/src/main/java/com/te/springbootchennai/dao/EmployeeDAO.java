package com.te.springbootchennai.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springbootchennai.bean.EmployeeInfo;

@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeInfo, Integer>{

//	@Query("from EmployeeInfo where id=:id and name=:name")
//	public EmployeeInfo getData(Integer id , String name);
	
	public EmployeeInfo findByIdAndName(Integer id , String name);
}

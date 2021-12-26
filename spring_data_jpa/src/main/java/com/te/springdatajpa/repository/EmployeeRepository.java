package com.te.springdatajpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.te.springdatajpa.beans.EmployeeInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer> {

	@Query("from EmployeeInfoBean where empId= :empId  and password= :password")
	public EmployeeInfoBean authenticate( int empId,  String password);
	
}
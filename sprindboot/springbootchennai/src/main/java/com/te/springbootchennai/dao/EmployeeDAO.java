package com.te.springbootchennai.dao;

import java.util.List;

import com.te.springbootchennai.beans.EmployeeInfo;

public interface EmployeeDAO {

	public EmployeeInfo getEmployee(Integer id);
	
	public boolean delete(Integer id);
	
	public boolean register(EmployeeInfo info);
	
	public boolean update(EmployeeInfo newData);
	
	public List<EmployeeInfo> getAllData();
}

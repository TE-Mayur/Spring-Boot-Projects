package com.te.springbootchennai.service;

import java.util.List;

import com.te.springbootchennai.bean.EmployeeInfo;

public interface EmployeeService {
	public EmployeeInfo getEmployee(Integer id);

	public boolean delete(Integer id);

	public EmployeeInfo register(EmployeeInfo info);

	public EmployeeInfo update(EmployeeInfo newData);

	public List<EmployeeInfo> getAllData();
	
	public EmployeeInfo getData(Integer id , String name);

}

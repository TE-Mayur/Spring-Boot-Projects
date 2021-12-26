package com.te.springbootchennai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbootchennai.beans.EmployeeInfo;
import com.te.springbootchennai.customeexp.EmployeeException;
import com.te.springbootchennai.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfo getEmployee(Integer id) {
		if (id <= 0) {
			throw new EmployeeException("Data Not found");
		}

		EmployeeInfo employeeInfo = dao.getEmployee(id);
		if (employeeInfo != null) {
			employeeInfo.setPwd(null);
			return employeeInfo;
		} else {
			throw new EmployeeException("Data Not found");
		}
	}

	@Override
	public EmployeeInfo register(EmployeeInfo info) {

		if (dao.register(info)) {
			EmployeeInfo info1 = dao.getEmployee(info.getId());
			info1.setPwd(null);
			return info1;
		}
		throw new EmployeeException("Data Already Exist");
	}

	@Override
	public boolean update(EmployeeInfo newData) {

		return dao.update(newData);
	}

	@Override
	public boolean delete(Integer id) {
		if (id <= 0) {
			return false;
		}
		return dao.delete(id);
	}
	
	
	@Override
	public List<EmployeeInfo> getAllData(){
		return dao.getAllData();
	}
}

package com.te.springbootchennai.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springbootchennai.bean.EmployeeInfo;
import com.te.springbootchennai.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeInfo getEmployee(Integer id) {
		Optional<EmployeeInfo> optional = dao.findById(id);
		return optional.get();

	}

	@Override
	@Transactional
	public boolean delete(Integer id) {

		dao.deleteById(id);
		return true;
	}

	@Override
	@Transactional
	public EmployeeInfo register(EmployeeInfo info) {
		return dao.save(info);
	}

	@Override
	public EmployeeInfo update(EmployeeInfo newData) {
		return dao.save(newData);
	}

	@Override
	public List<EmployeeInfo> getAllData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeInfo getData(Integer id, String name) {
		
//		return dao.getData(id, name);
		return dao.findByIdAndName(id, name);
	}

}

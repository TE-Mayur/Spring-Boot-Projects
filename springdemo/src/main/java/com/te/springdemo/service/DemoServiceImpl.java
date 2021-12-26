package com.te.springdemo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springdemo.beans.DemoBean;
import com.te.springdemo.dao.DemoDAO;
import com.te.springdemo.exception.InsertionFailed;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoDAO dao;

	@Override
	@Transactional
	public DemoBean storeData(DemoBean data) {
		DemoBean obj = dao.save(data);
		if (obj != null) {
			return obj;
		} else {
			throw new InsertionFailed("Data is not Insert");
		}
	}

}

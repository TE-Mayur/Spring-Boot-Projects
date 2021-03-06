package com.te.springdemo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springdemo.beans.UserBean;
import com.te.springdemo.dao.UserDao;
import com.te.springdemo.exception.CustomException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public Optional<UserBean> getUser(Integer id) {
		if (id <= 0) {
			throw new CustomException("Please enter the proper id");
		} else {
			return dao.findById(id);
		}
	}

	@Override
	@Transactional
	public UserBean register(UserBean bean) {
		UserBean obj = dao.save(bean);
		if (obj != null) {
			return obj;
		} else {
			throw new CustomException("please enter the details");
		}

	}

	@Override
	public boolean deleteData(Integer id) {
		if (id <= 0) {
			return false;
		}
		dao.deleteById(id);
		return true;
	}
	
	
	@Override
	@Transactional
	public UserBean updateData(UserBean info) {
		UserBean obj = dao.save(info);
		if (obj != null) {
			return obj;
		} else {
			throw new CustomException("please enter the details");
		}
	}
}
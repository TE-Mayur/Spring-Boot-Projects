package com.te.springdemo.service;

import java.util.Optional;

import com.te.springdemo.beans.UserBean;

public interface UserService {

	public Optional<UserBean> getUser(Integer id);
	
	public UserBean register(UserBean bean);
	
	public boolean deleteData(Integer id);
	
	public UserBean updateData(UserBean bean);
}

package com.te.springdemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.springdemo.beans.UserBean;

@Repository
public interface UserDao extends CrudRepository<UserBean, Integer>{
	
}

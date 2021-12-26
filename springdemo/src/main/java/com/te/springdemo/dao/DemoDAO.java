package com.te.springdemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.springdemo.beans.DemoBean;

@Repository
public interface DemoDAO extends CrudRepository<DemoBean, Integer> {

}

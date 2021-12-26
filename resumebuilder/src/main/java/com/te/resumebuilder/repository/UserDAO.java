package com.te.resumebuilder.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.beans.UserInfo;

@Repository
public interface UserDAO extends CrudRepository<UserInfo, String> {

	public UserInfo findByEmailAndPassword(String email, String password);

	public Optional<UserInfo> findBySerialNo(Integer serialNo);

}

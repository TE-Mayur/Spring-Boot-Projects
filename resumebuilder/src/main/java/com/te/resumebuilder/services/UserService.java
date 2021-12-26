package com.te.resumebuilder.services;

import com.te.resumebuilder.beans.UserInfo;

public interface UserService {

	public UserInfo getUser(Integer serialNo);

	public UserInfo signup(UserInfo user);

	public UserInfo login(String email, String password);

}

package com.neosoft.SpringBootApplication.service;
import com.neosoft.SpringBootApplication.entity.User;
import com.neosoft.SpringBootApplication.entity.UserMaster;

import java.util.List;
import java.util.Optional;

public interface IUserService {
	
	UserMaster saveUserData(UserMaster userMaster);

	Optional<User> findByUsername(String username);

	public List<UserMaster> findAllUserData();

	public UserMaster findUserById(int userMasterId);

	public List<UserMaster> searchUserMaster(String query);

	public UserMaster findUserByDepartment(String department);

}

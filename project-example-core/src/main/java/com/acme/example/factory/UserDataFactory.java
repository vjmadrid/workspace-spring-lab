package com.acme.example.factory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.example.common.constant.UserConstant;
import com.acme.example.entity.User;

public final class UserDataFactory {

	public static User createSampleUserWithId(long id,String name,String password) {
		final User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		return user;
	}
	
	public static User createSampleUserDefault() {
		return createSampleUserWithId(UserConstant.TEST_ID,UserConstant.TEST_USERNAME, UserConstant.TEST_PASSWORD);
	}
	
	public static Map<Long,User> createSampleUserMap() {
		final Map<Long,User> usersMap = new HashMap<Long, User>(); 
		usersMap.put(UserConstant.TEST_USER_1_ID, UserDataFactory.createSampleUserWithId(UserConstant.TEST_USER_1_ID, UserConstant.TEST_USER_1_USERNAME , UserConstant.TEST_USER_1_PASSWORD));
		usersMap.put(UserConstant.TEST_USER_2_ID, UserDataFactory.createSampleUserWithId(UserConstant.TEST_USER_2_ID, UserConstant.TEST_USER_2_USERNAME , UserConstant.TEST_USER_2_PASSWORD));
		return usersMap;
	}
	
	public static List<User> createSampleUserList() {
		final List<User> list = new ArrayList<User>();
		list.add(UserDataFactory.createSampleUserWithId(UserConstant.TEST_USER_1_ID, UserConstant.TEST_USER_1_USERNAME , UserConstant.TEST_USER_1_PASSWORD));
		list.add(UserDataFactory.createSampleUserWithId(UserConstant.TEST_USER_2_ID, UserConstant.TEST_USER_2_USERNAME , UserConstant.TEST_USER_2_PASSWORD));
		return list;
	}
	
}

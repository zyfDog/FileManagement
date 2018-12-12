package service;

import java.util.List;

import pojo.User;

/**
 * @author: 詹亦凡
 * @date: 2018年12月7日 下午4:50:59
 */
public interface UserService {
	
	public User get(String account);
	
	public List<User> getList();
	
}

package service;

import java.util.List;
import java.util.Map;

import pojo.User;

/**
 * @author: 詹亦凡
 * @date: 2018年12月7日 下午4:50:59
 */
public interface UserService {
	
	//通过账号获取用户
	public User get(String account);
	
	//获取所有用户
	public List<User> getList();
	
	//获取用部分分组好的用户List用于Select框
	public Map<String, List<User>> getMap();
	
}

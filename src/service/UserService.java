package service;

import java.util.List;
import java.util.Map;

import pojo.User;

/**
 * @author: 詹亦凡
 * @date: 2018年12月7日 下午4:50:59
 */
public interface UserService {
	
	public User get(String account);
	
	public List<User> getList();
	
	public Map<String, List<User>> getMap();
	
}

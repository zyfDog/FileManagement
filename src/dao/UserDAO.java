package dao;

import java.util.List;

import pojo.User;

/**
 * @author: 詹亦凡
 * @date: 2018年12月7日 下午4:46:09
 */
public interface UserDAO {
	
	public User get(String account);
	
	public List<User> getList();

}

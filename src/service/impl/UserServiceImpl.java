package service.impl;

import java.util.List;

import dao.UserDAO;
import pojo.User;
import service.UserService;

/**
 * @author: 詹亦凡
 * @date: 2018年12月7日 下午4:51:47
 */
public class UserServiceImpl implements UserService{
	
	UserDAO userDAO;
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public User get(String account) {
		return userDAO.get(account);
	}
	
	public List<User> getList() {
		return userDAO.getList();
	}

}

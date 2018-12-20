package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.UserDAO;
import pojo.User;

/**
 * @author: 詹亦凡
 * @date: 2018年12月7日 下午4:47:58
 */
public class UserDAOImpl extends HibernateTemplate implements UserDAO{

	public User get(String account) {
		List<User> users = find("from User where account='" + account +"'");
		if(users == null || users.size() == 0)
			return null;
		else 
			return users.get(0);
	}

	public List<User> getList() {
		return find("from User");
	}
}

package dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.UserDAO;
import pojo.User;

/**
 * @author: 詹亦凡
 * @date: 2018年12月7日 下午4:47:58
 */
public class UserDAOImpl extends HibernateTemplate implements UserDAO{

	public User get(String account) {
		return (User) find("from User where account='" + account +"'").get(0);
	}

}

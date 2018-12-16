package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.HistoryDAO;
import pojo.History;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午9:12:10
 */
public class HistoryDAOImpl extends HibernateTemplate implements HistoryDAO {
	
	public List<History> list() {
		return find("from History");
	}
	
	public void add(History history) {
		save(history);
	}
}

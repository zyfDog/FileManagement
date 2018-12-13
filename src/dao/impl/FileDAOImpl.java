package dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.FileDAO;
import pojo.File;
import pojo.Folder;
import pojo.User;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午5:16:12
 */
public class FileDAOImpl extends HibernateTemplate implements FileDAO {

	public List<File> list(Folder folder) {
		return find("from File where superiorFolder=" + folder.getId());
	}

	public void add(File file) {
		save(file);
	}

	public void delete(File file) {
		super.delete(file);
	}

	public List<File> downloadList(List<Integer> ids) {
		StringBuilder hql = new StringBuilder("from File where id in(");
		for(Integer id : ids) {
			hql.append(id + ",");
		}
		hql.deleteCharAt(hql.length()-1);
		hql.append(")");
		return find(hql.toString());
	}
	
	public File get(Integer id) {
		return get(File.class,id);
	}
	
	public List<File> query(String name, String theme, String keyword, User user, Date beforeQueryDate,
			Date afterQueryDate) {
		StringBuilder hql = new StringBuilder("from File where 1=1 ");
		if(name != null && !name.equals("")) 
			hql.append("and name like '%" + name + "%'");
		if(theme != null && !theme.equals(""))
			hql.append("and theme like '%" + theme + "%'");
		if(keyword != null && !keyword.equals(""))
			hql.append("and keyword like '%" + keyword + "%'");
		if(beforeQueryDate != null && afterQueryDate != null) 
			hql.append("and createTime between '" + beforeQueryDate + "' and '" + afterQueryDate + "'");
		return find(hql.toString());
	}
}

package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.FolderDAO;
import pojo.Folder;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午9:11:47
 */
public class FolderDAOImpl extends HibernateTemplate implements FolderDAO {

	public List<Folder> listAll() {
		return find("from Folder");
	}
	
	public List<Folder> list() {
		return find("from Folder where superiorFolder is null");
	}
	
	public void add(Folder folder) {
		save(folder);
	}
	
	public Folder get(Integer id) {
		return get(Folder.class, id);
	}
}

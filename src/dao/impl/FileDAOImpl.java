package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.FileDAO;
import pojo.File;
import pojo.Folder;

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
}

package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.FileDAO;
import pojo.File;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午5:16:12
 */
public class FileDAOImpl extends HibernateTemplate implements FileDAO {

	public List<File> list() {
		return find("from File");
	}
}

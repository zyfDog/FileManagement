package dao;

import java.util.List;

import pojo.File;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午5:14:31
 */
public interface FileDAO {
	
	public List<File> list();

	public void add(File file);
	
	public void delete(File file);
}

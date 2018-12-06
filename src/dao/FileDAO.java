package dao;

import java.util.List;

import pojo.File;
import pojo.Folder;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午5:14:31
 */
public interface FileDAO {
	
	public List<File> list(Folder folder);

	public void add(File file);
	
	public void delete(File file);
	
	public List<File> downloadList(List<Integer> ids);
	
	public File get(Integer id);
}

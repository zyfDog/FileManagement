package service;

import java.util.Date;
import java.util.List;

import pojo.File;
import pojo.Folder;
import pojo.User;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午9:14:59
 */
public interface FileService {

	public List<File> list(Folder folder);
	
	public void add(File file);
	
	public void delete(File file);
	
	public List<File> downloadList(List<Integer> ids);
	
	public File get(Integer id);
	
	public List<File> query(String name, String theme, String keyword, User user, Date beforeQueryDate,
			Date afterQueryDate);
}

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

	//根据文件夹获取文件
	public List<File> list(Folder folder);
	
	//新增文件
	public void add(File file);
	
	//删除文件
	public void delete(File file);
	
	//通过文件idList获取文件List
	public List<File> downloadList(List<Integer> ids);
	
	//通过id获取文件
	public File get(Integer id);
	
    //查询符合条件的文件
	public List<File> query(String name, String theme, String keyword, User user, Date beforeQueryDate,
			Date afterQueryDate);
	
	//更新文件（重命名）
	public void update(File file);
}

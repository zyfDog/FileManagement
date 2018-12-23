package service;

import java.util.List;

import pojo.Folder;


/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午9:15:14
 */
public interface FolderService {

	//获取所有的文件夹
	public List<Folder> listAll();
	
	//获取顶级文件夹
	public List<Folder> list();
	
	//新增文件夹
	public void add(Folder folder);
	
	//获取当前文件夹的路径
	public String getCurrentPath(Folder folder);
	
	//获取文件夹的子文件夹
	public List<Folder> getChildren(Folder folder);
	
	//删除文件夹
	public void delete(Folder folder);
	
	//更新文件夹(重命名)
	public void update(Folder folder);
	
	//通过id获取文件夹
	public Folder get(Integer id);
}

package service;

import java.util.List;

import pojo.Folder;


/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午9:15:14
 */
public interface FolderService {

	public List<Folder> listAll();
	
	public List<Folder> list();
	
	public void add(Folder folder);
	
	public String getCurrentPath(Folder folder);
	
	public List<Folder> getChildren(Folder folder);
	
	public void delete(Folder folder);
	
	public void update(Folder folder);
	
	public Folder get(Integer id);
}

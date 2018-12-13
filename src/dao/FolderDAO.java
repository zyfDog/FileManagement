package dao;

import java.util.List;

import pojo.Folder;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午5:15:11
 */
public interface FolderDAO {
	
	public List<Folder> listAll();
	
	public List<Folder> list();
	
	public void add(Folder folder);
	
	public Folder get(Integer id);
	
	public List<Folder> getChildren(Folder folder);

}

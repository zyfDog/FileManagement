package service.impl;

import java.util.List;

import dao.FolderDAO;
import pojo.Folder;
import service.FolderService;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午9:16:29
 */
public class FolderServiceImpl implements FolderService {

	FolderDAO folderDAO;

	public FolderDAO getFolderDAO() {
		return folderDAO;
	}

	public void setFolderDAO(FolderDAO folderDAO) {
		this.folderDAO = folderDAO;
	}

	public List<Folder> listAll() {
		return folderDAO.listAll();
	}
	
	public List<Folder> list() {
		return folderDAO.list();
	}

	public void add(Folder folder) {
		folderDAO.add(folder);
	}
	
	public String getCurrentPath(Folder folder) {
		if(folder.getId() == 0) {
			return "/";
		}
		StringBuilder currentPath = new StringBuilder(""); 
		folder = folderDAO.get(folder.getId());
		Folder superiorFolder = folder;
		 
		currentPath.append("/" + superiorFolder.getName() + "/");
		while(superiorFolder.getSuperiorFolder() != null) {
			superiorFolder = folderDAO.get(superiorFolder.getSuperiorFolder().getId());
			currentPath.insert(0, "/" + superiorFolder.getName()); 
		}
		return currentPath.toString();
	}
	
	public List<Folder> getChildren(Folder folder) {
		if(folder.getId() == 0)
			return null;
		return folderDAO.getChildren(folder);
	}
}

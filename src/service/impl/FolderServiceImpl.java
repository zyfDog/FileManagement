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

	public List<Folder> list() {
		return folderDAO.list();
	}

	public void add(Folder folder) {
		folderDAO.add(folder);
	}
}

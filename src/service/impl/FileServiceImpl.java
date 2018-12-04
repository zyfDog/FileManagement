package service.impl;

import java.util.List;

import dao.FileDAO;
import pojo.File;
import pojo.Folder;
import service.FileService;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午9:16:02
 */
public class FileServiceImpl implements FileService {

	FileDAO fileDAO;

	public FileDAO getFileDAO() {
		return fileDAO;
	}

	public void setFileDAO(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}

	public List<File> list(Folder folder) {
		return fileDAO.list(folder);
	}
	
	public void add(File file) {
		fileDAO.add(file);
	}
	
	public void delete(File file) {
		fileDAO.delete(file);
	}
}

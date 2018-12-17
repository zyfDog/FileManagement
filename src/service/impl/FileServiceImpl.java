package service.impl;

import java.util.Date;
import java.util.List;

import dao.FileDAO;
import pojo.File;
import pojo.Folder;
import pojo.User;
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
	
	public List<File> downloadList(List<Integer> ids) {
		 return fileDAO.downloadList(ids);
	}
	
	public File get(Integer id) {
		return fileDAO.get(id);
	}
	
	public List<File> query(String name, String theme, String keyword, User user, Date beforeQueryDate,
			Date afterQueryDate) {
		return fileDAO.query(name, theme, keyword, user, beforeQueryDate, afterQueryDate);
	}
	
	public void update(File file) {
		fileDAO.update(file);
	}
}

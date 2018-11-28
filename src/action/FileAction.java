package action;

import java.util.List;

import pojo.File;
import service.FileService;

/**
 * @author: 詹亦凡
 * @date: 2018年11月28日 下午5:05:09
 */
public class FileAction {
	FileService fileService;
	List<File> files;
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}
	
	public String list() {
		files = fileService.list();
		return "listJsp";
	}
}

package action;

import java.util.List;

import pojo.File;
import pojo.Folder;
import service.FileService;
import service.FolderService;

/**
 * @author: 詹亦凡
 * @date: 2018年11月28日 下午5:05:09
 */
public class IndexAction {
	private FileService fileService;
	private FolderService folderService;
	private List<File> files;
	private List<Folder> folders;
	private Folder folder;

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public FolderService getFolderService() {
		return folderService;
	}

	public void setFolderService(FolderService folderService) {
		this.folderService = folderService;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<Folder> getFolders() {
		return folders;
	}

	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public String list() {
		files = fileService.list(folder);
		folders = folderService.list();
		System.out.println(folders);
		return "listJsp";
	}
}

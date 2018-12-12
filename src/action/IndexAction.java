package action;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pojo.File;
import pojo.Folder;
import pojo.User;
import service.FileService;
import service.FolderService;
import service.UserService;

/**
 * @author: 詹亦凡
 * @date: 2018年11月28日 下午5:05:09
 */
public class IndexAction {
	private FileService fileService;
	private FolderService folderService;
	private UserService userService;
	private List<File> files;
	private List<Folder> folders;
	private List<Folder> allFolders;
	private Map<String, List<User>> userMap;
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

	public List<Folder> getAllFolders() {
		return allFolders;
	}

	public void setAllFolders(List<Folder> allFolders) {
		this.allFolders = allFolders;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public Map<String, List<User>> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<String, List<User>> userMap) {
		this.userMap = userMap;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String list() {
		files = fileService.list(folder);
		folders = folderService.list();
		allFolders = folderService.listAll();
		List<User> users = userService.getList();
		System.out.println("zzz" + users);
		userMap = (Map<String, List<User>>) users.stream().collect(Collectors.groupingBy(User::getDepartment));
		System.out.println("zzz" + userMap);
		return "listJsp";
	}
}

package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import pojo.File;
import pojo.Folder;
import pojo.History;
import pojo.User;
import service.FileService;
import service.FolderService;
import service.HistoryService;
import service.UserService;

/**
 * @author: 詹亦凡
 * @date: 2018年11月28日 下午5:05:09
 */
public class IndexAction {
	private FileService fileService;
	private FolderService folderService;
	private UserService userService;
	private HistoryService historyService;
	private Folder folder;// 当前文件夹
	private List<File> files;// 获取所选文件夹中的文件
	private List<Folder> folderChildren;// 获取所选文件夹中的文件夹
	private List<Folder> folders;// 获取一级文件夹
	private List<Folder> allFolders;// 获取所有文件夹 用于选择文件或者文件夹的上级文件夹
	private List<History> histories;// 获取历史操作
	private Map<String, List<User>> userMap;// 获取以部门分组的用户Map 用于选择部门和用户
	private List<File> queryFiles = new ArrayList<>();// 查询的文件
	private String currentPath;// 获取当前路径

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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public HistoryService getHistoryService() {
		return historyService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<Folder> getFolderChildren() {
		return folderChildren;
	}

	public void setFolderChildren(List<Folder> folderChildren) {
		this.folderChildren = folderChildren;
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

	public List<History> getHistories() {
		return histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public Map<String, List<User>> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<String, List<User>> userMap) {
		this.userMap = userMap;
	}

	public List<File> getQueryFiles() {
		return queryFiles;
	}

	public void setQueryFiles(List<File> queryFiles) {
		this.queryFiles = queryFiles;
	}

	public String getCurrentPath() {
		return currentPath;
	}

	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}

	public String list() {
		//获取查询文件传来的文件List
		queryFiles = (List<File>) ActionContext.getContext().get("queryFiles");
		if (queryFiles != null && queryFiles.size() != 0) {
			Folder folder = new Folder();
			folder.setId(0);
			this.folder = folder;
		}

		files = fileService.list(folder);
		folders = folderService.list();
		allFolders = folderService.listAll();
		folderChildren = folderService.getChildren(folder);
		histories = historyService.list();
		currentPath = folderService.getCurrentPath(folder);
		userMap = userService.getMap();

		return "listJsp";
	}
}

package action;

import com.opensymphony.xwork2.ActionSupport;

import pojo.Folder;
import service.FolderService;

/**
 * @author: 詹亦凡
 * @date: 2018年12月4日 下午8:53:12
 */
public class FolderAction extends ActionSupport{
	private FolderService folderService;
	private Folder folder;

	public FolderService getFolderService() {
		return folderService;
	}

	public void setFolderService(FolderService folderService) {
		this.folderService = folderService;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}
	
	public String add() {
		if(folder.getSuperiorFolder().getId() == 0) {
			folder.setSuperiorFolder(null);
		}
		folderService.add(folder);
		return SUCCESS;
	}

}

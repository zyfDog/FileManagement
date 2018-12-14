package action;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pojo.Folder;
import pojo.User;
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
		folder.setUpdateTime(new Date());
		Map<String, Object> session = ActionContext.getContext().getSession();
		folder.setUpdateUser((User) session.get("user"));
		folderService.add(folder);
		return SUCCESS;
	}

}

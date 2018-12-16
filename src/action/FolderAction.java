package action;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pojo.Folder;
import pojo.History;
import pojo.User;
import service.FolderService;
import service.HistoryService;

/**
 * @author: 詹亦凡
 * @date: 2018年12月4日 下午8:53:12
 */
public class FolderAction extends ActionSupport {
	private FolderService folderService;
	private HistoryService historyService;
	private Folder folder;
	private String deleteFolders;

	public FolderService getFolderService() {
		return folderService;
	}

	public void setFolderService(FolderService folderService) {
		this.folderService = folderService;
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

	public String getDeleteFolders() {
		return deleteFolders;
	}

	public void setDeleteFolders(String deleteFolders) {
		this.deleteFolders = deleteFolders;
	}

	public String add() {
		if (folder.getSuperiorFolder().getId() == 0) {
			folder.setSuperiorFolder(null);
		}
		folder.setUpdateTime(new Date());
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		folder.setUpdateUser((User) session.get("user"));
		folderService.add(folder);
		
		History history = new History((User) session.get("user"), new Date(), "新增文件夹");
		historyService.add(history);
		
		return SUCCESS;
	}

	public String delete() {
		if (deleteFolders == null)
			return SUCCESS;
		String[] values = deleteFolders.split(",");
		for (String value : values) {
			Folder folder = new Folder();
			folder.setId(Integer.valueOf(value));
			folderService.delete(folder);
		}
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		History history = new History((User) session.get("user"), new Date(), "删除文件夹");
		historyService.add(history);
		
		return SUCCESS;
	}

}

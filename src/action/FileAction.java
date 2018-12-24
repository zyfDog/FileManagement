package action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pojo.File;
import pojo.Folder;
import pojo.History;
import pojo.User;
import service.FileService;
import service.HistoryService;

/**
 * @author: 詹亦凡
 * @date: 2018年12月4日 下午3:19:45
 */
public class FileAction extends ActionSupport {
	private FileService fileService;
	private HistoryService historyService;
	private String deleteFiles;// 需要删除的文件
	private String deleteFolders;// 需要删除的文件夹，传给下一个action用
	private File file;
	private Folder folder;// 文件所属文件夹
	private File queryFile;// 用于接收查询条件
	private Date beforeQueryDate;// 查询日期
	private Date afterQueryDate;// 查询日期
	private List<File> queryFiles;
	private User queryFileUser;

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public HistoryService getHistoryService() {
		return historyService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

	public String getDeleteFiles() {
		return deleteFiles;
	}

	public void setDeleteFiles(String deleteFiles) {
		this.deleteFiles = deleteFiles;
	}

	public String getDeleteFolders() {
		return deleteFolders;
	}

	public void setDeleteFolders(String deleteFolders) {
		this.deleteFolders = deleteFolders;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public File getQueryFile() {
		return queryFile;
	}

	public void setQueryFile(File queryFile) {
		this.queryFile = queryFile;
	}

	public Date getBeforeQueryDate() {
		return beforeQueryDate;
	}

	public void setBeforeQueryDate(Date beforeQueryDate) {
		this.beforeQueryDate = beforeQueryDate;
	}

	public Date getAfterQueryDate() {
		return afterQueryDate;
	}

	public void setAfterQueryDate(Date afterQueryDate) {
		this.afterQueryDate = afterQueryDate;
	}

	public List<File> getQueryFiles() {
		return queryFiles;
	}

	public void setQueryFiles(List<File> queryFiles) {
		this.queryFiles = queryFiles;
	}

	public User getQueryFileUser() {
		return queryFileUser;
	}

	public void setQueryFileUser(User queryFileUser) {
		this.queryFileUser = queryFileUser;
	}

	// 删除文件，然后传给删除文件夹的action
	public String delete() {
		if (deleteFiles == null || deleteFiles.equals(""))
			return "deletesuccess";
		String[] values = deleteFiles.split(",");
		for (String value : values) {
			File file = new File();
			file.setId(Integer.valueOf(value));
			fileService.delete(file);
		}
		// 添加操作历史
		Map<String, Object> session = ActionContext.getContext().getSession();
		History history = new History((User) session.get("user"), new Date(), "删除文件");
		historyService.add(history);

		return "deletesuccess";
	}

	// 新建文件
	public String add() {
		Map<String, Object> session = ActionContext.getContext().getSession();

		file.setName(file.getTheme() + "." + file.getType());
		file.setSuperiorFolder(folder);
		file.setCreateTime(new Date());
		file.setUpdateTime(new Date());
		file.setCreateUser((User) session.get("user"));
		file.setUpdateUser((User) session.get("user"));
		fileService.add(file);

		// 添加操作历史
		History history = new History((User) session.get("user"), new Date(), "新建文件");
		historyService.add(history);

		return SUCCESS;
	}

	// 查询文件
	public String query() {
		if(queryFileUser == null || queryFileUser.getDepartment().equals("") || queryFileUser.getDepartment() == null) {
			queryFileUser = null;
		}
		queryFiles = fileService.query(queryFile.getName(), queryFile.getTheme(), queryFile.getKeyword(),
				queryFileUser, beforeQueryDate, afterQueryDate);

		// 将查询出的文件List放入上下文，传给IndexAction在页面展示
		ActionContext.getContext().put("queryFiles", queryFiles);
		// 添加操作历史
		Map<String, Object> session = ActionContext.getContext().getSession();
		History history = new History((User) session.get("user"), new Date(), "查询文件");
		historyService.add(history);
		return "querysuccess";
	}

	// 更新文件(重命名)
	public String update() {
		File oldFile = fileService.get(file.getId());
		oldFile.setName(file.getName() + "." + oldFile.getType());
		fileService.update(oldFile);
		// 添加操作历史
		Map<String, Object> session = ActionContext.getContext().getSession();
		History history = new History((User) session.get("user"), new Date(), "重命名文件");
		historyService.add(history);
		return SUCCESS;
	}

}

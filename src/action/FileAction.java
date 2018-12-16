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
	private String deleteFiles;
	private String deleteFolders;
	private File file;
	private Folder folder;
	private File queryFile;// 用于接收查询条件
	private Date beforeQueryDate;
	private Date afterQueryDate;
	private List<File> queryFiles;

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

	public String delete() {
		if (deleteFiles == null || deleteFiles == "")
			return "deletesuccess";
		String[] values = deleteFiles.split(",");
		for (String value : values) {
			File file = new File();
			file.setId(Integer.valueOf(value));
			fileService.delete(file);
		}
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		History history = new History((User) session.get("user"), new Date(), "删除文件");
		historyService.add(history);

		return "deletesuccess";
	}

	public String add() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		file.setName(file.getTheme() + "." + file.getType());
		file.setCreateTime(new Date());
		file.setUpdateTime(new Date());
		file.setCreateUser((User) session.get("user"));
		file.setUpdateUser((User) session.get("user"));
		fileService.add(file);
		
		History history = new History((User) session.get("user"), new Date(), "新增文件");
		historyService.add(history);
		
		return SUCCESS;
	}

	public String query() {
		queryFiles = fileService.query(queryFile.getName(), queryFile.getTheme(), queryFile.getKeyword(),
				queryFile.getCreateUser(), beforeQueryDate, afterQueryDate);
		ActionContext.getContext().put("queryFiles", queryFiles);
		return "querysuccess";
	}

}

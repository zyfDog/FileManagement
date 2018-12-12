package action;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pojo.File;
import pojo.Folder;
import service.FileService;

/**
 * @author: 詹亦凡
 * @date: 2018年12月4日 下午3:19:45
 */
public class FileAction extends ActionSupport {
	private FileService fileService;
	private String deleteFiles;
	private File file;
	private Folder folder;
	private File queryFile;
	private Date beforeQueryDate;
	private Date afterQueryDate;
	private List<File> queryFiles;

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public String getDeleteFiles() {
		return deleteFiles;
	}

	public void setDeleteFiles(String deleteFiles) {
		this.deleteFiles = deleteFiles;
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
		String[] values = deleteFiles.split(",");
		for (String value : values) {
			File file = new File();
			file.setId(Integer.valueOf(value));
			fileService.delete(file);
		}

		return SUCCESS;
	}

	public String add() {
		file.setName(file.getTheme());
		file.setName(file.getName() + "." + file.getType());
		file.setCreateTime(new Date());
		fileService.add(file);
		return SUCCESS;
	}

	public String query() {
		queryFiles = fileService.query(queryFile.getName(), queryFile.getTheme(), 
				queryFile.getKeyword(), queryFile.getCreateUser(), beforeQueryDate, afterQueryDate);
		ActionContext.getContext().put("queryFiles", queryFiles);
		return "querysuccess";
	}

}

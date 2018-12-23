package action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pojo.Folder;
import pojo.History;
import pojo.User;
import service.FileService;
import service.HistoryService;

/**
 * @author: 詹亦凡
 * @date: 2018年12月5日 下午9:23:37
 */
public class UploadAction extends ActionSupport {
	private Integer superiorFolderId;
	private File doc;
	private String docFileName;
	private String docContentType;
	private pojo.File file;
	private FileService fileService;
	private HistoryService historyService;

	public Integer getSuperiorFolderId() {
		return superiorFolderId;
	}

	public void setSuperiorFolderId(Integer superiorFolderId) {
		this.superiorFolderId = superiorFolderId;
	}

	public File getDoc() {
		return doc;
	}

	public void setDoc(File doc) {
		this.doc = doc;
	}

	public String getDocFileName() {
		return docFileName;
	}

	public void setDocFileName(String docFileName) {
		this.docFileName = docFileName;
	}

	public String getDocContentType() {
		return docContentType;
	}

	public void setDocContentType(String docContentType) {
		this.docContentType = docContentType;
	}

	public pojo.File getFile() {
		return file;
	}

	public void setFile(pojo.File file) {
		this.file = file;
	}

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

	public String execute() {
		String realPath = "F:\\eclipse-workspace\\FileManagement\\WebContent\\files";
		File file = new File(realPath);

		// java.io.File.File(File parent, String child)通过上级路径新建文件
		File newFile = new File(file, docFileName);

		try {
			FileUtils.copyFile(doc, newFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		save(newFile);

		return SUCCESS;
	}

	// 将文件存入数据库
	public void save(File doc) {
		Map<String, Object> session = ActionContext.getContext().getSession();

		Folder folder = new Folder();
		folder.setId(superiorFolderId);
		file.setName(doc.getName());
		String type = file.getName().split("\\.")[1];// .需要转义符\\
		file.setType(type);
		file.setSize((int) doc.length());
		file.setCreateTime(new Date());
		file.setUpdateTime(new Date());
		file.setCreateUser((User) session.get("user"));
		file.setUpdateUser((User) session.get("user"));
		file.setPath(doc.getPath());
		file.setSuperiorFolder(folder);
		fileService.add(file);

		// 添加操作历史
		History history = new History((User) session.get("user"), new Date(), "上传");
	}

}

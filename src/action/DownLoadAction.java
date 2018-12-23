package action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pojo.File;
import pojo.History;
import pojo.User;
import service.FileService;
import service.HistoryService;

public class DownLoadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String contentType;  //文件的mime类型，默认为text/plain；
	private long contentLength; //下载文件的长度
	private String contentDisposition; //指定文件下载的处理方式，内联(inline)和附件(attachment)两种方式，attachment会弹出文件保存对话框
	private InputStream inputStream; //inputstream流的名称
	private String downloadFiles;
	private FileService fileService;
	private HistoryService historyService;

	public String getContentType() {
		return contentType;
	}

	public long getContentLength() {
		return contentLength;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String getDownloadFiles() {
		return downloadFiles;
	}

	public void setDownloadFiles(String downloadFiles) {
		this.downloadFiles = downloadFiles;
	}

	public FileService getFileService() {
		return fileService;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public HistoryService getHistoryService() {
		return historyService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

	@Override
	public String execute() throws Exception {

		// 确定各个成员变量的值
		File file = fileService.get(Integer.valueOf(downloadFiles));

		contentDisposition = "attachment;filename=" + file.getName();
		//如果文件是新建的，没有路径，则新建一个真实文件
		if (file.getPath() == null) {
			java.io.File newFile = new java.io.File(
					"F:\\eclipse-workspace\\FileManagement\\WebContent\\files\\" + file.getName());
			if (!newFile.exists())
				newFile.createNewFile();
			inputStream = new FileInputStream(newFile);
		} else {
			inputStream = new FileInputStream(file.getPath());
		}

		contentLength = inputStream.available();
		
		//下载后文件点击数加一
		file.setHits(file.getHits() + 1);
		fileService.update(file);
		//添加操作历史
		Map<String, Object> session = ActionContext.getContext().getSession();
		History history = new History((User) session.get("user"), new Date(), "下载");
		historyService.add(history);

		return SUCCESS;
	}
}

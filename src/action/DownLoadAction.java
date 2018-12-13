package action;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import pojo.File;
import service.FileService;

public class DownLoadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String contentType;
	private long contentLength;
	private String contentDisposition;
	private InputStream inputStream;
	private String downloadFiles;
	private FileService fileService;

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

	@Override
	public String execute() throws Exception {

		// 确定各个成员变量的值
		ServletContext servletContext = ServletActionContext.getServletContext();

		File file = fileService.get(Integer.valueOf(downloadFiles));

		contentDisposition = "attachment;filename=" + file.getName();
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

		return SUCCESS;
	}
}

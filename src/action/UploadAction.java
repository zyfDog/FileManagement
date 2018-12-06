package action;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

import service.FileService;

/**
 * @author: 詹亦凡
 * @date: 2018年12月5日 下午9:23:37
 */
public class UploadAction extends ActionSupport {
	private File doc;
	private String docFileName;
	private String docContentType;
	private pojo.File file;
	private FileService fileService;

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

	public String execute() {
		String realPath = "F:\\eclipse-workspace\\FileManagement\\WebContent\\files";
		System.out.println("hh" + realPath);
		File file = new File(realPath);

		File newFile = new File(file, docFileName);
		try {
			FileUtils.copyFile(doc, newFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		save(newFile);

		return SUCCESS;
	}

	public void save(File doc) {
		file.setName(doc.getName());
		String type = file.getName().split("\\.")[1];
		System.out.println(type);
		file.setType(type);
		file.setSize((int) doc.length());
		file.setUpdateTime(new Date());
		file.setPath(doc.getPath());
		System.out.println(file);
		fileService.add(file);
	}

}

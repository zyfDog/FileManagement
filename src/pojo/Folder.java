package pojo;

import java.util.Date;
import java.util.Set;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午4:44:31
 */
public class Folder {

	private int id;
	private String name;
	private String keyword;
	private Date updateTime;
	private User updateUser;
	private Folder superiorFolder;
	private Set<Folder> childrenFolder;
	private Set<File> childrenFile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

	public Folder getSuperiorFolder() {
		return superiorFolder;
	}

	public void setSuperiorFolder(Folder superiorFolder) {
		this.superiorFolder = superiorFolder;
	}

	public Set<Folder> getChildrenFolder() {
		return childrenFolder;
	}

	public void setChildrenFolder(Set<Folder> childrenFolder) {
		this.childrenFolder = childrenFolder;
	}

	public Set<File> getChildrenFile() {
		return childrenFile;
	}

	public void setChildrenFile(Set<File> childrenFile) {
		this.childrenFile = childrenFile;
	}

	@Override
	public String toString() {
		String Json = "{" +
				"\"id\":\"" + id +"\","+
	            "\"name\":\"" + name +"\","+
	            "\"keyword\":\"" + keyword + "\","+
	            "\"updateTime\":\"" + updateTime + "\"";
		
		if(updateUser != null) {
			Json += ",\"updateUser\":\"" + updateUser.getName() + "\"";
		}
		if(superiorFolder != null) {
			Json += ",\"superiorFolder\":\"" + superiorFolder.getName() + "\"";
		}
		
		Json += '}';
		return Json;
				/*"{" +
	            "\"name\":\"" + name +"\","+
	            "\"keyword\":\"" + keyword + "\","+
	            "\"updateTime\":\"" + updateTime + "\"," +
	            "\"updateUser\":\"" + updateUser.getName() + "\"," +
	            "\"superiorFolder\":\"" + superiorFolder.getName() + "\"" +
	            '}';*/

	}

}

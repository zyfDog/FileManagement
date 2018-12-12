package pojo;

import java.util.Date;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午4:31:54
 */
public class File {

	private int id;
	private String name;
	private String theme;
	private String type;
	private String keyword;
	private int size;
	private int hits;
	private Date createTime;
	private Date createUser;
	private Date updateTime;
	private User updateUser;
	private Folder superiorFolder;
	private String path;

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

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Date createUser) {
		this.createUser = createUser;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", name=" + name + ", theme=" + theme + ", type=" + type + ", keyword=" + keyword
				+ ", size=" + size + ", hits=" + hits + ", updateTime=" + updateTime + ", updateUser=" + updateUser
				+ ", superiorFolder=" + superiorFolder + ", path=" + path + "]";
	}

}

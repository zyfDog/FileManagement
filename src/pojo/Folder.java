package pojo;

import java.util.Set;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午4:44:31
 */
public class Folder {

	private int id;
	private String name;
	private String keyword;
	private Folder superiorFolder;
	private Set<Folder> childrenFolder;

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

	@Override
	public String toString() {

		return  id + name + "["+childrenFolder+"]" ;

	}

}

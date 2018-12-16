package pojo;

import java.util.Date;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午4:44:44
 */
public class History {

	private int id;
	private User user;
	private Date time;
	private String operation;

	public History() {
		
	}
	
	public History(User user, Date time, String operation) {
		this.user = user;
		this.time = time;
		this.operation = operation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}

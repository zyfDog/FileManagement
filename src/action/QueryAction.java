package action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

import pojo.User;

/**
 * @author: 詹亦凡
 * @date: 2018年12月12日 下午4:19:03
 */
public class QueryAction extends ActionSupport {
	private String name;
	private String theme;
	private String keyword;
	private User createUser;
	private Date beforeQueryDate;
	private Date afterQueryDate;

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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
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

	public void query() {

	}

}

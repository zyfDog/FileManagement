package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import pojo.User;
import service.UserService;

/**
 * @author: 詹亦凡
 * @date: 2018年10月10日 下午11:13:40
 */
public class LoginAction extends ActionSupport {

	private User user;
	private UserService userService;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() {

		User inUser = userService.get(user.getAccount());
		if (inUser != null && user.getPassword().equals(inUser.getPassword())) {
			ActionContext actionContext = ActionContext.getContext();
			Map<String, Object> session = actionContext.getSession();
			session.put("user", inUser);
		} else {
			return "reLogin";
		}
		
		return SUCCESS;
	}

}

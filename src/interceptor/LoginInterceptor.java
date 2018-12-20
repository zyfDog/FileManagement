package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import pojo.User;

/**
 * @author: 詹亦凡
 * @date: 2018年10月10日 下午11:32:13
 */
public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/*System.out.println("进入拦截器");*/
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		User user =  (User) session.get("user");
		if(user != null) {
			/*System.out.println("已登录" + user.getName());*/
			return invocation.invoke();
		}
		else {
			return "reLogin";
		}
	}

}

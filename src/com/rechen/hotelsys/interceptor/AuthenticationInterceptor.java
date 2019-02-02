/**
 * 
 */
package com.rechen.hotelsys.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author Re.chen
 *
 */
public class AuthenticationInterceptor implements Interceptor {

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String,Object> session = invocation.getInvocationContext().getSession();
		Object admin = session.get("loginedAdmin");
		
		if(admin==null){
			return "login_action";
		}
			
		return invocation.invoke();
	}

}

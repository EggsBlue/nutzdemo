package demo.hello.filter;

import javax.servlet.http.HttpServletRequest;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.ViewWrapper;

public class MyFilter3 implements ActionFilter  {

	@Override
	public View match(ActionContext actionContext) {
		HttpServletRequest request = actionContext.getRequest();
		String valueOf = String.valueOf(System.currentTimeMillis());
		String test  =request.getRemoteHost();
		System.out.println(test);
		return null;
	}
	
}

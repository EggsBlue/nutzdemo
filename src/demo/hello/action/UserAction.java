package demo.hello.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import com.huage.service.UserService;

@At("userAction")
public class UserAction {
	@Inject
	private UserService userService;
	
	public void execute(){
		userService.findall();
	}
	
	@At
	@Ok("json")
	public Object login(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> map2 = new HashMap<String,Object>();
		String sid = request.getSession().getId();
		map2.put("sid", sid);
		System.out.println("login--sid--->"+sid);
		map.put("callback",map);
		return map;
	}
	
	@At
	@Ok("json")
	public void index(HttpServletRequest request){
		HttpSession session = request.getSession();
		System.out.println("index--sid--->"+session.getId());
	}
	
	@At
	@Ok("json")
	public void index2(HttpServletRequest request){
		HttpSession session = request.getSession();
		System.out.println("index2--sid--->"+session.getId());
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

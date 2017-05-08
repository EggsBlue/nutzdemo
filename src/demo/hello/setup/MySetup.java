package demo.hello.setup;

import javax.servlet.ServletContext;

import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

public class MySetup implements Setup{

	@Override
	public void destroy(NutConfig nc) {
		String name = nc.getAppName();
		String appRoot = nc.getAppRoot();
		ServletContext context = nc.getServletContext();
		Ioc ioc = nc.getIoc();
		

		System.out.println("appName:"+name);
		System.out.println("appRoot:"+appRoot);
		System.out.println("context:"+context);
		System.out.println("appName:"+name);
		
		System.out.println("应用destroy...");
	}

	@Override
	public void init(NutConfig nc) {
		System.out.println("应用初始化...");
	}

}

package demo.hello;

import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
@At("/testModule")
public class TestModule {
	
	@At
	@Ok("raw")
	public String testMethod(){
		return "testMethod!";
	}
}

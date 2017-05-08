package demo.hello.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.nutz.json.Json;

import demo.hello.entity.Person;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str = URLDecoder.decode("324cXQmSPj9cZ-oyPqWl11TdeWKkkh1k", "ISO-8859-1");
		System.out.println(str);
		

	
	}
	
	@org.junit.Test
	public void nutzJsonTest(){
		//将java对象转换为json
		Person p = new Person();
		p.setName("huage");
		p.setAge(1);
		String strObj = "{'name':'huage','age': 1}";
		System.out.println(Json.toJson(p));
		//将json字符串,转换为java对象
		Person p2 = Json.fromJson(Person.class, strObj);
		System.out.println(p2);
	}
}

package demo.hello.ioc;

import org.junit.Test;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.AnnotationIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;

import demo.hello.action.UserAction;
import demo.hello.entity.Person;
import demo.hello.entity.Pet;

public class NutzIocDemo {
	
	@Test
	public void jsonIocTest(){
		Ioc ioc = new NutIoc(new JsonLoader("demo/hello/entity/ioc.js"));
		Person p = ioc.get(Person.class, "huage");
		System.out.println(p.getName()+"--"+p.getAge());
//		ioc.depose();
		Person p2 = ioc.get(Person.class, "gc");
		System.out.println(p2.getName()+"--"+p2.getAge());
		Person luli = ioc.get(Person.class,"luli");
		System.out.println(luli.getName()+"--"+luli.getAge());
		Person my = ioc.get(Person.class,"my");
		System.out.println(my.getName());
	}
	
	@Test
	public void annotationIocTest(){
		Ioc ioc = new NutIoc(new AnnotationIocLoader("demo.hello.entity"));
		Person p = ioc.get(Person.class,"person");
		System.out.println(p.getName());
	}
	
	
	public static void main(String[] args) {
		Ioc ioc = new NutIoc(new AnnotationIocLoader("demo.hello.entity"));
		Person p = ioc.get(Person.class,"person");
		System.out.println(p.getName());
	}
	
	
	@Test
	public void fencengTest(){
		Ioc ioc = new NutIoc(new AnnotationIocLoader("com.huage"));
		UserAction userAction = ioc.get(UserAction.class,"userAction");
		userAction.execute();
		ioc.depose();
		
	}
}

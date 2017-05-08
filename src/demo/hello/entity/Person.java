package demo.hello.entity;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean
public class Person {
	@Inject(":abcc")
	private String name;
	
	private int age;
	private Person friend;
	private Ioc ioc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person getFriend() {
		return friend;
	}
	public void setFriend(Person friend) {
		this.friend = friend;
	}
	
	public Ioc getIoc() {
		return ioc;
	}
	public void setIoc(Ioc ioc) {
		this.ioc = ioc;
	}
	public Person(String name){
		this.name = name;
	}
	public Person(){}
	
	public String test(){
		System.out.println("this is test!");
		return "hhh";
	}
	
	public void init(){
		System.out.println("person init...");
	}
	public void fetch(){
		System.out.println("person fetch...");
	}
	public void depose(){
		System.out.println("person depose...");
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", friend=" + friend + ", ioc=" + ioc + "]";
	}
	
}

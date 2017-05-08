package demo.hello.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.util.cri.SimpleCriteria;
import org.nutz.dao.util.cri.SqlExpressionGroup;

import demo.hello.entity.Student;

public class NutzDaoDemo {
	
	public Dao dao = null;
	
	//初始化DAO
	@Before
	public void init(){
		SimpleDataSource dataSource  = new SimpleDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://192.168.22.202:3306/nutzdemo");
		dataSource.setUsername("root");
		dataSource.setPassword("sysadmin");
		dao = new NutDao(dataSource);
	}
	
	//基本操作
	/**
	 * 建表
	 * @throws ClassNotFoundException
	 */
	@Test
	public void createTableTest() throws ClassNotFoundException{
		dao.create(Student.class, false);//建表
	}
	
	
	/**
	 * 插入一条数据
	 */
	@Test
	public void insertTest(){
		Student stu = new Student();
		stu.setName("nutz2");
		stu.setAge(15);
		dao.insert(stu);
		System.out.println(stu.getId());
	}
	
	/*
	 * 插入多条,支持数组,List,Map
	 */
	@Test
	public void fastInsertTest(){
		Student[] stus = new Student[2];
		Student s1=  new Student();
		s1.setName("aaa");
		s1.setAge(16);
		Student s2=  new Student();
		s2.setName("bbb");
		s2.setAge(19);
		
		stus[0] = s1;
		stus[1] = s2;
		
		dao.fastInsert(stus);
	}
	
	/*
	 * 删除一条
	 */
	@Test
	public void deleteTest(){
		Student stu = new Student();
		stu.setId(2);
		dao.delete(stu);
	}
	
	/*
	 * 更新
	 */
	@Test
	public void updateTest(){
		Student stu = new Student();
		stu.setId(2);
		stu.setName("huage");
		stu.setAge(19);
		dao.update(stu);
	}
	/*
	 * 查询一条
	 */
	@Test
	public void fetchTest(){
		Student stu = new Student();
		stu.setId(2);
		Student stu2 = dao.fetch(stu);
		System.out.println(stu2);
	}
	
	/*
	 * 查询多条
	 */
	@Test
	public void queryTest(){
		List<Student> list = dao.query(Student.class,Cnd.where("1","=","1"));
		for (Student s : list) {
			System.out.println(s);
		}
	}
	
	/*
	 * 清空表数据
	 */
	@Test
	public void clearTest(){
		dao.clear(Student.class);
	}
	
	/*
	 * 聚合查询,sum,avg,count等
	 */
	@Test
	public void func(){
		int i = dao.func(Student.class, "count", "*");
		System.out.println(i);
	}
	
	/*
	 * 删除表
	 */
	@Test
	public void droptableTest(){
		dao.drop(Student.class);
	}
	
	//复杂查询
	@Test
	public void conditionTest(){
		
		Condition c1 = Cnd.where("1","=","1");
		System.out.println(c1.toSql(null));
		List<Student> list = dao.query(Student.class,c1);
		System.out.println(list);
	}
	
	@Test
	public void criteriaTest(){
		SimpleCriteria cri = Cnd.cri();
		SqlExpressionGroup sql = cri.where().andBetween("age", 15, 20).andIn("age", 16);
		List<Student> list = dao.query(Student.class,Cnd.where(sql));
		System.out.println(list);
	}
	
	@Test
	public void criteriaTest2(){
		SimpleCriteria cri = Cnd.cri();
		cri.where().andGT("age", 18);
		cri.where().andLT("age", 25);
		cri.getOrderBy().asc("age");
		List<Student> list = dao.query(Student.class,cri);
		System.out.println(list);
	}
	
	
	//分页
	@Test
	public void pagerTest(){
		Pager pager = dao.createPager(1, 3);
		List<Student> list = dao.query(Student.class,Cnd.where("age","=",19),pager);
		pager.setRecordCount(dao.count(Student.class));
		System.out.println(list);
		System.out.println(pager);
	}
	
}

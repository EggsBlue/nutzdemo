package demo.sugar;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.nutz.castor.Castors;
import org.nutz.lang.random.EnumRandom;

public class Test {
	
	
	@org.junit.Test
	public void test1(){
		
//		int[] i1 = {1,2,3};
//		int[] i2 = {1,2,3};
//		
//		System.out.println(i1 == i2);
//		System.out.println(i1.equals(i2));
//		System.out.println(Lang.equals(i1, i2));
		
		String[] s1 = {"1","2","3"};
//		String[] s2 = {"1","2","3"};
//		System.out.println(s1 == s2);
//		System.out.println(s1.equals(s2));
//		System.out.println(Lang.equals(s1, s2));
		
		
		List<String> list = Castors.me().castTo("[1,2,3]", List.class);
//		System.out.println(Lang.equals(list, s1));
		
//		Person p = new Person();
//		p.setAge(1111);
//		System.out.println(Dumps.obj(p));
//		System.out.println(Dumps.obj(list));
		
//		System.out.println(Lang.contains(s1, "11"));
//		Lang.each(list,	new Each<String>(){
//
//			@Override
//			public void invoke(int index, String ele, int length) throws ExitLoop, ContinueLoop, LoopException {
//				System.out.println(index);
//				System.out.println(ele);
//				System.out.println(length);
//			}
//			
//		});
		
		
		//数组转map
//		String[][] strings = Lang.collection2array(list,String[].class);
		
		//对象模拟
//		ArrayList<String> list2 = Lang.list("[1,2,3,4]");
//		System.out.println(list2);
		
		//随即数据
//		StringGenerator sg = new StringGenerator(20);
//		sg.setup(20, 20);
//		for(int i=0; i<20; i++)
//			System.out.println(sg.next());
		
		
//		System.out.println(R.random(0, 10));//区间int值
//		System.out.println((new EnumRandom<MyEnums>(){}).next(););
		
		
		
		//类型转换
		System.out.println(Castors.me().castTo("110",int.class));
		System.out.println(Castors.me().castTo(System.currentTimeMillis(),Calendar.class).getTime());
	}
	
	
}

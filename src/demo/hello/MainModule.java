package demo.hello;

import java.io.File;

import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.filter.CrossOriginFilter;
import org.nutz.mvc.upload.FieldMeta;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.mvc.view.JspView;

import demo.hello.entity.User;
import demo.hello.filter.PassHttpFilter;
import demo.hello.setup.MySetup;

@Modules(scanPackage=true)
@SetupBy(MySetup.class)
@Filters({@By(type=CrossOriginFilter.class)})
@Encoding(input="utf-8",output="utf-8")
public class MainModule {
	
	@At("/hello")
	@Ok("raw")
	@Fail("jsp:/index.jsp")
	public String hello() throws Exception{
		throw new Exception("111");
	}
	
	@At("/hello2")
	@Ok("raw")
	public String hello2(@Param("str")String str){
		return "Hello Nutz2--"+str;
	}
	
	@At("/hello3")
	@Ok("raw")
	public String hello3(){
		return "Hello Nutz333333!";
	}
	
	@At("getFile")
	@Ok("raw")
	public File getFile(){
		return new File("F:\\实用工具\\计算机.exe");
	}
	
	@At("/fileupload")
	@AdaptBy(type=UploadAdaptor.class,args={"${app.root}/temp"})
	public Object upload(@Param("img") File file){
		return new JspView("/index.jsp");
	}
	
	@At("/fileupload2")
	@AdaptBy(type=UploadAdaptor.class,args={"${app.root}/temp"})
	public Object upload2(@Param("img") TempFile file){
		FieldMeta meta = file.getMeta();
		long size = file.getSize();
		String name = meta.getName();
		String fileExtension = meta.getFileExtension();
		String fileLocalName = meta.getFileLocalName();
		String fileLocalPath = meta.getFileLocalPath();
		File file2 = file.getFile();
		
		System.out.println("name: "+name);
		System.out.println("fileExtension: "+fileExtension);
		System.out.println("fileLocalName: "+fileLocalName);
		System.out.println("fileLocalPath: "+fileLocalPath);
		System.out.println("size:"+size);
		
		return new JspView("/index.jsp");
	}
	
	@At("login")
	public Object login(@Param("user_name") String user_name,@Param("pwd") String pwd){
		User user = new User(1001,user_name,pwd);
		return user;
	}
	
	
}

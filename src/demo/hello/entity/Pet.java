package demo.hello.entity;

import java.util.Calendar;

import org.nutz.ioc.loader.annotation.IocBean;
@IocBean
public class Pet {
	   private String name;

	    private Calendar birthday;

	    private Pet friend;

	    public Pet() {}

	    public Pet(String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Calendar getBirthday() {
	        return birthday;
	    }

	    public void setBirthday(Calendar birthday) {
	        this.birthday = birthday;
	    }

	    public Pet getFriend() {
	        return friend;
	    }

	    public void setFriend(Pet friend) {
	        this.friend = friend;
	    }

		@Override
		public String toString() {
			return "Pet [name=" + name + ", birthday=" + birthday + ", friend=" + friend + "]";
		}
	    
}

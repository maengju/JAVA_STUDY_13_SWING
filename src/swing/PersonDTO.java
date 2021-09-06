package swing;

import java.io.Serializable;

public class PersonDTO implements Serializable {//추상메소드가 아예 없는 인터페이스임

	
	private String id;
	private String name;
	private String pwd;
	private String phone;
	
	
	public PersonDTO( String id, String name,String pwd, String phone) {
		super();
		
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	
	


	
	
	
	
	
	
	
	
	
	
}




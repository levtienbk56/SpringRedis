package tienlv.demo.redis.model;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = -326082738027339528L;
	private String id;
	private String name;
	private String password;

	public Account() {
	}

	public Account(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}

package com.book.dto;

public class LoginDTO {

	private String id;
	private String pwd;
	
	public LoginDTO() {
		super();
	}

	public LoginDTO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
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
	
	
	
	
	

}

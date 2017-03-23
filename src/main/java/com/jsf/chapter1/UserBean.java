package com.jsf.chapter1;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("user")
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	
	public String getGreeting() {		
		if ( name == null || name.length() == 0 ) return "";
		else return "Welcome to JSF + Ajax, " + name + "!";
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
}

package model.entity;

import java.io.Serializable;

public class User implements Serializable {

	private String user;
	private String pass;
	private String name;
	private int id;

	public User() {
	}

	public User(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	public User(String user, String pass, String name) {
		this.user = user;
		this.pass = pass;
		this.name = name;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



}
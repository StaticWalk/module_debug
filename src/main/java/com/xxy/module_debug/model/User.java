package com.xxy.module_debug.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiongxiaoyu
 * Data:2019/5/30
 * Time:12:04
 */

@Data
public class User implements Serializable {

//	@Id
	private String id;

	private String username;
	private String age;
	private String grade;

	public User(String id, String username, String age, String grade) {
		this.id = id;
		this.username = username;
		this.age = age;
		this.grade = grade;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getAge() {
		return age;
	}
}

package com.improve.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="userEntity")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique=true)
	private String workId;
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Column
	private String role="user";

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Column
	private String userName="xxx";
	@Column
	private int age=0;
	@Column
	private String telphone="000";
	@Column
	private String mail="xxx@163.com";
	@Column
	private String passwd="xxx";
	
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Override
	public String toString()
	{
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("id",this.id);
		result.put("workId", workId);
		result.put("name", this.userName);
		result.put("age",this.age);
		result.put("telphone",this.age);
		result.put("mail",this.mail);
		
		return result.toString();
	}

}

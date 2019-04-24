package com.improve.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.improve.RequestCode.RequestCode;
import com.improve.entity.User;
import com.improve.service.UserService;

@RestController
@RequestMapping("/user/*")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	private RequestCode requestCode=new RequestCode();
	
	@RequestMapping(value="/jpaSave",method=RequestMethod.GET)
	public String jpaSave(
			@RequestParam("workId") String workId,
			@RequestParam("name") String name,
			@RequestParam("age") Integer age,
			@RequestParam("mail") String mail,
			@RequestParam("telphone") String telphone,
			@RequestParam("passwd") String passwd
			)
	{
		System.out.println(telphone);
		User user=new User();
		user.setWorkId(workId);
		user.setUserName(name);
		user.setAge(age);
		user.setMail(mail);
		user.setTelphone(telphone);
		user.setPasswd(passwd);
		//Map<String,Object> result=new HashMap<String,Object>();
		userService.save(user);
		System.out.println("jpaSave");
		return "jpaSave";	
	}
	
	
	@RequestMapping(value="/userApply",method=RequestMethod.GET)
	public Map<String,Object> userApply(
			@RequestParam("workId") String workId,
			@RequestParam("name") String name,
			@RequestParam("age") Integer age,
			@RequestParam("mail") String mail,
			@RequestParam("telphone") String telphone,
			@RequestParam("passwd") String passwd
			)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
		User user=new User();
		user.setWorkId(workId);
		user.setUserName(name);
		user.setAge(age);
		user.setMail(mail);
		user.setTelphone(telphone);
		user.setPasswd(passwd);
		//Map<String,Object> result=new HashMap<String,Object>();
		userService.save(user);
		result.put("status", "success");
		System.out.println("###userApply success###  "+name+telphone);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("###userApply failed### "+name+telphone);
			result.put("status", e);
		}
		return result;	
	}
	
	@RequestMapping(value="/deleteUserById",method=RequestMethod.GET)
	public Map<String,Object> deleteUserById(@RequestParam("id") Integer id)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
	
		//Map<String,Object> result=new HashMap<String,Object>();
		userService.deleteById(id);
		result.put("status", "success");
		System.out.println("###deleteUserById success###  "+id);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("###deleteUserById failed### "+id);
			result.put("status", e);
		}
		return result;	
	}
	
	@RequestMapping(value="/jpaSelectName",method=RequestMethod.GET)
	public String jpaSelectName(@RequestParam("name") String name)
	{
		//从url中获取查询字段
		List<User> user;
		try {
			user=userService.getUserByName(name);
			System.out.println("getUserName");
		}catch(Exception e)
		{
			System.out.println("#############jsp Select Error########## ");
			e.printStackTrace();
			user=null;
		}
		return name;
	}
	
	@RequestMapping(value="/jpaModify",method = RequestMethod.GET)
	public String jpaModify(
			@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("telphone") int Telphone,
			@RequestParam("mail") String mail)
	{
		//从Url中获取要修改的字段以及实体
		//User user=new User();
		return "jpaModify";
	}
	
	
	@RequestMapping(value="jpaDeleteByName",method = RequestMethod.GET)
	public String jpaDelete(@RequestParam("id") Integer id)
	{
		
		userService.deleteById(id);
		return "jpaDelete";
	}
	
	@RequestMapping(value="/findAllUser",method=RequestMethod.GET)
	public List<User> findAllUser()
	{
		//从url中获取查询字段
		List<User> users;
		try {
			users=userService.findAllUser();
			System.out.println("###findAllUser Success###");
		}catch(Exception e)
		{
			System.out.println("#############findAllUser Error########## ");
			e.printStackTrace();
			users=new ArrayList<User>();
		}
		return users;
	}

	//此功能为管理员使用
	@RequestMapping("/register")
	public Map<String,Object> userRegister(
			@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("telphone") int Telphone,
			@RequestParam("mail") String mail
			)
	{
		
		return null;
	}
	
	
	@RequestMapping("/login")
	public Map<String,Object> userLogin(
			@RequestParam("id") Integer id,
			@RequestParam("passwd") String passwd)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		User user=userService.getUserById(id);	
		if(user==null)
		{
			result.put("status","No User");
			return result;
		}
		if(user.getPasswd().equals(passwd))
		{
			result.put("status","success");
		}
		else
		{
			result.put("status","error");
		}
		return result;

	}
	
	@RequestMapping("/logout")
	public Map<String,Object> userLogout()
	{
		return null;
	}
		
}

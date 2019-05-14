package com.improve.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.improve.RequestCode.RequestCode;
import com.improve.aspect.AuthToken;
import com.improve.entity.User;
import com.improve.service.UserService;


@SessionAttributes(value="user")
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
			@RequestParam("passwd") String passwd,
			@RequestParam("role") String role
			)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
		User user=new User();
		user.setWorkId(workId);
		user.setUserName(name);
		user.setAge(age);
		user.setRole(role);
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
	
//	@AuthToken(role_name= {"admin"})
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
//	@AuthToken(role_name= {"admin"})
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
	
	
	@RequestMapping(value="/updateAge",method=RequestMethod.GET)
	public Map<String,Object> userUpateAge(HttpServletRequest params)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			Integer id=Integer.valueOf(params.getParameter("id"));
			Integer newAge=Integer.valueOf(params.getParameter("age"));
			userService.upDateAge(id, newAge);
			result.put("status","success");
		}
		catch(Exception e)
		{
			System.out.println("###user  Update Age   error### ");
			e.printStackTrace();
			result.put("status",e);
		}
		return result;
	}
	
//	@AuthToken(role_name= {"user","admin"})
	@RequestMapping("/login")
	public Map<String,Object> userLogin(
			@RequestParam("workId") String workId,
			@RequestParam("passwd") String passwd,
			@RequestParam("player") String player,
			Map<String,Object> map
			) 
	{
		Map<String,Object> result=new HashMap<String,Object>();
		System.out.println("###login###");
		User user=userService.getUserByWorKId(workId);
		if(user==null)
		{
			result.put("status","No User");
			return result;
		}
		if(user.getPasswd().equals(passwd) && user.getRole().equals(player))
		{
//			map.put("user", user);
			result.put("status","success");
			
//			HttpSession session = request.getSession();
//			session.setAttribute("workId", workId);
//			session.setAttribute("passwd", passwd);
//			session.setAttribute("player", player);
			
	        //获取session的Id
//         String sessionId = session.getId();
//         //判断session是不是新创建的
//         if (session.isNew()) {
//             System.out.println("session创建成功，session的id是："+sessionId);
//         }else {
//        	 System.out.println("服务器已经存在该session了，session的id是："+sessionId);
//         }
		}
		else
		{
//			map.put("user", null);
			result.put("status","error");
			
		}
		return result;

	}
	
	@GetMapping("/updateUser")
	public Map<String,Object> updateRecord(
			@RequestParam("name") String userName,
			@RequestParam("age") int age,
			@RequestParam("telphone") String telphone,
			@RequestParam("mail") String mail,
			@RequestParam("passwd") String passwd,
			@RequestParam("workId") String workId,
			@RequestParam("role") String role
			)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try
		{
			userService.updateUser(userName, role, age, telphone, mail, workId, passwd);
			result.put("status", "success");
			System.out.println("### update User success###"+workId);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("### update User error### "+workId+e);
			result.put("status",e);
		}
		return result;
	}
	
	@RequestMapping("/logout")
	public Map<String,Object> userLogout(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			HttpSession session=request.getSession();
			System.out.println("invalidate session:"+session.getAttribute("user"));
		  session.invalidate();
	      result.put("status", "success");
		}catch(Exception e)
		{
			e.printStackTrace();
			result.put("status", e);
		}
		return result;
	}
	
	@RequestMapping(value="/findUserById")
	public User findUserById(@RequestParam("id") Integer id)
	{
		User user=null;
		try
		{
			user=userService.findUserById(id);
			System.out.println("###find user By id"+id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
}

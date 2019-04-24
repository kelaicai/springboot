package com.improve.service;


import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.improve.dao.UserDao;
import com.improve.entity.User;

@Service
public class UserService {
	
	@Resource
	private UserDao userDao;
	
	@Transactional
	public void save(User user)
	{
		userDao.save(user);
	}
	
	public User getUserByWorKId(String workId)
	{
		return userDao.findByWorkId(workId);
	}
	
	public List<User> getUserByName(String name)
	{
		return userDao.findByUserName(name);
	}
	
	public User getUserById(Integer id)
	{
		return userDao.findOne(id);
	}
	
	public void deleteByUser(User user)
	{
		userDao.delete(user);
	}
	
	public void deleteById(Integer id)
	{
		User user=userDao.findOne(id);
		userDao.delete(user);
	}
	
	public List<User> findAllUser()
	{
		return userDao.findAll();
	}
	
	
}

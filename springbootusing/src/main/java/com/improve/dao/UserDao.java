package com.improve.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.improve.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	public List<User> findByUserName(String userName);
	public User findByWorkId(String workId);
	
}


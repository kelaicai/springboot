package com.improve.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.improve.dao.CommentDao;
import com.improve.entity.Comment;

@Service
public class CommentService {
	@Resource
	private CommentDao commentDao;
	
	public List<Comment> findAllComment()
	{
		return commentDao.findAll();
	}
	
	public void save(Comment comment)
	{
		commentDao.save(comment);
	}

}

package com.improve.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.improve.entity.Comment;
import com.improve.service.CommentService;

@RestController
@RequestMapping("/comments/*")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/commentApply")
	public Map<String,Object> commentApply(@RequestParam("workId") String workId,@RequestParam("comment") String comment)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try
		{
			Comment comment1=new Comment();
			comment1.setWorkId(workId);
			comment1.setComment(comment);
			commentService.save(comment1);
			result.put("status","success");
			
		}catch(Exception e)
		{
			e.printStackTrace();
			result.put("status", e);
		}
		return result;
	}
	
	
	@RequestMapping(value="/findAllComments")
	public List<Comment> findAllComments()
	{
		List<Comment> comments=null;
		try
		{
			comments=commentService.findAllComment();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			comments=new ArrayList<Comment>();
			comments.add(null);
		}
		return comments;
	}
	
}

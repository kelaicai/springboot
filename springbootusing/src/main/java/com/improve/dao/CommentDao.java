package com.improve.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.improve.entity.Comment;
import com.improve.entity.DeviceChange;


public interface CommentDao extends JpaRepository<Comment, Integer> {

		

}
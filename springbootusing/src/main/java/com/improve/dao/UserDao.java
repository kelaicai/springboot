package com.improve.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.improve.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	public List<User> findByUserName(String userName);
	public User findByWorkId(String workId);
//	public User findById(Integer id);
	
	
	
	
	@Query("select passwd from userEntity where workId=:workId")
	public String getUserByWorkId(@Param("workId") String workId);
	
	
	@Modifying
	@Query("update userEntity u set u.age=?2 where u.id=?1")
	public void updateAge(Integer id,Integer age);
	
	@Modifying(clearAutomatically=true)
	@Query("update userEntity set "
			+ "userName=:userName,"
			+ "role=:role,"
			+ "age=:age,"
			+ "telphone=:telphone,"
			+ "mail=:mail,"
			+ "workId=:workId,"
			+ "passwd=:passwd"
			+ " where id=:id")
	public void updateUser(
			@Param("id") Integer id,
			@Param("userName") String userName,
			@Param("role") String role,
			@Param("age") Integer age,
			@Param("telphone") String telphone,
			@Param("mail") String mail,
			@Param("workId") String workId,
			@Param("passwd") String passwd
			);
	
}


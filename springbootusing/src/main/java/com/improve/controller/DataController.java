package com.improve.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.improve.aspect.AuthToken;
import com.improve.service.DataService;

@RestController
@AuthToken(role_name= {"user","admin"})
@RequestMapping("/data/*")
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@GetMapping("/query")
	public List<Object> query(@RequestParam("assetId") String assetId,
			@RequestParam("type") String type)
	{
		List<Object> result=new ArrayList<Object>();
		try
		{
			result=dataService.query(assetId, type);
		}catch(Exception e)
		{
			System.out.println("### data query controller error");
			System.out.println(e);
			e.printStackTrace();
		}
		return result;		
	}
	
	@GetMapping("/queryByType")
	public List<Object> query(
			@RequestParam("type") String type)
	{
		List<Object> result=new ArrayList<Object>();
		try
		{
			result=dataService.queryByType(type);
			System.out.println("### data queryByType controller success###");
		}catch(Exception e)
		{
			System.out.println("### data queryByType controller error###");
			System.out.println(e);
			e.printStackTrace();
		}
		return result;		
	}
	
}

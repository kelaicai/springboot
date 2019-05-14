package com.improve.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.improve.dao.DeviceChangeDao;
import com.improve.dao.DeviceDao;
import com.improve.dao.DeviceDiscardDao;
import com.improve.dao.DeviceStoreDao;
import com.improve.dao.DeviceUsingDao;
import com.improve.dao.MaintenanceDao;
import com.improve.dao.UserDao;
import com.improve.dao.VerifyingDao;


/*
 * 
 * DataService是提供数据查询功能的整体接口
 * */
@Service
public class DataService {

	public static final Integer TYPE_DEIVCE=1;
	public static final Integer TYPE_USING=2;
	public static final Integer TYPE_DISCARD=3;
	public static final Integer TYPE_MAINTENANCE=4;
	public static final Integer TYPE_CHANGE=5;
	public static final Integer TYPE_STORE=6;
	
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private DeviceDao deviceDao;
	
	@Resource 
	private DeviceChangeDao deviceChangeDao;
	
	@Resource
	private DeviceDiscardDao deviceDiscardDao;
	
	@Resource
	private MaintenanceDao deviceMaintenanceDao;
	
	@Resource
	private DeviceUsingDao deviceUsingDao;
	
	@Resource
	private DeviceStoreDao deviceStoreDao;
	
	@Resource
	private VerifyingDao verifyDao;
	
	
	public List<Object> query(String assetId,String type)
	{
		List<Object> result=new ArrayList<Object>();
		try {
				if(type.equals("device")) //1
				{
					result.add(deviceDao.findByAssetId(assetId));
				}
				else if(type.equals("using"))  //2
				{
					result.add(deviceUsingDao.findByAssetId(assetId));
				}
				else if(type.equals("discard"))  //3
				{
					result.add(deviceDiscardDao.findByAssetId(assetId));
				}
				else if(type.equals("change"))  //5
				{
					result.add(deviceChangeDao.findByAssetId(assetId));
				}
				else if(type.equals("store"))  //6
				{
					result.add(deviceStoreDao.findByAssetIdAndIsUsedIsNull(assetId));
				}
				else if(type.equals("user"))  //6
				{
					result.add(userDao.findByWorkId(assetId));
				}
				else if(type.equals("maintenance"))  //4
				{
				result.add(deviceMaintenanceDao.findByAssetId(assetId));
				}
				else if(type.equals("verify"))
				{
					result.add(verifyDao.findByAssetId(assetId));
				}
				else
				{
					result.add(null);
				}
			
		}catch(Exception e)
		{
			System.out.println("### data query error###");
			e.printStackTrace();
			result.add("error");
		}
		return result;
	}
	
	public List<Object> queryByType(String type)
	{
		List<Object> result=new ArrayList<Object>();
		try {
				if(type.equals("device")) //1
				{
					result.add(deviceDao.findAll());
				}
				else if(type.equals("using"))  //2
				{
					result.add(deviceUsingDao.findAll());
				}
				else if(type.equals("discard"))  //3
				{
					result.add(deviceDiscardDao.findAll());
				}
				else if(type.equals("change"))  //5
				{
					result.add(deviceChangeDao.findAll());
				}
				else if(type.equals("store"))  //6
				{
					result.add(deviceStoreDao.findAll());
				}
				else if(type.equals("user"))
				{
					result.add(userDao.findAll());
				}
				else if(type.equals("maintenance"))  //4
				{
					result.add(deviceMaintenanceDao.findAll());
				}
				else if(type.equals("verify"))  //4
				{
					result.add(verifyDao.findAll());
				}
				else
				{
					result.add(null);
				}
			
		}catch(Exception e)
		{
			System.out.println("### data query error###");
			e.printStackTrace();
			result.add("error");
		}
		return result;
	}
	
		
}

package com.improve.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.improve.dao.DeviceStoreDao;
import com.improve.entity.Device;
import com.improve.entity.DeviceDiscard;
import com.improve.entity.DeviceStore;


/*
 * 库存信息应当是从基本信息表内统计出来的
 * 
 * */
@Service
public class DeviceStoreService{

	@Resource
	private DeviceStoreDao deviceStoreDao;
	
	
	@GetMapping("/deviceStoreApply")
	public Map<String,Object> deviceStoreApply(@RequestParam("assetId") String assetId,
			@RequestParam("count") Integer count)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try
		{
			
		}catch(Exception e)
		{
			
		}
		return result;
	}
	
	

	public List<Device> findAll()
	{
		return deviceStoreDao.findByIsUsedIsNull();
	}
	
	
	@Transactional
	public void updateStore(String assetId,Integer count)
	{
		List<Device> deviceStore=deviceStoreDao.findByAssetId(assetId);
		Integer id=0;
		for(Device deCh:deviceStore)
		{
			id=deCh.getId();
		}
		deviceStoreDao.udpateStore(id, assetId, count);
	}
	
	
}
	
	

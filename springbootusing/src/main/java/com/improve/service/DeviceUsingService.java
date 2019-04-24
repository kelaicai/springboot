package com.improve.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.improve.dao.DeviceUsingDao;
import com.improve.entity.DeviceUsing;

@RestController
@RequestMapping("/deviceUsing")
public class DeviceUsingService {
	
	@Resource
	private DeviceUsingDao deviceUsingDao;
	
	
	//实验设备使用记录
	@Transactional
	public void save(DeviceUsing deviceUsing)
	{
		deviceUsingDao.save(deviceUsing);
	}
	
	
	//实验设备通过日期查询
	public List<DeviceUsing> findUsingByDate(String date)
	{
		 return deviceUsingDao.findByDate(date);
	}
	
	
	//实验设备使用记录全员查询
	public List<DeviceUsing> findAllUsing()
	{
		return deviceUsingDao.findAll();
	}
	
	
	//实验设备使用记录查询(By assetName)
	public List<DeviceUsing> findByAssetName(String assetName){
		return deviceUsingDao.findByAssetName(assetName);
	}
	
	//实验设备使用记录删除(By recordId)
	public void deleteUsingById(Integer id)
	{
		DeviceUsing deviceUsing=deviceUsingDao.findById(id);
		deviceUsingDao.delete(deviceUsing);
	}
}

package com.improve.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.improve.dao.DeviceDao;
import com.improve.dao.UserDao;
import com.improve.entity.Device;
import com.improve.entity.User;

@Service
public class DeviceService {
	
	@Resource
	private DeviceDao deviceDao;
	
	@Resource
	private UserDao userDao;
	
	//存储设备基本信息
	@Transactional
	public void save(Device device)
	{
		deviceDao.save(device);
	}
	
	//通过设备名字获取设备集
	public List<Device> getDeviceByName(String assetName)
	{
		return deviceDao.findByAssetName(assetName);
	}
	
	
	//获取设备所有设备
	public List<Device> getDeviceAll()
	{
		return deviceDao.findAll();
	}
	
	public List<Device> findDeviceByUserName(String userName)
	{
		return deviceDao.findByUser(userName);

	}
	
	//通过设备ID获取具体设备
	public List<Device> getDeviceByAssetId(String assetId)
	{
		return deviceDao.findByAssetId(assetId);
	}
	
	@Transactional
	public void upateRecord(
			 String assetId,
			 String assetName,
			 String gbBigClass,
			 String gbClass,
			 String assetBigClass,
			 String assetClass,
			 Integer count,
			 String area,
			 String getMethod,
			 String getDate,
			 String eduUsing,
			 String usingDepartment,
			 String fianceType,
			 String valueType,
			 String typeSpecification,
			 String user,
			 String isUsed,
			 String isDiscard)
	{
		
		System.out.println("assetId:"+assetId+"assetNam:"+assetName+"gbClass:"+gbClass+"gbBigClass:"+gbBigClass+"assetBigClass:"+assetBigClass+""
				+ "assetClass:"+assetClass+"count:"+count+"area:"+area+"getMethod:"+getMethod+"getDate:"+getDate+"eduUsing"+eduUsing+"usingDepartment"+usingDepartment+""
						+ "fianceType:"+fianceType+"valueType:"+valueType+"typeSpecification:"+typeSpecification);
		List<Device> device=deviceDao.findByAssetId(assetId);
		
		Integer id=0;
		for(Device de:device)
		{
			id=de.getId();
		}
		deviceDao.updateRecord(id,assetId, assetName, gbBigClass, gbClass, assetBigClass, assetClass, count, area, getMethod, getDate, eduUsing, usingDepartment, fianceType, valueType, typeSpecification,user,isUsed,isDiscard);
	}
	
	
	//通过修改设备ID为asset_id的信息
	public String ModifyDeviceById()
	{
		return null;
	}
	
	//修改使用状态
	@Transactional
	public void modifyUsed(String assetId)
	{
		deviceDao.updateUsed(assetId);
	}
	
	//报废之后
	@Transactional
	public void cancelUsed(String assetId)
	{
		deviceDao.cancelUsed(assetId);
	}
	
	
	
	//修改报废状态
	@Transactional
	public void modifyDiscard(String assetId)
	{
		deviceDao.updateDiscard(assetId);
	}
	
	//通过设备ID删除设备
	public void deleteAssetByAssetId(String assetId)
	{
		List<Device> device=deviceDao.findByAssetId(assetId);
		deviceDao.delete(device);
	}
	
	public void deleteAssetById(Integer id)
	{
		deviceDao.delete(id);
	}
	
	public Device getDeviceById(Integer id)
	{
		return deviceDao.findOne(id);
	}
	
	
//	//设备使用情况
//	public void save(String date,String deviceUser,String timeLong)
//	{
//		deviceDao.saveDeviceUsing(date, deviceUser, timeLong);
//	}
	
	
}

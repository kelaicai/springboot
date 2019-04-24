package com.improve.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.improve.dao.DeviceDao;
import com.improve.dao.UserDao;
import com.improve.entity.Device;
import com.improve.entity.User;

@Service
public class DeviceService {
	
	@Resource
	private DeviceDao deviceDao;
	
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
	
	//通过设备ID获取具体设备
	public Device getDeviceByAssetId(String assetId)
	{
		return deviceDao.findByAssetId(assetId);
	}
	
	
	
	//通过修改设备ID为asset_id的信息
	public String ModifyDeviceById()
	{
		return null;
	}
	
	//通过设备ID删除设备
	public void deleteAssetByAssetId(String assetId)
	{
		Device device=deviceDao.findByAssetId(assetId);
		deviceDao.delete(device);
	}
	
	public void deleteAssetById(Integer id)
	{
		deviceDao.delete(id);
	}
	
	
//	//设备使用情况
//	public void save(String date,String deviceUser,String timeLong)
//	{
//		deviceDao.saveDeviceUsing(date, deviceUser, timeLong);
//	}
	
	
}

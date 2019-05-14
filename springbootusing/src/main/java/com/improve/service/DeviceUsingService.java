package com.improve.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.improve.dao.DeviceDao;
import com.improve.dao.DeviceUsingDao;
import com.improve.entity.Device;
import com.improve.entity.DeviceUsing;

@RestController
@RequestMapping("/deviceUsing")
public class DeviceUsingService {
	
	@Resource
	private DeviceUsingDao deviceUsingDao;
	
	
	//在提交设备使用信息时，设备表应该更新相应的设备为使用
	@Resource
	private DeviceDao deviceDao;
	
	
	//实验设备使用记录
	@Transactional
	public void save(DeviceUsing deviceUsing)
	{
		deviceUsingDao.save(deviceUsing);
		List<Device> device=deviceDao.findByAssetId(deviceUsing.getAssetId());
		if(device!=null)
		{
			try
			{
				deviceDao.updateUsed(deviceUsing.getAssetId());
				System.out.println("deviceUsing update success");
			}
			catch(Exception e)
			{
				System.out.println("device isUsed Update failed"+e);
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("device is null");
		}
	}
	
	
	//实验设备通过日期查询
	public List<DeviceUsing> findUsingByDate(String date)
	{
		 return deviceUsingDao.findByDate(date);
	}
	
	
	public DeviceUsing findUsingById(Integer id)
	{
		 return deviceUsingDao.findOne(id);
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
		List<DeviceUsing> deviceUsing=deviceUsingDao.findById(id);
		deviceUsingDao.delete(deviceUsing);
	}
	
	public List<Object> UsingCountByAssetId()
	{
		
		return deviceUsingDao.usingCountByAssetId();
	}
	
	@Transactional
	public void updateUsing(String date,String deviceUser,Integer timeLong,String assetId,String teacher,String time,String assetName)
	{
		DeviceUsing deviceUsing= deviceUsingDao.findByAssetId(assetId);
		Integer id=deviceUsing.getId();
		deviceUsingDao.updateUsing(id, date, deviceUser, timeLong, assetId, teacher, time, assetName);
	}
}

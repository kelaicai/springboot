package com.improve.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.improve.dao.DeviceDao;
import com.improve.dao.DeviceDiscardDao;
import com.improve.entity.Device;
import com.improve.entity.DeviceChange;
import com.improve.entity.DeviceDiscard;

@Service
public class DeviceDiscardService {

	@Resource
	private DeviceDiscardDao deviceDiscardDao;
	
	@Resource
	private DeviceDao deviceDao;
	
	//设备报废申请
	@Transactional
	public void deviceDiscardApply(DeviceDiscard deviceDiscard)
	{
		deviceDiscardDao.save(deviceDiscard);
		List<Device> device=deviceDao.findByAssetId(deviceDiscard.getAssetId());
		if(device!=null)
		{
			try
			{
				deviceDao.updateDiscard(deviceDiscard.getAssetId());
				System.out.println("deviceDiscard update success");
			}
			catch(Exception e)
			{
				System.out.println("deviceDiscard Update failed"+e);
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("device is null");
		}
	}
	
	//设备报废申请
	@Transactional
	public void deviceDiscardApply(List<DeviceDiscard> deviceDiscard)
	{
		deviceDiscardDao.save(deviceDiscard);
	}
	
	//设备报废查询
	public List<DeviceDiscard> deviceDiscardFindAll()
	{
		return deviceDiscardDao.findAll();
	}
	
	//通过设备名字查询报废记录
	public List<DeviceDiscard> deviceDiscardFindByAssetName(String assetName)
	{
		return deviceDiscardDao.findByAssetName(assetName);
	}
	
	//通过设备ID查询报废记录
	public List<DeviceDiscard> deviceDiscardFindByAssetId(String assetId)
	{
		return deviceDiscardDao.findByAssetId(assetId);
	}
	
	
	//通过日期查询相应的报废记录
	public List<DeviceDiscard> deviceDiscardFindByDate(String date)
	{
		return deviceDiscardDao.findByDate(date);
	}
	
	public void deleteById(Integer id)
	{
		DeviceDiscard deviceDiscard=deviceDiscardDao.findOne(id);
		deviceDiscardDao.delete(deviceDiscard);
	}
	
	
	@Transactional
	public void updateDiscard(String assetId,String assetName,String reason,String date,String petitioner)
	{
		List<DeviceDiscard> deviceDiscard=deviceDiscardDao.findByAssetId(assetId);
		Integer id=0;
		for(DeviceDiscard deCh:deviceDiscard)
		{
			id=deCh.getId();
		}
		deviceDiscardDao.updateDiscard(id, assetId, assetName, reason, date, petitioner);
	}
	public DeviceDiscard findById(Integer id)
	{
		return deviceDiscardDao.findOne(id);
	}
	
	
	//设备报废删除
//	public void deviceDiscardDeleteByRecordId(Integer recordId)
//	{
//		deviceDiscardDao.deleteByRecordId(recordId);
//	}
//	
	
	//报废信息修改
//	public void deviceDiscardModify(Integer recordId,String reason)
//	{
//		deviceDiscardDao.moidfyByReson(recordId,reason);
//	}
//	
	
	
}

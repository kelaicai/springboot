package com.improve.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.improve.dao.DeviceDiscardDao;
import com.improve.entity.DeviceDiscard;

@Service
public class DeviceDiscardService {

	@Resource
	private DeviceDiscardDao deviceDiscardDao;
	
	//设备报废申请
	@Transactional
	public void deviceDiscardApply(DeviceDiscard deviceDiscard)
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
	public DeviceDiscard deviceDiscardFindByAssetId(String assetId)
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

package com.improve.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.improve.dao.DeviceChangeDao;
import com.improve.entity.DeviceChange;

@Service
public class DeviceChangeService {

	@Resource
	private DeviceChangeDao deviceChangeDao;
	
	//设备变更记录查询(全部)
	public List<DeviceChange> findAllChange()
	{
		return deviceChangeDao.findAll();
	}
	
	//设备变更记录查询(申请人)
	public List<DeviceChange> findByProposer(String proposer)
	{
		return deviceChangeDao.findByProposer(proposer);
	}
	
	//设备变更记录查询(日期)
	public List<DeviceChange> findByDate(String date)
	{
		return deviceChangeDao.findByDate(date);
	}
	
	//设备变更记录查询(设备名称)
	public List<DeviceChange> findByAssetName(String assetName)
	{
		return deviceChangeDao.findByAssetName(assetName);
	}
	
	//设备变更记录查询(设备Id)
	public DeviceChange findByAssetId(String assetId)
	{
		return deviceChangeDao.findByAssetId(assetId);
	}
	
	//设备变更记录提交
	@Transactional
	public void applyDeviceChange(DeviceChange deviceChange)
	{
		deviceChangeDao.save(deviceChange);
	}
	
	public void deleteById(Integer id)
	{
		DeviceChange deviceChange=deviceChangeDao.findOne(id);
		deviceChangeDao.delete(deviceChange);
	}
	
	public DeviceChange findById(Integer id)
	{
		return deviceChangeDao.findOne(id);
	}
	
//
	
	
	
	
}

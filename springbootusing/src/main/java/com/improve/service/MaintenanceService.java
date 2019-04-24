package com.improve.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.improve.dao.MaintenanceDao;
import com.improve.entity.DeviceMaintenance;

@Service
public class MaintenanceService {

	
	@Resource
	private MaintenanceDao maintenanceDao;
	
	
	//设备维护信息录入
	@Transactional
	public void save(DeviceMaintenance deviceMaintenance)
	{
		maintenanceDao.save(deviceMaintenance);
	}
	
	//设备维护信息查询(全部)
	public List<DeviceMaintenance> findByMaintenanceAll()
	{
		return maintenanceDao.findAll();
	}
	
	//设备维护信息查询(ID)
	public DeviceMaintenance findById(Integer id)
	{
		return maintenanceDao.findOne(id);
	}
	
	//设备维护信息查询(Date)
	public List<DeviceMaintenance> findByDate(String date)
	{
		return maintenanceDao.findByDate(date);
	}
	
	//设备维护信息删除(ID)
	public void deleteByMaintenanceId(Integer id)
	{
		DeviceMaintenance deviceMaintenance=maintenanceDao.findOne(id);
		maintenanceDao.delete(deviceMaintenance);
	}
	
	//根据记录ID删除记录
	public void deleteById(Integer id)
	{
		DeviceMaintenance deviceMaintenance=maintenanceDao.findOne(id);
		maintenanceDao.delete(deviceMaintenance);
	}
}

package com.improve.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.improve.entity.DeviceMaintenance;
import com.improve.entity.DeviceUsing;


//维护信息DAO
public interface MaintenanceDao extends JpaRepository<DeviceMaintenance, Integer>{
	public List<DeviceMaintenance> findByDate(String date);
//	public void deleteByRecordId(Integer recordId);
	
	
//	
//	@Query(value="update device_using set date/deviceUser/ where data=?1/deviceUser=?")
//	public modifyDeviceUsing(@Param("date") String date/deviceUser);
}


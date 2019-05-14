package com.improve.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.improve.entity.DeviceMaintenance;
import com.improve.entity.DeviceUsing;


//维护信息DAO
public interface MaintenanceDao extends JpaRepository<DeviceMaintenance, Integer>{
	public List<DeviceMaintenance> findByDate(String date);
	public List<DeviceMaintenance> findByAssetId(String assetId);
	
	@Modifying(clearAutomatically=true)
	@Query(value="update deviceMaintenance set "
			+ "assetId=:assetId,"
			+ "assetName=:assetName,"
			+ "date=:date,"
			+ "maintenancer=:maintenancer,"
			+ "content=:content,"
			+ "other=:other "
			+ "where id=:id",nativeQuery = true)
	public void updateMaintenance(
			@Param("id")  Integer id,
			@Param("assetId") String assetId,
			@Param("assetName") String assetName,
			@Param("date") String date,
			@Param("maintenancer") String maintenancer,
			@Param("content") String content,
			@Param("other") String other
			);

//	public void deleteByRecordId(Integer recordId);
	
	
//	
//	@Query(value="update device_using set date/deviceUser/ where data=?1/deviceUser=?")
//	public modifyDeviceUsing(@Param("date") String date/deviceUser);
}


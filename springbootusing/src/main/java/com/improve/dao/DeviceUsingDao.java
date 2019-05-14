package com.improve.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.improve.entity.DeviceUsing;

public interface DeviceUsingDao extends JpaRepository<DeviceUsing, Integer>{
	public List<DeviceUsing> findByDate(String date);
	public void deleteById(Integer id);
	public void deleteByAssetId(String assetId);
	public List<DeviceUsing> findById(Integer id);
	public List<DeviceUsing> findByAssetName(String assetName);
	
	public DeviceUsing findByAssetId(String assetId);
	
	
	@Modifying(clearAutomatically=true)
	@Query(value="update deviceUsing "
			+ "set date=:date,"
			+ "deviceUser=:deviceUser,"
			+"timeLong=:timeLong,"
			+ "assetId=:assetId,"
			+ "teacher=:teacher,"
			+ "time=:time,"
			+ "assetName=:assetName" 
			+" where id=:id",nativeQuery = true)
	public void updateUsing(
			@Param("id") Integer id,
			@Param("date") String date,
			@Param("deviceUser") String deviceUser,
			@Param("timeLong") 	Integer timeLong,
			@Param("assetId") String assetId,
			@Param("teacher") String teacher,
			@Param("time") String time,
			@Param("assetName") String assetName
			);

	
	@Query("select assetId,assetName,count(*) from deviceUsing group by assetId")
	public List<Object> usingCountByAssetId();
//	
//	@Query(value="update device_using set date/deviceUser/ where data=?1/deviceUser=?")
//	public modifyDeviceUsing(@Param("date") String date/deviceUser);
}

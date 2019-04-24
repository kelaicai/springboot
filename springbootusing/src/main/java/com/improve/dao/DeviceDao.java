package com.improve.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.improve.entity.Device;


public interface DeviceDao extends JpaRepository<Device, Integer> {
	public Device findByAssetId(String assetId);
	public List<Device> findByAssetName(String assetName);
//	public void modifyAssetById(String assertId);
//	public void DeleteAssetById(String assetId);
	
//	@Query(value="insert device_using(date,device_user,timeLong) values(?1,?2,?3)",nativeQuery=true)
//	public void saveDeviceUsing(@Param("Id") int id,
//								@Param("date") String date,
//								@Param("deviceUser") String deviceUser,
//								@Param("timeLong") String timeLong);
//	
//	@Query(value="select * from device_using where date=?1",nativeQuery=true)
//	public List<Device> findDeviceUsingByDate(@Param("date") String date);

}

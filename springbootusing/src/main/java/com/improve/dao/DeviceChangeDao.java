package com.improve.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.improve.entity.DeviceChange;


public interface DeviceChangeDao extends JpaRepository<DeviceChange, Integer> {
	public List<DeviceChange> findByAssetId(String assetId);
	public List<DeviceChange> findByAssetName(String assetName);
	public List<DeviceChange> findByProposer(String proposer);
	public List<DeviceChange> findByDate(String date);
		
	@Modifying
	@Query(value="update deviceChange set "
			+ "assetId=:assetId,"
			+ "assetName=:assetName,"
			+ "reason=:reason,"
			+ "date=:date,"
			+ "proposer=:proposer,"
			+ "oldPlace=:oldPlace,"
			+ "newPlace=:newPlace"
			+ " where id=:id",nativeQuery = true)
	public void updateChange(
			@Param("id") Integer id,
			@Param("assetId") String assetId,
			@Param("assetName") String assetName,
			@Param("reason") String reason,
			@Param("date") String date,
			@Param("proposer") String proposer,
			@Param("oldPlace") String oldPlace,
			@Param("newPlace") String newPlace
			);
	

	
//	public void modifyAssetById(String assertId);
//	public void deleteAssetById(String assetId);
	
//	@Query(value="insert device_using(date,device_user,timeLong) values(?1,?2,?3)",nativeQuery=true)
//	public void saveDeviceUsing(@Param("Id") int id,
//								@Param("date") String date,
//								@Param("deviceUser") String deviceUser,
//								@Param("timeLong") String timeLong);
//	
//	@Query(value="select * from device_using where date=?1",nativeQuery=true)
//	public List<Device> findDeviceUsingByDate(@Param("date") String date);

}
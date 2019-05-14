package com.improve.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.improve.entity.Device;




public interface DeviceStoreDao extends JpaRepository<Device, Integer> {
	public List<Device> findByAssetId(String assetId);
	public List<Device> findByAssetName(String assetName);
	
	@Modifying
	@Query(value="udpate deviceStore set "
			+ "assetId=:assetId,"
			+ "count=:count "
			+ "where id=:id",nativeQuery = true)
	public void udpateStore(@Param("id") Integer id,
			@Param("assetId") String assetId,
			@Param("count") Integer count);
	public Device findByAssetIdAndIsUsedIsNull(String assetId);
//	@Query("select * from deviceEntity where assetId=:assetId and isUsed='true' and isDiscard!=NULL")
//	public Device getByAssetId(@Param("assetId") String assetId);
	
	public List<Device> findByIsUsedIsNull();
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

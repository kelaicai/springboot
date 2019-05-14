package com.improve.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.improve.entity.DeviceDiscard;



public interface DeviceDiscardDao extends JpaRepository<DeviceDiscard, Integer>{
	public List<DeviceDiscard> findByDate(String date);
	public List<DeviceDiscard> findByAssetName(String assetName);
	public List<DeviceDiscard> findByAssetId(String assetId);
	
	@Modifying(clearAutomatically=true)
	@Query(value="update deviceDiscard set "
			+ "assetId=:assetId,"
			+ "assetName=:assetName,"
			+ "reason=:reason,"
			+ "date=:date,"
			+ "petitioner=:petitioner"
			+ " where id=:id",nativeQuery = true)
	public void updateDiscard(
			@Param("id") Integer id,
			@Param("assetId") String assetId,
			@Param("assetName") String assetName,
			@Param("reason") String reason,
			@Param("date") String date,
			@Param("petitioner") String petitioner);
	
//	public void deleteById(Integer id);
//	
//	@Query(value="update device_discard set reason=?2 where recordId=1?",nativeQuery=true)
//	public void moidfyByReson(Integer recordId,String reason);
//	
//	@Query(value="update device_using set date/deviceUser/ where data=?1/deviceUser=?")
//	public modifyDeviceUsing(@Param("date") String date/deviceUser);
}
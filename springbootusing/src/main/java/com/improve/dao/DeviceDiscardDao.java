package com.improve.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.improve.entity.DeviceDiscard;



public interface DeviceDiscardDao extends JpaRepository<DeviceDiscard, Integer>{
	public List<DeviceDiscard> findByDate(String date);
	public List<DeviceDiscard> findByAssetName(String assetName);
	public DeviceDiscard findByAssetId(String assetId);
//	public void deleteById(Integer id);
//	
//	@Query(value="update device_discard set reason=?2 where recordId=1?",nativeQuery=true)
//	public void moidfyByReson(Integer recordId,String reason);
//	
//	@Query(value="update device_using set date/deviceUser/ where data=?1/deviceUser=?")
//	public modifyDeviceUsing(@Param("date") String date/deviceUser);
}
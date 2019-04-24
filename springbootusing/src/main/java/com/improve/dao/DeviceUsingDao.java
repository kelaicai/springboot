package com.improve.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.improve.entity.DeviceUsing;

public interface DeviceUsingDao extends JpaRepository<DeviceUsing, Integer>{
	public List<DeviceUsing> findByDate(String date);
	public void deleteById(Integer id);
	public void deleteByAssetId(String assetId);
	public DeviceUsing findById(Integer id);
	public List<DeviceUsing> findByAssetName(String assetName);
//	
//	@Query(value="update device_using set date/deviceUser/ where data=?1/deviceUser=?")
//	public modifyDeviceUsing(@Param("date") String date/deviceUser);
}

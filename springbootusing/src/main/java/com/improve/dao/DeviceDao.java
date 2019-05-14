package com.improve.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.improve.entity.Device;


public interface DeviceDao extends JpaRepository<Device, Integer> {
	public List<Device> findByAssetId(String assetId);
	public List<Device> findByAssetName(String assetName);
	

	public List<Device> findByUser(String user);
	
	@Modifying
	@Query(value="update deviceEntity set isUsed='true' where assetId=:assetId")
	public void updateUsed(@Param("assetId") String assetId);
	
	@Modifying
	@Query(value="update deviceEntity set isDiscard='true' where assetId=:assetId")
	public void updateDiscard(@Param("assetId") String assetId);
	
	@Modifying
	@Query(value="update deviceEntity set isUsed='unused' where assetId=:assetId")
	public void cancelUsed(@Param("assetId") String assetId);
	
	
	@Modifying(clearAutomatically=true)
	@Query(value="update deviceEntity set "
			+ "assetId=:assetId,"
			+ "assetName=:assetName,"
			+ "gbBigClass=:gbBigClass,gbClass=:gbClass,"
			+ "assetClass=:assetClass,"
			+ "assetBigClass=:assetBigClass,"
			+ "area=:area,count=:count,"
			+ "getMethod=:getMethod,"
			+ "typeSpecification=:typeSpecification,"
			+ "user=:user,"
			+ "usingDepartment=:usingDepartment,"
			+ "fianceType=:fianceType,"
			+ "valueType=:valueType,"
			+ "getDate=:getDate,"
			+ "eduUsing=:eduUsing,"
			+ "isUsed=:isUsed,"
			+ "isDiscard=:isDiscard "
			+ "where id=:id",nativeQuery = true)
	public void updateRecord(
			@Param("id") Integer id,
			@Param("assetId") String assetId,
			@Param("assetName") String assetName,
			@Param("gbBigClass") String gbBigClass,
			@Param("gbClass") String gbClass,
			@Param("assetBigClass") String assetBigClass,
			@Param("assetClass") String assetClass,
			@Param("count") int count,
			@Param("area") String area,
			@Param("getMethod") String getMethod,
			@Param("getDate") String getDate,
			@Param("eduUsing") String eduUsing,
			@Param("usingDepartment") String usingDepartment,
			@Param("fianceType") String fianceType,
			@Param("valueType") String valueType,
			@Param("typeSpecification") String typeSpecification,
			@Param("user") String user,
			@Param("isUsed") String isUsed,
			@Param("isDiscard") String isDiscard
			);

}

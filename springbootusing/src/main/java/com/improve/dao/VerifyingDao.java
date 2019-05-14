package com.improve.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.improve.entity.DeviceDiscard;
import com.improve.entity.Verify;

public interface VerifyingDao extends JpaRepository<Verify, Integer>{
	public List<Verify> findByDate(String date);
	public List<Verify> findByAssetName(String assetName);
	public List<Verify> findByAssetId(String assetId);
	public List<Verify> findByIsVerifiedIsNull();
	
	
	//更新结果审核是否通过
	@Modifying
	@Query("update verify set isVerified=:choice where assetId=:assetId")
	public void updateVerify(@Param("assetId") String assetId,@Param("choice") String choice);
	
	//设置审核过程
	@Modifying
	@Query("update verify set prograss=:prograss where assetId=:assetId")
	public void updatePrograss(@Param("assetId") String assetId,@Param("prograss") String prograss);
}
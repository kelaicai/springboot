package com.improve.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.improve.dao.VerifyingDao;
import com.improve.entity.DeviceDiscard;
import com.improve.entity.Verify;

@Service
public class VerifyingService {

	@Resource
	private VerifyingDao verifyingDao;
	
	public List<Verify>findAll()
	{
		return verifyingDao.findAll();  
	}
	
	
	@Transactional
	public void  verify(String assetId,String choice)
	{
		verifyingDao.updateVerify(assetId,choice);
	}
	
	@Transactional
	public void updatePrograss(String assetId,String prograss)
	{
		verifyingDao.updatePrograss(assetId, prograss);
	}
	
	
	@Transactional
	public void save(Verify verify)
	{
		verifyingDao.save(verify);
	}
	
	public List<Verify> findByAssetId(String assetId)
	{
		return verifyingDao.findByAssetId(assetId);
	}
	

}

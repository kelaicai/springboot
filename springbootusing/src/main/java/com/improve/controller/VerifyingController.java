package com.improve.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.improve.entity.DeviceDiscard;
import com.improve.entity.Verify;
import com.improve.service.DeviceDiscardService;
import com.improve.service.DeviceService;
import com.improve.service.VerifyingService;

@RestController
@RequestMapping("/verify/*")
public class VerifyingController {

	@Autowired
	private VerifyingService verifyService;
	
	@Autowired 
	private DeviceDiscardService deviceDiscardService;
	
	@Autowired
	private DeviceService deviceService;
	
	@GetMapping("/findAllVerify")
	public List<Verify> findAllVerify()
	{
		return verifyService.findAll();
	}
	
	//审核通过 设置verified为true
	
	@GetMapping("/updateVerify")
	public Map<String,Object> updateVerify(@RequestParam("assetId") String assetId,
			@RequestParam("choice") String choice)
	{

		Map<String,Object> result=new HashMap<String,Object>();
		try
		{
			if(choice.equals("pass"))  //如果没有审核通过那么返回一个空的结果集
			{
				//先更新审核表,
				verifyService.verify(assetId,"true");  //审核通过
				verifyService.updatePrograss(assetId, "finish");  //过程结束
			
				//接着将审核通过的设备记录到数据库中
				List<Verify> verify=verifyService.findByAssetId(assetId);
				System.out.println(verify);
				for(Verify item :verify)
				{
					DeviceDiscard deviceDiscard=new DeviceDiscard();
					deviceDiscard.setAssetId(item.getAssetId());
					deviceDiscard.setAssetName(item.getAssetName());
					deviceDiscard.setDate(item.getDate());
					deviceDiscard.setPetitioner(item.getPetitioner());
					deviceDiscard.setReason(item.getReason());
					deviceDiscardService.deviceDiscardApply(deviceDiscard);
					//审核最后需要将设备表中的报废项目设置为true,Prograss设置为finish
					deviceService.modifyUsed(assetId);
					deviceService.modifyDiscard(assetId);
				}
			
				result.put("status","success");
				System.out.println("### verify update success###");
			}
				else  //审核失败,将verified设置为false 同时设置prograss为finished
				{
					verifyService.verify(assetId,"false");
					verifyService.updatePrograss(assetId, "finish");  //过程结束
				}
		}
		catch(Exception e)
		{
			result.put("status",e);
			e.printStackTrace();
			System.out.println("### verify update faild###");
		}
		
		
		return result;	
	}
	
	@GetMapping("/verifyApply")
	public Map<String,Object> verifyApply(@RequestParam("assetId") String assetId,
			@RequestParam("assetName") String assetName,
			@RequestParam("petitioner") String petitioner,
			@RequestParam("reason") String reason,
			@RequestParam("date") String date
			)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
		Verify verify=new Verify();
		verify.setAssetName(assetName);
		verify.setAssetId(assetId);
		verify.setPetitioner(petitioner);
		verify.setReason(reason);
		verify.setDate(date);
		verify.setPrograss("process");
		verifyService.save(verify);
		result.put("status","success");
		}
		catch(Exception e)
		{
			System.out.println("###deviceDiscard Error deviceApply ###");
			result.put("status","error");
			e.printStackTrace();
		}
		return result;
	}
}

package com.improve.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.improve.entity.DeviceDiscard;
import com.improve.service.DeviceDiscardService;

@RestController
@RequestMapping("/deviceDiscard/*")
public class DeviceDiscardController {

	@Autowired
	private DeviceDiscardService deviceDiscardService;
	
	//提交设备报废信息
	@RequestMapping(value="/discardApply",method=RequestMethod.GET)
	public Map<String,Object> discardApply(
			@RequestParam("assetId") String assetId,
			@RequestParam("assetName") String assetName,
			@RequestParam("petitioner") String petitioner,
			@RequestParam("reason") String reason,
			@RequestParam("date") String date
			)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
		DeviceDiscard deviceDiscard=new DeviceDiscard();
		deviceDiscard.setAssetName(assetId);
		deviceDiscard.setAssetId(assetName);
		deviceDiscard.setPetitioner(petitioner);
		deviceDiscard.setReason(reason);
		deviceDiscard.setDate(date);
		deviceDiscardService.deviceDiscardApply(deviceDiscard);
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
	
	//查询所有的报废信息
	@RequestMapping(value="/discardAll",method=RequestMethod.GET)
	public List<DeviceDiscard> discardAll()
	{
			return deviceDiscardService.deviceDiscardFindAll();
	}
	
	//通过设备名字查询报废设备
	@RequestMapping(value="/discardByAssetName",method=RequestMethod.GET)
	public List<DeviceDiscard> findDiscardByAssetName(@RequestParam("assetName") String assetName)
	{
		return deviceDiscardService.deviceDiscardFindByAssetName(assetName);
	}
	
	
	//通过设备ID查询报废设备
	@RequestMapping(value="/discardByAssetId",method=RequestMethod.GET)
	public DeviceDiscard findDiscardByAssetId(@RequestParam("assetId") String assetId)
	{
		return deviceDiscardService.deviceDiscardFindByAssetId(assetId);
	}
	
	//通过id删除报废记录
	@RequestMapping(value="/deleteDiscardById",method=RequestMethod.GET)
	public Map<String,Object> deleteDiscardById(@RequestParam("id") Integer id)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			deviceDiscardService.deleteById(id);
			System.out.println("###  deleteDiscardById  ###"+id);
			result.put("status","success");
		}
		catch(Exception e)
		{
			result.put("status","error");
			System.out.println("### deleteDiscardById Error ###"+id);
			e.printStackTrace();
		}
		return result;
	}
	
	
	
}

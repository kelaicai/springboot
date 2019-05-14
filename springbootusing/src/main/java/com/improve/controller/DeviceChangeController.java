package com.improve.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.improve.entity.DeviceChange;
import com.improve.service.DeviceChangeService;

@RestController
@RequestMapping("/deviceChange/*")
public class DeviceChangeController {
	
	@Autowired
	private DeviceChangeService deviceChangeService;
	
	
	//查询所有的设备变更信息
	@RequestMapping(value="/findAllDeviceChange",method=RequestMethod.GET)
	public List<DeviceChange> findAllDeviceChange()
	{
		return deviceChangeService.findAllChange();
	}
	
	//查询设备变更信息(by assetName)
	@RequestMapping(value="/findByAssetName",method=RequestMethod.GET)
	public List<DeviceChange> findByAssetName(String assetName)
	{
		return deviceChangeService.findByAssetName(assetName);
	}
	
	//查询设备变更信息(by Id)
	@RequestMapping(value="findByAssetId",method=RequestMethod.GET)
	public List<DeviceChange> findByAssetId(String assetId)
	{
		return deviceChangeService.findByAssetId(assetId);
	}
	
	
	//提交变更信息
	@RequestMapping(value="/deviceChangeApply",method=RequestMethod.GET)
	public Map<String,Object> deviceChangeApply(
			@RequestParam("assetId") String assetId,
			@RequestParam("assetName") String assetName,
			@RequestParam("reason") String reason,
			@RequestParam("date") String date,
			@RequestParam("proposer") String proposer,
			@RequestParam("oldPlace") String oldPlace,
			@RequestParam("newPlace") String newPlace
			)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
		DeviceChange deviceChange=new DeviceChange();
		deviceChange.setAssetId(assetId);
		deviceChange.setAssetName(assetName);
		deviceChange.setDate(date);
		deviceChange.setProposer(proposer);
		deviceChange.setReason(reason);
		deviceChange.setOldPlace(oldPlace);
		deviceChange.setNewPlace(newPlace);
		deviceChangeService.applyDeviceChange(deviceChange);
		result.put("status","success");
		System.out.println("###deviceChangeApply success###"+assetId+assetName);
		}catch(Exception e)
		{
			System.out.println("###deviceChangeApply error###"+assetId+assetName);
			e.printStackTrace();
			result.put("status",e);
		}
		return result;
	}
	
	@RequestMapping(value="/deleteById",method=RequestMethod.GET)
	public Map<String,Object> deleteById(@RequestParam("id") Integer id)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try
		{
			deviceChangeService.deleteById(id);
			result.put("status","success");
			System.out.println("###deleteById success###"+id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("###deleteById### error"+id);
			result.put("status", e);
		}
		return result;
	}
	
	@GetMapping("/updateChange")
	public Map<String,Object> updateRecord(
			@RequestParam("assetId") String assetId,
			@RequestParam("assetName") String assetName,
			@RequestParam("reason") String reason,
			@RequestParam("date") String date,
			@RequestParam("proposer") String proposer,
			@RequestParam("oldPlace") String oldPlace,
			@RequestParam("newPlace") String newPlace)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try
		{
			deviceChangeService.updateChange(assetId, assetName, reason, date, proposer, oldPlace, newPlace);;
			result.put("status","success");
			System.out.println("###updateChange success###"+assetId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("###updateChange ### error"+assetId);
			result.put("status", e);
		}
		return result;
	}
	
	@GetMapping("/findChangeById")
	public DeviceChange findUsingById(@RequestParam("id") Integer id)
	{
		DeviceChange deviceChange=null;
		try {
		deviceChange=deviceChangeService.findById(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return deviceChange;
	}
}

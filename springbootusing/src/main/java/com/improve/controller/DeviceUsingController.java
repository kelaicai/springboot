package com.improve.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.improve.entity.DeviceUsing;
import com.improve.service.DeviceUsingService;

@RestController
@RequestMapping("/deviceUsing/*")
public class DeviceUsingController {
	
	@Autowired
	private DeviceUsingService deviceUsingService;
	
	
	//查询所有的设备使用记录
	@RequestMapping(value="/findAllUsing",method=RequestMethod.GET)
	public List<DeviceUsing> findAllUsing()
	{
		return deviceUsingService.findAllUsing();
	}
	
	
	//查询设备使用记录(by assetName)
	@RequestMapping(value="/findByAssetName",method=RequestMethod.GET)
	public List<DeviceUsing> findByAssetName(@RequestParam("assetName") String assetName)
	{
		return deviceUsingService.findByAssetName(assetName);
	}
	
	//通过日期查询使用记录
	@RequestMapping(value="/findByDate",method=RequestMethod.GET)
	public List<DeviceUsing> findByDate(@RequestParam("date") String date)
	{
		return deviceUsingService.findUsingByDate(date);
	}
	
	
	@RequestMapping(value="deleteUsingById",method=RequestMethod.GET)
	public Map<String,Object> deleteUsingById(@RequestParam("id") Integer id)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			deviceUsingService.deleteUsingById(id);
			result.put("status", "success");
			System.out.println("###deleteUsingById success###  "+id);
		}catch(Exception e)
		{
			result.put("status", "error");
			System.out.println("###deleteUsingById error###  "+id);
		}
	
		return result;
	}
	
	//向上提交使用记录
	@RequestMapping(value="/usingApply",method=RequestMethod.GET)
	public Map<String,Object> usingApply(
			@RequestParam("date") String date,
			@RequestParam("deviceUser") String deviceUser,
			@RequestParam("timeLong") Integer timeLong,
			@RequestParam("assetId") String assetId,
			@RequestParam("teacher") String teacher,
			@RequestParam("time") String time
			)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			DeviceUsing deviceUsing=new DeviceUsing();
			deviceUsing.setAssetId(assetId);
			deviceUsing.setDate(date);
			deviceUsing.setDeviceUser(deviceUser);
			deviceUsing.setTimeLong(timeLong);
			deviceUsing.setTeacher(teacher);
			deviceUsing.setTime(time);
			deviceUsingService.save(deviceUsing);
			result.put("status", "success");
			System.out.println("###deviceUsingApply success####");
		}catch(Exception e)
		{
			System.out.println("###deviceUsing apply failed###");
			result.put("status", e);
		}
		return result;
	}
	
		
}

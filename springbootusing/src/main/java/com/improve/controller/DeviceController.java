package com.improve.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.improve.entity.Device;
import com.improve.service.DeviceService;

@RestController
@RequestMapping("/device/*")
public class DeviceController {
	
	@Autowired
	public DeviceService deviceService;
	
	
	
	//添加设备信息
	@RequestMapping(value="/deviceApply",method=RequestMethod.GET)
	public Map<String,Object> deviceApply(
			@RequestParam("assetId") String assetId,
			@RequestParam("gb_class") String gb_class,
			@RequestParam("gb_big_class") String gb_big_class,
			@RequestParam("asset_class") String asset_class,
			@RequestParam("asset_big_class") String asset_big_class,
			@RequestParam("asset_name") String asset_name,
			@RequestParam("count") int count,
			@RequestParam("area") String area,
			@RequestParam("value") String value,
			@RequestParam("edu_using") String edu_using,
			@RequestParam("value_type") String value_type,
			@RequestParam("finace_type") String finace_type,
			@RequestParam("get_method") String get_method,
			@RequestParam("get_Date") String get_date,
			@RequestParam("using_department") String using_department,
			@RequestParam("type_specification") String type_specification,
			@RequestParam("user") String user
			)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try
		{
			Device device=new Device();
			device.setAssetsId(assetId);
			device.setGbClass(gb_class);
			device.setGbBigClass(gb_big_class);
			device.setAssetsClass(asset_class);
			device.setAssetsBigClass(asset_big_class);
			device.setAssetsName(asset_name);
			device.setCount(count);
			device.setArea(area);
			device.setEduUsing(edu_using);
			device.setValueType(value_type);
			device.setFianceType(finace_type);
			device.setGetMethod(get_method);
			device.setGetDate(get_date);
			device.setUsingDepartment(using_department);
			device.setTypeSpecification(type_specification);
			device.setUser(user);
			deviceService.save(device);
			System.out.println("device apply");
			result.put("status", "success");
		}
		catch(Exception  e)
		{
			System.out.println("device apply error"+e);
			result.put("status",e);
			e.printStackTrace();
		}
		return result;
	}
	
	//根据设备名字查询
	@RequestMapping(value="/deviceSearchByName",method=RequestMethod.GET)
	public List<Device> deviceSearchByName(@RequestParam("assetName") String assetName)
	{
		return deviceService.getDeviceByName(assetName);
	}
	
	//根据设备ID查询
	@RequestMapping(value="/deviceSearchByAssetId",method=RequestMethod.GET)
	public Device deviceSearchByAssetId(@RequestParam("assetId") String assetId)
	{
		return deviceService.getDeviceByAssetId(assetId);
	}
	
	//获取所有设备
	@RequestMapping(value="/getDeviceAll",method=RequestMethod.GET)
	public List<Device> getAllDevice()
	{
		return deviceService.getDeviceAll();
	}
	
	//删除设备
	@RequestMapping(value="/deleteDeviceByAssetId",method=RequestMethod.GET)
	public Map<String,Object> deleteDeviceByAssetId(@RequestParam("assetId") String assetId)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try
		{
			deviceService.deleteAssetByAssetId(assetId);
			System.out.println("deleteDeviceByAssetId");
			result.put("status","success");
		}
		catch(Exception e)
		{
			System.out.println("deleteDeviceByAssetId Error"+e);
			e.printStackTrace();
			result.put("status","error");
		}
		return result;
	}
	
	//通过设备表中的记录ID删除记录
	@RequestMapping(value="/deleteDeviceById",method=RequestMethod.GET)
	public Map<String,Object> deleteDeviceById(@RequestParam("id") Integer id)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try
		{
			deviceService.deleteAssetById(id);
			System.out.println("deleteDeviceByAssetId");
			result.put("status","success");
		}
		catch(Exception e)
		{
			System.out.println("deleteDeviceByAssetId Error"+e);
			e.printStackTrace();
			result.put("status","error");
		}
		return result;
	}
	
	//设备调拨信息
	@RequestMapping(value="/deviceAllocation",method=RequestMethod.GET)
	public List<Device> deviceAllocation()
	{
		return null;
		
	}
	

}

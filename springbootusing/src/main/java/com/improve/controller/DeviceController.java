package com.improve.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.improve.entity.Device;
import com.improve.entity.User;
import com.improve.service.DeviceService;
import com.improve.service.UserService;
import com.mysql.cj.Session;


@SessionAttributes(value="user")
@RestController
@RequestMapping("/device/*")
public class DeviceController {
	
	@Autowired
	public DeviceService deviceService;
	
	@Autowired
	public UserService userService;
	
	
	
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
			@RequestParam("fiance_type") String finace_type,
			@RequestParam("get_method") String get_method,
			@RequestParam("get_Date") String get_date,
			@RequestParam("using_department") String using_department,
			@RequestParam("type_specification") String type_specification,
			@RequestParam("user") String user,
			@RequestParam("isUsed") String isUsed,
			@RequestParam("isDiscard") String isDiscard
			)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try
		{
			Device device=new Device();
			System.out.println(asset_big_class);
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
			device.setIsUsed(isUsed);
			device.setIsDiscard(isDiscard);
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
	public List<Device> deviceSearchByAssetId(@RequestParam("assetId") String assetId)
	{
		return deviceService.getDeviceByAssetId(assetId);
	}
	
	@RequestMapping(value="/deviceSearchById",method=RequestMethod.GET)
	public Device deviceSearchByAssetId(@RequestParam("id") Integer id)
	{
		return deviceService.getDeviceById(id);
	}
	
	//获取所有设备
	@RequestMapping(value="/getDeviceAll",method=RequestMethod.GET)
	public List<Device> getAllDevice(HttpServletRequest request, HttpServletResponse response)
	{
//		User user=(User)request.getSession().getAttribute("user");
//		System.out.println(user);
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
	
	@GetMapping("/updateDevice")
	public  Map<String,Object> updateDevice(
			@RequestParam("assetId") String assetId,
			@RequestParam("gb_class") String gb_class,
			@RequestParam("gb_big_class") String gb_big_class,
			@RequestParam("asset_class") String asset_class,
			@RequestParam("asset_big_class") String asset_big_class,
			@RequestParam("asset_name") String asset_name,
			@RequestParam("count") Integer count,
			@RequestParam("area") String area,
			@RequestParam("value") String value,
			@RequestParam("edu_using") String edu_using,
			@RequestParam("value_type") String value_type,
			@RequestParam("fiance_type") String fiance_type,
			@RequestParam("get_method") String get_method,
			@RequestParam("get_Date") String get_date,
			@RequestParam("using_department") String using_department,
			@RequestParam("type_specification") String type_specification,
			@RequestParam("user") String user,
			@RequestParam("isUsed") String isUsed,
			@RequestParam("isDiscard") String isDiscard
			)
	{
		Map<String,Object> result=new HashMap<String,Object>();
		try
		{
			deviceService.upateRecord(assetId, asset_name, gb_big_class,
					gb_class, asset_big_class, asset_class, count, area, 
					get_method, get_date, edu_using, using_department, 
					fiance_type, value_type, type_specification,user,isUsed,isDiscard);
			System.out.println("updateRecord");
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
	@RequestMapping(value="/findDeviceByUser",method=RequestMethod.GET)
	public List<Device> findDeviceByUser(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session =request.getSession();
		List<Device> result=new ArrayList<Device>();
		String workId=(String)session.getAttribute("workId");
		System.out.println(workId+" get attr");
		User user=userService.findUserByWorkId(workId);
		if(user!=null)
		{
			result= deviceService.findDeviceByUserName(user.getUserName());
		}else
		{
			result.add(null);
		}
		return result;
	}
	

}

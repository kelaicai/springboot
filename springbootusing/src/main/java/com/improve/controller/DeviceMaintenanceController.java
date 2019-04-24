package com.improve.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.improve.entity.DeviceMaintenance;
import com.improve.service.MaintenanceService;

@RestController
@RequestMapping("/deviceMaintenance/*")
public class DeviceMaintenanceController {

		@Autowired
		private MaintenanceService maintenanceService;
		
		@RequestMapping(value="/maintenanceApply",method=RequestMethod.GET)
		public Map<String,Object> maintenanceApply(
				@RequestParam("assetId") String assetId,
				@RequestParam("assetName") String assetName,
				@RequestParam("date") String date,
				@RequestParam("maintenancer") String maintenancer,
				@RequestParam("content") String content,
				@RequestParam("other") String other
				
				)
		{
			Map<String,Object> result=new HashMap<String,Object>();
			try {
			DeviceMaintenance deviceMaintenance=new DeviceMaintenance();
			deviceMaintenance.setAssetId(assetId);
			deviceMaintenance.setAssetName(assetName);
			deviceMaintenance.setMaintenancer(maintenancer);
			deviceMaintenance.setContent(content);
			deviceMaintenance.setDate(date);
			deviceMaintenance.setOther(other);
		    maintenanceService.save(deviceMaintenance);
		    result.put("status","success");
		    System.out.println("###deviceMiantenance Apply success###");
		    
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("###deviceMaintenance Apply error###");
				result.put("status","error");
			}
		    return result;
		}
		
		@RequestMapping(value="/deleteMaintenanceById",method=RequestMethod.GET)
		public Map<String,Object> deleteMaintenanceById(@RequestParam("id") Integer id)
		{
			Map<String,Object> result=new HashMap<String,Object>();
			try
			{
				maintenanceService.deleteById(id);
				result.put("status", "success");
			}
			catch(Exception e)
			{
				result.put("status", e);
			}
			return result;
			
		}
		
		@RequestMapping(value="/findMaintenanceById",method=RequestMethod.GET)
		public DeviceMaintenance findMaintenanceById(@RequestParam("id") Integer id)
		{
			return null;
		}
		
		@RequestMapping(value="/getAllMaintenance",method=RequestMethod.GET)
		public List<DeviceMaintenance> getAllMaintenance()
		{
			List<DeviceMaintenance> result=new ArrayList<DeviceMaintenance>();
			try
			{
				result=maintenanceService.findByMaintenanceAll();
				System.out.println("###getAllMaintanance success###");
			}
			catch(Exception e)
			{
				System.out.println("###getAllMaintenance failed####");
			}
			return result;
		}
		
		
		
}
